package com.saurabh.searche;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    NavigationView navigationView;
    Toolbar toolbar;
    TextView textView;
    DrawerLayout drawerLayout;
    ImageView mainImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.nav_view);
        textView=findViewById(R.id.textView);
        toolbar= (Toolbar)findViewById(R.id.toolbars);
        setSupportActionBar(toolbar);      //setting the toolbar as action bar
        mainImage = findViewById(R.id.mainimg);

        //navigation drawer code
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle=new
                ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
       navigationView.setNavigationItemSelectedListener(this);
       //set home screen by default
        navigationView.setCheckedItem(R.id.nav_home);

    }
    public void onclick(View view) {
        //going to camera on clicking
        startActivity(new Intent(MainActivity.this,Camera.class));
    }
    //closing the navigationn screen on pressing back key
    @Override
    public void onBackPressed(){
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else
        {super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_home:
                break;
            case R.id.nav_share:                //For sharing the app
                Intent shareintent = new Intent();
                shareintent.setAction(Intent.ACTION_SEND);
                shareintent.putExtra(Intent.EXTRA_TEXT,"https://play.google.com/store/apps/details?id=com.saurabh.searche");
                shareintent.setType("text/plain");
                startActivity(Intent.createChooser(shareintent,"share via"));
                break;
            case R.id.nav_rate:         //For giving the rate to our app
                try{
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://play.google.com/store/apps/details?id=com.saurabh.searche")));
                }catch (ActivityNotFoundException e){
                    startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://play.google.com/store/apps/details?id=com.saurabh.socialdistancing")));
                }
                break;
            case R.id.nav_logout:
                startActivity(new Intent(MainActivity.this,Login.class));
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
    public void onbrowse(View view) {
        startActivity(new Intent(MainActivity.this,Browse.class));   //intent to browse class

    }
    public void onprofile(View view) {
        startActivity(new Intent(MainActivity.this,Header.class));    //intent to header class where you can see the profile

    }

    public void onExplore(View view) {
        startActivity(new Intent(MainActivity.this,Explore.class));
    }

    public void onChat(View view) {
        startActivity(new Intent(MainActivity.this,Shop.class));   //intent to shop class
    }
}
