
package ipcb.proyecto2ydl.tablero;

import java.io.Serializable;

/**
 *
 * @author yenni
 */
public class Dimensiones implements Serializable{
    private int dimX, dimY;
    public Dimensiones(int x, int y) {
        dimX = x;
        dimY = y;
    }
    public boolean valido(){
        return dimX>=4&&dimY>=4;
    }

    public int getDimX() {
        return dimX;
    }

    public int getDimY() {
        return dimY;
    }
    
}
