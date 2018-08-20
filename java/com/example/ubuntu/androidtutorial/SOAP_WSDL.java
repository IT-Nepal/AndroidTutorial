package com.example.ubuntu.androidtutorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
// Download jar file( ksoap2 android .jar
// app ->New-> Module -> import .JAR/.AAR Package -> add jar file
// app -> Open Module Setting -> Dependencies -> + -> Module Dependencies
public class SOAP_WSDL extends AppCompatActivity {

    ListView listView;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soap__wsdl);

        listView = findViewById(R.id.lv);
        editText = findViewById(R.id.et);
    }

    public void getDetail(View view){

    }
}
