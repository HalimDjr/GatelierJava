package Vue;

import Model.*;
import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Authentification extends javax.swing.JFrame {

    public static String usernameAdmin="";

    public Authentification() {
        initComponents();
        setLocationRelativeTo(this);
    }

    public static String adminName() {
        ConnexionAdmin cu = new ConnexionAdmin();

        boolean trouve = false;

        try {
            while (cu.rs.next()) {
                if (tfuser.getText().equals(cu.rs.getString("username"))
                        && tpassword.getText().equals(cu.rs.getString("password"))) {
                    trouve = true;
                    break;
                }

            }
            if (trouve) {
                usernameAdmin = cu.rs.getString("username");
            }else{
                usernameAdmin="username";
            }

        } catch (SQLException ex) {
            Logger.getLogger(Authentification.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usernameAdmin;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        bconnect = new javax.swing.JButton();
        licon1 = new javax.swing.JLabel();
        licon2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        cachpassword = new javax.swing.JTextField();
        tfuser = new javax.swing.JTextField();
        tpassword = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lsingup = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(112, 150, 209));
        jLabel1.setText("BIENVENUE");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, -1, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ihm/login2.jpg"))); // NOI18N
        jLabel2.setToolTipText("");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 210, 240));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 360));

        jPanel2.setBackground(new java.awt.Color(51, 78, 172));
        jPanel2.setForeground(new java.awt.Color(219, 219, 229));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 290, 10));
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 290, 10));

        bconnect.setBackground(new java.awt.Color(255, 255, 255));
        bconnect.setForeground(new java.awt.Color(112, 150, 209));
        bconnect.setText(" Se connencter");
        bconnect.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bconnectMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bconnectMouseExited(evt);
            }
        });
        bconnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bconnectActionPerformed(evt);
            }
        });
        jPanel2.add(bconnect, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 290, 40));

        licon1.setBackground(new java.awt.Color(0, 102, 255));
        licon1.setForeground(new java.awt.Color(0, 102, 255));
        licon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ihm/icons8-user-30.png"))); // NOI18N
        jPanel2.add(licon1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 120, -1, -1));

        licon2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ihm/password-30.png"))); // NOI18N
        jPanel2.add(licon2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 170, 30, 30));
        jPanel2.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, 0, 10));

        cachpassword.setForeground(new java.awt.Color(102, 102, 102));
        cachpassword.setText("  Entre votre password");
        cachpassword.setBorder(null);
        cachpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cachpasswordActionPerformed(evt);
            }
        });
        jPanel2.add(cachpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 290, 30));

        tfuser.setForeground(new java.awt.Color(102, 102, 102));
        tfuser.setText("  Enter votre username");
        tfuser.setBorder(null);
        tfuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfuserActionPerformed(evt);
            }
        });
        tfuser.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfuserFocusGained(evt);
            }
        });
        jPanel2.add(tfuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 290, 30));

        tpassword.setBorder(null);
        tpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tpasswordActionPerformed(evt);
            }
        });
        jPanel2.add(tpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 290, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("LOGIN");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, -1, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Hello! Let's get started");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ihm/close_fill (1).png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 30, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Don't have an account?");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, -1, -1));

        lsingup.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lsingup.setForeground(new java.awt.Color(255, 255, 255));
        lsingup.setText("Sign Up");
        lsingup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lsingupMouseClicked(evt);
            }
        });
        jPanel2.add(lsingup, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 290, -1, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 330, 360));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tpasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tpasswordActionPerformed

    private void tfuserFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfuserFocusGained
        tfuser.setText(null);
        cachpassword.setVisible(false);
    }//GEN-LAST:event_tfuserFocusGained

    private void bconnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bconnectActionPerformed
        ConnexionAdmin cu = new ConnexionAdmin();

        boolean trouve = false;

        try {
            while (cu.rs.next()) {
                if (tfuser.getText().equals(cu.rs.getString("username"))
                        && tpassword.getText().equals(cu.rs.getString("password"))) {
                    trouve = true;
                    break;
                }

            }
            if (trouve) {
                new Dashboard().setVisible(true);
                this.setVisible(false);

                usernameAdmin = cu.rs.getNString("username");

            } else {
                JOptionPane.showMessageDialog(this, "username ou mot de pass incorrect", "erreur", JOptionPane.WARNING_MESSAGE);
                tfuser.setText("Enter votre user name");
                cachpassword.setVisible(true);
                tpassword.setText(null);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Authentification.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bconnectActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void lsingupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lsingupMouseClicked
        SingUp su = new SingUp();
        su.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_lsingupMouseClicked

    private void cachpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cachpasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cachpasswordActionPerformed

    private void bconnectMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bconnectMouseEntered
        bconnect.setBackground(Color.decode("#d0e3ff"));


    }//GEN-LAST:event_bconnectMouseEntered

    private void bconnectMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bconnectMouseExited
        bconnect.setBackground(Color.decode("#ffffff"));
    }//GEN-LAST:event_bconnectMouseExited

    private void tfuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfuserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfuserActionPerformed

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
            java.util.logging.Logger.getLogger(Authentification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Authentification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Authentification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Authentification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Authentification().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bconnect;
    public static javax.swing.JTextField cachpassword;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel licon1;
    private javax.swing.JLabel licon2;
    private javax.swing.JLabel lsingup;
    public static javax.swing.JTextField tfuser;
    public static javax.swing.JPasswordField tpassword;
    // End of variables declaration//GEN-END:variables

}
