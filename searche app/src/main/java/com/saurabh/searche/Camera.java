package com.saurabh.searche;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.graphics.Bitmap;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.wonderkiln.camerakit.CameraKitError;
import com.wonderkiln.camerakit.CameraKitEvent;
import com.wonderkiln.camerakit.CameraKitEventListener;
import com.wonderkiln.camerakit.CameraKitImage;
import com.wonderkiln.camerakit.CameraKitVideo;
import com.wonderkiln.camerakit.CameraView;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Camera extends AppCompatActivity {
    private static final String MODEL_PATH = "modeld.tflite";
    private static final boolean QUANT = true;
    private static final String LABEL_PATH = "labelscc.txt";
    private static final int INPUT_SIZE = 224;
    public Classifier classifier;
    private Executor executor = Executors.newSingleThreadExecutor();
    private TextView textViewResult;
    private Button btnDetectObject, btnToggleCamera;
    private ImageView imageViewResult;
    private CameraView cameraView;
    String sp="None", s8="a",skc,ksc="b";;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        cameraView = findViewById(R.id.cameraView);
        imageViewResult = findViewById(R.id.imageViewResult);
        textViewResult = findViewById(R.id.textViewResult);
        textViewResult.setMovementMethod(new ScrollingMovementMethod());
        btnDetectObject = findViewById(R.id.btnDetectObject);


        //setting onclick event listener on cameraview button
        cameraView.addCameraKitListener(new CameraKitEventListener() {
            @Override
            public void onEvent(CameraKitEvent cameraKitEvent) {
            }
            @Override
            public void onError(CameraKitError cameraKitError) {
            }
            @Override
            public void onImage(CameraKitImage cameraKitImage) {

                Bitmap bitmap = cameraKitImage.getBitmap();    //getting the image into bitmap format
                //converting the captured image in size according to input size
                bitmap = Bitmap.createScaledBitmap(bitmap, INPUT_SIZE, INPUT_SIZE, false);
                imageViewResult.setImageBitmap(bitmap);        //set the image bitmap on imageview
                //classifying the bitmap image
                final List<Classifier.Recognition> results = classifier.recognizeImage(bitmap);

                //textViewResult.setText(results.toString());
                  sp = results.toString();
            }
            @Override
            public void onVideo(CameraKitVideo cameraKitVideo) {
            }
        });
        // on click listener to capture the image
        btnDetectObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cameraView.captureImage();
            }
        });
        //calling the tensorflow model to load and run
        initTensorFlowAndLoadModel();
    }

    @Override
    protected void onResume() {
        super.onResume();
        cameraView.start();
    }

    @Override
    protected void onPause() {
        cameraView.stop();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                classifier.close();
            }
        });
    }

    public void initTensorFlowAndLoadModel() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    classifier = TensorFlowImageClassifier.create(
                            getAssets(),
                            MODEL_PATH,
                            LABEL_PATH,
                            INPUT_SIZE,
                            QUANT);
                    makeButtonVisible();
                } catch (final Exception e) {
                    throw new RuntimeException("Error initializing TensorFlow!", e);
                }
            }
        });
    }
    private void makeButtonVisible() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                btnDetectObject.setVisibility(View.VISIBLE);
            }
        });
    }


    public void oncheck(View view) {
       char[] camchararrays = sp.toCharArray();    //storing the string sp into char array
       char[] camnewarray = new char[sp.length()];
       int camu = 0,camq=0;
       for (int camk = 0;camk<sp.length();camk++){
           if((camchararrays[camk]>='a' && camchararrays[camk]<='z') || (camchararrays[camk] ==',') || (camchararrays[camk]>='A' && camchararrays[camk]<='Z')
                   || camchararrays[camk] == '_'){      //condition to match the character accordingly
               camnewarray[camk] = camchararrays[camk];
               camq++;
           }
       }
       char[] camfaltu = new char[camq];
        for(int m= 0;m<sp.length();m++){
            if((camnewarray[m]>='a' && camnewarray[m]<='z') || (camnewarray[m] == ',') || (camnewarray[m]>='A' && camnewarray[m]<='Z' )
                    || camnewarray[m] == '_'){
                camfaltu[camu] = camnewarray[m];
                camu++;
            }
        }

        String[] cams10;
        s8 = String.valueOf(camfaltu);
        if (s8.contains(",")) {
            cams10 = s8.split(",", 2);      //splitting the string separated by comma
            skc=cams10[0];
            ksc=cams10[1];;
        }
        else
            skc=s8;
        //custom alert dialog
        final AlertDialog.Builder alerts = new AlertDialog.Builder(Camera.this);
        View mviews = getLayoutInflater().inflate(R.layout.customdialog,null);
        final Button bt_sk = (Button)mviews.findViewById(R.id.onsk);
        final Button bt_ks = (Button)mviews.findViewById(R.id.onks);
        bt_sk.setText(skc);
        bt_ks.setText(ksc);
        if (ksc.equals("b"))
            bt_ks.setVisibility(View.INVISIBLE);;     //setting the button invisible
        ksc="b";
        alerts.setView(mviews);                       //set the alert dialog in mviews
        final AlertDialog alertDialogs = alerts.create();
        bt_sk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                oncamchecks(skc,Camera.this);         //calling the function oncamecheck
                alertDialogs.dismiss();
            }
        });
        bt_ks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               oncamchecks(ksc,Camera.this);     //calling the method oncamchecks()
               ksc="b";
               alertDialogs.dismiss();     // Dismiss the alert dialog
            }
        });
        alertDialogs.show();        //set the alert dialog to show on screen

    }
    // This method check the electronic component name and show the information according to that
    public void oncamchecks(String sd, Context cc){

        if(sd.equals("DHT")) {
            Intent i = new Intent(cc, NewActivity.class);
            i.putExtra("actionBarTitle", "DHT");     //sending the data into NewActivity through method putExtra()
            i.putExtra("contentTv", "DHT");
            startActivity(i);
        }
        else
        if(sd.equals("MPU_Sensor")) {
            Intent i = new Intent(cc, NewActivity.class);
            i.putExtra("actionBarTitle", "MPU_Sensor");
            i.putExtra("contentTv", "MPU_Sensor");
            startActivity(i);
        }
        else
        if(sd.equals("LED")) {
            Intent i = new Intent(cc, NewActivity.class);
            i.putExtra("actionBarTitle", "LED");
            i.putExtra("contentTv", "LED");
            startActivity(i);
        }
        else
        if(sd.equals("Arduino_Mega")) {
            Intent i = new Intent(cc, NewActivity.class);
            i.putExtra("actionBarTitle", "Arduino_Mega");
            i.putExtra("contentTv", "Arduino_Mega");
            startActivity(i);
        }
        else
        if(sd.equals("Arduino_Nano")) {
            Intent i = new Intent(cc, NewActivity.class);
            i.putExtra("actionBarTitle", "Arduino_Nano");
            i.putExtra("contentTv", "Arduino_Nano");
            startActivity(i);
        }
        else
        if(sd.equals("Arduino_Uno")) {
            Intent i = new Intent(cc, NewActivity.class);
            i.putExtra("actionBarTitle", "Arduino_Uno");
            i.putExtra("contentTv", "Arduino_Uno");
            startActivity(i);
        }
        else
        if(sd.equals("Buzzer")) {
            Intent i = new Intent(cc, NewActivity.class);
            i.putExtra("actionBarTitle", "Buzzer");
            i.putExtra("contentTv", "Buzzer");
            startActivity(i);
        }
        else
        if(sd.equals("Camera")) {
            Intent i = new Intent(cc, NewActivity.class);
            i.putExtra("actionBarTitle", "Camera");
            i.putExtra("contentTv", "Camera");
            startActivity(i);
        }
        else
        if(sd.equals("Cartridge-Fuse")) {
            Intent i = new Intent(cc, NewActivity.class);
            i.putExtra("actionBarTitle", "Cartridge-FuseT");
            i.putExtra("contentTv", "Cartridge-Fuse");
            startActivity(i);
        }
        else
        if(sd.equals("Clip-Lead")) {
            Intent i = new Intent(cc ,NewActivity.class);
            i.putExtra("actionBarTitle", "Clip-Lead");
            i.putExtra("contentTv", "Clip-Lead");
            startActivity(i);
        }
        else
        if(sd.equals("Filament")) {
            Intent i = new Intent(cc, NewActivity.class);
            i.putExtra("actionBarTitle", "Filament");
            i.putExtra("contentTv", "Filament");
            startActivity(i);
        }
        else
        if(sd.equals("Flame_Sensor")) {
            Intent i = new Intent(cc, NewActivity.class);
            i.putExtra("actionBarTitle", "Flame_Sensor");
            i.putExtra("contentTv", "Flame_SensorT");
            startActivity(i);
        }
        else
        if(sd.equals("Induction-Coil")) {
            Intent i = new Intent(cc, NewActivity.class);
            i.putExtra("actionBarTitle", "Induction-Coil");
            i.putExtra("contentTv", "Induction-Coil");
            startActivity(i);
        }
        else
        if(sd.equals("Ir_Sensor_Module")) {
            Intent i = new Intent(cc, NewActivity.class);
            i.putExtra("actionBarTitle", "Ir_Sensor_Module");
            i.putExtra("contentTv", "Ir_Sensor_Module");
            startActivity(i);
        }
        else
        if(sd.equals("Lpg_Gas_Sensor_Module")) {
            Intent i = new Intent(cc, NewActivity.class);
            i.putExtra("actionBarTitle", "Lpg_Gas_Sensor_Module");
            i.putExtra("contentTv", "Lpg_Gas_Sensor_Module");
            startActivity(i);
        }
        else
        if(sd.equals("Memory-Chip")) {
            Intent i = new Intent(cc, NewActivity.class);
            i.putExtra("actionBarTitle", "Memory-Chip");
            i.putExtra("contentTv", "Memory-ChipT");
            startActivity(i);
        }
        else
        if(sd.equals("Moisture_Sensor")) {
            Intent i = new Intent(cc, NewActivity.class);
            i.putExtra("actionBarTitle", "Moisture_Sensor");
            i.putExtra("contentTv", "Moisture_Sensor");
            startActivity(i);
        }
        else
        if(sd.equals("MultiplexerT")) {
            Intent i = new Intent(cc, NewActivity.class);
            i.putExtra("actionBarTitle", "Multiplexer");
            i.putExtra("contentTv", "Multiplexer");
            startActivity(i);
        }
        else
        if(sd.equals("Potentiometer")) {
            Intent i = new Intent(cc, NewActivity.class);
            i.putExtra("actionBarTitle", "Potentiometer");
            i.putExtra("contentTv", "Potentiometer");
            startActivity(i);
        }
        else
        if(sd.equals("Pulse-Generator")) {
            Intent i = new Intent(cc, NewActivity.class);
            i.putExtra("actionBarTitle", "Pulse-Generator");
            i.putExtra("contentTv", "Pulse-Generator");
            startActivity(i);
        }
        else
        if(sd.equals("Raspberry_Pi")) {
            Intent i = new Intent(cc, NewActivity.class);
            i.putExtra("actionBarTitle", "Raspberry_Pi");
            i.putExtra("contentTv", "Raspberry_Pi");
            startActivity(i);
        }
        else
        if(sd.equals("Relay")) {
            Intent i = new Intent(cc, NewActivity.class);
            i.putExtra("actionBarTitle", "Relay");
            i.putExtra("contentTv", "Relay");
            startActivity(i);
        }
        else
        if(sd.equals("Shunt")) {
            Intent i = new Intent(cc, NewActivity.class);
            i.putExtra("actionBarTitle", "Shunt");
            i.putExtra("contentTv", "Shunt");
            startActivity(i);
        }
        else
        if(sd.equals("Stabilizer")) {
            Intent i = new Intent(cc, NewActivity.class);
            i.putExtra("actionBarTitle", "Stabilizer");
            i.putExtra("contentTv", "Stabilizer");
            startActivity(i);
        }
        else
        if(sd.equals("Transistor")) {
            Intent i = new Intent(cc, NewActivity.class);
            i.putExtra("actionBarTitle", "Transistor");
            i.putExtra("contentTv", "Transistor");
            startActivity(i);
        }
        else
        if(sd.equals("Ultrasonic_Sensor")) {
            Intent i = new Intent(cc, NewActivity.class);
            i.putExtra("actionBarTitle", "Ultrasonic_Sensor");
            i.putExtra("contentTv", "Ultrasonic_Sensor");
            startActivity(i);
        }
        else
            startActivity(new Intent(cc,Explore.class));
    }


}



