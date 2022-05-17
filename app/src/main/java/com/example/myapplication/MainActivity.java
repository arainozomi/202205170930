package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        //インスタンス化
//        GreetingOnClickListener listener = new GreetingOnClickListener();
//        //
//        Button button = findViewById(R.id.buttonChangeGreetings);
//
//        button.setOnClickListener(listener);



        //Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference("abc");/*pathはデータベースのデータのキー*/
            reference.setValue("Hello, World!");
        // Read from the database

            reference.addValueEventListener(new ValueEventListener() {
            @Override
            /*データの変化があったらこいつが呼ばれる*/
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d("Arai", "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Arai", "Failed to read value.", error.toException());
            }
        });
    }

//    class GreetingOnClickListener implements View.OnClickListener{
//
//        @Override
//        public void onClick(View view) {
//            Log.d("Arai", "ボタンが押された");
//
//            TextView v = findViewById(R.id.textViewGreetings);
//            v.setText("こんにちはCTC!!!");
//        }
//    }
}
