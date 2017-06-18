package com.siam.jumpadeng.sirijanya.mysiam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity { //extends คลาสที่นำเสนอในหน้าจอ

    //Explicit
    private EditText userEditText, passwordEditText;
    private TextView textView;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // Statement
        setContentView(R.layout.activity_main); // การผูก layout

        //Initial View การเเอาตัวแปรไปผูกกับ privte
        initialView();

        //TextView Controller การทำให้ตัวอักษรคลิกได้
        textViewController();


    } // Mathod Mail

    private void textViewController() {
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Intent to NewRegisterActivity
                Intent intent = new Intent(MainActivity.this, NewRegisterActivity.class);
                startActivity(intent); //การเปิดหน้าที่2ซ้อนมาหน้าแรกสามารถกดกลับได้


            }
        });
    }

    private void initialView() {

        userEditText = (EditText) findViewById(R.id.edtUser);
        passwordEditText = (EditText) findViewById(R.id.edtPassword);
        textView = (TextView) findViewById(R.id.txtNewRegister);
        button = (Button) findViewById(R.id.btnLogin);


    }
} //  Main class นี่คือ คลาสหลัก
