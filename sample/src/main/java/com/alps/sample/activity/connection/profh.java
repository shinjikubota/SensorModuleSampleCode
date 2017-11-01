package com.alps.sample.activity.connection;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.alps.sample.R;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

/**
 * Created by shinji_kubota on 2017/10/10.
 */

public class profh extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profh);
    }


    public void soushin(View V){

        EditText editText = (EditText)findViewById(R.id.editT);
        String s1 = editText.getText().toString();


        //データ送信
        AsyncHttpClient client = new AsyncHttpClient();

        RequestParams params = new RequestParams();
        params.put("a", s1);
//        params.put("b", b);
//        params.put("c", c);
//        params.put("d", d);


        String url = "http://131.113.80.160/POSTh.php";

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


