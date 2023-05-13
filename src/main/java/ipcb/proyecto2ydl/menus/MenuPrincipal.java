
package ipcb.proyecto2ydl.menus;

import ipcb.proyecto2ydl.tablero.AdmiTableros;
import ipcb.proyecto2ydl.Tienda.Tienda;
import ipcb.proyecto2ydl.admiPlayers.DisplayPersonajes;
import ipcb.proyecto2ydl.admiPlayers.Inventario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author yenni
 */
public class MenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form MenuPrincipal
     */
    
    private AdmiTableros admiTableros;
    private Tienda tienda;
    private Inventario inventario;
    public MenuPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
        admiTableros = new AdmiTableros(this);
        inventario = new Inventario(this);
        tienda = new Tienda(this, inventario);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        bTienda = new javax.swing.JButton();
        bTablero = new javax.swing.JButton();
        bRanking = new javax.swing.JButton();
        bInventario = new javax.swing.JButton();
        bExit = new javax.swing.JButton();
        bPartida = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(16, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 580, 900, 70));

        jPanel1.setBackground(new java.awt.Color(16, 0, 0));

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("BATALLA MEDIEVAL");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(192, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(151, 151, 151))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel1)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 170));

        bTienda.setBackground(new java.awt.Color(61, 0, 0));
        bTienda.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        bTienda.setForeground(new java.awt.Color(255, 255, 255));
        bTienda.setText("Tienda");
        bTienda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTiendaActionPerformed(evt);
            }
        });
        getContentPane().add(bTienda, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 270, 210, 40));

        bTablero.setBackground(new java.awt.Color(61, 0, 0));
        bTablero.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        bTablero.setForeground(new java.awt.Color(255, 255, 255));
        bTablero.setText("Generacion de Tablero");
        bTablero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTableroActionPerformed(evt);
            }
        });
        getContentPane().add(bTablero, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 320, 210, 40));

        bRanking.setBackground(new java.awt.Color(61, 0, 0));
        bRanking.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        bRanking.setForeground(new java.awt.Color(255, 255, 255));
        bRanking.setText("Ranking");
        getContentPane().add(bRanking, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 420, 210, 40));

        bInventario.setBackground(new java.awt.Color(61, 0, 0));
        bInventario.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        bInventario.setForeground(new java.awt.Color(255, 255, 255));
        bInventario.setText("Inventario");
        bInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bInventarioActionPerformed(evt);
            }
        });
        getContentPane().add(bInventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 370, 210, 40));

        bExit.setBackground(new java.awt.Color(61, 0, 0));
        bExit.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        bExit.setForeground(new java.awt.Color(255, 255, 255));
        bExit.setText("Salir");
        bExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bExitActionPerformed(evt);
            }
        });
        getContentPane().add(bExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 510, 210, 40));

        bPartida.setBackground(new java.awt.Color(61, 0, 0));
        bPartida.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        bPartida.setForeground(new java.awt.Color(255, 255, 255));
        bPartida.setText("Iniciar Partida");
        bPartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPartidaActionPerformed(evt);
            }
        });
        getContentPane().add(bPartida, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 220, 210, 40));

        fondo.setForeground(new java.awt.Color(255, 255, 255));
        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fondo.jpg"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 650));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_bExitActionPerformed

    private void bTableroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTableroActionPerformed
        this.setVisible(false);
        admiTableros.setVisible(true);
    }//GEN-LAST:event_bTableroActionPerformed

    private void bTiendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTiendaActionPerformed
        this.setVisible(false);
        tienda.setVisible(true);
    }//GEN-LAST:event_bTiendaActionPerformed

    private void bInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bInventarioActionPerformed
        this.setVisible(false);
        inventario.setVisible(true);
    }//GEN-LAST:event_bInventarioActionPerformed

    private void bPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPartidaActionPerformed
        this.setVisible(false);
        DisplayPersonajes seleccionPersonajes = inventario.getDisplayPersonajes();
        seleccionPersonajes.setDefaultSelection(admiTableros.getColector(), this);
        seleccionPersonajes.setVisible(true);
    }//GEN-LAST:event_bPartidaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bExit;
    private javax.swing.JButton bInventario;
    private javax.swing.JButton bPartida;
    private javax.swing.JButton bRanking;
    private javax.swing.JButton bTablero;
    private javax.swing.JButton bTienda;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}