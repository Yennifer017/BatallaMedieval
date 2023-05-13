
package ipcb.proyecto2ydl.tablero;

import excepciones.TableroException;
import ipcb.proyecto2ydl.casillas.*;
import java.awt.Color;
import java.io.Serializable;

/**
 *
 * @author yenni
 */
public class Tablero implements Serializable{

    private final String id;
    private final Dimensiones dimensiones;
    private boolean tableroValido;
    private Casilla[][] tablero;
            
    public Tablero(String id, Dimensiones dimensiones, String[] contenido) throws TableroException{
        this.id = id;
        this.dimensiones = dimensiones;
        this.rellenarTablero(contenido);
        
    }
    public Tablero(String id, Casilla[][] elementos){
        this.id = id;
        tablero = elementos;
        this.dimensiones = new Dimensiones(elementos.length, elementos[0].length);
    }
    
    private void rellenarTablero(String[] contenido) throws TableroException{
        if(dimensiones.valido()){
            tablero = new Casilla[dimensiones.getDimX()][dimensiones.getDimY()];
            int contador=0;
            try {
                for (int j = 0; j < tablero[0].length; j++) {
                    for (int i = 0; i < tablero.length; i++) {
                        Coordenada coordenada = new Coordenada(i, j);
                        tablero[i][j] = selectCasillaRelleno(contenido[contador], coordenada);
                        contador++;
                    }
                tableroValido=true;
            }
            } catch (IndexOutOfBoundsException e) {
                throw new TableroException("Elementos insuficientes para construir el tablero");
            }
        }else{
            throw new TableroException("Las dimensiones no se especificaron correctamente");
        }
    }
    private Casilla selectCasillaRelleno(String tipoCasilla, Coordenada coordenada) throws TableroException{
        Casilla casilla = switch (tipoCasilla) {
            case "~"-> new Agua(coordenada);
            case "-"-> new Planicie(coordenada);
            case "T","t"-> new Arbol(coordenada);
            case "#" -> new Lava(coordenada);
            default -> throw new TableroException();
        };
        return casilla;
    }
    private String[][] generateElementsTxt(Casilla[][] tablero){
        String[][] tableroTxt = new String[tablero.length][tablero[0].length];
        for (int j = 0; j < tablero[0].length; j++) {
            for (int i = 0; i < tablero.length; i++) {
                tableroTxt[i][j] = tablero[i][j].getNombre();
            }
        }
        return tableroTxt;
    }
    
    public boolean valido(){
        return tableroValido;
    }

    public String getId() {
        return id;
    }

    public int getLengthX() {
        return dimensiones.getDimX();
    }
    public int getLengthY() {
        return dimensiones.getDimY();
    }
    
    public Casilla getCasilla(int x, int y){
        return tablero[x][y];
    }
    public Casilla getCasilla(Coordenada coordenada){
        return tablero[coordenada.getX()][coordenada.getY()];
    }

    public String getElementosTxt() {
        String[][] elementosTxt = generateElementsTxt(tablero);
        String elementos= "Tablero:" + id + "\n";
        elementos+="Dimensiones: "+ dimensiones.getDimX() + "X" + dimensiones.getDimY()+ "\n\n";
        for (int j = 0; j < tablero[0].length; j++) {
            for (int i = 0; i < tablero.length; i++) {
                elementos += elementosTxt[i][j] + " ";
            }
            elementos+="\n";
        }
        return elementos;
    }
    
    public void disable(){
        for (int j = 0; j < tablero[0].length; j++) {
            for (int i = 0; i < tablero.length; i++) {
                tablero[i][j].setBackground(Color.GRAY);
                tablero[i][j].setEnabled(false);
            }
        }
    }
    public int getTotalCasillas(){
        int contador=0;
        for (int j = 0; j < tablero[0].length; j++) {
            for (int i = 0; i < tablero.length; i++) {
                contador ++;
            }
        }
        return contador;
    }
    
}
