package de.cbc.azubiproject.collections;

import java.util.Collection;

import de.cbc.azubiproject.interfaces.IQuestionAnswerCollection;
import de.cbc.azubiproject.models.QuestionAnswer;
import de.cbc.azubiproject.repositories.AnswerRepository;
import de.cbc.azubiproject.repositories.QuestionRepository;
import de.cbc.azubiproject.repositories.UserRepository;

public class QuestionAnswerCollection implements IQuestionAnswerCollection {
    private Collection<QuestionAnswer> questionAnswerCollection;

    public QuestionAnswerCollection(Collection<QuestionAnswer> questionAnswerCollection)
    {
        this.questionAnswerCollection = questionAnswerCollection;
    }

    public UserRepository getUserGroupRepository()
    {
        return new UserRepository(new FilterCollection(questionAnswerCollection, questionAnswer -> questionAnswer.getUserGroup().getUserGroupId() > 0).getCollection());
    }

    public QuestionRepository getQuestionRepository()
    {
        return new QuestionRepository(new FilterCollection(questionAnswerCollection, questionAnswer -> questionAnswer.getQuestion().getQuestionId() > 0).getCollection());
    }

    public AnswerRepository getAnswerRepository()
    {
        return new AnswerRepository(new FilterCollection(questionAnswerCollection, questionAnswer -> questionAnswer.getAnswer().getAnswerId() > 0).getCollection());
    }
}
