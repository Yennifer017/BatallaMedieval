
package ipcb.proyecto2ydl.tablero;

import excepciones.CasillaException;
import excepciones.LecturaException;
import ipcb.proyecto2ydl.casillas.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author yenni
 */
public class CrearTableroLogic {
    
    private String seleccionCas;
    private GenericaCas[][] casillas;
    public CrearTableroLogic() {
        seleccionCas="planicie";
    }
    public Dimensiones leerDimensiones(JTextField x, JTextField y) throws LecturaException{
        Dimensiones dimensiones;
        try {
            int dimX = Integer.parseInt(x.getText());
            int dimY = Integer.parseInt(y.getText());
            dimensiones = new Dimensiones(dimX, dimY);
            if(!dimensiones.valido()){
                throw new LecturaException("Las dimensiones no son validas");
            }
            return dimensiones;
        } catch (NumberFormatException e) {
            throw new LecturaException("No se han logrado leer las dimensiones");
        }
    }
    public void inicializarCreador(Dimensiones dimension, JPanel panelTablero){
        int ancho =panelTablero.getWidth()/dimension.getDimX();
        int largo =panelTablero.getHeight()/dimension.getDimY();
        int x = 0;
        int y = 0;
        casillas = generarCasillasGen(dimension);
        for (int j = 0; j < dimension.getDimY(); j++) {
            for (int i = 0; i < dimension.getDimX(); i++) {
                GenericaCas currentCasilla = casillas[i][j];
                currentCasilla.setBounds(x, y, ancho, largo);
                currentCasilla.setBackground(Color.lightGray);
                currentCasilla.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){ //anadimos el evento de los botones
                        try {
                            currentCasilla.convert(seleccionCas, casillas);
                        } catch (CasillaException ex) {
                            JOptionPane.showMessageDialog(null, ex.toString());
                        }
                    }
                });
                panelTablero.add(currentCasilla);
                //panelTablero.revalidate();
                //panelTablero.repaint();
                x+= ancho;
            }
            y+=largo;
            x=0;
        }
        panelTablero.revalidate();
        panelTablero.repaint();
    }
    private GenericaCas[][] generarCasillasGen(Dimensiones dimension){
        GenericaCas[][] casillas = new GenericaCas[dimension.getDimX()][dimension.getDimY()];
        for (int j = 0; j < dimension.getDimY(); j++) {
            for (int i = 0; i < dimension.getDimX(); i++) {
                Coordenada coordenada = new Coordenada(i, j);
                casillas[i][j] = new GenericaCas(coordenada);
            }
        }
        return casillas;
    }
    public void setSeleccionCasilla(String seleccion){
        this.seleccionCas = seleccion;
    }
    public Casilla[][] getContentTabCreado(){
        Casilla[][] contenidoTab = new Casilla[casillas.length][casillas[0].length];
        for (int j = 0; j < casillas[0].length; j++) {
            for (int i = 0; i < casillas.length; i++) {
                Coordenada coordenada = new Coordenada(i, j);
                contenidoTab[i][j] = switch (casillas[i][j].getNombre()) {
                    case "~" -> new Agua(coordenada);
                    case "T" -> new Arbol(coordenada);
                    case "#" -> new Lava(coordenada);
                    default -> new Planicie(coordenada);
                };
            }
        }
        return contenidoTab;
    }
    
}
