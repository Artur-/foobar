/**
 *
 */
package org.vaadin.netbeans.maven.project;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

import org.netbeans.api.project.Project;
import org.netbeans.spi.project.ui.support.ProjectCustomizer;
import org.netbeans.spi.project.ui.support.ProjectCustomizer.Category;
import org.openide.util.Lookup;
import org.openide.util.NbBundle;
import org.vaadin.netbeans.VaadinSupport;
import org.vaadin.netbeans.maven.ui.wizard.VaadinProjectWizardIterator;

/**
 * @author denis
 */
@ProjectCustomizer.CompositeCategoryProvider.Registration(
        projectType = "org-netbeans-modules-maven", position = 450)
public class VaadinCustomizer implements
        ProjectCustomizer.CompositeCategoryProvider
{

    static final String VAADIN_GROUP_ID = "com.vaadin"; // NOI18N

    static final String VAADIN_PLUGIN = "vaadin-maven-plugin"; // NOI18N

    static final String JETTY_GROUP_ID = "org.mortbay.jetty"; // NOI18N

    static final String JETTY_PLUGIN = "jetty-maven-plugin"; // NOI18N

    static final String VAADIN_CATEGORY = "Vaadin"; // NOI18N

    private static final String GWT_COMPILER_CATEGORY = "GwtCompiler";// NOI18N

    private static final String DEV_MODE_CATEGORY = "GwtHosted";// NOI18N

    private static final String JETTY_CATEGORY = "Jetty";// NOI18N

    @NbBundle.Messages({ "vaadinCategoryName=Vaadin",
            "gwtCategoryName=Compiler and GWT", "devModeCategoryName=Dev Mode",
            "jettyCategoryName=Jetty" })
    @Override
    public ProjectCustomizer.Category createCategory( Lookup context ) {
        Project project = context.lookup(Project.class);
        VaadinSupport support = project.getLookup().lookup(VaadinSupport.class);
        if (support == null || !support.isEnabled() || !support.isWeb()) {
            return null;
        }
        BufferedImage image = null;
        try {
            image = ImageIO
                    .read(VaadinCustomizer.class
                            .getResource('/' + VaadinProjectWizardIterator.PROJECT_ICON));
        }
        catch (IOException ignore) {
        }
        Category gwt = Category.create(GWT_COMPILER_CATEGORY,
                Bundle.gwtCategoryName(), null);
        Category devMode = Category.create(DEV_MODE_CATEGORY,
                Bundle.devModeCategoryName(), null);
        Category jetty = Category.create(JETTY_CATEGORY,
                Bundle.jettyCategoryName(), null);

        return ProjectCustomizer.Category.create(VAADIN_CATEGORY,
                Bundle.vaadinCategoryName(), image, gwt, devMode, jetty);
    }

    @Override
    public JComponent createComponent( ProjectCustomizer.Category category,
            Lookup context )
    {
        if (category.getName().equals(VAADIN_CATEGORY)) {
            return new VaadinOptionsPanel(context);
        }
        else if (category.getName().equals(GWT_COMPILER_CATEGORY)) {
            return new GwtCompilerOptionsPanel(context);
        }
        else if (category.getName().equals(DEV_MODE_CATEGORY)) {
            return new DevModeOptionsPanel(context);
        }
        else if (category.getName().equals(JETTY_CATEGORY)) {
            return new JettyOptionsPanel(context);
        }
        else {
            throw new IllegalArgumentException("Unexpected category "
                    + category.getName());
        }
    }

}
