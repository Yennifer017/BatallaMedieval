
package ipcb.proyecto2ydl.casillas;

import ipcb.proyecto2ydl.tablero.Coordenada;
import java.awt.Color;

/**
 *
 * @author yenni
 */
public class Arbol extends Casilla {
    public Arbol(Coordenada coordenada) {
        this.coordenada = coordenada;
        nombre = "T";
        dirIconImage = "/images/arbol.png";
    }
    @Override
    protected Color getColor(){
        return Color.GREEN;
    };
}
