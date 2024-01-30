package com.example.droidplaygroundjava;

import android.content.Context;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class QuestionsFragment extends Fragment  {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private EditText answerText;
    private Button buttonSubmit;

    private OnSubmitButtonClickedListeners listeners;
    public QuestionsFragment() {
        // Required empty public constructor
    }

    public static QuestionsFragment newInstance(String param1, String param2) {
        QuestionsFragment fragment = new QuestionsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listeners = (OnSubmitButtonClickedListeners) context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        requireActivity().getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                requireActivity().finish();
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         View view = inflater.inflate(R.layout.fragment_questions, container, false);
         answerText = view.findViewById(R.id.editTextText_questions_answer);
         buttonSubmit = view.findViewById(R.id.button_questions_submit);
         buttonSubmit.setOnClickListener(v -> {
             getParentFragmentManager().popBackStack();
             if (answerText.getText() == null) {
                 listeners.onSubmitButtonClicked(null);
             } else {
                 listeners.onSubmitButtonClicked(answerText.getText().toString());
             }
         });
         return view;
    }

    interface OnSubmitButtonClickedListeners {
        void onSubmitButtonClicked(String answer);
    }
}