/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Model.ConnetCommandeSm;
import Model.Connexion;
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
import javax.swing.text.html.HTML;

/**
 *
 * @author toshiba
 */
public class Commande extends javax.swing.JPanel {

    ListeDesClientss lc = new ListeDesClientss();
    ListeDesModeles lm = new ListeDesModeles();
    ListeDesMagasins lmg = new ListeDesMagasins();
    ListeDesModeless lmm = new ListeDesModeless();
    ConnetCommandeSm cs = new ConnetCommandeSm();
    PreparedStatement ps;
    Connexion co = new Connexion();
    DefaultTableModel dtm = new DefaultTableModel();
    DefaultTableModel dtm2 = new DefaultTableModel();
    Statement stat;
    ResultSet rs;

    /**
     * Creates new form Commande
     */
    public Commande() {
        initComponents();
        reinitialiserSM();
        pcmpa.setVisible(false);
        actualiserSM();
        actualiserPA();
        reinitialiserPA();
    }

    public void afficherSM(int nligne) {
        tdate.setDate((Date) tabcommandeSm.getValueAt(nligne, 1));
        tclientId.setText(tabcommandeSm.getValueAt(nligne, 2).toString());
        jmi.setText(tabcommandeSm.getValueAt(nligne, 3).toString());
        tcouleur.setText(tabcommandeSm.getValueAt(nligne, 4).toString());
        cmetat.setSelectedItem(tabcommandeSm.getValueAt(nligne, 5).toString());
        tclientId.setVisible(true);
        jmi.setVisible(true);
        lcid.setVisible(true);
        jLmi.setVisible(true);

        try {
            stat = co.getCo().createStatement();
            rs = stat.executeQuery("SELECT nom,prenom FROM clients WHERE id=" + Integer.parseInt(tabcommandeSm.getValueAt(nligne, 2).toString()));

            if (rs.next()) {

                // Si le ResultSet contient des lignes, récupérez les données
                tnom.setText(rs.getString("nom"));
                tprenom.setText(rs.getString("prenom"));
                tnom.setVisible(true);
                tprenom.setVisible(true);
                lcnom.setVisible(true);
                lcprenom.setVisible(true);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Commande.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            stat = co.getCo().createStatement();
            rs = stat.executeQuery("select nom from modeles where id=" + Integer.parseInt(tabcommandeSm.getValueAt(nligne, 3).toString()));

            if (rs.next()) {

                // Si le ResultSet contient des lignes, récupérez les données
                jmn.setText(rs.getString("nom"));
                jLmi.setVisible(true);
                jmn.setVisible(true);
                jlmn.setVisible(true);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Commande.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void afficherPA(int nligne) {
        tdate1.setDate((Date) tabcommandePa.getValueAt(nligne, 1));
        tidmagasin.setText(tabcommandePa.getValueAt(nligne, 2).toString());
        idmodele.setText(tabcommandePa.getValueAt(nligne, 3).toString());
        tqte.setText(tabcommandePa.getValueAt(nligne, 4).toString());
        cmetat1.setSelectedItem(tabcommandePa.getValueAt(nligne, 5).toString());
        idmodele.setVisible(true);
        tidmagasin.setVisible(true);

        try {
            stat = co.getCo().createStatement();
            rs = stat.executeQuery("SELECT nom FROM magasin WHERE id=" + Integer.parseInt(tabcommandePa.getValueAt(nligne, 2).toString()));

            if (rs.next()) {

                // Si le ResultSet contient des lignes, récupérez les données
                tnommagasin.setText(rs.getString("nom"));
                tnommagasin.setVisible(true);
                jLmi2.setVisible(true);
                jlmn2.setVisible(true);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Commande.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            stat = co.getCo().createStatement();
            rs = stat.executeQuery("select nom from modeles where id=" + Integer.parseInt(tabcommandePa.getValueAt(nligne, 3).toString()));

            if (rs.next()) {

                // Si le ResultSet contient des lignes, récupérez les données
                nommodele.setText(rs.getString("nom"));
                nommodele.setVisible(true);
                jLmi1.setVisible(true);
                jlmn1.setVisible(true);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Commande.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void reinitialiserSM() {
        tdate.setDate(null);
        lcid.setVisible(false);
        lcnom.setVisible(false);
        lcprenom.setVisible(false);
        tclientId.setText("");
        tnom.setVisible(false);
        tprenom.setVisible(false);
        tcouleur.setText(null);
        cmetat.setSelectedItem("Nouvelle");
        jLmi.setVisible(false);
        jlmn.setVisible(false);
        jmi.setText("");
        jmn.setVisible(false);
        bmodifier.setVisible(false);
        bsupprimer.setVisible(false);
        errC.setVisible(false);
    }

    public void reinitialiserPA() {
        tdate1.setDate(null);
        tqte.setText(null);
        cmetat1.setSelectedItem("Nouvelle");
        bmodifier1.setVisible(false);
        bsupprimer1.setVisible(false);
        tidmagasin.setText("");
        tnommagasin.setVisible(false);
        idmodele.setText("");
        nommodele.setVisible(false);
        jLmi1.setVisible(false);
        jLmi2.setVisible(false);
        jlmn1.setVisible(false);
        jlmn2.setVisible(false);
        errq.setVisible(false);
    }

    public void actualiserSM() {
        //vider la table
        dtm.setColumnCount(0);
        dtm.setRowCount(0);
        try {
            stat = co.getCo().createStatement();
            rs = stat.executeQuery("select * from commandes_sm");
            dtm.addColumn("numero");
            dtm.addColumn("date");
            dtm.addColumn("id_client");
            dtm.addColumn("id_model");
            dtm.addColumn("couleur");
            dtm.addColumn("état");

            while (rs.next()) {
                dtm.addRow(new Object[]{
                    rs.getInt("id"), rs.getDate("date"), rs.getInt("id_client"), rs.getInt("id_modele"),
                    rs.getString("couleur"), rs.getString("etat")
                });
            }
            tabcommandeSm.setModel(dtm);
        } catch (SQLException ex) {
            Logger.getLogger(Commande.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void actualiserPA() {
        //vider la table
        dtm2.setColumnCount(0);
        dtm2.setRowCount(0);
        try {
            stat = co.getCo().createStatement();
            rs = stat.executeQuery("select * from commandes_pa");
            dtm2.addColumn("numero");
            dtm2.addColumn("date");
            dtm2.addColumn("id_magasin");
            dtm2.addColumn("id_model");
            dtm2.addColumn("quantité");
            dtm2.addColumn("état");

            while (rs.next()) {
                dtm2.addRow(new Object[]{
                    rs.getInt("id"), rs.getDate("date"), rs.getInt("magasin"), rs.getInt("id_modele"),
                    rs.getString("quentite"), rs.getString("etat")
                });
            }
            tabcommandePa.setModel(dtm2);
        } catch (SQLException ex) {
            Logger.getLogger(Commande.class.getName()).log(Level.SEVERE, null, ex);
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

        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        pcmpa = new javax.swing.JPanel();
        pcommandeSm1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        tdate1 = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        selectmagasin = new javax.swing.JLabel();
        jLmi1 = new javax.swing.JLabel();
        jlmn1 = new javax.swing.JLabel();
        idmodele = new javax.swing.JLabel();
        nommodele = new javax.swing.JLabel();
        bajouter1 = new javax.swing.JButton();
        bmodifier1 = new javax.swing.JButton();
        bsupprimer1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jSeparator10 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
        jSeparator15 = new javax.swing.JSeparator();
        jSeparator16 = new javax.swing.JSeparator();
        jSeparator17 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        selectmodele2 = new javax.swing.JLabel();
        jSeparator18 = new javax.swing.JSeparator();
        tqte = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        tidmagasin = new javax.swing.JLabel();
        jLmi2 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jSeparator12 = new javax.swing.JSeparator();
        cmetat1 = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        tnommagasin = new javax.swing.JLabel();
        jlmn2 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jSeparator13 = new javax.swing.JSeparator();
        jButton6 = new javax.swing.JButton();
        errq = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabcommandePa = new javax.swing.JTable();
        panelcms = new javax.swing.JPanel();
        pcommandeSm = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        tdate = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        selectmodele = new javax.swing.JLabel();
        jLmi = new javax.swing.JLabel();
        jlmn = new javax.swing.JLabel();
        jmi = new javax.swing.JLabel();
        jmn = new javax.swing.JLabel();
        bajouter = new javax.swing.JButton();
        bmodifier = new javax.swing.JButton();
        bsupprimer = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        cmetat = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        selectclient = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        pid = new javax.swing.JPanel();
        tclientId = new javax.swing.JLabel();
        lcid = new javax.swing.JLabel();
        pnom = new javax.swing.JPanel();
        tnom = new javax.swing.JLabel();
        lcnom = new javax.swing.JLabel();
        pprenom = new javax.swing.JPanel();
        tprenom = new javax.swing.JLabel();
        lcprenom = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        errC = new javax.swing.JLabel();
        tcouleur = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabcommandeSm = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        bpa = new javax.swing.JButton();
        bms = new javax.swing.JButton();
        trecherche = new javax.swing.JTextField();
        cmchoix = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        brecherche = new javax.swing.JButton();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pcmpa.setBackground(new java.awt.Color(255, 255, 255));
        pcmpa.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pcommandeSm1.setBackground(new java.awt.Color(208, 227, 255));
        pcommandeSm1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(208, 227, 255), null));
        pcommandeSm1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setText("état :");
        pcommandeSm1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));
        pcommandeSm1.add(tdate1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 210, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 78, 172));
        jLabel7.setText("Commandes pret a porté");
        pcommandeSm1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel9.setText("Modele :");
        pcommandeSm1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 40, -1, -1));

        selectmagasin.setBackground(new java.awt.Color(204, 204, 255));
        selectmagasin.setForeground(new java.awt.Color(51, 78, 172));
        selectmagasin.setText("+ selectionner");
        selectmagasin.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        selectmagasin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                selectmagasinMouseClicked(evt);
            }
        });
        pcommandeSm1.add(selectmagasin, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 40, -1, -1));

        jLmi1.setText("Id :");
        pcommandeSm1.add(jLmi1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 90, -1, -1));

        jlmn1.setText("Nom :");
        pcommandeSm1.add(jlmn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 130, -1, -1));

