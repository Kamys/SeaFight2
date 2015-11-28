package hnkntoc.com.seafight2.Game.Calculate;


import hnkntoc.com.seafight2.Game.Field.Cell;
import hnkntoc.com.seafight2.Game.Object.Ship;

/**
 * Created by HNKNTOC on 14.11.2015.
 */
public class ShipDelet extends CalculateCoorShip {

    public ShipDelet(Cell[][] listCell, Ship ship, int columns, int rows) {
        super(listCell, ship, columns, rows);
        super.columns--;
        super.rows--;
    }

    @Override
    protected void actionShip(int columns, int rows) {
        Cell cell = listCell[columns][rows];
        cell.setGameObject(null);
    }

    @Override
    protected void actionIndent(int columns, int rows) {
        Cell cell = listCell[columns][rows];
        if(cell.getGameObject()!=null){
            cell.getGameObject().destruction(listCell);
        }
    }

    @Override
    public boolean action() {
        return super.action();
    }
}
