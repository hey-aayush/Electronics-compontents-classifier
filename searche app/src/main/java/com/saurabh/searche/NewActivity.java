package com.saurabh.searche;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class NewActivity extends AppCompatActivity {
    private WebView mywebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        androidx.appcompat.widget.Toolbar toolbarsss = (Toolbar) findViewById(R.id.toolbarss);
        setSupportActionBar(toolbarsss);

        //webView
        mywebView = (WebView)findViewById(R.id.webview);
        WebSettings webSettings = mywebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        //get data from previous activity when item of listview is clicked using intent
        Intent intent = getIntent();
        String mActionBarTitle = intent.getStringExtra("actionBarTitle");
        String mContent = intent.getStringExtra("contentTv");

        //set actionbar title
        toolbarsss.setTitle(mActionBarTitle);
        // Comparing name passed through intent and according to that open that web page
     if(mContent.equals("DHT"))
        mywebView.loadUrl("https://571sanyam.github.io/dht/DHT-22.html");
     else
     if(mContent.equals("MPU_Sensor"))
         mywebView.loadUrl("https://571sanyam.github.io/mpu/MPU.html");
     else
     if(mContent.equals("LED"))
         mywebView.loadUrl("https://571sanyam.github.io/led/led.html");
     else
     if(mContent.equals("Arduino_Mega"))
         mywebView.loadUrl("https://571sanyam.github.io/arduino-mega/ArduinoMega.html");
     else
     if(mContent.equals("Arduino_Nano"))
         mywebView.loadUrl("https://571sanyam.github.io/nano/ArduinoNano");
     else
     if(mContent.equals("Arduino_Uno"))
         mywebView.loadUrl("https://571sanyam.github.io/uno/ArduinoUno");
     else
     if(mContent.equals("Buzzer"))
         mywebView.loadUrl("https://571sanyam.github.io/buzzer/Buzzer.html");
     else
     if(mContent.equals("Camera"))
         mywebView.loadUrl("https://571sanyam.github.io/Camera/camera.html");
     else
     if(mContent.equals("Cartridge_Fuse"))
         mywebView.loadUrl("https://571sanyam.github.io/fuse/Cartridgefuse.html");
     else
     if(mContent.equals("Clip_Lead"))
         mywebView.loadUrl("https://571sanyam.github.io/clip/clip-lead.html");
     else
     if(mContent.equals("Filament"))
         mywebView.loadUrl("https://571sanyam.github.io/filament/Filament.html");
     else
     if(mContent.equals("Flame_Sensor"))
         mywebView.loadUrl("https://571sanyam.github.io/flame/FlameSensor.html");
     else
     if(mContent.equals("Induction_Coil"))
         mywebView.loadUrl("https://571sanyam.github.io/induction/Induction.html");
     else
     if(mContent.equals("IR_Sensor_Module"))
         mywebView.loadUrl("https://571sanyam.github.io/ir/IR.html");
     else
     if(mContent.equals("LPG_Gas_Sensor_Module"))
         mywebView.loadUrl("https://571sanyam.github.io/lpg/LPG.html");
     else
     if(mContent.equals("Memory_Chip"))
         mywebView.loadUrl("https://571sanyam.github.io/memorychip/Memorychip.html");
     else
     if(mContent.equals("Moisture_Sensor"))
         mywebView.loadUrl("https://571sanyam.github.io/moisture/Moisture.html");
     else
     if(mContent.equals("Multiplexer"))
         mywebView.loadUrl("https://571sanyam.github.io/multiplexer/multiplexer.html");
     else
     if(mContent.equals("Potentiometer"))
         mywebView.loadUrl("https://571sanyam.github.io/potentiometer/potentiometer.html");
     else
     if(mContent.equals("Pulse_Generator"))
         mywebView.loadUrl("https://571sanyam.github.io/pulse/Pulse.html");
     else
     if(mContent.equals("Raspberry_Pi"))
         mywebView.loadUrl("https://571sanyam.github.io/raspberry-pi/camera.html");
     else
     if(mContent.equals("Relay"))
         mywebView.loadUrl("https://571sanyam.github.io/relay/camera.html");
     else
     if(mContent.equals("Shunt"))
         mywebView.loadUrl("https://571sanyam.github.io/shunt/camera.html");
     else
     if(mContent.equals("Stabilizer"))
         mywebView.loadUrl("https://571sanyam.github.io/stabilizer/camera.html");
     else
     if(mContent.equals("Transistor"))
         mywebView.loadUrl("https://571sanyam.github.io/transistor/camera.html");
     else
     if(mContent.equals("Ultrasonic_Sensor"))
         mywebView.loadUrl("https://571sanyam.github.io/ultrasonic/camera.html");





    }
}

