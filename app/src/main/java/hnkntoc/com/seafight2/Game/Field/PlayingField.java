package hnkntoc.com.seafight2.Game.Field;


import java.util.ArrayList;

import hnkntoc.com.seafight2.Activity.PlanningActivity;
import hnkntoc.com.seafight2.Activity.fragment.PlayingFieldFragment;
import hnkntoc.com.seafight2.Game.Calculate.ShipDraw;
import hnkntoc.com.seafight2.Game.Clikc.HandlerCellClick;
import hnkntoc.com.seafight2.Game.Object.GameObject;
import hnkntoc.com.seafight2.Game.Object.GenerationShip;
import hnkntoc.com.seafight2.Game.Object.Ship;

/**
 * Обрабатывает события происходящие в PlanningActivity
 */
public class PlayingField {
    private Cell[][] listCell;
    private ArrayList<Ship> listShip = new ArrayList<>();

    private PlanningActivity PA;

    private int quantityShips1;
    private int quantityShips2;
    private int quantityShips3;
    private int quantityShips4;


    public PlayingField(Cell[][] listCell,PlanningActivity planningActivity) {
        this.PA = planningActivity;
        this.listCell = listCell;
    }

    public boolean addGameObject(int thisShip, boolean thisStatus, int columns, int rows){
        Ship ship = new Ship(thisShip);
        ship.setState(thisStatus);
        ship.setColumns(columns);
        ship.setRows(rows);

        ShipDraw shipDraw = new ShipDraw(listCell,ship);

        if (shipDraw.action()){
            listShip.add(ship);
            calcShips();
            return true;
        }
        return false;
    }

    public boolean destructionGameObject(int columns,int rows){
        GameObject gameObject = listCell[columns][rows].getGameObject();
        if(gameObject.destruction(listCell)){
            listShip.remove(gameObject);
            calcShips();
            return true;
        }
        return false;
    }

    public boolean onClikc(int columns,int rows,HandlerCellClick handlerCellClick){

        return handlerCellClick.OnClick(listCell, columns, rows);
    }

    public boolean clearGameObject(){
        for(Ship ship:listShip){
            ship.destruction(listCell);
        }
        listShip.clear();
        calcShips();
        return true;
    }

    public boolean Random(PlayingFieldFragment playingFieldFragment){
        clearGameObject();
        GenerationShip generationShip = new GenerationShip(listCell);
        if(!generationShip.generate()){
            playingFieldFragment.update(listShip);
            calcShips();
            return false;
        }
        listShip = generationShip.getListShip();
        calcShips();
        return true;
    }

    /**
     * Считает количество Ships
     */
    public void calcShips(){

        quantityShips1=0;
        quantityShips2=0;
        quantityShips3=0;
        quantityShips4=0;

        for(Ship ship:listShip){
            switch (ship.getSize()){
                case 1: quantityShips1++; break;
                case 2: quantityShips2++; break;
                case 3: quantityShips3++; break;
                case 4: quantityShips4++; break;
            }
        }
        checButton();
    }

    public void checButton(){
        if(quantityShips1>=4){
            PA.getAddShip1().setEnabled(false);
        }else {
            PA.getAddShip1().setEnabled(true);
        }

        if(quantityShips2>=3){
            PA.getAddShip2().setEnabled(false);
        }else {
            PA.getAddShip2().setEnabled(true);
        }

        if(quantityShips3>=2){
            PA.getAddShip3().setEnabled(false);
        }else {
            PA.getAddShip3().setEnabled(true);
        }

        if(quantityShips4>=1){
            PA.getAddShip4().setEnabled(false);
        }else {
            PA.getAddShip4().setEnabled(true);
        }
    }

}
