package com.example.bparks1271databinding.databindingexample;

import android.databinding.Bindable;
import android.databinding.DataBindingUtil;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bparks1271databinding.databindingexample.databinding.FragmentMainBinding;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        FragmentMainBinding binding = FragmentMainBinding.inflate(inflater, container, false);
        ShiftyUser user = new ShiftyUser();
        binding.setUser(user);
        user.makeShifty();



        return binding.getRoot();
    }
}
