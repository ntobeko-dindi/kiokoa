package com.ntobeko.kiokoa;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.ntobeko.kiokoa.data.DBHelper;
import com.ntobeko.kiokoa.databinding.FragmentFirstBinding;
import com.ntobeko.kiokoa.models.Credential;
import com.ntobeko.kiokoa.data.ListAdapter;
import java.util.ArrayList;

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

        Cursor cursor = DB.getData();

        if(cursor.getCount() == 0) {
            Toast.makeText(getContext(), "No Entry Exists", Toast.LENGTH_SHORT).show();
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

        SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("position", "" + credentials.get(position).getSiteName());
        editor.apply();

            NavHostFragment.findNavController(FirstFragment.this)
                    .navigate(R.id.action_FirstFragment_to_SecondFragment);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}