/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author EQUIPO
 */
public class conexionSQL {
    
    Connection conectar = null;
    
    public Connection conexion (){
        
        try {
             Class.forName("com.mysql.jdbc.Driver");
             conectar=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/personaliud", "root", "root");
             
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de conexión "+ e.getMessage());
        }
        return conectar;
    }
    
    public void cerrarConexion() throws SQLException {
        try {
            conectar.close();
        } catch (SQLException e) {
            System.out.println(e);
            conectar.close();
        } finally{
           conectar.close(); 
        }
        
    }
}
