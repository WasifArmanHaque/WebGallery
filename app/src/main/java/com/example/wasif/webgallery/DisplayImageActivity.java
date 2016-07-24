package com.example.wasif.webgallery;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Matrix;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import uk.co.senab.photoview.PhotoViewAttacher;

public class DisplayImageActivity extends Activity {


    ImageView fullImg;

    PhotoViewAttacher mAttacher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_display_image);


        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        String url = extras.getString("url");
        fullImg = (ImageView) findViewById(R.id.full_image);

        Callback imageLoaded = new Callback()
        {
            @Override
            public void onSuccess()
            {
                if(mAttacher!=null)
                {
                    mAttacher.update();
                }
                else
                {
                    mAttacher = new PhotoViewAttacher(fullImg);
                }
            }

            @Override
            public void onError() {

            }
        };


        Picasso.with(getApplicationContext()).load(url).into(fullImg, imageLoaded);

        mAttacher = new PhotoViewAttacher(fullImg);
        //SGD = new ScaleGestureDetector(this, new ScaleListener());
    }

}
