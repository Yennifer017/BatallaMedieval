
package ipcb.proyecto2ydl.menus;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author yenni
 */
public class ImgUtil {
    public ImageIcon getImgAEscala(String path, int width, int height){
        //Obtener un icono desde la ruta dinamica, esto de la misma manera que lo tiene neatBeans
        Icon iconoOriginal = new ImageIcon(getClass().getResource(path));
        //casteo
        ImageIcon i = (ImageIcon) iconoOriginal;    
        //escalar la imagen de tal manera que se ajuste al boton
        ImageIcon aEscala = new ImageIcon(i.getImage().getScaledInstance(width, height, 
                java.awt.Image.SCALE_SMOOTH));
        //colocar como tal el icono
        return aEscala;
    }
    public void setImagenOro(JLabel displayOro){
        displayOro.setIcon(getImgAEscala("/images/oro.png", displayOro.getWidth(), 
                displayOro.getHeight()));
    }
}
