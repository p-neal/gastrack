package com.example.gastrack;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

//    private View.OnClickListener editLitersListener = new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            editLitersClicked();
//        }
//    };
//    private View.OnClickListener editPriceListener = new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            editPriceClicked();
//        }
//    };
//    private View.OnClickListener editPerLiterListener = new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            editPerLiterClicked();
//        }
//    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_data, R.id.navigation_notes)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        //editPerLiter.addTextChangedListener(dataEntryWatcher);

//        editLiters.setOnClickListener(editLitersListener);
//        editPrice.setOnClickListener(editPriceListener);
//        editPerLiter.setOnClickListener(editPerLiterListener);

    }

//    private void editLitersClicked() {
//        editLiters.getText().clear();
//    }
//    private void editPriceClicked() {
//        editLiters.getText().clear();
//    }
//    private void editPerLiterClicked() {
//        editLiters.getText().clear();
//    }


}
