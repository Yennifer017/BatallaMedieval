
package ipcb.proyecto2ydl.casillas;

import ipcb.proyecto2ydl.tablero.Coordenada;
import java.awt.Color;

/**
 *
 * @author yenni
 */
public class Agua extends Casilla {
    public Agua(Coordenada coordenada) {
        this.coordenada = coordenada;
        nombre = "~";
        dirIconImage = "/images/agua.png";
    }
    @Override
    protected Color getColor(){
        return Color.blue;
    };
}
