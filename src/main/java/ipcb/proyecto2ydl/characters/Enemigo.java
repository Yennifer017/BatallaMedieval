
package ipcb.proyecto2ydl.characters;

import java.util.Random;

/**
 *
 * @author yenni
 */
public class Enemigo extends Personaje{

    private Random random;
    public Enemigo() {
        random = new Random();
        
    }
    
    public char getDirRandom(){
        int eleccion = random.nextInt(4);
        char direccion;
        switch (eleccion) {
            case 1 -> direccion = 'w';
            case 2 -> direccion = 'a';
            case 3 -> direccion = 's';
            case 4 -> direccion = 'd';
            default -> throw new AssertionError();
        }
        return direccion;
    }
    public int getNoMovsRandom(){
        int movs = (random.nextInt(maxMov))+1;
        return movs;
    }
   
}
