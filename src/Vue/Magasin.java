/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Beans.Magasins;
import Model.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author toshiba
 */
public class Magasin extends javax.swing.JPanel {

    Connexion c = new Connexion();
    Statement stat;
    PreparedStatement prestate;
    ResultSet rs;
    DefaultTableModel dtm = new DefaultTableModel();

    public Magasin() {
        initComponents();
        actualiser();
        pmodifier.setVisible(false);
        bsuuprimer.setVisible(false);
    }

    public static void reinitialiser() {
        tnom.setText(null);
        taddresse.setText(null);
    }

    public void actualiser() {
        //vider la table
        dtm.setColumnCount(0);
        dtm.setRowCount(0);
        try {
            stat = c.getCo().createStatement();
            rs = stat.executeQuery("select * from magasin");
            dtm.addColumn("identifiant");
            dtm.addColumn("nom");
            dtm.addColumn("addresse");
            while (rs.next()) {
                dtm.addRow(new Object[]{
                    rs.getInt("id"), rs.getString("nom"), rs.getString("addresse")});
            }
            tabmagasin.setModel(dtm);
        } catch (SQLException ex) {
            Logger.getLogger(Magasin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void afficher(int nligne) {
        tnom.setText(tabmagasin.getValueAt(nligne, 1).toString());
        taddresse.setText(tabmagasin.getValueAt(nligne, 2).toString());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cmchoix = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        trecherche = new javax.swing.JTextField();
        brecherche = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        pfichec = new javax.swing.JPanel();
        taddresse = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        bsuuprimer = new javax.swing.JButton();
        pmodifier = new javax.swing.JButton();
        bajouter = new javax.swing.JButton();
        tnom = new javax.swing.JTextField();
        bacctualiser = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabmagasin = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(770, 550));
        setPreferredSize(new java.awt.Dimension(770, 550));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(174, 220, 243));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(8, 31, 92));
        jLabel1.setText("MAGASINS");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, -1, -1));

        cmchoix.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "id ", "nom" }));
        cmchoix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmchoixActionPerformed(evt);
            }
        });
        jPanel1.add(cmchoix, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, -1, 30));

        jLabel6.setForeground(new java.awt.Color(0, 0, 102));
        jLabel6.setText("recherche par ");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 30, -1, -1));

        trecherche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trechercheActionPerformed(evt);
            }
        });
        trecherche.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                trechercheFocusGained(evt);
            }
        });
        jPanel1.add(trecherche, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 20, 120, 30));

        brecherche.setBackground(new java.awt.Color(51, 78, 172));
        brecherche.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ihm/search_2_fill (1).png"))); // NOI18N
        brecherche.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                brechercheMouseClicked(evt);
            }
        });
        brecherche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brechercheActionPerformed(evt);
            }
        });
        jPanel1.add(brecherche, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 20, -1, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ihm/magasin.jpg"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, -1, 100));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 70));

        pfichec.setBackground(new java.awt.Color(247, 242, 235));
        pfichec.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pfichec.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        pfichec.add(taddresse, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 30, 210, 30));

        jLabel11.setText("Nom  :");
        pfichec.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 60, -1));

        jLabel12.setText("Adresse :");
        pfichec.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, 60, -1));

        bsuuprimer.setBackground(new java.awt.Color(51, 78, 172));
        bsuuprimer.setForeground(new java.awt.Color(255, 255, 255));
        bsuuprimer.setText("Supprimer");
        bsuuprimer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bsuuprimerMouseClicked(evt);
            }
        });
        bsuuprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsuuprimerActionPerformed(evt);
            }
        });
        pfichec.add(bsuuprimer, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, 90, 30));

        pmodifier.setBackground(new java.awt.Color(51, 78, 172));
        pmodifier.setForeground(new java.awt.Color(255, 255, 255));
        pmodifier.setText("Modifier");
        pmodifier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pmodifierMouseClicked(evt);
            }
        });
        pmodifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pmodifierActionPerformed(evt);
            }
        });
        pfichec.add(pmodifier, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 80, 30));

        bajouter.setBackground(new java.awt.Color(51, 78, 172));
        bajouter.setForeground(new java.awt.Color(255, 255, 255));
        bajouter.setText("Ajouter");
        bajouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bajouterActionPerformed(evt);
            }
        });
        pfichec.add(bajouter, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 80, 30));

        tnom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tnomActionPerformed(evt);
            }
        });
        tnom.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tnomFocusLost(evt);
            }
        });
        pfichec.add(tnom, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 210, 30));

        bacctualiser.setBackground(new java.awt.Color(51, 78, 172));
        bacctualiser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ihm/refresh_3_fill.png"))); // NOI18N
        bacctualiser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bacctualiserMouseClicked(evt);
            }
        });
        bacctualiser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bacctualiserActionPerformed(evt);
            }
        });
        pfichec.add(bacctualiser, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 10, 50, 30));

        add(pfichec, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 740, 140));

        tabmagasin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        tabmagasin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabmagasinMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabmagasin);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 740, 310));
    }// </editor-fold>//GEN-END:initComponents

    private void bsuuprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsuuprimerActionPerformed

    }//GEN-LAST:event_bsuuprimerActionPerformed

    private void pmodifierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pmodifierMouseClicked

        if (JOptionPane.showConfirmDialog(this, "voullez vous vraiment modifier ?", "modification",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            try {
                prestate = c.getCo().prepareStatement("UPDATE magasin SET nom=?,"
                        + "addresse=? WHERE id=?");
                prestate.setString(1, tnom.getText());
                prestate.setString(2, taddresse.getText());

                prestate.setInt(3, Integer.parseInt(tabmagasin.getValueAt(tabmagasin.getSelectedRow(), 0) + ""));
                prestate.execute();
                JOptionPane.showMessageDialog(this, "Modification faite avec succes");
                actualiser();
                reinitialiser();
                pmodifier.setVisible(false);
                bsuuprimer.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(Clients.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_pmodifierMouseClicked

    private void pmodifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pmodifierActionPerformed


    }//GEN-LAST:event_pmodifierActionPerformed

    private void bajouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bajouterActionPerformed

        boolean vide = false;

        // recuperer les donnees du formulaire
        String nom = tnom.getText();
        String addresse = taddresse.getText();

        if (nom.equals("") || addresse.equals("")) {
            vide = true;
        }
        if (!vide) {
            ConnectMagasins cmg = new ConnectMagasins();
            Magasins m = new Magasins();
            m.setNom(nom);
            m.setAddresse(addresse);
            boolean magasinExiste = false;

            try {
                while (cmg.rs.next()) {
                    if (nom.equals(cmg.rs.getString("nom")) && addresse.equals(cmg.rs.getString("addresse"))) {
                        magasinExiste = true;
                        break;
                    }
                }

                if (!magasinExiste) {
                    // Si le magasin n'existe pas, effectuez l'insertion dans la base de données
                    stat = c.getCo().createStatement();
                    stat.executeUpdate("INSERT INTO magasin(nom,addresse) VALUES('" + m.getNom() + "','" + m.getAddresse() + "')");
                    JOptionPane.showMessageDialog(null, "Magasin ajouté avec succès");
                    actualiser();
                    reinitialiser();
                } else {
                    JOptionPane.showMessageDialog(null, "Le magasin existe déjà");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Magasin.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Vous devez remplir tous les champs");
        }

    }//GEN-LAST:event_bajouterActionPerformed

    private void tabmagasinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabmagasinMouseClicked
        afficher(tabmagasin.getSelectedRow());
        pmodifier.setVisible(true);
        bsuuprimer.setVisible(true);
    }//GEN-LAST:event_tabmagasinMouseClicked

    private void tnomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tnomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tnomActionPerformed

    private void cmchoixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmchoixActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmchoixActionPerformed

    private void trechercheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trechercheActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_trechercheActionPerformed

    private void trechercheFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_trechercheFocusGained
        actualiser();
        reinitialiser();
    }//GEN-LAST:event_trechercheFocusGained

    private void brechercheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brechercheActionPerformed
        String s;
        s = cmchoix.getSelectedItem().toString();
        try {

            prestate = c.getCo().prepareStatement("SELECT * FROM magasin WHERE " + s + "=?");
            if (s.equals("id")) {
                prestate.setInt(1, Integer.parseInt(trecherche.getText()));
            } else {
                prestate.setString(1, trecherche.getText().toUpperCase());
            }

            rs = prestate.executeQuery();
            dtm.setRowCount(0);
            while (rs.next()) {
                dtm.addRow(new Object[]{rs.getInt("id"), rs.getString("nom"), rs.getString("addresse")});
            }
            tabmagasin.setModel(dtm);
            if (dtm.getRowCount() != 0) {
                afficher(0);
            } else {
                actualiser();
                JOptionPane.showMessageDialog(this, "le magasin n'existe pas");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Magasin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_brechercheActionPerformed

    private void bacctualiserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bacctualiserActionPerformed

    }//GEN-LAST:event_bacctualiserActionPerformed

    private void bacctualiserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bacctualiserMouseClicked
        actualiser();
        reinitialiser();
        pmodifier.setVisible(false);
        bsuuprimer.setVisible(false);
    }//GEN-LAST:event_bacctualiserMouseClicked

    private void bsuuprimerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bsuuprimerMouseClicked
        if (JOptionPane.showConfirmDialog(this, "voulez vous vraiment supprimer ?", "suppression", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            try {
                stat = c.getCo().createStatement();
                stat.executeUpdate("DELETE FROM livraisons WHERE magasin='" + tabmagasin.getValueAt(tabmagasin.getSelectedRow(), 0) + "'");
                stat = c.getCo().createStatement();
                stat.executeUpdate("DELETE FROM commandes_pa WHERE magasin='" + tabmagasin.getValueAt(tabmagasin.getSelectedRow(), 0) + "'");
                stat = c.getCo().createStatement();
                
                stat.executeUpdate("DELETE FROM magasin WHERE id='" + tabmagasin.getValueAt(tabmagasin.getSelectedRow(), 0) + "'");
                JOptionPane.showMessageDialog(this, "suppression faite avec succes");
                actualiser();
                pmodifier.setVisible(false);
                bsuuprimer.setVisible(false);
                reinitialiser();
            } catch (SQLException ex) {
                Logger.getLogger(Magasin.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_bsuuprimerMouseClicked

    private void tnomFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tnomFocusLost
        tnom.setText(tnom.getText().toUpperCase());
    }//GEN-LAST:event_tnomFocusLost

    private void brechercheMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_brechercheMouseClicked
        
    }//GEN-LAST:event_brechercheMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bacctualiser;
    public javax.swing.JButton bajouter;
    private javax.swing.JButton brecherche;
    private javax.swing.JButton bsuuprimer;
    private javax.swing.JComboBox<String> cmchoix;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel pfichec;
    private javax.swing.JButton pmodifier;
    private javax.swing.JTable tabmagasin;
    public static javax.swing.JTextField taddresse;
    public static javax.swing.JTextField tnom;
    private javax.swing.JTextField trecherche;
    // End of variables declaration//GEN-END:variables
}
