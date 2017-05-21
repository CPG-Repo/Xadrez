/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excepcions;

/**
 *
 * @author Carlos
 */
public class UserException extends Exception {
    int tipo;
    public UserException(int n){
        this.tipo=n;
    }
    @Override
    public String getMessage() {
        switch (tipo){
            case 1:
                return "Erro-> Usuario/Contrasinal: Esta baleiro";
            case 2:
                return "Erro-> O usuario debe comezar por unha Letra";
            case 3:
                return "Erro-> O usuario/contrasinal: NON cumpre a lonxitude minima";
            case 4:
                return "Erro-> na Asignacion do Nome de Usuario";
            case 5:
                return "Erro-> O usuario/contrasinal: Non pode conter espazos en Branco";
            case 6:
                return "Erro-> O Usuario SÓ pode conter letras ou numeros";
            case 7:
                return "Erro-> O Contrasinal DEBE levar como minimo 1 letra, 1 numero e 1 caracter especial";
            default:
                return "Erro";
        }
    }
}
