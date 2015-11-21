package hnkntoc.com.seafight2.Game;


import android.util.Log;

import hnkntoc.com.seafight2.Game.Field.Cell;

/**
 * Интерфейс от которого наследуются все отображаемые объекты на игровом поле
 */
public class GameObject {
    protected int resorseId;

    public GameObject(int resorseId) {
        this.resorseId = resorseId;
    }

    public int getResorseId() {
        return resorseId;
    }

    public void add(Cell[][] listCell,int columns,int rows){
        listCell[columns][rows].setGameObject(this);
    }

    public void setResorseId(int resorseId) {
        this.resorseId = resorseId;
    }

    public void onClick(){
        Log.i("GameObject",this.toString());
    }

    public void destruction(Cell[][] listCell,int columns,int rows){
        listCell[columns][rows].setGameObject(null);
    }

    @Override
    public String toString() {
        return "GameObject{" +
                "resorseId=" + resorseId +
                '}';
    }
}
