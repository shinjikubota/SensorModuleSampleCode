package com.alps.sample.activity.connection;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.alps.sample.R;

/**
 * Created by shinji_kubota on 2017/10/12.
 */

public class AGAppTeisyoku extends AppCompatActivity {


    //1行目
    //ポッド
    private Spinner pod1;
    private String pod1Items[] = {"0", "100", "120","1","2","3"};
    String pod1val;
    //数
    private Spinner kazu1;
    private String kazu1Items[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    String kazu1val;


    //2行目
    //ポッド
    private Spinner pod2;
    private String pod2Items[] = {"0", "100", "120"};
    String pod2val = "";
    //数
    private Spinner kazu2;
    private String kazu2Items[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    String kazu2val = "";


    //3行目
    //ポッド
    private Spinner pod3;
    private String pod3Items[] = {"0", "100", "120"};
    String pod3val = "";
    //数
    private Spinner kazu3;
    private String kazu3Items[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    String kazu3val = "";





    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.agappteisyoku);


        //ポッド１
        pod1 = (Spinner)findViewById(R.id.pod1);
        ArrayAdapter<String> adapter11 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, pod1Items);
        adapter11.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        pod1.setAdapter(adapter11);
        pod1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner spinner = (Spinner) parent;
                pod1val = (String) spinner.getSelectedItem();
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
            }
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });





        //ポッド2
        pod2 = (Spinner)findViewById(R.id.pod2);
        ArrayAdapter<String> adapter21 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, pod2Items);
        adapter21.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        pod2.setAdapter(adapter21);
        pod2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner spinner = (Spinner) parent;
                pod2val = (String) spinner.getSelectedItem();
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
            }
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




        //ポッド3
        pod3 = (Spinner)findViewById(R.id.pod3);
        ArrayAdapter<String> adapter31 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, pod3Items);
        adapter31.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        pod3.setAdapter(adapter31);
        pod3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner spinner = (Spinner) parent;
                pod3val = (String) spinner.getSelectedItem();
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
            }
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }


    public void tsugi(View V){

        //String-int変換
        int ipod1 = Integer.parseInt(pod1val);
        int ikaz1 = Integer.parseInt(kazu1val);

        int ipod2 = Integer.parseInt(pod2val);
        int ikaz2 = Integer.parseInt(kazu2val);

        int ipod3 = Integer.parseInt(pod3val);
        int ikaz3 = Integer.parseInt(kazu3val);





        saibaidata.syousai = ipod1 * ikaz1 + ipod2 * ikaz2 + ipod3 * ikaz3 + "個";



        Intent intent = new Intent(getApplication(),hojyo.class);
        startActivity(intent);

        // 通知
        Toast.makeText(AGAppTeisyoku.this, saibaidata.syousai, Toast.LENGTH_SHORT).show();

    }


}
