
package ipcb.proyecto2ydl.casillas;

import ipcb.proyecto2ydl.tablero.Coordenada;
import java.awt.Color;

/**
 *
 * @author yenni
 */
public class Lava extends Casilla {
    public Lava(Coordenada coordenada) {
        this.coordenada = coordenada;
        nombre = "#";
        dirIconImage = "/images/fuego.png";
    }
    @Override
    protected Color getColor(){
        return Color.RED;
    };
}
