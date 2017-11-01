package com.alps.sample.activity.connection;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.format.Time;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.alps.sample.R;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by shinji_kubota on 2017/07/02.
 */

public class AGApp extends AppCompatActivity {



    int tsuki = 0;
    int hi = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.agapp);



        Time time = new Time("Asia/Tokyo");
        time.setToNow();

        tsuki = time.month+1;
        hi = time.monthDay;

    }


    public void hash(View v) {


        Intent intent = new Intent(getApplication(),AGAppHashu.class);
        startActivity(intent);

        saibaidata.sagyou = "播種";
    }






    public void onButton1(View v) {


        Intent intent = new Intent(getApplication(),AGAppTeisyoku.class);
        startActivity(intent);

        saibaidata.sagyou = "定植";
    }


    public void onButton2(View v) {


        Intent intent = new Intent(getApplication(),AGAppBoujyo.class);
        startActivity(intent);

        saibaidata.sagyou = "防除";

    }


    public void onButton3(View v) {


        Intent intent = new Intent(getApplication(),AGAppSehi.class);
        startActivity(intent);

        saibaidata.sagyou = "施肥";

    }

    public void onButton4(View v) {


        Intent intent = new Intent(getApplication(),AGAppSyuukaku.class);
        startActivity(intent);

        saibaidata.sagyou = "収穫";

    }



    public void syux(View v) {


        Intent intent = new Intent(getApplication(),AGAppSyuxtuka.class);
        startActivity(intent);

        saibaidata.sagyou = "出荷";
    }


    public void san(View v) {


        Intent intent = new Intent(getApplication(),AGAppSansui.class);
        startActivity(intent);

        saibaidata.sagyou = "散水";
    }


    public void onReturn(View v) {
        Intent intent = new Intent(getApplication(),sakumotsu.class);
        startActivity(intent);
    }


//    public void onButton5(View v) {
//
//
//        Intent intent = new Intent(getApplication(),serverdata.class);
//        startActivity(intent);
//
//    }
//




