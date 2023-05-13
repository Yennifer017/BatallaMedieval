
package ipcb.proyecto2ydl.characters;

/**
 *
 * @author yenni
 */
public class Flor extends Enemigo{
    public Flor() {
        tipoPersonaje = "Flor carnivora";
        pathImage = "/images/flor.png";
        maxVida = 250;
        vida = maxVida;
        dano = 30;
        maxMov = 0;
        maxAlcanceAtaque = 3;
        vuela=false;
    }
}
