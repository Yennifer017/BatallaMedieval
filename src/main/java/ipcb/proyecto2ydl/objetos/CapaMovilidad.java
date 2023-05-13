
package ipcb.proyecto2ydl.objetos;

import java.io.Serializable;

/**
 *
 * @author yenni
 */
public class CapaMovilidad extends Objeto implements Serializable{

    public CapaMovilidad() {
        tipoObjeto = "Capa de movilidad";
        pathImage = "/images/capa.png";
        costo=75;
        uso = "Mueve al personaje una casilla extra a su alrededor";
    }
    
}
