package com.example.a10603.geoquiz;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class QuizActivity extends AppCompatActivity {

    private Button mTrueButton;
    private Button mFalseButton;
    private ImageButton mNextNutton;
    private ImageButton mPriButton;
    private TextView mQuestionTextView;
    private Question[] mQuestionsBank = new Question[]{
            new Question(R.string.question_oceans, true),
            new Question(R.string.question_mideast, false),
            new Question(R.string.question_africa, false),
            new Question(R.string.question_americas, true),
            new Question(R.string.question_asia, true),
    };
    private int mCurrentInt = 0;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient mClient;

    private void QuizAnswer(boolean userPressedTrue) {
        boolean answerIsTrue = mQuestionsBank[mCurrentInt].isAnswerTrue();
        int messageId = 0;
        if (userPressedTrue == answerIsTrue) {
            messageId = R.string.correct_toast;
        } else {
            messageId = R.string.incorrect_toast;
        }
        Toast.makeText(QuizActivity.this, messageId, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        mTrueButton = (Button) findViewById(R.id.true_button);
        mFalseButton = (Button) findViewById(R.id.false_button);
        mNextNutton = (ImageButton) findViewById(R.id.next_button);
        mPriButton=(ImageButton) findViewById(R.id.pri_button);
        mQuestionTextView = (TextView) findViewById(R.id.question_text);
        int question = mQuestionsBank[mCurrentInt].getTextResId();
        mQuestionTextView.setText(question);


        mNextNutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                updateQuestion();
            }
        });


        mPriButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                priQuestion();
            }
        });

        mQuestionTextView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                updateQuestion();
            }
        });

        mQuestionTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateQuestion();
            }
        });

        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QuizAnswer(true);
            }
        });


        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QuizAnswer(false);
            }
        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        mClient = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Quiz Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        mClient.connect();
        AppIndex.AppIndexApi.start(mClient, getIndexApiAction());
    }

    public void updateQuestion() {
        mCurrentInt = (mCurrentInt + 1) % mQuestionsBank.length;
        int question = mQuestionsBank[mCurrentInt].getTextResId();
        mQuestionTextView.setText(question);
    }


    public void priQuestion() {
        if (mCurrentInt>0){
            mCurrentInt =(mCurrentInt - 1) % mQuestionsBank.length;
            int question = mQuestionsBank[mCurrentInt].getTextResId();
            mQuestionTextView.setText(question);
        }else{
            Toast.makeText(QuizActivity.this, "当前为第一题", Toast.LENGTH_SHORT).show();
        }

    }


    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(mClient, getIndexApiAction());
        mClient.disconnect();
    }
}
