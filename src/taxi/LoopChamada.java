/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taxi;

import java.io.IOException;
import java.util.Calendar;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anton
 */
public class LoopChamada {
    private int horaAtual;
    public void chamada(){
        Calendar hoje2 = Calendar.getInstance();
      int hora2 = hoje2.get(Calendar.HOUR);
       horaAtual = hora2;
       
        while (horaAtual > -1) { 
            Calendar hoje = Calendar.getInstance();
           int hora = hoje.get(Calendar.HOUR);

            
             if(horaAtual == hora){
            
            LerCsv ler = new LerCsv();
                 try {
                     ler.lerCsv();
                 } catch (IOException ex) {
                     Logger.getLogger(LoopChamada.class.getName()).log(Level.SEVERE, null, ex);
                 }
            horaAtual = hora+1;
            System.out.println(horaAtual);

            }
               //----------------------------
             else if(horaAtual == hora){
                 LerCsv ler = new LerCsv();
                 try {
                     ler.lerCsv();
                 } catch (IOException ex) {
                     Logger.getLogger(LoopChamada.class.getName()).log(Level.SEVERE, null, ex);
                 }
            
             }
             //------------------
             else if(horaAtual != hora){
                
               System.out.println(horaAtual);

                 System.out.println("Aguardando o tempo ...");
   /*                System.out.print("informe a hora");
Scanner sc = new Scanner(System.in);
int resp = sc.nextInt();

horaAtual = resp;*/
             }
           
        }
  
       
    
    }
}
