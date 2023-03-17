/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tema8.Cola.Llamada;

import java.time.LocalDateTime;

/**
 *
 * @author jolun
 */
    import java.time.LocalDateTime;
import java.time.Duration;

public class Llamada implements Comparable<Llamada> {

    private String numCliente;
    private String numInterlocutor;
    private boolean esSaliente;
    private LocalDateTime inicio;
    private LocalDateTime fin;
    private ZonaInterlocutor zona;
    
    public Llamada(String numCliente, String numInterlocutor, boolean esSaliente, LocalDateTime inicio, LocalDateTime fin, ZonaInterlocutor zona) {
      this.numCliente = numCliente;
      this.numInterlocutor = numInterlocutor;
      this.esSaliente = esSaliente;
      this.inicio = inicio;
      this.fin = fin;
      this.zona = zona;
    }
    
    public enum ZonaInterlocutor {
        España(5), Italia(10), Argentina(15), Brasil(20), Rusia(25);
         
        private int tarifa;
        ZonaInterlocutor(int tarifa) {
            this.tarifa = tarifa;
        }
        public int getTarifa() {
            return tarifa;
        }
    }
    public static final int[] TARIFAS = { ZonaInterlocutor.España.getTarifa(), ZonaInterlocutor.Italia.getTarifa(), ZonaInterlocutor.Argentina.getTarifa(),
        ZonaInterlocutor.Brasil.getTarifa(), ZonaInterlocutor.Rusia.getTarifa() };
    
   
    
    public int getDuracion() {
        Duration duracion = Duration.between(inicio, fin);
        return (int) duracion.toMinutes();
    }
    
    public double getCoste() {
        if (esSaliente) {
            int zonaIndex = zona.ordinal();
            int tarifa = TARIFAS[zonaIndex];
            int duracion = getDuracion();
            return (double) tarifa * duracion / 100;
        }
        else {
            return 0;
        }
    }
    
    @Override
    public int compareTo(Llamada otraLlamada) {
        if (numCliente.compareTo(otraLlamada.numCliente) == 0) {
            return inicio.compareTo(otraLlamada.inicio);
        }
        else {
            return numCliente.compareTo(otraLlamada.numCliente);
        }
    }
    
    @Override
    public String toString() {
        return "Llamada [numCliente=" + numCliente + ", numInterlocutor=" + numInterlocutor + ", esSaliente=" + esSaliente
                + ", inicio=" + inicio + ", duracion=" + getDuracion() + " min, coste=" + getCoste() + " €]";
    }
    
}

