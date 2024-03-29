/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates and open the template
 * in the editor.
 */
package org.vaadin.netbeans.refactoring;

import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.netbeans.modules.refactoring.spi.ui.CustomRefactoringPanel;
import org.openide.util.NbBundle;

/**
 * @author denis
 */
class RenamePanel extends JPanel implements CustomRefactoringPanel {

    @NbBundle.Messages({ "# {0} - module name",
            "renameModule=Rename GWT Module {0}" })
    RenamePanel( String name, final ChangeListener listener ) {
        setName(Bundle.renameModule(name));
        initComponents();

        myName.setText(name);
        myName.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void removeUpdate( DocumentEvent e ) {
                fireEvent();
            }

            @Override
            public void insertUpdate( DocumentEvent e ) {
                fireEvent();
            }

            @Override
            public void changedUpdate( DocumentEvent e ) {
                fireEvent();
            }

            private void fireEvent() {
                listener.stateChanged(null);
            }
        });
    }

    @Override
    public Component getComponent() {
        return this;
    }

    @Override
    public void initialize() {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                if (SwingUtilities.getWindowAncestor(myName) == null) {
                    initialize();
                }
                else {
                    myName.requestFocusInWindow();
                    myName.selectAll();
                }
            }
        });
    }

    String getNewName() {
        return myName.getText().trim();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        renameLbl = new javax.swing.JLabel();
        myName = new javax.swing.JTextField();

        renameLbl.setLabelFor(myName);
        org.openide.awt.Mnemonics.setLocalizedText(renameLbl, org.openide.util.NbBundle.getMessage(RenamePanel.class, "LBL_NewName")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(renameLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(myName, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(myName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(renameLbl))
        );

        renameLbl.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(RenamePanel.class, "ACSN_NewName")); // NOI18N
        renameLbl.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(RenamePanel.class, "ACSD_NewName")); // NOI18N
        myName.getAccessibleContext().setAccessibleName(renameLbl.getAccessibleContext().getAccessibleName());
        myName.getAccessibleContext().setAccessibleDescription(renameLbl.getAccessibleContext().getAccessibleDescription());
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField myName;
    private javax.swing.JLabel renameLbl;
    // End of variables declaration//GEN-END:variables
}
