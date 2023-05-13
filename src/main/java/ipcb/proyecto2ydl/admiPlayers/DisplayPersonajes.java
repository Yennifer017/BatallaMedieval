
package ipcb.proyecto2ydl.admiPlayers;

import excepciones.IncorrectTypeException;
import ipcb.proyecto2ydl.characters.Jugable;
import ipcb.proyecto2ydl.menus.BtnUtil;
import ipcb.proyecto2ydl.tablero.ColectorTableros;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import linkedlist.LinkedListY;

/**
 *
 * @author yenni
 */
public class DisplayPersonajes extends javax.swing.JFrame {

    /**
     * Creates new form DisplayPersonajes
     */
    private JButton[] displayButtons;
    private JLabel[] displayPersonajes;
    private JFrame pestanaAnterior;
    private Inventario defaultPestanaAnterior;
    private InventarioLogic<Jugable> logic;
    private boolean selectionMode;
    private BtnUtil bUtil;
    //private int contador;
    LinkedListY<Jugable> listaPersonajes;
    
    //CONSTRUCTOR
    public DisplayPersonajes(Inventario inventario) {
        initComponents();
        this.defaultPestanaAnterior = inventario;
        this.setLocationRelativeTo(null);
        //this.contador = 0;
        logic = new InventarioLogic("personajes");
        initMyComponents();
        this.listaPersonajes = inventario.getListaPlayers();   
        this.bUtil = new BtnUtil();
    }
    private void initMyComponents(){
        displayButtons = new JButton[4];
        displayPersonajes = new JLabel[4];
        displayButtons[0] = bP1;
        displayButtons[1] = bP2;
        displayButtons[2] = bP3;
        displayButtons[3] = bP4;
        displayPersonajes[0] = personaje1;
        displayPersonajes[1] = personaje2;
        displayPersonajes[2] = personaje3;
        displayPersonajes[3] = personaje4;        
        resetDisplay();
    }
    
