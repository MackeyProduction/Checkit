package de.cbc.azubiproject.checkit;


import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.concurrent.ExecutionException;

import de.cbc.azubiproject.containers.GroupContainer;
import de.cbc.azubiproject.facades.GroupFacade;
import de.cbc.azubiproject.models.AddQuestionDialog;
import de.cbc.azubiproject.models.QuestionAnswer;
import de.cbc.azubiproject.models.UserGroup;
import de.cbc.azubiproject.repositories.QuestionAnswerRepository;


/**
 * A simple {@link Fragment} subclass.
 */
public class GroupFragment extends Fragment implements View.OnClickListener {
    private QuestionModeFragment questionModeFragment;
    private TextView textViewQuestion;
    private RecyclerView rvGroupQuestions;
    private GroupAdapter groupAdapter;
    public static final String GROUP_ID = "de.cbc.checkit.MESSAGE";

    public GroupFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_group, container, false);

        // buttons
        FloatingActionButton questionMode = (FloatingActionButton) layout.findViewById(R.id.fabQuestionMode);
        questionMode.setOnClickListener(this);
        FloatingActionButton addQuestion = (FloatingActionButton) layout.findViewById(R.id.fabAddQuestion);
        addQuestion.setOnClickListener(this);
        FloatingActionButton editQuestion = (FloatingActionButton) layout.findViewById(R.id.fabEditQuestion);
        editQuestion.setOnClickListener(this);

        rvGroupQuestions = (RecyclerView) layout.findViewById(R.id.rvGroupQuestions);

        return layout;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvGroupQuestions.setHasFixedSize(true);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        rvGroupQuestions.setLayoutManager(mLayoutManager);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        try {
            // load group id
            int groupId = Integer.parseInt(getArguments().getString(GroupViewFragment.GROUP_ID));

            GroupContainer groupContainer = new GroupFacade().getContainer();
            List<QuestionAnswer> questionAnswers = (List<QuestionAnswer>) groupContainer.getQuestionAnswerCollection().getByGroupId(groupId);

            groupAdapter = new GroupAdapter(questionAnswers.subList(2, 7));
            rvGroupQuestions.setAdapter(groupAdapter);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            Toast.makeText(getActivity().getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }

        Bundle bundle = new Bundle();
        bundle.putString(GROUP_ID, GroupViewFragment.GROUP_ID);
        questionModeFragment = (QuestionModeFragment) Fragment.instantiate(getActivity().getApplicationContext(), QuestionModeFragment.class.getName(), bundle);
    }

    public void btnAddQuestion_onClick(View view)
    {
        AddQuestionDialog addQuestionDialog = new AddQuestionDialog(getActivity(), R.layout.dialog_group_question);
        addQuestionDialog.showDialog();
    }

    public void btnQuizMode_onClick(View view)
    {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.replace(R.id.clMain, questionModeFragment);
        fragmentTransaction.commit();
    }

    public void btnEditMode_onClick(View view)
    {
        Toast.makeText(getActivity().getApplicationContext(), "Diese Funktion steht noch nicht zur Verfügung.", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fabAddQuestion:
                btnAddQuestion_onClick(view);
                break;
            case R.id.fabQuestionMode:
                btnQuizMode_onClick(view);
                break;
            case R.id.fabEditQuestion:
                btnEditMode_onClick(view);
                break;
        }
    }
}
