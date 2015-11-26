package hnkntoc.com.seafight2.Game;


import android.util.Log;

import java.io.Serializable;

import hnkntoc.com.seafight2.Game.Field.Cell;

/**
 * Интерфейс от которого наследуются все отображаемые объекты на игровом поле
 */
public class GameObject implements Serializable {
    protected int resorseId;
    protected int rows;
    protected int columns;

    public GameObject(int resorseId) {
        this.resorseId = resorseId;
    }

    public int getResorseId() {
        return resorseId;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public boolean add(Cell[][] listCell){
        listCell[columns][rows].setGameObject(this);
        return true;
    }

    public void setResorseId(int resorseId) {
        this.resorseId = resorseId;
    }

    public void onClick(){
        Log.i("GameObject",this.toString());
    }

    public boolean destruction(Cell[][] listCell){
        listCell[columns][rows].setGameObject(null);
        return true;
    }

    @Override
    public String toString() {
        return "GameObject{" +
                "resorseId=" + resorseId +
                '}';
    }
}
