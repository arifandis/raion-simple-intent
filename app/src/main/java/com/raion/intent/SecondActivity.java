package com.raion.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.mbms.StreamingServiceInfo;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private Button btnClick;
    private EditText etPhone;
    private TextView tvData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btnClick = findViewById(R.id.btnClick);
        etPhone = findViewById(R.id.etNoTelp);
        tvData = findViewById(R.id.tvData);

        if (getIntent() != null){
            String data = getIntent().getStringExtra("phone");
            tvData.setText(data);
        }

        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("phone", etPhone.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
