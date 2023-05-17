/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package USCAJA;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Date;

/**
 *
 * @author jolun
 */
public class CuentaBancariaDAO {
    private ConexionBD conexion;
   
    UsuarioPotencialDAO u1 = new UsuarioPotencialDAO();
    TitularesCuentasDAO t1 = new TitularesCuentasDAO();
   
    public CuentaBancariaDAO() {
        conexion = new ConexionBD();
    }
    
     // FUNCIONES 
    
   public List listarCuentas() {
        List cuentas = new ArrayList();
        ConexionBD gc = new ConexionBD();
        Connection con = gc.getConexion();
        try {
            Statement sentencia = con.createStatement();
           ResultSet rs = sentencia.executeQuery("SELECT * FROM cuentas_bancarias c INNER JOIN titulares_cuentas t ON c.numero_cuenta = t.numero_cuenta WHERE t.NIF='"+(u1.seleccion())+"'");
            CuentaBancaria cuenta = null;
            while(rs.next()) {
                cuenta = new CuentaBancaria();
                cuenta.setNumeroCuenta(rs.getLong("Numero_cuenta"));
                cuenta.setFechaCreacion(rs.getDate("Fecha_creacion"));
                cuenta.setSaldo(rs.getDouble("Saldo"));
                cuentas.add(cuenta);
            }
        con.close();
         if (!cuentas.isEmpty()) {
            System.out.println("Se ha encontrado " + cuentas.size() + " cuenta(s) asociada(s) al NIF");
        } else {
            System.out.println("No se encontraron cuentas asociadas al NIF");
        }
        } catch (SQLException ex) {
            Logger.getLogger(CuentaBancariaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cuentas;
  }
   
  public void crearCuentas() throws SQLException {
    CuentaBancaria c1;
    Scanner sc = new Scanner(System.in);
    ConexionBD gc = new ConexionBD();
    Connection con = gc.getConexion();

    System.out.println("Escriba el número de su cuenta:");
    Long numeroCuenta = sc.nextLong();

    c1 = new CuentaBancaria(numeroCuenta, Date.valueOf(LocalDate.now()),(0.0));

    String sql = "INSERT INTO Cuentas_bancarias(numero_cuenta, Fecha_creacion, Saldo) VALUES("+ c1.getNumeroCuenta() + ", '" + c1.getFechaCreacion() + "', " + c1.getSaldo() + ")";
    String sql2 = "INSERT INTO Titulares_cuentas VALUES ('"+(u1.seleccion())+"', '"+ numeroCuenta+"')";
    try{
        Statement sentencia = con.createStatement();
        sentencia.executeUpdate(sql);
        sentencia.execute(sql2);
        System.out.println("La cuenta "+numeroCuenta+" ha sido creada correctamente");
    } catch (SQLException ex) {
        Logger.getLogger(UsuarioPotencialDAO.class.getName()).log(Level.SEVERE, null, ex);
        System.out.println("Error al crear la cuenta " + numeroCuenta);
    }
}
   
    public String seleccion2(){
        Scanner sc = new Scanner(System.in);
        String usu;
        System.out.println("Inserte su cuenta bancaria");
        usu=sc.next();
        return usu;
    }
    
     public String seleccion3(){
        Scanner sc = new Scanner(System.in);
        String usu;
        System.out.println("Inserte la cuenta a la que se desea hacer una transferencia");
        usu=sc.next();
        return usu;
    }
}
