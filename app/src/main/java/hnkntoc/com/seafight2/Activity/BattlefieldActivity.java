package hnkntoc.com.seafight2.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;


import java.util.ArrayList;

import hnkntoc.com.seafight2.Activity.fragment.PlayingFieldFragment;
import hnkntoc.com.seafight2.Calculate.ShipDraw;
import hnkntoc.com.seafight2.Game.Field.Cell;
import hnkntoc.com.seafight2.Game.Ship;
import hnkntoc.com.seafight2.R;

/**
 * Created by HNKNTOC on 22.11.2015.
 */
public class BattlefieldActivity extends FragmentActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.battl);

        PlayingFieldFragment fragment = (PlayingFieldFragment) getFragmentManager().findFragmentById(R.id.fragment1);

        Cell[][] cells = fragment.getListCell();

        for (Ship ship: (ArrayList<Ship>) getIntent().getSerializableExtra("list")) {
            ShipDraw shipDraw = new ShipDraw(cells,ship,ship.getColumns(),ship.getRows());
            shipDraw.action();
        }

    }
}
