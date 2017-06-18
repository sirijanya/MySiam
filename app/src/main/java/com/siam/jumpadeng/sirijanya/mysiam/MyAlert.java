package com.siam.jumpadeng.sirijanya.mysiam;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * Created by Admin on 18/6/2560.
 */

public class MyAlert {

    //การส่งแจ้งเตือนเรื่องอะไรcontext
    private Context context;

    public MyAlert(Context context) {
        this.context = context;
    }

    public void myDialog(String strTitle, String strMassage) {

        //show popup
        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        //popup ขึ้นมา ไม่สามารถ show undo
        builder.setCancelable(false);

        //show image popup
        builder.setIcon(R.mipmap.ic_name);

        builder.setTitle(strTitle);
        builder.setMessage(strMassage);

        //การเเลือกปุ่ม เพื่อให้ popup ขึ้นให้เลือก
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        //show
        builder.show();

    }


} //Main Class
