package com.example.sebastianchimal.alaas4;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.ViewFlipper;
import android.util.Log;


public class MainActivity extends ActionBarActivity {

    private ViewFlipper viewFlipper;
    private float lastX;
    private int noMorir = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewFlipper = (ViewFlipper)findViewById(R.id.viewflipper);
    }

    public void onClick(View view){
        Log.d("STATE",""+viewFlipper.getDisplayedChild());
        if(viewFlipper.getDisplayedChild()==15){
            TextView textView = (TextView)findViewById(R.id.texto16);
            textView.setText("Número de positivos: "+noMorir);
        }
       viewFlipper.setInAnimation(this, R.anim.slide_in_from_left);
        viewFlipper.setInAnimation(this, R.anim.slide_in_from_right);
        viewFlipper.showNext();
        noMorir+=1;
    }
    public void onClickNo(View view){
        if(viewFlipper.getDisplayedChild()==15){
            TextView textView = (TextView)findViewById(R.id.texto16);
            textView.setText("Número de aciertos: "+noMorir);
        }
        viewFlipper.setInAnimation(this,R.anim.slide_in_from_left);
        viewFlipper.setInAnimation(this,R.anim.slide_in_from_right);
        viewFlipper.showNext();
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
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
