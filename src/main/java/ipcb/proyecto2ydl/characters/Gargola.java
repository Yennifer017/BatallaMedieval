
package ipcb.proyecto2ydl.characters;

/**
 *
 * @author yenni
 */
public class Gargola extends Enemigo{
    public Gargola() {
        tipoPersonaje = "gargola";
        pathImage = "/images/gargola.png";
        maxVida = 150;
        vida = maxVida;
        dano = 100;
        maxMov = 3;
        maxAlcanceAtaque = 3;
        vuela=true;
    }
}
