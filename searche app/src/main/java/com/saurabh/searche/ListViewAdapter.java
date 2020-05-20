package com.saurabh.searche;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ListViewAdapter extends BaseAdapter{

    //variables
    Context mContext;
    LayoutInflater inflater;
    List<Model> modellist;
    ArrayList<Model> arrayList;

    //constructor
    public ListViewAdapter(Context context, List<Model> modellist) {
        mContext = context;
        this.modellist = modellist;
        inflater = LayoutInflater.from(mContext);
        this.arrayList = new ArrayList<Model>();
        this.arrayList.addAll(modellist);
    }

    public class ViewHolder{
        TextView mTitleTv, mDescTv;
        ImageView mIconIv;
    }

    @Override
    public int getCount() {
        return modellist.size();
    }

    @Override
    public Object getItem(int i) {
        return modellist.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int postition, View view, ViewGroup parent) {
        ViewHolder holder;
        if (view==null){
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.row, null);

            //locate the views in row.xml
            holder.mTitleTv = view.findViewById(R.id.textView1);
            holder.mDescTv = view.findViewById(R.id.textView2);
            holder.mIconIv = view.findViewById(R.id.image);

            view.setTag(holder);

        }
        else {
            holder = (ViewHolder)view.getTag();
        }
        //set the results into textviews
        holder.mTitleTv.setText(modellist.get(postition).getTitle());
        holder.mDescTv.setText(modellist.get(postition).getDesc());
        //set the result in imageview
        holder.mIconIv.setImageResource(modellist.get(postition).getIcon());

        //listview item clicks
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //code later
                if (modellist.get(postition).getTitle().equals("Arduino Mega")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Arduino Mega");
                    intent.putExtra("contentTv", "Arduino_Mega");
                    mContext.startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("Camera")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Camera");
                    intent.putExtra("contentTv", "Camera");
                    mContext.startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("Cartridge-Fuse")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Cartridge-Fuse");
                    intent.putExtra("contentTv", "Cartridge_Fuse");
                    mContext.startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("Buzzer")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Buzzer");
                    intent.putExtra("contentTv", "Buzzer");
                    mContext.startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("Moisture Senosr")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Moisture Sensor");
                    intent.putExtra("contentTv", "Moisture_Sensor");
                    mContext.startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("Ultrasonic Sensor")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Ultrasonic Sensor");
                    intent.putExtra("contentTv", "Ultrasonic_Sensor");
                    mContext.startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("Transistor")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Transistor");
                    intent.putExtra("contentTv", "Transistor");
                    mContext.startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("Stabilizer")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Stabilizer");
                    intent.putExtra("contentTv", "Stabilizer");
                    mContext.startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("Shunt")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Shunt");
                    intent.putExtra("contentTv", "Shunt");
                    mContext.startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("Relay")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Relay");
                    intent.putExtra("contentTv", "Relay");
                    mContext.startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("Raspberry Pi")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Raspberry Pi");
                    intent.putExtra("contentTv", "Raspberry_Pi");
                    mContext.startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("Pulse Generator")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Pulse Generator");
                    intent.putExtra("contentTv", "Pulse_Generator");
                    mContext.startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("Potentiometer")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Potentiometer");
                    intent.putExtra("contentTv", "Potentiometer");
                    mContext.startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("Multiplexer")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Multiplexer");
                    intent.putExtra("contentTv", "Multiplexer.");
                    mContext.startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("MPU6060 Sensor")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "MPU6060 Sensor");
                    intent.putExtra("contentTv", "MPU_Sensor");
                    mContext.startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("Memory Chip")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Memory Chip");
                    intent.putExtra("contentTv", "Memory_Chip");
                    mContext.startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("LPG gas sensor Module")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "LPG gas sensor Module");
                    intent.putExtra("contentTv", "LPG_Gas_Sensor_Module");
                    mContext.startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("LED")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "LED");
                    intent.putExtra("contentTv", "LED");
                    mContext.startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("IR Sensor Module")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "IR Sensor Module");
                    intent.putExtra("contentTv", "IR_Sensor_Module");
                    mContext.startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("Induction-Coil")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Induction Coil");
                    intent.putExtra("contentTv", "Induction_Coil");
                    mContext.startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("Flame Sensor")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Flame Sensor");
                    intent.putExtra("contentTv", "Flame_Sensor");
                    mContext.startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("Filament")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Filament");
                    intent.putExtra("contentTv", "Filamen");
                    mContext.startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("DHT-22")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "DHT-22");
                    intent.putExtra("contentTv", "DHT");
                    mContext.startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("Clip-Lead")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Clip-Lead");
                    intent.putExtra("contentTv", "Clip-Lead.");
                    mContext.startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("Arduino Nano")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Arduino Nano");
                    intent.putExtra("contentTv", "Arduino_Nano");
                    mContext.startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("Arduino Uno")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Arduino Uno");
                    intent.putExtra("contentTv", "Arduino_Uno");
                    mContext.startActivity(intent);
                }

            }
        });


        return view;
    }

    //filter
    public void filter(String charText){
        charText = charText.toLowerCase(Locale.getDefault());  //converting into lowercase
        modellist.clear();
        if (charText.length()==0){
            modellist.addAll(arrayList);    //if search bar is empty showing the whole list
        }
        else {
            for (Model model : arrayList){
                if (model.getTitle().toLowerCase(Locale.getDefault())
                        .contains(charText)){
                    modellist.add(model);       //adding the model in modellst which contain that text
                }
            }
        }
        notifyDataSetChanged();
    }

}
