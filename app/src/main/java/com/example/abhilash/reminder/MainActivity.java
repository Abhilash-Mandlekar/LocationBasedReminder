package com.example.abhilash.reminder;

import android.content.Intent;
import android.os.Bundle;
import android.content.ClipData;
import android.content.Context;
import android.database.DataSetObserver;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.view.ViewGroup;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;



public class MainActivity extends ActionBarActivity {

    public static ArrayList<String> reminders =new ArrayList<String>() ;
    public static String sub;
    public static String des;
    public static String loc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void addReminder(View view)
    {
        //TextView str= (TextView) findViewById(R.id.hello_text_view);
        setContentView(R.layout.reminder_ui);
    }


    public void saveReminder(View view) throws IOException {


        EditText text1 = (EditText) findViewById(R.id.subject);
        sub = text1.getText().toString();
        EditText text2 = (EditText) findViewById(R.id.description);
        des = text2.getText().toString();
        EditText text3 = (EditText) findViewById(R.id.location);
        loc = text3.getText().toString();

        startActivity(new Intent(MainActivity.this, Database.class));

    }

    public void viewReminders(View view)
    {

        startActivity(new Intent(MainActivity.this, Existing.class));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
