package com.pb.riskanalysisforsmb.georisk;


import com.pb.riskanalysisforsmb.beans.WeatherVO;

import org.junit.Test;

import java.util.Date;

import static com.pb.riskanalysisforsmb.georisk.api.WeatherAPI.getWeatherDetails;

public class WeatherAPITest {

    @Test
    public void checkWeatherAPIforDate() throws Exception {
        String zipCode = "33414";
        String shippingDate = "2017-10-05 12:00:00";
        //WeatherVO weatherDetails = getWeatherDetails(shippingDate, zipCode, "Florida", "United States");

    }

    @Test
    public void checkWeatherVO() throws Exception {
        WeatherVO weatherDetails = new WeatherVO( new Date(), "Heavy Snowfall", 87, 303.573f, 303.573f, 303.573f, "Florida", "United States");
        weatherDetails.toString();
    }

}