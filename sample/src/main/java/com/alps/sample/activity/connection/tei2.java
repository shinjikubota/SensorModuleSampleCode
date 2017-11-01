package com.alps.sample.activity.connection;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.text.format.Time;
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
 * Created by shinji_kubota on 2017/07/12.
 */

public class tei2 extends AppCompatActivity {



    String command = "定植";
    String date = "";
    String item = "ナス";


    int tsuki = 0;
    int hi = 0;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tei2);

        Time time = new Time("Asia/Tokyo");
        time.setToNow();
        date = time.year + "年" + (time.month+1) + "月" + time.monthDay + "日　" + time.hour + "時" + time.minute + "分" + time.second + "秒";

        tsuki = time.month+1;
        hi = time.monthDay;


    }


    public void onReturn(View v) {
        Intent intent = new Intent(getApplication(), teisyoku.class);
        startActivity(intent);
    }




    //データ送信を押した時の処理
    public void onSoushin(View v) throws FileNotFoundException {


        EditText editText = (EditText)findViewById(R.id.editT);
        String tok = editText.getText().toString();






        String FileName = "/storage/emulated/0/A/" + tsuki + hi + "sdata.csv";

        //ファイルを読み込む
        //Androidにおけるファイル操作で特徴的なのは、プログラムがファイルを保存できる場所が "/data/data/パッケージ名/files/" という場所に限られるということです。
//            FileReader fr = new FileReader("/storage/emulated/0/Download/data.csv");

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










        //エミュレータのurl(localhost)
//        String url = "http://10.0.2.2/POST3.php";
        //研究室



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
//            }
//
//            @Override
//            public void onFailure(int i, cz.msebera.android.httpclient.Header[] headers, byte[] bytes, Throwable throwable) {
//
//            }
//        });
//






        //csv書き出し準備
        String pathLog;
        File file;
        pathLog = Environment.getExternalStorageDirectory().toString() + "/B";
        file = new File(pathLog);
        file.mkdir();

        //pathLog = Environment.getExternalStorageDirectory().toString() + "/" + context.getString(R.string.app_name) + "/" + name.replaceAll(":", "-") + ".csv";
        pathLog = Environment.getExternalStorageDirectory().toString() + "/B" + "/" + tsuki + hi +"data.csv";
        //file = new File(pathLog);




        //csvの書き出し
        try {
            //出力先を作成する
//            FileWriter fw = new FileWriter(pathLog, false);  //※１：2番目の引数をtrueにすると追記モード、falseにすると上書きモードになります。
//            OutputStreamWriter fw2 = new OutputStreamWriter(fw, "utf-8");
//            PrintWriter pw = new PrintWriter(new BufferedWriter(fw2));


            //文字化け治らない！！
            // PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(pathLog, true),"utf-8")));

//            File file_w3 = new File(pathLog);
//            //BufferedReader b_reader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));
//            PrintWriter pw  = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file_w3),"UTF-8")));



//            FileOutputStream fos = new FileOutputStream(pathLog);
//
//            BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( fos, "UTF8" ));
//
//            PrintWriter pw = new PrintWriter(bw);



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


            Toast toast = Toast.makeText(this, "-----書き出し完了！-----", Toast.LENGTH_SHORT);
            toast.show();


//            //内容を指定する
//            pw.print("作業内容");
//            pw.print(",");
//            pw.print("日付");
//            pw.print(",");
//            pw.print("種類");
//            pw.print(",");
//            pw.print("温度");
//            pw.print(",");
//            pw.print("湿度");
//            pw.print(",");
//            pw.print("照度");
//            pw.print(",");
//            pw.print("特記事項");
//
//            pw.println();
//
//            pw.print(command);
//            pw.print(",");
//            pw.print(date);
//            pw.print(",");
//            pw.print(item);
//            pw.print(",");
//            pw.print(tem);
//            pw.print(",");
//            pw.print(hum);
//            pw.print(",");
//            pw.print(amb);
//            pw.print(",");
//            pw.print(tok);
//            pw.println();
//
//            //ファイルに書き出す
//            pw.close();
//

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
