package de.cbc.azubiproject.collections;

import java.util.Collection;

import de.cbc.azubiproject.interfaces.IQuestionAnswer;
import de.cbc.azubiproject.models.Answer;
import de.cbc.azubiproject.models.Question;
import de.cbc.azubiproject.models.QuestionAnswer;
import de.cbc.azubiproject.models.UserGroup;
import de.cbc.azubiproject.repositories.AnswerRepository;
import de.cbc.azubiproject.repositories.QuestionAnswerRepository;
import de.cbc.azubiproject.repositories.QuestionRepository;
import de.cbc.azubiproject.repositories.UserGroupRepository;

public class QuestionAnswerCollection implements IQuestionAnswer {
    private Collection<QuestionAnswer> questionAnswers;
    private int groupId;

    public QuestionAnswerCollection(Collection<QuestionAnswer> questionAnswers, int groupId)
    {
        this.questionAnswers = questionAnswers;
        this.groupId = groupId;
    }

    @Override
    public UserGroupRepository getUserGroups() {
        return new UserGroupRepository(new QuestionAnswerRepository().getById(groupId), groupId);
    }

    @Override
    public QuestionRepository getQuestions() {
        return null;
    }

    @Override
    public AnswerRepository getAnswers() {
        return null;
    }

    @Override
    public boolean isCorrect() {
        return false;
    }
}
