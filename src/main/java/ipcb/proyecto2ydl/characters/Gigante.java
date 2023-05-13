
package ipcb.proyecto2ydl.characters;

import java.io.Serializable;

/**
 *
 * @author yenni
 */
public class Gigante extends Jugable implements Serializable{

    public Gigante(String name) {
        tipoPersonaje = name;
        pathImage = "/images/gigante.png";
        maxVida = 350;
        vida = maxVida;
        dano = 56;
        maxMov = 1;
        maxAlcanceAtaque = 3;
        vuela=false;
    }
    
}
