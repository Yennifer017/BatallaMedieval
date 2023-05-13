
package ipcb.proyecto2ydl.characters;

/**
 *
 * @author yenni
 */
public class Ogro extends Enemigo{
    public Ogro() {
        tipoPersonaje = "Ogro";
        pathImage = "/images/ogro.png";
        maxVida = 300;
        vida = maxVida;
        dano = 50;
        maxMov = 1;
        maxAlcanceAtaque = 1;
        vuela=false;
    }
}
