package com.example.a10603.geoquiz;

/**
 * Created by 10603 on 2017/2/16.
 */

public class Question {
    private int mTextResId;
    private  boolean mAnswerTrue;

    public boolean isAnswerTrue() {
        return mAnswerTrue;
    }

    public void setAnswerTrue(boolean answerTrue) {
        mAnswerTrue = answerTrue;
    }

    public void setTextResId(int textResId) {
        mTextResId = textResId;

    }

    public int getTextResId() {


        return mTextResId;
    }

    public Question(int textResId, boolean answerTrue){
        mAnswerTrue=answerTrue;
        mTextResId=textResId;

    }

}
