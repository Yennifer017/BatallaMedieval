
package ipcb.proyecto2ydl.characters;

import java.io.Serializable;

/**
 *
 * @author yenni
 */
public class Dragon extends Jugable implements Serializable{

    public Dragon(String name) {
        tipoPersonaje = name;
        pathImage = "/images/dragon.png";
        maxVida = 250;
        vida=maxVida;
        dano = 75;
        maxMov = 3;
        maxAlcanceAtaque = 2;
        vuela=true;
    }
    
}
