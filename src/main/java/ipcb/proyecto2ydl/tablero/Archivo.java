
package ipcb.proyecto2ydl.tablero;

import excepciones.ListaException;
import excepciones.TableroException;
import java.io.*;
import javax.swing.JFileChooser;
import linkedlist.LinkedListY;

/**
 *
 * @author yenni
 * @param <T>
 */
public class Archivo<T> {
    
    /**
     * ARCHIVOS DE TEXTO
     * @param ruta
     * @return 
     */
    public String abrirArchivo(String ruta){ //obtiene el texto contenido en un archivo y lo devuelve
        String texto="";
        try{
            File archivo=new File(ruta); //creando el archivo
            FileReader lector = new FileReader(archivo); //lector del archivo
            BufferedReader buffer = new BufferedReader(lector); //para leer mas rapido el archivo
            String linea;
            while((linea=buffer.readLine()) !=null ){
                texto+=linea+"\n";
            }
            buffer.close();
            lector.close();
        }catch(IOException error){
            System.out.println(error);
        }
        return texto;
    }
    
    public void guardarArchivo(String texto, String ruta){ //reescribe un archivo a partir de un texto
        try{
            File archivo = new File(ruta); //obtiene el archivo de la ruta
            FileWriter escritor = new FileWriter(archivo,false);
            BufferedWriter buffer = new BufferedWriter(escritor);
            buffer.write(texto);
            buffer.close();
            escritor.close();
        }catch(IOException error){
            System.out.println(error);
        }
    }
    
    private String[] separarPorLineas(String texto, String separador){
        texto = texto.toLowerCase(); 
        String[] lineas = texto.split(separador);
        return lineas;
    }
    
    public void guardarTableros(LinkedListY<Tablero> lista, String texto){
        String[] linea = separarPorLineas(texto, "\n");
        for (int i = 0; i < linea.length; i++) {
            if (linea[i].contains("id") || linea[i].contains("tablero")) {
                String nombreTablero = linea[i].replace("tablero", "");
                nombreTablero = nombreTablero.replace("id", "");
                nombreTablero = nombreTablero.replace(" ", "");
                String contenidoTablero="";
                Dimensiones dimTab = new Dimensiones(0, 0);
                i++;
                for (; i < linea.length; i++) {
                    if (linea[i].contains("dimension") || linea[i].contains("dimensiones")) {
                        dimTab = leerDimensiones(linea[i]);
                    }else if(linea[i].contains(",")){
                        contenidoTablero+=linea[i];
                        contenidoTablero+=",";
                    }else if(!linea[i].equals("")){
                        i--;
                        break;
                    }
                }
                String[] contentTab = contenidoTablero.split(",");
                Tablero currentTablero;
                try {
                    currentTablero = new Tablero(nombreTablero, dimTab, contentTab); 
                    if (currentTablero.valido()) {
                        lista.add(currentTablero);
                    }
                } catch (TableroException e) {
                    System.out.println(e);
                } 
            }
        }
    }
    private Dimensiones leerDimensiones(String dim){
        dim = dim.replace("dimension ", "");
        dim = dim.replace("dimensiones ", "");
        String[] dims = dim.split("x");
        Dimensiones dimensiones;
        try {
            dimensiones = new Dimensiones(Integer.parseInt(dims[0]), Integer.parseInt(dims[1]) );
        } catch (NumberFormatException e) {
            dimensiones = new Dimensiones(0, 0);
        }
        return dimensiones;
    }
    
    public String getPath(){
        JFileChooser buscador=new JFileChooser(); //creando el buscador de archivos
        buscador.showOpenDialog(null); //abrir el buscador
        return buscador.getSelectedFile().getAbsolutePath();
    }
    
    /**
     * ARCHIVOS BINARIOS
     *      ARCHIVOS DE OBJETOS
     * @param path
     * @param objeto
     */
    public boolean guardarArchivoBin(String path, Object objeto){
        boolean exitoso;
        File archivo = new File(path);
        try {
            FileOutputStream fos = new FileOutputStream(archivo);
            ObjectOutputStream escribir = new ObjectOutputStream(fos);
            escribir.writeObject(objeto);
            escribir.close();
            fos.close();
            exitoso =true;
        } catch (Exception e) {
            System.out.println("Error al escribir en el archivo. "
                    + e.getMessage());   
            exitoso = false;
        }
        return exitoso;
    }
    
    public T leerArchivoBin(String path){
        File archivo = new File(path);
        T objetoLeido = null;
        try {
            FileInputStream fis = new FileInputStream(archivo);
            ObjectInputStream leer;
            while(fis.available()>0){ //mientras haya bytes se lee
                leer= new ObjectInputStream(fis);
                objetoLeido = (T) leer.readObject();
                 
                System.out.println(objetoLeido.toString()); 
            }
        } catch (Exception e) {
            System.out.println("Error al leer el archivo. "
                    + e.getMessage());   
        }
        return objetoLeido;
    }
    
    
    public T abrirArchivoBin(String path, T objeto){
        File archivo = new File(path);
        if(!archivo.exists()){
            guardarArchivoBin(path, objeto);
        }
        return leerArchivoBin(path);
    }
    
    public void ordenar(LinkedListY<Tablero> listaTablero){
        for (int i = 1; i < listaTablero.getSize(); i++) {
            try {
                Tablero elemento = listaTablero.getContenido(i);
                for (int j = i-1; j  >= 0; j --) {
                    Tablero izquierda = listaTablero.getContenido(i);
                    if(izquierda.getTotalCasillas() > elemento.getTotalCasillas()){
                        
                    }
                }
                listaTablero.getContenido(i);
            } catch (ListaException e) {
                
            }
        }
    }
    
    
    
}
