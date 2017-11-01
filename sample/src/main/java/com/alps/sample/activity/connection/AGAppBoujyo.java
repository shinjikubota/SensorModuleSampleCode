package com.alps.sample.activity.connection;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.alps.sample.R;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

/**
 * Created by shinji_kubota on 2017/10/12.
 */

public class AGAppBoujyo extends AppCompatActivity {


    String url = "http://131.113.80.160/GETn.php";
    ListView listView;


    //スピナーの定義
    private Spinner spinner;
    private String spinnerItems[] = {"50L", "100L", "150L", "200L", "250L", "300L", "350L", "400L", "450L", "500L", "550L", "600L"};
    String sp = "";




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.agappboujyo);


        //ListViewの作成
        listView = (ListView) findViewById(R.id.listView);
        final ArrayAdapter<String> array = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice){
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                TextView view = (TextView)super.getView(position, convertView, parent);
                view.setTextSize(40);
                view.setHeight(60) ;
//                view.setMinimumHeight(10) ;
//                view.setMaxHeight(100);

                return view;
            }
        };
        listView.setAdapter(array);


        AsyncHttpClient client = new AsyncHttpClient();
        RequestParams params = new RequestParams();


        client.get(url, params, new JsonHttpResponseHandler() {


            //JSONArray,int statusCode, Header headers[]がポイント！！
            @TargetApi(Build.VERSION_CODES.KITKAT)
            public void onSuccess(int statusCode, Header headers[], JSONArray json) {


                Log.i("JSoooooooooooooooooooooooooooooooooon", "onSuccess: JSONObject");
                Log.i("JSoooooooooooooooooooooooooooooooooon", json.toString());


                JSONArray jsarr = null;
                try {
                    jsarr = new JSONArray(json.toString());

                    for (int i = 0; i < jsarr.length(); i++) {

                        JSONObject jsonObject = jsarr.getJSONObject(i);
//                        Log.d("JSONSampleActivity", jsonObject.getString("A"));
                        Log.d("JSONSampleActivity", String.valueOf(jsarr.getJSONObject(i)));


                        array.add(jsarr.getJSONObject(i).getString("A"));


                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }


        });


        Log.d("arraaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaay", String.valueOf(array));


        //スピナー
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
                // 選択アイテムを取得
                SparseBooleanArray checked = listView.getCheckedItemPositions();

                // チェックされたアイテムの文字列を生成
                // checked には、「チェックされているアイテム」ではなく、
                // 「一度でもチェックされたアイテム」が入ってくる。
                // なので、現在チェックされているかどうかを valutAt の戻り値
                // で判定する必要がある！！！
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < checked.size(); i++) {
                    if (checked.valueAt(i)) {
//                        sb.append(array.getItem(i) + ",");

                        int key = checked.keyAt(i);//チェックされている配列のキーを取得
                        sb.append(array.getItem(key) + "," );//用意した配列から値を取得する

                    }
                }


                // 通知
                Toast.makeText(AGAppBoujyo.this, sb.toString(), Toast.LENGTH_SHORT).show();


                //saibaidataに値を入れる。
                saibaidata.syousai = sb.toString() + sp + "使った";


                //画面遷移
                Intent intent = new Intent(getApplication(), hojyo.class);
                startActivity(intent);


            }
        });


    }





}