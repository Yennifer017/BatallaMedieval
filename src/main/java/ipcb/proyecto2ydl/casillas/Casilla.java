
package ipcb.proyecto2ydl.casillas;

import ipcb.proyecto2ydl.characters.Jugable;
import ipcb.proyecto2ydl.characters.Personaje;
import ipcb.proyecto2ydl.menus.ImgUtil;
import ipcb.proyecto2ydl.tablero.Coordenada;
import java.awt.Color;
import javax.swing.JButton;

/**
 *
 * @author yenni
 */
public abstract class Casilla extends JButton{
    protected Coordenada coordenada;
    protected String dirIconImage;
    protected String nombre;
    protected Personaje personaje;
    protected abstract Color getColor();
    protected boolean containsCharacter;
    public Casilla() {
        dirIconImage = "";
    }
    
    public void inicializar(){
        containsCharacter=false;
        this.setBackground(getColor());
        ImgUtil imgU = new ImgUtil();
        this.setIcon(imgU.getImgAEscala(dirIconImage, 
                this.getWidth(), this.getHeight()));
    }
    
    public void inicializar(boolean sobreescribir){
        if(!sobreescribir && this.personaje != null && !(this.personaje instanceof Jugable)){
            this.setBackground(Color.BLACK);
            ImgUtil imgU = new ImgUtil();
            this.setIcon(imgU.getImgAEscala(personaje.getPathImage(), 
                    this.getWidth(), this.getHeight()));
        }else{
            inicializar();
        }
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void ingresarPersonaje(Personaje personaje){
        containsCharacter = true;
        this.personaje = personaje;
        this.setBackground(Color.BLACK);
        ImgUtil imgU = new ImgUtil();
        this.setIcon(imgU.getImgAEscala(personaje.getPathImage(), 
                this.getWidth(), this.getHeight()));
    }
            
    public Coordenada getCoordenada(){
        return coordenada;
    }
    public boolean containsCharacter(){
        return containsCharacter;
    }
    
    
    
}
