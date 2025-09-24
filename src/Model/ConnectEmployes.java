/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author toshiba
 */
public class ConnectEmployes {
 public Connexion co=new Connexion();
public PreparedStatement ps;
public ResultSet rs;
public  ConnectEmployes(){
     try {
        ps=co.getCo().prepareStatement("SELECT* FROM employes");
       rs=ps.executeQuery();
                } catch (SQLException ex) {
        Logger.getLogger(ConnectEmployes.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
}

