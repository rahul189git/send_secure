package com.pb.riskanalysisforsmb.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.pb.riskanalysisforsmb.R;

import static com.pb.riskanalysisforsmb.R.layout.acknowledge_csv_file;
import static com.pb.riskanalysisforsmb.R.layout.toolbar_app_layout;

public class CSVAcknowledgementActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(acknowledge_csv_file);

    }


}
