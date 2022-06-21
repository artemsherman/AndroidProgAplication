package com.example.androidprogaplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GameMenuLevels extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamemenulevels);
        SharedPreferences save = getSharedPreferences("Save", MODE_PRIVATE);
        final int level = save.getInt("Level", 1);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Button button_start = (Button) findViewById(R.id.buttonback);
        button_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(GameMenuLevels.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {

                }
            }
        });
        TextView textView1 = (TextView) findViewById(R.id.textView1);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level >= 1) {
                        Intent intent = new Intent(GameMenuLevels.this, Level1.class);
                        startActivity(intent);
                        finish();
                    } else {
                        //пусто
                    }
                } catch (Exception e) {

                }
            }

        });
        TextView textView2 = (TextView) findViewById(R.id.textView2);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level >= 2) {
                        Intent intent = new Intent(GameMenuLevels.this, Level2.class);
                        startActivity(intent);
                        finish();
                    } else {
                        //пусто
                    }

                } catch (Exception e) {

                }
            }

        });
        TextView textView3 = (TextView) findViewById(R.id.textView3);
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level >= 3) {
                        Intent intent = new Intent(GameMenuLevels.this, Level3.class);
                        startActivity(intent);
                        finish();
                    } else {
                        //пусто
                    }
                } catch (Exception e) {

                }
            }

        });
        TextView textView4 = (TextView) findViewById(R.id.textView4);
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level >= 4) {
                        Intent intent = new Intent(GameMenuLevels.this, Level4.class);
                        startActivity(intent);
                        finish();
                    } else {
                        //пусто
                    }
                } catch (Exception e) {

                }
            }

        });
        TextView textView5 = (TextView) findViewById(R.id.textView5);
        textView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level >= 5) {
                        Intent intent = new Intent(GameMenuLevels.this, Level5.class);
                        startActivity(intent);
                        finish();
                    } else {
                        //пусто
                    }
                } catch (Exception e) {

                }
            }

        });
        final int[] x={
        R.id.textView1,
                R.id.textView2,
                R.id.textView3,
                R.id.textView4,
                R.id.textView5,
        };
        for(int i=1;i<level;i++){
            TextView tv=findViewById(x[i]);
            tv.setText(""+(i+1));
        }

    }
}


