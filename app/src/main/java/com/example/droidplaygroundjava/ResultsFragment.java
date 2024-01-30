package com.example.droidplaygroundjava;

import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ResultsFragment extends Fragment {

    private static final String ARG_PARAM1 = "answer";

    private String answer;

    private TextView resultText;

   /* public ResultsFragment() {
        // Required empty public constructor
    }

    public static ResultsFragment newInstance(String param1, String param2) {
        ResultsFragment fragment = new ResultsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }*/

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requireActivity().getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                requireActivity().finish();
            }
        });
        if (getArguments() != null) {
            answer = getArguments().getString(ARG_PARAM1);
            Log.d("###", "onCreateadd: "+ answer);
            if (answer == null || answer.isEmpty()) {
              answer = "0";
            } else {
                answer = "1";
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_results, container, false);
        resultText = view.findViewById(R.id.textView_results_value);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        resultText.setText(answer);
    }
}