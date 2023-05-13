
package ipcb.proyecto2ydl.admiPlayers;

import excepciones.IncorrectTypeException;
import excepciones.ListaException;
import ipcb.proyecto2ydl.characters.Jugable;
import ipcb.proyecto2ydl.menus.BtnUtil;
import javax.swing.*;
import ipcb.proyecto2ydl.menus.ImgUtil;
import ipcb.proyecto2ydl.objetos.Objeto;
import java.awt.event.*;
import linkedlist.LinkedListY;

/**
 *
 * @author yenni
 * @param <T>
 */
public class InventarioLogic<T> {
    
    private ImgUtil imgU;
    private int contador;
    private String tipoPersonaje;
    private T currentSelection;
    private BtnUtil btnUtil;
    private boolean modoSeleccion;
    public InventarioLogic(String tipoPersonaje) {
        this.imgU = new ImgUtil();
        this.tipoPersonaje = tipoPersonaje;
        this.contador = 0;
        this.btnUtil = new BtnUtil();
    }
    public void setModoSeleccion(boolean modoSeleccion){
        this.modoSeleccion = modoSeleccion;
    }

    /***************************************************************
     * DISPLAY DE LOS FORMS QUE TENGAN LA ESTRUCTURA DE INVENTARIO
     ***************************************************************/

    public void refreshDisplay(LinkedListY<T> lista, JLabel[] display, JButton[] displayButtons,
            JLabel displaySelection) throws IncorrectTypeException{
        if(lista.getSize()<=4){
            for (int i = 0; i < lista.getSize(); i++) {
                try {
                    this.initDependingType(display[i], displayButtons[i], 
                            lista.getContenido(i), displaySelection);
                } catch (ListaException e) {} 
            }
        }else if(contador<lista.getSize()){
            int finBotones = 0;
            while(finBotones<4 && contador<lista.getSize()){
                try {
                    this.initDependingType(display[finBotones], displayButtons[finBotones], 
                            lista.getContenido(contador), displaySelection);
                } catch (ListaException e) {} 
                contador++;
                finBotones++;
            }
            if(finBotones%4!=0){ //cuando los personajes no usaran todos los botones
                this.disableButtons(display, displayButtons, 
                        finBotones);
                while ((contador%4)!=0) { //para que el contador quede en un numero par             
                    contador++;
                }
            }
        } 
    }
        
