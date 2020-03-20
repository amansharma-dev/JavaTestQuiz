package com.example.javatestquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView questionTextView;
    private Button trueButton;
    private Button falseButton;
    private ImageButton nextButton;
    private ImageButton previousButton;

    private Questions[] questionBank = new Questions[]{
            new Questions(R.string.question_1,false),
            new Questions(R.string.question_2,true),
            new Questions(R.string.question_3,false),
            new Questions(R.string.question_4,false),
            new Questions(R.string.question_5,false),
            new Questions(R.string.question_6,true),
            new Questions(R.string.question_7,true),

    };

    private int currentQuestion = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        questionTextView = findViewById(R.id.question_textView);
        trueButton = findViewById(R.id.true_button);
        falseButton = findViewById(R.id.false_button);
        nextButton = findViewById(R.id.next_button);
        previousButton = findViewById(R.id.previous_button);

        trueButton.setOnClickListener(this);
        falseButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);
        previousButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.true_button:

                checkAnswer(true);
                break;

            case R.id.false_button:

                checkAnswer(false);
                break;

            case R.id.next_button:

                currentQuestion = (currentQuestion + 1) % questionBank.length;
                updateQuestion();

                break;

            case R.id.previous_button:

                if (currentQuestion>0){
                    currentQuestion = (currentQuestion-1) % questionBank.length;
                    updateQuestion();
                }
                else{
                    Toast.makeText(getApplicationContext(),"can\'t go back",Toast.LENGTH_SHORT).show();

                }
                break;
        }
    }

    public void updateQuestion(){
        Log.d("QUESTIONTAG", "nextQuestion: "+ currentQuestion);
        questionTextView.setText(questionBank[currentQuestion].getAnswersResId());
    }

    public void checkAnswer(boolean userChooseCorrect){
        boolean answerIsTrue = questionBank[currentQuestion].isAnswerTrue();
        int toastMessage = 0;
        if (userChooseCorrect == answerIsTrue){
            toastMessage = R.string.text_correct;
        }else{
            toastMessage = R.string.text_wrong;
        }

        Toast.makeText(getApplicationContext(),toastMessage,Toast.LENGTH_SHORT).show();
    }
}
