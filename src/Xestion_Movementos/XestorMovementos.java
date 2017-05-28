/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Xestion_Movementos;

import Clases_Peza.Peza;
import Clases_Peza.TipoPeza;
import Xogo.Taboleiro;
import Xogo.Xogo;
import java.util.ArrayList;

/**
 *
 * @author Carlos
 */
public class XestorMovementos {
    private Taboleiro tabCopia;
    private int[][] tabMovementosPosibles= new int[8][8];
    private int fichaX,fichaY;
    
    public int[][] movementosPosibles(Taboleiro tabOrixinal, int pezaX, int pezaY){
        resetearTabMovementosPosibles();
        this.tabCopia=tabOrixinal;
        fichaX=pezaX;
        fichaY=pezaY;
        calculoMovemento(tabCopia.get(pezaX, pezaY));
        
        tabMovementosPosibles[fichaX][fichaY]=0;
        return tabMovementosPosibles;
    }
    
    
    //Se a peza non e un peon ou un cabalo pasamos a calcular os movementos dun xeito Estandar
    private void calculoMovemento(Peza e){
        switch(e.getTipo()){
        case REI: case RAIÑA:
            calcularHorizontal(e);
            calcularVertical(e);
            calcularDiagonal(e);
            break;  
        case ALFIL:
            calcularDiagonal(e);
            break;
        case TORRE:
            calcularHorizontal(e);
            calcularVertical(e);
            break;
        case CABALO:
            calcularCabalo(e);
            break;
        case PEON:
            calcularVertical(e);
            calcularDiagonal(e);
            break;
        }
    }
    
    private void calcularVertical(Peza e){
        int y;
        int limitacionYpos=this.limitacionVerticalPositiva(e);
        int limitacionYneg=this.limitacionVerticalNegativa(e);
        
        for(y=fichaY; y<limitacionYpos ;y++){
            this.asignarPeza(fichaX,y , e);
            if(this.tabMovementosPosibles[fichaX][y]==2 || this.tabMovementosPosibles[fichaX][y]==3){
                break;
            }
        }
        
        for(y=fichaY; y>=limitacionYneg ;y--){
            this.asignarPeza(fichaX,y , e);
            if(this.tabMovementosPosibles[fichaX][y]==2 || this.tabMovementosPosibles[fichaX][y]==3){
                break;
            }
        }
    }
    
    private void calcularHorizontal(Peza e){
        int x;
        int limitacionXpos=this.limitacionHorizontalPositiva(e);
        int limitacionXneg=this.limitacionHorizontalNegativa(e);
       
        for(x=fichaX; x<limitacionXpos ;x++){
            this.asignarPeza(x, fichaY, e);
            if(this.tabMovementosPosibles[x][fichaY]==2 || this.tabMovementosPosibles[x][fichaY]==3){
                break;
            }
        }
        
        for(x=fichaX;  x>=limitacionXneg ;x--){
            this.asignarPeza(x, fichaY, e);
            if(this.tabMovementosPosibles[x][fichaY]==2 || this.tabMovementosPosibles[x][fichaY]==3){
                break;
            }
        }
    }
    
    private void calcularDiagonal(Peza e){
        int x , y;
        int limitacionXpos=this.limitacionHorizontalPositiva(e);
        int limitacionXneg=this.limitacionHorizontalNegativa(e);
        int limitacionYpos=this.limitacionVerticalPositiva(e);
        int limitacionYneg=this.limitacionVerticalNegativa(e);

        //Sentido x+ y+
        for(x=fichaX, y=fichaY;x<limitacionXpos && y<limitacionYpos;x++, y++){
            this.asignarPeza(x, y, e);
            if(this.tabMovementosPosibles[x][y]==2 || this.tabMovementosPosibles[x][y]==3){
                break;
            }
        }
        
        //Sentido x+ y-
        for(x=fichaX, y=fichaY; x<limitacionXpos && y>=limitacionYneg;x++, y--){
            this.asignarPeza(x, y, e);
            if(this.tabMovementosPosibles[x][y]==2 || this.tabMovementosPosibles[x][y]==3){
                break;
            }
        }
        
        //Sentido x- y+
        for(x=fichaX, y=fichaY;x>=limitacionXneg && y<limitacionYpos;x--, y++){
            this.asignarPeza(x, y, e);
            if(this.tabMovementosPosibles[x][y]==2 || this.tabMovementosPosibles[x][y]==3){
                break;
            }
        }
        
        //Sentido x- y-
        for(x=fichaX, y=fichaY;x>=limitacionXneg && y>=limitacionYneg;x--, y--){
            this.asignarPeza(x, y, e);
            if(this.tabMovementosPosibles[x][y]==2 || this.tabMovementosPosibles[x][y]==3){
                break;
            }
        }
    }
    
