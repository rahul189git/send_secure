package com.pb.riskanalysisforsmb.georisk.tasks;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Environment;

import com.pb.riskanalysisforsmb.R;
import com.pb.riskanalysisforsmb.activity.CSVFileSelectActivity;
import com.pb.riskanalysisforsmb.activity.NotificationActivity;
import com.pb.riskanalysisforsmb.csv.utils.CSVWriter;
import com.pb.riskanalysisforsmb.risk.type.CrimeRisk;

import java.io.InputStream;
import java.util.List;

import static com.pb.riskanalysisforsmb.csv.utils.CSVWriter.getAddressesWithScores;


public class CSVBatchWritingTask extends AsyncTask<InputStream, Integer, List<CrimeRisk>> {
    private static final int NOTIFICATION_ID = 1;
    private Context context;
    // private ProgressDialog progressDialog;
    private String outputFilePath;




    public CSVBatchWritingTask(Context context) {
        this.context = context;
        // progressDialog = new ProgressDialog(context);
    }


    @Override
    protected void onPreExecute() {
          /* Called before task execution; from UI thread, so you can access your widgets */

        super.onPreExecute();
      /*  progressDialog.setMessage("Calculating Risk for addresses...");
        progressDialog.setIndeterminate(false);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setCancelable(false);
        progressDialog.show();*/
    }


    @Override
    protected List doInBackground(InputStream... inputStream) {
        List<CrimeRisk> addressList = getAddressesWithScores(inputStream[0]);
        return addressList;

    }


    @Override
    protected void onPostExecute(List<CrimeRisk> addressList) {
        super.onPostExecute(addressList);
        if (isExternalStorageWritable()) {
            outputFilePath = CSVWriter.writeCsvFile(addressList);
        }

        //  progressDialog.dismiss();

        createNotification(context, addressList);
        //Toast.makeText(context, "Risk has been calculated", Toast.LENGTH_SHORT).show();
    }

    /* Checks if external storage is available for read and write */
    private boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        return Environment.MEDIA_MOUNTED.equals(state);
    }

    /* Checks if external storage is available to at least read */
    public boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        return Environment.MEDIA_MOUNTED.equals(state) || Environment.MEDIA_MOUNTED_READ_ONLY.equals(state);
    }

    private void createNotification(Context context, List<CrimeRisk> addressList) {

        //Log.d("createNotification", "title is [" + contentTitle +"]");

        NotificationManager nm = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        //Build the notification using Notification.Builder
        Notification.Builder builder = new Notification.Builder(context)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setAutoCancel(true)
                .setContentTitle("Risk result")
                .setContentText("Risk analysis is complete.");


        int counter = 0;
        int lowCrimeCount = 0, moderateCrimeCount = 0, highCrimeCount = 0;
        int weatherRiskCount = 0;
        for (CrimeRisk crimeRisk : addressList) {
            if (crimeRisk != null) {
                String riskSeverity = crimeRisk.getRiskSeverity();
                if ("High".equalsIgnoreCase(riskSeverity)) {
                    highCrimeCount++;
                }
                if ("Moderate".equalsIgnoreCase(riskSeverity)) {
                    moderateCrimeCount++;
                }
                if ("Low".equalsIgnoreCase(riskSeverity)) {
                    lowCrimeCount++;
                }
            }

            boolean isExtremeWeatherRequired = (counter% 3 == 0);
            if (isExtremeWeatherRequired) {
                weatherRiskCount++;
            }
            counter++;
            //Not Needed
            //WeatherVO weatherDetails = MockWeatherAPI.getWeatherDetails(crimeRisk.getAddressVO(), isExtremeWeatherRequired);

        }
        int totalCount = addressList != null ? addressList.size() : 0;

        // Creates an explicit intent for an Activity in your app
        Intent resultIntent = new Intent(context, NotificationActivity.class);
        resultIntent.putExtra("HIGH_RISK_PERCENT", totalCount != 0 ? String.valueOf((highCrimeCount * 100 / totalCount)) : 0 + "%");
        resultIntent.putExtra("MODERATE_RISK_PERCENT", totalCount != 0 ? String.valueOf((moderateCrimeCount * 100 / totalCount)) : 0 + "%");
        resultIntent.putExtra("LOW_RISK_PERCENT", totalCount != 0 ? String.valueOf((lowCrimeCount * 100 / totalCount)) : 0 + "%");
        resultIntent.putExtra("WEATHER_RISK_PERCENT", totalCount != 0 ? String.valueOf((weatherRiskCount * 100 / totalCount)) : 0 + "%");
        resultIntent.putExtra("OUTPUT_FILE_PATH", outputFilePath);
        // The stack builder object will contain an artificial back stack for the
        // started Activity.This ensures that navigating backward from the Activity leads out of
        // your app to the Home screen.
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
        // Adds the back stack for the Intent (but not the Intent itself)
        stackBuilder.addParentStack(CSVFileSelectActivity.class);
        // Adds the Intent that starts the Activity to the top of the stack
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(resultPendingIntent);


        //Show the notification
        nm.notify(NOTIFICATION_ID, builder.build());
    }

}
