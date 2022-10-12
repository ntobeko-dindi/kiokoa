package com.ntobeko.kiokoa;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import com.ntobeko.kiokoa.databinding.FragmentFirstBinding;
import com.ntobeko.kiokoa.models.Credential;
import com.ntobeko.kiokoa.models.ListAdapter;
import java.util.ArrayList;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    ArrayList<Credential> credentials = new ArrayList<>();

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

        credentials.clear();

        credentials.add(new Credential("facebook","xcoding", "12345"));
        credentials.add(new Credential("facebook","xcoding", "12345"));
        credentials.add(new Credential("facebook","xcoding", "12345"));
        credentials.add(new Credential("facebook","xcoding", "12345"));

        ListAdapter listAdapter = new ListAdapter(getContext(),credentials);

        binding.listview.setAdapter(listAdapter);
        binding.listview.setClickable(true);
        binding.listview.setOnItemClickListener((parent, view1, position, id) -> {

//                Intent i = new Intent(getContext(),UserActivity.class);
//                i.putExtra("name",name[position]);
//                i.putExtra("phone",phoneNo[position]);
//                i.putExtra("country",country[position]);
//                i.putExtra("imageid",imageId[position]);
//                startActivity(i);
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