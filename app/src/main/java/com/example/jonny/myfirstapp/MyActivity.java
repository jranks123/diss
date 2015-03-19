package com.example.jonny.myfirstapp;



import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.support.v7.app.ActionBarActivity;
import java.io.*;
import android.app.Activity;
import android.os.Bundle;
import android.view.*;
import android.view.View.OnClickListener;
import android.widget.*;


public class MyActivity extends ActionBarActivity{

    public final static String EXTRA_MESSAGE = "com.example.jonny.myfirstapp.MESSAGE";

    // GUI controls
    EditText txtData;
    Button btnWriteSDFile;
    Button btnReadSDFile;
    Button btnClearScreen;
    Button btnClose;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        // bind GUI elements with local controls
        txtData = (EditText) findViewById(R.id.txtData);
        txtData.setHint("Enter some lines of data here...");

        btnWriteSDFile = (Button) findViewById(R.id.btnWriteSDFile);
        btnWriteSDFile.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                // write on SD card file data in the text box
                try {
                    File myFile = new File("/sdcard/mysdfile.py");
                    myFile.createNewFile();
                    FileOutputStream fOut = new FileOutputStream(myFile);
                    OutputStreamWriter myOutWriter =
                            new OutputStreamWriter(fOut);
                    myOutWriter.append(txtData.getText());
                    myOutWriter.close();
                    fOut.close();
                    Toast.makeText(getBaseContext(),
                            "Done writing SD 'mysdfile.py'",
                            Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(getBaseContext(), e.getMessage(),
                            Toast.LENGTH_SHORT).show();
                }
            }// onClick
        }); // btnWriteSDFile

        btnReadSDFile = (Button) findViewById(R.id.btnReadSDFile);
        btnReadSDFile.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                // write on SD card file data in the text box
                try {
                    File myFile = new File("/sdcard/mysdfile.py");
                    FileInputStream fIn = new FileInputStream(myFile);
                    BufferedReader myReader = new BufferedReader(
                            new InputStreamReader(fIn));
                    String aDataRow = "";
                    String aBuffer = "";
                    while ((aDataRow = myReader.readLine()) != null) {
                        aBuffer += aDataRow + "\n";
                    }
                    txtData.setText(aBuffer);
                    myReader.close();
                    Toast.makeText(getBaseContext(),
                            "Done reading SD 'mysdfile.py'",
                            Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(getBaseContext(), e.getMessage(),
                            Toast.LENGTH_SHORT).show();
                }
            }// onClick
        }); // btnReadSDFile

        btnClearScreen = (Button) findViewById(R.id.btnClearScreen);
        btnClearScreen.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                // clear text box
                txtData.setText("");
            }
        }); // btnClearScreen

        btnClose = (Button) findViewById(R.id.btnClose);
        btnClose.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                // clear text box
                finish();
            }
        }); // btnClose

    }

        /**Called when the user clicks the Send button */
        public void sendMessage(View view){
            //Do something in response to the button
            Intent intent = new Intent(this, DisplayMessageActivity.class);
            EditText editText = (EditText) findViewById(R.id.txtData);
            String message = editText.getText().toString();
            intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);
        }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_activity_actions, menu);
        return super.onCreateOptionsMenu(menu);
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
