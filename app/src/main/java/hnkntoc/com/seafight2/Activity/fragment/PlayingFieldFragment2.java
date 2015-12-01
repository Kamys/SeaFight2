package hnkntoc.com.seafight2.Activity.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import hnkntoc.com.seafight2.Game.Field.Cell;
import hnkntoc.com.seafight2.R;

/**
 * Created by HNKNTOC on 25.11.2015.
 */
public class PlayingFieldFragment2 extends Fragment {

    private static final String[] nameColumns = {"", "А", "Б", "В", "Г", "Д", "Е", "Ё", "Ж", "З", "И"};
    private static final String[] nameRows = {"", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    private ViewGroup rootView;
    private Cell[][] listCell = new Cell[10][10];
    private GridView gridView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = (ViewGroup) inflater.inflate(R.layout.fragment_field2, container, false);

        gridView = (GridView) rootView.findViewById(R.id.gridview);

        gridView.setNumColumns(10);

        gridView.setVerticalSpacing(-10);
        //gridView.setHorizontalSpacing(-100);

        gridView.setAdapter(new ImageAdapter(rootView.getContext(), 10, 10));
        gridView.setEnabled(true);


        gridView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_MOVE) {
                    return true;
                }
                return false;
            }
        });


        return rootView;
    }
}
