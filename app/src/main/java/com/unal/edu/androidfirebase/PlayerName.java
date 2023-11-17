package com.unal.edu.androidfirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PlayerName extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_name);
        final EditText playerNameEt = findViewById(R.id.playerNameEt);
        final Button startGameBtn = findViewById(R.id.startGameBtn);

        startGameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String getplayername = playerNameEt.getText().toString();

                if (getplayername.isEmpty()){
                    Toast.makeText(PlayerName.this,"Please enter your Name",Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent = new Intent(PlayerName.this,MainActivity.class);
                    intent.putExtra("playerName",getplayername);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}