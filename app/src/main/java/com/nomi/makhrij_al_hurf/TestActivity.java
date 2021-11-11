package com.nomi.makhrij_al_hurf;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class TestActivity extends AppCompatActivity implements View.OnClickListener {
    String throat ,tongue ,lips ,nose ,mouth;
    TextView textView_ ,scoreView_;

    String answer;
    int score = 0 ,tries=0,wrong=0;
    CardView _cardView[] = new CardView[6];
    char c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        textView_ = findViewById(R.id.question);
        scoreView_ = findViewById(R.id.score);
        _cardView[0] = findViewById(R.id.card1);
        _cardView[1] = findViewById(R.id.card2);
        _cardView[2] = findViewById(R.id.card3);
        _cardView[3] = findViewById(R.id.card4);
        _cardView[4] = findViewById(R.id.card5);
        _cardView[5] = findViewById(R.id.card6);


        for(CardView cardView : _cardView){
            cardView.setOnClickListener(this);
        }

        //characters = "باَ بوُ بىِ م ن و ب ف ص ز س ظ ذ ث ط د ت ر ل ض ج ش ى ق ك غ خ ع ح أ ة";
        throat = "غخعح";
        tongue = "صزسظذثطدترلضجشىقك";
        lips = "وبف";
        nose = "من";
        mouth = "من";
        runTest();

    }

    public void removeSpaces(){
        //characters.replaceAll("\\s+","");
        throat.replaceAll("\\s+","");
        tongue.replaceAll("\\s+","");
        lips.replaceAll("\\s+","");
        nose.replaceAll("\\s+","");
        mouth.replaceAll("\\s+","");
    }
    public void runTest(){
        removeSpaces();
        int randomNum = ThreadLocalRandom.current().nextInt(1, 5 + 1);
        switch (randomNum){
            case 1 : answer = "throat";c = selectAChar(throat);break;
            case 2 : answer = "tongue";c = selectAChar(tongue);break;
            case 3 : answer = "lips";c = selectAChar(lips);break;
            case 4 : answer = "nose";c = selectAChar(nose);break;
            case 5 : answer = "mouth";c = selectAChar(mouth);break;
            default: answer = "nothing";break;
        }

        textView_.setText(Character.toString(c));
    }
    public char selectAChar(String s){

        Random random = new Random();
        int index = random.nextInt(s.length());
        return s.charAt(index);

    }
    void displayToast(String msg){
        Toast.makeText(this,  msg , Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.card1:
                if(answer.equals("throat")){
                    correct();
                }else{
                    wrongMethod();
                }
                break;
            case R.id.card2:
                if(answer.equals("nose")){
                    correct();
                }else{
                    wrongMethod();
                }
                break;
            case R.id.card3:
                if(answer.equals("tongue")){
                    correct();
                }else{
                    wrongMethod();
                }
                break;
            case R.id.card4:
                if(answer.equals("mouth")){
                    correct();
                }else{
                    wrongMethod();
                }
                break;
            case R.id.card5:
                if(answer.equals("lips")){
                    correct();
                }else{

                    wrongMethod();
                }
                break;
            case R.id.card6:
                share();
                break;
        }
        runTest();

    }
    public void correct(){
        displayToast("correct");
        score++;
        scoreView_.setText("correct: "+String.valueOf(score)+" wrong: "+String.valueOf(wrong));
    }
    public void triesMethod(){
        tries++;
        scoreView_.setText("correct: "+String.valueOf(score)+" wrong: "+String.valueOf(wrong));
    }
    public void wrongMethod(){
        displayToast("wrong");
        wrong++;
        scoreView_.setText("correct: "+String.valueOf(score)+" wrong: "+String.valueOf(wrong));
    }

   public void share(){
       Intent sendIntent = new Intent();
       sendIntent.setAction(Intent.ACTION_SEND);
       sendIntent.putExtra(Intent.EXTRA_TEXT, "My score is :"+score);
       sendIntent.setType("text/plain");
       Intent shareIntent = Intent.createChooser(sendIntent, null);
       startActivity(shareIntent);
   }
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        score = savedInstanceState.getInt("score");
        wrong = savedInstanceState.getInt("wrong");
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("score", score);
        savedInstanceState.putInt("wrong", wrong);
    }



}