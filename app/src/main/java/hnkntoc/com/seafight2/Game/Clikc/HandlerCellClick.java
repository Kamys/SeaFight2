package hnkntoc.com.seafight2.Game.Clikc;


import hnkntoc.com.seafight2.Game.Field.Cell;

/**
 * Интерфейс для реализации обработки клика на Cell
 */
public interface HandlerCellClick {
    boolean OnClick(Cell[][] listCell,int columns,int rows);
}
