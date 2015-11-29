package hnkntoc.com.seafight2.Game;

import java.util.ArrayList;

import hnkntoc.com.seafight2.Game.Object.Ship;

/**
 * Created by HNKNTOC on 29.11.2015.
 */
public class Bot extends Player{

    public Bot(ArrayList<Ship> listShip) {
        super(listShip, "Бот Вася");
    }

    @Override
    public void setMove(boolean move) {
        super.setMove(move);

        if(move){

            int columns = (int) (Math.random()*10);
            int rows = (int) (Math.random()*10);

            onClick(listCellEnemy[columns][rows]);
        }
    }
}
