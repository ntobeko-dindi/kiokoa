package com.ntobeko.kiokoa;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.ntobeko.kiokoa.data.DBHelper;
import com.ntobeko.kiokoa.databinding.FragmentSecondBinding;
import com.ntobeko.kiokoa.models.Crypto;
import com.ntobeko.kiokoa.models.Encryption;

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

        SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
        String sharedPrefString = sharedPref.getString("position", "");

        Cursor cursor = new DBHelper(getContext()).getDataById(sharedPrefString);

        if(cursor.getCount() == 0)
            return;

        cursor.moveToNext();

        binding.siteName.setText(cursor.getString(0));
        binding.username.setText(cursor.getString(1));
        Encryption encryption = new Encryption(cursor.getString(0), cursor.getString(2), true);

        String cipher = encryption.encrypt();

        if(cipher.length() > 50)
            cipher = cipher.substring(0,50);

       binding.password.setText(cipher);

        binding.btnCopy.setOnClickListener(v -> {
            ClipboardManager clipboard = (ClipboardManager)getContext().getSystemService(getContext().CLIPBOARD_SERVICE);
            ClipData clip = ClipData.newPlainText("", binding.password.getText().toString().trim());
            clipboard.setPrimaryClip(clip);
            Toast.makeText(getContext(), "Copied to clipboard!", Toast.LENGTH_LONG).show();
        });

        binding.deleteBtn.setOnClickListener(v -> {
            new DBHelper(getContext()).deleteData(sharedPrefString);
            NavHostFragment.findNavController(SecondFragment.this)
                    .navigate(R.id.action_SecondFragment_to_FirstFragment);
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}