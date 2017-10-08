package com.pb.riskanalysisforsmb.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import com.pb.riskanalysisforsmb.AddressWithRisk;
import com.pb.riskanalysisforsmb.R;
import com.pb.riskanalysisforsmb.RiskProfileItem;
import com.pb.riskanalysisforsmb.adaptor.CustomExpandableListAdapter;
import com.pb.riskanalysisforsmb.adaptor.ExpandableListDataPump;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class MultipleAddressRiskProfileActivity extends AppCompatActivity implements View.OnClickListener {

    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    LinkedHashMap<RiskProfileItem, List<RiskProfileItem>> expandableListDetail;
    private Button submitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.multiple_address_risk_profile);
        expandableListView = (ExpandableListView) findViewById(R.id.expandableListView);
        ArrayList<AddressWithRisk> addressWithRisks = getIntent().getParcelableArrayListExtra ("ADDRESSES_WITH_RISKS");
        expandableListDetail = ExpandableListDataPump.getData(addressWithRisks);
        expandableListAdapter = new CustomExpandableListAdapter(this, expandableListView, expandableListDetail);
        expandableListView.setAdapter(expandableListAdapter);

        // Locate the submitFileButton in activity layout
        submitBtn = (Button) findViewById(R.id.next_button);
        submitBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // do something when the button is clicked
        // Yes we will handle click here but which button clicked???
        switch (v.getId()) {
            case R.id.next_button:
                Intent intent = new Intent(this, SummaryActivity.class);
                intent.putExtra("CRIME_RISK_SELECTED", ((CustomExpandableListAdapter)expandableListAdapter).isCrimeRiskChecked());
                intent.putExtra("WEATHER_RISK_SELECTED", ((CustomExpandableListAdapter)expandableListAdapter).isWeatherRiskChecked());
                intent.putExtra("PARENT", "MULTI");
                startActivity(intent);
                break;

            default:
                break;
        }
    }


}
