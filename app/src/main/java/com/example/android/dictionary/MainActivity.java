package com.example.android.dictionary;

import android.app.AlertDialog;
import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private static final int WORD_LOADER=0;
    public static ArrayList<HashMap<String, String>> arr = new ArrayList<HashMap<String, String>>();
    EditText search;
    ListView lv;
    Button b;
    newCursorAdapter mCursorAdapter;
    ArrayList<Word> wordList;
    SimpleAdapter simpleAdapter;
    WordAdapter itemAdapter;
    ClassNode node;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.add);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,AddWord.class);
                startActivity(intent);
            }
        });

        search=(EditText)findViewById(R.id.search);
        lv=(ListView)findViewById(R.id.list);
        b = (Button) findViewById(R.id.button_search);


        DataBaseHandler dataBaseHandler = new DataBaseHandler(this);
        wordList = dataBaseHandler.getAllWords();

        node = new ClassNode();
        for (int i = 0; i < wordList.size(); i++) {
            Word w = wordList.get(i);
            String word = w.getWord();
            String mean = w.getMean();
            node.put(word, mean);
        }

        itemAdapter = new WordAdapter(MainActivity.this, 0, wordList);
        lv.setAdapter(itemAdapter);

      /* mCursorAdapter=new newCursorAdapter(this,null);
        lv.setAdapter(mCursorAdapter);*/


      /* DataBaseHandler db=new DataBaseHandler(MainActivity.this);
        wordList=db.getAllWords();

       int i=0;
        for(i=0;i<wordList.size();i++)
        {
            Word word=wordList.get(i);
            HashMap<String,String> list=new HashMap<String,String>();
            list.put("Id",String.valueOf(word.getId()));
            list.put("Word", word.getWord());
            list.put("Meaning",word.getMean());
            arr.add(list);
        }

        simpleAdapter=new SimpleAdapter(getApplicationContext(),arr,R.layout.list_item,new String[]{"Word"},new int[]{R.id.name});
        lv.setAdapter(simpleAdapter);*/




       /* search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                MainActivity.this.simpleAdapter.getFilter().filter(charSequence);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                MainActivity.this.simpleAdapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });*/

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long rowId) {


                AlertDialog.Builder adb = new AlertDialog.Builder(
                        MainActivity.this);

                // String str= parent.getItemAtPosition(position).toString();

                //jhjhjhjhjhjhjhjhjhjhjhjhj
                int j, k;
                j = 10;
               /* Cursor cursor = (Cursor) parent.getItemAtPosition(position);
                int wordColumnIndex = cursor.getColumnIndex(DataBaseHandler.COLUMN_WORD);
                int meanColumnIndex = cursor.getColumnIndex(DataBaseHandler.COLUMN_MEANING);

                String word = cursor.getString(wordColumnIndex);
                String meaning = cursor.getString(meanColumnIndex);*/
                Word word = wordList.get(position);
                String w = word.getWord() + " " + word.getMean() + " " + word.getId();


                String str = w;
               /* HashMap<String,String> word=new HashMap<String, String>();
                word=arr.get(position);*/


                adb.setTitle("Her You Go!!");
                adb.setMessage(" Word - Meaning \n"
                        + str);
                adb.setPositiveButton("Ok", null);
                adb.show();

            }

        });


        // getLoaderManager().initLoader(WORD_LOADER, null, this);



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {


            //noinspection SimplifiableIfStatement
            case R.id.action_settings:
                return true;
            case R.id.action_delete_all_entries:
                deleteAllWords();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void deleteAllWords() {
        int rowsDeleted = getContentResolver().delete(DataProvider.CONTENT_URI, null, null);
        Log.v("MainActivity", rowsDeleted + " rows deleted from word database");
        // itemAdapter.notifyDataSetChanged();
    }




  /*  @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {

        String [] projection ={
                DataBaseHandler._ID,
                DataBaseHandler.COLUMN_WORD,
                DataBaseHandler.COLUMN_MEANING
        };
        return new CursorLoader(this,DataProvider.CONTENT_URI,projection,null,null,null);

    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        mCursorAdapter.swapCursor(cursor);

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        mCursorAdapter.swapCursor(null);

    }*/


    public void word_search(View v){
        String s = search.getText().toString();

        String t = node.contains(s);
        Log.v("MainActivity: ", t);
    }



}
