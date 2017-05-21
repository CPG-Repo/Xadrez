/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Xogador;

import Excepcions.UserException;

/**
 *
 * @author Carlos
 */
public class Xogador {
    private String user;
    private String password;
    
    public Xogador(String usuario, String pass) throws UserException{
        if(this.comprobarUsuario(usuario)){
            if(comprobarContrasinal(pass)){
                user=usuario;
                password=pass;
            };
        }else{
            throw new UserException(4);
        }
    }
    
    //Comproba Usuario Comprobando que cumpra as condicions Establecidas
    private boolean comprobarUsuario(String us) throws UserException{
        if (this.comprobarBaleiroNull(us)|
            this.comprobarCaracterInicial(us)|
            this.comprobarLonxitude(us, 5)|
            this.comprobarEspazos(us)|
            this.comprobarSiTodoLetrasOuNumeros(us)){
            
            
            return true;
        }else{
            return false;
        }
    }
    
    //Comproba Contrasinal Comprobando que cumpra as condicions Establecidas
    private boolean comprobarContrasinal(String contra) throws UserException{
        if (this.comprobarBaleiroNull(contra)|
            this.comprobarEspazos(contra)|
            this.comprobarLonxitude(contra, 8)|
            this.comprobarLimitacionContrasinal(contra)){

            return true;
        }else{
            return false;
        }
    }
    
    //Metodos de comprobacion de Condicions individuais
    private boolean comprobarLimitacionContrasinal(String contra) throws UserException{
        int c, contadorLetras=0,contadorNumeros=0, contadorEspeciais=0;
        char[] cadea=contra.toCharArray();
        for(c=0;c<cadea.length;c++){
            if(Character.isDigit(cadea[c])){
                contadorNumeros++;
            }else if(Character.isLetter(cadea[c])){
                contadorLetras++;
            }else{
                contadorEspeciais++;
            }
        }if(contadorLetras==0|contadorNumeros==0|contadorEspeciais==0){
            throw new UserException(7);
        }else
            return true;
    }
    private boolean comprobarEspazos(String us) throws UserException{
        int c;
        char[] cadea=us.toCharArray();
        for(c=0;c<cadea.length;c++){
            if(Character.isWhitespace(cadea[c])){
                throw new UserException(5);
            }
        }
        return false;
    }
    private boolean comprobarBaleiroNull(String us) throws UserException{
        if(us.isEmpty()|us.equals(null)){
            throw new UserException(1);
        }else{
            return true;
        }
    }
    private boolean comprobarCaracterInicial(String us) throws UserException{
        if(Character.isLetter(us.charAt(0))){
            return true;
        }else{
            throw new UserException(2);           
        }
    }
    private boolean comprobarLonxitude(String us,int lonxitude) throws UserException{
        if(us.length()>=lonxitude){
            return true;
        }else{
            throw new UserException(3);
        }
    }
    private boolean comprobarSiTodoLetrasOuNumeros(String us) throws UserException{
        int c;
        char[] cadea=us.toCharArray();
        for(c=0;c<cadea.length;c++){
            if(!Character.isLetterOrDigit(cadea[c])){
              throw new UserException(6);
            }
        }
        return false;
    }
    //Fin de Metodos de comprobacion de condicions individuais

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
