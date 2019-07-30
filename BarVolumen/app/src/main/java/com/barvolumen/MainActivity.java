package com.barvolumen;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText inputPanjang;
    private EditText inputLebar;
    private EditText inputTinggi;
    private Button buttonHitung;
    private TextView textHitung;

    private static final String STATE_RESULT = "state_result";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputPanjang = (EditText) findViewById(R.id.input_panjang);
        inputLebar = (EditText) findViewById(R.id.input_lebar);
        inputTinggi = (EditText) findViewById(R.id.input_tinggi);
        buttonHitung = (Button) findViewById(R.id.button_hitung);
        textHitung = (TextView) findViewById(R.id.text_hitung);

        if (savedInstanceState != null) {
            String result = savedInstanceState.getString(STATE_RESULT);
            textHitung.setText(result);
        }

        buttonHitung();
    }

    private void buttonHitung() {
        buttonHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strPanjang = inputPanjang.getText().toString().trim();
                String strLebar = inputLebar.getText().toString().trim();
                String strTinggi = inputTinggi.getText().toString().trim();

                boolean isEmptyField = false;
                boolean isValidDouble = false;

                if(TextUtils.isEmpty(strPanjang)){
                    isEmptyField = true;
                    inputPanjang.setError("Field ini tidak boleh kosong!");
                }

                if(TextUtils.isEmpty(strLebar)){
                    isEmptyField = true;
                    inputLebar.setError("Field ini tidak boleh kosong!");
                }

                if(TextUtils.isEmpty(strTinggi)){
                    isEmptyField = true;
                    inputTinggi.setError("Field ini tidak boleh kosong!");
                }

                Double panjang = toDouble(strPanjang);
                Double lebar = toDouble(strLebar);
                Double tinggi = toDouble(strTinggi);

                if(panjang == null){
                    isValidDouble = true;
                    inputPanjang.setError("Field harus berupa nomor valid!");
                }

                if(lebar == null){
                    isValidDouble = true;
                    inputLebar.setError("Field harus berupa nomor valid!");
                }

                if(tinggi == null){
                    isValidDouble = true;
                    inputTinggi.setError("Field harus berupa nomor valid!");
                }

                if(!isEmptyField && !isValidDouble){
                    double volume = panjang * lebar * tinggi;
                    textHitung.setText(String.valueOf(volume));
                }
            }
        });
    }

    private Double toDouble(String str) {
        try{
            return Double.valueOf(str);
        }catch(NumberFormatException e){
            return null;
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_RESULT, textHitung.getText().toString());
    }
}
