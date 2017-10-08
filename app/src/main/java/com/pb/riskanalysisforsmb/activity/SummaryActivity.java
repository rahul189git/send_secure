package com.pb.riskanalysisforsmb.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.pb.riskanalysisforsmb.R;

import java.util.Random;


public class SummaryActivity extends AppCompatActivity {
    private static final String LOG_TAG = "SummaryActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.summary);

        Bundle bundle = getIntent().getExtras();
        boolean isCrimeRiskSelected = bundle.getBoolean("CRIME_RISK_SELECTED");
        boolean isWeatherRiskSelected = bundle.getBoolean("WEATHER_RISK_SELECTED");
        String parent = bundle.getString("PARENT");

        TextView shippingText = (TextView) findViewById(R.id.shipping_cost);
        TextView premiumText = (TextView) findViewById(R.id.premium);
        TextView expressText = (TextView) findViewById(R.id.express_charges);
        TextView totalText = (TextView) findViewById(R.id.total_charges);

        Random rnd = new Random();
        int shipping = 100 + rnd.nextInt(900);
        int premium = isCrimeRiskSelected ? 10 + rnd.nextInt(90) : 0;
        int express = isWeatherRiskSelected ? 10 + rnd.nextInt(90) : 0;

        if ("SINGLE".equalsIgnoreCase(parent)) {
            shipping = 10 + rnd.nextInt(90);
            premium = isCrimeRiskSelected ? 1 + rnd.nextInt(9) : 0;
            express = isWeatherRiskSelected ? 1 + rnd.nextInt(9) : 0;
        }

        int total = shipping + premium + express;

        shippingText.setText("$ " + shipping);
        premiumText.setText("$ " + premium);
        expressText.setText("$ " + express);
        totalText.setText("$ "+ total);
    }

}
