
package ipcb.proyecto2ydl.objetos;

import java.io.Serializable;

/**
 *
 * @author yenni
 */
public class SemillaVida extends Objeto implements Serializable{

    public SemillaVida() {
        tipoObjeto = "Semilla de vida";
        pathImage = "/images/semilla.png";
        costo=50;
        uso = "Resucita a un personaje muerto en batalla";
    }
    
}
