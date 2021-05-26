package com.example.mycw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Random;

import static android.graphics.Color.*;
public class carMake extends AppCompatActivity {

    public static final ArrayList<Integer> INTEGERS = new ArrayList<>();

    public int cars[]= {
            R.drawable.audi_1,R.drawable.audi_2,R.drawable.audi_3,R.drawable.audi_4,R.drawable.audi_5,
            R.drawable.benz_1, R.drawable.benz_2,R.drawable.benz_3,R.drawable.benz_4,R.drawable.benz_5,
            R.drawable.bmw1,R.drawable.bmw2,R.drawable.bmw3,R.drawable.bmw4,R.drawable.bmw5,
            R.drawable.honda1,R.drawable.honda2,R.drawable.honda3,R.drawable.honda4,R.drawable.honda5,
            R.drawable.nissan1,R.drawable.nissan2,R.drawable.nissan3,R.drawable.nissan4,R.drawable.nissan5,
            R.drawable.toyota_1,R.drawable.toyota_2,R.drawable.toyota_3,R.drawable.toyota_4,R.drawable.toyota_5
    };
//reference - (STACKOVERFLOW) https://stackoverflow.com/questions/39962816/get-random-images-in-android-studio

    boolean clickedSubmit;
    Random ran = new Random();
    int random;
    Button identifyCar;
    Button buttonHome1;
    ImageView img;
    Spinner sp1;
    String correctCar;
    int num;
    TextView tv;


    @Override
    protected void onSaveInstanceState (Bundle state) {

        super.onSaveInstanceState(state);
        state.putInt("randI",random);
        state.putBoolean("submit",clickedSubmit);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_make);


        //home button
        buttonHome1 = findViewById(R.id.w1790810_buttonHome1);//Referenced the tutorial
        //connecting car make page with main activity page
        //Referenced the tutorial
        buttonHome1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(carMake.this,MainActivity.class);
                startActivity(intent);
            }
        });


        if(INTEGERS.size()>30){
            finish();
        }

        clickedSubmit=false;
        int v = ran.nextInt(30);
        while(INTEGERS.contains(v)){
            v=ran.nextInt(30);
        }
        random=v;
        INTEGERS.add(random);
        if(savedInstanceState != null) {

            this.random = savedInstanceState.getInt("randI");
            this.clickedSubmit = savedInstanceState.getBoolean("submit");
        }
        img = findViewById(R.id.w1790810_identify_car);
        identifyCar = findViewById(R.id.w1790810_Submit1);

        correctCar = getCar(random);
        img.setImageResource(cars[random]);       //selecting random image from the arrays
        ArrayAdapter<CharSequence> names = ArrayAdapter.createFromResource(this, R.array.car_names, android.R.layout.simple_spinner_item);
        names.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);      //setting the data to dropdown
        sp1 = findViewById(R.id.w1790810_spinner);  //select the spinner
        if (sp1 != null) {
            sp1.setAdapter(names);   //adding names array to the spinner
        }


    }

    private String getCar(int num) {
        String car;
        if(-1<num && num<5){
            car="AUDI";
        }else if(5<num && num<10){
            car="BENZ";
        }else if(10<num && num<15){
            car="BMW";
        }else if(15<num && num<20){
            car="HONDA";
        }else if(20<num && num<25){
            car="NISSAN";
        }else {
            car="TOYOTA";
        }
        return car;
    }


    public void clickedSubmit(View view) {

        if(!clickedSubmit) {
            String text = sp1.getSelectedItem().toString();
            if (text.equals(correctCar)) {
                tv = (TextView) findViewById(R.id.w1790810_textViewTitle);
                tv.setText("CORRECT!");
                tv.setBackgroundColor(Color.GREEN);


            }

            else {
                tv = (TextView) findViewById(R.id.w1790810_textViewTitle);
                tv.setText("WRONG");
                tv.setBackgroundColor(RED);

                tv = (TextView) findViewById(R.id.textView2);
                tv.setText(correctCar);
                tv.setBackgroundColor(YELLOW);
            }


            identifyCar.setText("Next");
            identifyCar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view1) {
                    finish();
                    startActivity(getIntent());
                }
            });
        }
    }
}


//References - YOUTUBE TUTORIALS
//  STACKOVERFLOW
//(GIT HUB) - https://github.com/sanethinduwara/Flags-Android-Game/blob/master/app/src/main/java/com/saneth/flags/GuessHint.java
//https://github.com/sshajeeth/Simple-Flag-Game-App/blob/master/app/src/main/java/com/example/flaggame/GuessHints.java