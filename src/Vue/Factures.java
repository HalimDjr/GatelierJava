/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Model.Connexion;
import static Vue.Livraisons.idcommande;
import static Vue.Livraisons.idmagasin1;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author toshiba
 */
public class Factures extends javax.swing.JPanel {

    FicheF ff = new FicheF();
    ListeDesClommandess lcm = new ListeDesClommandess();
    PreparedStatement ps;
    Connexion co = new Connexion();
    DefaultTableModel dtm = new DefaultTableModel();
    Statement stat;
    ResultSet rs;
       Statement stat2;
    ResultSet rs2;

    /**
     * Creates new form Livraisons
     */
    public Factures() {
        initComponents();
        actualiser();
        reinitialiser();

    }

    public void reinitialiser() {
        tdate1.setDate(null);
        idcommande.setText("");
        lqte.setVisible(false);
        idmagasin1.setVisible(false);
        nommagasin.setVisible(false);
        addressemagasin.setVisible(false);
        tnumero.setText(null);
        ttotale.setText(null);
        lidc.setVisible(false);
        lq.setVisible(false);
        lidm.setVisible(false);
        lnm.setVisible(false);
        laddm.setVisible(false);
        bsuuprimer1.setVisible(false);
        pmodifier.setVisible(false);
        bafficher.setVisible(false);

    }

