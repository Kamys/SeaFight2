package hnkntoc.com.seafight2.Game.Field;

import android.content.Context;
import android.widget.ImageView;

import hnkntoc.com.seafight2.Game.GameObject;
import hnkntoc.com.seafight2.R;


/**
 * Клетка поля содержит состояние клетки и её координаты
 */
public class Cell extends ImageView {

    private int rows;
    private int columns;
    private GameObject gameObject;

    public Cell(Context context, int rows, int y) {
        super(context);
        this.rows = rows;
        this.columns = y;
        update();
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public GameObject getGameObject() {
        return gameObject;
    }

    public void setGameObject(GameObject gameObject) {
        this.gameObject = gameObject;
        update();
    }

    public void onClick(){
    }

    /**
     * Обновляет картинку Cell взависимости
     */
    private void update(){

        if(gameObject==null){
            setImageResource(R.drawable.white_field);
        }else {
            setImageResource(gameObject.getResorseId());
        }
    }

    @Override
    public String toString() {
        return "columns="+ columns +" rows="+ rows+" ship="+ gameObject;
    }

}
