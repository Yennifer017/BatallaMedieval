
package ipcb.proyecto2ydl.admiPlayers;

import ipcb.proyecto2ydl.casillas.Casilla;
import ipcb.proyecto2ydl.casillas.Planicie;
import ipcb.proyecto2ydl.characters.Bruja;
import ipcb.proyecto2ydl.characters.Cancerbero;
import ipcb.proyecto2ydl.characters.Enemigo;
import ipcb.proyecto2ydl.characters.Flor;
import ipcb.proyecto2ydl.characters.Gargola;
import ipcb.proyecto2ydl.characters.Ogro;
import ipcb.proyecto2ydl.tablero.Coordenada;
import ipcb.proyecto2ydl.tablero.Tablero;
import java.util.Random;

/**
 *
 * @author yenni
 */
public class AdmiEnemigos extends Thread{

    private Enemigo[] enemigos;
    public AdmiEnemigos(int dificultad) {
        this.enemigos = crearEnemigos(dificultad);
        System.out.println(dificultad);
    }

    private Enemigo[] crearEnemigos(int dificultad){
        Enemigo[] enemigosCreados = new Enemigo[0];
        switch (dificultad) {
            case 0 -> {
                enemigosCreados = new Enemigo[3];
                enemigosCreados[0] = new Ogro();
                enemigosCreados[1] = new Gargola();
                enemigosCreados[2] = new Flor();
            }
            case 1 -> {
                enemigosCreados = new Enemigo[5];
                enemigosCreados[0] = new Ogro();
                enemigosCreados[1] = new Gargola();
                enemigosCreados[2] = new Flor();
                enemigosCreados[3] = new Cancerbero();
                enemigosCreados[4] = new Bruja();
            }
            case 2 -> {
                enemigosCreados = new Enemigo[8];
                enemigosCreados[0] = new Ogro();
                enemigosCreados[1] = new Gargola();
                enemigosCreados[2] = new Flor();
                enemigosCreados[3] = new Cancerbero();
                enemigosCreados[4] = new Bruja();
                enemigosCreados[5] = new Ogro();
                enemigosCreados[6] = new Gargola();
                enemigosCreados[7] = new Flor();
            }
            default -> throw new AssertionError();
        }
        return enemigosCreados;
    }
    public void initEnemigos(Tablero tablero){
        int enemigosExistosos = 0;
        Random random = new Random();
        while (enemigosExistosos<enemigos.length) {            
            int posX = random.nextInt(tablero.getLengthX());
            int posY = random.nextInt(tablero.getLengthY());
            Coordenada coordenada = new Coordenada(posX, posY);
            if(tablero.getCasilla(coordenada) instanceof Planicie && 
                    !tablero.getCasilla(coordenada).containsCharacter()){
                Casilla casilla = tablero.getCasilla(coordenada);
                enemigos[enemigosExistosos].setPrimeraCoordenada(coordenada);
                casilla.ingresarPersonaje(enemigos[enemigosExistosos]);
                casilla.repaint();
                enemigosExistosos++;
            }
        }
    }
    public void moverEnemigos(Tablero tablero){
        
        for (int i = 0; i < enemigos.length; i++) {
            boolean movimientoValido;
            int contador=0;
            do {    
                movimientoValido=true;
                char dir = enemigos[i].getDirRandom();
                int movs = enemigos[i].getNoMovsRandom();
                
                if(movs>0){
                    Coordenada coordenadaInicial = enemigos[i].getCurrentCoordenada();
                    Coordenada coordenadaDestino = null;
                    for (int j = 0; j < movs; j++) {
                        coordenadaDestino = coordenadaInicial.getRectCoorFromThis(dir);
                        coordenadaInicial = coordenadaDestino;
                    }
                    if (coordenadaDestino.valida(tablero)) {
                        enemigos[i].moverse(coordenadaDestino, tablero);
                    } else {
                        contador++;
                        movimientoValido = false;
                    }
                }else{
                    movimientoValido=true;
                }
 
            } while (!movimientoValido && contador<100);  
        }
    }
    
    @Override
    public void run(){
        
    }
}

