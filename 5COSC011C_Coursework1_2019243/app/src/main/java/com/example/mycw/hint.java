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

public class hint extends AppCompatActivity {


    public static final ArrayList<Integer> randomsample = new ArrayList<>();

    public int cars[]= {
            R.drawable.audi_1,R.drawable.audi_2,R.drawable.audi_3,R.drawable.audi_4,R.drawable.audi_5,
            R.drawable.benz_1, R.drawable.benz_2,R.drawable.benz_3,R.drawable.benz_4,R.drawable.benz_5,
            R.drawable.bmw1,R.drawable.bmw2,R.drawable.bmw3,R.drawable.bmw4,R.drawable.bmw5,
            R.drawable.honda1,R.drawable.honda2,R.drawable.honda3,R.drawable.honda4,R.drawable.honda5,
            R.drawable.nissan1,R.drawable.nissan2,R.drawable.nissan3,R.drawable.nissan4,R.drawable.nissan5,
            R.drawable.toyota_1,R.drawable.toyota_2,R.drawable.toyota_3,R.drawable.toyota_4,R.drawable.toyota_5
    };

    //reference - (STACKOVERFLOW) https://stackoverflow.com/questions/39962816/get-random-images-in-android-studio


    boolean submitbtn;
    TextView txt2;
    TextView txt4;
    TextView renametxt;
    String y = "";
    String x = "";
    Random randomOne = new Random();
    int random;
    Button bt1;
    Button buttonHome2;
    ImageView imgv;
    String word;
    EditText txt1;

    int atmt;
    boolean message2;




    @Override

    protected void onSaveInstanceState(Bundle state) {

        super.onSaveInstanceState(state);
        state.putInt("randW", random);
        state.putBoolean("submit", submitbtn);
        state.putBoolean("message2", message2);

    }

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hint);
        imgv = findViewById(R.id.w1790810_identifyImage1);
        txt1 = (EditText) findViewById(R.id.w1790810_editTextHint);
        txt2 = (TextView) findViewById(R.id.w1790810_textViewHint1);
        txt4 = (TextView) findViewById(R.id.w1790810_textViewHint3);
        renametxt = (TextView) findViewById(R.id.w1790810_textViewHint2);
        bt1 = (Button) findViewById(R.id.w1790810_submit2);
        buttonHome2 = findViewById(R.id.w1790810_buttonHome2);
        buttonHome2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(hint.this,MainActivity.class);
                startActivity(intent);
            }
        });





        if (randomsample.size() > 30) {
            finish();
        }
        submitbtn = false;
        int v = randomOne.nextInt(30);
        while (randomsample.contains(v)) {
            v = randomOne.nextInt(30);
        }
        random = v;
        randomsample.add(random);
        if (savedInstanceState != null) {
            this.random = savedInstanceState.getInt("randI");
            this.submitbtn = savedInstanceState.getBoolean("submit");
            this.message2 = savedInstanceState.getBoolean("message2");
        }
        imgv = findViewById(R.id.w1790810_identifyImage1);
        bt1 = findViewById(R.id.w1790810_submit2);
        word = getCar(random);
        imgv.setImageResource(cars[random]);

        //Putting underscore
        final ArrayList<Integer> index = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            if (Character.isWhitespace(word.toLowerCase().charAt(i))) {
                x = x.concat(" ");
            } else {
                x = x.concat(" _");
            }
        }

        //putting car name into variable y
        for (int i = 0; i < word.length(); i++) {
            if (Character.isWhitespace(word.toLowerCase().charAt(i))) {
                y = y.concat(" ");
            } else {
                y = y.concat(" " + word.charAt(i));
            }
        }


        //putting x and y to charArray
        final char[] char1Array = x.toCharArray();
        final char[] carNCharArray = y.toCharArray();
        txt2.setText(x);//setText to printName
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String letter = txt1.getText().toString();

                if (word.contains(letter)) {
                    txt4.setText("CORRECT!");
                    txt4.setTextColor(Color.GREEN);
                } else if (!word.contains(y)) {
                    atmt++;
                    txt4.setText("WRONG!");
                    txt4.setTextColor(Color.RED);
                }
                if (atmt >= 3) {
                    renametxt.setText(y);
                    renametxt.setTextColor(Color.YELLOW);

                }
                for (int i = 1; i < carNCharArray.length; i++) {
                    if (carNCharArray[i] == letter.charAt(0)) {
                        index.add(i);
                    }
                }


                for (int i = 0; i < index.size(); i++) {
                    char1Array[index.get(i)] = letter.charAt(0);

                }

                int count = 0;

                index.clear();
                txt2.setText("");


                for (int i = 0; i < carNCharArray.length; i++) {

                    String y = String.valueOf(char1Array[i]);

                    txt2.append(y);
                    System.out.print(char1Array[i]);
                    if (y.equals("_")) {
                        count++;
                    }
                }


                if (atmt >= 3) {
                    bt1.setText("Next");
                    bt1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            startActivity(getIntent());
                            finish();
                        }
                    });
                }

                txt1.setText("");
            }
        });
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

    public void submitWord(View view) {
        if(!submitbtn) {
            bt1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view1) {
                    Intent intent = new Intent(hint.this,hint.class);
                    startActivity(intent);
                }
            });
        }
    }




}

