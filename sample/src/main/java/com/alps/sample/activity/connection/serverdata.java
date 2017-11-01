package com.alps.sample.activity.connection;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.alps.sample.R;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;


/**
 * Created by shinji_kubota on 2017/07/09.
 */

public class serverdata extends AppCompatActivity {


    String url = "http://131.113.80.160/GET.php";

    ListView listView;






    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serverdata);


        listView = (ListView) findViewById(R.id.List1);
        final ArrayAdapter<String> array = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        listView.setAdapter(array);


        array.add("日付/作業者/農作物/作業内容/作業詳細/圃場/温度/湿度/照度");

//        OnClickListener listener = null;
//
//
//        Button btn=(Button)findViewById(R.id.button7);
//
//        //クリックイベントの通知先指定
//        btn.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {

                AsyncHttpClient client = new AsyncHttpClient();
                RequestParams params = new RequestParams();

//                array.add("B");

                client.get(url, params, new JsonHttpResponseHandler() {


                    //JSONArray,int statusCode, Header headers[]がポイント！！
                    @TargetApi(Build.VERSION_CODES.KITKAT)
                    public void onSuccess(int statusCode, Header headers[], JSONArray json) {


                        Log.i("JSoooooooooooooooooooooooooooooooooon", "onSuccess: JSONObject");
                        Log.i("JSoooooooooooooooooooooooooooooooooon", json.toString());


                        // b = json.getJSONArray().getJSONObject(0).getString("name");


                        JSONArray jsarr = null;
                        try {
                            jsarr = new JSONArray(json.toString());

                            for (int i = 0; i < jsarr.length(); i++) {

                                JSONObject jsonObject = jsarr.getJSONObject(i);
//                        Log.d("JSONSampleActivity", jsonObject.getString("A"));
                                Log.d("JSONSampleActivity", String.valueOf(jsarr.getJSONObject(i)));


                                array.add(jsarr.getJSONObject(i).getString("A") + "/" + jsarr.getJSONObject(i).getString("B") + "/" + jsarr.getJSONObject(i).getString("C") + "/" + jsarr.getJSONObject(i).getString("D") + "/" + jsarr.getJSONObject(i).getString("E") + "/" + jsarr.getJSONObject(i).getString("F") + "/" + jsarr.getJSONObject(i).getString("G") + "/" + jsarr.getJSONObject(i).getString("H") + "/" + jsarr.getJSONObject(i).getString("I"));

                            }

                            //Log.d("Sugeeeeeeeeeeeeeeeeeeeeeeeee", String.valueOf(jsarr.getJSONObject(2).getString("B")));

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                        //Log.d("JSoooooooooooooooooooooooooooooooooon",cmds);

                        //Toast.makeText(serverdata.this, json.toString(), Toast.LENGTH_LONG).show();
                    }


                });

            }
//        });
//    }











    public void onReturn(View v) {
        Intent intent = new Intent(getApplication(), TopView.class);
        startActivity(intent);

        finish();
    }




}






//        //webビューを使ったやつ
//        WebView myWebView = (WebView)findViewById(R.id.webView1);
//        myWebView.setWebViewClient(new WebViewClient());
//        myWebView.loadUrl(url);
//        myWebView.getSettings().setJavaScriptEnabled(true);

