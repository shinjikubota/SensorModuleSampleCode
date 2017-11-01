package com.alps.sample.activity.connection;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceActivity.Header;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
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

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by shinji_kubota on 2017/10/12.
 */

public class AGAppSyuxtuka extends AppCompatActivity {




    String url = "http://131.113.80.160/GETsyu.php";


    //出荷先
    private Spinner pod1;
    String pod1val;
    ArrayList<String> podItems = new ArrayList<String>(Arrays.asList("高松青果","日吉青果","松川研究室"));





    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.agappsyuxtuka);


        //農作物の表示
        TextView textView = (TextView) findViewById(R.id.tv);
        textView.setText(saibaidata.sakumotsu);


        //ポッド１
        pod1 = (Spinner)findViewById(R.id.pod1);
        final ArrayAdapter<String> adapter11 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,podItems){
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
        adapter11.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


//        adapter11.add("高松青果");
//        adapter11.add("日吉青果");
//        adapter11.add("松川研究室");
//


        //通信する場合


        //http通信
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


                        adapter11.add(jsarr.getJSONObject(i).getString("A"));


                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }


        });




        pod1.setAdapter(adapter11);
        pod1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner spinner = (Spinner) parent;
                pod1val = (String) spinner.getSelectedItem();
            }
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




    }


    public void tsugi(View V){


        //テキストの取得
        EditText editText = (EditText)findViewById(R.id.editT);
        String ryo = editText.getText().toString();




        saibaidata.syousai = pod1val + ":" + ryo + "個";


        Intent intent = new Intent(getApplication(),hojyo.class);
        startActivity(intent);

        // 通知
        Toast.makeText(AGAppSyuxtuka.this, saibaidata.syousai, Toast.LENGTH_SHORT).show();


    }

}