package com.example.svinc.guessinggame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class SecondaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);

        Button btn = (Button) findViewById(R.id.save_values);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondaryActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });



        SeekBar seekBarMax;
        seekBarMax = (SeekBar)findViewById(R.id.seekbar_max);
        seekBarMax.setProgress(0);
        seekBarMax.incrementProgressBy(10);
        seekBarMax.setMax(200);
        final TextView seekBarValueMax = (TextView)findViewById(R.id.max_value);
        seekBarValueMax.setText(seekBarValueMax.getText().toString().trim());

        seekBarMax.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progress = progress / 10;
                progress = progress * 10;
                seekBarValueMax.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        SeekBar seekBarMin;
        seekBarMin = (SeekBar)findViewById(R.id.seekbar_min);
        seekBarMin.setProgress(0);
        seekBarMin.incrementProgressBy(10);
        seekBarMin.setMax(200);
        final TextView seekBarValueMin = (TextView)findViewById(R.id.min_value);
        seekBarValueMin.setText(seekBarValueMin.getText().toString().trim());

        seekBarMin.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progress = progress / 10;
                progress = progress * 10;
                seekBarValueMin.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
