package com.example.mycw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

import java.util.Random;
import static android.graphics.Color.*;

public class carImage extends AppCompatActivity {
    public static final ArrayList<Integer> randI = new ArrayList<>();

    public int cars[]= {
            R.drawable.audi_1,R.drawable.audi_2,R.drawable.audi_3,R.drawable.audi_4,R.drawable.audi_5,
            R.drawable.benz_1, R.drawable.benz_2,R.drawable.benz_3,R.drawable.benz_4,R.drawable.benz_5,
            R.drawable.bmw1,R.drawable.bmw2,R.drawable.bmw3,R.drawable.bmw4,R.drawable.bmw5,
            R.drawable.honda1,R.drawable.honda2,R.drawable.honda3,R.drawable.honda4,R.drawable.honda5,
            R.drawable.nissan1,R.drawable.nissan2,R.drawable.nissan3,R.drawable.nissan4,R.drawable.nissan5,
            R.drawable.toyota_1,R.drawable.toyota_2,R.drawable.toyota_3,R.drawable.toyota_4,R.drawable.toyota_5
    };
    //reference - (STACKOVERFLOW) https://stackoverflow.com/questions/39962816/get-random-images-in-android-studio


    private static final ArrayList<Integer> ints = new ArrayList<>();
    boolean submitImage;
    public static int choose=-1;
    Random ran = new Random();
    int random;
    Button identifyWords;
    Button buttonHome3;
    TextView tv;
    TextView correct;
    TextView wrong;
    int x, y, z;
    int carName;
    int cAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_image);


        //home button
        buttonHome3 = findViewById(R.id.w1790810_buttonHome3);//Referenced the tutorial
        //connecting car make page with main activity page
        //Referenced the tutorial
        buttonHome3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(carImage.this,MainActivity.class);
                startActivity(intent);
            }
        });


        //  random image
        if(randI.size()>30){
            finish();
        }

        x = randI();
        randI.add(x);
        ints.add(x);
        y = randI();
        while(x/5==y/5){
            y = randI();
        }
        ints.add(y);
        z = randI();
        while(x/5==z/5 || y/5==z/5){
            z = randI();
        }
        ints.add(z);
        carName = (ran.nextInt(4));
        final ImageView iv1 = findViewById(R.id.imageView_1);
        final ImageView iv2 = findViewById(R.id.image3);
        final ImageView iv3 = findViewById(R.id.image2);
        if(savedInstanceState!= null) {
            this.x = savedInstanceState.getInt("x");
            this.y = savedInstanceState.getInt("y");
            this.z = savedInstanceState.getInt("z");
            this.cAnswer = savedInstanceState.getInt("cAnswer");
            this.carName = savedInstanceState.getInt("carName");
            this.submitImage=savedInstanceState.getBoolean("submitImage");
        }

        if (carName==1){
            cAnswer=x;
        }
        else if (carName==2){
            cAnswer=y;
        }
        else{
            cAnswer=z;
        }
        String carN = getCar(cAnswer);
        TextView textView = findViewById(R.id.textView_name);
        textView.setText(carN);
        iv1.setImageResource(cars[x]);
        iv2.setImageResource(cars[y]);
        iv3.setImageResource(cars[z]);
        identifyWords = findViewById(R.id.w1790810_button_next);

    }

    private int randI() {
        int x = ran.nextInt(30);
        while(randI.contains(x)){
            x=ran.nextInt(30);
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

    public void findCorrectImage(View view) {
        //did this to do the thing when orientation changes


        identifyWords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(getIntent());
            }
        });

    }

    public void click1(View view) {
        choose = x;
        if (choose == cAnswer){
            correct = (TextView) findViewById(R.id.textView_statusCarImage);
            correct.setText("CORRECT!");
            correct.setBackgroundColor(Color.GREEN);// if the user select the correct answer

        } else {
            wrong = (TextView) findViewById(R.id.textView_statusCarImage);
            wrong.setText("WRONG!");
            wrong.setBackgroundColor(RED);
        }

        identifyWords.setEnabled(true);
        identifyWords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(getIntent());
            }
        });
    }

    public void click2(View view) {
        choose = y;
        if (choose == cAnswer){
            correct = (TextView) findViewById(R.id.textView_statusCarImage);
            correct.setText("CORRECT!");
            correct.setBackgroundColor(Color.GREEN);// if the user select the correct answer

        } else {
            wrong = (TextView) findViewById(R.id.textView_statusCarImage);
            wrong.setText("WRONG!");
            wrong.setBackgroundColor(RED);
        }
        identifyWords.setEnabled(true);
        identifyWords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(getIntent());
            }
        });
    }

    public void click3(View view) {
        choose = z;
        if (choose == cAnswer){
            correct = (TextView) findViewById(R.id.textView_statusCarImage);
            correct.setText("CORRECT!");
            correct.setBackgroundColor(Color.GREEN);// if the user select the correct answer

        } else {
            wrong = (TextView) findViewById(R.id.textView_statusCarImage);
            wrong.setText("WRONG!");
            wrong.setBackgroundColor(RED);
        }
        identifyWords.setEnabled(true);
        identifyWords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(getIntent());
            }
        });
    }
}

