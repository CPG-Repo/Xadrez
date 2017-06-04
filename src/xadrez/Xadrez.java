/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xadrez;



import Clases_Xogador.Xogador;
import EntornoGrafico.CambioTurno;
import EntornoGrafico.Menu;
import EntornoGrafico.TaboleiroGrafico;
import Excepcions.UserException;
import Xogo.Xogo;




/**
 *
 * @author Carlos
 */
public class Xadrez {
    private static Xogo partida;
    private static Xogador xog1,xog2;
    private static String turno;
    private static TaboleiroGrafico tabG= new TaboleiroGrafico();
    
    public static void comezar(){
       Xadrez.setPartida(new Xogo(getXog1().getUser(),getXog2().getUser()));
       partida.iniciarXogo();
       tabG.setVisible(true);
       turno=xog1.getUser();
    }
    
    public static void cambioTurno(){        
        CambioTurno comprobar= new CambioTurno();
        comprobar.setVisible(true);
        comprobar.cambiarTitulo("Tocache: "+seguinteXogador().getUser());
        tabG.setEnabled(false);
    }
    
    public static void finDoXogo(){
        tabG.mensaxeDeVitoria();
        tabG.dispose();
    }
    
    public static void operacionCambioTurno(){
        tabG.setEnabled(true);
        if(turno.equals(xog1.getUser())){
            turno=xog2.getUser();
        }else{
            turno=xog1.getUser();
        }
    }
    
    public static Xogador seguinteXogador(){
        if(getTurno().equals(xog1.getUser())){
            return xog2;
        }else{
            return xog1;
        }
    }
    
    public static Xogo getPartida() {
        return partida;
    }

    public static void setPartida(Xogo partida) {
        Xadrez.partida = partida;
    }
    
    public String isQuenda() {
        return turno;
    }

    public static Xogador getXog1() {
        return xog1;
    }

    public static void setXog1(Xogador xog1) {
        Xadrez.xog1 = xog1;
    }

    public static Xogador getXog2() {
        return xog2;
    }

    public static void setXog2(Xogador xog2) {
        Xadrez.xog2 = xog2;
    }
    
    public static String getTurno() {
        return turno;
    }
    
    /**
     * @param args the command line arguments
     * @throws Excepcions.UserException
     */
    public static void main(String[] args) throws UserException {

        Menu logeo= new Menu();
        logeo.setVisible(true);
        

    }
}
