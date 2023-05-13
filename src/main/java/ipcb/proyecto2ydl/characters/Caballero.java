
package ipcb.proyecto2ydl.characters;

import java.io.Serializable;

/**
 *
 * @author yenni
 */
public class Caballero extends Jugable implements Serializable{

    public Caballero(String name) {
        tipoPersonaje = name;
        pathImage = "/images/caballero.png";
        maxVida = 300;
        vida = maxVida;
        dano = 45;
        maxMov = 1;
        maxAlcanceAtaque = 1;
        vuela=false;
    }
    
    
}
