
package ipcb.proyecto2ydl.characters;

/**
 *
 * @author yenni
 */
public class Bruja extends Enemigo{
    public Bruja() {
        tipoPersonaje = "";
        pathImage = "/images/bruja.png";
        maxVida = 150;
        vida = maxVida;
        dano = 100;
        maxMov = 10;
        maxAlcanceAtaque = 0;
        vuela=true;
    }
}
