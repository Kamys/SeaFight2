package hnkntoc.com.seafight2.Game.Object;


import hnkntoc.com.seafight2.Game.Calculate.CalculateCoorShip;
import hnkntoc.com.seafight2.Game.Calculate.ShipDelet;
import hnkntoc.com.seafight2.Game.Calculate.ShipDraw;
import hnkntoc.com.seafight2.Game.Field.Cell;
import hnkntoc.com.seafight2.R;


/**
 * Created by HNKNTOC on 10.11.2015.
 */
public class Ship extends GameObject {

    private int size;
    private boolean state; //true- vertical , false - horizontal;

    public Ship(int size) {
        super(R.drawable.white_field,"Ship");
        this.size = size;

        switch (size){
            case 1: resorseId = R.drawable.yellow_field; break;
            case 2: resorseId = R.drawable.green_field; break;
            case 3: resorseId = R.drawable.blue_field; break;
            case 4: resorseId = R.drawable.red_field; break;
        }

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
    public boolean add(Cell[][] listCell) {
        ShipDraw draw = new ShipDraw(listCell,this);
        return draw.action();
    }

    @Override
    public boolean destruction(Cell[][] listCell) {
        CalculateCoorShip calculateCoor = new ShipDelet(listCell,this,this.columns,this.rows);
        return calculateCoor.action();
    }

    @Override
    public void onClick(Cell cell) {
        cell.setGameObject(new DestroyedShip());
    }

    @Override
    public String toString() {
        return "Ship{" +
                "size=" + size +
                ", state=" + state +
                '}';
    }
}
