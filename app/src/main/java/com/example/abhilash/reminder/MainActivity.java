package com.example.abhilash.reminder;

import android.os.Bundle;
import android.content.ClipData;
import android.content.Context;
import android.database.DataSetObserver;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;



public class MainActivity extends ActionBarActivity {

    public static ArrayList<String> reminders =new ArrayList<String>() ;
    public static String sub;

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

    public void saveReminder(View view)
    {
        EditText text = (EditText) findViewById(R.id.subject);
        sub = text.getText().toString();
        reminders.add(sub);
        /*//setContentView(R.layout.text_view_reminder);
        ArrayAdapter rem = new ArrayAdapter<String>(this,R.layout.text_view_reminder, R.id.list_item,reminders);
        ListView lv = (ListView) findViewById(R.id.list_item);
        lv.setAdapter( rem);*/
        setContentView(R.layout.dummy_layout);
        getFragmentManager().beginTransaction()
                .add(R.id.container,new ListReminder())
                .commit();
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
