package com.example.mushfiqurrahman.sqlliteapp;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //databasehelper myDB;
    SQLiteOpenHelper openHelper;
    SQLiteDatabase myDB;
    Button _btnreg, _btnlogin;
    EditText _txtfanme, _txtlname, _txtpass, _txtemail, _txtphone;
//    EditText editname,editsur,editmarks,editTextId;
//    Button editbut;
//    Button btnviewAll;
//    Button btnviewUpdate;
//    Button btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

       super.onCreate(savedInstanceState);

    setContentView(R.layout.activity_main);
        openHelper  = new databasehelper(this);
        _txtfanme = (EditText)findViewById(R.id.editText1);
        _txtlname = (EditText)findViewById(R.id.editText2);
        _txtpass = (EditText)findViewById(R.id.editText3);
        _txtemail = (EditText)findViewById(R.id.editText8);
        _txtphone = (EditText)findViewById(R.id.editText4);
       _btnlogin=(Button)findViewById(R.id.button4);
        _btnreg=(Button)findViewById(R.id.button2);
        _btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               myDB=openHelper.getWritableDatabase();
                String fname=_txtfanme.getText().toString();
                String lname=_txtlname.getText().toString();
                String pass=_txtpass.getText().toString();
                String email=_txtemail.getText().toString();
                String phone=_txtphone.getText().toString();
                insertdata(fname, lname,pass,email,phone);
                Toast.makeText(getApplicationContext(), "register successfully",Toast.LENGTH_LONG).show();

            }
        });
        _btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, login.class);
                startActivity(intent);
            }
        });
    }





    public void insertdata(String fname, String lname, String pass, String email, String phone){
        ContentValues contentValues = new ContentValues();
        contentValues.put(databasehelper.col_6,fname);
        contentValues.put(databasehelper.col_7, lname);
        contentValues.put(databasehelper.col_8, pass);
        contentValues.put(databasehelper.col_9, email);
        contentValues.put(databasehelper.col_10, phone);
        long id = myDB.insert(databasehelper.TABLE_Registeration, null, contentValues);
    }
}

//        myDB =new databasehelper(this);
//        editTextId = (EditText)findViewById(R.id.editText4);
//        editname=(EditText)findViewById(R.id.editTex_name);
//        editsur=(EditText)findViewById(R.id.editTex_sur);
//        editmarks=(EditText)findViewById(R.id.editTex_marks);
//        editbut=(Button)findViewById(R.id.button1);
//        btnviewAll = (Button)findViewById(R.id.button2);
//        btnviewUpdate= (Button)findViewById(R.id.button3);
//        btnDelete= (Button)findViewById(R.id.button4);
       // AddData();
       // viewAll();
       // UpdateData();
       // DeleteData();

//    public void DeleteData() {
//        btnDelete.setOnClickListener(
//                new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Integer deletedRows = myDB.deleteData(editTextId.getText().toString());
//                        if(deletedRows > 0)
//                            Toast.makeText(MainActivity.this,"Data Deleted",Toast.LENGTH_LONG).show();
//                        else
//                            Toast.makeText(MainActivity.this,"Data not Deleted",Toast.LENGTH_LONG).show();
//                    }
//                }
//        );
//    }
//    public void UpdateData() {
//        btnviewUpdate.setOnClickListener(
//                new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        boolean isUpdate = myDB.updateData(editTextId.getText().toString(),
//                                editname.getText().toString(),
//                                editsur.getText().toString(),editmarks.getText().toString());
//                        if(isUpdate == true)
//                            Toast.makeText(MainActivity.this,"Data Update",Toast.LENGTH_LONG).show();
//                        else
//                            Toast.makeText(MainActivity.this,"Data not Updated",Toast.LENGTH_LONG).show();
//                    }
//                }
//        );
//    }
//    public  void AddData()
//    {
//        editbut.setOnClickListener(
//                new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                       boolean isInserted= myDB.insert(editname.getText().toString(),editsur.getText().toString(),editmarks.getText().toString());
//                       if(isInserted==true){
//                           Toast.makeText(MainActivity.this,"Data inserted ",Toast.LENGTH_LONG).show();
//                       }
//                       else{
//                           Toast.makeText(MainActivity.this,"Data not inserted ",Toast.LENGTH_LONG).show();
//                       }
//                    }
//                }
//        );
//    }
//    public void viewAll() {
//        btnviewAll.setOnClickListener(
//                new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Cursor res = myDB.getAllData();
//                        if(res.getCount() == 0) {
//                            // show message
//                            showMessage("Error","Nothing found");
//                            return;
//                        }
//
//                        StringBuffer buffer = new StringBuffer();
//                        while (res.moveToNext()) {
//                            buffer.append("Id :"+ res.getString(0)+"\n");
//                            buffer.append("Name :"+ res.getString(1)+"\n");
//                            buffer.append("Surname :"+ res.getString(2)+"\n");
//                            buffer.append("Marks :"+ res.getString(3)+"\n\n");
//                        }
//
//                        // Show all data
//                        showMessage("Data",buffer.toString());
//                    }
//                }
//        );
//    }
//    public void showMessage(String title,String Message){
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setCancelable(true);
//        builder.setTitle(title);
//        builder.setMessage(Message);
//        builder.show();
//    }


