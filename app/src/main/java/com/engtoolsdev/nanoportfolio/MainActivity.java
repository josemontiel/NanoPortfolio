package com.engtoolsdev.nanoportfolio;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final long STARTED_MILLIS = 1433390942107l;

    private View.OnClickListener buttonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(view instanceof Button){
                Button button = (Button) view;
                Toast.makeText(MainActivity.this, String.format(getResources().getString(R.string.toast_holder), button.getText().toString()), Toast.LENGTH_SHORT).show();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int daysPast = calculateDaysPast();

        TextView daysTextView = (TextView) findViewById(R.id.days_textview);
        daysTextView.setText(String.format(daysTextView.getText().toString(), daysPast));

        Button spotifyButton = (Button) findViewById(R.id.spotify_streamer_button);
        spotifyButton.setOnClickListener(buttonClickListener);

        Button scoresButton = (Button) findViewById(R.id.scores_app_button);
        scoresButton.setOnClickListener(buttonClickListener);

        Button libraryButton = (Button) findViewById(R.id.library_app_button);
        libraryButton.setOnClickListener(buttonClickListener);

        Button biggerButton = (Button) findViewById(R.id.bigger_app_button);
        biggerButton.setOnClickListener(buttonClickListener);

        Button xyzButton = (Button) findViewById(R.id.xyz_button);
        xyzButton.setOnClickListener(buttonClickListener);

        Button capstoneButton = (Button) findViewById(R.id.capstone_button);
        capstoneButton.setOnClickListener(buttonClickListener);

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

    private int calculateDaysPast() {
        long current = System.currentTimeMillis();
        long difference = current - STARTED_MILLIS;

        return (int) (difference / (1000 * 60 * 60 * 24));
    }
}
