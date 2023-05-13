
package ipcb.proyecto2ydl.casillas;

import excepciones.CasillaException;
import ipcb.proyecto2ydl.menus.ImgUtil;
import ipcb.proyecto2ydl.tablero.Coordenada;
import java.awt.Color;

/**
 *
 * @author yenni
 */
public class GenericaCas extends Casilla{

    Coordenada coordenada;
    public GenericaCas(Coordenada coordenada) {
        nombre="-";
        this.coordenada = coordenada;
    }
    
    @Override
    protected Color getColor(){
        return Color.LIGHT_GRAY;
    };
    @Override
    public void inicializar(){
        this.setBackground(getColor());
    }
    public void convert(String tipoCas, GenericaCas[][] preTab) throws CasillaException{
        tipoCas = tipoCas.toLowerCase();
        switch (tipoCas) {
            case "agua":
                allowAgua(preTab);
                break;
            case "arbol":
                nombre="T";
                dirIconImage = "/images/arbol.png";
                this.setBackground(Color.green);
                break;
            case "lava":
                nombre="#";
                dirIconImage = "/images/fuego.png";
                this.setBackground(Color.red);
                break;
            case "planicie":
                dirIconImage="";
                nombre="-";
                this.setBackground(Color.lightGray);
                break;
            default:
                dirIconImage="";
                break;
                
        }
        ImgUtil imgU = new ImgUtil();
        this.setIcon(imgU.getImgAEscala(dirIconImage, 
                this.getWidth(), this.getHeight()));
    }
    private void allowAgua(GenericaCas[][] preTab) throws CasillaException{
        boolean agregada=false;
        if(coordenada.getX()==0 || coordenada.getY()==0 || coordenada.getX()==(preTab.length-1)
                || coordenada.getY()== preTab[0].length-1){
            convertAgua();
        }else{ //cuando ya no esta en las orillas
            for (int i = 0; i <= 3; i++) {
                Coordenada check = coordenada.getRectCoorFromThis(i);
                if(preTab[check.getX()][check.getY()].getNombre().equals("~")){
                    agregada=true;
                    convertAgua();
                    break;
                }
            }
            if(!agregada){
                throw new CasillaException("La casilla de agua debe generarse desde las orillas");
            }
        }
        
            
    }
    
    private void convertAgua(){
        nombre="~";
        dirIconImage = "/images/agua.png";
        this.setBackground(Color.blue);
    }
    
}
