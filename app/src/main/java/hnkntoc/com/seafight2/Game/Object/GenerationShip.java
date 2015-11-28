package hnkntoc.com.seafight2.Game.Object;

import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

import hnkntoc.com.seafight2.Game.Calculate.ShipDraw;
import hnkntoc.com.seafight2.Game.Field.Cell;

/**
 * Случайно растовляет колабли на игровом поле;
 */
public class GenerationShip {

    private Cell[][] listCell;
    private ArrayList<Ship> listShip;

    public GenerationShip(Cell[][] cells) {
        this.listCell =cells;
    }

    public ArrayList<Ship> getListShip() {
        return listShip;
    }

    /**
     * Возвращает список 10 Ship со случайно сгенерированным положением.
     * @return ArrayList<Ship>
     */
    private ArrayList<Ship> getRandomShips(){
        ArrayList<Ship> ships = new ArrayList<>();

        int number=4;

        for(int i=1;i<=4;i++){
            for(int s=0;s<number;s++){
                ships.add(new Ship(i));
            }
            number--;
        }

        return ships;
    }

    /**
     * Рандомно растовляет Ships из listShip в listCell;
     * @return false при возникновении ошибки
     */
    private boolean putRandomAllShips(){
        listShip = getRandomShips();
        int i=0;
        for(Ship ship:listShip){
            while (!putRandomShip(ship)){
                i++;
                if(i>2000){
                    Log.e("GenerationShip","Generation Ships attempts exceeded 2000");
                    return false;
                }
            }
            Log.i("GenerationShip","unsuccessful generation "+i);
        }

        return true;
    }

    /**
     * Рандомно генерирует координаты для Ships и ставит Ships в listCell;
     * @return false если место зането
     */
    private boolean putRandomShip(Ship ship){

        ShipDraw shipDraw;
        int columns=11,row=11;

        if(ship.getState()){
            columns=columns-ship.getSize();
            row--;
        }else {
            row=row-ship.getSize();
            columns--;
        }
        ship.setColumns((int) (Math.random() * columns));
        ship.setRows((int) (Math.random() * row));
        Random r = new Random();
        ship.setState(r.nextBoolean());

        shipDraw = new ShipDraw(listCell,ship);
        return shipDraw.action();
    }

    /**
     * Случайно растонавливает Ships в Cell[][]
     * @return false при возникновении ошибки
     */
    public boolean generate(){
        int i=0;
        while (!putRandomAllShips()){
            i++;
            if(i>200){
                Log.e("GenerationShip","Generation BattleField attempts exceeded 200");
                return false;
            }
            for(Ship ship:listShip){
                ship.destruction(listCell);
            }
        }
        return true;
    }

}
