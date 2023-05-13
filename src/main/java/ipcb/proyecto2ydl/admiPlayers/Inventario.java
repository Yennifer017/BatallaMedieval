
package ipcb.proyecto2ydl.admiPlayers;
import ipcb.proyecto2ydl.characters.*;
import ipcb.proyecto2ydl.objetos.DisplayObjetos;
import ipcb.proyecto2ydl.objetos.Objeto;
import ipcb.proyecto2ydl.tablero.Archivo;
import javax.swing.JFrame;
import linkedlist.LinkedListY;
/**
 *
 * @author yenni
 */
public class Inventario extends javax.swing.JFrame {

    /**
     * Creates new form Inventario
     */
    private LinkedListY<Jugable> players;
    private LinkedListY<Objeto> objetos;
    private final JFrame pestanaAnterior;
    private DisplayPersonajes displayPersonajes;
    private DisplayObjetos displayObjetos;
    private Integer oro;
    public static final String ARCHIVO_PLAYERS = "players.data";
    public static final String ARCHIVO_OBJETOS = "objetos.data";
    public static final String ARCHIVO_ORO = "oro.data";
    public Inventario(JFrame pestanaAnterior) {
        initComponents();
        this.setLocationRelativeTo(null);
        //datos guardados
        Archivo<LinkedListY<Jugable>> archivoPlayers = new Archivo<>();
        players = archivoPlayers.abrirArchivoBin(ARCHIVO_PLAYERS, new LinkedListY<>());
        Archivo<LinkedListY<Objeto>> archivoObjetos = new Archivo<>();
        objetos = archivoObjetos.abrirArchivoBin(ARCHIVO_OBJETOS, new LinkedListY<>());
        Archivo<Integer> archivoOro = new Archivo<>();
        oro = archivoOro.abrirArchivoBin(ARCHIVO_ORO, 500);
        this.pestanaAnterior = pestanaAnterior;
        this.displayPersonajes = new DisplayPersonajes(this);
        this.displayObjetos = new DisplayObjetos(this, objetos);
    }
    public JFrame getPestanaAnterior(){
        return pestanaAnterior;
    }
    
    public LinkedListY<Jugable> getListaPlayers(){
        return players;
    }
    public LinkedListY<Objeto> getListaObjetos(){
        return objetos;
    }
    public DisplayPersonajes getDisplayPersonajes(){
        return displayPersonajes;
    }
    public void operarOro(int numero){
        oro-=numero;    
    }
    public Integer getOro(){
        return oro;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        bPersonajes = new javax.swing.JButton();
        bObjetos = new javax.swing.JButton();
        bVender = new javax.swing.JButton();
        bAtras = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(42, 6, 6));

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("INVENTARIO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(268, 268, 268)
                .addComponent(jLabel1)
                .addContainerGap(294, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(35, 35, 35))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 140));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        bPersonajes.setBackground(new java.awt.Color(25, 1, 1));
        bPersonajes.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        bPersonajes.setForeground(new java.awt.Color(255, 255, 255));
        bPersonajes.setText("VER PERSONAJES");
        bPersonajes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPersonajesActionPerformed(evt);
            }
        });

        bObjetos.setBackground(new java.awt.Color(25, 1, 1));
        bObjetos.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        bObjetos.setForeground(new java.awt.Color(255, 255, 255));
        bObjetos.setText("VER OBJETOS");
        bObjetos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bObjetosActionPerformed(evt);
            }
        });

        bVender.setBackground(new java.awt.Color(25, 1, 1));
        bVender.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        bVender.setForeground(new java.awt.Color(255, 255, 255));
        bVender.setText("VENDER OBJETOS");

        bAtras.setBackground(new java.awt.Color(255, 0, 0));
        bAtras.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        bAtras.setForeground(new java.awt.Color(255, 255, 255));
        bAtras.setText("Atras");
        bAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAtrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(bAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bPersonajes, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bObjetos, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bVender, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(215, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(bPersonajes, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bObjetos, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bVender, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(64, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 900, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAtrasActionPerformed
        this.setVisible(false);
        pestanaAnterior.setVisible(true);
    }//GEN-LAST:event_bAtrasActionPerformed

    private void bPersonajesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPersonajesActionPerformed
        this.setVisible(false);
        displayPersonajes.resetDisplay();
        displayPersonajes.inicializar(false, "Clic en el boton para ver mas informacion"
                + "de los personajes");
        displayPersonajes.setVisible(true);
    }//GEN-LAST:event_bPersonajesActionPerformed

    private void bObjetosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bObjetosActionPerformed
        this.setVisible(false);
        displayObjetos.setVisible(true);
        displayObjetos.Inicializar("Objetos en inventario");
    }//GEN-LAST:event_bObjetosActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAtras;
    private javax.swing.JButton bObjetos;
    private javax.swing.JButton bPersonajes;
    private javax.swing.JButton bVender;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
