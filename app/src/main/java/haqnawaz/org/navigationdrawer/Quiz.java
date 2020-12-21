package haqnawaz.org.navigationdrawer;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;
import androidx.appcompat.app.AppCompatActivity;

public class Quiz extends AppCompatActivity {

    Button answer1,answer2,answer3,answer4;
    TextView score,question;

    private Question myQuestion=new Question();
    private String mAnswer;
    private int mScore = 0;
    private int mQuestionLeangth=myQuestion.myQuestion.length;
    Random r;
    int tern=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        r=new Random();

        answer1=(Button)findViewById(R.id.answer1);
        answer2=(Button)findViewById(R.id.answer2);
        answer3=(Button)findViewById(R.id.answer3);
        answer4=(Button)findViewById(R.id.answer4);

        score=(TextView)findViewById(R.id.score);
        question=(TextView)findViewById(R.id.question);

        score.setText("Score: "+mScore);
        updateQuestion(tern);

        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answer1.getText()== mAnswer){
                    mScore++;
                    score.setText("Score: "+mScore);
                    tern=tern+1;
                    updateQuestion(tern);
                }else{
                    score.setText("Score: "+mScore);
                    tern=tern+1;
                    updateQuestion(tern);
                }

            }
        });

        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answer2.getText()== mAnswer){
                    mScore++;
                    score.setText("Score: "+mScore);
                    tern=tern+1;
                    updateQuestion(tern);
                }else{
                    score.setText("Score: "+mScore);
                    tern=tern+1;
                    updateQuestion(tern);
                }
            }
        });

        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answer3.getText()== mAnswer){
                    mScore++;
                    score.setText("Score: "+mScore);
                    tern=tern+1;
                    updateQuestion(tern);
                }else{
                    score.setText("Score: "+mScore);
                    tern=tern+1;
                    updateQuestion(tern);
                }
            }
        });

        answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answer4.getText()== mAnswer){
                    mScore++;
                    score.setText("Score: "+mScore);
                    tern=tern+1;
                    updateQuestion(tern);
                }else{
                    score.setText("Score: "+mScore);
                    tern=tern+1;
                    updateQuestion(tern);
                }
            }
        });
    }

    private void updateQuestion(int num){
        if(num<10){
            question.setText(myQuestion.getQuestion(num));
            answer1.setText(myQuestion.getChoices1(num));
            answer2.setText(myQuestion.getChoices2(num));
            answer3.setText(myQuestion.getChoices3(num));
            answer4.setText(myQuestion.getChoices4(num));
            mAnswer=myQuestion.getCorrectChoice(num);}
        else{
            gameOver();
        }
    }

    private void gameOver(){
        AlertDialog.Builder alertDialogBuilder=new AlertDialog.Builder(Quiz.this);
        alertDialogBuilder
                .setMessage("Quiz over! Your score is "+mScore+" Pints.")
                .setCancelable(false)
                .setPositiveButton("New Quiz",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                                finish();
                            }
                        })
                .setNegativeButton("Exit",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        });
        AlertDialog alertDialog=alertDialogBuilder.create();
        alertDialog.show();
    }

}