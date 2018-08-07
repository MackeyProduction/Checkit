package de.cbc.azubiproject.checkit;


import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import de.cbc.azubiproject.containers.GroupContainer;
import de.cbc.azubiproject.facades.GroupFacade;
import de.cbc.azubiproject.models.QuestionAnswer;


/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionModeFragment extends Fragment {
    private RecyclerView rvQuestionMode;
    private QuestionModeAdapter questionModeAdapter;

    public QuestionModeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_question_mode, container, false);

        rvQuestionMode = (RecyclerView) layout.findViewById(R.id.rvQuestionMode);

        return layout;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvQuestionMode.setHasFixedSize(true);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        rvQuestionMode.setLayoutManager(mLayoutManager);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        try {
            int groupId = Integer.parseInt(getArguments().getString(GroupFragment.GROUP_ID));

            GroupContainer groupContainer = new GroupFacade().getContainer();
            List<QuestionAnswer> questionAnswers = (List<QuestionAnswer>) groupContainer.getQuestionAnswerCollection().getByAnswerType(groupId, "Quizmodus");

            questionModeAdapter = new QuestionModeAdapter(questionAnswers);
            rvQuestionMode.setAdapter(questionModeAdapter);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
