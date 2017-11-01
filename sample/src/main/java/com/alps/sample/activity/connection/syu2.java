package com.alps.sample.activity.connection;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.text.format.Time;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
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

public class syu2 extends AppCompatActivity {



    String command = "収穫";
    String date = "";
    String item = "ナス";


    int tsuki = 0;
    int hi = 0;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tei1);

        Time time = new Time("Asia/Tokyo");
        time.setToNow();
        date = time.year + "年" + (time.month+1) + "月" + time.monthDay + "日　" + time.hour + "時" + time.minute + "分" + time.second + "秒";

        tsuki = time.month+1;
        hi = time.monthDay;


    }


    public void onReturn(View v) {
        Intent intent = new Intent(getApplication(), syuukaku.class);
        startActivity(intent);
    }




    //データ送信を押した時の処理
    public void onSoushin(View v) throws FileNotFoundException {


        EditText editText = (EditText)findViewById(R.id.editT);
        String tok = editText.getText().toString();






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


        arrayLine = list.get(2);




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
            bw.write(tok);


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


