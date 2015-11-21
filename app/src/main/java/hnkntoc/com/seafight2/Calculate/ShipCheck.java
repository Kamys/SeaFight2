package hnkntoc.com.seafight2.Calculate;


import hnkntoc.com.seafight2.Game.Field.Cell;
import hnkntoc.com.seafight2.Game.Ship;

/**
 *Проверка Cells на содержани в них других GameObject.
 *true если Cells пусты
 */
public class ShipCheck extends CalculateCoor {

    private boolean check=true;

    public ShipCheck(Cell[][] listCell, Ship ship, int columns, int rows) {
        super(listCell, ship, columns, rows);
    }

    @Override
    public boolean action() {
        calculateCell();
        return check;
    }

    protected void Draw2(int columns,int rows){
        for(int i=0;i<3;i++){
            if (i==1) {
                if (checkCell(columns,rows)) {
                    actionShip(columns, rows);
                }else {
                    check = false;
                }
            }else {
                if (checkCell(columns,rows)) {
                    actionIndent(columns, rows);
                }
            }
            if(ship.getState()){
                rows++;
            }else {
                columns++;
            }
        }
    }

    /**
     * Проверяет пустая ли Cell
     * @param columns
     * @param rows
     */
    @Override
    protected void actionShip(int columns, int rows) {
        if(check){
            if(!(listCell[columns][rows].getGameObject()==null)){ check = false;}
        }
    }
}
