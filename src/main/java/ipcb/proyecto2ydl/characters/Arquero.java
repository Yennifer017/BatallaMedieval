
package ipcb.proyecto2ydl.characters;

import java.io.Serializable;

/**
 *
 * @author yenni
 */
public class Arquero extends Jugable implements Serializable{

    public Arquero(String name) {
        tipoPersonaje = name;
        pathImage = "/images/arquero.png";
        maxVida = 300;
        vida = maxVida;
        dano = 100;
        maxMov = 3;
        maxAlcanceAtaque = 3;
        vuela=false;
    }
    
}
