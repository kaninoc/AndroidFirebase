package com.unal.edu.androidfirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private LinearLayout player1Layout;

    private LinearLayout player2Layout;

    private ImageView image1,image2,image3,image4,image5,image6,image7,image8,image9;

    private TextView player1TV,player2TV;

    //winning moves
    private final List<int[]> combinationslist = new ArrayList<>();

    //player unique id
    private String playerUniqueId = "0";

    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://tic-tac-toe-firebase-ae6a6-default-rtdb.firebaseio.com/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        player1Layout = findViewById(R.id.player1Layout);
        player2Layout = findViewById(R.id.player2Layout);
        image1 = findViewById(R.id.image1);
        image2 = findViewById(R.id.image2);
        image3 = findViewById(R.id.image3);
        image4 = findViewById(R.id.image4);
        image5 = findViewById(R.id.image5);
        image6 = findViewById(R.id.image6);
        image7 = findViewById(R.id.image7);
        image8 = findViewById(R.id.image8);
        image9 = findViewById(R.id.image9);

        player1TV = findViewById(R.id.player1TV);
        player2TV = findViewById(R.id.player2TV);

        final String getPlayerName = getIntent().getStringExtra("playerName");

        //winning moves
        combinationslist.add(new int[]{0,1,2});
        combinationslist.add(new int[]{3,4,5});
        combinationslist.add(new int[]{6,7,8});
        combinationslist.add(new int[]{0,3,6});
        combinationslist.add(new int[]{1,4,7});
        combinationslist.add(new int[]{2,5,8});
        combinationslist.add(new int[]{0,4,8});
        combinationslist.add(new int[]{2,4,6});

        //waiting for oponent
        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("waitting for opponent");
        progressDialog.show();

        //generating player unique id, identification player for id
        playerUniqueId = String.valueOf(System.currentTimeMillis());

        //set to text view
        player1TV.setText(getPlayerName);

        databaseReference.child("connections").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}