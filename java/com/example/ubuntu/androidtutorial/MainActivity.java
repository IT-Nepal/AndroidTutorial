package com.example.ubuntu.androidtutorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void readXML(View view){

    }
}


//SAX Parser have one supporting class called default handler.
// Default handler five methods are:-
//1. startDocument()
//2. startElement()
//3. characters()
//4.endElement()
//5.endDocument()