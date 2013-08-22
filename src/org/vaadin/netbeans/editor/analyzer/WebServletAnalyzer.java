/**
 *
 */
package org.vaadin.netbeans.editor.analyzer;

import java.io.IOException;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.TypeElement;

import org.netbeans.api.java.source.CompilationInfo;
import org.netbeans.api.project.FileOwnerQuery;
import org.netbeans.api.project.Project;
import org.netbeans.spi.editor.hints.ErrorDescription;
import org.netbeans.spi.editor.hints.Severity;
import org.openide.filesystems.FileObject;
import org.openide.util.NbBundle;
import org.vaadin.netbeans.VaadinSupport;
import org.vaadin.netbeans.code.generator.JavaUtils;
import org.vaadin.netbeans.editor.VaadinTaskFactory;
import org.vaadin.netbeans.model.ModelOperation;
import org.vaadin.netbeans.model.VaadinModel;

/**
 * @author denis
 */
public class WebServletAnalyzer implements TypeAnalyzer {

    @Override
    public void analyze( TypeElement type, CompilationInfo info,
            Collection<ErrorDescription> descriptions,
            VaadinTaskFactory factory, AtomicBoolean cancel )
    {
        FileObject fileObject = info.getFileObject();
        Project project = FileOwnerQuery.getOwner(fileObject);
        if (project == null) {
            return;
        }
        VaadinSupport support = project.getLookup().lookup(VaadinSupport.class);
        if (support == null || !support.isEnabled()) {
            return;
        }
        AnnotationMirror servlet = JavaUtils.getAnnotation(type,
                JavaUtils.SERVLET_ANNOTATION);
        if (servlet == null || cancel.get()) {
            return;
        }

        String widgetset = JavaUtils.getWidgetsetWebInit(servlet);
        String ui = JavaUtils.getWebInitParamValue(servlet, JavaUtils.UI);

        TypeElement vaadinServlet = info.getElements().getTypeElement(
                JavaUtils.VAADIN_SERVLET);
        if (vaadinServlet == null || cancel.get()) {
            return;
        }

        final FileObject[] gwtXml = new FileObject[1];
        try {
            support.runModelOperation(new ModelOperation() {

                @Override
                public void run( VaadinModel model ) {
                    gwtXml[0] = model.getGwtXml();
                }
            });
        }
        catch (IOException e) {
            Logger.getLogger(VaadinServletConfigurationAnalyzer.class.getName())
                    .log(Level.INFO, null, e);
        }

        if (cancel.get()) {
            return;
        }

        if (info.getTypes().isSubtype(type.asType(), vaadinServlet.asType())) {
            if (ui == null) {
                noUiVaadinServlet(type, info, descriptions);
            }
            else {
                if (widgetset == null) {
                    noWidgetsetVaadinServlet(type, info, descriptions);
                }
                else {
                    checkWidgetset(widgetset, type, info, descriptions, factory);
                }
            }
        }
        else {
            if (ui != null || widgetset != null) {
                requireVaadinServlet(type, info, descriptions);
            }
        }
    }

    @NbBundle.Messages("badClassHierarchy=Class has Vaadin specific annotation parameter but is not derived from VaadinServlet")
    private void requireVaadinServlet( TypeElement type, CompilationInfo info,
            Collection<ErrorDescription> descriptions )
    {
        descriptions.add(AbstractJavaFix.createExtendServletFix(type, info,
                Bundle.badClassHierarchy(), Severity.WARNING));
    }

    private void checkWidgetset( String widgetset, TypeElement type,
            CompilationInfo info, Collection<ErrorDescription> descriptions,
            VaadinTaskFactory factory )
    {
        // TODO : Check widgetset against gwtXml and provide hints for correction/creation if it differs
    }

    private void noWidgetsetVaadinServlet( TypeElement type,
            CompilationInfo info, Collection<ErrorDescription> descriptions )
    {
        // TODO : hint to set widgetset if gwtXml is available/ create and set if there is no gwtXml

    }

    private void noUiVaadinServlet( TypeElement type, CompilationInfo info,
            Collection<ErrorDescription> descriptions )
    {
        // TODO : add hint to set(+create) UI. No widgetset hint
    }
}
