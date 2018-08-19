package com.example.ubuntu.androidtutorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

//    SAX parser is abstract class, we can't create object of abstract class
//    Factory class help to get object of SAX Parser. It has capability of creating own object
//    and return the object
    public void readXML(View view) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser(); //get the object of SAXParser by calling newSAXParser.
//            get data from assets folder
//             (first parameter:InputStream, second parameter:DefaultHandler)
            parser.parse(getAssets().open("employees.xml"),
                    new DefaultHandler(){ //when we create object of class like this then it is called annonymous inner class.
                        Employee employee;
                        ArrayList<Employee> list;
                        String msg ="";

                        @Override
                        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                            super.startElement(uri, localName, qName, attributes);
                        }

                        @Override
                        public void characters(char[] ch, int start, int length) throws SAXException {
                            super.characters(ch, start, length);
                        }

                        @Override
                        public void endElement(String uri, String localName, String qName) throws SAXException {
                            super.endElement(uri, localName, qName);
                        }
                    });
        } catch (Exception e) {

        }
    }
}


//SAX Parser have one supporting class called default handler.
// Default handler five methods are:-
//1. startDocument()
//2. startElement()
//3. characters()
//4.endElement()
//5.endDocument()

//SAX Parser is sequential execution