package com.example.droidplaygroundjava;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentFactory;

public class AppFragmentFactory extends FragmentFactory {
    @NonNull
    @Override
    public Fragment instantiate(@NonNull ClassLoader classLoader, @NonNull String className) {
        try {
            Class<?> fragmentClass = classLoader.loadClass(className);
            Log.d("###", "instantiate: "+className);
            if (fragmentClass.equals(InstructionsFragment.class)) {
                return new InstructionsFragment();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return super.instantiate(classLoader, className);
    }
}
