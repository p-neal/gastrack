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
   //Moving
//    public static final String EXTRA_MESSAGE = "com.example.gastrack.MESSAGE";
//    private EditText editLiters;
//    private EditText editPrice;
//    private EditText editPerLiter;
//    private Button buttonSave;
//Moving
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
//Moving
//        editLiters = findViewById(R.id.editLiters);
//        editPrice =  findViewById(R.id.editPrice);
//        editPerLiter = findViewById(R.id.editPerLiter);
//        buttonSave = findViewById(R.id.button_save);
//        buttonSave.setEnabled(false);
//
//        editLiters.addTextChangedListener(dataEntryWatcher);
//        editPrice.addTextChangedListener(dataEntryWatcher);
//Moving

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



//moving
//    private TextWatcher dataEntryWatcher = new TextWatcher() {
//        @Override
//        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//        }
//
//        @Override
//        public void onTextChanged(CharSequence s, int start, int before, int count) {
//            Double litersInput = Double.parseDouble(editLiters.getText().toString());
//            Double priceInput = Double.parseDouble(editPrice.getText().toString());
//            //Double perLiterInput = Double.parseDouble(editPerLiter.getText().toString().trim());
//
//            if (litersInput == 1.00) {
//                buttonSave.setEnabled(true);
//            }else{
//                buttonSave.setEnabled(false);
//            }
//            //Double perLiterInput = (litersInput/priceInput);
//            //afterTextChanged(perLiterInput.toString().);
//
//        }
//
//        @Override
//        public void afterTextChanged(Editable s) {
//            Double litersInput = Double.parseDouble(editLiters.getText().toString());
//            Double priceInput = Double.parseDouble(editPrice.getText().toString());
//            Double perLiterInput = (litersInput/priceInput);
//            if(priceInput != 0.00) {
//                editPerLiter.setText(String.format("%.2f", perLiterInput));
//            }
//        }
//    };
//moving
//moving
//      public void saveData (View view) {
//        Intent intent = new Intent(this, DisplayMessageActivity.class);
//        //Fields
//        EditText editLiters = (EditText) findViewById(R.id.editLiters);
//        EditText editPrice = (EditText) findViewById((R.id.editPrice));
//        EditText editPerLiter = (EditText) findViewById((R.id.editPerLiter));
//        //Strings
//        String editLitersString = editLiters.getText().toString();
//        String editPriceString = editPrice.getText().toString();
//        String editPerLiterString = editPerLiter.getText().toString();
//        //Combined
//        String message = "Liters: " + editLitersString + ", Price: " + editPriceString + ", Price per liter: " + editPerLiterString;
//        //create Json
//        JSONObject entryInfoJSON = createJson(editLitersString,editPriceString,editPerLiterString);
//        intent.putExtra(EXTRA_MESSAGE, message);
//        intent.putExtra("entryInfoJSON", entryInfoJSON.toString());
//        startActivity(intent);
//    }
//moving
   //moving
//    public JSONObject createJson(String liters, String price, String perLiter ){
//        JSONObject entryInfoJSON = new JSONObject();
//        try {
//            entryInfoJSON.put("Liters", liters);
//            entryInfoJSON.put("Price", price);
//            entryInfoJSON.put("PerLiters", perLiter);
//        }catch(JSONException e){
//            e.printStackTrace();
//        }
//        return(entryInfoJSON);
//
//    }
    //moving
}
