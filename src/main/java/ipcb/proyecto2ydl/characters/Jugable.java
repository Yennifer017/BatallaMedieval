
package ipcb.proyecto2ydl.characters;

import interfaces.PropiedadesObj;
import java.io.Serializable;

/**
 *
 * @author yenni
 */
public abstract class Jugable extends Personaje implements PropiedadesObj,Serializable{
    protected int costo;
    //protected String infoPropiedades;

    public Jugable() {
        costo = 200;
    }

    @Override
    public int getCosto(){
        return costo;
    }
    @Override
    public String getInfo(){
        String infoPropiedades= "     ## Personaje: " + tipoPersonaje + " ##     \n\n";
        if(vuela){
            infoPropiedades += "El personaje puede volar, por lo que puede atravesar ciertos obstaculos.";
        }else{
            infoPropiedades += "El personaje no puede volar, por lo que no puede atravesar ciertos obstaculos.";   
        }
        infoPropiedades += "\n";
        infoPropiedades += "Rango maximo de movimiento = " + maxMov + " casilla(s)\n\n" ;
        infoPropiedades += "Vida maxima = " + maxVida + "\n";
        infoPropiedades += "Ataque = " + dano + "\n";
        infoPropiedades += "Maximo alcance de ataque = " + maxAlcanceAtaque + " casilla(s)\n\n";
        return infoPropiedades;
    }
    public void mejorar(String tipoMejora, int mejora){
        tipoMejora = tipoMejora.toLowerCase();
        switch (tipoMejora) {
            case "vida" -> {
                maxVida +=mejora;
                vida = maxVida;
            }
            case "ataque" -> dano+=mejora;
            case "movilidad" -> maxMov+=mejora;
            default -> System.out.println("No se ha mejorado nada");
        }
    }
    
}
