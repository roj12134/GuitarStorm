/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Giovanni Rojas Mazariegos 
 */
public class NotesModel {
    
    private int pos;
    private int time;
    private int posy;

    public NotesModel(int pos, int time) {
        this.pos = pos;
        this.time = time;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getPosY() {
       return posy;
    }

    public void setPosY(int posy) {
        this.posy = posy;
    }
    
    
    
    
}
