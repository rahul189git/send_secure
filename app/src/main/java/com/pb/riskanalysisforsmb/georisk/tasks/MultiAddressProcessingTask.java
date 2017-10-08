package com.pb.riskanalysisforsmb.georisk.tasks;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;

import com.pb.riskanalysisforsmb.AddressWithRisk;
import com.pb.riskanalysisforsmb.activity.MultipleAddressRiskProfileActivity;
import com.pb.riskanalysisforsmb.activity.SingleAddressRiskProfileActivity;
import com.pb.riskanalysisforsmb.beans.AddressVO;
import com.pb.riskanalysisforsmb.beans.WeatherVO;
import com.pb.riskanalysisforsmb.georisk.api.MockWeatherAPI;
import com.pb.riskanalysisforsmb.risk.type.CrimeRisk;

import java.util.ArrayList;

import static com.pb.riskanalysisforsmb.georisk.api.GeoRiskAPI.getAddressWithCrimeRisk;


public class MultiAddressProcessingTask extends AsyncTask<AddressVO, Void, ArrayList<AddressWithRisk>> {
    private Context context;
    private ProgressDialog progressDialog;

    public MultiAddressProcessingTask(Context context) {
        this.context = context;
        progressDialog = new ProgressDialog(context);
    }


    @Override
    protected void onPreExecute() {
          /* Called before task execution; from UI thread, so you can access your widgets */

        super.onPreExecute();
        SpannableString ss2 = new SpannableString("Calculating Risk...");
        ss2.setSpan(new RelativeSizeSpan(1.5f), 0, ss2.length(), 0);
        progressDialog.setMessage(ss2);
        progressDialog.setIndeterminate(false);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setCancelable(false);
        progressDialog.show();
    }


    @Override
    protected ArrayList<AddressWithRisk> doInBackground(AddressVO... addresses) {

        ArrayList<AddressWithRisk> addressWithRisks = new ArrayList<>();
        //remove after fix.
        int counter = 0;
        for (AddressVO address : addresses) {
            CrimeRisk crimeRisk = getAddressWithCrimeRisk(address);
            AddressWithRisk addressWithRisk;
            if (crimeRisk != null) {
                addressWithRisk = new AddressWithRisk(crimeRisk.getAddress(),
                        crimeRisk.getRiskScore(),
                        crimeRisk.getRiskSeverity());
            } else {
                addressWithRisk = new AddressWithRisk();
            }

            boolean isWeatherRiskRequired = false;
            if (counter%3 == 0) {
                isWeatherRiskRequired = true;
            }

            WeatherVO weatherDetails = MockWeatherAPI.getWeatherDetails(address, isWeatherRiskRequired);
            if (weatherDetails != null) {
                addressWithRisk.setWeatherRiskDescription(weatherDetails.toString());
            }

            addressWithRisks.add(addressWithRisk);
            counter++;
        }
        return addressWithRisks;
    }


    @Override
    protected void onPostExecute(ArrayList<AddressWithRisk> addressList) {
        super.onPostExecute(addressList);
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }

        Intent intent;
        if (addressList.size() == 1) {
            //If single address, call another anctivity
            intent = new Intent(context, SingleAddressRiskProfileActivity.class);

        } else {
            //If multiple addresses, call MultipleAddressRiskProfileActivity anctivity
            intent = new Intent(context, MultipleAddressRiskProfileActivity.class);

        }
        intent.putParcelableArrayListExtra("ADDRESSES_WITH_RISKS", addressList);
        context.startActivity(intent);


    }


}
