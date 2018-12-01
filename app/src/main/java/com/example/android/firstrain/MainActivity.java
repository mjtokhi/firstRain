package com.example.android.firstrain;

import android.app.Activity;
import android.os.Bundle;
import com.example.android.firstrain.MyGIFView;

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

        setContentView(new MyGIFView(this));
    }

}

