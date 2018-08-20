package com.example.ubuntu.androidtutorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

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

        Log.d("TAG","oncreate");
    }

//    SAX parser is abstract class, we can't create object of abstract class
//    Factory class help to get object of SAX Parser. It has capability of creating own object
//    and return the object
    public void readXML(View view) {
        try {
            Log.d("TAG","button clicl");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser(); //get the object of SAXParser by calling newSAXParser.
//            get data from assets folder
//             (first parameter:InputStream, second parameter:DefaultHandler)
            parser.parse(getAssets().open("employee.xml"),
                    new DefaultHandler(){ //when we create object of class like this then it is called annonymous inner class.
                        Employee employee;
                        ArrayList<Employee> list;
                        String msg ="";

                        @Override
                        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                            super.startElement(uri, localName, qName, attributes);

                            if(qName.equals("employees")){
                                list = new ArrayList<>(); //create arraylist object
                            }
                            if(qName.equals("employee")){
                                employee = new Employee(); //create Employee object.
                            }
                        }

                        @Override
                        public void characters(char[] ch, int start, int length) throws SAXException {
                            super.characters(ch, start, length);

                            msg = new String(ch,start,length); //converting char[] to string.
                        }

                        @Override
                        public void endElement(String uri, String localName, String qName) throws SAXException {
                            super.endElement(uri, localName, qName);

                            if(qName.equals("id")){
                                employee.setId(Integer.parseInt(msg));
                            }
                            if(qName.equals("name")){
                                employee.setName(msg);
                            }
                            if(qName.equals("age")){
                                employee.setAge(Integer.parseInt(msg));
                            }
                            if(qName.equals("work")){
                                employee.setWork(msg);
                            }
                            if(qName.equals("employee")){ //as start of employee tag new object is created for Employee class
//                                by which new object will be created and old object will be deleted with its refrences too.
                                list.add(employee);
                            }
                            if(qName.equals("employees")){
//                                creating temporary arraylist type string inorder to present object data into the string format.
                                ArrayList<String> temp_list = new ArrayList<>();

                                for(Employee employee:list){
                                    temp_list.add(employee.getId()+ "|" +employee.getName()+ "|"+ employee.getAge()+
                                    "|"+employee.getWork());
                                }
                                ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1, temp_list);
                                ListView listView = findViewById(R.id.lv);
                                listView.setAdapter(adapter);

                                Toast.makeText(MainActivity.this, "hello", Toast.LENGTH_SHORT).show();
                            }
                        }
//                        one refrences can't point to two objects but two references can point to same object.
                    });
        } catch (Exception e) {
Log.d("TAG", "exception occurs" + e);
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