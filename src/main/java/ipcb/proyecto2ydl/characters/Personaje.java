
package ipcb.proyecto2ydl.characters;

import ipcb.proyecto2ydl.casillas.*;
import ipcb.proyecto2ydl.tablero.Coordenada;
import ipcb.proyecto2ydl.tablero.Tablero;
import java.io.Serializable;
import javax.swing.JOptionPane;

/**
 *
 * @author yenni
 */
public abstract class Personaje implements Serializable{
    protected String pathImage, tipoPersonaje;
    protected double maxVida, vida;
    protected int dano, maxMov, maxAlcanceAtaque;
    protected boolean vuela;
    protected Coordenada coordenada;
    public Personaje() {
        pathImage = "";
    }
    
    public String getPathImage(){
        return pathImage;
    }
    public String getName(){
        return tipoPersonaje;
    }

    public double getMaxVida() {
        return maxVida;
    }

    public int getDano() {
        return dano;
    }

    public int getMaxMov() {
        return maxMov;
    }

    public int getMaxAlcanceAtaque() {
        return maxAlcanceAtaque;
    }

    public boolean vuela() {
        return vuela;
    }

    public double getVida() {
        return vida;
    }
    public void setPrimeraCoordenada(Coordenada coordenada){
        this.coordenada = coordenada;
    }
    public void enableMovimientosValidos(Tablero tablero){
        Casilla casillaPersonaje = tablero.getCasilla(coordenada);
        casillaPersonaje.setEnabled(true);
        for (int i = 0; i < 4; i++) { //hasta 4 para poder abarcar las 4 direcciones
            Coordenada inicial = coordenada;
            for (int j = 0; j < maxMov; j++) {
                Coordenada enableBtnCoor = inicial.getRectCoorFromThis(i); //wasd
                if(enableBtnCoor.valida(tablero)){
                    Casilla casilla = tablero.getCasilla(enableBtnCoor);
                    casilla.inicializar(true);
                    casilla.setEnabled(true);
                    inicial = enableBtnCoor;
                }else{
                    break;
                }
            }
        }
    }
    public void moverse(Coordenada coordenada, Tablero tablero){
        if(vuela){
            moverVolador(coordenada, tablero);
        }else{
            moverNoVolador(coordenada, tablero);
        }
    }
    private void moverVolador(Coordenada coordenada, Tablero tablero){
        Casilla casillaInicial = tablero.getCasilla(this.coordenada);
        Casilla destino = tablero.getCasilla(coordenada);
        if(destino instanceof Agua){
            JOptionPane.showMessageDialog(null, "El personaje no puede posicionarse aqui");
        }else{
            //casillaInicial.inicializar();
            //try {
                casillaInicial.inicializar();
                //Thread.sleep(1000);
                destino.ingresarPersonaje(this);
                //Thread.sleep(1000);
            //} catch (Exception e) {
            //}
            //destino.ingresarPersonaje(this);
            this.coordenada = destino.getCoordenada();
        }
    }
    private void moverNoVolador(Coordenada coordenada, Tablero tablero){
        char direccion = this.coordenada.getDirection(coordenada);
        int moves =  this.coordenada.getHowManyMovs(coordenada);
        for (int i = 0; i < moves; i++) {
            Casilla casillaInicial = tablero.getCasilla(this.coordenada);
            Coordenada movimientoPrevio = this.coordenada.getRectCoorFromThis(direccion);
            Casilla destino = tablero.getCasilla(movimientoPrevio);
            if(destino instanceof Agua || destino instanceof Arbol){
                JOptionPane.showMessageDialog(null, 
                        "El personaje no puede posicionarse aqui");
                break;
            }else{
                
                //try {
                    casillaInicial.inicializar();
                    //Thread.sleep(1000);
                    //destino.setBackground(Color.red);
                    //Thread.sleep(1000);
                    destino.ingresarPersonaje(this);
                    this.coordenada = destino.getCoordenada();
                //} catch (Exception e) {
                //}
                
            }
        }
    }
    
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
}