    public void actualiser() {
        //vider la table
        dtm.setColumnCount(0);
        dtm.setRowCount(0);
        try {
            stat = co.getCo().createStatement();
            rs = stat.executeQuery("select * from factures");
            dtm.addColumn("numero");
            dtm.addColumn("date");
            dtm.addColumn("total");
            dtm.addColumn("id_commande");

            while (rs.next()) {
                dtm.addRow(new Object[]{
                    rs.getInt("id"), rs.getDate("date"), rs.getInt("total"), rs.getInt("id_commande")
                });
            }
            tabfactures.setModel(dtm);
        } catch (SQLException ex) {
            Logger.getLogger(Factures.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void afficher(int nligne) {
        tnumero.setText(tabfactures.getValueAt(nligne, 0).toString());
        tdate1.setDate((Date) tabfactures.getValueAt(nligne, 1));
        ttotale.setText(tabfactures.getValueAt(nligne, 2).toString());
        idcommande.setText(tabfactures.getValueAt(nligne, 3).toString());

        try {
            stat = co.getCo().createStatement();
            rs = stat.executeQuery("SELECT quentite FROM commandes_pa  WHERE id=" + Integer.parseInt(tabfactures.getValueAt(nligne, 3).toString()));

            if (rs.next()) {
                // Si le ResultSet contient des lignes, récupérez les données
                lqte.setText(rs.getString("quentite"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Factures.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            stat = co.getCo().createStatement();
            rs = stat.executeQuery("SELECT m.id,m.nom,m.addresse FROM magasin m,commandes_pa cp WHERE m.id= cp.magasin and cp.id=" + Integer.parseInt(tabfactures.getValueAt(nligne, 3).toString()));

            if (rs.next()) {
                // Si le ResultSet contient des lignes, récupérez les données
                idmagasin1.setText(rs.getString("id"));
                nommagasin.setText(rs.getString("nom"));
                addressemagasin.setText(rs.getString("addresse"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Factures.class.getName()).log(Level.SEVERE, null, ex);
        }
        idcommande.setVisible(true);
        lqte.setVisible(true);
        idmagasin1.setVisible(true);
        nommagasin.setVisible(true);
        addressemagasin.setVisible(true);
        lidc.setVisible(true);
        lq.setVisible(true);
        lidm.setVisible(true);
        lnm.setVisible(true);
        laddm.setVisible(true);
        bsuuprimer1.setVisible(true);
        pmodifier.setVisible(true);
        bafficher.setVisible(true);

    }

    public void affact(int nligne) {
        ff.lnumfact.setText(tabfactures.getValueAt(nligne, 0).toString());
        ff.ldatefact.setText(tabfactures.getValueAt(nligne, 1).toString());
        ff.ltotal.setText(tabfactures.getValueAt(nligne, 2).toString());
        try {
            stat2 = co.getCo().createStatement();
            rs2 = stat2.executeQuery("SELECT nom,addresse FROM aatelier WHERE id= 1" );
            stat = co.getCo().createStatement();
            rs = stat.executeQuery("SELECT m.nom,m.addresse FROM magasin m,commandes_pa cp WHERE m.id= cp.magasin and cp.id=" + Integer.parseInt(tabfactures.getValueAt(nligne, 3).toString()));

            if (rs.next()) {
                ff.lnomM.setText(rs.getString("nom"));
                ff.ladresseM.setText(rs.getString("addresse"));
            }
               if (rs2.next()) {
                ff.nomA.setText(rs2.getString("nom"));
                ff.ladresseA.setText(rs2.getString("addresse"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Livraisons.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            stat = co.getCo().createStatement();
            rs = stat.executeQuery("SELECT m.nom,m.prix FROM modeles m,commandes_pa cp WHERE m.id= cp.id_modele and cp.id=" + Integer.parseInt(tabfactures.getValueAt(nligne, 3).toString()));

            if (rs.next()) {
                ff.nommodele.setText(rs.getString("nom"));
                ff.prixmodele.setText(rs.getString("prix"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Livraisons.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        brecherche = new javax.swing.JButton();
        trecherche = new javax.swing.JTextField();
        cmchoix = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        pfichec = new javax.swing.JPanel();
        ttotale = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        bafficher = new javax.swing.JButton();
        pmodifier = new javax.swing.JButton();
        bajouter = new javax.swing.JButton();
        tdate1 = new com.toedter.calendar.JDateChooser();
        bsuuprimer1 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        tnumero = new javax.swing.JLabel();
        selectcommande = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        lidc = new javax.swing.JLabel();
        idcommande = new javax.swing.JLabel();
        jSeparator12 = new javax.swing.JSeparator();
        jPanel13 = new javax.swing.JPanel();
        lq = new javax.swing.JLabel();
        lqte = new javax.swing.JLabel();
        jSeparator13 = new javax.swing.JSeparator();
        jLabel13 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        lidm = new javax.swing.JLabel();
        idmagasin1 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        lnm = new javax.swing.JLabel();
        nommagasin = new javax.swing.JLabel();
        jSeparator14 = new javax.swing.JSeparator();
        jPanel14 = new javax.swing.JPanel();
        laddm = new javax.swing.JLabel();
        addressemagasin = new javax.swing.JLabel();
        jSeparator15 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabfactures = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(770, 550));
        setPreferredSize(new java.awt.Dimension(770, 550));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(173, 204, 207));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(8, 31, 92));
        jLabel1.setText("FACTURES");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, -1, -1));

        jLabel2.setBackground(new java.awt.Color(112, 150, 209));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ihm/facture2.jpg"))); // NOI18N
        jLabel2.setOpaque(true);
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 70));

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

        cmchoix.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "id", "id_commande" }));
        cmchoix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmchoixActionPerformed(evt);
            }
        });
        jPanel1.add(cmchoix, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, -1, 30));

        jLabel6.setText("recherche par ");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 30, -1, -1));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 70));

        pfichec.setBackground(new java.awt.Color(247, 242, 235));
        pfichec.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pfichec.setFocusable(false);
        pfichec.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ttotale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ttotaleActionPerformed(evt);
            }
        });
        pfichec.add(ttotale, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 140, 30));

        jLabel10.setText("Numero  :");
        pfichec.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel11.setText("Date :");
        pfichec.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 40, -1));

        jLabel12.setText("Total a payer :");
        pfichec.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 80, -1));

        bafficher.setBackground(new java.awt.Color(51, 78, 172));
        bafficher.setForeground(new java.awt.Color(255, 255, 255));
        bafficher.setText("Afficher");
        bafficher.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bafficherMouseClicked(evt);
            }
        });
        bafficher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bafficherActionPerformed(evt);
            }
        });
        pfichec.add(bafficher, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, 90, 30));

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
        pfichec.add(pmodifier, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 80, 30));

        bajouter.setBackground(new java.awt.Color(51, 78, 172));
        bajouter.setForeground(new java.awt.Color(255, 255, 255));
        bajouter.setText("Ajouter");
        bajouter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bajouterMouseClicked(evt);
            }
        });
        bajouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bajouterActionPerformed(evt);
            }
        });
        pfichec.add(bajouter, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 80, 30));
        pfichec.add(tdate1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 160, 30));

        bsuuprimer1.setBackground(new java.awt.Color(51, 78, 172));
        bsuuprimer1.setForeground(new java.awt.Color(255, 255, 255));
        bsuuprimer1.setText("Supprimer");
        bsuuprimer1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bsuuprimer1MouseClicked(evt);
            }
        });
        bsuuprimer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsuuprimer1ActionPerformed(evt);
            }
        });
        pfichec.add(bsuuprimer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 90, 30));

        jButton1.setBackground(new java.awt.Color(51, 78, 172));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ihm/refresh_3_fill.png"))); // NOI18N
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        pfichec.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 10, 50, 30));

        tnumero.setText("................");
        pfichec.add(tnumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 80, -1));

        selectcommande.setBackground(new java.awt.Color(204, 204, 255));
        selectcommande.setForeground(new java.awt.Color(51, 78, 172));
        selectcommande.setText("+ selectionner");
        selectcommande.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        selectcommande.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                selectcommandeMouseClicked(evt);
            }
        });
        pfichec.add(selectcommande, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, -1, -1));

        jLabel14.setText("Commande : ");
        pfichec.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, -1, -1));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lidc.setText("id :");
        jPanel9.add(lidc, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        idcommande.setText(".........");
        jPanel9.add(idcommande, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        pfichec.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 50, 160, 30));

        jSeparator12.setForeground(new java.awt.Color(51, 78, 172));
        pfichec.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 80, 160, 10));

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lq.setText("Quantité :");
        jPanel13.add(lq, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        lqte.setText(".........");
        jPanel13.add(lqte, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        pfichec.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 90, 160, 30));

        jSeparator13.setForeground(new java.awt.Color(51, 78, 172));
        pfichec.add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 120, 160, 10));

        jLabel13.setText("Magasin : ");
        pfichec.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 20, -1, -1));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lidm.setText("Id :");
        jPanel11.add(lidm, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        idmagasin1.setText("........");
        jPanel11.add(idmagasin1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        pfichec.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 50, 220, 30));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lnm.setText("Nom :");
        jPanel10.add(lnm, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        nommagasin.setText("........");
        jPanel10.add(nommagasin, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        pfichec.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 90, 220, 30));

        jSeparator14.setForeground(new java.awt.Color(51, 78, 172));
        pfichec.add(jSeparator14, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 120, 220, 10));

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        laddm.setText("Addresse :");
        jPanel14.add(laddm, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        addressemagasin.setText("...................................");
        jPanel14.add(addressemagasin, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        pfichec.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 130, 220, 30));

        jSeparator15.setForeground(new java.awt.Color(51, 78, 172));
        pfichec.add(jSeparator15, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 180, 220, 10));

        jLabel3.setText("DA");
        pfichec.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, -1, -1));

        add(pfichec, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 740, 180));

        tabfactures.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabfactures.setRequestFocusEnabled(false);
        tabfactures.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabfacturesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabfactures);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 740, 270));
    }// </editor-fold>//GEN-END:initComponents

    private void bafficherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bafficherActionPerformed

    }//GEN-LAST:event_bafficherActionPerformed

    private void pmodifierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pmodifierMouseClicked
        if (JOptionPane.showConfirmDialog(this, "voullez vous vraiment modifier ?", "modification",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            boolean vide = false;

// Récupérer les données du formulaire
            Date date = tdate1.getDate();
            String tt = ttotale.getText();
            String vidc = idcommande.getText();

            if (date == null || tt.isEmpty() || vidc.isEmpty()) {
                vide = true;
            }

            if (!vide) {
                // Vérifier si ttotale ne contient que des chiffres
                Pattern pattern = Pattern.compile("\\d+");
                Matcher matcherT = pattern.matcher(tt);

                if (!matcherT.matches()) {
                    JOptionPane.showMessageDialog(null, "La saisie du total n'est pas valide");
                } else {
                    try {
                        ps = co.getCo().prepareStatement("UPDATE factures SET date=?,"
                                + "total=?,id_commande=? WHERE id=?");
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        ps.setString(1, sdf.format(tdate1.getDate()));
                        ps.setInt(2, Integer.parseInt(ttotale.getText()));
                        ps.setInt(3, Integer.parseInt(idcommande.getText()));
                        ps.setInt(4, Integer.parseInt(tabfactures.getValueAt(tabfactures.getSelectedRow(), 0) + ""));
                        ps.execute();
                        JOptionPane.showMessageDialog(this, "Modification faite avec succes");
                        actualiser();
                        reinitialiser();
                    } catch (SQLException ex) {
                        Logger.getLogger(Factures.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Vous devez remplir tous les champs");
            }
        }

    }//GEN-LAST:event_pmodifierMouseClicked

    private void pmodifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pmodifierActionPerformed


    }//GEN-LAST:event_pmodifierActionPerformed

    private void bajouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bajouterActionPerformed

    }//GEN-LAST:event_bajouterActionPerformed

    private void tabfacturesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabfacturesMouseClicked
        afficher(tabfactures.getSelectedRow());
    }//GEN-LAST:event_tabfacturesMouseClicked

    private void ttotaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ttotaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ttotaleActionPerformed

    private void bsuuprimer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsuuprimer1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bsuuprimer1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    }//GEN-LAST:event_jButton1ActionPerformed

    private void brechercheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brechercheActionPerformed

    }//GEN-LAST:event_brechercheActionPerformed

    private void trechercheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trechercheActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_trechercheActionPerformed

    private void trechercheFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_trechercheFocusGained
        actualiser();
        reinitialiser();
    }//GEN-LAST:event_trechercheFocusGained

    private void cmchoixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmchoixActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmchoixActionPerformed

    private void bafficherMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bafficherMouseClicked
        ff.setVisible(true);
        affact(tabfactures.getSelectedRow());


    }//GEN-LAST:event_bafficherMouseClicked

    private void selectcommandeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectcommandeMouseClicked
        lcm.setVisible(true);
    }//GEN-LAST:event_selectcommandeMouseClicked

    private void bajouterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bajouterMouseClicked

        boolean vide = false;

