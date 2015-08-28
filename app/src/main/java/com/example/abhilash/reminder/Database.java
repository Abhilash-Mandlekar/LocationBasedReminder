package com.example.abhilash.reminder;

import android.app.Activity;
import android.app.Activity;
import android.app.Fragment;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;



/**
 * Created by Abhilash on 8/27/2015.
 */
public class Database extends Activity {

    ArrayList<String> Sub = new ArrayList<String>();
    ArrayList<String> Des = new ArrayList<String>();
    ArrayList<String> Loc = new ArrayList<String>();
    ArrayAdapter<String> reminderAdapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SQLiteDatabase myDB = null;
        String TableName = "myTable";

  /* Create a Database. */
        try {
            myDB = this.openOrCreateDatabase("ReminderDatabase", MODE_PRIVATE, null);

   /* Create a Table in the Database. */
            myDB.execSQL("CREATE TABLE IF NOT EXISTS "
                    + TableName
                    + " ( Subject VARCHAR , Description VARCHAR , Location VARCHAR);");


            ContentValues values = new ContentValues();
            values.put("Subject", MainActivity.sub);
            values.put("Description", MainActivity.des);
            values.put("Location", MainActivity.loc);

            myDB.insert("myTable", null, values);

   /* Insert data to a Table*/
            /*myDB.execSQL("INSERT INTO "
                    + TableName
                    + " ( Subject , Description , Location)"
                    + " VALUES ( "+ "'MainActivity.sub'" + " , " + "'MainActivity.des'" + " , " + MainActivity.loc + ");");*/

   /*retrieve data from database */
            Cursor c = myDB.rawQuery("SELECT * FROM " + TableName, null);

            int Column1 = c.getColumnIndex("Subject");
            int Column2 = c.getColumnIndex("Description");
            int Column3 = c.getColumnIndex("Location");
            // Check if our result was valid.
            c.moveToFirst();
            if (c != null) {
                // Loop through all Results
                do {
                    String subject = c.getString(Column1);
                    String desc = c.getString(Column2);
                    String location = c.getString(Column3);
                    Sub.add(subject);
                    Des.add(desc);
                    Loc.add(location);
                } while (c.moveToNext());

                List<String> weekReminder = new ArrayList<String>(Sub);


                reminderAdapter = new ArrayAdapter<String>(
                        this, // The current context (this activity)
                        R.layout.text_view_reminder, // The name of the layout ID.
                        R.id.list_txt, // The ID of the textview to populate.
                        weekReminder);

                ListView lv = new ListView(this);
                lv.setPadding(20, 20, 20, 20);
                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                        String forecast = reminderAdapter.getItem(position);
                        Toast.makeText(Database.this, forecast, Toast.LENGTH_SHORT).show();
                    }
                });

                    lv.setAdapter(reminderAdapter);
                    setContentView(lv);

            }
            } catch (Exception e) {
            Log.e("Error", "Error", e);
        } finally {
            if (myDB != null) {
                myDB.close();
                Sub.clear();
                Loc.clear();
                Des.clear();
            }
        }
    }


}




