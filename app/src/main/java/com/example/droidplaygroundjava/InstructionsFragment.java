package com.example.droidplaygroundjava;

import android.content.Context;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class InstructionsFragment extends Fragment {

   /* public InstructionsFragment() {
        // Required empty public constructor
    }*/

    private OnStartTestButtonClickedListeners listeners;
    private Button buttonStartTest;

    // TODO: Rename and change types and number of parameters
    public static InstructionsFragment newInstance(String param1, String param2) {
        InstructionsFragment fragment = new InstructionsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listeners = (OnStartTestButtonClickedListeners) context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        View view = inflater.inflate(R.layout.fragment_instructions, container, false);
        buttonStartTest = view.findViewById(R.id.button_instructions_start);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        buttonStartTest.setOnClickListener(v -> {
            listeners.onStartButtonClicked();
        });
    }

    interface OnStartTestButtonClickedListeners {
        void onStartButtonClicked();
    }
}