package hnkntoc.com.seafight2.Game;

import hnkntoc.com.seafight2.Game.Field.Cell;
import hnkntoc.com.seafight2.R;

/**
 * Created by HNKNTOC on 19.11.2015.
 */
public class Indent extends GameObject {

    private int quantity=1;

    public Indent() {
        super(R.drawable.krestik);
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean add(Cell[][] listCell, int columns, int rows) {
        listCell[columns][rows].setGameObject(this);
        return true;
    }

    @Override
    public void onClick() {
        quantity++;
    }

    @Override
    public boolean destruction(Cell[][] listCell,int columns, int rows) {
        quantity--;
        if(quantity<=0){
            listCell[columns][rows].setGameObject(null);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Indent{" +
                "quantity=" + quantity +
                '}';
    }
}
