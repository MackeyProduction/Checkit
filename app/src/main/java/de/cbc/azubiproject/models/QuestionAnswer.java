package de.cbc.azubiproject.models;

import java.util.Collection;

import de.cbc.azubiproject.interfaces.IAnswer;
import de.cbc.azubiproject.interfaces.IQuestion;
import de.cbc.azubiproject.interfaces.IQuestionAnswer;
import de.cbc.azubiproject.interfaces.IRepository;
import de.cbc.azubiproject.interfaces.IResponseRepository;
import de.cbc.azubiproject.interfaces.IUserGroup;
import de.cbc.azubiproject.repositories.QuestionRepository;
import de.cbc.azubiproject.repositories.UserGroupRepository;

public class QuestionAnswer implements IQuestionAnswer {
    private int qaId;
    private UserGroup userGroup;
    private Question question;
    private Answer answer;
    private int isCorrect;

    public QuestionAnswer()
    {
        super();
    }

    public QuestionAnswer(int qaId, UserGroup userGroup, Question question, Answer answer, int isCorrect)
    {
        this.qaId = qaId;
        this.userGroup = userGroup;
        this.question = question;
        this.answer = answer;
        this.isCorrect = isCorrect;
    }

    @Override
    public int questionAnswerId() {
        return qaId;
    }

    @Override
    public UserGroup getUserGroup() {
        return userGroup;
    }

    @Override
    public Question getQuestion() {
        return question;
    }

    @Override
    public Answer getAnswer() {
        return answer;
    }

    @Override
    public int isCorrect() {
        return isCorrect;
    }
}
