/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import controllers.Facade;
import dao.DAOException;
import entities.Guard;
import entities.Guardnotificationtype;
import entities.Guardpreference;
import java.awt.event.KeyEvent;
import java.math.BigInteger;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author diegovc8
 */
public class NewGuardModal extends javax.swing.JDialog {

    /**
     * Creates new form AddNewGuard
     */
    Facade fachada;
    Guard updateGuard = null;
    
    public NewGuardModal(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        fachada = new Facade();
    }

    NewGuardModal(java.awt.Frame parent, boolean modal, Guard guard) {
        super(parent, modal);
        initComponents();
        fachada = new Facade();
        updateGuard = guard;
        
        TF_DNI.setText(Integer.toString(guard.getDni()));
        TF_fName.setText(guard.getFirstname());
        TF_lName.setText(guard.getLastname());
        TF_email.setText(guard.getEmail());
        TF_Phone.setText(Integer.toString(guard.getPhone()));
        FTF_birthdate.setDate(guard.getBirthdate());
        Set<Guardpreference> preferenceList = updateGuard.getGuardpreferences();
        if (!preferenceList.isEmpty()) {
            preferenceList.forEach(item -> {
                int notificationType = (int) item.getGuardnotificationtype().getId();
                switch (notificationType) {
                    case 1: CB_phone.setSelected(true);
                            break;
                    case 2: CB_email.setSelected(true);
                            break;
                    case 3: CB_calendar.setSelected(true);
                            break;
                    }
            });
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PNL_sidebar = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        PNL_principal = new javax.swing.JPanel();
        TF_fName = new javax.swing.JTextField();
        LabelNombre = new javax.swing.JLabel();
        LabelDNI = new javax.swing.JLabel();
        TF_DNI = new javax.swing.JTextField();
        LabelTelefono = new javax.swing.JLabel();
        TF_Phone = new javax.swing.JTextField();
        LabelEmail = new javax.swing.JLabel();
        TF_email = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        CB_email = new javax.swing.JCheckBox();
        CB_phone = new javax.swing.JCheckBox();
        CB_calendar = new javax.swing.JCheckBox();
        jSeparator1 = new javax.swing.JSeparator();
        FTF_birthdate = new com.toedter.calendar.JDateChooser();
        LabelNacimiento = new javax.swing.JLabel();
        CB_gender = new javax.swing.JComboBox<>();
        LabelSexo = new javax.swing.JLabel();
        TF_lName = new javax.swing.JTextField();
        LabelApellido = new javax.swing.JLabel();
        LBL_aceptar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        PNL_sidebar.setBackground(new java.awt.Color(0, 0, 80));
        PNL_sidebar.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nuevo guardia");

        javax.swing.GroupLayout PNL_sidebarLayout = new javax.swing.GroupLayout(PNL_sidebar);
        PNL_sidebar.setLayout(PNL_sidebarLayout);
        PNL_sidebarLayout.setHorizontalGroup(
            PNL_sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PNL_sidebarLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(22, 22, 22))
        );
        PNL_sidebarLayout.setVerticalGroup(
            PNL_sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PNL_sidebarLayout.createSequentialGroup()
                .addGap(270, 270, 270)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PNL_principal.setBackground(new java.awt.Color(255, 255, 255));

        TF_fName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TF_fName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 80)));
        TF_fName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TF_fNameKeyTyped(evt);
            }
        });

        LabelNombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LabelNombre.setText("Nombre:");

        LabelDNI.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LabelDNI.setText("DNI:");

        TF_DNI.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TF_DNI.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 80)));
        TF_DNI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TF_DNIKeyTyped(evt);
            }
        });

        LabelTelefono.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LabelTelefono.setText("Nº de Teléfono:");

        TF_Phone.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TF_Phone.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 80)));
        TF_Phone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TF_PhoneKeyTyped(evt);
            }
        });

        LabelEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LabelEmail.setText("E-Mail:");

        TF_email.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TF_email.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 80)));
        TF_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_emailActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Notificar por:");

        CB_email.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        CB_email.setText("Email");
        CB_email.setOpaque(false);
        CB_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_emailActionPerformed(evt);
            }
        });

        CB_phone.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        CB_phone.setText("Llamada");
        CB_phone.setOpaque(false);

        CB_calendar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        CB_calendar.setText("Calendario");
        CB_calendar.setOpaque(false);

        FTF_birthdate.setToolTipText("");

        LabelNacimiento.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LabelNacimiento.setText("Fecha de Nacimiento:");

        CB_gender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Femenino" }));

        LabelSexo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LabelSexo.setText("Sexo:");

        TF_lName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TF_lName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 80)));
        TF_lName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TF_lNameKeyTyped(evt);
            }
        });

        LabelApellido.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LabelApellido.setText("Apellido:");

        LBL_aceptar.setBackground(new java.awt.Color(20, 141, 176));
        LBL_aceptar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        LBL_aceptar.setForeground(new java.awt.Color(255, 255, 255));
        LBL_aceptar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LBL_aceptar.setText("Aceptar");
        LBL_aceptar.setOpaque(true);
        LBL_aceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LBL_aceptarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LBL_aceptarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LBL_aceptarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout PNL_principalLayout = new javax.swing.GroupLayout(PNL_principal);
        PNL_principal.setLayout(PNL_principalLayout);
        PNL_principalLayout.setHorizontalGroup(
            PNL_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PNL_principalLayout.createSequentialGroup()
                .addGroup(PNL_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PNL_principalLayout.createSequentialGroup()
                        .addContainerGap(29, Short.MAX_VALUE)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 638, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PNL_principalLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LBL_aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24))
            .addGroup(PNL_principalLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(PNL_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addGroup(PNL_principalLayout.createSequentialGroup()
                        .addComponent(CB_email)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CB_phone)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CB_calendar))
                    .addComponent(TF_email)
                    .addGroup(PNL_principalLayout.createSequentialGroup()
                        .addComponent(LabelEmail)
                        .addGap(165, 165, 165))
                    .addGroup(PNL_principalLayout.createSequentialGroup()
                        .addGroup(PNL_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PNL_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(TF_DNI)
                                .addComponent(TF_Phone, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                                .addComponent(LabelNombre)
                                .addComponent(LabelDNI)
                                .addComponent(TF_fName))
                            .addComponent(LabelTelefono))
                        .addGap(18, 18, 18)
                        .addGroup(PNL_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(LabelNacimiento)
                            .addComponent(LabelApellido)
                            .addComponent(LabelSexo)
                            .addComponent(TF_lName)
                            .addComponent(CB_gender, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(FTF_birthdate, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PNL_principalLayout.setVerticalGroup(
            PNL_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PNL_principalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PNL_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelNombre)
                    .addComponent(LabelApellido))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PNL_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TF_fName, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TF_lName, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PNL_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelDNI)
                    .addComponent(LabelSexo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PNL_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TF_DNI, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CB_gender, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PNL_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelTelefono)
                    .addComponent(LabelNacimiento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PNL_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TF_Phone, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FTF_birthdate, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(LabelEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TF_email, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PNL_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CB_email)
                    .addComponent(CB_phone)
                    .addComponent(CB_calendar))
                .addGap(15, 15, 15)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(LBL_aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(PNL_sidebar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(PNL_principal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PNL_sidebar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PNL_principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void TF_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TF_emailActionPerformed

    private void TF_DNIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TF_DNIKeyTyped
        char c = evt.getKeyChar();
        if (!( Character.isDigit(c) || c == KeyEvent.VK_DELETE || c == KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
        }  else if (!TF_DNI.getText().equals("")) {
            BigInteger cantidad = new BigInteger(TF_DNI.getText());
            System.out.println(cantidad);
            if (BigInteger.valueOf(Integer.MAX_VALUE).compareTo(cantidad) < 0) {
                evt.consume();
                JOptionPane.showMessageDialog(null, "El numero debe ser menor a "+Integer.MAX_VALUE);
            }
        }
    }//GEN-LAST:event_TF_DNIKeyTyped

    private void TF_PhoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TF_PhoneKeyTyped
        char c = evt.getKeyChar();
        if (!( Character.isDigit(c) || c == KeyEvent.VK_DELETE || c == KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
        }  else if (!TF_Phone.getText().equals("")) {
            BigInteger cantidad = new BigInteger(TF_Phone.getText());
            System.out.println(cantidad);
            if (BigInteger.valueOf(Integer.MAX_VALUE).compareTo(cantidad) < 0) {
                evt.consume();
                JOptionPane.showMessageDialog(null, "El numero debe ser menor a "+Integer.MAX_VALUE);
            }
        }
    }//GEN-LAST:event_TF_PhoneKeyTyped

    private void TF_fNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TF_fNameKeyTyped
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_TF_fNameKeyTyped

    private void TF_lNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TF_lNameKeyTyped
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_TF_lNameKeyTyped

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        
    }//GEN-LAST:event_formWindowClosed

    private void CB_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CB_emailActionPerformed

    private void LBL_aceptarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LBL_aceptarMouseClicked
        if ("".equals(TF_fName.getText()) || "".equals(TF_lName.getText()) ||
            FTF_birthdate.getDate() == null || "".equals(TF_DNI.getText()) ) {
            JOptionPane.showMessageDialog(null, "Debe completar todo los campos", "Alert", JOptionPane.INFORMATION_MESSAGE);
        } else {
            Guard guard = new Guard();
            
            if (updateGuard != null) {
                guard.setId(updateGuard.getId());
                try {
                    fachada.deleteAllGuardPreferenceByGuard(updateGuard.getId());
                } catch (DAOException ex) {
                    Logger.getLogger(NewGuardModal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            guard.setDni(Integer.parseInt(TF_DNI.getText()));
            guard.setFirstname(TF_fName.getText());
            guard.setLastname(TF_lName.getText());
            guard.setBirthdate(FTF_birthdate.getDate());
            guard.setPhone(Integer.parseInt(TF_Phone.getText()));

            if (CB_gender.getSelectedIndex() == 1) {
                guard.setGender(true);
            } else if (CB_gender.getSelectedIndex() == 2) {
                guard.setGender(false);
            }
            
            if (!"".equals(TF_email.getText())) {
                guard.setEmail(TF_email.getText());
            }
            
            if (CB_phone.isSelected()) {
                try {
                    Guardnotificationtype notificationType = fachada.getNotificationType(1);
                    Guardpreference guardPreference = new Guardpreference();
                    guardPreference.setGuardnotificationtype(notificationType);
                    guardPreference.setDescription(notificationType.getDescription());
                    guardPreference.setGuard(guard);
                    guard.getGuardpreferences().add(guardPreference);
                } catch (DAOException ex) {
                    Logger.getLogger(NewGuardModal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (CB_email.isSelected()) {
                try {
                    Guardnotificationtype notificationType = fachada.getNotificationType(2);
                    Guardpreference guardPreference = new Guardpreference();
                    guardPreference.setGuardnotificationtype(notificationType);
                    guardPreference.setDescription(notificationType.getDescription());
                    guardPreference.setGuard(guard);
                    guard.getGuardpreferences().add(guardPreference);
                } catch (DAOException ex) {
                    Logger.getLogger(NewGuardModal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (CB_calendar.isSelected()) {
                try {
                    Guardnotificationtype notificationType = fachada.getNotificationType(3);
                    Guardpreference guardPreference = new Guardpreference();
                    guardPreference.setGuardnotificationtype(notificationType);
                    guardPreference.setDescription(notificationType.getDescription());
                    guardPreference.setGuard(guard);
                    guard.getGuardpreferences().add(guardPreference);
                } catch (DAOException ex) {
                    Logger.getLogger(NewGuardModal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            try {
                this.setEnabled(false);
                fachada.createGuard(guard);
                if (updateGuard == null) {
                    JOptionPane.showMessageDialog(null, "El guardia "+guard.getFirstname()+" ha sido guardado con exito", "Nuevo guardia", JOptionPane.INFORMATION_MESSAGE);
                    Object newGuard[] = {guard.getId(), guard.getFirstname(), guard.getLastname(), guard.getDni(), guard.getPhone()};
                    Main.guardModel.addRow(newGuard);
                } else {
                    JOptionPane.showMessageDialog(null, "El guardia "+guard.getFirstname()+" ha sido Modificado con exito", "Guardia modificado", JOptionPane.INFORMATION_MESSAGE);
                    int row = -1;
                    
                    for (int i = 0; i < Main.guardModel.getRowCount(); ++i) {
                        if (Main.guardModel.getValueAt(i, 0).equals(guard.getId())) {
                            row = i;
                            break;
                        }
                    }

                    if (row != -1) {
                        Main.guardModel.removeRow(row);
                    }
                    
                    Object newGuard[] = {guard.getId(), guard.getFirstname(), guard.getLastname(), guard.getDni(), guard.getPhone()};
                    Main.guardModel.addRow(newGuard);
                }

                this.setEnabled(true);
                this.dispose();
            } catch (DAOException ex) {
                JOptionPane.showMessageDialog(null, "Error de base de datos", "Base de datos", JOptionPane.INFORMATION_MESSAGE);
                ex.printStackTrace();
                this.setEnabled(true);
                this.dispose();
            }
        }
    }//GEN-LAST:event_LBL_aceptarMouseClicked

    private void LBL_aceptarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LBL_aceptarMouseEntered
        LBL_aceptar.setBackground(new java.awt.Color(43,152,183));
    }//GEN-LAST:event_LBL_aceptarMouseEntered

    private void LBL_aceptarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LBL_aceptarMouseExited
        LBL_aceptar.setBackground(new java.awt.Color(20,141,176));
    }//GEN-LAST:event_LBL_aceptarMouseExited

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewGuardModal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewGuardModal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewGuardModal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewGuardModal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewGuardModal(null, true).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox CB_calendar;
    private javax.swing.JCheckBox CB_email;
    private javax.swing.JComboBox<String> CB_gender;
    private javax.swing.JCheckBox CB_phone;
    private com.toedter.calendar.JDateChooser FTF_birthdate;
    private javax.swing.JLabel LBL_aceptar;
    private javax.swing.JLabel LabelApellido;
    private javax.swing.JLabel LabelDNI;
    private javax.swing.JLabel LabelEmail;
    private javax.swing.JLabel LabelNacimiento;
    private javax.swing.JLabel LabelNombre;
    private javax.swing.JLabel LabelSexo;
    private javax.swing.JLabel LabelTelefono;
    private javax.swing.JPanel PNL_principal;
    private javax.swing.JPanel PNL_sidebar;
    private javax.swing.JTextField TF_DNI;
    private javax.swing.JTextField TF_Phone;
    private javax.swing.JTextField TF_email;
    private javax.swing.JTextField TF_fName;
    private javax.swing.JTextField TF_lName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