    private void calcularCabalo(Peza e){
        int x,y;

        x=fichaX+2; y=fichaY+1;
        if(x>=0 && x<8 && y>=0 && y<8){
            this.asignarPeza(x, y, e);
        }
        
        x=fichaX+1; y=fichaY+2;
        if(x>=0 && x<8 && y>=0 && y<8){
            this.asignarPeza(x, y, e);
        }
        
        x=fichaX+2; y=fichaY-1;
        if(x>=0 && x<8 && y>=0 && y<8){
            this.asignarPeza(x, y, e);
        }
        
        x=fichaX+1; y=fichaY-2;
        if(x>=0 && x<8 && y>=0 && y<8){
            this.asignarPeza(x, y, e);
        }
        
        
        x=fichaX-2; y=fichaY+1;
        if(x>=0 && x<8 && y>=0 && y<8){
            this.asignarPeza(x, y, e);
        }
        
        x=fichaX-1; y=fichaY+2;
        if(x>=0 && x<8 && y>=0 && y<8){
            this.asignarPeza(x, y, e);
        }
        
        x=fichaX-2; y=fichaY-1;
        if(x>=0 && x<8 && y>=0 && y<8){
            this.asignarPeza(x, y, e);
        }
        
        x=fichaX-1; y=fichaY-2;
        if(x>=0 && x<8 && y>=0 && y<8){
            this.asignarPeza(x, y, e);
        }
    }
    
    private void resetearTabMovementosPosibles(){
         for(int x=0; x<this.tabMovementosPosibles.length;x++){
             for(int y=0; y<this.tabMovementosPosibles.length;y++){
                 this.tabMovementosPosibles[x][y]=0;
             }
         }
    }
    
    private void asignarPeza(int x, int y, Peza e){
        if(this.tabCopia.haiPeza(x, y)){
            if(this.tabCopia.get(x, y).getPropiedadeDe().equals(e.getPropiedadeDe())){
                this.tabMovementosPosibles[x][y]=3;//CAMBIALO POR UN 0
            }else{
                this.tabMovementosPosibles[x][y]=2;
            }
        }else{
            this.tabMovementosPosibles[x][y]=1;
        }
        tabMovementosPosibles[fichaX][fichaY]=0;
    }
    
    
    
    /*
     ******************************************************
     */
    private int limitacionHorizontalPositiva(Peza e){
        if(e.getLimitacionHorizontal()==0){
            return this.tabMovementosPosibles.length;
        }else{
            if(fichaX+e.getLimitacionHorizontal()<tabMovementosPosibles.length){
                return fichaX+e.getLimitacionHorizontal()+1;
            }else{
                return this.tabMovementosPosibles.length;
            }
        }
    }
    
    private int limitacionHorizontalNegativa(Peza e){
        if(e.getLimitacionHorizontal()==0){
            return 0;
        }else{
            if(fichaX-e.getLimitacionHorizontal()>=0){
                return fichaX-e.getLimitacionHorizontal();
            }else{
                return 0;
            }
        }
    }
    
    private int limitacionVerticalPositiva(Peza e){
        if(e.getLimitacionVertical()==0){
            return this.tabMovementosPosibles.length;
        }else{
            if(fichaY+e.getLimitacionVertical()<tabMovementosPosibles.length){
                return fichaY+e.getLimitacionVertical()+1;
            }else{
                return this.tabMovementosPosibles.length;
            }
        }
    }
    
    private int limitacionVerticalNegativa(Peza e){
        if(e.getLimitacionVertical()==0){
            return 0;
        }else{
            if(fichaY-e.getLimitacionVertical()>=0){
                return fichaY-e.getLimitacionVertical();
            }else{
                return 0;
            }
        }
    }
    /*
     ******************************************************
     */
    
    
    
    public static void main(String args[]) {
        Xogo xog=new Xogo("pepe","carmela");
        XestorMovementos xestor= new XestorMovementos();
        xog.iniciarXogo();
        
        Xogo.tab.put(6, 5, new Peza(TipoPeza.REI, "carmela"));
        xestor.movementosPosibles(Xogo.tab,6, 5);
        
        int x;
        int y;
        System.out.println("     0 1 2 3 4 5 6 7 ");
        System.out.println("     | | | | | | | | ");
        for(x=0;x<xestor.tabMovementosPosibles.length;x++){
            System.out.print(x+"-- ");
            System.out.print("|");
            for(y=0;y<xestor.tabMovementosPosibles.length;y++){
                System.out.print(xestor.tabMovementosPosibles[x][y]+"|");
            }
            System.out.println("");
        }
        
    }
}
