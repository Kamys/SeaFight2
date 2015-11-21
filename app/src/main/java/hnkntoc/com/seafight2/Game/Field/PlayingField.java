package hnkntoc.com.seafight2.Game.Field;


import hnkntoc.com.seafight2.Clikc.HandlerCellClick;
import hnkntoc.com.seafight2.Game.GameObject;

/**
 * Created by HNKNTOC on 19.11.2015.
 */
public class PlayingField {
    private Cell[][] listCell;

    public PlayingField(Cell[][] listCell) {
        this.listCell = listCell;
    }

    public void AddGameObject(GameObject gameObject,int columns,int rows){

        gameObject.add(listCell,columns,rows);
    }

    public void onClikc(int columns,int rows,HandlerCellClick handlerCellClick){

        handlerCellClick.OnClick(listCell,columns,rows);
    }

}
