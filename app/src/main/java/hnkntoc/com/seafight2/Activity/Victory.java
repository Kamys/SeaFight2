package hnkntoc.com.seafight2.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import hnkntoc.com.seafight2.R;

/**
 * Created by HNKNTOC on 29.11.2015.
 */
public class Victory extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.victory);

        TextView textView = (TextView) findViewById(R.id.victory);

        textView.setText("Победил "+getIntent().getStringExtra("victory"));

    }
}
