package de.cbc.azubiproject.collections;

import java.util.Collection;

import de.cbc.azubiproject.interfaces.IQuestionAnswer;
import de.cbc.azubiproject.models.Answer;
import de.cbc.azubiproject.models.Question;
import de.cbc.azubiproject.models.QuestionAnswer;
import de.cbc.azubiproject.models.UserGroup;

public class QuestionAnswerCollection {
    private Collection<QuestionAnswer> questionAnswers;

    public QuestionAnswerCollection(Collection<QuestionAnswer> questionAnswers)
    {
        this.questionAnswers = questionAnswers;
    }
}