    private void initDependingType(JLabel img, JButton boton, T getInfoFrom, JLabel selection) throws IncorrectTypeException{
        if(getInfoFrom instanceof Jugable){
            initDisplay(img, boton, (Jugable) getInfoFrom, selection);
        }else if(getInfoFrom instanceof  Objeto){
            initDisplay(img, boton, (Objeto) getInfoFrom, selection);
        } else{
            throw new IncorrectTypeException("Esta clase solo funciona con clases tipo "
                    + "Objeto o Personaje");
        }

    }
    private void initDisplay(JLabel img, JButton boton, Jugable personaje, JLabel selection){
        img.setIcon(imgU.getImgAEscala(personaje.getPathImage(), img.getWidth(), 
                img.getHeight()));
        boton.setText(personaje.getName());
        boton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){ //anadimos el evento de los botones
                if(!modoSeleccion){
                    JOptionPane.showMessageDialog(null, personaje.getInfo());
                }else{
                    //int opcion = JOptionPane.showConfirmDialog(null, personaje.getInfo() + 
                //"Selecionar al " + tipoPersonaje + "?", "Confirmar eleccion", 
                //JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    //if (opcion==0) {
                        currentSelection = (T) personaje;
                        try {
                            updateSelection(selection);
                        } catch (IncorrectTypeException ex) {}
                    //}
                }
            }
        });
    }
    private void initDisplay(JLabel img, JButton boton, Objeto objeto, JLabel selection){
        img.setIcon(imgU.getImgAEscala(objeto.getPathImage(), img.getWidth(), 
                img.getHeight()));
        boton.setText(objeto.getName());
        
        boton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){ //anadimos el evento de los botones
                if(!modoSeleccion){
                    JOptionPane.showMessageDialog(null, objeto.getInfo());
                }else{
                    //int opcion = JOptionPane.showConfirmDialog(null, objeto.getInfo() + 
                //"Selecionar al " + tipoPersonaje + "?", "Confirmar eleccion", 
                //JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    //if (opcion==0) {
                        currentSelection = (T) objeto;
                        try {
                            updateSelection(selection);
                        } catch (IncorrectTypeException ex) {}
                    //}
                }
            }
        });
    }
   
    public void addGoTo(JButton boton, JFrame currentFrame, JFrame goTo){
        boton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){ //anadimos el evento de los botones
                currentFrame.setVisible(false);
                goTo.setVisible(true);
            }
        });
    }
                
    

    /***************************************************************
     * RESETEO DE VALORES
     ***************************************************************/
    /*private void resetButtons(JButton[] botones){ 
        for (int i = 0; i < 4; i++) {
            botones[i].setEnabled(true);
            ActionListener[] acciones = botones[i].getActionListeners();
            if(acciones.length!=0){
                for (int j = 0; j < acciones.length; j++) {
                    botones[i].removeActionListener(acciones[j]);
                }
            }
        }
    }
    public void resetButton(JButton boton){
        ActionListener[] acciones = boton.getActionListeners();
        if(acciones.length!=0){
            for (int j = 0; j < acciones.length; j++) {
                boton.removeActionListener(acciones[j]);
            }
        }
    }*/
    
    private void disableButtons(JLabel[] display, JButton[] botones, int inicioDisable){
        int i = inicioDisable;
        while (i<4) {   
            botones[i].setText("");
            botones[i].setEnabled(false);
            //display[i].removeAll();
            display[i].setIcon(null);
            i++;
        }
    }
    
    /***************************************************************
     * ACCIONES DE CIERTOS BOTONES QUE SE DEBEN IMPLEMENTAR
     ***************************************************************/
    public void accionBAtras(LinkedListY<T> lista, JLabel[] display, JButton[] displayButtons, 
            JLabel displaySelection) throws IncorrectTypeException{
        if(contador>=8){
            contador-=8;
            btnUtil.resetButtons(displayButtons);
            refreshDisplay(lista, display, displayButtons, displaySelection);
        }else{
            JOptionPane.showMessageDialog(null, "Ya no hay personajes anteriores");
        }
    }
    public void accionBSiguiente(LinkedListY<T> lista, JLabel[] display, JButton[] displayButtons, 
            JLabel displaySelection) throws IncorrectTypeException{
        if(contador<lista.getSize() && lista.getSize()>4){
            btnUtil.resetButtons(displayButtons);
            refreshDisplay(lista, display, displayButtons, displaySelection);
        }else{
            JOptionPane.showMessageDialog(null, "Ya no hay personajes que mostrar");
        }
    }
    public void resetDisplay(LinkedListY<T> lista, JLabel[] display, JButton[] displayButtons, 
            JLabel displaySelection) throws IncorrectTypeException{
        btnUtil.resetButtons(displayButtons);
        contador=0;
        refreshDisplay(lista, display, displayButtons, displaySelection);
        
    }
    
    /***************************************************************
     * CURRENT SELECTION
     ***************************************************************/
    public T getCurrentSelection(){
        return currentSelection;
    }   
    public void resetSelection(JLabel display){
        currentSelection = null;
        display.setText("---------------");
    }
    public void updateSelection(JLabel display) throws IncorrectTypeException{
        try {
            if(currentSelection!=null){
                if(currentSelection instanceof Objeto){
                    Objeto objeto = (Objeto) currentSelection;
                    display.setText(objeto.getName());
                } else if(currentSelection instanceof Jugable){
                    Jugable jugable = (Jugable) currentSelection;
                    display.setText(jugable.getName());
                } else if(currentSelection == null){
                    display.setText("--------------");
                } else {
                    throw new IncorrectTypeException();
                }
            }
        } catch (NullPointerException e) {
        }
        
    }
}
