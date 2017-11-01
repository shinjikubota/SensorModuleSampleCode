package com.alps.sample.activity.connection;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.text.format.Time;
import android.util.Log;
import android.widget.Toast;

import com.alps.sample.R;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

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
 * Created by shinji_kubota on 2017/10/06.
 */

public class soushin extends AppCompatActivity {



    String date = "";

    int tsuki = 0;
    int hi = 0;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.soushin);

        Time time = new Time("Asia/Tokyo");
        time.setToNow();
        date = time.year + "年" + (time.month+1) + "月" + time.monthDay + "日　" + time.hour + "時" + time.minute + "分" + time.second + "秒";

        tsuki = time.month+1;
        hi = time.monthDay;







        String FileName = "/storage/emulated/0/A/" + tsuki + hi + "sdata.csv";



        FileReader fr = null;
        try {
            fr = new FileReader(FileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }



        BufferedReader br = new BufferedReader(fr);

        List<String[]> list = new ArrayList<String[]>();
        String line;
        String[] arrayLine;
        int i = 0;

        try {
            while ((line = br.readLine()) != null) {
                arrayLine = line.split(",");
                list.add(arrayLine);
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        arrayLine = list.get(i-1);




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



            //加えた
            bw.write(date);
            bw.write(",");
            bw.write(saibaidata.sagyousya);
            bw.write(",");
            bw.write(saibaidata.sakumotsu);
            bw.write(",");
            bw.write(saibaidata.sagyou);
            bw.write(",");
            bw.write(saibaidata.syousai);
            bw.write(",");
            bw.write(saibaidata.hojyo);
            bw.write(",");
            bw.write(tem);
            bw.write(",");
            bw.write(hum);
            bw.write(",");
            bw.write(amb);


            bw.newLine();



            bw.close();



            Log.d("BufferReadeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeer", String.valueOf(bw));
            Toast toast = Toast.makeText(this, "-----書き出し完了！-----", Toast.LENGTH_SHORT);
            toast.show();





        } catch (IOException ex) {
            //例外時処理
            ex.printStackTrace();
        }





        //データ送信
        AsyncHttpClient client = new AsyncHttpClient();

            RequestParams params = new RequestParams();
            params.put("a", saibaidata.date);
            params.put("b", saibaidata.sagyousya);
            params.put("c", saibaidata.sakumotsu);
            params.put("d", saibaidata.sagyou);
            params.put("e", saibaidata.syousai);
            params.put("f", saibaidata.hojyo);
            params.put("g", tem);
            params.put("h", hum);
            params.put("i", amb);


            String url = "http://131.113.80.160/POST4.php";

            //自宅
//        String url = "http://192.168.2.101/POST2.php";

            client.post(url, params, new AsyncHttpResponseHandler() {


                @Override
                public void onSuccess(int i, cz.msebera.android.httpclient.Header[] headers, byte[] bytes) {

//            Log.d(TAG, String.valueOf(tem));


                    pop();


                }

                @Override
                public void onFailure(int i, cz.msebera.android.httpclient.Header[] headers, byte[] bytes, Throwable throwable) {

                    pop2();

                }

            });















        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(getApplication(), TopView.class);
                startActivity(intent);


            }
        }, 5000);

    }




    //データ送信成功のポップアップ！
    private void pop() {
        Toast toast = Toast.makeText(this, "-----送信成功！-----", Toast.LENGTH_SHORT);
        toast.show();
    }


    //データ送信失敗のポップアップ
    private void pop2() {
        Toast toast = Toast.makeText(this, "-----※送信失敗-----\n通信環境を確認してください", Toast.LENGTH_SHORT);
        toast.show();

    }

}
