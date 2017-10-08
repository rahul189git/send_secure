package com.pb.riskanalysisforsmb.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.pb.riskanalysisforsmb.AddressWithRisk;
import com.pb.riskanalysisforsmb.R;

import java.util.ArrayList;


public class SingleAddressRiskProfileActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String LOG_TAG = "SARProfileActivity";
    private Button submitBtn;
    private CheckBox crimeRiskCheckBox;
    private RadioGroup weatherRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_address_risk_profile);

        ArrayList<AddressWithRisk> addressWithRisks = getIntent().getParcelableArrayListExtra("ADDRESSES_WITH_RISKS");
        AddressWithRisk addressWithRisk = addressWithRisks.get(0);

        TextView riskScoreText = (TextView) findViewById(R.id.crime_risk_score_val);
        TextView riskSeverityText = (TextView) findViewById(R.id.crime_risk_severity_val);
        TextView weatherDescText = (TextView) findViewById(R.id.weather_risk_val);

        riskScoreText.setText(addressWithRisk.getCrimeRiskScore());
        riskSeverityText.setText(addressWithRisk.getCrimeRiskSeverity());
        weatherDescText.setText(addressWithRisk.getWeatherRiskDescription());

        submitBtn = (Button) findViewById(R.id.next_button);
        submitBtn.setOnClickListener(this);

        crimeRiskCheckBox = (CheckBox) findViewById(R.id.crime_risk_checkBox);
        weatherRadioGroup = (RadioGroup) findViewById(R.id.radioGroup);
    }

    @Override
    public void onClick(View v) {
        // do something when the button is clicked
        // Yes we will handle click here but which button clicked???
        switch (v.getId()) {
            case R.id.next_button:
                Intent intent = new Intent(this, SummaryActivity.class);
                intent.putExtra("CRIME_RISK_SELECTED", crimeRiskCheckBox.isChecked());
                intent.putExtra("WEATHER_RISK_SELECTED", weatherRadioGroup.getCheckedRadioButtonId() == -1 ? false : true);
                intent.putExtra("PARENT", "SINGLE");
                startActivity(intent);
                break;
            default:
                break;
        }
    }

}
