/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


/**
 *
 * @author JoaN
 */
public class ConexionMySQL {
    public String db = "VIDEOCLUB";
    //public String url2="jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
    public String url= "jdbc:mysql://localhost/"+db;
    public String user ="root";
    public String pass = "";

    public Connection Conectar(){
        Connection link = null;
        
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            
            link = DriverManager.getConnection(this.url, this.user, this.pass);
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Error: " +ex);
        }
        
        return link;
    }
}