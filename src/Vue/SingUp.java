package Vue;

import Beans.Admin;
import Model.*;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class SingUp extends javax.swing.JFrame {

    Connexion c = new Connexion();
    Statement stat;
    PreparedStatement prestate;
    ResultSet rs;

    public SingUp() {
        initComponents();
        setLocationRelativeTo(this);
        lerreurepasword.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        bsinscrire = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        cachpassword = new javax.swing.JTextField();
        jtusername = new javax.swing.JTextField();
        tpassword = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lsingin = new javax.swing.JLabel();
        lerreurepasword = new javax.swing.JLabel();

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

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 255));
        jLabel5.setText("X");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, 30, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 0, 250, 360));

        jPanel2.setBackground(new java.awt.Color(51, 78, 172));
        jPanel2.setForeground(new java.awt.Color(219, 219, 229));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 290, 10));
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 290, 10));

        bsinscrire.setBackground(new java.awt.Color(255, 255, 255));
        bsinscrire.setForeground(new java.awt.Color(112, 150, 209));
        bsinscrire.setText("Inscrire");
        bsinscrire.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bsinscrireMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bsinscrireMouseExited(evt);
            }
        });
        bsinscrire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsinscrireActionPerformed(evt);
            }
        });
        jPanel2.add(bsinscrire, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 290, 40));
        jPanel2.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, 0, 10));

        cachpassword.setForeground(new java.awt.Color(102, 102, 102));
        cachpassword.setText("  Entre votre password");
        cachpassword.setBorder(null);
        cachpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cachpasswordActionPerformed(evt);
            }
        });
        cachpassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cachpasswordFocusGained(evt);
            }
        });
        jPanel2.add(cachpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 290, 30));

        jtusername.setForeground(new java.awt.Color(102, 102, 102));
        jtusername.setText("  Entrer votre username");
        jtusername.setBorder(null);
        jtusername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtusernameActionPerformed(evt);
            }
        });
        jtusername.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtusernameFocusGained(evt);
            }
        });
        jPanel2.add(jtusername, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 290, 30));

        tpassword.setBorder(null);
        tpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tpasswordActionPerformed(evt);
            }
        });
        jPanel2.add(tpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 290, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Sing Up");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, -1, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Hello! Let's get started");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Alredy have an account");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, -1, -1));

        lsingin.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lsingin.setForeground(new java.awt.Color(255, 255, 255));
        lsingin.setText("Sign in");
        lsingin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lsinginMouseClicked(evt);
            }
        });
        jPanel2.add(lsingin, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 290, -1, 30));

        lerreurepasword.setForeground(new java.awt.Color(255, 0, 0));
        lerreurepasword.setText("le mot de passe doit contenir au moins 8 caracteres");
        jPanel2.add(lerreurepasword, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 330, 360));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tpasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tpasswordActionPerformed

    private void jtusernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtusernameFocusGained
        jtusername.setText(null);
        cachpassword.setVisible(false);
        lerreurepasword.setVisible(false);
    }//GEN-LAST:event_jtusernameFocusGained

    private void bsinscrireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsinscrireActionPerformed
        String username = jtusername.getText();
        String password = tpassword.getText();
        Boolean trouve = false;
        Boolean vide=false;

        ConnexionAdmin cu = new ConnexionAdmin();
        
        if (username.equals("")|| password.equals("")) {
            vide=true;
        }
        if (vide==false) {
            if (password.length()>7) {
                 try {
            while (cu.rs.next()) {
                if (username.equals(cu.rs.getString("username"))) {
                    trouve = true;
                    break;
                }
            }
            if (trouve == false) {
                stat = c.getCo().createStatement();
                stat.executeUpdate("INSERT INTO Admin(username,password) VALUES('"
                        + username + "','" + password + "')");
                JOptionPane.showMessageDialog(null, "inscription avec succes");
                Authentification auth = new Authentification();
                auth.setVisible(true);
                setVisible(false);
            } else {
                JOptionPane.showMessageDialog(this, "username exist deja", "erreur", JOptionPane.WARNING_MESSAGE);
                cachpassword.setVisible(true);
                jtusername.setText(" entrer votre username");
                tpassword.setText(null);
            }

        } catch (SQLException ex) {
            Logger.getLogger(SingUp.class.getName()).log(Level.SEVERE, null, ex);
        }
            }
            else{
              lerreurepasword.setVisible(true);
                cachpassword.setVisible(true);
                 jtusername.setText(" entrer votre username");
                tpassword.setText(null);
            }
                
        } else {
            JOptionPane.showMessageDialog(this, "erreur d'isertion", "erreur", JOptionPane.WARNING_MESSAGE);
                cachpassword.setVisible(true);
                 jtusername.setText(" entrer votre username");
                tpassword.setText(null);
        }
        
        
        
       


    }//GEN-LAST:event_bsinscrireActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void lsinginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lsinginMouseClicked
        Authentification ath = new Authentification();
        ath.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_lsinginMouseClicked

    private void cachpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cachpasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cachpasswordActionPerformed

    private void bsinscrireMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bsinscrireMouseEntered
        bsinscrire.setBackground(Color.decode("#d0e3ff"));


    }//GEN-LAST:event_bsinscrireMouseEntered

    private void bsinscrireMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bsinscrireMouseExited
        bsinscrire.setBackground(Color.decode("#ffffff"));
    }//GEN-LAST:event_bsinscrireMouseExited

    private void cachpasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cachpasswordFocusGained
      jtusername.setText(null);
        cachpassword.setVisible(false);
        lerreurepasword.setVisible(false);
    }//GEN-LAST:event_cachpasswordFocusGained

    private void jtusernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtusernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtusernameActionPerformed

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
            java.util.logging.Logger.getLogger(SingUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SingUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SingUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SingUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SingUp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bsinscrire;
    private javax.swing.JTextField cachpassword;
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
    private javax.swing.JTextField jtusername;
    private javax.swing.JLabel lerreurepasword;
    private javax.swing.JLabel lsingin;
    private javax.swing.JPasswordField tpassword;
    // End of variables declaration//GEN-END:variables

}
