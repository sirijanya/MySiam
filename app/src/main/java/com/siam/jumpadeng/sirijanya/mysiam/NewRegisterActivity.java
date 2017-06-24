package com.siam.jumpadeng.sirijanya.mysiam;

import android.support.annotation.BoolRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import static com.siam.jumpadeng.sirijanya.mysiam.R.id.btnNewRegister;
import static com.siam.jumpadeng.sirijanya.mysiam.R.id.edtPassword;

public class NewRegisterActivity extends AppCompatActivity {

    // การทำ Explicit การปรพกาษตัวแปร
    private ImageView imageView;
    private EditText nameEditText, userEditText, passwordEditText;
    private Button button;
    private String nameString, userString, passwordString; //การประกาศค่าโดยใช้string


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_register);

        //Initial View
        initialView();

        //Back Controller ลูกศรกลับ
        backcontroller();

        //NewRegister Controller
        newRegisterController();


    }// Mani Method

    private void newRegisterController() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Get Value From Edit Text เวลาพิมไม่ถูกหรืออะไรก็แล้วแต่จะขึ้นแจ้งเตือนตามนี่
                nameString = nameEditText.getText().toString().trim();
                userString = userEditText.getText().toString().trim();
                passwordString = passwordEditText.getText().toString().trim();

                //Check Space การเช็คช่องว่าง ตัว OR คือ ||
                if (nameString.equals("") || userString.equals("") || passwordString.equals("")) {
                    //Have Space
                    MyAlert myAlert = new MyAlert(NewRegisterActivity.this);
                    myAlert.myDialog("Have Space", "Please Fill All Blank");

                } else {
                    //No Space
                    uploadValueToserver();

                }


            }
        });
    }

    private void uploadValueToserver() {

        try {

            PostDataToServer postDataToServer = new PostDataToServer(NewRegisterActivity.this);
            postDataToServer.execute(nameString,userString,passwordString,"http://androidthai.in.th/siam/addDataSirijanya.php");

            if (Boolean.parseBoolean(postDataToServer.get())) {
                finish();

            }else {
                MyAlert myAlert = new MyAlert(NewRegisterActivity.this);
                myAlert.myDialog("Cannot Upload","Please Try Again");

            }






        }catch (Exception e){
            Log.d("SiamV1", "e upload ==> " + e.toString());

        }

    }

    private void backcontroller() {
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initialView() {
        imageView = (ImageView) findViewById(R.id.imvback);
        nameEditText = (EditText) findViewById(R.id.edtname123);
        userEditText = (EditText) findViewById(R.id.edtUser);
        passwordEditText = (EditText) findViewById(R.id.edtPassword);
        button = (Button) findViewById(btnNewRegister);
    }

} //Main Class
