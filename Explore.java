package com.saurabh.searche;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.icu.text.CaseMap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Explore extends AppCompatActivity {
    /*ListView listview;
    String[] nameIndia = {"saurabh", "Sushil", "Vishal", "Atul", "Khushi", "Alok", "Khush"};
    //ArrayAdapter<String> arrayAdapter;
    MyAdapter adapter;

   // ListView mylistView;
    String mTitle[] = {"Facebook", "Whatsapp", "Twitter", "Instagram", "Youtube"};
    String mDescription[] = {"Facebook Description", "Whatsapp Description", "Twitter Description", "Instagram Description", "Youtube Description"};
    int images[] = {R.drawable.profile, R.drawable.problem, R.drawable.profiles, R.drawable.search, R.drawable.chats};

*/
    Context hello;
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
        hello = getApplicationContext();
     //  listview = (ListView) findViewById(R.id.listView);
        Toolbar toolbars = (Toolbar) findViewById(R.id.toolbarss);
        setSupportActionBar(toolbars);
        title = new String[]{"LED", "Transistor", "Armature", "Arduino", "Water Sensor"};
        description = new String[]{"LED detail...", "Transistor detail...", "Armature detail...", "Arduino detail...", "Water Sensor detail..."};
        icon = new int[]{R.drawable.profiles, R.drawable.e, R.drawable.search, R.drawable.profile, R.drawable.problem};

        listView = findViewById(R.id.listView);

        for (int i =0; i<title.length; i++){
            Model model = new Model(title[i], description[i], icon[i]);
            //bind all strings in an array
            arrayList.add(model);
        }

        //pass results to listViewAdapter class
        adapter = new ListViewAdapter(hello, arrayList);

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
                    listView.clearTextFilter();
                }
                else {
                    adapter.filter(s);
                }
                return true;
            }
        });
        return true;
    }

/*    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id==R.id.action_settings){
            //do your functionality here
            return true;
        }
        return super.onOptionsItemSelected(item);
    }*/
}
     /*   //arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,nameIndia,);
         adapter = new MyAdapter(this, mTitle, mDescription, images);
        mylistview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Toast.makeText(Explore.this, "Facebook Description", Toast.LENGTH_SHORT).show();
                }
                if (position == 1) {
                    Toast.makeText(Explore.this, "Whatsapp Description", Toast.LENGTH_SHORT).show();
                }
                if (position == 2) {
                    Toast.makeText(Explore.this, "Twitter Description", Toast.LENGTH_SHORT).show();
                }
                if (position == 3) {
                    Toast.makeText(Explore.this, "Instagram Description", Toast.LENGTH_SHORT).show();
                }
                if (position == 4) {
                    Toast.makeText(Explore.this, "Youtube Description", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String rTitle[];
        String rDescription[];
        int rImgs[];

        MyAdapter(Context c, String title[], String description[], int imgs[]) {
            super(c, R.layout.row, R.id.textView1, title);
            this.context = c;
            this.rTitle = title;
            this.rDescription = description;
            this.rImgs = imgs;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            ImageView images = row.findViewById(R.id.image);
            TextView myTitle = row.findViewById(R.id.textView1);
            TextView myDescription = row.findViewById(R.id.textView2);

            // now set our resources on views
            images.setImageResource(rImgs[position]);
            myTitle.setText(rTitle[position]);
            myDescription.setText(rDescription[position]);


            return row;
        }
    }


    public void onclick(View view) {
        Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show();
    }

   @Override
    public boolean onCreateOptionsMenu( Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_search_menu,menu);

        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView)menuItem.getActionView();
        searchView.setQueryHint("Search here");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                adapter.getFilter().filter(newText);
                return true;
            }
        });
        return super.onCreateOptionsMenu(menu);

}
}
*/
