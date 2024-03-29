/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package org.vaadin.netbeans.ui.wizard;

import org.vaadin.netbeans.ui.wizard.WidgetTypePanel.Template;

/**
 * @author denis
 */
public class WidgetTemplatePanel extends javax.swing.JPanel {

    /**
     * Creates new form WidgetTemplatePanel
     */
    public WidgetTemplatePanel() {
        initComponents();
        myFullFledged.setSelected(true);
    }

    Template getSelectedTemplate() {
        if (myFullFledged.isSelected()) {
            return Template.FULL_FLEDGED;
        }
        else if (myConnector.isSelected()) {
            return Template.CONNECTOR_ONLY;
        }
        else if (myExtension.isSelected()) {
            return Template.EXTENSION;
        }
        return null;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        panel = new javax.swing.JPanel();
        myFullFledged = new javax.swing.JRadioButton();
        myConnector = new javax.swing.JRadioButton();
        myExtension = new javax.swing.JRadioButton();

        panel.setBorder(javax.swing.BorderFactory
                .createTitledBorder(org.openide.util.NbBundle.getMessage(
                        WidgetTemplatePanel.class, "LBL_TemplateTitle"))); // NOI18N

        buttonGroup.add(myFullFledged);
        org.openide.awt.Mnemonics.setLocalizedText(myFullFledged,
                org.openide.util.NbBundle.getMessage(WidgetTemplatePanel.class,
                        "LBL_FullFledged")); // NOI18N

        buttonGroup.add(myConnector);
        org.openide.awt.Mnemonics.setLocalizedText(myConnector,
                org.openide.util.NbBundle.getMessage(WidgetTemplatePanel.class,
                        "LBL_ConnectorOnly")); // NOI18N

        buttonGroup.add(myExtension);
        org.openide.awt.Mnemonics.setLocalizedText(myExtension,
                org.openide.util.NbBundle.getMessage(WidgetTemplatePanel.class,
                        "LBL_Extension")); // NOI18N

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout
                .setHorizontalGroup(panelLayout
                        .createParallelGroup(
                                javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(
                                panelLayout
                                        .createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(
                                                panelLayout
                                                        .createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(
                                                                myFullFledged,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(
                                                                myConnector,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(
                                                                myExtension))
                                        .addContainerGap(89, Short.MAX_VALUE)));
        panelLayout
                .setVerticalGroup(panelLayout
                        .createParallelGroup(
                                javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(
                                panelLayout
                                        .createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(
                                                myFullFledged,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(
                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(
                                                myConnector,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(
                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(myExtension)
                                        .addContainerGap(
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE)));

        myFullFledged.getAccessibleContext().setAccessibleName(
                org.openide.util.NbBundle.getMessage(WidgetTemplatePanel.class,
                        "ACSN_FullFledged")); // NOI18N
        myFullFledged.getAccessibleContext().setAccessibleDescription(
                org.openide.util.NbBundle.getMessage(WidgetTemplatePanel.class,
                        "ACSD_FullFledged")); // NOI18N
        myConnector.getAccessibleContext().setAccessibleName(
                org.openide.util.NbBundle.getMessage(WidgetTemplatePanel.class,
                        "ACSN_ConnectorOnly")); // NOI18N
        myConnector.getAccessibleContext().setAccessibleDescription(
                org.openide.util.NbBundle.getMessage(WidgetTemplatePanel.class,
                        "ACSD_ConnectorOnly")); // NOI18N
        myExtension.getAccessibleContext().setAccessibleName(
                org.openide.util.NbBundle.getMessage(WidgetTemplatePanel.class,
                        "ACSN")); // NOI18N
        myExtension.getAccessibleContext().setAccessibleDescription(
                org.openide.util.NbBundle.getMessage(WidgetTemplatePanel.class,
                        "ACSD_Extension")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(
                javax.swing.GroupLayout.Alignment.LEADING).addComponent(panel,
                javax.swing.GroupLayout.DEFAULT_SIZE,
                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(layout.createParallelGroup(
                javax.swing.GroupLayout.Alignment.LEADING).addComponent(panel,
                javax.swing.GroupLayout.PREFERRED_SIZE,
                javax.swing.GroupLayout.DEFAULT_SIZE,
                javax.swing.GroupLayout.PREFERRED_SIZE));
    }// </editor-fold>//GEN-END:initComponents
     // Variables declaration - do not modify//GEN-BEGIN:variables

    private javax.swing.ButtonGroup buttonGroup;

    private javax.swing.JRadioButton myConnector;

    private javax.swing.JRadioButton myExtension;

    private javax.swing.JRadioButton myFullFledged;

    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables

}
