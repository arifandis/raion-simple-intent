package com.raion.intent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnClick;
    private EditText etPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnClick = findViewById(R.id.btnClick);
        etPhone = findViewById(R.id.etNoTelp);

        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                simpleIntent();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1){
            if (resultCode == RESULT_OK){
                if (data != null){
                    String phone = data.getStringExtra("phone");
                    etPhone.setText(phone);
                }
            }
        }
    }

    protected void actionCall(){
        String phoneNumber = etPhone.getText().toString();
        if (phoneNumber.isEmpty()){
            Toast.makeText(this, "Isi nomor telepon", Toast.LENGTH_SHORT).show();
        }else{
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phoneNumber));
            startActivity(intent);
        }
    }

    protected void simpleIntent(){
        Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
        startActivity(intent);
    }

    protected void intentWithResult(){
        Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
        startActivityForResult(intent, 1);
    }

    protected void intentWithData(){
        String phoneNumber = etPhone.getText().toString();
        if (phoneNumber.isEmpty()){
            Toast.makeText(this, "Isi nomor telepon", Toast.LENGTH_SHORT).show();
        }else{
            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra("phone",phoneNumber);
            startActivity(intent);
        }
    }
}
