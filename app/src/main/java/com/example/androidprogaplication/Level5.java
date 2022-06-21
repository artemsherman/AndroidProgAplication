package com.example.androidprogaplication;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;

public class Level5 extends AppCompatActivity {
    int number1,number2,number3,sum;
    Dialog dialog;
    ArrayList<Integer>answers=new ArrayList<>();
    TextView tv_num1,tv_num2,tv_num3;
    Button btnAnswer0,btnAnswer1,btnAnswer2,btnAnswer3;
    public int count=0;
    final int[] progress={
            R.id.point1,R.id.point2,R.id.point3,R.id.point4,R.id.point5,R.id.point6,R.id.point7,R.id.point8,
            R.id.point9,R.id.point10,R.id.point11,R.id.point12,R.id.point13,R.id.point14,R.id.point15,
    };
    public void ChooseAnswer(View view) {
        int answer= Integer.parseInt(view.getTag().toString());

        if(answers.get(answer)==(number1*(number2+number3))) {
            if(count<15){
                count=count+1;
            }
            for(int i=0;i<15;i++){
                TextView tv=findViewById(progress[i]);
                tv.setBackgroundResource(R.drawable.style_points);
            }
            for(int i=0;i<count;i++){
                TextView tv=findViewById(progress[i]);
                tv.setBackgroundResource(R.drawable.style_orange);

            }
            makeQuestionAnswer();
        }else{
            if(count>0){
                if(count==1){
                    count=0;
                }else{
                    count=count-2;

                }
            }
            for(int i=0;i<14;i++){
                TextView tv=findViewById(progress[i]);
                tv.setBackgroundResource(R.drawable.style_points);
            }
            for(int i=0;i<count;i++){
                TextView tv=findViewById(progress[i]);
                tv.setBackgroundResource(R.drawable.style_orange);

            }
        }
        if(count==15){
            SharedPreferences save =getSharedPreferences("Save",MODE_PRIVATE);
            final int level=save.getInt("level",1);

            if(level>4){
                //пусто
            }else{
                SharedPreferences.Editor editor=save.edit();
                editor.putInt("level",5);
                editor.apply();
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal5);
        Button button_start = (Button) findViewById(R.id.button_back);
        button_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Level5.this, GameMenuLevels.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {

                }
            }
        });

        TextView text_levels=(TextView)findViewById(R.id.text_levels);
        text_levels.setText(R.string.level5);
        Window w =getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        btnAnswer0=findViewById(R.id.btnAnswer0);
        btnAnswer1=findViewById(R.id.btnAnswer1);
        btnAnswer2=findViewById(R.id.btnAnswer2);
        btnAnswer3=findViewById(R.id.btnAnswer3);
        tv_num1=findViewById(R.id.tv_num1);
        tv_num2=findViewById(R.id.tv_num2);
        tv_num3=findViewById(R.id.tv_num3);
        Random rand =new Random();
        number1=rand.nextInt(9);
        number2=rand.nextInt(9);
        number3= rand.nextInt(9);
        if(number1==0){
            number1=rand.nextInt(9);
        }
        if(number2==0){
            number2=rand.nextInt(9);
        }
        if(number3==0){
            number3=rand.nextInt(9);
        }

        tv_num1.setText(""+number1);
        tv_num2.setText(""+number2);
        tv_num3.setText(""+number3);

        int correctPosition= rand.nextInt(4);
        for(int i=0;i<4;i++){
            if(i==correctPosition){
                answers.add(i,number1*(number2+number3));
            }
          else
            {
                int otherPosition= rand.nextInt(81);
                while (otherPosition==(number1*(number2+number3))){
                    otherPosition=rand.nextInt(81);
                }
                answers.add(i,otherPosition);
                //dialog= new Dialog(this);
               // dialog.show();
            }
        }
        btnAnswer0.setText(Integer.toString(answers.get(0)));
        btnAnswer1.setText(Integer.toString(answers.get(1)));
        btnAnswer2.setText(Integer.toString(answers.get(2)));
        btnAnswer3.setText(Integer.toString(answers.get(3)));
        Button button_back =(Button)findViewById(R.id.button_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent =new Intent(Level5.this, GameMenuLevels.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }
            }
        });

    }

    public void makeQuestionAnswer(){
        Random rand =new Random();
        number1=rand.nextInt(9);
        number2=rand.nextInt(9);
        number3=rand.nextInt(9);
        if(number1==0){
            number1=rand.nextInt(9);
        }
        if(number2==0){
            number2=rand.nextInt(9);
        }
        if(number3==0){
            number3=rand.nextInt(9);
        }
        tv_num1.setText(""+number1);
        tv_num2.setText(""+number2);
        tv_num3.setText(""+number3);
        int correctPosition= rand.nextInt(4);
        for(int i=0;i<4;i++){
            if(i==correctPosition){
                answers.add(i,number1*(number2+number3));

            }else{

                int otherPosition= rand.nextInt(81);
                while (otherPosition==number1*(number2+number3)){
                    otherPosition=rand.nextInt(81);
                }
                answers.add(i,otherPosition);
            }
        }
        btnAnswer0.setText(Integer.toString(answers.get(0)));
        btnAnswer1.setText(Integer.toString(answers.get(1)));
        btnAnswer2.setText(Integer.toString(answers.get(2)));
        btnAnswer3.setText(Integer.toString(answers.get(3)));

    }

}