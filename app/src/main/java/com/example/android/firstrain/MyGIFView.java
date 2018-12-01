package com.example.android.firstrain;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Movie;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

import java.io.InputStream;

class MyGIFView extends View {

    Movie movie,movie1;
    InputStream is=null,is1=null;
    long moviestart;
    @SuppressLint("ResourceType")
    public MyGIFView(Context context) {
        super(context);


        // Provide your own gif animation file

        is=context.getResources().openRawResource(R.drawable.nakey1);
        movie=Movie.decodeStream(is);

    }

    @Override
    protected void onDraw(Canvas canvas) {

        canvas.drawColor(Color.WHITE);
        super.onDraw(canvas);
        WindowManager wMan = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        Display display = wMan.getDefaultDisplay();
        float screenW = display.getWidth();
        float screenH = display.getHeight();
        canvas.scale(screenW/movie.width(),screenH/movie.height());
        long now=android.os.SystemClock.uptimeMillis();
        System.out.println("now="+now);
        if (moviestart == 0) { // first time
            moviestart = now;
        }
        System.out.println("\tmoviestart="+moviestart);
        int relTime = (int)((now - moviestart) % movie.duration()) ;
        System.out.println("time="+relTime+"\treltime="+movie.duration());
        movie.setTime(relTime);
        //movie.draw(canvas,this.getWidth()/,this.getHeight()/2-40);
        movie.draw(canvas, 0, 0);
        this.invalidate();
    }
}
