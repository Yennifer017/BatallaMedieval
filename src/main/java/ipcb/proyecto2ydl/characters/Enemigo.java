
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
            case 0 -> direccion = 'w';
            case 1 -> direccion = 'a';
            case 2 -> direccion = 's';
            case 3 -> direccion = 'd';
            default -> throw new AssertionError();
        }
        return direccion;
    }
    public int getNoMovsRandom(){
        int movs;
        if(maxMov>0){
            movs = (random.nextInt(maxMov))+1;
        }else{
            movs = 0;
        }
        return movs;
    }
   
}
