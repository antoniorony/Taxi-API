/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taxi;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author anton
 */
public class TAXi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setSize(400, 400);
        JLabel retorno = new JLabel();
        retorno.setText("Carregando........");
        jf.add(retorno);
        jf.setDefaultCloseOperation(1);
        
        jf.setVisible(true);
        
        LoopChamada lop = new LoopChamada();
        lop.chamada();

        
// TODO code application logic here
    }
    
}
