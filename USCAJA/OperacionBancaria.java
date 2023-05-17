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

/**
 *
 * @author jolun
 */
public class OperacionBancaria {
  private int codigoOperacion;
  private String tipoOperacion;
  private Date fechaOperacion;
  private double cantidad;
  private long numeroCuentaOrigen;
  private long numeroCuentaDestino;
  private String nifUsuario;

  public OperacionBancaria(int codigoOperacion, String tipoOperacion, Date fechaOperacion, double cantidad, long numeroCuentaOrigen, long numeroCuentaDestino, String nifUsuario) {
    this.codigoOperacion = codigoOperacion;
    this.tipoOperacion = tipoOperacion;
    this.fechaOperacion = fechaOperacion;
    this.cantidad = cantidad;
    this.numeroCuentaOrigen = numeroCuentaOrigen;
    this.numeroCuentaDestino = numeroCuentaDestino;
    this.nifUsuario = nifUsuario;
  }

    OperacionBancaria() {
    }

  // Métodos para acceder y modificar atributos
   public int getCodigoOperacion() {
        return codigoOperacion;
    }

    public void setCodigoOperacion(int codigoOperacion) {
        this.codigoOperacion = codigoOperacion;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public Date getFechaOperacion() {
        return fechaOperacion;
    }
     public void setFechaOperacion(Date fechaOperacion) {
        this.fechaOperacion = fechaOperacion;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public long getNumeroCuentaOrigen() {
        return numeroCuentaOrigen;
    }

    public void setNumeroCuentaOrigen(long numeroCuentaOrigen) {
        this.numeroCuentaOrigen = numeroCuentaOrigen;
    }

    public long getNumeroCuentaDestino() {
        return numeroCuentaDestino;
    }

    public void setNumeroCuentaDestino(long numeroCuentaDestino) {
        this.numeroCuentaDestino = numeroCuentaDestino;
    }

    public String getNifUsuario() {
        return nifUsuario;
    }

    public void setNifUsuario(String nifUsuario) {
        this.nifUsuario = nifUsuario;
    }

    @Override
    public String toString() {
        return "OperacionBancaria{" + "codigoOperacion=" + codigoOperacion + ", tipoOperacion=" + tipoOperacion + ", fechaOperacion=" + fechaOperacion + ", cantidad=" + cantidad + ", numeroCuentaOrigen=" + numeroCuentaOrigen + ", numeroCuentaDestino=" + numeroCuentaDestino + ", nifUsuario=" + nifUsuario + '}';
    }

   
}








