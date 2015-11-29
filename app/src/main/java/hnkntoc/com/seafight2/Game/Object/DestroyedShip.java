package hnkntoc.com.seafight2.Game.Object;

import hnkntoc.com.seafight2.Game.Field.Cell;
import hnkntoc.com.seafight2.R;

/**
 * Поподание
 */
public class DestroyedShip extends GameObject {
    public DestroyedShip() {
        super(R.drawable.krestik,"DestroyedShip");
    }

    @Override
    public void onClick(Cell cell) {
        super.onClick(cell);
    }
}