        idmodele.setText("............");
        pcommandeSm1.add(idmodele, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 90, -1, -1));

        nommodele.setText("..........");
        pcommandeSm1.add(nommodele, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 130, -1, -1));

        bajouter1.setBackground(new java.awt.Color(51, 78, 172));
        bajouter1.setForeground(new java.awt.Color(255, 255, 255));
        bajouter1.setText("Ajouter");
        bajouter1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bajouter1MouseClicked(evt);
            }
        });
        pcommandeSm1.add(bajouter1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        bmodifier1.setBackground(new java.awt.Color(51, 78, 172));
        bmodifier1.setForeground(new java.awt.Color(255, 255, 255));
        bmodifier1.setText("Modifier");
        bmodifier1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bmodifier1MouseClicked(evt);
            }
        });
        bmodifier1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bmodifier1ActionPerformed(evt);
            }
        });
        pcommandeSm1.add(bmodifier1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, -1, -1));

        bsupprimer1.setBackground(new java.awt.Color(51, 78, 172));
        bsupprimer1.setForeground(new java.awt.Color(255, 255, 255));
        bsupprimer1.setText("Supprimer");
        bsupprimer1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bsupprimer1MouseClicked(evt);
            }
        });
        bsupprimer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsupprimer1ActionPerformed(evt);
            }
        });
        pcommandeSm1.add(bsupprimer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, -1, -1));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        pcommandeSm1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 80, 160, 30));

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        pcommandeSm1.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 120, 160, 30));

        jSeparator10.setForeground(new java.awt.Color(51, 78, 172));
        pcommandeSm1.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 150, 160, 10));

        jSeparator11.setForeground(new java.awt.Color(51, 78, 172));
        pcommandeSm1.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 110, 160, 10));
        pcommandeSm1.add(jSeparator15, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 50, 70, 10));
        pcommandeSm1.add(jSeparator16, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, -1, -1));
        pcommandeSm1.add(jSeparator17, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 60, -1, -1));

        jLabel10.setText("Magasins : ");
        pcommandeSm1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 40, -1, -1));

        selectmodele2.setBackground(new java.awt.Color(204, 204, 255));
        selectmodele2.setForeground(new java.awt.Color(51, 78, 172));
        selectmodele2.setText("+ selectionner");
        selectmodele2.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        selectmodele2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                selectmodele2MouseClicked(evt);
            }
        });
        pcommandeSm1.add(selectmodele2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 40, -1, -1));
        pcommandeSm1.add(jSeparator18, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 50, 70, 10));

        tqte.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tqteFocusGained(evt);
            }
        });
        pcommandeSm1.add(tqte, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 210, 30));

        jLabel12.setText("date :");
        pcommandeSm1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        tidmagasin.setText("............");
        pcommandeSm1.add(tidmagasin, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 90, -1, -1));

        jLmi2.setText("Id :");
        pcommandeSm1.add(jLmi2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, -1, -1));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        pcommandeSm1.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 80, 160, 30));

        jSeparator12.setForeground(new java.awt.Color(51, 78, 172));
        pcommandeSm1.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 110, 160, 10));

        cmetat1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nouvelle", "En cours de traitement", "Terminée", "Expédiée" }));
        pcommandeSm1.add(cmetat1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 210, -1));

        jLabel13.setText("Quantité :");
        pcommandeSm1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        tnommagasin.setText("..........");
        pcommandeSm1.add(tnommagasin, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 130, -1, -1));

        jlmn2.setText("Nom :");
        pcommandeSm1.add(jlmn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, -1, -1));

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        pcommandeSm1.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 120, 160, 30));

        jSeparator13.setForeground(new java.awt.Color(51, 78, 172));
        pcommandeSm1.add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 150, 160, 10));

        jButton6.setBackground(new java.awt.Color(51, 78, 172));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ihm/refresh_3_fill.png"))); // NOI18N
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton6MouseClicked(evt);
            }
        });
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        pcommandeSm1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 10, 50, 30));

        errq.setForeground(new java.awt.Color(255, 0, 0));
        errq.setText("La saisie de la quentité n'est pas valide");
        pcommandeSm1.add(errq, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 104, -1, 20));

        pcmpa.add(pcommandeSm1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 730, 200));

        tabcommandePa.setModel(new javax.swing.table.DefaultTableModel(
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
        tabcommandePa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabcommandePaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabcommandePa);

        pcmpa.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 730, 220));

        jPanel1.add(pcmpa, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 80, 790, 390));

        panelcms.setBackground(new java.awt.Color(255, 255, 255));
        panelcms.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pcommandeSm.setBackground(new java.awt.Color(208, 227, 255));
        pcommandeSm.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(208, 227, 255), null));
        pcommandeSm.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("date :");
        pcommandeSm.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));
        pcommandeSm.add(tdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 210, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 78, 172));
        jLabel3.setText("Commandes sur mesures");
        pcommandeSm.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel5.setText("Modele :");
        pcommandeSm.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 50, -1, -1));

        selectmodele.setBackground(new java.awt.Color(204, 204, 255));
        selectmodele.setForeground(new java.awt.Color(51, 78, 172));
        selectmodele.setText("+ selectionner");
        selectmodele.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        selectmodele.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                selectmodeleMouseClicked(evt);
            }
        });
        pcommandeSm.add(selectmodele, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 50, -1, -1));

        jLmi.setText("Id :");
        pcommandeSm.add(jLmi, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 100, -1, -1));

        jlmn.setText("Nom :");
        pcommandeSm.add(jlmn, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 140, -1, -1));

        jmi.setText("............");
        pcommandeSm.add(jmi, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 100, -1, -1));

        jmn.setText("..........");
        pcommandeSm.add(jmn, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 140, -1, -1));

        bajouter.setBackground(new java.awt.Color(51, 78, 172));
        bajouter.setForeground(new java.awt.Color(255, 255, 255));
        bajouter.setText("Ajouter");
        bajouter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bajouterMouseClicked(evt);
            }
        });
        pcommandeSm.add(bajouter, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        bmodifier.setBackground(new java.awt.Color(51, 78, 172));
        bmodifier.setForeground(new java.awt.Color(255, 255, 255));
        bmodifier.setText("Modifier");
        bmodifier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bmodifierMouseClicked(evt);
            }
        });
        bmodifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bmodifierActionPerformed(evt);
            }
        });
        pcommandeSm.add(bmodifier, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, -1, -1));

        bsupprimer.setBackground(new java.awt.Color(51, 78, 172));
        bsupprimer.setForeground(new java.awt.Color(255, 255, 255));
        bsupprimer.setText("Supprimer");
        bsupprimer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bsupprimerMouseClicked(evt);
            }
        });
        bsupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsupprimerActionPerformed(evt);
            }
        });
        pcommandeSm.add(bsupprimer, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        pcommandeSm.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 90, 160, 30));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        pcommandeSm.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 130, 160, 30));

        jSeparator1.setForeground(new java.awt.Color(51, 78, 172));
        pcommandeSm.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 160, 160, -1));

        jSeparator2.setForeground(new java.awt.Color(51, 78, 172));
        pcommandeSm.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 120, 160, -1));
        pcommandeSm.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 60, 70, 10));
        pcommandeSm.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, -1, -1));
        pcommandeSm.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 60, -1, -1));

        cmetat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nouvelle", "En cours de traitement", "Terminée", "Expédiée" }));
        cmetat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmetatActionPerformed(evt);
            }
        });
        pcommandeSm.add(cmetat, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, 210, 30));

        jLabel14.setText("état :");
        pcommandeSm.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        selectclient.setBackground(new java.awt.Color(204, 204, 255));
        selectclient.setForeground(new java.awt.Color(51, 78, 172));
        selectclient.setText("+ selectionner");
        selectclient.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        selectclient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                selectclientMouseClicked(evt);
            }
        });
        pcommandeSm.add(selectclient, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, -1, -1));

        jLabel4.setText("Client :");
        pcommandeSm.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 50, -1, -1));

        pid.setBackground(new java.awt.Color(255, 255, 255));
        pid.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tclientId.setText("............");
        pid.add(tclientId, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 5, -1, -1));

        lcid.setText("Id :");
        pid.add(lcid, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        pcommandeSm.add(pid, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 90, 150, 30));

        pnom.setBackground(new java.awt.Color(255, 255, 255));
        pnom.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tnom.setText("............");
        pnom.add(tnom, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 5, -1, -1));

        lcnom.setText("nom :");
        pnom.add(lcnom, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        pcommandeSm.add(pnom, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 130, 150, 30));

        pprenom.setBackground(new java.awt.Color(255, 255, 255));
        pprenom.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tprenom.setText("............");
        pprenom.add(tprenom, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 60, -1));

        lcprenom.setText("Prenom :");
        pprenom.add(lcprenom, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 10, 50, -1));

        pcommandeSm.add(pprenom, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 170, 150, 30));

        jLabel15.setText("couleur :");
        pcommandeSm.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jSeparator3.setForeground(new java.awt.Color(51, 78, 172));
        pcommandeSm.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 200, 150, 10));

        jSeparator4.setForeground(new java.awt.Color(51, 78, 172));
        pcommandeSm.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 120, 150, 10));

        jSeparator5.setForeground(new java.awt.Color(51, 78, 172));
        pcommandeSm.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 160, 150, 10));

        errC.setForeground(new java.awt.Color(255, 0, 0));
        errC.setText("La saisie de la couleur n'est pas valide");
        pcommandeSm.add(errC, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, -1, 20));

        tcouleur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tcouleurActionPerformed(evt);
            }
        });
        tcouleur.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tcouleurFocusGained(evt);
            }
        });
        pcommandeSm.add(tcouleur, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 210, 30));

        jButton5.setBackground(new java.awt.Color(51, 78, 172));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ihm/refresh_3_fill.png"))); // NOI18N
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        pcommandeSm.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 10, 50, 30));

        panelcms.add(pcommandeSm, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 730, 220));

        tabcommandeSm.setModel(new javax.swing.table.DefaultTableModel(
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
        tabcommandeSm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabcommandeSmMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabcommandeSm);

        panelcms.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 730, 230));

        jPanel1.add(panelcms, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 80, 780, 530));

        jPanel8.setBackground(new java.awt.Color(185, 228, 245));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Commandes");
        jPanel8.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ihm/commandes.jpg"))); // NOI18N
        jPanel8.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 70));

        bpa.setBackground(new java.awt.Color(51, 78, 172));
        bpa.setForeground(new java.awt.Color(255, 255, 255));
        bpa.setText("Pret a porté");
        bpa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bpaMouseClicked(evt);
            }
        });
        jPanel8.add(bpa, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, -1, -1));

        bms.setBackground(new java.awt.Color(51, 78, 172));
        bms.setForeground(new java.awt.Color(255, 255, 255));
        bms.setText("Sur mesures");
        bms.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bmsMouseClicked(evt);
            }
        });
        jPanel8.add(bms, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, -1, -1));

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
        jPanel8.add(trecherche, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 20, 120, 30));

        cmchoix.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "numero ", "nom" }));
        cmchoix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmchoixActionPerformed(evt);
            }
        });
        jPanel8.add(cmchoix, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 20, -1, 30));

        jLabel11.setText("recherche par ");
        jPanel8.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 30, -1, -1));

        brecherche.setBackground(new java.awt.Color(51, 78, 172));
        brecherche.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ihm/search_2_fill (1).png"))); // NOI18N
        brecherche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brechercheActionPerformed(evt);
            }
        });
        jPanel8.add(brecherche, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 20, -1, 30));

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 70));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 550));
    }// </editor-fold>//GEN-END:initComponents

    private void tabcommandeSmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabcommandeSmMouseClicked
        afficherSM(tabcommandeSm.getSelectedRow());
        bmodifier.setVisible(true);
        bsupprimer.setVisible(true);
         errC.setVisible(false);


    }//GEN-LAST:event_tabcommandeSmMouseClicked

    private void bpaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bpaMouseClicked
        panelcms.setVisible(false);
        pcmpa.setVisible(true);


    }//GEN-LAST:event_bpaMouseClicked

    private void bmsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bmsMouseClicked
        pcmpa.setVisible(false);
        panelcms.setVisible(true);


    }//GEN-LAST:event_bmsMouseClicked

    private void trechercheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trechercheActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_trechercheActionPerformed

    private void trechercheFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_trechercheFocusGained

    }//GEN-LAST:event_trechercheFocusGained

    private void cmchoixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmchoixActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmchoixActionPerformed

    private void brechercheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brechercheActionPerformed

    }//GEN-LAST:event_brechercheActionPerformed

    private void tabcommandePaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabcommandePaMouseClicked
        afficherPA(tabcommandePa.getSelectedRow());
        bmodifier1.setVisible(true);
        bsupprimer1.setVisible(true);
        errq.setVisible(false);
    }//GEN-LAST:event_tabcommandePaMouseClicked

    private void bsupprimer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsupprimer1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bsupprimer1ActionPerformed

    private void bsupprimer1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bsupprimer1MouseClicked
        if (JOptionPane.showConfirmDialog(this, "voulez vous vraiment supprimer ?", "suppression", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            try {
                stat = co.getCo().createStatement();
                stat.executeUpdate("DELETE FROM factures WHERE id_commande='" + tabcommandePa.getValueAt(tabcommandePa.getSelectedRow(), 0) + "'");
                stat = co.getCo().createStatement();
                stat.executeUpdate("DELETE FROM commandes_pa WHERE id='" + tabcommandePa.getValueAt(tabcommandePa.getSelectedRow(), 0) + "'");
                JOptionPane.showMessageDialog(this, "suppression faite avec succes");
                actualiserPA();
                reinitialiserPA();
            } catch (SQLException ex) {
                Logger.getLogger(Commande.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_bsupprimer1MouseClicked

    private void bmodifier1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bmodifier1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bmodifier1ActionPerformed

    private void bmodifier1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bmodifier1MouseClicked
        if (JOptionPane.showConfirmDialog(this, "voullez vous vraiment modifier ?", "modification",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            boolean vide = false;

            // recuperer les donnees du formulaire
            Date date = tdate1.getDate();
            String q = tqte.getText();
            String idmg = tidmagasin.getText();
            String idmo = idmodele.getText();

            if (date == null || q.equals("") || idmg.equals("") || idmo.equals("")) {
                vide = true;
            }

            if (vide == false) {

                Pattern pattern = Pattern.compile("[^0-9]");
                Matcher matcherQ = pattern.matcher(q);

                if (matcherQ.find()) {

                    errq.setVisible(true);
                } else {
                    try {
                        ps = co.getCo().prepareStatement("UPDATE commandes_pa SET date=?,"
                                + "magasin=?,id_modele=?,quentite=?,etat=? WHERE id=?");
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        ps.setString(1, sdf.format(tdate1.getDate()));
                        ps.setString(2, tidmagasin.getText());

                        ps.setString(3, idmodele.getText());
                        ps.setString(4, tqte.getText());
                        ps.setString(5, cmetat1.getSelectedItem().toString());
                        ps.setInt(6, Integer.parseInt(tabcommandePa.getValueAt(tabcommandePa.getSelectedRow(), 0) + ""));
                        ps.execute();
                        JOptionPane.showMessageDialog(this, "Modification faite avec succes");
                        actualiserPA();
                        reinitialiserPA();
                    } catch (SQLException ex) {
                        Logger.getLogger(Commande.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            } else {
                JOptionPane.showMessageDialog(null, "Vous devez remplir tous les champs");
            }
        }

    }//GEN-LAST:event_bmodifier1MouseClicked

    private void bajouter1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bajouter1MouseClicked

        boolean vide = false;

        // recuperer les donnees du formulaire
        Date date = tdate1.getDate();
        String q = tqte.getText();
        String idmg = tidmagasin.getText();
        String idmo = idmodele.getText();

        if (date == null || q.equals("") || idmg.equals("") || idmo.equals("")) {
            vide = true;
        }

        if (vide == false) {

            Pattern pattern = Pattern.compile("[^0-9]");
            Matcher matcherQ = pattern.matcher(q);

            if (matcherQ.find()) {

                errq.setVisible(true);
            } else {

                try {
                    ps = co.getCo().prepareStatement("INSERT INTO commandes_pa (date,magasin,id_modele,quentite,etat) VALUES(?,?,?,?,?)");

                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    ps.setString(1, sdf.format(tdate1.getDate()));
                    ps.setInt(2, Integer.parseInt(tidmagasin.getText()));
                    ps.setInt(3, Integer.parseInt(idmodele.getText()));
                    ps.setInt(4, Integer.parseInt(tqte.getText()));
                    ps.setString(5, cmetat1.getSelectedItem().toString());
                    ps.execute();
                    JOptionPane.showMessageDialog(null, "Commande ajouté avec succès");
                    reinitialiserPA();
                    actualiserPA();
                } catch (SQLException ex) {
                    Logger.getLogger(Commande.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } else {
            JOptionPane.showMessageDialog(null, "Vous devez remplir tous les champs");
        }
    }//GEN-LAST:event_bajouter1MouseClicked

    private void selectmagasinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectmagasinMouseClicked
        lmg.setVisible(true);
    }//GEN-LAST:event_selectmagasinMouseClicked

    private void selectmodele2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectmodele2MouseClicked
        lmm.setVisible(true);
        lmm.actualiser();
    }//GEN-LAST:event_selectmodele2MouseClicked

    private void bsupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsupprimerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bsupprimerActionPerformed

    private void bsupprimerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bsupprimerMouseClicked
        if (JOptionPane.showConfirmDialog(this, "voulez vous vraiment supprimer ?", "suppression", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            try {
                stat = co.getCo().createStatement();
                stat.executeUpdate("DELETE FROM seances_dessayage WHERE id_commande='" + tabcommandeSm.getValueAt(tabcommandeSm.getSelectedRow(), 0) + "'");
                stat = co.getCo().createStatement();
                stat.executeUpdate("DELETE FROM commandes_sm WHERE id='" + tabcommandeSm.getValueAt(tabcommandeSm.getSelectedRow(), 0) + "'");
                JOptionPane.showMessageDialog(this, "suppression faite avec succes");
                actualiserSM();

                reinitialiserSM();
            } catch (SQLException ex) {
                Logger.getLogger(Clients.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_bsupprimerMouseClicked

    private void bmodifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bmodifierActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bmodifierActionPerformed

    private void bmodifierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bmodifierMouseClicked
        if (JOptionPane.showConfirmDialog(this, "voullez vous vraiment modifier ?", "modification",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
               boolean vide = false;

        // recuperer les donnees du formulaire
        Date date = tdate.getDate();
        String q = tcouleur.getText();
        String idc = tclientId.getText();
        String idmo = jmi.getText();

        if (date == null || q.equals("") || idc.equals("") || idmo.equals("")) {
            vide = true;
        }

        if (vide == false) {

            Pattern pattern = Pattern.compile("[^a-zA-Z]");
            Matcher matcherQ = pattern.matcher(q);

            if (matcherQ.find()) {

                errC.setVisible(true);
            } else {
              try {
                ps = co.getCo().prepareStatement("UPDATE commandes_sm SET date=?,"
                        + "id_client=?,id_modele=?,couleur=?,etat=? WHERE id=?");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                ps.setString(1, sdf.format(tdate.getDate()));
                ps.setString(2, tclientId.getText());

                ps.setString(3, jmi.getText());
                ps.setString(4, tcouleur.getText());
                ps.setString(5, cmetat.getSelectedItem().toString());
                ps.setInt(6, Integer.parseInt(tabcommandeSm.getValueAt(tabcommandeSm.getSelectedRow(), 0) + ""));
                ps.execute();
                JOptionPane.showMessageDialog(this, "Modification faite avec succes");
                actualiserSM();
                reinitialiserSM();
            } catch (SQLException ex) {
                Logger.getLogger(Commande.class.getName()).log(Level.SEVERE, null, ex);
            }
            }

        } else {
            JOptionPane.showMessageDialog(null, "Vous devez remplir tous les champs");
        }
        }
      
    }//GEN-LAST:event_bmodifierMouseClicked

    private void bajouterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bajouterMouseClicked

        boolean vide = false;

        // recuperer les donnees du formulaire
        Date date = tdate.getDate();
        String q = tcouleur.getText();
        String idc = tclientId.getText();
        String idmo = jmi.getText();

        if (date == null || q.equals("") || idc.equals("") || idmo.equals("")) {
            vide = true;
        }

        if (vide == false) {

            Pattern pattern = Pattern.compile("[^a-zA-Z]");
            Matcher matcherQ = pattern.matcher(q);

            if (matcherQ.find()) {

                errC.setVisible(true);
            } else {
                try {
                    ps = co.getCo().prepareStatement("INSERT INTO commandes_sm (date,id_client,id_modele,couleur,etat) VALUES(?,?,?,?,?)");

                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    ps.setString(1, sdf.format(tdate.getDate()));
                    ps.setInt(2, Integer.parseInt(tclientId.getText()));
                    ps.setInt(3, Integer.parseInt(jmi.getText()));
                    ps.setString(4, tcouleur.getText());
                    ps.setString(5, cmetat.getSelectedItem().toString());
                    ps.execute();
                    JOptionPane.showMessageDialog(null, "Commande ajouté avec succès");
                    reinitialiserSM();
                    actualiserSM();
                } catch (SQLException ex) {
                    Logger.getLogger(Commande.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } else {
            JOptionPane.showMessageDialog(null, "Vous devez remplir tous les champs");
        }
    }//GEN-LAST:event_bajouterMouseClicked

    private void selectmodeleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectmodeleMouseClicked
        lm.setVisible(true);
        lm.actualiser();
    }//GEN-LAST:event_selectmodeleMouseClicked

    private void selectclientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectclientMouseClicked
        lc.setVisible(true);
    }//GEN-LAST:event_selectclientMouseClicked

    private void cmetatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmetatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmetatActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        actualiserSM();
        reinitialiserSM();

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5MouseClicked

    private void jButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseClicked
        actualiserPA();
        reinitialiserPA();
    }//GEN-LAST:event_jButton6MouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void tqteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tqteFocusGained
        errq.setVisible(false);
    }//GEN-LAST:event_tqteFocusGained

    private void tcouleurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tcouleurActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tcouleurActionPerformed

    private void tcouleurFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tcouleurFocusGained
        errC.setVisible(false);
    }//GEN-LAST:event_tcouleurFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bajouter;
    private javax.swing.JButton bajouter1;
    private javax.swing.JButton bmodifier;
    private javax.swing.JButton bmodifier1;
    private javax.swing.JButton bms;
    private javax.swing.JButton bpa;
    private javax.swing.JButton brecherche;
    private javax.swing.JButton bsupprimer;
    private javax.swing.JButton bsupprimer1;
    private javax.swing.JComboBox<String> cmchoix;
    private javax.swing.JComboBox<String> cmetat;
    private javax.swing.JComboBox<String> cmetat1;
    private javax.swing.JLabel errC;
    private javax.swing.JLabel errq;
    public static javax.swing.JLabel idmodele;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public static javax.swing.JLabel jLmi;
    public static javax.swing.JLabel jLmi1;
    public static javax.swing.JLabel jLmi2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator17;
    private javax.swing.JSeparator jSeparator18;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    public static javax.swing.JLabel jlmn;
    public static javax.swing.JLabel jlmn1;
    public static javax.swing.JLabel jlmn2;
    public static javax.swing.JLabel jmi;
    public static javax.swing.JLabel jmn;
    public static javax.swing.JLabel lcid;
    public static javax.swing.JLabel lcnom;
    public static javax.swing.JLabel lcprenom;
    public static javax.swing.JLabel nommodele;
    private javax.swing.JPanel panelcms;
    private javax.swing.JPanel pcmpa;
    private javax.swing.JPanel pcommandeSm;
    private javax.swing.JPanel pcommandeSm1;
    public static javax.swing.JPanel pid;
    private javax.swing.JPanel pnom;
    private javax.swing.JPanel pprenom;
    private javax.swing.JLabel selectclient;
    private javax.swing.JLabel selectmagasin;
    private javax.swing.JLabel selectmodele;
    private javax.swing.JLabel selectmodele2;
    private javax.swing.JTable tabcommandePa;
    private javax.swing.JTable tabcommandeSm;
    public static javax.swing.JLabel tclientId;
    private javax.swing.JTextField tcouleur;
    public com.toedter.calendar.JDateChooser tdate;
    public com.toedter.calendar.JDateChooser tdate1;
    public static javax.swing.JLabel tidmagasin;
    public static javax.swing.JLabel tnom;
    public static javax.swing.JLabel tnommagasin;
    public static javax.swing.JLabel tprenom;
    private javax.swing.JTextField tqte;
    private javax.swing.JTextField trecherche;
    // End of variables declaration//GEN-END:variables
}
