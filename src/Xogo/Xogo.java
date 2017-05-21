/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Xogo;

import Clases_Peza.Peza;
import Clases_Peza.TipoPeza;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Carlos
 */
public class Xogo {
    Taboleiro tab= new Taboleiro();
    String xog1,xog2;
    
    
    public Xogo(){
    }
    
    public void iniciarXogo(){
        encherTaboleiro();
        asignarXogador1();
    }
    
    private void encherTaboleiro(){
        Integer x, y;
        for(x=0;x<tab.taboleiro.size();x++){
            tab.put(x,y=1 , new Peza(TipoPeza.PEON));
            tab.put(x,y=6 , new Peza(TipoPeza.PEON));
        }
        
        for(x=0;x<tab.taboleiro.size();x++){
            if(x==0|x==7){
                tab.put(x, y=0, new Peza(TipoPeza.TORRE));
                tab.put(x, y=7, new Peza(TipoPeza.TORRE));     
            }else if(x==1|x==6){
                tab.put(x, y=0, new Peza(TipoPeza.CABALO));
                tab.put(x, y=7, new Peza(TipoPeza.CABALO));   
            }else if(x==2|x==5){
                tab.put(x, y=0, new Peza(TipoPeza.ALFIL));
                tab.put(x, y=7, new Peza(TipoPeza.ALFIL));   
            }else if(x==3){
                tab.put(x, y=0, new Peza(TipoPeza.REI));
                tab.put(x, y=7, new Peza(TipoPeza.RAIÑA)); 
            }else if(x==4){
                tab.put(x, y=0, new Peza(TipoPeza.RAIÑA));
                tab.put(x, y=7, new Peza(TipoPeza.REI)); 
            }
        }
    }
    
    private void asignarXogador1(){
        int x,y;
        for(x=0;x<tab.taboleiro.size();x++){
            for(y=0;y==1;y++){
                tab.get(x, y).setPropiedadeDe(xog1);
            }
        }
    }
    
    private void asignarXogador2(){
        int x,y;
        for(x=0;x<tab.taboleiro.size();x++){
            for(y=6;y==7;y++){
                tab.get(x, y).setPropiedadeDe(xog2);
            }
        }
    }
    
    public Peza getFicha(Integer x,Integer y){
        Peza ficha=tab.get(x, y);
        return ficha;
    }
    
    
//    public void getTaboleiro(){
//        int x;
//        int y;
//        System.out.println("     0 1 2 3 4 5 6 7 8 9");
//        System.out.println("     | | | | | | | | | |");
//        for(x=0;x<taboleiro.length;x++){
//            System.out.print(x+"-- ");
//            System.out.print("|");
//            for(y=0;y<taboleiro.length;y++){
//                System.out.print(taboleiro[x][y]+"|");
//            }
//            System.out.println("");
//        }
//    }
    
//      public String toString(){
//      String result = "";
//      for(int i = 0; i < taboleiro.size(); i++){
//          for(int j = 0; j < taboleiro.get(i).size(); j++){
//              result += taboleiro.get(i).get(j);
//          }
//          System.out.println("x");
//      }
//      return result;
//  }
}
