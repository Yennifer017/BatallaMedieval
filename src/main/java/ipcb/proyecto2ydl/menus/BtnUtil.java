
package ipcb.proyecto2ydl.menus;

import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author yenni
 */
public class BtnUtil {
    public void resetButtons(JButton[] botones){ 
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
    }
}
