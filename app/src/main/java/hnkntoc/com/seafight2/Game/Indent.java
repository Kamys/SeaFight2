package hnkntoc.com.seafight2.Game;

import hnkntoc.com.seafight2.Game.Field.Cell;
import hnkntoc.com.seafight2.R;

/**
 * Created by HNKNTOC on 19.11.2015.
 */
public class Indent extends GameObject {

    private int quantity=1;

    public Indent(int columns,int rows) {
        super(R.drawable.krestik);
        this.columns=columns;
        this.rows=rows;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean add(Cell[][] listCell) {
        listCell[columns][rows].setGameObject(this);
        return true;
    }

    @Override
    public void onClick() {
        quantity++;
    }

    @Override
    public boolean destruction(Cell[][] listCell) {
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
