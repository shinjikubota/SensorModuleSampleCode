package com.alps.sample.activity.connection;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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

import cz.msebera.android.httpclient.Header;

/**
 * Created by shinji_kubota on 2017/10/12.
 */

public class AGAppSyuukaku extends AppCompatActivity {



    String url = "http://131.113.80.160/GETc.php";


    //1行目
    //ポッド
    private Spinner pod1;
    ArrayList<String> pod1Items = new ArrayList<String>(Arrays.asList("小キャリー"));
    String pod1val = "";
    //数
    private Spinner kazu1;
    private String kazu1Items[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    String kazu1val;


    //2行目
    //ポッド
    private Spinner pod2;
    ArrayList<String> pod2Items = new ArrayList<String>(Arrays.asList("小キャリー"));
//    private String pod2Items[] = {"Mキャリー"};
    String pod2val = "";
    //数
    private Spinner kazu2;
    private String kazu2Items[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    String kazu2val;


    //3行目
    //ポッド
    private Spinner pod3;
    ArrayList<String> pod3Items = new ArrayList<String>(Arrays.asList("小キャリー"));
//    private String pod3Items[] = {"Mキャリー"};
    String pod3val = "";
    //数
    private Spinner kazu3;
    private String kazu3Items[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    String kazu3val;



//    int ipod1 = 0;
//    int ikaz1 = 0;
//
//    int ipod2 = 0;
//    int ikaz2 = 0;
//
//    int ipod3 = 0;
//    int ikaz3 = 0;






    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.agappsyuukaku);


        //農作物の表示
        TextView textView = (TextView) findViewById(R.id.TV);
        textView.setText(saibaidata.sakumotsu);




        //ポッド１
        pod1 = (Spinner)findViewById(R.id.pod1);
        final ArrayAdapter<String> adapter11 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, pod1Items);
        adapter11.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        //ポッド2
        pod2 = (Spinner)findViewById(R.id.pod2);
        final ArrayAdapter<String> adapter21 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, pod2Items);
        adapter21.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        //ポッド3
        pod3 = (Spinner)findViewById(R.id.pod3);
        final ArrayAdapter<String> adapter31 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, pod3Items);
        adapter31.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);




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


//                        adapter11.add(jsarr.getJSONObject(i).getString("A") + "," + jsarr.getJSONObject(i).getString("B") + "," + jsarr.getJSONObject(i).getString("C"));
//                        adapter21.add(jsarr.getJSONObject(i).getString("A") + "," + jsarr.getJSONObject(i).getString("B") + "," + jsarr.getJSONObject(i).getString("C"));
//                        adapter31.add(jsarr.getJSONObject(i).getString("A") + "," + jsarr.getJSONObject(i).getString("B") + "," + jsarr.getJSONObject(i).getString("C"));


                        adapter11.add(jsarr.getJSONObject(i).getString("A"));
                        adapter21.add(jsarr.getJSONObject(i).getString("A"));
                        adapter31.add(jsarr.getJSONObject(i).getString("A"));



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

//
//                //配列を分割
//                String str1 = pod1val;
//                String[] val1 = str1.split(",", 0);
//
//                //String-int変換
//                ipod1 = Integer.parseInt(val1[1]);

            }
            public void onNothingSelected(AdapterView<?> parent) {



            }
        });


        //枚数１
        kazu1 = (Spinner)findViewById(R.id.kazu1);
        ArrayAdapter<String> adapter12 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, kazu1Items);
        adapter12.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        kazu1.setAdapter(adapter12);
        kazu1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner spinner = (Spinner) parent;
                kazu1val = (String) spinner.getSelectedItem();
//
//                ikaz1 = Integer.parseInt(kazu1val);

            }
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });






        pod2.setAdapter(adapter21);
        pod2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner spinner = (Spinner) parent;
                pod2val = (String) spinner.getSelectedItem();


//                String str2 = pod2val;
//                String[] val2 = str2.split(",", 0);
//
//
//                ipod2 = Integer.parseInt(val2[1]);


            }
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        //枚数2
        kazu2 = (Spinner)findViewById(R.id.kazu2);
        ArrayAdapter<String> adapter22 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, kazu2Items);
        adapter22.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        kazu2.setAdapter(adapter22);
        kazu2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner spinner = (Spinner) parent;
                kazu2val = (String) spinner.getSelectedItem();


//                ikaz2 = Integer.parseInt(kazu2val);


            }
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });





        pod3.setAdapter(adapter31);
        pod3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner spinner = (Spinner) parent;
                pod3val = (String) spinner.getSelectedItem();


//                String str3 = pod3val;
//                String[] val3 = str3.split(",", 0);
//
//
//
//                ipod3 = Integer.parseInt(val3[1]);



            }
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        //枚数3
        kazu3 = (Spinner)findViewById(R.id.kazu3);
        ArrayAdapter<String> adapter32 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, kazu3Items);
        adapter32.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        kazu3.setAdapter(adapter32);
        kazu3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner spinner = (Spinner) parent;
                kazu3val = (String) spinner.getSelectedItem();



//                ikaz3 = Integer.parseInt(kazu3val);





            }
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
















    }


    public void tsugi(View V){


//        int ipod1 = 0;
//        int ikaz1 = 0;
//
//        int ipod2 = 0;
//        int ikaz2 = 0;
//
//        int ipod3 = 0;
//        int ikaz3 = 0;



//        //配列を分割
//        String str1 = pod1val;
//        String[] val1 = str1.split(",", 0);
//
//        String str2 = pod2val;
//        String[] val2 = str2.split(",", 0);
//
//        String str3 = pod3val;
//        String[] val3 = str3.split(",", 0);
//
//
//        //String-int変換
//        ipod1 = Integer.parseInt(val1[1]);
//        ikaz1 = Integer.parseInt(kazu1val);
//
//        ipod2 = Integer.parseInt(val2[1]);
//        ikaz2 = Integer.parseInt(kazu2val);
//
//        ipod3 = Integer.parseInt(val3[1]);
//        ikaz3 = Integer.parseInt(kazu3val);



        saibaidata.syousai = pod1val +":" + kazu1val + "個," + pod2val +":" + kazu2val + "個," + pod3val +":" + kazu3val + "個";



        Intent intent = new Intent(getApplication(),hojyo.class);
        startActivity(intent);

        // 通知
        Toast.makeText(AGAppSyuukaku.this, saibaidata.syousai, Toast.LENGTH_SHORT).show();

    }


}
