package com.example.mycw;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Random;

public class advancedLevel extends AppCompatActivity {


    public static final ArrayList<Integer> randI = new ArrayList<>();
    public int cars[]= {
            R.drawable.audi_1,R.drawable.audi_2,R.drawable.audi_3,R.drawable.audi_4,R.drawable.audi_5,
            R.drawable.benz_1, R.drawable.benz_2,R.drawable.benz_3,R.drawable.benz_4,R.drawable.benz_5,
            R.drawable.bmw1,R.drawable.bmw2,R.drawable.bmw3,R.drawable.bmw4,R.drawable.bmw5,
            R.drawable.honda1,R.drawable.honda2,R.drawable.honda3,R.drawable.honda4,R.drawable.honda5,
            R.drawable.nissan1,R.drawable.nissan2,R.drawable.nissan3,R.drawable.nissan4,R.drawable.nissan5,
            R.drawable.toyota_1,R.drawable.toyota_2,R.drawable.toyota_3,R.drawable.toyota_4,R.drawable.toyota_5
    };


    private static final ArrayList<Integer> ints = new ArrayList<>();
    boolean image;
    Random random = new Random();
    Button btnid;
    Button buttonHome4;
    TextView textView, textView1, textView2;
    int x, y, z;
    int anInt;
    EditText brand, brand1, brand2;
    int answer1;
    int answer2;
    int answer3;
    int marks1 = 0;
    int marks2 = 0;
    int marks3 = 0;
    TextView correct1, correct2, correct3;
    private final int MAX_ATTEMPTS = 3;
    private int attempts = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced_level);
        //Referenced the tutorial
        brand = (EditText) findViewById(R.id.editText_car1);
        brand1 = (EditText) findViewById(R.id.editText_car2);
        brand2 = (EditText) findViewById(R.id.editText_car3);
        btnid = (Button) findViewById(R.id.w1790810_Submit1);
        textView2 = (TextView) findViewById(R.id.marks);
        correct1 = (TextView) findViewById(R.id.textView_car1);
        correct2 = (TextView) findViewById(R.id.textView_car2);
        correct3 = (TextView) findViewById(R.id.textView_car3);
        buttonHome4 = findViewById(R.id.w1790810_buttonHome4);
        //connecting car make page with main activity page
        //Referenced the tutorial
        buttonHome4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(advancedLevel.this,MainActivity.class);
                startActivity(intent);
            }
        });


        if (randI.size() > 30) {
            finish();
        }

        x = randI();
        randI.add(x);
        ints.add(x);
        y = randI();
        while (x / 5 == y / 5) {
            y = randI();
        }
        ints.add(y);
        z = randI();
        while (x / 5 == z / 5 || y / 5 == z / 5) {
            z = randI();
        }                                                                                            //
        ints.add(z);
        anInt = (random.nextInt(4));

        final ImageView iv1 = findViewById(R.id.w1790810_identifyImage1);
        final ImageView iv2 = findViewById(R.id.w1790810_identifyImage3);
        final ImageView iv3 = findViewById(R.id.w1790810_identifyImage2);
        if (savedInstanceState != null) {
            this.x = savedInstanceState.getInt("x");
            this.y = savedInstanceState.getInt("y");
            this.z = savedInstanceState.getInt("z");
            this.answer1 = savedInstanceState.getInt("cAnswer1");
            this.answer2 = savedInstanceState.getInt("cAnswer2");
            this.answer3 = savedInstanceState.getInt("cAnswer3");
            this.image = savedInstanceState.getBoolean("submitImage");
        }
        if (anInt ==1){
            answer1 =x;
        }else if (anInt ==2){
            answer2 =y;
        }else{
            answer3 =z;
        }
        String carN1 = getCar(x).toLowerCase();
        String carN2 = getCar(z).toLowerCase();
        String carN3 = getCar(y).toLowerCase();
        iv1.setImageResource(cars[x]);
        iv2.setImageResource(cars[y]);
        iv3.setImageResource(cars[z]);


        btnid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (carN1.contentEquals(brand.getText())) {
                    brand.setBackgroundColor(Color.GREEN);

                    brand.setEnabled(false);

                    marks1 = 1;

                } else  {
                    brand.setBackgroundColor(Color.RED);
                }
                if (carN2.contentEquals(brand1.getText())) {
                    brand1.setBackgroundColor(Color.GREEN);
                    brand1.setEnabled(false);
                    marks2 = 1;
                } else {
                    brand1.setBackgroundColor(Color.RED);
                }
                if (carN3.contentEquals(brand2.getText())) {
                    brand2.setBackgroundColor(Color.GREEN);
                    brand2.setEnabled(false);
                    marks3 = 1;
                } else {
                    brand2.setBackgroundColor(Color.RED);
                }
                textView2.setText(String.valueOf(marks1 + marks2 + marks3));
                attempts++;
                if (attempts >= MAX_ATTEMPTS) {
                    if (carN1.contentEquals(brand.getText())) {
                    } else  {
                        correct1.setText(carN1);
                        correct1.setTextColor(Color.YELLOW);
                    }
                    if (carN2.contentEquals(brand1.getText())) {

                    } else {
                        correct2.setText(carN2);
                        correct2.setTextColor(Color.YELLOW);
                    }
                    if (carN3.contentEquals(brand2.getText())) {
                    } else {

                        correct3.setText(carN3);
                        correct3.setTextColor(Color.YELLOW);
                    }
                    btnid.setText("Next");

                    btnid.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            startActivity(getIntent());
                            finish();
                        }
                    });

                }else if(carN1.contentEquals(brand.getText()) && carN2.contentEquals(brand1.getText()) && carN3.contentEquals(brand2.getText())) {

                    btnid.setText("Next");
                    textView.setText("CORRECT!");
                    textView.setBackgroundColor(Color.GREEN);
                    btnid.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            startActivity(getIntent());
                            finish();
                        }
                    });
                }
            }
        });
    }

    private int randI() {
        int x = random.nextInt(30);

        while(randI.contains(x)){
            x= random.nextInt(30);
        }
        return x;
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



}
