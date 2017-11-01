package com.alps.sample.activity.connection;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.alps.sample.R;


/**
 * Created by shinji_kubota on 2017/07/02.
 */



public class teisyoku extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teisyoku);

    }

    public void onButton1(View v) {


        Intent intent = new Intent(getApplication(),tei1.class);
        startActivity(intent);




    }







    public void onReturn(View v) {
        Intent intent = new Intent(getApplication(),AGApp.class);
        startActivity(intent);
    }



    public void onButton2(View v) {


        Intent intent = new Intent(getApplication(),tei2.class);
        startActivity(intent);

    }


    public void onButton3(View v) {


        Intent intent = new Intent(getApplication(),tei3.class);
        startActivity(intent);

    }

    public void onButton4(View v) {


        Intent intent = new Intent(getApplication(),tei4.class);
        startActivity(intent);

    }




}















//    private static final String TAG = "teisyoku";
//
////    LatestData dc = new LatestData();
//
//
//    //SensorModule dc = new SensorModule();
//
//
//    String command = "定植";
//    String date = "";
//    String item = "";
//
////    float tem = dc.temperature;
////    float hum = dc.humidity;
////    float amb = dc.ambientLight;
//
//
//    //スピナーの定義
//    private Spinner spinner;
//    private String spinnerItems[] = {"作物A", "作物B", "作物C", "作物D"};
//
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_teisyoku);
//
//
//
//        //時間の取得と表示
//        TextView dateText = (TextView) findViewById(R.id.date_id);
//        Time time = new Time("Asia/Tokyo");
//        time.setToNow();
//        date = time.year + "年" + (time.month + 1) + "月" + time.monthDay + "日　" + time.hour + "時" + time.minute + "分" + time.second + "秒";
//        dateText.setText(date);
//
//
//
//
////        //テスト
////        TextView textView = (TextView) findViewById(R.id.date_id);
////        // テキストを設定
////        textView.setText(tem + "," + hum + "," + amb);
////
////
////
//
//
//
//        //スピナーで内容の選択
//        spinner = (Spinner) findViewById(R.id.spinner);
//
//        // ArrayAdapter
//        ArrayAdapter<String> adapter
//                = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinnerItems);
//
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//
//        // spinner に adapter をセット
//        spinner.setAdapter(adapter);
//
//        // リスナーを登録
//        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
//            //　アイテムが選択された時
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                Spinner spinner = (Spinner) parent;
//                item = (String) spinner.getSelectedItem();
//
//            }
//
//            //　アイテムが選択されなかった
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
//
//    }
//
//
//    public void onReturn(View v) {
//        Intent intent = new Intent(getApplication(), AGApp.class);
//        startActivity(intent);
//    }
//
//
//    //データ送信を押した時の処理
//    public void onButton(View v) throws FileNotFoundException {
//
//
//        String FileName = "/storage/emulated/0/A/data.csv";
//
//        //ファイルを読み込む
//        //Androidにおけるファイル操作で特徴的なのは、プログラムがファイルを保存できる場所が "/data/data/パッケージ名/files/" という場所に限られるということです。
////            FileReader fr = new FileReader("/storage/emulated/0/Download/data.csv");
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
//        arrayLine = list.get(1);
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
//
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
//
//        //エミュレータのurl(localhost)
////        String url = "http://10.0.2.2/POST3.php";
//        //研究室
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
//    }

