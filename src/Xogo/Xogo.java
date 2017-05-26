/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Xogo;

import Clases_Peza.Peza;
import Clases_Peza.TipoPeza;


/**
 *
 * @author Carlos
 */
public class Xogo {
    public static Taboleiro tab= new Taboleiro();
    private static String xog1,xog2;
    
    
    public Xogo(String xogador1, String xogador2){
        this.xog1=xogador1;
        this.xog2=xogador2;
    }
    
    public void iniciarXogo(){
        encherTaboleiro();
        asignarXogador1();
    }
    
    private void encherTaboleiro(){
        Integer x, y;
        for(x=0;x<8;x++){
            tab.put(x,y=1 , new Peza(TipoPeza.PEON,xog1));
            tab.put(x,y=6 , new Peza(TipoPeza.PEON,xog2));
        }
        
        for(x=0;x<8;x++){
            if(x==0|x==7){
                tab.put(x, y=0, new Peza(TipoPeza.TORRE,xog1));
                tab.put(x, y=7, new Peza(TipoPeza.TORRE,xog2));     
            }else if(x==1|x==6){
                tab.put(x, y=0, new Peza(TipoPeza.CABALO,xog1));
                tab.put(x, y=7, new Peza(TipoPeza.CABALO,xog2));   
            }else if(x==2|x==5){
                tab.put(x, y=0, new Peza(TipoPeza.ALFIL,xog1));
                tab.put(x, y=7, new Peza(TipoPeza.ALFIL,xog2));   
            }else if(x==3){
                tab.put(x, y=0, new Peza(TipoPeza.REI,xog1));
                tab.put(x, y=7, new Peza(TipoPeza.RAIÑA,xog2)); 
            }else if(x==4){
                tab.put(x, y=0, new Peza(TipoPeza.RAIÑA,xog1));
                tab.put(x, y=7, new Peza(TipoPeza.REI,xog2)); 
            }
        }
    }
    
    private void asignarXogador1(){
        int x,y;
        for(x=0;x<8;x++){
            for(y=0;y==1;y++){
                tab.get(x, y).setPropiedadeDe(xog1);
            }
        }
    }
    
    private void asignarXogador2(){
        int x,y;
        for(x=0;x<8;x++){
            for(y=6;y==7;y++){
                tab.get(x, y).setPropiedadeDe(xog2);
            }
        }
    }
    
    public Peza getFicha(Integer x,Integer y){
        Peza ficha=tab.get(x, y);
        return ficha;
    }
    
    public static String getXog1() {
        return xog1;
    }

    public static String getXog2() {
        return xog2;
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
