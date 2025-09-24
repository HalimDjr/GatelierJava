/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;
import Vue.*;

import Model.Connexion;
import static Vue.Dashboard.tabdpan;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;


/**
 *
 * @author toshiba
 */
public class Accueil extends javax.swing.JPanel {

        
   Connexion c = new Connexion();
    Statement stat;
    Statement stat1;
    PreparedStatement prestate;
    ResultSet rs;
    ResultSet rs1;
  
    String ch = "BIENVENUE DANS MON APPLLICATION  ";
    public Accueil() {
        initComponents();
        
        nbemployes();
        nbclients();
         nbModeles();
         nbFactures();
         nbCommandes();
         nbLivraisons();
         
   
    }
    public void nbemployes(){
          try {
    stat = c.getCo().createStatement();
    rs = stat.executeQuery("select count(id) as nbe from employes");
    
    // Vérifier s'il y a des résultats
    if (rs.next()) {
        // Récupérer le nombre d'employés et le mettre dans le JLabel
        int nombreEmployes = rs.getInt("nbe");
        nbemployes.setText(String.valueOf(nombreEmployes));
    } else {
        // Aucun résultat trouvé
        nbemployes.setText("00");
    }
} catch (SQLException ex) {
    Logger.getLogger(Accueil.class.getName()).log(Level.SEVERE, null, ex);    
}
    }
    public void nbModeles(){
          try {
    stat = c.getCo().createStatement();
    rs = stat.executeQuery("select count(id) as nbm from modeles");
    
    // Vérifier s'il y a des résultats
    if (rs.next()) {
        // Récupérer le nombre d'employés et le mettre dans le JLabel
        int nombreEmployes = rs.getInt("nbm");
        nbmodeles.setText(String.valueOf(nombreEmployes));
    } else {
        // Aucun résultat trouvé
        nbemployes.setText("00");
    }
} catch (SQLException ex) {
    Logger.getLogger(Accueil.class.getName()).log(Level.SEVERE, null, ex);

       
}
    }
    
     public void nbclients(){
          try {
    stat = c.getCo().createStatement();
    rs = stat.executeQuery("select count(id) as nbc from clients");
    
    // Vérifier s'il y a des résultats
    if (rs.next()) {
        // Récupérer le nombre d'employés et le mettre dans le JLabel
        int nombreEmployes = rs.getInt("nbc");
        nbclients.setText(String.valueOf(nombreEmployes));
    } else {
        // Aucun résultat trouvé
        nbemployes.setText("00");
    }
} catch (SQLException ex) {
    Logger.getLogger(Accueil.class.getName()).log(Level.SEVERE, null, ex);    
}
    }
     
      public void nbFactures(){
          try {
    stat = c.getCo().createStatement();
    rs = stat.executeQuery("select count(id) as nbc from factures");
    
    // Vérifier s'il y a des résultats
    if (rs.next()) {
        // Récupérer le nombre d'employés et le mettre dans le JLabel
        int nombreFactures = rs.getInt("nbc");
        nbfactures.setText(String.valueOf(nombreFactures));
    } else {
        // Aucun résultat trouvé
        nbfactures.setText("00");
    }
} catch (SQLException ex) {
    Logger.getLogger(Accueil.class.getName()).log(Level.SEVERE, null, ex);    
}
    }
       public void nbLivraisons(){
          try {
    stat = c.getCo().createStatement();
    rs = stat.executeQuery("select count(id) as nbc from livraisons");
    
    // Vérifier s'il y a des résultats
    if (rs.next()) {
        // Récupérer le nombre d'employés et le mettre dans le JLabel
        int nbl = rs.getInt("nbc");
        nblivraisons.setText(String.valueOf(nbl));
    } else {
        // Aucun résultat trouvé
        nblivraisons.setText("00");
    }
} catch (SQLException ex) {
    Logger.getLogger(Accueil.class.getName()).log(Level.SEVERE, null, ex);    
}
    }
     
