package com.thinkvaughn.apptraining;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class trainer extends ActionBarActivity {
    EditText webviewlink;
    GPSEngine gps;
    boolean messageSent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trainer);
        webviewlink = (EditText) findViewById(R.id.webviewText);
        gps = new GPSEngine(this);
        messageSent = false;

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_trainer, menu);
        return true;
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

    public void launchTrainerWebview(View v){

        Intent intent = new Intent(this, trainerWebview.class);
        intent.putExtra("webviewlink", webviewlink.getText().toString());
        startActivity(intent);

    }
    public void showLocation(View v){
        if(gps.canGetLocation()){
            double latitude = gps.getLatitude();
            double longitude = gps.getLongitude();
            Toast t = Toast.makeText(getApplicationContext(), "Your Location is - \nLat: " + latitude + "\nLong: " + longitude, Toast.LENGTH_LONG);
            t.setGravity(Gravity.CENTER, 0, 0);
            t.show();
        }
    }

    public void callTrainer(View v){

        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:+919007748046"));
        startActivity(intent);

    }
    public void messageTrainer(View v){
        if(!messageSent){
            String number = "9007748046";
            String message = "Can you help me send a message or make a phone call please?";
            SmsManager smsManager =     SmsManager.getDefault();
            smsManager.sendTextMessage(number, null, message, null, null);
            Toast t = Toast.makeText(getApplicationContext(), "Message Sent!", Toast.LENGTH_LONG);
            t.setGravity(Gravity.CENTER, 0, 0);
            t.show();
            messageSent = true;
        }else{
            Toast t = Toast.makeText(getApplicationContext(), "You already sent the message. Please don't spam my inbox!", Toast.LENGTH_LONG);
            t.setGravity(Gravity.CENTER, 0, 0);
            t.show();
        }

    }
}
