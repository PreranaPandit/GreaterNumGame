package com.example.greaternumgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnFirstNum, btnSecondNum;
    TextView tvTotalScore;
    int firstNum, secondNum, totalScore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Binding
        btnFirstNum = findViewById(R.id.btnFirstNum);
        btnSecondNum = findViewById(R.id.btnSecondNum);
        tvTotalScore = findViewById(R.id.tvTotalSore);
        btnFirstNum.setOnClickListener(this);
        btnSecondNum.setOnClickListener(this);
        getRandomNumber();
    }


        public void getRandomNumber()
        {
            final Random randomNum = new Random();

            firstNum = randomNum.nextInt(100);
            secondNum = randomNum.nextInt(100);

            btnFirstNum.setText(Integer.toString(firstNum));
            btnSecondNum.setText(Integer.toString(secondNum));
        }


    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.btnFirstNum:
                if(firstNum > secondNum){
                    totalScore+=1;
                }else if(firstNum<secondNum){
                    totalScore-=1;
                }
                getRandomNumber();
                greateNumWinner();
                break;

            case R.id.btnSecondNum:
                if(secondNum < firstNum){
                    totalScore-=1;
                }else if(secondNum>firstNum){
                    totalScore+=1;
                }
                getRandomNumber();
                greateNumWinner();
                break;
        }
    }

    public void greateNumWinner(){
        tvTotalScore.setText(Integer.toString(totalScore));
        if(totalScore == 10){
            Toast.makeText(this,"Congratulations!!, You won the game!!..",Toast.LENGTH_LONG).show();
            totalScore=0;
        }
        else if(totalScore == -10){
            Toast.makeText(this,"Sorry!!, You loose the game!!..",Toast.LENGTH_LONG).show();
            totalScore=0;
        }





        }

    }

