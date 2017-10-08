package com.pb.riskanalysisforsmb.csv.utils;

import android.os.Environment;
import android.util.Log;

import com.pb.riskanalysisforsmb.beans.AddressVO;
import com.pb.riskanalysisforsmb.beans.WeatherVO;
import com.pb.riskanalysisforsmb.georisk.api.MockWeatherAPI;
import com.pb.riskanalysisforsmb.risk.type.CrimeRisk;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static com.pb.riskanalysisforsmb.georisk.api.GeoRiskAPI.getAddressWithCrimeRisk;

public final class CSVWriter {
    private static final String TAG = "CSVWriter";
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final Object[] FILE_HEADER = {"Name", "Address1", "Address2", "Address3",
            "City", "State", "Country", "Zip",
            "Overall Crime Score", "Crime Severity", "Weather Risk Details"
    };
    private static final String OUTPUT_FILE_NAME = "Address_Risk_Output.csv";

    public static String writeCsvFile(List<CrimeRisk> addressesWithCrimeRisk) {
        FileWriter fileWriter = null;
        CSVPrinter csvFilePrinter = null;
        // Create the CSVFormat object with "\n" as a record delimiter
        CSVFormat csvFileFormat = CSVFormat.DEFAULT.withRecordSeparator(NEW_LINE_SEPARATOR);

        File outputFile = null;
        try {
            File dir = Environment.getExternalStorageDirectory();
            if (dir != null && !dir.exists()) {
                dir.mkdir();
            }

            outputFile = new File(dir, OUTPUT_FILE_NAME);
            if (!outputFile.exists()) {
                outputFile.createNewFile();
            }

            fileWriter = new FileWriter(outputFile);
            csvFilePrinter = new CSVPrinter(fileWriter, csvFileFormat);

            // Create CSV file header
            csvFilePrinter.printRecord(FILE_HEADER);

            int counter=0;
            // Write a new student object list to the CSV file
            for (CrimeRisk crimeRisk : addressesWithCrimeRisk) {
                List<String> addressDataRecord = new ArrayList<>();
                AddressVO address = crimeRisk.getAddressVO();
                addressDataRecord.add(address.getName());
                addressDataRecord.add(address.getAddress1());
                addressDataRecord.add(address.getAddress2());
                addressDataRecord.add(address.getAddress3());
                addressDataRecord.add(address.getCity());
                addressDataRecord.add(address.getState());
                addressDataRecord.add(address.getCountry());
                addressDataRecord.add(address.getZipCode());

                addressDataRecord.add(crimeRisk.getRiskScore());
                addressDataRecord.add(crimeRisk.getRiskSeverity());

                //Add mocked weather.
                boolean isWeatherRiskRequired = false;
                if (counter % 3 == 0) {
                    isWeatherRiskRequired = true;
                }
                counter++;

                WeatherVO weatherDetails = MockWeatherAPI.getWeatherDetails(address, isWeatherRiskRequired);
                if (weatherDetails != null) {
                    addressDataRecord.add(weatherDetails.toString());
                }
                //--------End------
                csvFilePrinter.printRecord(addressDataRecord);
            }

            Log.i(TAG, " Risk score updated in Csv " + outputFile.getAbsolutePath());

        } catch (Exception e) {
            Log.e(TAG, "Exception occurred in CsvFileWriter" + Log.getStackTraceString(e));
        } finally {
            try {
                if (fileWriter != null) {
                    fileWriter.flush();
                    fileWriter.close();
                }
                if (csvFilePrinter != null) {
                    csvFilePrinter.close();
                }
            } catch (IOException e) {
                Log.e(TAG, "Exception occurred in finally while flushing" + Log.getStackTraceString(e));
            }
        }
        return outputFile.getAbsolutePath();
    }

    public static List<CrimeRisk> getAddressesWithScores(InputStream inputStream) {
        List<CrimeRisk> addressList = new ArrayList<>();
        try {
            CSVParser csvRecords = CSVFormat.newFormat(',')
                    .withIgnoreEmptyLines(true)
                    .withNullString("")
                    .withHeader()
                    .parse(new InputStreamReader(inputStream));


            for (CSVRecord csvRecord : csvRecords) {

                String name = csvRecord.get("Name");
                String address1 = csvRecord.get("address1");
                String address2 = csvRecord.get("address2");
                String address3 = csvRecord.get("address3");
                String city = csvRecord.get("city");
                String state = csvRecord.get("state");
                String country = csvRecord.get("country");
                String zipCode = csvRecord.get("zip");


                AddressVO address = new AddressVO(name, address1, address2, address3, city, state, country, zipCode);

                addressList.add(getAddressWithCrimeRisk(address));

            }


        } catch (IOException e) {
            Log.e(TAG, "Exception occurred :" + Log.getStackTraceString(e));
        }
        return addressList;
    }


}