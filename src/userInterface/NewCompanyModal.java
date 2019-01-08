/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import controllers.Facade;
import dao.DAOException;
import entities.Company;
import java.awt.event.KeyEvent;
import java.math.BigInteger;
import javax.swing.JOptionPane;

/**
 *
 * @author diegovc8
 */
public class NewCompanyModal extends javax.swing.JDialog {
    private int x , y;
    Facade fachada;
    Company updateCompany = null;
    
    public NewCompanyModal(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        fachada = new Facade();
    }

    NewCompanyModal(java.awt.Frame parent, boolean modal, Company company) {
        super(parent, modal);
        initComponents();
        fachada = new Facade();
        updateCompany = company;
        
        TF_name.setText(company.getName());
        TF_address.setText(company.getAddress());
        TF_cuit.setText(Integer.toString(company.getCuit()));
        TF_email.setText(company.getEmail());
        TF_phone.setText(Integer.toString(company.getPhone()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        TF_name = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        TF_address = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        TF_cuit = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        TF_phone = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        TF_email = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        LBL_aceptar = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(550, 450));
        setMinimumSize(new java.awt.Dimension(550, 450));
        setResizable(false);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        TF_name.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TF_name.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 80)));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel1.setText("Nombre:");

        TF_address.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TF_address.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 80)));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel2.setText("Direccion:");

        TF_cuit.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TF_cuit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 80)));
        TF_cuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_cuitActionPerformed(evt);
            }
        });
        TF_cuit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TF_cuitKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel4.setText("CUIT:");

        TF_phone.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TF_phone.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 80)));
        TF_phone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_phoneActionPerformed(evt);
            }
        });
        TF_phone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TF_phoneKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel3.setText("Teléfono:");

        TF_email.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TF_email.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 80)));
        TF_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_emailActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel5.setText("Email:");

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addComponent(jLabel5)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(TF_name, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel1))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addComponent(TF_address, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(TF_phone, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(TF_cuit, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LBL_aceptar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TF_email, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TF_name, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TF_address, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TF_phone, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TF_cuit, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TF_email, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LBL_aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        jPanel1.setBackground(new java.awt.Color(0, 0, 80));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Nueva compañia");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(165, 165, 165))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void TF_phoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF_phoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TF_phoneActionPerformed

    private void TF_cuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF_cuitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TF_cuitActionPerformed

    private void TF_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TF_emailActionPerformed

    private void TF_phoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TF_phoneKeyTyped
        char c = evt.getKeyChar();
        if (!( Character.isDigit(c) || c == KeyEvent.VK_DELETE || c == KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
        }  else if (!TF_phone.getText().equals("")) {
            BigInteger cantidad = new BigInteger(TF_phone.getText());
            if (BigInteger.valueOf(Integer.MAX_VALUE).compareTo(cantidad) < 0) {
                evt.consume();
                JOptionPane.showMessageDialog(null, "El numero debe ser menor a "+Integer.MAX_VALUE);
            }
        }
    }//GEN-LAST:event_TF_phoneKeyTyped

    private void TF_cuitKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TF_cuitKeyTyped
        char c = evt.getKeyChar();
        if (!( Character.isDigit(c) || c == KeyEvent.VK_DELETE || c == KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
        }
    }//GEN-LAST:event_TF_cuitKeyTyped

    private void LBL_aceptarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LBL_aceptarMouseEntered
        LBL_aceptar.setBackground(new java.awt.Color(43,152,183));
    }//GEN-LAST:event_LBL_aceptarMouseEntered

    private void LBL_aceptarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LBL_aceptarMouseExited
        LBL_aceptar.setBackground(new java.awt.Color(20,141,176));
    }//GEN-LAST:event_LBL_aceptarMouseExited

    private void LBL_aceptarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LBL_aceptarMouseClicked
               if ("".equals(TF_name.getText()) || "".equals(TF_address.getText()) ||
            "".equals(TF_cuit.getText())) {
            JOptionPane.showMessageDialog(null, "Debe completar todo los campos", "Alert", JOptionPane.INFORMATION_MESSAGE);
        } else {
            Company company = new Company();
            if (updateCompany != null) {
                company.setId(updateCompany.getId());
            }
            company.setName(TF_name.getText());
            company.setAddress(TF_address.getText());
            company.setCuit(Integer.parseInt(TF_cuit.getText()));

            if (!"".equals(TF_phone.getText())) {
                company.setPhone(Integer.parseInt(TF_phone.getText()));
            }

            if (!"".equals(TF_email.getText())) {
                company.setEmail(TF_email.getText());
            }

            try {
                this.setEnabled(false);
                fachada.createCompany(company);
                if (updateCompany == null) {
                    JOptionPane.showMessageDialog(null, "La empresa "+company.getName()+" ah sido guardado con exito", "Nueva Empresa", JOptionPane.INFORMATION_MESSAGE);
                    Object newCompany[] = {company.getId(), company.getName(), company.getAddress(), company.getPhone(), company.getCuit()};
                    Main.companyModel.addRow(newCompany);
                } else {
                    JOptionPane.showMessageDialog(null, "La empresa "+company.getName()+" ah sido Modificada con exito", "Empresa modificada", JOptionPane.INFORMATION_MESSAGE);
                    Object newCompany[] = {company.getId(), company.getName(), company.getAddress(), company.getPhone(), company.getCuit()};
                    int row = -1;

                    for (int i = 0; i < Main.companyModel.getRowCount(); ++i) {
                        if (Main.companyModel.getValueAt(i, 0).equals(company.getId())) {
                            row = i;
                            break;
                        }
                    }

                    if (row != -1) {
                        Main.companyModel.removeRow(row);
                    }

                    Main.companyModel.addRow(newCompany);
                }

                this.setEnabled(true);
                this.dispose();
            } catch (DAOException ex) {
                JOptionPane.showMessageDialog(null, "Error de base de datos", "Alert", JOptionPane.INFORMATION_MESSAGE);
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_LBL_aceptarMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LBL_aceptar;
    private javax.swing.JTextField TF_address;
    private javax.swing.JTextField TF_cuit;
    private javax.swing.JTextField TF_email;
    private javax.swing.JTextField TF_name;
    private javax.swing.JTextField TF_phone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}