    //inicializar la pestana para poder seleccionar a los personajes
    //no incluye una correcta inicializacion para poder dar paso a una partida
    public void inicializar(boolean selectionMode, String displayMessage){
        try {
            this.selectionMode = selectionMode;
            setSelectionMode(selectionMode, displayMessage);
            logic.resetDisplay(listaPersonajes, displayPersonajes, displayButtons, displaySelection);
        } catch (IncorrectTypeException ex) {
            Logger.getLogger(DisplayPersonajes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void setSelectionMode(boolean selectionMode, String displayMessage){
        this.displayMessage.setText(displayMessage);
        logic.setModoSeleccion(selectionMode);
        if(selectionMode){
            displaySelection.setVisible(true);
            labelSelection.setVisible(true);
        }
    }
    
    //resetear el modo de no-seleccion 
    public final void resetDisplay(){
        displaySelection.setVisible(false);
        labelSelection.setVisible(false);
        bAccionEsp.setVisible(false);
        pestanaAnterior = defaultPestanaAnterior;
    }
    
    //setear el flujo de la pestana para no regresar a la pestana por defecto
    //...con la funcion de ir a otra pestana
    public void setFlujoPestana(String msgEspButton, JFrame goTo, JFrame regresar){
        pestanaAnterior = regresar;
        bUtil.resetButton(bAccionEsp);
        bAccionEsp.setText(msgEspButton);
        logic.addGoTo(bAccionEsp, this, goTo);
        bAccionEsp.setVisible(true);
    }
    
    //... con la funcion de dejar a libertad el comportamiento del boton especial
    public void setFlujoPestana(String msgEspButton, ActionListener action, JFrame regresar){
        pestanaAnterior = regresar;
        bUtil.resetButton(bAccionEsp);
        bAccionEsp.setText(msgEspButton);
        bAccionEsp.addActionListener(action);
        bAccionEsp.setVisible(true);
    }
    
    // para seleccionar dos personajes que posteriormente serviran para iniciar una partida
    private int contador;
    private Jugable[] selectionPlayers = new Jugable[2];
    public void setDefaultSelection(ColectorTableros seleccionTablero, JFrame pestanaAnterior){
        contador=0;
        inicializar(true, "Ingresa el jugador no." + (contador+1));
        setFlujoPestana("Aceptar", (ActionEvent e) -> {
            if(contador==0){
                guardarSeleccion(true);
            }else if(contador ==1){
                boolean seleccionExitosa = guardarSeleccion(false);
                if(seleccionExitosa){
                    this.setVisible(false);
                    seleccionTablero.setSelectionMode("Selecciona un tablero para jugar", 
                            this);
                }
            }
        }, pestanaAnterior);
    }
    
    private boolean guardarSeleccion(boolean primeraSeleccion){
        if(logic.getCurrentSelection()!= null){
            if(primeraSeleccion || (!primeraSeleccion && (logic.getCurrentSelection() != selectionPlayers[contador - 1]))){
                selectionPlayers[contador] = logic.getCurrentSelection();
                contador++;
                displayMessage.setText("Ingresa al jugador no." + (contador + 1));
                JOptionPane.showMessageDialog(null, "personaje no." + contador + " seleccinado");
                logic.resetSelection(displaySelection);
                return true;
            }else{
                JOptionPane.showMessageDialog(null, "Seleccion invalida, intentalo otra vez");
                return false;
            }
        }else{
            JOptionPane.showMessageDialog(null, "Debes seleccionar un personaje, "
                        + "este debe ser valido");
            return false;
        }
    }
    
    public Jugable getSelection(){
        return logic.getCurrentSelection();
    }
    public Jugable[] getSelectionPlayers(){
        return selectionPlayers;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        bP1 = new javax.swing.JButton();
        personaje1 = new javax.swing.JLabel();
        bSiguiente = new javax.swing.JButton();
        bAnteriores = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        bP2 = new javax.swing.JButton();
        personaje2 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        bP3 = new javax.swing.JButton();
        personaje3 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        bP4 = new javax.swing.JButton();
        personaje4 = new javax.swing.JLabel();
        bAtras = new javax.swing.JButton();
        displayMessage = new javax.swing.JLabel();
        labelSelection = new javax.swing.JLabel();
        displaySelection = new javax.swing.JLabel();
        bAccionEsp = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(42, 6, 6));

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("PERSONAJES EN INVENTARIO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel1)
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(25, 25, 25))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 120));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        bP1.setBackground(new java.awt.Color(51, 0, 0));
        bP1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        bP1.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bP1, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(personaje1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(bP1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(personaje1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 14, Short.MAX_VALUE))
        );

        bSiguiente.setBackground(new java.awt.Color(51, 0, 0));
        bSiguiente.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        bSiguiente.setForeground(new java.awt.Color(255, 255, 255));
        bSiguiente.setText("Siguiente");
        bSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSiguienteActionPerformed(evt);
            }
        });

        bAnteriores.setBackground(new java.awt.Color(51, 0, 0));
        bAnteriores.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        bAnteriores.setForeground(new java.awt.Color(255, 255, 255));
        bAnteriores.setText("Anteriores");
        bAnteriores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAnterioresActionPerformed(evt);
            }
        });

        jPanel7.setBackground(new java.awt.Color(0, 0, 0));

        bP2.setBackground(new java.awt.Color(51, 0, 0));
        bP2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        bP2.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bP2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(personaje2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(bP2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(personaje2, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 21, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(0, 0, 0));

        bP3.setBackground(new java.awt.Color(51, 0, 0));
        bP3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        bP3.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bP3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(personaje3, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(bP3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(personaje3, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 21, Short.MAX_VALUE))
        );

        jPanel9.setBackground(new java.awt.Color(0, 0, 0));

        bP4.setBackground(new java.awt.Color(51, 0, 0));
        bP4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        bP4.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bP4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(personaje4, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(bP4, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(personaje4, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 21, Short.MAX_VALUE))
        );

        bAtras.setBackground(new java.awt.Color(255, 0, 0));
        bAtras.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        bAtras.setForeground(new java.awt.Color(255, 255, 255));
        bAtras.setText("Atras");
        bAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAtrasActionPerformed(evt);
            }
        });

        displayMessage.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        displayMessage.setForeground(new java.awt.Color(0, 0, 0));
        displayMessage.setText("Clic en el boton de un personaje para ver mas informacion.");

        labelSelection.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        labelSelection.setForeground(new java.awt.Color(0, 0, 0));
        labelSelection.setText("Selección:");

        displaySelection.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        displaySelection.setForeground(new java.awt.Color(0, 0, 0));
        displaySelection.setText("-------------------------------------------");

        bAccionEsp.setBackground(new java.awt.Color(255, 102, 0));
        bAccionEsp.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        bAccionEsp.setForeground(new java.awt.Color(255, 255, 255));
        bAccionEsp.setText("display");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(bAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(99, 99, 99)
                        .addComponent(bAnteriores, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addComponent(bSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(104, 104, 104)
                        .addComponent(bAccionEsp, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(displayMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(labelSelection, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(displaySelection, javax.swing.GroupLayout.PREFERRED_SIZE, 631, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(displayMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bAnteriores, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bAccionEsp, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSelection, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(displaySelection, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 900, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bAnterioresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAnterioresActionPerformed
        try {
            logic.accionBAtras(listaPersonajes, displayPersonajes, displayButtons, displaySelection);
        } catch (IncorrectTypeException ex) {
            Logger.getLogger(DisplayPersonajes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bAnterioresActionPerformed

    private void bAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAtrasActionPerformed
        try {
            logic.resetDisplay(listaPersonajes, displayPersonajes, displayButtons, null);
        } catch (Exception e) {}
        this.setVisible(false);
        pestanaAnterior.setVisible(true);
    }//GEN-LAST:event_bAtrasActionPerformed

    private void bSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSiguienteActionPerformed
        try {
            logic.accionBSiguiente(listaPersonajes, displayPersonajes, displayButtons, displaySelection);
        } catch (IncorrectTypeException ex) {
            Logger.getLogger(DisplayPersonajes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bSiguienteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAccionEsp;
    private javax.swing.JButton bAnteriores;
    private javax.swing.JButton bAtras;
    private javax.swing.JButton bP1;
    private javax.swing.JButton bP2;
    private javax.swing.JButton bP3;
    private javax.swing.JButton bP4;
    private javax.swing.JButton bSiguiente;
    private javax.swing.JLabel displayMessage;
    private javax.swing.JLabel displaySelection;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel labelSelection;
    private javax.swing.JLabel personaje1;
    private javax.swing.JLabel personaje2;
    private javax.swing.JLabel personaje3;
    private javax.swing.JLabel personaje4;
    // End of variables declaration//GEN-END:variables
}
