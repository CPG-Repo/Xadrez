/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xadrez;



import EntornoGrafico.TaboleiroGrafico;
import Excepcions.UserException;
import Xogo.Xogo;




/**
 *
 * @author Carlos
 */
public class Xadrez {
    private String turno=Xogo.getXog1();
    
    
    public void cambioTurno(){
        if(turno.equals(Xogo.getXog1())){
            turno=Xogo.getXog2();
        }else{
            turno=Xogo.getXog1();
        }
    }
    
    public String isQuenda() {
        return turno;
    }
    /**
     * @param args the command line arguments
     * @throws Excepcions.UserException
     */
    public static void main(String[] args) throws UserException {
        Xogo xog=new Xogo("pepe","carmela");
        xog.iniciarXogo();
        TaboleiroGrafico tabG= new TaboleiroGrafico();
        tabG.setVisible(true);
        
        
        

    }
}
