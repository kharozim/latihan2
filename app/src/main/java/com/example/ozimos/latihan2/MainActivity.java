package com.example.ozimos.latihan2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtWidth, edtHeight, edtLength;
    private Button btnHitung;
    private TextView tvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtWidth = (EditText) findViewById(R.id.edt_width);
        edtHeight = (EditText) findViewById(R.id.edt_height);
        edtLength = (EditText) findViewById(R.id.edt_length);
        btnHitung = (Button) findViewById(R.id.btn_hitung);
        tvHasil = (TextView) findViewById(R.id.hasil);
        btnHitung.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_hitung) {
            String length = edtLength.getText().toString().trim();
            String width = edtWidth.getText().toString().trim();
            String height = edtHeight.getText().toString().trim();
            boolean isEmptyFields = false;
            if (TextUtils.isEmpty(length)) {
                isEmptyFields = true;
                edtLength.setError("Field ini Tidal Boleh kosong");
            }
            if (TextUtils.isEmpty(width)) {
                isEmptyFields = true;
                edtWidth.setError("Field ini Tidal Boleh kosong");
            }
            if (TextUtils.isEmpty(height)) {
                isEmptyFields = true;
                edtHeight.setError("Field ini Tidal Boleh kosong");
            }
            if (!isEmptyFields) {
                double l = Double.parseDouble(length);
                double w = Double.parseDouble(width);
                double h = Double.parseDouble(height);
                double volume = l * w * h;
                tvHasil.setText((String.valueOf(volume)));
            }

        }
    }

}
