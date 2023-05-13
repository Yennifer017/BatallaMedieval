/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;

/**
 *
 * @author yenni
 */
public class TableroException extends Exception{
    String excepcion;
    public TableroException() {
    }

    public TableroException(String string) {
        super(string);
        this.excepcion = string;
    }
    
    @Override
    public String toString(){
        return excepcion;
    }
    
}
