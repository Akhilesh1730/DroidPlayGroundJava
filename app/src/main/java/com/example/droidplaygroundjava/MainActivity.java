package com.example.droidplaygroundjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
        implements InstructionsFragment.OnStartTestButtonClickedListeners, QuestionsFragment.OnSubmitButtonClickedListeners {

    private static String TAG = "###";
    FragmentManager manager;
    FragmentTransaction transaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportFragmentManager().setFragmentFactory(new AppFragmentFactory());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = getSupportFragmentManager();
        addFragment(getSupportFragmentManager().getFragmentFactory()
                .instantiate(getClassLoader(), InstructionsFragment.class.getName()), "InstructionsFragment");
        Log.d(TAG, "onCreate: ");
    }

    private void addFragment(Fragment fragment, String tag) {
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        if (tag.equals("InstructionsFragment")) {
            transaction.add(R.id.fragmentContainerView, fragment, tag);
        } else if (tag.equals("InstructionsFragment")) {
            transaction.replace(R.id.fragmentContainerView, fragment,tag);
        } else {
            transaction.replace(R.id.fragmentContainerView, fragment, tag);
        }
        transaction.setReorderingAllowed(true);
        transaction.addToBackStack(null);
        transaction.commit();
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    @Override
    public void onStartButtonClicked() {
        manager.popBackStack();
        addFragment(getSupportFragmentManager().getFragmentFactory()
                .instantiate(getClassLoader(), QuestionsFragment.class.getName()), "QuestionsFragment");
    }

    @Override
    public void onSubmitButtonClicked(String answer) {
        //manager.popBackStack();
        Fragment fragment = getSupportFragmentManager().getFragmentFactory()
                .instantiate(getClassLoader(), ResultsFragment.class.getName());
        Bundle bundle = new Bundle();
        bundle.putString("answer", answer);
        fragment.setArguments(bundle);
        addFragment(fragment,"ResultsFragment");
    }
}