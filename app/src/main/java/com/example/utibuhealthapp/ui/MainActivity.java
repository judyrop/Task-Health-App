package com.example.utibuhealthapp.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.utibuhealthapp.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.customerIdEditText)
    EditText customerId;
    @BindView(R.id.medicationEditText)
    EditText medicationId;
    @BindView(R.id.quantityEditText)
    EditText quantity;
    @BindView(R.id.orderbtn)
    Button order;

    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        db = FirebaseFirestore.getInstance();
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String customerEditText = customerId.getText().toString();
                String medicationEditText = medicationId.getText().toString();
                String quantityEditText = quantity.getText().toString();

                Map<String, Object> user = new HashMap<>();
                user.put("customerId", customerEditText);
                user.put("medicationId", medicationEditText);
                user.put("quantity", quantityEditText);

                db.collection("user")
                        .add(user)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Toast.makeText(MainActivity.this, "order received wait for response", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(MainActivity.this, OrderConfirmationActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(MainActivity.this, "Failed to get your details", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }
}