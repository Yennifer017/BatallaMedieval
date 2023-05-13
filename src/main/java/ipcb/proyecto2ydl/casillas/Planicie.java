
package ipcb.proyecto2ydl.casillas;

import ipcb.proyecto2ydl.tablero.Coordenada;
import java.awt.Color;

/**
 *
 * @author yenni
 */
public class Planicie extends Casilla {

    public Planicie(Coordenada coordenada) {
        this.coordenada = coordenada;
        nombre = "-";
        dirIconImage = "/images/planicie.png";
        
    }
    @Override
    protected Color getColor(){
        return new Color(82, 72, 67);
    };
    
    
}
