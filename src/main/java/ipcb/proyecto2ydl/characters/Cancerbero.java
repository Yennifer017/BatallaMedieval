
package ipcb.proyecto2ydl.characters;

/**
 *
 * @author yenni
 */
public class Cancerbero extends Enemigo{
    public Cancerbero() {
        tipoPersonaje = "Cancerbero";
        pathImage = "/images/cerbero.png";
        maxVida = 400;
        vida = maxVida;
        dano = 45;
        maxMov = 1;
        maxAlcanceAtaque = 1;
        vuela=false;
    }
}
