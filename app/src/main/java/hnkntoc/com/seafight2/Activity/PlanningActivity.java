package hnkntoc.com.seafight2.Activity;



import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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

    private Button addShip1;
    private Button addShip2;
    private Button addShip3;
    private Button addShip4;

    private int quantityShips1;
    private int quantityShips2;
    private int quantityShips3;
    private int quantityShips4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planning);

        addShip1 = (Button) findViewById(R.id.newShip1);
        addShip2 = (Button) findViewById(R.id.newShip2);
        addShip3 = (Button) findViewById(R.id.newShip3);
        addShip4 = (Button) findViewById(R.id.newShip4);

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

        if(butStateAdd & thisShip != null) {
            thisShip.setColumns(cell.getColumns());
            thisShip.setRows(cell.getRows());
            thisShip.setState(thisStatus);
            if(playingField.AddGameObject(thisShip,cell.getColumns(),cell.getRows())){
                listShip.add(thisShip);
            }
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
        calcShips();
        butStateAdd = false;
        butStateDelet = false;
    }

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
            addShip1.setEnabled(false);
        }else {
            addShip1.setEnabled(true);
        }

        if(quantityShips2>=3){
            addShip2.setEnabled(false);
        }else {
            addShip2.setEnabled(true);
        }

        if(quantityShips3>=2){
            addShip3.setEnabled(false);
        }else {
            addShip3.setEnabled(true);
        }

        if(quantityShips4>=1){
            addShip4.setEnabled(false);
        }else {
            addShip4.setEnabled(true);
        }
    }

    public void OnClickNewShip(View v){
        thisShip=null;
        butStateAdd = true;
        switch (v.getId()){
            case R.id.newShip1: thisShip = new Ship(R.drawable.yellow_field,1); break;
            case R.id.newShip2: thisShip = new Ship(R.drawable.green_field,2); break;
            case R.id.newShip3: thisShip = new Ship(R.drawable.blue_field,3); break;
            case R.id.newShip4: thisShip = new Ship(R.drawable.red_field,4); break;
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

    public void OnClickClear(View v){
        for(Ship ship:listShip){
            ship.destruction(listCell, ship.getColumns(), ship.getRows());
        }
        listShip.clear();
        calcShips();
    }

    public void OnClickNext(View v){
        Log.i("OnClickNext", "NEXT GO");
        Intent intent = new Intent(this,BattlefieldActivity.class);
        intent.putExtra("list",listShip);
        startActivity(intent);
    }
}
