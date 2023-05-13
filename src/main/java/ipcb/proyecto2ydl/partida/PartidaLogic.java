
package ipcb.proyecto2ydl.partida;

import ipcb.proyecto2ydl.admiPlayers.AdmiEnemigos;
import ipcb.proyecto2ydl.casillas.Casilla;
import ipcb.proyecto2ydl.casillas.Planicie;
import ipcb.proyecto2ydl.characters.Jugable;
import ipcb.proyecto2ydl.tablero.Coordenada;
import ipcb.proyecto2ydl.tablero.Tablero;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author yenni
 */
public class PartidaLogic {
    
    private boolean SeleccionExitosa;
    private Jugable[] personajes;
    private JPanel panelTablero;
    private Tablero tablero;
    private int contador;
    private boolean moverse, turnoPlayer;
    private AdmiEnemigos admiEnemigos;
    public PartidaLogic(Partida partida) {
        this.personajes = partida.getPersonajes();
        this.panelTablero = partida.getDisplayGame();
        this.tablero = partida.getTablero();
        contador = 0;
        moverse =true;
        admiEnemigos = new AdmiEnemigos(partida.getDificultad());
    }
    
    public void initGame(){
        int ancho =panelTablero.getWidth()/tablero.getLengthX();
        int largo =panelTablero.getHeight()/tablero.getLengthY();
        int x = 0;
        int y = 0;
        for (int j = 0; j < tablero.getLengthY(); j++) {
            for (int i = 0; i < tablero.getLengthX(); i++) {
                Casilla casilla= tablero.getCasilla(i, j);
                //casilla.setBackground(colorAzul);
                casilla.setBounds(x, y, ancho, largo);
                casilla.inicializar();
                addActionCasilla(casilla);
                panelTablero.add(casilla);
                panelTablero.revalidate();
                panelTablero.repaint();
                x+= ancho;
            }
            y+=largo;
            x=0;
        }        
    }

    private void addActionCasilla(Casilla casilla){
        if(casilla instanceof Planicie){
            casilla.addActionListener((ActionEvent e) -> {
                if(!SeleccionExitosa){
                    selectionPlayerMode(casilla);
                }else{
                    playMode(casilla.getCoordenada());
                }
            });
        }else{
            casilla.addActionListener((ActionEvent e) -> {
                if(SeleccionExitosa){
                    playMode(casilla.getCoordenada());
                }else{
                    JOptionPane.showMessageDialog(null, "Los personajes deben iniciar "
                            + "en una casilla tipo planicie");
                }
            });
        }
    }
    private void selectionPlayerMode(Casilla casilla){
        int opcion = JOptionPane.showConfirmDialog(null, 
                "Ingresar al personaje aqui?", "confirmar eleccion", 
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(opcion==0){
            personajes[0].setPrimeraCoordenada(casilla.getCoordenada());
            casilla.ingresarPersonaje(personajes[0]);
            SeleccionExitosa=true;
            admiEnemigos.initEnemigos(tablero);
            
            JOptionPane.showMessageDialog(null, "Ahora vas a poder mover al personaje");
            
            tablero.disable();
            personajes[0].enableMovimientosValidos(tablero);
            turnoPlayer=true;

        }
    }
    private void playMode(Coordenada coordenada){
        if(moverse && turnoPlayer){
            personajes[contador].moverse(coordenada, tablero);
            turnoPlayer=false;
            admiEnemigos.moverEnemigos(tablero);
            /*try {
                Thread.sleep(3000);
            } catch (Exception e) {
            }*/
            tablero.disable();
            personajes[contador].enableMovimientosValidos(tablero);
            turnoPlayer=true;
        }else{
            
        }
    }
    
}
