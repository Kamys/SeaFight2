package hnkntoc.com.seafight2.Calculate;

import android.util.Log;

import hnkntoc.com.seafight2.Game.Field.Cell;
import hnkntoc.com.seafight2.Game.Indent;
import hnkntoc.com.seafight2.Game.Ship;

/**
 * Created by HNKNTOC on 11.11.2015.
 */
public class ShipDraw extends CalculateCoorShip {

    public ShipDraw(Cell[][] listCell, Ship ship, int columns, int rows) {
        super(listCell, ship, columns, rows);
        super.columns--;
        super.rows--;
    }

    @Override
    protected void actionShip(int columns, int rows) {
        Log.i("ActionGrap kr", "" + columns + ";" + rows + "=" + listCell[columns][rows].toString());
        Cell cell = listCell[columns][rows];
        cell.setGameObject(ship);
    }

    @Override
    protected void actionIndent(int columns, int rows) {
        Log.i("ActionGrap krestik", "" + columns + ";" + rows + "=" + listCell[columns][rows].toString());
        Cell cell = listCell[columns][rows];
        if(cell.getGameObject()==null){
            cell.setGameObject(new Indent());
        }else {
            cell.getGameObject().onClick();
        }
    }

    @Override
    public boolean action() {
        ShipCheck check = new ShipCheck(listCell,ship,columns,rows);
        if (!check.action()) {
            return false;
        }
        calculateCell();
        return true;
    }
}
