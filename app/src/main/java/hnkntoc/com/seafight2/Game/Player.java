package hnkntoc.com.seafight2.Game;

import android.view.View;

import java.io.Serializable;
import java.util.ArrayList;

import hnkntoc.com.seafight2.Game.Field.Cell;
import hnkntoc.com.seafight2.Game.Object.Ship;
import hnkntoc.com.seafight2.R;

/**
 * Created by HNKNTOC on 28.11.2015.
 */
public class Player implements View.OnClickListener,Serializable {
    protected String name;
    protected Cell[][] listCell;
    protected ArrayList<Ship> listShip;
    protected boolean move;
    protected Battlefield battlefield;
    protected int hit;
    protected Cell[][] listCellEnemy;

    public Player(ArrayList<Ship> listShip, String name) {
        this.listShip = listShip;
        this.name = name;

        for(Ship ship:listShip){
            ship.setResorseId(R.drawable.white_field);
        }

    }

    public void setListCellEnemy(Cell[][] listCellEnemy) {
        this.listCellEnemy = listCellEnemy;
    }

    public int getHit() {
        return hit;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }

    public boolean getMove() {
        return move;
    }

    public void setMove(boolean move) {
        this.move = move;
    }

    public String getName() {
        return name;
    }

    public Cell[][] getListCell() {
        return listCell;
    }

    public void setListCell(Cell[][] listCell) {
        this.listCell = listCell;
        for(Cell[] listCells:listCell){
            for(Cell cell:listCells){
                cell.setOnClickListener(this);
            }
        }
    }

    public ArrayList<Ship> getListShip() {
        return listShip;
    }

    public void setBattlefield(Battlefield battlefield) {
        this.battlefield = battlefield;
    }

    @Override
    public void onClick(View view) {
        if(battlefield==null){
            return;
        }
        Cell cell = (Cell) view;
        battlefield.movePlayer(this,cell.getColumns(),cell.getRows());
    }
}
