package com.instagram_sample;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    public static final String INSTAGRAM_PACKAGE = "com.instagram.android";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                openInstagramApp();
            }
        });
    }
    public void openInstagramApp() {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("image/*");
        // String imageurl = "file:///storage/emulated/0/Android/data/com.styl.android/cach
        String imageurl = "file:///storage/emulated/0/Styl/Insta.jpg";
        i.putExtra(Intent.EXTRA_STREAM, Uri.parse(imageurl));
        i.putExtra(Intent.EXTRA_TEXT, "Hello Caption");
        i.setPackage(INSTAGRAM_PACKAGE);
        startActivity(i);
    }
}
