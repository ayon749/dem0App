package com.example.mushfiqurrahman.sqlliteapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
    final String TAG = "xxx";
    SQLiteDatabase db;
    SQLiteOpenHelper openHelper;
    Cursor cursor;
    Button _btnLogin;
    EditText _txtEmail, _txtPass;

@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        _txtEmail=(EditText)findViewById(R.id.editText11);
        _txtPass=(EditText)findViewById(R.id.editText12);
        _btnLogin=(Button)findViewById(R.id.button3);
        openHelper=new databasehelper(this);
        db = openHelper.getReadableDatabase();
        _btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = _txtEmail.getText().toString();
                String pass = _txtPass.getText().toString();

                cursor = db.rawQuery("SELECT * FROM "+ databasehelper.TABLE_Registeration +" WHERE "+ databasehelper.col_9 + "=? AND " + databasehelper.col_8 +"=?", new String[]{email, pass});
                //String sql = "SELECT * FROM " + databasehelper.TABLE_NAME1;
                //" WHERE " + databasehelper.col_9 + " = ? AND " + databasehelper.col_8 + " = ? ", new String[]{email, pass};

               // Log.d(TAG,"sql: "+sql);


                //cursor = db.rawQuery(sql);


                if (cursor != null) {
                    if (cursor.getCount() > 0){
                        Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(getApplicationContext(), "Login error", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
