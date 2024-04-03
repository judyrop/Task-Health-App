package com.example.utibuhealthapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.utibuhealthapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrderConfirmationActivity extends AppCompatActivity {
    @BindView(R.id.pickDeliveryRadioGroup)
    RadioGroup pickDelivery;
    @BindView(R.id.paymentRadioGroup) RadioGroup payment;
    @BindView(R.id.proceedButton)
    Button proceedPayment;
    @BindView(R.id.backButton) Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_confirmation);
        ButterKnife.bind(this);

        proceedPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int selectedPickDeliveryId = pickDelivery.getCheckedRadioButtonId();
                RadioButton selectedPickDelivery = findViewById(selectedPickDeliveryId);
                String pickDeliveryOption = selectedPickDelivery.getText().toString();


                int selectedPaymentId = payment.getCheckedRadioButtonId();
                RadioButton selectedPayment = findViewById(selectedPaymentId);
                String paymentOption = selectedPayment.getText().toString();


                String message = "Selected Pick/Delivery Option: " + pickDeliveryOption +
                        "\nSelected Payment Option: " + paymentOption;
                Toast.makeText(OrderConfirmationActivity.this, message, Toast.LENGTH_SHORT).show();

            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OrderConfirmationActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();

            }
        });
    }
}