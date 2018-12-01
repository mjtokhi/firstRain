package com.example.android.firstrain;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;

public class MainActivity extends Activity {

    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

public class AA extends Activity {
*/
    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        LinearLayout ll = (LinearLayout) findViewById(R.id.gifView);
        MyGIFView myGif = new MyGIFView(this);
        ll.addView(myGif);


    }

}

