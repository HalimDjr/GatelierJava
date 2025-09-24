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
public class ConnectVariante {
 public Connexion co=new Connexion();
public PreparedStatement ps;
public ResultSet rs;
public  ConnectVariante(){
     try {
        ps=co.getCo().prepareStatement("SELECT* FROM variantes");
       rs=ps.executeQuery();
                } catch (SQLException ex) {
        Logger.getLogger(ConnectVariante.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
}

