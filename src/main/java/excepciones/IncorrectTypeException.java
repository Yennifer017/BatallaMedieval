
package excepciones;

/**
 *
 * @author yenni
 */
public class IncorrectTypeException extends Exception{
    String excepcion;
    public IncorrectTypeException() {
    }

    public IncorrectTypeException(String string) {
        super(string);
        excepcion=string;
    }
    @Override
    public String toString(){
        return excepcion;
    }
}
