package com.saurabh.searche;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SearchView;
import java.util.ArrayList;

public class Explore extends AppCompatActivity {

    ListView listView;
    ListViewAdapter adapter;
    String[] title;
    String[] description;
    int[] icon;
    ArrayList<Model> arrayList = new ArrayList<Model>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore);
        Toolbar toolbars = (Toolbar) findViewById(R.id.toolbarss);
        setSupportActionBar(toolbars);       //setting the toolbar as action bar
        //taking the names of electronic components in string array
        title = new String[]{"Arduino Mega", "Camera", "Cartridge-Fuse", "Buzzer", "Moisture Senosr","Ultrasonic Sensor", "Transistor",
        "Stabilizer", "Shunt", "Relay","Raspberry Pi", "Pulse Generator", "Potentiometer", "Multiplexer", "MPU6060 Sensor", "Memory Chip",
        "LPG gas sensor Module","LED","IR Sensor Module", "Induction Coil", "Flame Sensor", "Filament", "DHT-22", "Clip-Lead","Arduino Nano",
        "Arduino Uno"};
        //taking the description of elcetronic components
        description = new String[]{"Arduino Mega detail...", "Camera detail...", "Cartridge-Fuse detail...", "Buzzer detail..."
                , "Moisture Sensor detail...", "Ultrasonic Sensor detail...", "Transistor detail..." , "Stabilizer detail...",
        "Shunt detail...", "Relay detail...", "Raspberry Pi detail...", "Pulse Generator detail...", "Potentiometer detail...",
                "Multiplexer detail...", "MPU6060 Sensor detail...", "Memory Chip detail...", "LPG gas sensor Module detail...",
                "LED detail...", "IR Sensor Module detail...", "Induction Coil detail...", "\"Flame SensorD detail...", "Filament detail...",
                "LED detail...", "LED detail...",
                "DHT-22 detail...", "Clip-Lead detail...", "Arduino Nano detail...", "Arduino Uno detail...",};
        //taking the image in an int array for custom list
        icon = new int[]{R.drawable.arduinomega, R.drawable.camera, R.drawable.cartridgefuse, R.drawable.buzzer, R.drawable.moisture,
                R.drawable.ultrasonic,R.drawable.transistor,R.drawable.stabilizer,R.drawable.shunt,R.drawable.relay,R.drawable.raspberry
        ,R.drawable.pulsegenerator,R.drawable.potentiometer,R.drawable.multiplexer,R.drawable.mpu,R.drawable.memory,R.drawable.lpg,
        R.drawable.led,R.drawable.ir,R.drawable.induction,R.drawable.flame,R.drawable.filament,R.drawable.dht,R.drawable.clip,
        R.drawable.arduinonano,R.drawable.arduinouno};

        listView = findViewById(R.id.listView);

        for (int i =0; i<title.length; i++){
            Model model = new Model(title[i], description[i], icon[i]);
            //bind all strings in an array
            arrayList.add(model);  //Adding all the array data combinely in an arraylist respecively
        }

        //pass results to listViewAdapter class
        adapter = new ListViewAdapter(Explore.this, arrayList);

        //bind the adapter to the listview
        listView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_search_menu,menu);

        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView)menuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                if (TextUtils.isEmpty(s)){
                    adapter.filter("");
                    listView.clearTextFilter();   //for on removing all the text from search bar to show whole list
                }
                else {
                    adapter.filter(s);    //filter the list data according to text written is search bar
                }
                return true;
            }
        });
        return true;
    }


}
