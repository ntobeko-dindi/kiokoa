package com.ntobeko.kiokoa;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.ntobeko.kiokoa.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        System.out.println("=======================================================================================================================================");
        //System.out.println("" + savedInstanceState.getString("key2", "fuck off"));
        System.out.println("=======================================================================================================================================");

        binding.textviewSecond.setText("value");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}