package com.pb.riskanalysisforsmb.activity;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.OpenableColumns;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.pb.riskanalysisforsmb.R;
import com.pb.riskanalysisforsmb.georisk.tasks.CSVBatchWritingTask;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class CSVFileSelectActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String LOG_TAG = "CSVFileSelectActivity";
    private static final int READ_REQUEST_CODE = 42;
    private Uri filePath;
    private Button browseFileButton, submitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Locate the browseFileButton in activity_main.xml
        browseFileButton = (Button) findViewById(R.id.browse_file_btn_id);
        browseFileButton.setOnClickListener(this);

        // Locate the submitFileButton in activity_main.xml
        submitBtn = (Button) findViewById(R.id.submit_btn);
        submitBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // do something when the button is clicked
        // Yes we will handle click here but which button clicked???
        switch (v.getId()) {
            case R.id.submit_btn:

                TextView fileText = (TextView) findViewById(R.id.browse_file_text_id);
                String filePathInputString = fileText.getText().toString();
                if ("Select Address File.".equalsIgnoreCase(filePathInputString)) {
                    Toast.makeText(this, "Select file first.", Toast.LENGTH_SHORT).show();
                } else {
                    processData();
                    //Go to CSVAcknowledgementActivity
                    Intent goToNextActivity = new Intent(CSVFileSelectActivity.this, CSVAcknowledgementActivity.class);
                    startActivity(goToNextActivity);
                }
                break;

            case R.id.browse_file_btn_id:
                showFileChooser();

                break;

            default:
                break;
        }
    }

    private void showFileChooser() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("*/*");
        startActivityForResult(Intent.createChooser(intent, "Select your file"), READ_REQUEST_CODE);
    }


    private void processData() {
        InputStream inputStream = null;
        try {
            inputStream = getContentResolver().openInputStream(this.filePath);
        } catch (FileNotFoundException e) {
            Log.e(LOG_TAG, "Exception occurred :" + Log.getStackTraceString(e));
        }

        //Run in the background.
        new CSVBatchWritingTask(CSVFileSelectActivity.this).execute(inputStream);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {

            case READ_REQUEST_CODE:

                if (resultCode == RESULT_OK && data != null && data.getData() != null) {

                    filePath = data.getData();
                    TextView fileTextBox = (TextView) findViewById(R.id.browse_file_text_id);

                    String fileName = getFileName();
                    fileTextBox.setText(fileName);




                }
                break;


        }
    }

    private String getFileName() {
        Cursor returnCursor = getContentResolver().query(filePath, null, null, null, null);
                    /*
                     * Get the column indexes of the data in the Cursor,
                     * move to the first row in the Cursor, get the data,
                     * and display it.
                     */
        int nameIndex = returnCursor.getColumnIndex(OpenableColumns.DISPLAY_NAME);
        returnCursor.moveToFirst();
        return returnCursor.getString(nameIndex);
    }

}
