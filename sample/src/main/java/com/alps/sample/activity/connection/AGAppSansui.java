package com.alps.sample.activity.connection;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.alps.sample.R;

/**
 * Created by shinji_kubota on 2017/10/21.
 */

public class AGAppSansui extends AppCompatActivity {



    //スピナーの定義
    private Spinner spinner;
    private String spinnerItems[] = {"10ml", "100ml", "1L","5L", "10L", "20L"};
    String sp = "";




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.agappsansui);


        //スピナーで内容の選択
        spinner = (Spinner) findViewById(R.id.ryo);

        // ArrayAdapter
        ArrayAdapter<String> adapter
                = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinnerItems){
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                TextView view = (TextView)super.getView(position, convertView, parent);
                view.setTextSize(25);
                view.setHeight(60) ;
//                view.setMinimumHeight(10) ;
//                view.setMaxHeight(100);

                return view;
            }
        };

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // spinner に adapter をセット
        spinner.setAdapter(adapter);

        // リスナーを登録
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            //　アイテムが選択された時
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner spinner = (Spinner) parent;
                sp = (String) spinner.getSelectedItem();

            }

            //　アイテムが選択されなかった
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        Button btn = (Button) findViewById(R.id.tsugi);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //saibaidataに値を入れる。
                saibaidata.syousai = sp;


                //画面遷移
                Intent intent = new Intent(getApplication(), hojyo.class);
                startActivity(intent);


            }
        });


    }

}