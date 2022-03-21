/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taxi;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONObject;

/**
 *
 * @author anton
 */
public class EnviaDados {
    
    
    
    public void envia(String numeroServico, String ganhoViagem, String tempo, String distancia, String valorCorrida, String descontoCorrida, String horarioSolicitacao, String dataFechamento,String valorSomadoSemana,String motorista, String idMotoristaSistema, String email){
       try {
       URL url = new URL("http://localhost:8089/Taxi/emvia.php");
       HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setDoOutput(true);
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");

        JSONObject jsonObj = new JSONObject();
      jsonObj.put("numSO", String.valueOf(numeroServico));
        jsonObj.put("ganhoViagem", String.valueOf(ganhoViagem));
        jsonObj.put("tempo", String.valueOf(tempo));
        jsonObj.put("distancia", String.valueOf(distancia));
        jsonObj.put("valorCorrida", String.valueOf(valorCorrida));
        jsonObj.put("descontoCorrida", String.valueOf(descontoCorrida));
        jsonObj.put("horarioSolicitacao", String.valueOf(horarioSolicitacao));
        jsonObj.put("dataFechamento", String.valueOf(dataFechamento));
        //jsonObj.put("informacoesCadaCorrida", String.valueOf(informaçõesCadaCorrida));
        jsonObj.put("motorista", String.valueOf(motorista));
        jsonObj.put("idMotorista", String.valueOf(idMotoristaSistema));
        jsonObj.put("email", String.valueOf(email));
        System.out.println(email);
      //  jsonObj.put("email", "antoniorony@hotmail.com");
       // jsonObj.put("mensagem", String.valueOf(ganhoViagem+"|"+tempo+"|"+distancia+"|"+valorCorrida+"|"+descontoCorrida+"|"+horarioSolicitacao+"|"+dataFechamento+"|"+motorista));

        DataOutputStream os = new DataOutputStream(con.getOutputStream());
        os.writeBytes(jsonObj.toString());
        os.flush();

        BufferedReader br = new BufferedReader(new InputStreamReader((con.getInputStream())));
        int responseCode = con.getResponseCode();
        String output;
        StringBuffer sb = new StringBuffer();
        System.out.println("Output from Server .... \n");
        while ((output = br.readLine()) != null) {
            sb.append(output);
            break;
        } 

        System.out.println("Response Code: "+responseCode);
        System.out.println("URL: "+url);
        System.out.println("Parameters: "+jsonObj.toString());
        System.out.println("Output: "+output.toString());

        con.disconnect();
    } catch (MalformedURLException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}
