/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Peza;

import Xestion_Movementos.Movemento;
import javax.swing.ImageIcon;


/**
 *
 * @author Carlos
 */
public class Peza {

    private boolean estado=true;
    private TipoPeza tipo;
    private String propiedadeDe;
    private Movemento direccionMovemento;
    private int limitacionVertical;
    private int limitacionHorizontal;
    private int limitacionDiagonal;
    private ImageIcon iconaxog1; 
    private ImageIcon iconaxog2;

    
    public Peza(TipoPeza quePeza,String xogador){
        switch(quePeza){
            case PEON:
                this.direccionMovemento=Movemento.VERTICAL_DIAGONAL;
                this.limitacionDiagonal=1;
                this.limitacionVertical=1;
                this.tipo=quePeza;
                this.iconaxog1=new javax.swing.ImageIcon(".\\resources\\Pezas Xadrez\\PeonBranco.png");
                this.iconaxog2=new javax.swing.ImageIcon(".\\resources\\Pezas Xadrez\\PeonNegro.png");
                this.propiedadeDe=xogador;
                break;
                
            case TORRE:
                this.direccionMovemento= Movemento.VERTICAL_HORIZONTAL;
                this.tipo=quePeza;
                this.iconaxog1=new javax.swing.ImageIcon(".\\resources\\Pezas Xadrez\\TorreBranca.png");
                this.iconaxog2=new javax.swing.ImageIcon(".\\resources\\Pezas Xadrez\\TorreNegra.png");
                this.propiedadeDe=xogador;
                break;
            case ALFIL:
                this.direccionMovemento= Movemento.DIAGONAL;
                this.tipo=quePeza;
                this.iconaxog1=new javax.swing.ImageIcon(".\\resources\\Pezas Xadrez\\AlfilBranco.png");
                this.iconaxog2=new javax.swing.ImageIcon(".\\resources\\Pezas Xadrez\\AlfilNegro.png");
                this.propiedadeDe=xogador;
                break;
            case CABALO:
                this.direccionMovemento= Movemento.EN_L;
                this.tipo=quePeza;
                this.iconaxog1=new javax.swing.ImageIcon(".\\resources\\Pezas Xadrez\\CabaloBranco.png");
                this.iconaxog2=new javax.swing.ImageIcon(".\\resources\\Pezas Xadrez\\CabaloNegro.png");
                this.propiedadeDe=xogador;
                break;
            case REI:
                this.direccionMovemento= Movemento.VERTICAL_HORIZONTA_DIAGONAL;
                this.limitacionDiagonal=1;
                this.limitacionHorizontal=1;
                this.limitacionVertical=1;
                this.tipo=quePeza;
                this.iconaxog1=new javax.swing.ImageIcon(".\\resources\\Pezas Xadrez\\ReiBranco.png");
                this.iconaxog2=new javax.swing.ImageIcon(".\\resources\\Pezas Xadrez\\ReiNegro.png");
                this.propiedadeDe=xogador;
                break;
            case RAIÑA:
                this.direccionMovemento= Movemento.VERTICAL_HORIZONTA_DIAGONAL;
                this.tipo=quePeza;
                this.iconaxog1=new javax.swing.ImageIcon(".\\resources\\Pezas Xadrez\\RaiñaBranca.png");
                this.iconaxog2=new javax.swing.ImageIcon(".\\resources\\Pezas Xadrez\\RaiñaNegra.png");
                this.propiedadeDe=xogador;
                break;
        }
    }
    
    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public TipoPeza getTipo() {
        return tipo;
    }

    public void setTipo(TipoPeza tipo) {
        this.tipo = tipo;
    }

    public String getPropiedadeDe() {
        return propiedadeDe;
    }

    public void setPropiedadeDe(String propiedadeDe) {
        this.propiedadeDe = propiedadeDe;
    }

    public Movemento getDireccionMovemento() {
        return direccionMovemento;
    }

    public void setDireccionMovemento(Movemento direccionMovemento) {
        this.direccionMovemento = direccionMovemento;
    }

    public int getLimitacionVertical() {
        return limitacionVertical;
    }

    public void setLimitacionVertical(int limitacionVertical) {
        this.limitacionVertical = limitacionVertical;
    }

    public int getLimitacionHorizontal() {
        return limitacionHorizontal;
    }

    public void setLimitacionHorizontal(int limitacionHorizontal) {
        this.limitacionHorizontal = limitacionHorizontal;
    }

    public int getLimitacionDiagonal() {
        return limitacionDiagonal;
    }

    public void setLimitacionDiagonal(int limitacionDiagonal) {
        this.limitacionDiagonal = limitacionDiagonal;
    }
    
    public ImageIcon getIconaxog1() {
        return iconaxog1;
    }

    public ImageIcon getIconaxog2() {
        return iconaxog2;
    }
    
}
