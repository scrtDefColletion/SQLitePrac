package com.mirea.kt.android2023.myapplication;

import static java.lang.Integer.parseInt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";
    private EditText etModel, etSerial, etPrice;
    DBManager dbManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etModel = findViewById(R.id.etEnterModel);
        etSerial = findViewById(R.id.etEnterSerial);
        etPrice = findViewById(R.id.etEnterPrice);
        Button btnAdd = findViewById(R.id.btnAdd);
        Button btnShow = findViewById(R.id.btnShowTelephoneList);

        this.dbManager = new DBManager(new MyAppSQLiteHelper(this, "my_database.db",
                null, 1));


        btnAdd.setOnClickListener(this);
        btnShow.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnAdd){
            String model = etModel.getText().toString();
            String serial = etSerial.getText().toString();
            String price = etPrice.getText().toString();
            if(!model.isEmpty() && !serial.isEmpty() && !price.isEmpty()){
                boolean result = dbManager.saveTelephoneToDatabase(new Telephone(model, serial,
                                parseInt(price)));
                if (result) {
                    Toast.makeText(this, R.string.incert_success, Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(this, R.string.incert_error, Toast.LENGTH_LONG).show();
                }
            }else{
                Toast.makeText(this, R.string.incorrect_value, Toast.LENGTH_LONG).show();
            }
        } else if (v.getId() == R.id.btnShowTelephoneList) {
            Log.d(TAG, "onClick: Show button pressed ");
            Intent intent = new Intent(this, TelephoneActivity.class);
            startActivity(intent);
        }
    }


}