package com.alps.sample.activity.connection;


import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.text.format.Time;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.alps.sample.R;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by shinji_kubota on 2017/07/14.
 */

public class bou1 extends AppCompatActivity {



    String command = "防除";
    String date = "";
    String item = "農薬";
    String sp = "";

    int tsuki = 0;
    int hi = 0;

    //スピナーの定義
    private Spinner spinner;
    private String spinnerItems[] = {"100g", "200g", "300g", "1kg"};



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bou1);

        Time time = new Time("Asia/Tokyo");
        time.setToNow();
        date = time.year + "年" + (time.month+1) + "月" + time.monthDay + "日　" + time.hour + "時" + time.minute + "分" + time.second + "秒";

        tsuki = time.month+1;
        hi = time.monthDay;


        //スピナーで内容の選択
        spinner = (Spinner)findViewById(R.id.spinner);

        // ArrayAdapter
        ArrayAdapter<String> adapter
                = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinnerItems);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // spinner に adapter をセット
        spinner.setAdapter(adapter);

        // リスナーを登録
        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            //　アイテムが選択された時
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner spinner = (Spinner) parent;
                sp = (String) spinner.getSelectedItem();

            }

            //　アイテムが選択されなかった
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }


    public void onReturn(View v) {
        Intent intent = new Intent(getApplication(), sehi.class);
        startActivity(intent);
    }




    //データ送信を押した時の処理
    public void onSoushinsehi1(View v) throws FileNotFoundException {




        String FileName = "/storage/emulated/0/A/" + tsuki + hi + "sdata.csv";

        FileReader fr = new FileReader(FileName);
        BufferedReader br = new BufferedReader(fr);

        List<String[]> list = new ArrayList<String[]>();
        String line;
        String[] arrayLine;

        try {
            while ((line = br.readLine()) != null) {
                arrayLine = line.split(",");
                list.add(arrayLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        arrayLine = list.get(1);




        String tem = arrayLine[12];
        String hum = arrayLine[11];
        String amb = arrayLine[10];



        //csv書き出し準備
        String pathLog;
        File file;
        pathLog = Environment.getExternalStorageDirectory().toString() + "/B";
        file = new File(pathLog);
        file.mkdir();



        pathLog = Environment.getExternalStorageDirectory().toString() + "/B" + "/" + tsuki + hi +"data.csv";



        //csvの書き出し
        try {

            FileOutputStream fos = new FileOutputStream(pathLog,true);
            OutputStreamWriter osw = new OutputStreamWriter(fos, "SJIS");
            BufferedWriter bw = new BufferedWriter(osw);


            //内容を指定する
//            bw.write("作業内容,日付,種類,温度,湿度,照度,特記事項");
//
//            bw.newLine();


            //加えた
            bw.write(saibaidata.sagyousya);
            bw.write(",");
            bw.write(saibaidata.hojyo);
            bw.write(",");
            //前からあった
            bw.write(command);
            bw.write(",");
            bw.write(date);
            bw.write(",");
            bw.write(item);
            bw.write(",");
            bw.write(tem);
            bw.write(",");
            bw.write(hum);
            bw.write(",");
            bw.write(amb);
            bw.write(",");

            //変えた
            bw.write(sp);


            bw.newLine();



            bw.close();



            Log.d("BufferReadeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeer", String.valueOf(bw));
            Toast toast = Toast.makeText(this, "-----書き出し完了！-----", Toast.LENGTH_SHORT);
            toast.show();


        } catch (IOException ex) {
            //例外時処理
            ex.printStackTrace();
        }






    }















    //さらに作用入力を押した時の処理
    public void onHokasagyou(View v) throws FileNotFoundException {


        Intent intent = new Intent(getApplication(),TopView.class);
        startActivity(intent);




    }


}









//public class bou1 extends AppCompatActivity {
//
//
//
//    String command = "防除";
//    String date = "";
//    String item = "農薬";
//
//
//    int tsuki = 0;
//    int hi = 0;
//
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.tei1);
//
//        Time time = new Time("Asia/Tokyo");
//        time.setToNow();
//        date = time.year + "年" + (time.month+1) + "月" + time.monthDay + "日　" + time.hour + "時" + time.minute + "分" + time.second + "秒";
//
//        tsuki = time.month+1;
//        hi = time.monthDay;
//
//
//    }
//
//
//    public void onReturn(View v) {
//        Intent intent = new Intent(getApplication(), boujyo.class);
//        startActivity(intent);
//    }
//
//
//
//
//    //データ送信を押した時の処理
//    public void onSoushin(View v) throws FileNotFoundException {
//
//
//        EditText editText = (EditText)findViewById(R.id.editT);
//        String tok = editText.getText().toString();
//
//
//
//
//
//
//        String FileName = "/storage/emulated/0/A/" + tsuki + hi + "sdata.csv";
//
//        FileReader fr = new FileReader(FileName);
//        BufferedReader br = new BufferedReader(fr);
//
//        List<String[]> list = new ArrayList<String[]>();
//        String line;
//        String[] arrayLine;
//
//        try {
//            while ((line = br.readLine()) != null) {
//                arrayLine = line.split(",");
//                list.add(arrayLine);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//        arrayLine = list.get(2);
//
//
//
//
//        String tem = arrayLine[12];
//        String hum = arrayLine[11];
//        String amb = arrayLine[10];
//
//
//
//        //csv書き出し準備
//        String pathLog;
//        File file;
//        pathLog = Environment.getExternalStorageDirectory().toString() + "/B";
//        file = new File(pathLog);
//        file.mkdir();
//
//
//
//        pathLog = Environment.getExternalStorageDirectory().toString() + "/B" + "/" + tsuki + hi +"data.csv";
//
//
//
//        //csvの書き出し
//        try {
//
//            FileOutputStream fos = new FileOutputStream(pathLog,true);
//            OutputStreamWriter osw = new OutputStreamWriter(fos, "SJIS");
//            BufferedWriter bw = new BufferedWriter(osw);
//
//
//            //内容を指定する
////            bw.write("作業内容,日付,種類,温度,湿度,照度,特記事項");
////
////            bw.newLine();
//
//            bw.write(command);
//            bw.write(",");
//            bw.write(date);
//            bw.write(",");
//            bw.write(item);
//            bw.write(",");
//            bw.write(tem);
//            bw.write(",");
//            bw.write(hum);
//            bw.write(",");
//            bw.write(amb);
//            bw.write(",");
//            bw.write(tok);
//
//
//            bw.newLine();
//
//
//
//            bw.close();
//
//
//
//            Log.d("BufferReadeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeer", String.valueOf(bw));
//            Toast toast = Toast.makeText(this, "-----書き出し完了！-----", Toast.LENGTH_SHORT);
//            toast.show();
//
//
//        } catch (IOException ex) {
//            //例外時処理
//            ex.printStackTrace();
//        }
//
//
//
//
//
//
//    }
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//    //さらに作用入力を押した時の処理
//    public void onHokasagyou(View v) throws FileNotFoundException {
//
//
//        Intent intent = new Intent(getApplication(),AGApp.class);
//        startActivity(intent);
//
//
//
//
//    }
//
//
//}
//
//
