package de.cbc.azubiproject.models;

public class QuestionAnswerHelper {
    private Question question;
    private Answer[] answers;
    private int[] correct;

    public QuestionAnswerHelper(Question question, Answer[] answers, int[] correct)
    {
        this.question = question;
        this.answers = answers;
        this.correct = correct;
    }

    public Question getQuestion() {
        return question;
    }

    public Answer[] getAnswers() {
        return answers;
    }

    public int[] getCorrect() {
        return correct;
    }
}
