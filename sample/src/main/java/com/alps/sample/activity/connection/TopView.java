package com.alps.sample.activity.connection;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.text.format.Time;
import android.view.View;
import android.widget.Toast;

import com.alps.sample.R;

import java.io.FileNotFoundException;

/**
 * Created by shinji_kubota on 2017/07/21.
 */

public class TopView extends AppCompatActivity {

    int tsuki = 0;
    int hi = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.topview);

        Time time = new Time("Asia/Tokyo");
        time.setToNow();
        tsuki = time.month+1;
        hi = time.monthDay;
    }


    public void ToSagyosha(View v) {

        Intent intent = new Intent(getApplication(), sagyosha.class);
        startActivity(intent);

    }


    public void dataview(View v) {

        Intent intent = new Intent(getApplication(), serverdata.class);
        startActivity(intent);

    }


    //アプリの終了
    public void tofin(View v) {


        Toast toast = Toast.makeText(this, "-----アプリを終了します。-----", Toast.LENGTH_SHORT);
        toast.show();


        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {



                //System.exit(0);
                moveTaskToBack(true);
                finish();
                //android.os.Process.killProcess(android.os.Process.myPid());
//                ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
//                activityManager.restartPackage(getPackageName());


            }
        }, 3000);



    }




    //プロフィール入力
    public void Toprof(View v) throws FileNotFoundException {

        Intent intent = new Intent(getApplication(), prof.class);
        startActivity(intent);


//データ送信の遺産

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
//        //変更後
//        for (int i = 0; i < list.size(); i++) {
//
//
//            arrayLine = list.get(i);
//
//
//            Log.d("arrayLisssssssssssssssssssssssst", String.valueOf(arrayLine[0]));
//            Log.d("arrayLisssssssssssssssssssssssst", String.valueOf(arrayLine[1]));
//            Log.d("arrayLisssssssssssssssssssssssst", String.valueOf(arrayLine[2]));
//            Log.d("arrayLisssssssssssssssssssssssst", String.valueOf(arrayLine[3]));
//            Log.d("arrayLisssssssssssssssssssssssst", String.valueOf(arrayLine[4]));
//
//
//            String sag = arrayLine[0];
//            String hoj = arrayLine[1];
//            String command = arrayLine[2];
//            String date = arrayLine[3];
//            String item = arrayLine[4];
//            String tem = arrayLine[5];
//            String hum = arrayLine[6];
//            String amb = arrayLine[7];
//            //String tok = arrayLine[8];
//
//
//            AsyncHttpClient client = new AsyncHttpClient();
//
//            RequestParams params = new RequestParams();
//            params.put("a", sag);
//            params.put("b", hoj);
//            params.put("c", command);
//            params.put("d", date);
//            params.put("e", item);
//            params.put("f", tem);
//            params.put("g", hum);
//            params.put("h", amb);
//            //params.put("i", tok);
//
//
//            String url = "http://131.113.80.160/POST4.php";
//
//            //自宅
////        String url = "http://192.168.2.101/POST2.php";
//
//            client.post(url, params, new AsyncHttpResponseHandler() {
//
//
//                @Override
//                public void onSuccess(int i, cz.msebera.android.httpclient.Header[] headers, byte[] bytes) {
//
////            Log.d(TAG, String.valueOf(tem));
//
//
//                    pop();
//
//
//                }
//
//                @Override
//                public void onFailure(int i, cz.msebera.android.httpclient.Header[] headers, byte[] bytes, Throwable throwable) {
//
//                    pop2();
//
//                }
//
//            });
//
//
//        }
//
//    }
//
//
//    //データ送信成功のポップアップ！
//    private void pop() {
//        Toast toast = Toast.makeText(this, "-----送信成功！-----", Toast.LENGTH_SHORT);
//        toast.show();
//    }
//
//
//    //データ送信失敗のポップアップ
//    private void pop2() {
//        Toast toast = Toast.makeText(this, "-----※送信失敗-----\n通信環境を確認してください", Toast.LENGTH_SHORT);
//        toast.show();
//
   }


}