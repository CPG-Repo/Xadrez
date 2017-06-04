/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Xogo;

import Clases_Peza.Peza;
import Clases_Peza.TipoPeza;
import static Clases_Peza.TipoPeza.REI;
import xadrez.Xadrez;

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

    public static void efectuarMovemento(int aMoverX, int aMoverY, int ondeSeMoveX, int ondeSeMoveY){
        Peza p= Xogo.tab.get(aMoverX, aMoverY);
        
        if(p.getPropiedadeDe().equalsIgnoreCase(Xadrez.getTurno())){
            
            if(Xogo.tab.haiPeza(ondeSeMoveX, ondeSeMoveY) && Xogo.tab.get(ondeSeMoveX, ondeSeMoveY).getTipo()==REI){
                Xogo.tab.put(ondeSeMoveX, ondeSeMoveY, p);
                Xogo.tab.put(aMoverX, aMoverY, null);
                Xadrez.finDoXogo();
            }else{
                Xogo.tab.put(ondeSeMoveX, ondeSeMoveY, p);
                Xogo.tab.put(aMoverX, aMoverY, null);   
                Xadrez.cambioTurno();
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
    
}
