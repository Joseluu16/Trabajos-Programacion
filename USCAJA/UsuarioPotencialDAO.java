/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package USCAJA;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jolun
 */
public class UsuarioPotencialDAO {
    private ConexionBD conexion;

    public UsuarioPotencialDAO() {
        conexion = new ConexionBD();
    }
    
    
    // FUNCIONES
      public List listarUsuarios() {
        List usuarios = new ArrayList();
        ConexionBD gc = new ConexionBD();
        Connection con = gc.getConexion();
        
        try {
            // Procesar los resultados
            Statement sentencia = con.createStatement();
            ResultSet rs = sentencia.executeQuery("SELECT * FROM usuarios_potenciales");
            UsuarioPotencial usuario = null;
            while (rs.next()) {
                usuario = new UsuarioPotencial();
                usuario.setNif(rs.getString("NIF"));
                usuario.setTelefono(rs.getString("Telefono"));
                usuario.setApellidos(rs.getString("Apellidos"));
                usuario.setNombre(rs.getString("Nombre"));
                usuario.setAnoNacimiento(rs.getDate("Ano_nacimiento"));
                usuario.setDireccion(rs.getString("Direccion"));
                usuario.setEmail(rs.getString("Email"));
                usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioPotencialDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return usuarios;
    }
      
   public void crearUsuario() throws SQLException {
        Scanner sc = new Scanner(System.in);
        ConexionBD gc = new ConexionBD();
        Connection con = gc.getConexion();

        System.out.println("Escriba su NIF:");
        String nif = sc.next();
        System.out.println("Apellidos del usuario:");
        String apellidos = sc.nextLine();
        apellidos = sc.nextLine();
        System.out.println("Nombre del usuario:");
        String nombre = sc.next();
        System.out.println("Año de nacimiento:");
        String anio = sc.next();
        System.out.println("Dirección del usuario:");
        String direccion = sc.nextLine();
        direccion = sc.nextLine();
        System.out.println("Correo electronico:");
        String mail = sc.next();
        System.out.println("Télefono:");
        String telefono = sc.next();

        String sql = "INSERT INTO usuarios_potenciales VALUES ('"+ nif + "', '" + apellidos + "', '" + nombre + "', '" + anio + "', '" + direccion + "', '" + mail + "', '" + telefono + "')";
        
        try{
            Statement sentencia = con.createStatement();
            sentencia.executeUpdate(sql);
            System.out.println("El usuario se ha creado correctamente.");
        } catch (SQLException ex) {
             System.out.println("Error al crear el usuario: " + ex.getMessage());
            Logger.getLogger(UsuarioPotencialDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    
     public boolean eliminarUsuarioPotencial() throws SQLException {
      Scanner sc = new Scanner(System.in);
      ConexionBD gc = new ConexionBD();
      Connection con = gc.getConexion();

      System.out.println("Escriba el NIF:");
      String nif = sc.next();

    String sql = "DELETE FROM usuarios_potenciales WHERE NIF = ? ";
    try {
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, nif);
        preparedStatement.executeUpdate();
        int filasAfectadas = preparedStatement.executeUpdate();
        if (filasAfectadas > 0) {
            System.out.println("Se ha eliminado correctamente.");
            return true;
        } else {
            System.out.println("ERROR: No se encontró el usuario potencial para eliminar.");
            return false;
        }
    } catch (SQLException ex) {
        Logger.getLogger(UsuarioPotencialDAO.class.getName()).log(Level.SEVERE, null, ex);
        return false;
    }
}
          
       public String seleccion(){
        Scanner sc=new Scanner(System.in);
        String usu;
        System.out.println("Selecciona un Usuario");
        usu=sc.next();
        return usu;
    }
       
      public void actualizarNombre() {
        Scanner sc=new Scanner(System.in);
        String cambio=seleccion();
        ConexionBD gc = new ConexionBD();
        Connection con = gc.getConexion();
        System.out.println("Escribe el nuevo nombre");
        String nuevoNombre = sc.nextLine();
        try {
            String sql = "UPDATE Usuarios_potenciales SET nombre = '" +nuevoNombre+ "' WHERE NIF = '"+cambio+"'";
            Statement sentencia = con.createStatement();
            sentencia.executeUpdate(sql);
            System.out.println("Se ha modificado correctamente");
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioPotencialDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      
       public void actualizarApellido() {
        Scanner sc = new Scanner(System.in);
        String cambio=seleccion();
        ConexionBD gc = new ConexionBD();
        Connection con = gc.getConexion();
        System.out.println("Escriba los nuevos apellidos");
        String nuevoApellido = sc.nextLine();
        try {
            String sql = "UPDATE Usuarios_potenciales SET apellidos = '" +nuevoApellido+ "' WHERE NIF = '"+cambio+"'";
            Statement sentencia = con.createStatement();
            sentencia.executeUpdate(sql);
            System.out.println("Se ha modificado correctamente");
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioPotencialDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       } 
        
        public void actualizarDireccion() {
        Scanner sc = new Scanner(System.in);
        String cambio = seleccion();
        ConexionBD gc = new ConexionBD();
        Connection con = gc.getConexion();
        System.out.println("Escribe la nueva direccion");
        String nuevaDireccion = sc.nextLine();
        
        try {
            String sql = "UPDATE Usuarios_potenciales SET direccion = '" +nuevaDireccion+ "' WHERE NIF = '"+cambio+"'";
            Statement sentencia = con.createStatement();
            sentencia.executeUpdate(sql);
            System.out.println("Se ha modificado correctamente");
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioPotencialDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
     }   
        
       public void actualizarEmail() {
        Scanner sc=new Scanner(System.in);
        String cambio=seleccion();
        ConexionBD gc = new ConexionBD();
        Connection con = gc.getConexion();
        System.out.println("Escribe el nuevo nombre");
        String nuevoEmail = sc.nextLine();
        try {
            String sql = "UPDATE Usuarios_potenciales SET email = '" +nuevoEmail+ "' WHERE NIF = '"+cambio+"'";
            Statement sentencia = con.createStatement();
            sentencia.executeUpdate(sql);
            System.out.println("Se ha modificado correctamente");
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioPotencialDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
          public void actualizarTelefono() {
        Scanner sc = new Scanner(System.in);
        String cambio = seleccion();
        ConexionBD gc = new ConexionBD();
        Connection con = gc.getConexion();
        System.out.println("Escribe el nuevo telefono");
        String nuevoTelefono = sc.nextLine();
        try {
            String sql = "UPDATE Usuarios_potenciales SET telefono = '" +nuevoTelefono+ "' WHERE NIF = '"+cambio+"'";
            Statement sentencia = con.createStatement();
            sentencia.executeUpdate(sql);
            System.out.println("Se ha modificado correctamente");
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioPotencialDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

