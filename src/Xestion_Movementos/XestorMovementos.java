/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Xestion_Movementos;

import Clases_Peza.Peza;
import java.util.ArrayList;

/**
 *
 * @author Carlos
 */
public class XestorMovementos {
    ArrayList<Peza>[][] taboleiro = new ArrayList[8][8];
    ArrayList<Peza>[][] posiblesMovementos = new ArrayList[8][8];
    
    public XestorMovementos(Peza[][] tab, int pezaX, int pezaY, Movemento direccion){
        Peza ficha;
        ficha=taboleiro[pezaX][pezaY].get(pezaX);
        taboleiro[1][1].getClass();
    }
    
    public ArrayList[][] movementosPosibles(ArrayList[][] tab, int pezaX, int pezaY){
        return null;
    }
    
    private void Horizontal(int pezaX,int pezaY){
        int coordX, coordY;
        boolean pezaNoCamiño=false;
        for(coordX=pezaX;coordX<0;pezaX++){
            
        }
    }
}
