package hnkntoc.com.seafight2.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;


import hnkntoc.com.seafight2.Activity.fragment.PlayingFieldFragment;
import hnkntoc.com.seafight2.Game.Battlefield;
import hnkntoc.com.seafight2.Game.Players.Player;
import hnkntoc.com.seafight2.R;

/**
 * В этом активити происходит бой между двумя игроками или ботом.
 */
public class BattlefieldActivity extends FragmentActivity {

    Battlefield battlefield;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.battl);

        PlayingFieldFragment fragment1 = (PlayingFieldFragment) getFragmentManager().findFragmentById(R.id.fragment1);
        PlayingFieldFragment fragment2 = (PlayingFieldFragment) getFragmentManager().findFragmentById(R.id.fragment2);

        Player player1 = (Player) getIntent().getSerializableExtra("Player1");
        Player player2 = (Player) getIntent().getSerializableExtra("Player2");

        fragment1.update(player1.getListShip());
        fragment2.update(player1.getListShip());

        player1.setListCell(fragment1.getListCell());
        player2.setListCell(fragment2.getListCell());
        player2.setListCellEnemy(fragment1.getListCell());

        battlefield = new Battlefield(player1,player2,this);

        battlefield.startCombat();

    }

    public void next(Player player){
        Intent intent = new Intent(this,Victory.class);
        intent.putExtra("victory",player.getName());
        startActivity(intent);
    }

}
