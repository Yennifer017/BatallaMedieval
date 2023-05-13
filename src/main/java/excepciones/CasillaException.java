
package excepciones;

/**
 *
 * @author yenni
 */
public class CasillaException extends Exception{
    String excepcion;
    public CasillaException() {
    }

    public CasillaException(String string) {
        super(string);
        excepcion=string;
    }
    @Override
    public String toString(){
        return excepcion;
    }
    public int getint(){
        return 0;

    }
}
