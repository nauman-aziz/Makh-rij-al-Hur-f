package com.nomi.makhrij_al_hurf;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.Random;

public class TestActivity extends AppCompatActivity {
    String characters ,throat ,tongue ,lips ,nose ,mouth;
    TextView textView_;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        textView_ = findViewById(R.id.question);

        characters = "باَ بوُ بىِ م ن و ب ف ص ز س ظ ذ ث ط د ت ر ل ض ج ش ى ق ك غ خ ع ح أ ة";
        throat = "غ خ ع ح أ ة";
        tongue = "ص ز س ظ ذ ث ط د ت ر ل ض ج ش ى ق ك";
        lips = "و ب ف";
        nose = "م ن";
        mouth = "باَ بوُ بىِ";
        runTest();

    }
    public void removeSpaces(){
        characters.replaceAll("\\s+","");
        throat.replaceAll("\\s+","");
        tongue.replaceAll("\\s+","");
        lips.replaceAll("\\s+","");
        nose.replaceAll("\\s+","");
        mouth.replaceAll("\\s+","");
    }
    public void runTest(){

        char c = selectAChar(characters);
        textView_.setText(Character.toString(c));
    }
    public char selectAChar(String s){

        Random random = new Random();
        int index = random.nextInt(s.length());
        return s.charAt(index);

    }


}