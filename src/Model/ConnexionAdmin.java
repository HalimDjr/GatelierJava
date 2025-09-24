/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author toshiba
 */
public class ConnexionAdmin {
    Connexion co=new Connexion();
PreparedStatement ps;
public ResultSet rs;
public ConnexionAdmin(){
 try {
        ps=co.getCo().prepareStatement("SELECT* FROM Admin");
        rs=ps.executeQuery();
                } catch (SQLException ex) {
        Logger.getLogger(ConnexionAdmin.class.getName()).log(Level.SEVERE, null, ex);
    }
}
}
