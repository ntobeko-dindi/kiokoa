package com.ntobeko.kiokoa;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.google.android.material.snackbar.Snackbar;
import com.ntobeko.kiokoa.Data.DBHelper;
import com.ntobeko.kiokoa.databinding.FragmentFirstBinding;
import com.ntobeko.kiokoa.models.Credential;
import com.ntobeko.kiokoa.Data.ListAdapter;
import java.util.ArrayList;
import java.util.Date;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    ArrayList<Credential> credentials = new ArrayList<>();
    DBHelper DB;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        DB = new DBHelper(getContext());
        credentials.clear();

        Cursor cursor = DB.getdata();

        if(cursor.getCount()==0) {
            Snackbar.make(view, "No Entry Exists", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            return;
        }

        while(cursor.moveToNext()) {
            Credential cred = new Credential(cursor.getString(0),cursor.getString(1),cursor.getString(2));
            credentials.add(cred);
        }

        ListAdapter listAdapter = new ListAdapter(getContext(),credentials);

        binding.listview.setAdapter(listAdapter);
        binding.listview.setClickable(true);
        binding.listview.setOnItemClickListener((parent, view1, position, id) -> {

            Bundle args = new Bundle();
            args.putString ("key1", "ntobeko");
            args.putString ("key2", "dindi");

            NavHostFragment.findNavController(FirstFragment.this)
                    .navigate(R.id.action_FirstFragment_to_SecondFragment, args);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}