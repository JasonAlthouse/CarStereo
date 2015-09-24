package cs301.carstereo;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    boolean power = true;
    String amfm = "FM";
    int station = 880;
    int ampreset1 = 550;
    int ampreset2 = 600;
    int ampreset3 = 650;
    int ampreset4 = 700;
    int ampreset5 = 750;
    int ampreset6 = 800;
    int ampreset7 = 1430;
    int fmpreset1 = 909;
    int fmpreset2 = 929;
    int fmpreset3 = 949;
    int fmpreset4 = 969;
    int fmpreset5 = 989;
    int fmpreset6 = 1009;
    int fmpreset7 = 1011;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.Preset1).setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (amfm.equals("FM"))
                    fmpreset1 = station;
                else
                    ampreset1 = station;
                return false;
            }
        });

        findViewById(R.id.Preset2).setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (amfm.equals("FM"))
                    fmpreset2 = station;
                else
                    ampreset2 = station;
                return false;
            }
        });

        findViewById(R.id.Preset3).setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (amfm.equals("FM"))
                    fmpreset3 = station;
                else
                    ampreset3 = station;
                return false;
            }
        });

        findViewById(R.id.Preset4).setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (amfm.equals("FM"))
                    fmpreset4 = station;
                else
                    ampreset4 = station;
                return false;
            }
        });

        findViewById(R.id.Preset5).setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (amfm.equals("FM"))
                    fmpreset5 = station;
                else
                    ampreset5 = station;
                return false;
            }
        });

        findViewById(R.id.Preset6).setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (amfm.equals("FM"))
                    fmpreset6 = station;
                else
                    ampreset6 = station;
                return false;
            }
        });

        findViewById(R.id.Preset7).setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (amfm.equals("FM"))
                    fmpreset7 = station;
                else
                    ampreset7 = station;
                return false;
            }
        });









    }


    public void tuner(View view)
    {
            if (view == findViewById(R.id.amfm))
            {
                if (amfm.equals("AM"))
                {
                    amfm = "FM";
                    station = 881;
                }
                else
                {
                    amfm = "AM";
                    station = 530;
                }
            }
            if (view == findViewById(R.id.TunnerPlus))
            {
                if(amfm.equals("FM"))
                {
                    station = station+2;
                    if(station > 1079)
                    {
                        station = 881;
                    }
                }
                else
                {
                    station = station+10;
                    if(station > 1700)
                    {
                        station = 530;
                    }
                }
            }
            if (view == findViewById(R.id.TunnerMinus))
            {
                if(amfm.equals("FM"))
                {
                    station = station-2;
                    if(station < 881)
                    {
                        station = 1079;
                    }
                }
                else
                {
                    station = station-10;
                    if(station < 530)
                    {
                        station = 1700;
                    }
                }
            }
        onScreen(amfm, station);
    }

    public void presets(View view) {
        if (amfm.equals("FM")) {
            if (view == findViewById(R.id.Preset1))
                station = fmpreset1;
            if (view == findViewById(R.id.Preset2))
                station = fmpreset2;
            if (view == findViewById(R.id.Preset3))
                station = fmpreset3;
            if (view == findViewById(R.id.Preset4))
                station = fmpreset4;
            if (view == findViewById(R.id.Preset5))
                station = fmpreset5;
            if (view == findViewById(R.id.Preset6))
                station = fmpreset6;
            if (view == findViewById(R.id.Preset7))
                station = fmpreset7;
        } else {
            if (view == findViewById(R.id.Preset1))
                station = ampreset1;
            if (view == findViewById(R.id.Preset2))
                station = ampreset2;
            if (view == findViewById(R.id.Preset3))
                station = ampreset3;
            if (view == findViewById(R.id.Preset4))
                station = ampreset4;
            if (view == findViewById(R.id.Preset5))
                station = ampreset5;
            if (view == findViewById(R.id.Preset6))
                station = ampreset6;
            if (view == findViewById(R.id.Preset7))
                station = ampreset7;
        }
        onScreen(amfm, station);
    }

    public void onScreen(String initAmfm, int initStation)
    {
        if(power == false) {
            TextView textbg = (TextView) findViewById(R.id.DisplayScreen);
            if (initAmfm.equals("FM")) {
                double fmStation = (double) initStation / 10;
                textbg.setText(fmStation + " " + initAmfm);
            } else {
                textbg.setText(initStation + initAmfm);
            }
        }
    }

    public void togglePower(View view)
    {
        if(power == false)
        {



           LinearLayout background = (LinearLayout) findViewById(R.id.mainBackground);
           background.setBackgroundColor(Color.DKGRAY);
            TextView textbg = (TextView) findViewById(R.id.DisplayScreen);
            textbg.setBackgroundColor(Color.GRAY);
            textbg.setTextColor(Color.BLACK);
            textbg.setText("Goodbye...");
            Button powerBtn = (Button) findViewById(R.id.PowerButton);
            powerBtn.setBackgroundColor(Color.RED);
            power = true;
        }
        else
        {
            LinearLayout background = (LinearLayout)findViewById(R.id.mainBackground);
            background.setBackgroundColor(Color.BLUE);
            TextView textbg = (TextView) findViewById(R.id.DisplayScreen);
            textbg.setBackgroundColor(Color.LTGRAY);
            textbg.setTextColor(Color.WHITE);
            textbg.setText("Welcome To Radio");
            Button powerBtn = (Button) findViewById(R.id.PowerButton);
            powerBtn.setBackgroundColor(Color.GREEN);
            power = false;
        }

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
