package com.example.ubuntu.androidtutorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.ksoap2.transport.HttpsTransportSE;

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

        String wsdl_url = "http://cxf.547215.n5.nabble.com/file/n5634307/ip2geo.wsdl";
        String soap_action = "http://ws.cdyne.com/ResolveIP"; //n number of services choose particular one service.
        String name_space = "http://ws.cdyne.com";
        String method_name = "ResolveIP";

        SoapObject soapObject = new SoapObject(name_space, method_name);
        soapObject.addProperty("ipAddress", editText.getText().toString());

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11); //version of soap service
//        if we are calling .Net web service then we have to use
        envelope.dotNet = true;
        envelope.setOutputSoapObject(soapObject);
//        transferring request over the network

        HttpTransportSE hts = new HttpTransportSE(wsdl_url);
        try{
            hts.call(soap_action, envelope);
//            hit the server and get the response from server.

            SoapObject object = (SoapObject) envelope.bodyIn;
           String respon = object.getProperty(0).toString(); //get the response in zero index

            System.out.println(respon);
        }catch(Exception e){}

    }
}
