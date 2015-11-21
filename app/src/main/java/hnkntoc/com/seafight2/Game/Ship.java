package hnkntoc.com.seafight2.Game;

import android.util.Log;


import hnkntoc.com.seafight2.Calculate.CalculateCoor;
import hnkntoc.com.seafight2.Calculate.ShipDelet;
import hnkntoc.com.seafight2.Calculate.ShipDraw;
import hnkntoc.com.seafight2.Game.Field.Cell;


/**
 * Created by HNKNTOC on 10.11.2015.
 */
public class Ship extends GameObject {

    private static final String TAG = "Ship";

    private int size;
    private boolean state;
    private int rows;
    private int columns;

    public Ship(int resorseId,int size) {
        super(resorseId);
        this.size = size;
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

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }


    @Override
    public void add(Cell[][] listCell,int columns, int rows) {
        ShipDraw draw = new ShipDraw(listCell,this,columns,rows);
        if(!draw.action()){
            Log.v(TAG, "Не прошол проверку (клетка занята)");
        }
    }

    @Override
    public void destruction(Cell[][] listCell,int columns, int rows) {
        CalculateCoor calculateCoor = new ShipDelet(listCell,this,this.columns,this.rows);
        calculateCoor.action();
    }

    @Override
    public String toString() {
        return "Ship{" +
                "size=" + size +
                ", state=" + state +
                '}';
    }
}
