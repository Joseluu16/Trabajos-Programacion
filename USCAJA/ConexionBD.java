

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package USCAJA;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author jolun
 */
class ConexionBD {
   Connection conn1 = null;

    public ConexionBD() {
        conn1 = crearConexion();
    }

   private Connection crearConexion() {
    if (conn1 != null) {
        return conn1;
    }
    Connection con = null;
    try {
        String url1 = "jdbc:mysql://localhost:3306/us-caja";
        String user = "root";
        String password = "";
        con = DriverManager.getConnection(url1, user, password);
        if (con != null) {
            System.out.println("Conectado a US-Caja");
        }
    } catch (SQLException ex) {
        System.out.println("ERROR: La dirección no es válida o el usuario y clave son incorrectos");
        ex.printStackTrace();
    }
    return con;
}

    public void cerrarConexion() {

        try {
            conn1.close();
            conn1=null;
        } catch (SQLException ex) {
            System.out.println("ERROR:al cerrar la conexión");
            ex.printStackTrace();
        }
    }
    public Connection getConexio() {
        return crearConexion();
    }

    Connection getConexion() {
       return crearConexion();
    }

    Connection obtenerConexion() {
       return null;
    }
}
   

