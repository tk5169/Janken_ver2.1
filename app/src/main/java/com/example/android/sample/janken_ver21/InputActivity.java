package com.example.android.sample.janken_ver21;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Admin on 2017/09/18.
 */

public class InputActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acount);

        Button btnOk = (Button)findViewById(R.id.btnOk);
        btnOk.setOnClickListener(this);

        Button btnBack = (Button)findViewById(R.id.btnBack);
        btnBack.setOnClickListener(this);


        //こっちのテキストを書き換える処理（n_or_cにテキストの情報が入ってる）
        TextView txt = (TextView)findViewById(R.id.text_n_c);
        //MainActivity側から送ったインテントをキャッチし、情報を受け取る
        Intent i = getIntent();
        String s = i.getStringExtra("n_or_c");
        txt.setText(String.valueOf(s));


        EditText etInput = (EditText) findViewById(R.id.etInput);
        // フィルターを作成
        InputFilter inputFilter = new InputFilter() {
            @Override
            public CharSequence filter(CharSequence source, int start, int end,
                                       Spanned dest, int dstart, int dend) {
                if (source.toString().matches("^[0-9a-zA-Z]+$")) {
                    return source;
                } else {
                    return "";
                }
            }
        };
// フィルターの配列を作成
        InputFilter[] filters = new InputFilter[] { inputFilter };
// フィルターの配列をセット
        etInput.setFilters(filters);


    }

    @Override
    public void onClick(View view) {
//
//        if(s.equals("はじめから")){
//            //EditTextに書かれていることを読み取ってString型にする
//            EditText etInput = (EditText) findViewById(R.id.etInput);
//            Editable editable = etInput.getText();
//            String acount = editable.toString();
//
//            SharedPreferences prefs = getSharedPreferences("SaveData", Context.MODE_PRIVATE);
//            SharedPreferences.Editor editor = prefs.edit();
//            //strの情報を保存
//            editor.putString("string", acount);
//            editor.apply();
//        }else if(s.equals("つづきから")){
//            finish();
//        }
//
//
//
//        int id = view.getId();
//
        int id = view.getId();
        switch (id) {

            case R.id.btnOk:
                //MainActivity側から送ったインテントをキャッチし、情報を受け取る
                Intent i = getIntent();
                String s = i.getStringExtra("n_or_c");
                if(s.equals("はじめから")) {
//                    //EditTextに書かれていることを読み取ってString型にする
//                    EditText etInput = (EditText) findViewById(R.id.etInput);
//                    Editable editable = etInput.getText();
//                    String acount = editable.toString();
//
//                    SharedPreferences prefs = getSharedPreferences("SaveData", Context.MODE_PRIVATE);
//                    //acountの情報を保存
//                    SharedPreferences.Editor editor = prefs.edit();
//                    editor.putString("string", acount);
//                    editor.apply();

                    //じゃんけんの選択画面に移る
                    Intent intent1 = new Intent(InputActivity.this, SelectActivity.class);
                    startActivity(intent1);
                    break;
                }else if(s.equals("つづきから")){
                    SharedPreferences prefs = getSharedPreferences("SaveData", Context.MODE_PRIVATE);
                    //保存した情報の出力
                    String sTr = prefs.getString("string", "aa");
                    Intent intent1 = new Intent(InputActivity.this, SelectActivity.class);
                    startActivity(intent1);

                    break;
                }

            case R.id.btnBack:
                finish();
                break;

        }

    }
}
