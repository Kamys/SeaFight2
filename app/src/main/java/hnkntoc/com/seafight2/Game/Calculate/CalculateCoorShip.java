package hnkntoc.com.seafight2.Game.Calculate;


import hnkntoc.com.seafight2.Game.Field.Cell;
import hnkntoc.com.seafight2.Game.Object.Ship;

/**
 * Главный класс в котором производится вычисления клеток на которых находятся кораблик.
 * Дочерние классы совершают действия с этими клетками
 */
public class CalculateCoorShip {
    protected Cell[][] listCell;
    protected Ship ship;
    protected int columns;
    protected int rows;

    public CalculateCoorShip(Cell[][] listCell, Ship ship
            , int columns, int rows) {
        this.columns = columns;
        this.rows = rows;
        this.listCell = listCell;
        this.ship = ship;
    }

    /**
     * Высчитывает из listCell, сell на которых находится ship.
     */
    protected void calculateCell(){

        int rows = this.rows;
        int columns = this.columns;


        Draw1(columns,rows);
        if(ship.getState()){
            columns++;
        }else {
            rows++;
        }
        for(int i=0;i<ship.getSize();i++){
            Draw2(columns, rows);

            if(ship.getState()){
                columns++;
            }else {
                rows++;
            }

        }
        Draw1(columns,rows);

    }


    protected void Draw1(int columns,int rows){
        for(int i=0;i<3;i++){
            if(checkCell(columns,rows)) {
                actionIndent(columns, rows);
            }
            if(ship.getState()){
                rows++;
            }else {
                columns++;
            }
        }
    }

    protected void Draw2(int columns,int rows){
        for(int i=0;i<3;i++){
            if (i==1) {
                if (checkCell(columns,rows)) {
                    actionShip(columns, rows);
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
     * Метод получает координаты на которых находится корабль
     */
    protected void actionShip(int columns,int rows){

    }

    /**
     * Метод получает координаты на которых находится отступ
     */
    protected void actionIndent(int columns,int rows){

    }

    /**
     * Если  columns или rows больше 9 или меньше 0 возвращает false
     * нужен для того чтоб кораблики не выходили за кроя игрового поля
     */
    protected boolean checkCell(int columns,int rows){
        return (columns>=0 & columns<=9 & rows>=0 & rows<=9);
    }

    /**
     * Запуск вычисления координат для корабля.
     * @return возвращает false если что-то пошло не так.
     */
    public boolean action(){
        calculateCell();
        return true;
    }

}
