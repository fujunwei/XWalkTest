package org.xwalk.test;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class ListViewActivity extends Activity {
    private static final String TAG = "XWalkTest";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
        setContentView(linearLayout);

        String[] data = new String[30];
        for (int i = 0; i < data.length; i++) {
            data[i] = "ListItem " + i;
        }

        BounceListView bounceListView = new BounceListView(this);
        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, data);
        bounceListView.setAdapter(arrayAdapter);
        linearLayout.addView(bounceListView);
    }
}
