/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package USCAJA;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author jolun
 */
public class UsuarioPotencial {
  private String nif;
  private String apellidos;
  private String nombre;
  private Date anoNacimiento;
  private String direccion;
  private String email;
  private String telefono;

  public UsuarioPotencial(String nif, String apellidos, String nombre, Date anoNacimiento, String direccion, String email, String telefono) {
    this.nif = nif;
    this.apellidos = apellidos;
    this.nombre = nombre;
    this.anoNacimiento = anoNacimiento;
    this.direccion = direccion;
    this.email = email;
    this.telefono = telefono;
  }

    UsuarioPotencial() {
    }

  // Métodos para acceder y modificar atributos
  public String getNif() {
    return nif;
}

public void setNif(String nif) {
    this.nif = nif;
}

public String getApellidos() {
    return apellidos;
}

public void setApellidos(String apellidos) {
    this.apellidos = apellidos;
}

public String getNombre() {
    return nombre;
}

public void setNombre(String nombre) {
    this.nombre = nombre;
}

public Date getAnoNacimiento() {
    return anoNacimiento;
}

public void setAnoNacimiento(Date anoNacimiento) {
    this.anoNacimiento = anoNacimiento;
}

public String getDireccion() {
    return direccion;
}

public void setDireccion(String direccion) {
    this.direccion = direccion;
}

public String getEmail() {
    return email;
}

public void setEmail(String email) {
    this.email = email;
}

public String getTelefono() {
    return telefono;
}

public void setTelefono(String telefono) {
    this.telefono = telefono;
}

    @Override
    public String toString() {
        return "UsuarioPotencial{" + "nif=" + nif + ", apellidos=" + apellidos + ", nombre=" + nombre + ", anoNacimiento=" + anoNacimiento + ", direccion=" + direccion + ", email=" + email + ", telefono=" + telefono + '}';
    }

    
}









