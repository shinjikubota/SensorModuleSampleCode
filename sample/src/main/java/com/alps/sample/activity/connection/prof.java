package com.alps.sample.activity.connection;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.alps.sample.R;

/**
 * Created by shinji_kubota on 2017/10/10.
 */

public class prof extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prof);
    }



    public void sag(View V){

        Intent intent = new Intent(getApplication(), profsag.class);
        startActivity(intent);
    }

    public void sak(View V){

        Intent intent = new Intent(getApplication(), profsak.class);
        startActivity(intent);
    }

    public void h(View V){

        Intent intent = new Intent(getApplication(), profh.class);
        startActivity(intent);
    }

    public void n(View V){

        Intent intent = new Intent(getApplication(), profn.class);
        startActivity(intent);
    }

    public void hi(View V){

        Intent intent = new Intent(getApplication(), profhi.class);
        startActivity(intent);
    }


    public void c(View V){

        Intent intent = new Intent(getApplication(), profc.class);
        startActivity(intent);
    }


    public void syux(View V){

        Intent intent = new Intent(getApplication(), profsyu.class);
        startActivity(intent);
    }

}
