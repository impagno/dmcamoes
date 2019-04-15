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
    private DatabaseReference db1 = db.child("produtos");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Produto p = new Produto("Sabão em pó", 5);
        //db.child("produtos").child("003").setValue(p);
        //Log.i("BANCODADOS", p.toString());

        db1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                Log.i("BANCODADOS", dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("BANCODADOS", "Houve um problema!", databaseError.toException());
            }
        });



    }
}
