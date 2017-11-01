package com.alps.sample.activity.connection;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.format.Time;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.alps.sample.R;
import com.alps.sample.activity.splash.ActivitySplash;

/**
 * Created by shinji_kubota on 2017/10/14.
 */

public class AGAppKakunin extends AppCompatActivity {


    ListView listView;

    String date = "";

    int tsuki = 0;
    int hi = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.agappkakunin);

        Time time = new Time("Asia/Tokyo");
        time.setToNow();
        date = time.year + "年" + (time.month+1) + "月" + time.monthDay + "日　" + time.hour + "時" + time.minute + "分" + time.second + "秒";

        tsuki = time.month+1;
        hi = time.monthDay;


        saibaidata.date = date;

        //ListViewの作成
        listView = (ListView) findViewById(R.id.listView);
        final ArrayAdapter<String> array = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1){
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                TextView view = (TextView)super.getView(position, convertView, parent);
                view.setTextSize(30);
                view.setHeight(60) ;
//                view.setMinimumHeight(10) ;
//                view.setMaxHeight(100);

                return view;
            }
        };
        listView.setAdapter(array);

        array.add("日付:" + saibaidata.date);
        array.add("作業者:" + saibaidata.sagyousya);
        array.add("作物:" + saibaidata.sakumotsu);
        array.add("作業:" + saibaidata.sagyou);
        array.add("詳細:" + saibaidata.syousai);
        array.add("圃場:" + saibaidata.hojyo);



        Button btn = (Button) findViewById(R.id.tsugi);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //画面遷移
                Intent intent = new Intent(getApplication(), ActivitySplash.class);
                startActivity(intent);


            }
        });


    }



}
