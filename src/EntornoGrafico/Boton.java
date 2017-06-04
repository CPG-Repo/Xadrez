/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntornoGrafico;

import javax.swing.JButton;

/**
 *
 * @author Carlos
 */
public class Boton extends JButton{
    private boolean clickado=false;
    private boolean posibleMov=false;

    
    private int botonX,botonY;

    
    
    public Boton(int x,int y, int alto, int ancho){
        this.setBounds(x*90, y*90, alto, ancho);
        this.botonX=x;
        this.botonY=y;
    }
 
    public void mudarEstadoClickado(){
        if(this.clickado==true){
            this.clickado=false;
        }else if(this.clickado==false){
            this.clickado=true;
        }
    }
    
    public void resetearEstado(){
        this.clickado=false;
        this.posibleMov=false;
    }
    
       
    public void setName(int x, int y){
        this.setText((x+1)+"-"+(y+1));
    }
    
    
    public int getBotonX() {
        return botonX;
    }

    public int getBotonY() {
        return botonY;
    }

    public boolean isClickado() {
        return clickado;
    }
    
    public boolean isPosibleMov() {
        return posibleMov;
    }

    public void setPosibleMov(boolean posibleMov) {
        this.posibleMov = posibleMov;
    }
}
