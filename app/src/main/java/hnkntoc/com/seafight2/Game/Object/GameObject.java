package hnkntoc.com.seafight2.Game.Object;


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
    protected String typeName;

    public GameObject(int resorseId,String typeName) {
        this.resorseId = resorseId;
        this.typeName=typeName;
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

    public String getTypeName() {
        return typeName;
    }

    public boolean add(Cell[][] listCell){
        listCell[columns][rows].setGameObject(this);
        return true;
    }

    public void setResorseId(int resorseId) {
        this.resorseId = resorseId;
    }

    public void onClick(Cell cell){
        Log.i("GameObject",cell.toString());
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