//    public void onData(View v)throws FileNotFoundException {
//
//
//        String FileName = "/storage/emulated/0/B/" + tsuki + hi + "data.csv";
//
//
//        Log.d("fileeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee", FileName);
//
//        //ファイルを読み込む
//        //Androidにおけるファイル操作で特徴的なのは、プログラムがファイルを保存できる場所が "/data/data/パッケージ名/files/" という場所に限られるということです。
////            FileReader fr = new FileReader("/storage/emulated/0/Download/data.csv");
//
////        FileReader fr  = new FileReader(FileName);
////
////        InputStreamReader in = new InputStreamReader(fr,"SJIS");
////
////        BufferedReader br = new BufferedReader(in);
//
//
//        //csvファイルの文字コードが"SJIS"の場合
//        BufferedReader br = null;
//        try {
//
//            br = new BufferedReader(new InputStreamReader(new FileInputStream(FileName), "SJIS"));
//
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//
//
//        //listに格納！
//        List<String[]> list = new ArrayList<String[]>();
//        String line;
//        String[] arrayLine;
//
//
//        try {
//            while ((line = br.readLine()) != null) {
//
//                //Log.d("readLinnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnne",br.readLine());
//
//                arrayLine = line.split(",");
//                list.add(arrayLine);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
////
////
////        arrayLine = list.get(0);
////
//
////
////        Log.d("arrayLisssssssssssssssssssssssst", String.valueOf(arrayLine[0]));
////
////
////        arrayLine = list.get(1);
////
////
////        Log.d("arrayLisssssssssssssssssssssssst", String.valueOf(arrayLine[0]));
////
////
////
////        String command = arrayLine[0];
////        String date = arrayLine[1];
////        String item = arrayLine[2];
////        String tem = arrayLine[3];
////        String hum = arrayLine[4];
////        String amb = arrayLine[5];
////        String tok = arrayLine[6];
//
//
//        AsyncHttpClient client = new AsyncHttpClient();
//
//        RequestParams params = new RequestParams();
//
//
//        params.put("L",list);
//
//
//
//
////        params.put("a", command);
////        params.put("b", date);
////        params.put("c", item);
////        params.put("d", tem);
////        params.put("e", hum);
////        params.put("f", amb);
////        params.put("g", tok);
//
//
//        String url = "http://131.113.80.160/POSTL.php";
//
//        //自宅
////        String url = "http://192.168.2.101/POST2.php";
//
//        client.post(url, params, new AsyncHttpResponseHandler() {
//
//
//            @Override
//            public void onSuccess(int i, cz.msebera.android.httpclient.Header[] headers, byte[] bytes) {
//
////            Log.d(TAG, String.valueOf(tem));
//
//
//                pop();
//
//
//            }
//
//            @Override
//            public void onFailure(int i, cz.msebera.android.httpclient.Header[] headers, byte[] bytes, Throwable throwable) {
//
//            }
//        });
//
//
//    }


    //永久保存版データ送信メソッド
    public void onData(View v)throws FileNotFoundException {


        String FileName = "/storage/emulated/0/B/" + tsuki + hi + "data.csv";


        Log.d("fileeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee", FileName);

        //ファイルを読み込む
        //Androidにおけるファイル操作で特徴的なのは、プログラムがファイルを保存できる場所が "/data/data/パッケージ名/files/" という場所に限られるということです。
//            FileReader fr = new FileReader("/storage/emulated/0/Download/data.csv");

//        FileReader fr  = new FileReader(FileName);
//
//        InputStreamReader in = new InputStreamReader(fr,"SJIS");
//
//        BufferedReader br = new BufferedReader(in);


        //csvファイルの文字コードが"SJIS"の場合
        BufferedReader br = null;
        try {

            br = new BufferedReader(new InputStreamReader(new FileInputStream(FileName), "SJIS"));

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        //listに格納！
        List<String[]> list = new ArrayList<String[]>();
        String line;
        String[] arrayLine;



        try {
            while ((line = br.readLine()) != null) {

                //Log.d("readLinnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnne",br.readLine());

                arrayLine = line.split(",");
                list.add(arrayLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }





        //変更後
        for (int i = 0; i < list.size(); i++){


            arrayLine = list.get(i);


            Log.d("arrayLisssssssssssssssssssssssst", String.valueOf(arrayLine[0]));
            Log.d("arrayLisssssssssssssssssssssssst", String.valueOf(arrayLine[1]));
            Log.d("arrayLisssssssssssssssssssssssst", String.valueOf(arrayLine[2]));
            Log.d("arrayLisssssssssssssssssssssssst", String.valueOf(arrayLine[3]));
            Log.d("arrayLisssssssssssssssssssssssst", String.valueOf(arrayLine[4]));


            String command = arrayLine[0];
            String date = arrayLine[1];
            String item = arrayLine[2];
            String tem = arrayLine[3];
            String hum = arrayLine[4];
            String amb = arrayLine[5];
            String tok = arrayLine[6];


            AsyncHttpClient client = new AsyncHttpClient();

            RequestParams params = new RequestParams();
            params.put("a", command);
            params.put("b", date);
            params.put("c", item);
            params.put("d", tem);
            params.put("e", hum);
            params.put("f", amb);
            params.put("g", tok);


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

                }
            });






        }




















//変更前
//        arrayLine = list.get(0);
//
//
//        Log.d("arrayLisssssssssssssssssssssssst", String.valueOf(arrayLine[0]));
//        Log.d("arrayLisssssssssssssssssssssssst", String.valueOf(arrayLine[1]));
//        Log.d("arrayLisssssssssssssssssssssssst", String.valueOf(arrayLine[2]));
//        Log.d("arrayLisssssssssssssssssssssssst", String.valueOf(arrayLine[3]));
//        Log.d("arrayLisssssssssssssssssssssssst", String.valueOf(arrayLine[4]));
//
//
//        String command = arrayLine[0];
//        String date = arrayLine[1];
//        String item = arrayLine[2];
//        String tem = arrayLine[3];
//        String hum = arrayLine[4];
//        String amb = arrayLine[5];
//        String tok = arrayLine[6];
//
//
//        AsyncHttpClient client = new AsyncHttpClient();
//
//        RequestParams params = new RequestParams();
//        params.put("a", command);
//        params.put("b", date);
//        params.put("c", item);
//        params.put("d", tem);
//        params.put("e", hum);
//        params.put("f", amb);
//        params.put("g", tok);
//
//
//        String url = "http://131.113.80.160/POST4.php";
//
//        //自宅
////        String url = "http://192.168.2.101/POST2.php";
//
//        client.post(url, params, new AsyncHttpResponseHandler() {
//
//
//            @Override
//            public void onSuccess(int i, cz.msebera.android.httpclient.Header[] headers, byte[] bytes) {
//
////            Log.d(TAG, String.valueOf(tem));
//
//
//                pop();
//
//
//            }
//
//            @Override
//            public void onFailure(int i, cz.msebera.android.httpclient.Header[] headers, byte[] bytes, Throwable throwable) {
//
//            }
//        });


    }








    private void pop(){


        Toast toast = Toast.makeText(this, "-----送信完了！-----", Toast.LENGTH_SHORT);
        toast.show();



    }







}







