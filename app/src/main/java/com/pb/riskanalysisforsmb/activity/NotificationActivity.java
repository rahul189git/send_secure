package com.pb.riskanalysisforsmb.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.pb.riskanalysisforsmb.R;


public class NotificationActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String LOG_TAG = "NotificationActivity";
    private static final int READ_REQUEST_CODE = 42;
    private TextView filePath;

    private TextView highRiskText;
    private TextView moderateRiskText;
    private TextView lowRiskText;

    private TextView weatherRiskText;
    private Button nextBtn;

    private CheckBox highCrimeRiskCheckBox;
    private CheckBox moderateCrimeRiskCheckBox;
    private CheckBox lowCrimeRiskCheckBox;
    private RadioGroup weatherRadioGroup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification);

        Intent intent = getIntent();

        highRiskText = (TextView) findViewById(R.id.ntf_high_risk_val_id);
        highRiskText.setText(intent.getStringExtra("HIGH_RISK_PERCENT"));

        moderateRiskText = (TextView) findViewById(R.id.ntf_moderate_risk_val_id);
        moderateRiskText.setText(intent.getStringExtra("MODERATE_RISK_PERCENT"));

        lowRiskText = (TextView) findViewById(R.id.ntf_low_crime_val_id);
        lowRiskText.setText(intent.getStringExtra("LOW_RISK_PERCENT"));

        weatherRiskText = (TextView) findViewById(R.id.ntf_weather_val_id);
        weatherRiskText.setText(intent.getStringExtra("WEATHER_RISK_PERCENT"));

        filePath = (TextView) findViewById(R.id.output_file_id);
        filePath.setText(intent.getStringExtra("OUTPUT_FILE_PATH"));

        nextBtn = (Button) findViewById(R.id.ntf_submit_notification_btn);
        nextBtn.setOnClickListener(this);

        lowCrimeRiskCheckBox = (CheckBox) findViewById(R.id.low_crime_cb_id);
        moderateCrimeRiskCheckBox = (CheckBox) findViewById(R.id.moderate_risk_cb_id);
        highCrimeRiskCheckBox = (CheckBox) findViewById(R.id.high_risk_checkBox_id);
        weatherRadioGroup = (RadioGroup) findViewById(R.id.radioGroup2);
    }

    @Override
    public void onClick(View v) {
        // do something when the button is clicked
        // Yes we will handle click here but which button clicked???
        switch (v.getId()) {
            case R.id.ntf_submit_notification_btn:

                buyInsurance();
                break;


            default:
                break;
        }
    }

    private void buyInsurance() {

        Intent goToNextActivity = new Intent(NotificationActivity.this, SummaryActivity.class);
        boolean isCrimeRiskSelected = lowCrimeRiskCheckBox.isChecked() || moderateCrimeRiskCheckBox.isChecked() || highCrimeRiskCheckBox.isChecked();
        goToNextActivity.putExtra("CRIME_RISK_SELECTED", isCrimeRiskSelected);
        goToNextActivity.putExtra("WEATHER_RISK_SELECTED", weatherRadioGroup.getCheckedRadioButtonId() == -1 ? false : true);
        goToNextActivity.putExtra("PARENT", "MULTI");
        startActivity(goToNextActivity);


    }

}
