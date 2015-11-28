package hnkntoc.com.seafight2.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;


import java.util.ArrayList;

import hnkntoc.com.seafight2.Activity.fragment.PlayingFieldFragment;
import hnkntoc.com.seafight2.Game.Calculate.ShipDraw;
import hnkntoc.com.seafight2.Game.Field.Cell;
import hnkntoc.com.seafight2.Game.Object.Ship;
import hnkntoc.com.seafight2.R;

/**
 * В этом активити происходит бой между двумя игроками или ботом.
 */
public class BattlefieldActivity extends FragmentActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.battl);

        PlayingFieldFragment fragment = (PlayingFieldFragment) getFragmentManager().findFragmentById(R.id.fragment1);

        Cell[][] cells = fragment.getListCell();

        fragment.update((ArrayList<Ship>) getIntent().getSerializableExtra("list"));


    }
}
