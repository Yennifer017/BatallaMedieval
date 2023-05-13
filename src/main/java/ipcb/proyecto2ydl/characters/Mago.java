
package ipcb.proyecto2ydl.characters;

import java.io.Serializable;

/**
 *
 * @author yenni
 */
public class Mago extends Jugable implements Serializable{

    public Mago(String name) {
        tipoPersonaje = name;
        pathImage = "/images/mago.png";
        maxVida = 100;
        vida = maxVida;
        dano = 60;
        maxMov = 3;
        //maxAlcanceAtaque = 5;//todo
        vuela=true;
    }
    
}
