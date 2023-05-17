/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package USCAJA;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Date;
import java.time.LocalDate;
import java.util.InputMismatchException;

/**
 *
 * @author jolun
 */
public class OperacionBancariaDAO {
     private ConexionBD conexion;
     UsuarioPotencialDAO u1 = new UsuarioPotencialDAO();
     CuentaBancariaDAO c1 = new CuentaBancariaDAO();
    
     public OperacionBancariaDAO() {
        conexion = new ConexionBD();
    }
    
    // FUNCIONES 
    
     public List listarOperaciones() {
        List operaciones = new ArrayList();

        // Llamar a la base de datos.
        ConexionBD gc = new ConexionBD();
        Connection con = gc.getConexion();
        try {
            // Procesar los resultados
            Statement sentencia = con.createStatement();
            ResultSet rs = sentencia.executeQuery("SELECT * FROM operaciones_bancarias o INNER JOIN Cuentas_bancarias c ON o.numero_cuenta_origen=c.numero_cuenta WHERE c.numero_cuenta='" + c1.seleccion2() + "'");
            OperacionBancaria opera = null;
            boolean hasOperations = false;
            while (rs.next()) {
                opera = new OperacionBancaria();
                opera.setCodigoOperacion(rs.getInt("codigo_operacion"));
                opera.setTipoOperacion(rs.getString("tipo_operacion"));
                opera.setFechaOperacion(rs.getDate("fecha_operacion"));
                opera.setCantidad(rs.getDouble("cantidad"));
                opera.setNumeroCuentaOrigen(rs.getLong("numero_cuenta_origen"));
                opera.setNumeroCuentaDestino(rs.getLong("numero_cuenta_destino"));
                opera.setNifUsuario(rs.getString("Nif_usuario"));
                operaciones.add(opera);
                hasOperations = true;
            }
       if (!hasOperations) {
            System.out.println(" La cuenta no ha realizado ninguna operación o no existe.");
        }

    } catch (SQLException ex) {
        Logger.getLogger(CuentaBancariaDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
        return operaciones;
    }
   
  public void retirar() throws SQLException {
      Scanner sc = new Scanner(System.in);
        OperacionBancaria o1;
        ConexionBD gc = new ConexionBD();
        Connection con = gc.getConexion();

        String cuenta = c1.seleccion2();
        String usuario = u1.seleccion();
        System.out.println("¿Cuanto desea retirar?");
        double cantidad = 0;
         try {
        cantidad = sc.nextDouble();
    } catch (InputMismatchException e) {
        throw new IllegalArgumentException("Cantidad inválida. Ingrese un número válido.");
    }

        int codigo = (int) Math.floor(Math.random() * 10000 + 1);

      o1 = new OperacionBancaria(codigo, "retirar", Date.valueOf(LocalDate.now()),cantidad, Long.parseLong(cuenta), Long.parseLong(cuenta), usuario);

        try {
            Statement sentencia = con.createStatement();
            int filasAfectadas = sentencia.executeUpdate("UPDATE Cuentas_bancarias SET saldo=saldo - " + cantidad + " WHERE numero_cuenta='" + cuenta + "'");
            String sql = "INSERT INTO Operaciones_bancarias VALUES (" + o1.getCodigoOperacion() + ", '" + o1.getTipoOperacion() + "', '" + o1.getFechaOperacion() + "', " + o1.getCantidad() + ", '" + o1.getNumeroCuentaOrigen() + "', '" + o1.getNumeroCuentaDestino() + "', '" + o1.getNifUsuario() + "')";
            sentencia.executeUpdate(sql);
            if (filasAfectadas > 0) {
            System.out.println("Se ha retirado " + cantidad + "€");
        } else {
            System.out.println("ERROR: No se ha podido realizar la operación de retirada.");
        }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioPotencialDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Se ha retirado "+cantidad+"€");
    }
  
  public void ingresar() throws SQLException {
      Scanner sc = new Scanner(System.in);
        OperacionBancaria o1;
        ConexionBD gc = new ConexionBD();
        Connection con = gc.getConexion();

        String cuenta = c1.seleccion2();
        String usuario = u1.seleccion();
        System.out.println("¿Cuanto desea retirar?");
        double cantidad = 0;
         try {
        cantidad = sc.nextDouble();
    } catch (InputMismatchException e) {
        throw new IllegalArgumentException("Cantidad inválida. Ingrese un número válido.");
    }

        int codigo = (int) Math.floor(Math.random() * 10000 + 1);

      o1 = new OperacionBancaria(codigo, "retirar", Date.valueOf(LocalDate.now()),cantidad, Long.parseLong(cuenta), Long.parseLong(cuenta), usuario);

        try {
            Statement sentencia = con.createStatement();
            int filasAfectadas = sentencia.executeUpdate("UPDATE Cuentas_bancarias SET saldo=saldo + " + cantidad + " WHERE numero_cuenta='" + cuenta + "'");
            String sql = "INSERT INTO Operaciones_bancarias VALUES (" + o1.getCodigoOperacion() + ", '" + o1.getTipoOperacion() + "', '" + o1.getFechaOperacion() + "', " + o1.getCantidad() + ", '" + o1.getNumeroCuentaOrigen() + "', '" + o1.getNumeroCuentaDestino() + "', '" + o1.getNifUsuario() + "')";
            sentencia.executeUpdate(sql);
            if (filasAfectadas > 0) {
            System.out.println("Se ha retirado " + cantidad + "€");
        } else {
            System.out.println("ERROR: No se ha podido realizar la operación de retirada.");
        }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioPotencialDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Se ha retirado "+cantidad+"€");
    }
  
      public void transferir() throws SQLException {
        Scanner sc = new Scanner(System.in);
        OperacionBancaria o1;
        ConexionBD gc = new ConexionBD();
        Connection con = gc.getConexion();

        String cuenta = c1.seleccion2();
        String cuenta2 = c1.seleccion3();
        String usuario = u1.seleccion();
        System.out.println("¿Cuanto desea transferir?");
        double cantidad = sc.nextDouble();

        int codigo = (int) Math.floor(Math.random() * 10000 + 1);

        o1 = new OperacionBancaria(codigo, "transferir", Date.valueOf(LocalDate.now()), cantidad, Long.parseLong(cuenta), Long.parseLong(cuenta2), usuario);

        try {
            Statement sentencia = con.createStatement();
            int filasAfectadas = sentencia.executeUpdate("UPDATE Cuentas_bancarias SET saldo=saldo-" + cantidad + " WHERE numero_cuenta='" + cuenta + "'");
            int filasAfectadas2 = sentencia.executeUpdate("UPDATE Cuentas_bancarias SET saldo=saldo+" + cantidad + " WHERE numero_cuenta='" + cuenta2 + "'");
            String sql = "INSERT INTO Operaciones_bancarias VALUES ('" + o1.getCodigoOperacion() + "', '" + o1.getTipoOperacion() + "', '" + o1.getFechaOperacion() + "', '" + o1.getCantidad() + "', '" + o1.getNumeroCuentaOrigen() + "', " + o1.getNumeroCuentaDestino() + ", '" + o1.getNifUsuario() + "')";
            sentencia.executeUpdate(sql);
            if (filasAfectadas > 0 && filasAfectadas2 > 0) {
            System.out.println("Se ha transferido " + cantidad + "€");
        } else {
            System.out.println("ERROR: No se ha podido realizar la operación de transferencia.");
        }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioPotencialDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Se ha transferido "+cantidad+"€");
    }

}






    

