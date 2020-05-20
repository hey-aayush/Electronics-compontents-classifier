package com.saurabh.searche;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.firebase.storage.StorageReference;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Browse extends Camera{
    private ImageView ProfileImage;
    private static final int PICK_IMAGE = 1;
   int INPUT_SIZE = 224,flag =10;
    Uri imageUri;
    Bitmap bitmap,newbitmap;
    String s1,sz;
    String s7="a",sk,ks="b";
    Context contexts = Browse.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse);

        ProfileImage = (ImageView) findViewById(R.id.profile_image);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE && resultCode == RESULT_OK && data != null) {  //checing the permission provided by the user to access the gallery
            imageUri = data.getData();

            try {
                 newbitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), imageUri);
                 //converting the newbitmap browsed image accordint o requring size
                bitmap =Bitmap.createScaledBitmap(newbitmap,INPUT_SIZE,INPUT_SIZE,false);
                ProfileImage.setImageBitmap(newbitmap);      //setting the image on profileImage imageView
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public void take(View view) {
        if (flag==10) {
            Toast.makeText(this, "Click on the black screen to browse the image", Toast.LENGTH_SHORT).show();  //Toast

        }else {
            //classifying the image
            final List<Classifier.Recognition> results = classifier.recognizeImage(bitmap);
            initTensorFlowAndLoadModel();
            s1=results.toString();     //Assigning the result given by model in string s1
            char[] chararray = s1.toCharArray();
            char[] newarray = new char[s1.length()];
            TensorFlowImageClassifier tensorFlowImageClassifier = new TensorFlowImageClassifier();
            int q=0,r,u=0;
            String s2;

                     String s3 = Character.toString(chararray[2]);
                     String s4 = Character.toString(chararray[3]);
                             if(chararray[3] != ']') {
                                 s2 = s3 +s4;
                             }
                             else
                                 s2 = s3;
                             for (int k=0;k<s1.length();k++){
                                 if((chararray[k]>='a' && chararray[k]<='z') || (chararray[k] ==',') || (chararray[k]>='A' && chararray[k]<='Z')
                                 || chararray[k] == '_'){
                                    newarray[k] = chararray[k];
                                    q++;
                                 }
                             }
                             char[] faltu = new char[q];
                             for(int m= 0;m<s1.length();m++){
                                 if((newarray[m]>='a' && newarray[m]<='z') || (newarray[m] == ',') || (newarray[m]>='A' && newarray[m]<='Z' )
                                 || newarray[m] == '_'){
                                     faltu[u] = newarray[m];
                                     u++;
                                 }
                             }
                             String[] s10;
                                 s7 = String.valueOf(faltu);
                             if (s7.contains(",")) {
                                  s10 = s7.split(",", 2);
                                  sk=s10[0];
                                  ks=s10[1];;
                             }
                             else
                                 sk=s7;
            Toast.makeText(this, results.toString(), Toast.LENGTH_SHORT).show();
            //custom dialog
            final AlertDialog.Builder alert = new AlertDialog.Builder(Browse.this);
            View mview = getLayoutInflater().inflate(R.layout.customdialog,null);
            final Button bt_sk = (Button)mview.findViewById(R.id.onsk);
            final Button bt_ks = (Button)mview.findViewById(R.id.onks);
            bt_sk.setText(sk);
            bt_ks.setText(ks);
            if (ks.equals("b"))
                bt_ks.setVisibility(View.INVISIBLE);    //setting the button invisible

            alert.setView(mview);
             final AlertDialog alertDialog = alert.create();
            bt_sk.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onchecks(sk,Browse.this);
                    alertDialog.dismiss();              //Dismiss the alert dialog
                }
            });
            bt_ks.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onchecks(ks,Browse.this);

                    ks="b";
                    alertDialog.dismiss();
                }
            });
            alertDialog.show();
        }
    }
    public void onimgbrowse(View view) {
        flag=11;
        Intent gallery = new Intent();
        gallery.setType("image/*");                   //Taking the all format type of image
        gallery.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(gallery, "Sellect Picture"), PICK_IMAGE);   //choosing the image from gallery
    }
    public void onchecks(String sd,Context cc){

        if(sd.equals("DHT")) {
            Intent i = new Intent(cc, NewActivity.class);
            i.putExtra("actionBarTitle", "DHT22");    //sending the data through intent to provide the title name of intent activity
            i.putExtra("contentTv", "DHT");
            startActivity(i);
        }
        else
        if(sd.equals("MPU_Sensor")) {
            Intent i = new Intent(cc, NewActivity.class);
            i.putExtra("actionBarTitle", "MPU6050_Sensor");
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
            i.putExtra("actionBarTitle", "Arduino Mega");
            i.putExtra("contentTv", "Arduino_Mega");
            startActivity(i);
        }
        else
        if(sd.equals("Arduino_Nano")) {
            Intent i = new Intent(cc, NewActivity.class);
            i.putExtra("actionBarTitle", "Arduino Nano");
            i.putExtra("contentTv", "Arduino_Nano");
            startActivity(i);
        }
        else
        if(sd.equals("Arduino_Uno")) {
            Intent i = new Intent(cc, NewActivity.class);
            i.putExtra("actionBarTitle", "Arduino Uno");
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
        if(sd.equals("Cartridge_Fuse")) {
            Intent i = new Intent(cc, NewActivity.class);
            i.putExtra("actionBarTitle", "Cartridge-Fuse");
            i.putExtra("contentTv", "Cartridge_Fuse");
            startActivity(i);
        }
        else
        if(sd.equals("Clip_Lead")) {
            Intent i = new Intent(cc ,NewActivity.class);
            i.putExtra("actionBarTitle", "Clip-Lead");
            i.putExtra("contentTv", "Clip_Lead");
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
            i.putExtra("actionBarTitle", "Flame Sensor");
            i.putExtra("contentTv", "Flame_Sensor");
            startActivity(i);
        }
        else
        if(sd.equals("Induction_Coil")) {
            Intent i = new Intent(cc, NewActivity.class);
            i.putExtra("actionBarTitle", "Induction-Coil");
            i.putExtra("contentTv", "Induction_Coil");
            startActivity(i);
        }
        else
        if(sd.equals("IR_Sensor_Module")) {
            Intent i = new Intent(cc, NewActivity.class);
            i.putExtra("actionBarTitle", "IR Sensor Module");
            i.putExtra("contentTv", "IR_Sensor_Module");
            startActivity(i);
        }
        else
        if(sd.equals("LPG_Gas_Sensor_Module")) {
            Intent i = new Intent(cc, NewActivity.class);
            i.putExtra("actionBarTitle", "Lpg Gas Sensor Module");
            i.putExtra("contentTv", "LPG_Gas_Sensor_Module");
            startActivity(i);
        }
        else
        if(sd.equals("Memory_Chip")) {
            Intent i = new Intent(cc, NewActivity.class);
            i.putExtra("actionBarTitle", "Memory Chip");
            i.putExtra("contentTv", "Memory_Chip");
            startActivity(i);
        }
        else
        if(sd.equals("Moisture_Sensor")) {
            Intent i = new Intent(cc, NewActivity.class);
            i.putExtra("actionBarTitle", "Moisture Sensor");
            i.putExtra("contentTv", "Moisture_Sensor");
            startActivity(i);
        }
        else
        if(sd.equals("Multiplexer")) {
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
        if(sd.equals("Pulse_Generator")) {
            Intent i = new Intent(cc, NewActivity.class);
            i.putExtra("actionBarTitle", "Pulse Generator");
            i.putExtra("contentTv", "Pulse_Generator");
            startActivity(i);
        }
        else
        if(sd.equals("Raspberry_Pi")) {
            Intent i = new Intent(cc, NewActivity.class);
            i.putExtra("actionBarTitle", "Raspberry Pi");
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
            i.putExtra("actionBarTitle", "Ultrasonic Sensor");
            i.putExtra("contentTv", "Ultrasonic_Sensor");
            startActivity(i);
        }
        else
            startActivity(new Intent(cc,Explore.class));

        }
    }



