package com.example.javatestquiz;

public class Questions {

    private int answersResId;
    private boolean isAnswerTrue;

    public Questions(int answersResId, boolean isAnswerTrue) {
        this.answersResId = answersResId;
        this.isAnswerTrue = isAnswerTrue;
    }

    public int getAnswersResId() {
        return answersResId;
    }

    public void setAnswersResId(int answersResId) {
        this.answersResId = answersResId;
    }

    public boolean isAnswerTrue() {
        return isAnswerTrue;
    }

    public void setAnswerTrue(boolean answerTrue) {
        isAnswerTrue = answerTrue;
    }
}
