
package ipcb.proyecto2ydl.objetos;

import interfaces.PropiedadesObj;
import java.io.Serializable;

/**
 *
 * @author yenni
 */
public abstract class Objeto implements PropiedadesObj, Serializable{
    protected String pathImage;
    protected int costo;
    protected String uso, tipoObjeto;
    public Objeto() {
        pathImage = "";
        costo=0;
        tipoObjeto="";
    }
    
    @Override
    public String getPathImage(){
        return pathImage;
    }
    @Override
    public int getCosto(){
        return costo;
    }
    @Override
    public String getInfo(){
        return uso;
    }
    @Override
    public String getName(){
        return tipoObjeto;
    }
    
}
