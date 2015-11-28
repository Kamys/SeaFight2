package hnkntoc.com.seafight2.Activity;



import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import hnkntoc.com.seafight2.Game.Field.Cell;
import hnkntoc.com.seafight2.Game.Field.PlayingField;
import hnkntoc.com.seafight2.R;
import hnkntoc.com.seafight2.Activity.fragment.PlayingFieldFragment;

/**
 * В этом активити происходит расстановка Ships.
 *
 */
public class PlanningActivity extends FragmentActivity implements View.OnClickListener{

    private int thisShip;
    private boolean thisStatus=true; //true- vertical , false - horizontal;
    private PlayingField playingField;
    private PlayingFieldFragment playingFieldFragment;

    private boolean butStateAdd; //Нажаты ли кнопки добавление корабля
    private boolean butStateDelet;//Нажати ли кнопка Удалит

    private Button addShip1;
    private Button addShip2;
    private Button addShip3;
    private Button addShip4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planning);

        addShip1 = (Button) findViewById(R.id.newShip1);
        addShip2 = (Button) findViewById(R.id.newShip2);
        addShip3 = (Button) findViewById(R.id.newShip3);
        addShip4 = (Button) findViewById(R.id.newShip4);

        playingFieldFragment = (PlayingFieldFragment) getFragmentManager().findFragmentById(R.id.fieldFragment);

        for(Cell cells[]: playingFieldFragment.getListCell()){
            for(Cell cell:cells){
                cell.setOnClickListener(this);
            }
        }

        playingField = new PlayingField(playingFieldFragment.getListCell(),this);

    }

    @Override
    public void onClick(View v) {
        Log.i("onClick", v.toString());
        Cell cell = (Cell) v;

        int columns = cell.getColumns();
        int rows = cell.getRows();

        if(butStateAdd & thisShip != 0) {
            playingField.addGameObject(thisShip, thisStatus,columns,rows);
        }

        if(cell.getGameObject()==null){
            return;
        }

        if(thisShip!=0){
            return;
        }


        if(butStateDelet){
            playingField.destructionGameObject(columns, rows);
        }
        butStateAdd = false;
        butStateDelet = false;
    }

    public void OnClickNewShip(View v){
        thisShip=0;
        butStateAdd = true;
        switch (v.getId()){
            case R.id.newShip1: thisShip = 1; break;
            case R.id.newShip2: thisShip = 2; break;
            case R.id.newShip3: thisShip = 3; break;
            case R.id.newShip4: thisShip = 4; break;
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
        thisShip = 0;
        butStateDelet = true;
    }

    public void OnClickClear(View v){
        playingField.clearGameObject();
    }

    public void OnClickNext(View v){
        Log.i("OnClickNext", "NEXT GO");
        Intent intent = new Intent(this,BattlefieldActivity.class);
        intent.putExtra("Player1", "test");
        intent.putExtra("Player2", "");
        startActivity(intent);
    }

    public void OnClickRandom(View v){
        playingField.Random(playingFieldFragment);
    }

    public Button getAddShip1() {
        return addShip1;
    }

    public Button getAddShip2() {
        return addShip2;
    }

    public Button getAddShip3() {
        return addShip3;
    }

    public Button getAddShip4() {
        return addShip4;
    }
}
