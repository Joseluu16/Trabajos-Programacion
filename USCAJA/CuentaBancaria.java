/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package USCAJA;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 *
 * @author jolun
 */
public class CuentaBancaria {
  private long numeroCuenta;
  private Date fechaCreacion;
  private double saldo;
  private List<UsuarioPotencial> titulares;

  public CuentaBancaria(long numeroCuenta, Date fechaCreacion, double saldo) {
    this.numeroCuenta = numeroCuenta;
    this.fechaCreacion = fechaCreacion;
    this.saldo = saldo;
  }

    CuentaBancaria() {  
    }

 
  // Métodos para acceder y modificar atributos
   public long getNumeroCuenta() {
        return numeroCuenta;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setNumeroCuenta(long numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public void setTitulares(List<UsuarioPotencial> titulares) {
        this.titulares = titulares;
    }

    public List<UsuarioPotencial> getTitulares() {
        return titulares;
    }

    @Override
    public String toString() {
        return "CuentaBancaria{" + "numeroCuenta=" + numeroCuenta + ", fechaCreacion=" + fechaCreacion + ", saldo=" + saldo + ", titulares=" + titulares + '}';
    }
     
}
