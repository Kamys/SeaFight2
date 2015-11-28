package hnkntoc.com.seafight2.Activity.fragment;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import hnkntoc.com.seafight2.R;

/**
 * Test
 */
public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private Integer mCols, mRows;

    public ImageAdapter(Context context, int cols, int rows) {
        mContext = context;
        mCols = cols;
        mRows = rows;
    }

    @Override
    public int getCount() {
        return mCols * mRows;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ImageView view; // для вывода картинки

        if (convertView == null)
            view = new ImageView(mContext);
        else
            view = (ImageView) convertView;

        view.setImageResource(R.drawable.white_field);

        return view;
    }
}