       public void nbCommandes() {
    try {
        stat = c.getCo().createStatement();
        rs = stat.executeQuery("select count(id) as nbc from commandes_sm");
        stat1 = c.getCo().createStatement(); // Utilisation de stat1 pour la deuxième requête
        rs1 = stat1.executeQuery("select count(id) as nbc from commandes_pa");
        int nbcm = 0;
        int nbcp = 0;
        // Vérifier s'il y a des résultats
        if (rs.next()) {
            // Récupérer le nombre de commandes pour sm et le mettre dans nbcm
            nbcm = rs.getInt("nbc");
        }
        if (rs1.next()) {
            // Récupérer le nombre de commandes pour pa et le mettre dans nbcp
            nbcp = rs1.getInt("nbc");
        }
        // Calculer le total des commandes
        String tc = (nbcp + nbcm) + "";
        nbcomm.setText(tc); // Mettre à jour le JLabel avec le total des commandes
    } catch (SQLException ex) {
        Logger.getLogger(Accueil.class.getName()).log(Level.SEVERE, null, ex);
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

        paccueil = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        nbemployes = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        nbclients = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        nbfactures = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        nbcomm = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        nbmodeles = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        nblivraisons = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(770, 530));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(770, 530));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        paccueil.setBackground(new java.awt.Color(255, 255, 255));
        paccueil.setMinimumSize(new java.awt.Dimension(770, 550));
        paccueil.setPreferredSize(new java.awt.Dimension(770, 550));
        paccueil.setRequestFocusEnabled(false);
        paccueil.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel8.setBackground(new java.awt.Color(167, 183, 192));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Employes");
        jPanel8.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 110, -1));

        nbemployes.setBackground(new java.awt.Color(255, 255, 255));
        nbemployes.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nbemployes.setText("00");
        jPanel8.add(nbemployes, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 30));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ihm/1713646754682.png"))); // NOI18N
        jPanel8.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 160));

        paccueil.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, 230, 160));

        jPanel9.setBackground(new java.awt.Color(167, 183, 192));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel9.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 99));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Clients");
        jPanel9.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 70, -1));

        nbclients.setBackground(new java.awt.Color(255, 255, 255));
        nbclients.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nbclients.setText("00");
        jPanel9.add(nbclients, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, 30));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ihm/1713646754691.png"))); // NOI18N
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel9.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 160));

        paccueil.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 230, 160));

        jPanel10.setBackground(new java.awt.Color(167, 183, 192));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Factures");
        jPanel10.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 110, -1));

        nbfactures.setBackground(new java.awt.Color(255, 255, 255));
        nbfactures.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nbfactures.setText("00");
        jPanel10.add(nbfactures, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ihm/1713648039569.png"))); // NOI18N
        jPanel10.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        paccueil.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 260, 230, 160));

        jPanel11.setBackground(new java.awt.Color(167, 183, 192));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Commandes");
        jPanel11.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 130, -1));

        nbcomm.setBackground(new java.awt.Color(255, 255, 255));
        nbcomm.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nbcomm.setText("00");
        jPanel11.add(nbcomm, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 30));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ihm/1713650362491.png"))); // NOI18N
        jPanel11.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        paccueil.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 70, 230, 160));

        jPanel12.setBackground(new java.awt.Color(167, 183, 192));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Modeles");
        jPanel12.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 100, -1));

        nbmodeles.setBackground(new java.awt.Color(255, 255, 255));
        nbmodeles.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nbmodeles.setText("00");
        jPanel12.add(nbmodeles, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 30));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ihm/1713650362499.png"))); // NOI18N
        jPanel12.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 160));

        paccueil.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 230, 160));

        jPanel13.setBackground(new java.awt.Color(167, 183, 192));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Livraisons");
        jPanel13.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 130, -1));

        nblivraisons.setBackground(new java.awt.Color(255, 255, 255));
        nblivraisons.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nblivraisons.setText("00");
        jPanel13.add(nblivraisons, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ihm/livraison.png"))); // NOI18N
        jPanel13.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 160));

        paccueil.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 260, 230, 160));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel14.setText("Accueil");
        paccueil.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        add(paccueil, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 780, 550));
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
       //ListeDesClients lc= new ListeDesClients();
       //lc.setVisible(true);
        
       
    }//GEN-LAST:event_jLabel7MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel nbclients;
    private javax.swing.JLabel nbcomm;
    private javax.swing.JLabel nbemployes;
    private javax.swing.JLabel nbfactures;
    private javax.swing.JLabel nblivraisons;
    private javax.swing.JLabel nbmodeles;
    private javax.swing.JPanel paccueil;
    // End of variables declaration//GEN-END:variables
}
