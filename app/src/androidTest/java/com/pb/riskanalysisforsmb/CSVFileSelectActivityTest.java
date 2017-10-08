package com.pb.riskanalysisforsmb;

import android.content.Context;
import android.os.Environment;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.pb.riskanalysisforsmb.beans.AddressVO;
import com.pb.riskanalysisforsmb.csv.utils.CSVWriter;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class CSVFileSelectActivityTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.pb.riskanalysisforsmb", appContext.getPackageName());
    }

    @Test
    public void testWriteToCSVFiles() throws Exception {

        AddressVO AddressVO =new AddressVO("addresss1","address2","address3","","","304503", "1100034","302");
        AddressVO AddressVO1 =new AddressVO("addresss1","address2","address3","","","304503", "1100034","302");
        AddressVO AddressVO2 =new AddressVO("addresss1","address2","address3","","","304503", "1100034","302");

        List addressList=new ArrayList<>();
        addressList.add(AddressVO);
        addressList.add(AddressVO1);
        addressList.add(AddressVO2);
        if (isExternalStorageWritable()) {
            File directory = getDocumentStorageDir();
            CSVWriter.writeCsvFile(addressList);
        }
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.pb.riskanalysisforsmb", appContext.getPackageName());
    }

    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        return Environment.MEDIA_MOUNTED.equals(state);
    }

    public File getDocumentStorageDir() {
        // Get the directory for the app's private pictures directory.
        //File file = context.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);
        File file = Environment.getExternalStorageDirectory();
        file = new File(file, "/HackathonFile");
        if (file != null && !file.exists()) {
            file.mkdir();
        }
        return file;
    }
}
