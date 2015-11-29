package hnkntoc.com.seafight2.Game;



import android.util.Log;

import java.util.Objects;

import hnkntoc.com.seafight2.Activity.BattlefieldActivity;
import hnkntoc.com.seafight2.Game.Field.Cell;
import hnkntoc.com.seafight2.Game.Object.GameObject;
import hnkntoc.com.seafight2.Game.Object.Miss;

/**
 * Здесь происходит обработка событий боя
 */
public class Battlefield{

    private Player player1;
    private Player player2;
    private BattlefieldActivity battlefieldActivity;
    private int xod;

    public Battlefield(Player player1, Player player2,BattlefieldActivity battlefieldActivity) {
        this.battlefieldActivity=battlefieldActivity;
        this.player1 = player1;
        this.player2 = player2;
        player1.setBattlefield(this);
        player2.setBattlefield(this);
    }

    public boolean startCombat(){
        player1.setMove(true);
        return true;
    }

    public boolean stopCombat(){
        player1.setMove(false);
        player2.setMove(false);
        return true;
    }

    private void nextMove(){
        if(player1.getMove()){
            player1.setMove(false);
            player2.setMove(true);
        }else {
            player2.setMove(false);
            player1.setMove(true);
        }

    }

    public void movePlayer(Player player,int columns,int rows){

        if(!player.getMove()){
            Log.i("Battlefield","Player "+player.getName()+" not move");
            return;
        }


        Cell cell = player.getListCell()[columns][rows];
        GameObject gameObject = cell.getGameObject();

        if(gameObject==null){
            cell.setGameObject(new Miss());
            nextMove();
            xod++;
            Log.i("Battlefield", xod + " Ходит " + player.getName() + " по " + columns + ";" + rows);
            return;
        }
            Log.i("Battlefield","");
        switch (gameObject.getTypeName()){
            case "Ship": gameObject.onClick(cell); player.setHit(player.getHit() + 1);
            case "Miss": player.setMove(true); xod--; break;

            case "Indent": gameObject.onClick(cell); nextMove(); break;
            case "DestroyedShip": player.setMove(true);  break;
            default:  break;
        }

        if(player.getHit()==20){
            battlefieldActivity.next(player);
        }

        xod++;
        Log.i("Battlefield",xod+" Ходит "+player.getName()+" по "+columns+";"+rows);

    }

}
