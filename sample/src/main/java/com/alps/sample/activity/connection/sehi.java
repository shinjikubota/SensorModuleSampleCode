package com.alps.sample.activity.connection;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.alps.sample.R;

/**
 * Created by shinji_kubota on 2017/07/02.
 */




public class sehi extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sehi);

    }

    public void onButton1(View v) {


        Intent intent = new Intent(getApplication(),seh1.class);
        startActivity(intent);




    }







    public void onReturn(View v) {
        Intent intent = new Intent(getApplication(),AGApp.class);
        startActivity(intent);
    }



    public void onButton2(View v) {


        Intent intent = new Intent(getApplication(),seh2.class);
        startActivity(intent);

    }


    public void onButton3(View v) {


        Intent intent = new Intent(getApplication(),seh3.class);
        startActivity(intent);

    }

    public void onButton4(View v) {


        Intent intent = new Intent(getApplication(),seh4.class);
        startActivity(intent);

    }




}


















//
//public class sehi extends AppCompatActivity {
//
//
//    String command = "施肥";
//    String date ="";
//    String item ="";
//
//    //スピナーの定義
//    private Spinner spinner;
//    private String spinnerItems[] = {"肥料A", "肥料B", "肥料C", "肥料D"};
//
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_sehi);
//
//
//
//        //時間の取得と表示
//        TextView dateText = (TextView)findViewById(R.id.date_id);
//        Time time = new Time("Asia/Tokyo");
//        time.setToNow();
//        date = time.year + "年" + (time.month+1) + "月" + time.monthDay + "日　" + time.hour + "時" + time.minute + "分" + time.second + "秒";
//        dateText.setText(date);
//
//
//        //スピナーで内容の選択
//        spinner = (Spinner)findViewById(R.id.spinner);
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
//
//
//    public void onReturn(View v) {
//        Intent intent = new Intent(getApplication(),AGApp.class);
//        startActivity(intent);
//    }
//
//
//    //データ送信を押した時の処理
//    public void onButton(View v) {
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
//
//        //エミュレータのurl(localhost)
////        String url = "http://10.0.2.2/POST3.php";
//        //研究室
//        String url = "http://131.113.80.160/POST3.php";
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
//            }
//
//            @Override
//            public void onFailure(int i, cz.msebera.android.httpclient.Header[] headers, byte[] bytes, Throwable throwable) {
//
//            }
//        });
//    }
//
//
//}