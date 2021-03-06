package com.paytabs.sample.paytabstestsample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.paytabs.paytabs_sdk.payment.ui.activities.PayTabActivity;
import com.paytabs.paytabs_sdk.utils.PaymentParams;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.pay).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goPayment();
            }
        });
    }

    private void goPayment() {
      Intent in = new Intent(getApplicationContext(), PayTabActivity.class);
      in.putExtra(PaymentParams.MERCHANT_EMAIL, "merchant-email@example.com");
      in.putExtra(PaymentParams.SECRET_KEY,"secret key");//Add your Secret Key Here
      in.putExtra(PaymentParams.LANGUAGE,PaymentParams.ENGLISH);
      in.putExtra(PaymentParams.TRANSACTION_TITLE, "Test Paytabs android library");
      in.putExtra(PaymentParams.AMOUNT, 5.0);

      in.putExtra(PaymentParams.CURRENCY_CODE, "BHD");
      in.putExtra(PaymentParams.CUSTOMER_PHONE_NUMBER, "009733");
      in.putExtra(PaymentParams.CUSTOMER_EMAIL, "customer-email@example.com");
      in.putExtra(PaymentParams.ORDER_ID, "123456");
      in.putExtra(PaymentParams.PRODUCT_NAME, "Product 1, Product 2");

      //Billing Address
      in.putExtra(PaymentParams.ADDRESS_BILLING, "Flat 1,Building 123, Road 2345");
      in.putExtra(PaymentParams.CITY_BILLING, "Manama");
      in.putExtra(PaymentParams.STATE_BILLING, "Manama");
      in.putExtra(PaymentParams.COUNTRY_BILLING, "BHR");
      in.putExtra(PaymentParams.POSTAL_CODE_BILLING, "00973"); //Put Country Phone code if Postal code not available '00973'

      //Shipping Address
      in.putExtra(PaymentParams.ADDRESS_SHIPPING, "Flat 1,Building 123, Road 2345");
      in.putExtra(PaymentParams.CITY_SHIPPING, "Manama");
      in.putExtra(PaymentParams.STATE_SHIPPING, "Manama");
      in.putExtra(PaymentParams.COUNTRY_SHIPPING, "BHR");
      in.putExtra(PaymentParams.POSTAL_CODE_SHIPPING, "00973"); //Put Country Phone code if Postal code not available '00973'

      //Payment Page Style
      in.putExtra(PaymentParams.PAY_BUTTON_COLOR, "#2474bc");
      in.putExtra(PaymentParams.THEME, PaymentParams.THEME_LIGHT);

      //Tokenization
      in.putExtra(PaymentParams.IS_TOKENIZATION, true);
      startActivityForResult(in, PaymentParams.PAYMENT_REQUEST_CODE);
    }
}
