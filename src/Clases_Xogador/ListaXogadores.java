/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Xogador;

import java.util.ArrayList;

/**
 *
 * @author Carlos
 */
public class ListaXogadores {
    private static ArrayList<Xogador> rexistro=new ArrayList<Xogador>();
    
    public static boolean comprobarExiste(String nom){
        for(int c=0;c<rexistro.size();c++){
            if(rexistro.get(c).getUser().equalsIgnoreCase(nom)){
                return true;
            }
        }
        return false;
    }
    
    public static void engadir(Xogador xog){
        rexistro.add(xog);
    }
    
    public static boolean comprobarLogIn(String nom, String pass){
        for(int c=0;c<rexistro.size();c++){
            if(rexistro.get(c).getUser().equalsIgnoreCase(nom) && rexistro.get(c).getPassword().equals(pass)){
                return true;
            }
        }
        return false;
    }
    
    public static Xogador getXogador(String user){
        for(Xogador x : ListaXogadores.rexistro){
            if(x.getUser().equalsIgnoreCase(user)){
                return x;
            }
        }
        return null;
    }
}
