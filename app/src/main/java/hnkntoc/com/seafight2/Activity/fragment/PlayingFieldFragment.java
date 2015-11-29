package hnkntoc.com.seafight2.Activity.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

import hnkntoc.com.seafight2.Game.Calculate.ShipDraw;
import hnkntoc.com.seafight2.Game.Field.Cell;
import hnkntoc.com.seafight2.Game.Object.Ship;
import hnkntoc.com.seafight2.R;

/**
 *   PlayingFieldFragment
 */
public class PlayingFieldFragment extends Fragment{

    private static final String[] nameColumns = {"","А","Б","В","Г","Д","Е","Ё","Ж","З","И"};
    private static final String[] nameRows = {"","1","2","3","4","5","6","7","8","9","10"};
    private ViewGroup rootView;
    private Cell[][] listCell = new Cell[10][10];


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         rootView = (ViewGroup) inflater.inflate(R.layout.fragment_field, container, false);

        drawField();
        return rootView;
    }

    /**
     * Вычесление dp
     * @param dpWidth
     * @param dpHeight
     * @return
     */
    public TableRow.LayoutParams expectDpLayoutParams(int dpWidth,int dpHeight){

        float density = rootView.getContext().getResources().getDisplayMetrics().density;

        TableRow.LayoutParams layoutParams = new TableRow.LayoutParams((int) (density * dpWidth), (int) (density * dpHeight));
        Log.i("density", "" + density + "\ndpWidth=" + (int) (density * dpWidth) + "\ndpHeight=" + (int) (density * dpHeight));
        return layoutParams;
    }

    /**
     *  В первый созданный TableRow добавляет 11 TextView (TextView содержит имя колонки из nameColumns).
     *  В последующие созданные TableRow добавляет 1 TextView (TextView содержит имя ряда из nameRows)
     *                                            и 10 Cell (Записывает координаты в Cell. Добавляет Cell в listCell).
     *  Получается игровое поле 10 на 10.
     */
    public void drawField(){

        final int rows = 11;
        final int columns = 11;

        TableLayout tableLayout = (TableLayout) rootView.findViewById(R.id.tableLayout);
        TableRow.LayoutParams params = expectDpLayoutParams(30,30);
        params.setMargins(-7, 0, 0, -5);

        for (int i = 0; i < rows; i++) {

            TableRow tableRow = new TableRow(rootView.getContext());
            tableRow.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));
            Log.i("ROWS=", "" + i);

            if(i==0){
                for (int j = 0; j < columns; j++) {
                    tableRow.addView(createTextView("  " + nameColumns[j], params));
                }
            }else {

                if(i==10){
                    params = expectDpLayoutParams(30,30);
                    params.setMargins(-7,0,0,0);
                    Log.i("ROWS=", "j==10");
                }

                for (int j = 0; j < columns; j++) {
                    if(j==0){
                        tableRow.addView(createTextView(" " + nameRows[i], params), j);
                    }else {
                        tableRow.addView(createCell(params, j, i), j);
                    }
                }
            }
            tableLayout.addView(tableRow, i);
        }
        Log.i("list size", "" + listCell.length);
    }


    private TextView createTextView(String txt, TableRow.LayoutParams params){
        TextView textView = new TextView(rootView.getContext());
        textView.setText(txt);
        textView.setLayoutParams(params);
        return textView;
    }


    private Cell createCell(TableRow.LayoutParams params, int rows, int columns){
        Cell cell = new Cell(rootView.getContext(),columns-1,rows-1);
        cell.setImageResource(R.drawable.white_field);
        cell.setLayoutParams(params);
        addCell(cell);
        return cell;
    }

    int a1;

    private void addCell(Cell cell){
        if(cell==null){
            Log.e("addCell","cell==null");
            return;
        }
        for(int i=0;i<listCell.length;i++){
            for(int j=0;j<listCell[i].length;j++){
                if(listCell[i][j]==null){
                    Log.i("addCell",""+ a1);
                    a1++;
                    listCell[i][j]= cell;
                    return;
                }
            }
        }
    }

    public Cell[][] getListCell(){
        if(listCell!=null){
            return listCell;
        }
        return null;
    }

    public void update(ArrayList<Ship> listShips){
        ShipDraw shipDraw;
        for(Ship ship:listShips){
            shipDraw = new ShipDraw(listCell,ship);
            shipDraw.action();
        }
    }

}
