package com.thinkvaughn.apptraining;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class activityLifeCycle extends ActionBarActivity {
    public Helper h;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_life_cycle);
        h = new Helper();
        Toast t = Toast.makeText(getApplicationContext(), "Activity onCreate("+h.getTimeInMilli()+");", Toast.LENGTH_SHORT);
        t.setGravity(Gravity.TOP|Gravity.LEFT, 50, 160);
        t.show();
    }
    @Override
    protected void onStart(){
        super.onStart();
        Toast t = Toast.makeText(getApplicationContext(), "Activity onStart("+h.getTimeInMilli()+");", Toast.LENGTH_SHORT);
        t.setGravity(Gravity.TOP|Gravity.LEFT, 50, 250);
        t.show();
    }
    @Override
    protected void onResume(){
        super.onResume();
        Toast t = Toast.makeText(getApplicationContext(), "Activity onResume("+h.getTimeInMilli()+");", Toast.LENGTH_SHORT);
        t.setGravity(Gravity.TOP|Gravity.LEFT, 50, 400);
        t.show();
    }
    @Override
    protected void onPause(){
        super.onPause();
        Toast t = Toast.makeText(getApplicationContext(), "Activity onPause("+h.getTimeInMilli()+");", Toast.LENGTH_SHORT);
        t.setGravity(Gravity.TOP|Gravity.LEFT, 50, 750);
        t.show();
    }
    @Override
    protected void onStop(){
        super.onStop();
        Toast t = Toast.makeText(getApplicationContext(), "Activity onStop("+h.getTimeInMilli()+");", Toast.LENGTH_SHORT);
        t.setGravity(Gravity.TOP|Gravity.LEFT, 50, 850);
        t.show();
    }
    @Override
    protected  void onRestart(){
        super.onRestart();
        Toast t = Toast.makeText(getApplicationContext(), "Activity onRestart("+h.getTimeInMilli()+");", Toast.LENGTH_SHORT);
        t.setGravity(Gravity.TOP|Gravity.LEFT, 200, 250);

        t.show();
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Toast t = Toast.makeText(getApplicationContext(), "Activity onDestroy("+h.getTimeInMilli()+");", Toast.LENGTH_SHORT);
        t.setGravity(Gravity.TOP|Gravity.LEFT, 50, 950);
        t.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_life_cycle, menu);
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
}
