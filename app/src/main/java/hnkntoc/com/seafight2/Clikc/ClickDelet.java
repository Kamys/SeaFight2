package hnkntoc.com.seafight2.Clikc;


import hnkntoc.com.seafight2.Game.Field.Cell;

/**
 * Created by HNKNTOC on 19.11.2015
 */
public class ClickDelet implements HandlerCellClick {
    @Override
    public boolean OnClick(Cell[][] listCell, int columns, int rows) {
        listCell[columns][rows].getGameObject()
                .destruction(listCell,columns,rows);
        return true;
    }
}
