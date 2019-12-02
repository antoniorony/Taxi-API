/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taxi;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author anton
 */
public class LerCsv {
    public void lerCsv() throws IOException{
   /*      
     dados a serem recolhidos
      ganho da viagem, o tempo, a distancia, o valor da corrida,
     se teve algum desconto no valor o horario da solicitação, a data
     O Fechamento é feito por semana
Vc pode separar por semana
e dentro de cada semana tem os valores somados e as informaçoes de cada corrida

    */
     float ganhoViagem;
     float tempo;
     float distancia;
     float valorCorrida;
     float descontoCorrida;
     String horarioSolicitacao;
     String dataFechamento;
     float valorSomadoSemana = 0;
     String informaçõesCadaCorrida;
     String motorista;
     
        String csvArquivo2 = "C://b.csv";
        BufferedReader conteudo = null;
        String linha = "";
        String cvsSeparadorCampo = ";";
        
        try {
            conteudo = new BufferedReader(new FileReader(csvArquivo2));
            while((linha = conteudo.readLine()) != null){
                String[] taxi = linha.split(cvsSeparadorCampo, -1);
               
               /* System.out.println("|0 "+taxi[0]
                +"|1 "+taxi[1]+"|2 "+taxi[2]+"|3 "+taxi[3]+"|4 "+taxi[4]
                +"|"+taxi[5]+"|"+taxi[6]+"|"+taxi[7]+"|"+taxi[8]
                +"|"+taxi[9]+"|"+taxi[10]+"|"+taxi[11]+"|"+taxi[12]
                +"|"+taxi[13]+"|"+taxi[14]+"|"+taxi[15]+"|"+taxi[16]
                +"|"+taxi[17]+"|"+taxi[18]+"|"+taxi[19]+"|"+taxi[20]
                +"|"+taxi[21]+"|"+taxi[22]+"|"+taxi[23]+"|"+taxi[24]+"|"+taxi[25]
                +"|"+taxi[26]+"|"+taxi[27]+"|"+taxi[28]+"|"+taxi[29]+"|"+taxi[30]
                +"|"+taxi[31]+"|"+taxi[32]+"|"+taxi[33]+"|"+taxi[34]+"|"+taxi[35]
                +"|"+taxi[36]+"|"+taxi[37]+"|"+taxi[38]+"|"+taxi[39]+"|"+taxi[40]
                +"|"+taxi[41]+"|"+taxi[42]+"|"+taxi[43]+"|"+taxi[44]+"|"+taxi[45]
                +"|"+taxi[46]+"|"+taxi[47]+"|"+taxi[48]+"|"+taxi[49]+"|"+taxi[50]
                +"|"+taxi[51]+"|"+taxi[52]+"|"+taxi[53]+"|"+taxi[54]+"|"+taxi[55]
                +"|"+taxi[56]+"|"+taxi[57]+"|"+taxi[58]+"|"+taxi[59]+"|"+taxi[60]
                +"|"+taxi[61]+"|"+taxi[62]+"|"+taxi[63]+"|"+taxi[64]+"|"+taxi[65]
                +"|"+taxi[66]+"|"+taxi[67]+"|"+taxi[68]);*/
                
                if(taxi[1].equals("Status")){
                }else{
                 //   while(taxi[0].equalsIgnoreCase("20935")){
                //valorSomadoSemana = Float.parseFloat(taxi[50]);
     EnviaDados enviaDados = new EnviaDados();
     if(taxi[32].equalsIgnoreCase("")){
              
    //System.out.println(ho[0]+ho[1]+taxi[0]+ taxi[50]+ taxi[26]+ taxi[44]+ taxi[50]+ taxi[49]+ " hora "+taxi[3]+" "+ taxi[4]+ "0"+ taxi[32] taxi[8]);
  String[] ho = taxi[3].split(" ", -1);
            enviaDados.envia(taxi[0], taxi[50], taxi[26], taxi[44], taxi[50], taxi[49], ho[1], ho[0], "0", "sem informacao","0",taxi[8]);
 
    }else{
          String[] ho = taxi[3].split(" ", -1);
 String[] mot =  taxi[32].split(" - ", -1);
     enviaDados.envia(taxi[0], taxi[50], taxi[26], taxi[44], taxi[50], taxi[49], ho[1], ho[0], "0", mot[1], mot[0], taxi[8]);//mot[1]passa o valor do nome do motorista
                   // , taxi[20]
    }            
                 //   }
                    }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LerCsv.class.getName()).log(Level.SEVERE, null, ex);
        }catch(ArrayIndexOutOfBoundsException e){
            Logger.getLogger(LerCsv.class.getName()).log(Level.SEVERE, null, e);

        }finally{
            if (conteudo != null) {
                try {
                    conteudo.close();
                } catch (IOException e) {
                    System.out.println("erro"+e.getMessage());
                }
            }
        }
     
    }
}
