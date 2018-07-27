package de.cbc.azubiproject.collections;

import java.util.ArrayList;
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

public class QuestionAnswerCollection {
    private Collection<QuestionAnswer> questionAnswers;
    private int groupId;

    public QuestionAnswerCollection(Collection<QuestionAnswer> questionAnswers)
    {
        this.questionAnswers = questionAnswers;
        this.groupId = groupId;
    }

    public QuestionAnswerRepository getRepository()
    {
        return new QuestionAnswerRepository(questionAnswers);
    }
}
