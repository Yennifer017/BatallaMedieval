
package ipcb.proyecto2ydl.objetos;

import java.io.Serializable;

/**
 *
 * @author yenni
 */
public class ElixirVerde extends Objeto implements Serializable{

    public ElixirVerde() {
        tipoObjeto = "Elixir Verde";
        pathImage = "/images/elixir.png";
        costo=25;
        uso="Cura 50 de vida";
    }
    
}
