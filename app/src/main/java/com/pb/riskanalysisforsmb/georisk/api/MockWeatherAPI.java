package com.pb.riskanalysisforsmb.georisk.api;

import com.pb.riskanalysisforsmb.beans.AddressVO;
import com.pb.riskanalysisforsmb.beans.WeatherVO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class MockWeatherAPI {
    static ArrayList<WeatherVO> weatherConditions = new ArrayList<>(
            Arrays.asList(
                    new WeatherVO(getShippingDate(), "Heavy intensity rain", 90f, 59f, 53f, 64f),
                    new WeatherVO(getShippingDate(), "Very heavy rain", 88f, 59f, 59f, 59f),
                    new WeatherVO(getShippingDate(), "Extreme rain", 95f, 63f, 58f, 71f),
                    new WeatherVO(getShippingDate(), "Freezing rain", 75f, 59f, 53f, 61f),
                    new WeatherVO(getShippingDate(), "Heavy snow", 81f, 59f, 72f, 76f),
                    new WeatherVO(getShippingDate(), "Heavy shower snow", 69f, 75f, 75f, 75f),
                    new WeatherVO(getShippingDate(), "Volcanic ash", 55f, 90f, 84f, 92f),
                    new WeatherVO(getShippingDate(), "Tornado", 63f, 95f, 92f, 97f),
                    new WeatherVO(getShippingDate(), "Hurricane", 48f, 80f, 79f, 87f)
                    ));

    public static WeatherVO getWeatherDetails(AddressVO address, boolean isExtremeWeatherRequired) {
        if (!isExtremeWeatherRequired) {
            return null;
        }

        Random r = new Random();
        int index = r.nextInt(9);

        WeatherVO result = weatherConditions.get(index);
        result.setCity(address.getCity());
        result.setCountry(address.getCountry());
        return result;
    }

    private static Date getShippingDate() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date()); // Now use today date.
        c.add(Calendar.DATE, 3);
        return c.getTime();
    }

}
