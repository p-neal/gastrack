package com.example.gastrack.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.gastrack.DisplayMessageActivity;
import com.example.gastrack.R;

import org.json.JSONException;
import org.json.JSONObject;

public class HomeFragment extends Fragment {

    public static final String EXTRA_MESSAGE = "com.example.gastrack.MESSAGE";
    private EditText editLiters;
    private EditText editPrice;
    private EditText editPerLiter;
    private Button buttonSave;
    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);

        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        buttonSave = root.findViewById(R.id.button_save);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData(root);
            }
        });
        return root;
//        editLiters = getView(R.id.editLiters);
//        editPrice = findViewById(R.id.editPrice);
//        editPerLiter = findViewById(R.id.editPerLiter);
//        buttonSave = findViewById(R.id.button_save);
//        buttonSave.setEnabled(false);
//
//        editLiters.addTextChangedListener(dataEntryWatcher);
//        editPrice.addTextChangedListener(dataEntryWatcher);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        //   ImageView imageView = (ImageView) getView().findViewById(R.id.foo);
        editLiters = getView().findViewById(R.id.editLiters);
        editPrice = getView().findViewById(R.id.editPrice);
        editPerLiter = getView().findViewById(R.id.editPerLiter);
        buttonSave.setEnabled(false);

        editLiters.addTextChangedListener(dataEntryWatcher);
        editPrice.addTextChangedListener(dataEntryWatcher);

    }
    private TextWatcher dataEntryWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            Double litersInput = Double.parseDouble(editLiters.getText().toString());
            Double priceInput = Double.parseDouble(editPrice.getText().toString());
            //Double perLiterInput = Double.parseDouble(editPerLiter.getText().toString().trim());

            if (litersInput != 0.00 && priceInput != 0.00) {
                buttonSave.setEnabled(true);
            }else{
                buttonSave.setEnabled(false);
            }
            //Double perLiterInput = (litersInput/priceInput);
            //afterTextChanged(perLiterInput.toString().);

        }

        @Override
        public void afterTextChanged(Editable s) {
            Double litersInput = Double.parseDouble(editLiters.getText().toString());
            Double priceInput = Double.parseDouble(editPrice.getText().toString());
            Double perLiterInput = (priceInput/litersInput);
            if(priceInput != 0.00) {
                editPerLiter.setText(String.format("%.2f", perLiterInput));
            }
        }
    };
    public void saveData (View view) {
        Intent intent = new Intent(getActivity(), DisplayMessageActivity.class);
        //Fields
        EditText editLiters = getView().findViewById(R.id.editLiters);
        EditText editPrice = getView().findViewById((R.id.editPrice));
        EditText editPerLiter = getView().findViewById((R.id.editPerLiter));
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