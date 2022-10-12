package com.ntobeko.kiokoa;

import android.app.Dialog;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.ntobeko.kiokoa.databinding.ActivityMainBinding;
import com.ntobeko.kiokoa.models.Credential;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;

    Dialog add;
    MaterialButton bAdd;
    TextInputEditText etName, etPassword, etUserName;

    ArrayList<Credential> credentials = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        com.ntobeko.kiokoa.databinding.ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        credentials.add(new Credential("facebook","xcoding", "12345"));
        credentials.add(new Credential("facebook","xcoding", "12345"));
        credentials.add(new Credential("facebook","xcoding", "12345"));
        credentials.add(new Credential("facebook","xcoding", "12345"));

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        add = new Dialog(MainActivity.this);
        add.setContentView(R.layout.dialog_input);
        add.getWindow().setBackgroundDrawable(getDrawable(R.drawable.ic_baseline_add_24));
        add.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        //map out elements
        etName = add.findViewById(R.id.etName);
        etPassword = add.findViewById(R.id.etPassword);
        etUserName = add.findViewById(R.id.etUserName);
        bAdd = add.findViewById(R.id.bAdd);

        bAdd.setOnClickListener(view -> {
            //add.hide();
            Snackbar.make(view, "Password added successfully", Snackbar.LENGTH_LONG).setAction("Action", null).show();
        });

        binding.fab.setOnClickListener(view -> add.show());

        //Snackbar.make(view, "Password added successfully", Snackbar.LENGTH_LONG).setAction("Action", null).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}