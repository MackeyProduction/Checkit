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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.concurrent.ExecutionException;

import de.cbc.azubiproject.containers.GroupContainer;
import de.cbc.azubiproject.facades.GroupFacade;
import de.cbc.azubiproject.interfaces.DialogOnClickListener;
import de.cbc.azubiproject.models.AddQuestionDialog;
import de.cbc.azubiproject.models.Group;
import de.cbc.azubiproject.models.QuestionAnswer;
import de.cbc.azubiproject.models.UserGroup;
import de.cbc.azubiproject.repositories.GroupRepository;


/**
 * A simple {@link Fragment} subclass.
 */
public class GroupFragment extends Fragment implements View.OnClickListener {
    private QuestionModeFragment questionModeFragment;
    private TextView textViewGroupName;
    private RecyclerView rvGroupQuestions;
    private GroupAdapter groupAdapter;
    private int groupId;
    private String username;
    public static final String GROUP_ID = "de.cbc.checkit.MESSAGE";
    private int counter = 0;
    private List<QuestionAnswer> questionAnswers;

    public GroupFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_group, container, false);

        // buttons
        ImageView questionMode = (ImageView) layout.findViewById(R.id.ivQuestionMode);
        questionMode.setOnClickListener(this);
        ImageView addQuestion = (ImageView) layout.findViewById(R.id.ivAddQuestion);
        addQuestion.setOnClickListener(this);

        rvGroupQuestions = (RecyclerView) layout.findViewById(R.id.rvGroupQuestions);
        textViewGroupName = (TextView) layout.findViewById(R.id.textViewGroupGroupName);

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
            counter = 0;

            // load group id
            groupId = Integer.parseInt(getArguments().getStringArrayList(GroupViewFragment.STRING_BUNDLE).get(0));
            username = getArguments().getStringArrayList(GroupViewFragment.STRING_BUNDLE).get(1);

            GroupContainer groupContainer = new GroupFacade().getContainer();
            textViewGroupName.setText(((List<UserGroup>) groupContainer.getUserGroupCollection().getByGroupId(groupId)).get(0).getGroup().getGroupName());
            questionAnswers = (List<QuestionAnswer>) groupContainer.getQuestionAnswerCollection().getByAnswerType(groupId, "Lernmodus");

            groupAdapter = new GroupAdapter(questionAnswers);
            rvGroupQuestions.setAdapter(groupAdapter);

            groupAdapter.setOnClickListener(new GroupAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(QuestionAnswer item, TextView textViewQuestion) throws Exception {
                    btnShowAnswer_onClick(item, textViewQuestion);
                }
            });
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            Toast.makeText(getActivity().getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Bundle bundle = new Bundle();
        bundle.putString(GROUP_ID, getArguments().getStringArrayList(GroupViewFragment.STRING_BUNDLE).get(0));
        questionModeFragment = (QuestionModeFragment) Fragment.instantiate(getActivity().getApplicationContext(), QuestionModeFragment.class.getName(), bundle);
    }

    public void btnAddQuestion_onClick(View view) throws Exception {
        try {
            GroupRepository groupRepository = new GroupFacade().getRepositories().getUserGroupCollection().getGroupRepository();
            String groupName = ((Group) groupRepository.getById(groupId)).getGroupName();
            AddQuestionDialog addQuestionDialog = new AddQuestionDialog(getActivity(), R.layout.dialog_group_question, username, groupName);

            addQuestionDialog.setOnClickListener(new DialogOnClickListener() {
                @Override
                public void onOk() {
                    try {
                        GroupContainer groupContainer = new GroupFacade().getContainer(true);
                        questionAnswers.clear();
                        questionAnswers.addAll(groupContainer.getQuestionAnswerCollection().getByAnswerType(groupId, "Lernmodus"));
                        groupAdapter.notifyDataSetChanged();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            addQuestionDialog.showDialog();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void btnQuizMode_onClick(View view) {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.replace(R.id.clMain, questionModeFragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onClick(View view) {
        try {
            switch (view.getId()) {
                case R.id.ivAddQuestion:
                    btnAddQuestion_onClick(view);
                    break;
                case R.id.ivQuestionMode:
                    btnQuizMode_onClick(view);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void btnShowAnswer_onClick(QuestionAnswer questionAnswer, TextView textViewQuestion) throws Exception {
        int cardId = counter % 2;
        switch (cardId) {
            case 0:
                textViewQuestion.setText(questionAnswer.getAnswer().getAnswer());
                break;
            case 1:
                textViewQuestion.setText(questionAnswer.getQuestion().getQuestion());
                break;
        }
        counter++;
    }
}
