package de.cbc.azubiproject.models;

import java.util.Collection;

import de.cbc.azubiproject.interfaces.IQuestionAnswer;
import de.cbc.azubiproject.interfaces.IRepository;
import de.cbc.azubiproject.interfaces.IResponseRepository;
import de.cbc.azubiproject.repositories.QuestionRepository;
import de.cbc.azubiproject.repositories.UserGroupRepository;

public class QuestionAnswer implements IQuestionAnswer {
    private int qaId;
    private IResponseRepository userGroupRepository;
    private IRepository questionRepository, answerRepository;
    private boolean isCorrect;

    public QuestionAnswer(int qaId, IResponseRepository userGroupRepository, IRepository questionRepository, IRepository answerRepository, boolean isCorrect)
    {
        this.qaId = qaId;
        this.userGroupRepository = userGroupRepository;
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
        this.isCorrect = isCorrect;
    }

    @Override
    public int questionAnswerId() {
        return qaId;
    }

    @Override
    public IResponseRepository getUserGroups() {
        return userGroupRepository;
    }

    @Override
    public IRepository getQuestions() {
        return questionRepository;
    }

    @Override
    public IRepository getAnswers() {
        return answerRepository;
    }

    @Override
    public boolean isCorrect() {
        return isCorrect;
    }
}
