package com.example.gastrack;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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
    public static final String EXTRA_MESSAGE = "com.example.gastrack.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
    }

    public void saveData (View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        //Fields
        EditText editLiters = (EditText) findViewById(R.id.editLiters);
        EditText editPrice = (EditText) findViewById((R.id.editPrice));
        EditText editPerLiter = (EditText) findViewById((R.id.editPerLiter));
        //Strings
        String editLitersString = editLiters.getText().toString();
        String editPriceString = editPrice.getText().toString();
        String editPerLiterString = editPerLiter.getText().toString();
        //Combined
        String message = "Liters: " + editLitersString + ", Price: " + editPriceString + ", Price per liter: " + editPerLiterString;
        //create Json
        JSONObject entryInfoJSON = createJson(editLitersString,editPriceString,editPerLiterString);
        intent.putExtra(EXTRA_MESSAGE, message);
        intent.putExtra("entryInfoJSON", entryInfoJSON.toString());
        startActivity(intent);
    }

    public JSONObject createJson(String liters, String price, String perLiter ){
        JSONObject entryInfoJSON = new JSONObject();
        try {
            entryInfoJSON.put("Liters", liters);
            entryInfoJSON.put("Price", price);
            entryInfoJSON.put("PerLiters", perLiter);
        }catch(JSONException e){
            e.printStackTrace();
        }
        return(entryInfoJSON);

    }
}
