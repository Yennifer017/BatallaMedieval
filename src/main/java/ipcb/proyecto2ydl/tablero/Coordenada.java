
package ipcb.proyecto2ydl.tablero;

import java.io.Serializable;

/**
 *
 * @author yenni
 */
public class Coordenada implements Serializable{
    private final int x;
    private final int y;
    
    public Coordenada(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public Coordenada getRectCoorFromThis(char dir){
        Coordenada nuevaCoordenada = switch (dir) {
            case 'w','W' -> new Coordenada(this.getX(), this.getY()-1);
            case 'a','A' -> new Coordenada(this.getX()-1, this.getY());
            case 's','S' -> new Coordenada(this.getX(), this.getY()+1);
            default -> new Coordenada(this.getX()+1, this.getY());
        };
        return nuevaCoordenada;
    }
    public Coordenada getRectCoorFromThis(int dir){
        Coordenada nuevaCoordenada = switch (dir) {
            case 0 -> new Coordenada(this.getX(), this.getY()-1); //w
            case 1 -> new Coordenada(this.getX()-1, this.getY()); //a
            case 2 -> new Coordenada(this.getX(), this.getY()+1); //s
            default -> new Coordenada(this.getX()+1, this.getY()); //d
        };
        return nuevaCoordenada;
    }
    
    public Coordenada getCoorEnCirculoFromThis(int dir){
        Coordenada nuevaCoordenada;
        nuevaCoordenada = switch (dir) {
            case 0 -> new Coordenada(this.getX(), this.getY()-1);
            case 1 -> new Coordenada(this.getX()+1, this.getY()-1);
            case 2 -> new Coordenada(this.getX()+1, this.getY());
            case 3 -> new Coordenada(this.getX()+1, this.getY()+1);
            case 4 -> new Coordenada(this.getX(), this.getY()+1);
            case 5 -> new Coordenada(this.getX()-1, this.getY()+1);
            case 6 -> new Coordenada(this.getX()-1, this.getY());
            default -> new Coordenada(this.getX()-1, this.getY()-1);
        };
        return nuevaCoordenada;
    }
    public boolean valida(Tablero tablero){
        return (x>=0 && x<tablero.getLengthX() && y>=0 && y<tablero.getLengthY());
    }
    public char getDirection(Coordenada anotherCoor){
        int diferenciaX = this.getX() -  anotherCoor.getX();
        int diferenciaY = this.getY() -  anotherCoor.getY();
        if(diferenciaX<0 && diferenciaY==0){
            return 'd';
        }else if(diferenciaX>0 && diferenciaY==0){
            return 'a';
        }else if(diferenciaY>0 && diferenciaX==0){
            return 'w';
        }else if(diferenciaY<0 && diferenciaX==0){
            return 's';
        }else{
            return '0';
        }
    }
    public int getHowManyMovs(Coordenada anotherCoor){
        int diferenciaX = this.getX() - anotherCoor.getX();
        int diferenciaY = this.getY() -  anotherCoor.getY();
        if((diferenciaX<0 && diferenciaY==0) || (diferenciaX>0 && diferenciaY==0)){
            return abs(diferenciaX);
        }else if((diferenciaY>0 && diferenciaX==0) || (diferenciaY<0 && diferenciaX==0)){
            return abs(diferenciaY);
        }else{
            return 0;
        }
    }
    
    private int abs (int numero) { 
        return numero > 0 ? numero : -numero; 
    }
    
}