// Récupérer les données du formulaire
        Date date = tdate1.getDate();
        String tt = ttotale.getText();
        String vidc = idcommande.getText();

        if (date == null || tt.isEmpty() || vidc.isEmpty()) {
            vide = true;
        }

        if (!vide) {
            // Vérifier si ttotale ne contient que des chiffres
            Pattern pattern = Pattern.compile("\\d+");
            Matcher matcherT = pattern.matcher(tt);

            if (!matcherT.matches()) {
                JOptionPane.showMessageDialog(null, "La saisie du total n'est pas valide");
            } else {
                try {
                    // Insérer les données dans la base de données
                    PreparedStatement ps = co.getCo().prepareStatement("INSERT INTO factures (date, total, id_commande) VALUES (?, ?, ?)");

                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    ps.setString(1, sdf.format(tdate1.getDate()));
                    ps.setInt(2, Integer.parseInt(tt));
                    ps.setInt(3, Integer.parseInt(vidc));
                    ps.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Facture ajoutée avec succès");
                    reinitialiser();
                    actualiser();
                } catch (SQLException ex) {
                    Logger.getLogger(Factures.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "Erreur lors de l'ajout de la facture : " + ex.getMessage());
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Vous devez remplir tous les champs");
        }
    }//GEN-LAST:event_bajouterMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        reinitialiser();
        actualiser();
    }//GEN-LAST:event_jButton1MouseClicked

    private void bsuuprimer1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bsuuprimer1MouseClicked
        if (JOptionPane.showConfirmDialog(this, "voulez vous vraiment supprimer ?", "suppression", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            try {
                stat = co.getCo().createStatement();
                stat.executeUpdate("DELETE FROM factures WHERE id='" + tabfactures.getValueAt(tabfactures.getSelectedRow(), 0) + "'");
                JOptionPane.showMessageDialog(this, "suppression faite avec succes");
                actualiser();

                reinitialiser();
            } catch (SQLException ex) {
                Logger.getLogger(Livraisons.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_bsuuprimer1MouseClicked

    private void brechercheMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_brechercheMouseClicked
        String s;
        s = cmchoix.getSelectedItem().toString();
        try {

            ps = co.getCo().prepareStatement("SELECT * FROM factures WHERE " + s + "=?");
            ps.setInt(1, Integer.parseInt(trecherche.getText()));

            rs = ps.executeQuery();
            dtm.setRowCount(0);
            while (rs.next()) {
                dtm.addRow(new Object[]{rs.getInt("id"), rs.getDate("date"), rs.getInt("total"), rs.getInt("id_commande")});

            }
            tabfactures.setModel(dtm);
            if (dtm.getRowCount() != 0) {
                afficher(0);
            } else {
                actualiser();
                JOptionPane.showMessageDialog(this, "facture n'existe pas");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Factures.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_brechercheMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel addressemagasin;
    private javax.swing.JButton bafficher;
    public javax.swing.JButton bajouter;
    private javax.swing.JButton brecherche;
    private javax.swing.JButton bsuuprimer1;
    private javax.swing.JComboBox<String> cmchoix;
    public static javax.swing.JLabel idcommande;
    public static javax.swing.JLabel idmagasin1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    public static javax.swing.JLabel laddm;
    public static javax.swing.JLabel lidc;
    public static javax.swing.JLabel lidm;
    public static javax.swing.JLabel lnm;
    public static javax.swing.JLabel lq;
    public static javax.swing.JLabel lqte;
    public static javax.swing.JLabel nommagasin;
    private javax.swing.JPanel pfichec;
    private javax.swing.JButton pmodifier;
    private javax.swing.JLabel selectcommande;
    public static javax.swing.JTable tabfactures;
    public com.toedter.calendar.JDateChooser tdate1;
    private javax.swing.JLabel tnumero;
    private javax.swing.JTextField trecherche;
    public static javax.swing.JTextField ttotale;
    // End of variables declaration//GEN-END:variables
}
