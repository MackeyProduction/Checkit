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
    private boolean isCorrect;

    public QuestionAnswer()
    {
        super();
    }

    public QuestionAnswer(int qaId, UserGroup userGroup, Question question, Answer answer, boolean isCorrect)
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
    public IUserGroup getUserGroup() {
        return userGroup;
    }

    @Override
    public IQuestion getQuestion() {
        return question;
    }

    @Override
    public IAnswer getAnswer() {
        return answer;
    }

    @Override
    public boolean isCorrect() {
        return isCorrect;
    }
}
