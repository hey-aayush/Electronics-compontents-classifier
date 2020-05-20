package com.saurabh.searche;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SearchView;

public class Shop extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
    }

    public void onamazon(View view) {
        Intent im = new Intent(Shop.this, Searchwebsite.class);  //intent for going to searchwebsite activity
        im.putExtra("key","amazon");         // passing the text to searchwebsite activity through putExtra method of Intent
        startActivity(im);
    }

    public void onflipkart(View view) {
        Intent im = new Intent(Shop.this, Searchwebsite.class);
        im.putExtra("key","flipkart");
        startActivity(im);
    }

    public void onrobu(View view) {
        Intent im = new Intent(Shop.this, Searchwebsite.class);
        im.putExtra("key","robu");
        startActivity(im);
    }
}
