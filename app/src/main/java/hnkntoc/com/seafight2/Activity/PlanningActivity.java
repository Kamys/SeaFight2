package hnkntoc.com.seafight2.Activity;



import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

import hnkntoc.com.seafight2.Clikc.ClickDelet;
import hnkntoc.com.seafight2.Game.Field.Cell;
import hnkntoc.com.seafight2.Game.Field.PlayingField;
import hnkntoc.com.seafight2.R;
import hnkntoc.com.seafight2.Activity.fragment.PlayingFieldFragment;
import hnkntoc.com.seafight2.Game.Ship;


public class PlanningActivity extends FragmentActivity implements View.OnClickListener{

    private Ship thisShip;
    private Cell[][] listCell;
    private boolean thisStatus=true; //true- vertical , false - horizontal;
    private ArrayList<Ship> listShip = new ArrayList<>();
    private PlayingField playingField;

    private boolean butStateAdd; //Нажаты ли кнопки добавление корабля
    private boolean butStateDelet;//Нажати ли кнопка Удалит

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planning);

        PlayingFieldFragment fieldFragment = (PlayingFieldFragment) getFragmentManager().findFragmentById(R.id.fieldFragment);

        listCell = fieldFragment.getListCell();

        for(Cell cells[]:fieldFragment.getListCell()){
            for(Cell cell:cells){
                cell.setOnClickListener(this);
            }
        }

        playingField = new PlayingField(listCell);

    }

    @Override
    public void onClick(View v) {
        Log.i("onClick", v.toString());
        Cell cell = (Cell) v;

        if(butStateAdd) {
            thisShip.setColumns(cell.getColumns());
            thisShip.setRows(cell.getRows());
            thisShip.setState(thisStatus);
            listShip.add(thisShip);
            playingField.AddGameObject(thisShip,cell.getColumns(),cell.getRows());
        }

        if(cell.getGameObject()==null){
            return;
        }

        try {
            Ship s = (Ship) cell.getGameObject();
        } catch (Exception e) {
            return;
        }


        if(butStateDelet){
            listShip.remove(cell.getGameObject());
            playingField.onClikc(cell.getColumns(),cell.getRows(),new ClickDelet());
        }


        butStateAdd = false;
        butStateDelet = false;
    }

    public void OnClickNewShip(View v){
        butStateAdd = true;
        switch (v.getId()){
            case R.id.Ship1: thisShip = new Ship(R.drawable.yellow_field,1); break;
            case R.id.Ship2: thisShip = new Ship(R.drawable.green_field,2); break;
            case R.id.Ship3: thisShip = new Ship(R.drawable.blue_field,3); break;
            case R.id.Ship4: thisShip = new Ship(R.drawable.red_field,4); break;
        }
    }

    public void OnClickStatusChange(View v){
        ImageView imageView = (ImageView) v;
        if(thisStatus){
            imageView.setImageResource(R.drawable.gorizont);
            thisStatus=false;
        }else {
            imageView.setImageResource(R.drawable.vertical);
            thisStatus=true;
        }
    }

    public void OnClickDelete(View v){
        butStateDelet = true;
    }

    public void OnClickNext(View v){
        for (Ship ship:listShip) {
            Log.i("OnClickNext",ship.toString());
        }
    }

    public void OnClickClear(View v){
        for(Ship ship:listShip){
            ship.destruction(listCell,ship.getColumns(),ship.getRows());
        }
    }

}
