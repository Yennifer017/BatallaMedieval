
package ipcb.proyecto2ydl.Tienda;
import ipcb.proyecto2ydl.admiPlayers.Inventario;
import ipcb.proyecto2ydl.characters.*;
import ipcb.proyecto2ydl.menus.ImgUtil;
import ipcb.proyecto2ydl.objetos.*;
import ipcb.proyecto2ydl.tablero.Archivo;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import linkedlist.LinkedListY;
/**
 *
 * @author yenni
 */
public class TiendaLogic {
    
    /**
     * COMPRA DE PERSONAJES
     * @param listaPersonajes
     * @param personaje
     */
    public void addPersonaje(LinkedListY<Jugable> listaPersonajes, String personaje, String name){
        personaje = personaje.toLowerCase();
        Jugable personajeCreado = getPersonajeMolde(personaje, name);
        listaPersonajes.add(personajeCreado);
    }
    public void initInfoCharacters(JLabel displayImage, JLabel displayCosto, String tipoPersonaje){
        ImgUtil imgU = new ImgUtil();
        Jugable moldePersonaje = getPersonajeMolde(tipoPersonaje);
        displayImage.setIcon(imgU.getImgAEscala(moldePersonaje.getPathImage(), displayImage.getWidth(),
                displayImage.getHeight()));
        displayCosto.setText(String.valueOf(moldePersonaje.getCosto()));
    }
    private Jugable getPersonajeMolde(String tipoPersonaje){
        Jugable moldePersonaje = switch (tipoPersonaje) {
        case "caballero" -> new Caballero("Caballero");
        case "mago" -> new Mago("Mago");
        case "arquero" -> new Arquero("Arquero");
        case "gigante" -> new Gigante("Gigante");
        case "dragon" -> new Dragon("Dragon");
        default -> null;
        };
        return moldePersonaje;
    }
    private Jugable getPersonajeMolde(String tipoPersonaje, String name){
        Jugable moldePersonaje = switch (tipoPersonaje) {
        case "caballero" -> new Caballero(name);
        case "mago" -> new Mago(name);
        case "arquero" -> new Arquero(name);
        case "gigante" -> new Gigante(name);
        case "dragon" -> new Dragon(name);
        default -> null;
        };
        return moldePersonaje;
    }
    public String getInfoPersonaje(String tipoPersonaje){
        Jugable moldePersonaje = getPersonajeMolde(tipoPersonaje);
        return moldePersonaje.getInfo();
    }
    public int getCostoPersonaje(String tipoPersonaje){
        Jugable moldePersonaje = getPersonajeMolde(tipoPersonaje);
        return moldePersonaje.getCosto();
    }
    
    /**
     * COMPRA DE OBJETOS
     * @param displayImage
     * @param displayCosto
     * @param tipoObjeto
     */
    public void initInfoObjetos(JLabel displayImage, JLabel displayCosto, String tipoObjeto){
        ImgUtil imgU = new ImgUtil();
        Objeto moldeObjeto = getObjetoMolde(tipoObjeto);
        displayImage.setIcon(imgU.getImgAEscala(moldeObjeto.getPathImage(), displayImage.getWidth(),
                displayImage.getHeight()));
        displayCosto.setText(String.valueOf(moldeObjeto.getCosto()));
    }
    public void addObjeto(LinkedListY<Objeto> listaObjeto, String tipoObjeto){
        tipoObjeto = tipoObjeto.toLowerCase();
        Objeto objeto = getObjetoMolde(tipoObjeto);
        listaObjeto.add(objeto);
    }
    
    private Objeto getObjetoMolde(String tipoObjeto){
        Objeto moldeObjeto = switch (tipoObjeto) {
        case "elixir" -> new ElixirVerde();
        case "semilla" -> new SemillaVida();
        case "capa" -> new CapaMovilidad();
        default -> null;
        };
        return moldeObjeto;
    }
    public int getCostoObjeto(String tipoObjeto){
        Objeto moldeObjeto = getObjetoMolde(tipoObjeto);
        return moldeObjeto.getCosto();
    }
    private String getInfoObjeto(String tipoObjeto){
        Objeto objeto = getObjetoMolde(tipoObjeto);
        return objeto.getInfo();
    }
    
    //compra de personajes
    public void comprar(Inventario inventario, String tipoPersonaje, JLabel displayOro){
        String infoCompra = getInfoPersonaje(tipoPersonaje);
        LinkedListY<Jugable> listaPersonajes = inventario.getListaPlayers();
        if(inventario.getOro()>=getCostoPersonaje(tipoPersonaje)){
            int opcion = JOptionPane.showConfirmDialog(null, infoCompra + " --Deseas comprar un " + 
                    tipoPersonaje + "?", "Confirmar compra", JOptionPane.YES_NO_OPTION, 
                    JOptionPane.QUESTION_MESSAGE);
            if (opcion==0) {
                String nickname = JOptionPane.showInputDialog(null, "Ingresa el nickname del personaje");
                if(nickname!=null && !nickname.equals("")){ //compra exitosa
                    addPersonaje(listaPersonajes, tipoPersonaje, nickname);
                    inventario.operarOro(getCostoPersonaje(tipoPersonaje));
                    displayOro.setText(inventario.getOro().toString());
                    Archivo archivo = new Archivo();
                    archivo.guardarArchivoBin(Inventario.ARCHIVO_PLAYERS, listaPersonajes);
                    archivo.guardarArchivoBin(Inventario.ARCHIVO_ORO, inventario.getOro());
                    JOptionPane.showMessageDialog(null, "Se ha comprado un " + tipoPersonaje + " exitosamente", 
                            "Compra exitosa", 1); 
                    
                }else if(nickname!= null && nickname.equals("")){
                    JOptionPane.showMessageDialog(null, "No se ha ingresado un nickname valido", 
                            "Compra exitosa", 1); 
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "No cuentas con suficiente oro para realizar la compra",
                    "Insuficiente oro", 0);
        }
    }
    //compra de objetos
    public void comprarObjeto(Inventario inventario, String tipoObjeto, JLabel displayOro){
        String infoCompra = getInfoObjeto(tipoObjeto);
        LinkedListY<Objeto> listaObjetos = inventario.getListaObjetos();
        if(inventario.getOro()>=getCostoObjeto(tipoObjeto)){
            int opcion = JOptionPane.showConfirmDialog(null, infoCompra + 
                    " -- Deseas comprar este objeto?", "Confirmar compra", 
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (opcion==0) {
                addObjeto(listaObjetos, tipoObjeto);
                inventario.operarOro(getCostoObjeto(tipoObjeto));
                displayOro.setText(inventario.getOro().toString());
                Archivo archivo = new Archivo();
                archivo.guardarArchivoBin(Inventario.ARCHIVO_OBJETOS, listaObjetos);
                archivo.guardarArchivoBin(Inventario.ARCHIVO_ORO, inventario.getOro());
                JOptionPane.showMessageDialog(null, "Se ha comprado un " + tipoObjeto + " exitosamente", 
                        "Compra exitosa", 1); 
            }
        }else{
            JOptionPane.showMessageDialog(null, "No cuentas con suficiente oro para realizar la compra",
                    "Insuficiente oro", 0);
        }
    }
    
    
}
