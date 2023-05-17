/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package USCAJA;

/**
 *
 * @author jolun
 */
public class TitularesCuentas {
    private String nif;
    private long numeroCuenta;
    
    public TitularesCuentas(String nif, long numeroCuenta) {
        this.nif = nif;
        this.numeroCuenta = numeroCuenta;
    }
    
    public String getNif() {
        return nif;
    }
    
    public void setNif(String nif) {
        this.nif = nif;
    }
    
    public long getNumeroCuenta() {
        return numeroCuenta;
    }
    
    public void setNumeroCuenta(long numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }
}


