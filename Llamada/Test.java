/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tema8.Cola.Llamada;

/**
 *
 * @author jolun
 */
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        
        Llamada llamada1 = new Llamada("722641622", "694058794", true, LocalDateTime.of(2023, 3, 15, 10, 0), LocalDateTime.of(2023, 3, 15, 10, 10), Llamada.ZonaInterlocutor.España);
        Llamada llamada2 = new Llamada("685947589", "618374658", false, LocalDateTime.of(2023, 3, 15, 11, 0), LocalDateTime.of(2023, 3, 15, 11, 5), Llamada.ZonaInterlocutor.Italia);
        Llamada llamada3 = new Llamada("638274466", "649357575", true, LocalDateTime.of(2023, 3, 15, 12, 0), LocalDateTime.of(2023, 3, 15, 12, 15), Llamada.ZonaInterlocutor.Argentina);
        Llamada llamada4 = new Llamada("632947578", "639586540", true, LocalDateTime.of(2023, 3, 15, 13, 0), LocalDateTime.of(2023, 3, 15, 14, 0), Llamada.ZonaInterlocutor.Brasil);
        
        List<Llamada> llamadas = new ArrayList<>();
        llamadas.add(llamada1);
        llamadas.add(llamada2);
        llamadas.add(llamada3);
        llamadas.add(llamada4);
        
        Collections.sort(llamadas);
        
        for (Llamada llamada : llamadas) {
            System.out.println(llamada);
        }
    }

}

