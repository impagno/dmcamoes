package edu.impagno.testefirebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import edu.impagno.testefirebase.Model.Produto;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference db = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db.child("produtos").child("001").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Produto produto = dataSnapshot.getValue(Produto.class);

                Log.i("BANCODADOS", produto.toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("BANCODADOS", "deu merda", databaseError.toException());
            }
        });



    }
}
