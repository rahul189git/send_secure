package com.pb.riskanalysisforsmb.georisk.api;

import android.util.Log;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pb.riskanalysisforsmb.APIConstants;
import com.pb.riskanalysisforsmb.RestRequest;
import com.pb.riskanalysisforsmb.beans.AddressVO;
import com.pb.riskanalysisforsmb.beans.WeatherVO;
import com.pb.riskanalysisforsmb.georisk.json.weather.List;
import com.pb.riskanalysisforsmb.georisk.json.weather.WeatherConditions;
import com.pb.riskanalysisforsmb.georisk.json.weather.WeatherResponse;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class WeatherAPI {
    private static final String TAG = "WeatherAPI";

    public static void main(String[] args) {
        AddressVO addressVO = new AddressVO("Meghan Bridgestock", "98454 Bowman Center", "789 Kropf Terrace", "435 Waubesa Place", "Spartanburg", "South Carolina", "United States", "29319");
        WeatherVO weatherDetails = getWeatherDetails(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()), addressVO);
        System.out.println(weatherDetails);
    }


    private final static String APIKEY = "171286da5c7bf8257959dccc0ee315de";

    private static java.util.List prepareWeatherListOfShippingDate(List weatherDetails, ArrayList<WeatherVO> weatherList, String shippingDateString, String capital, String country) {
        try {
            //creates a String representation of the date recieved from the weather response
            String dateText = weatherDetails.getDtTxt();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date dt = dateFormat.parse(dateText);
            String weatherDate = dateFormat.format(dt);

            if (weatherDate.equals(shippingDateString)) {

                DateFormat weatherDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                Date shipDate = weatherDateFormat.parse(dateText);
                float humidity = weatherDetails.getMain().getHumidity();
                float temp = (float) weatherDetails.getMain().getTemp();
                float tempMin = (float) weatherDetails.getMain().getTempMin();
                float tempMax = (float) weatherDetails.getMain().getTempMax();
                String weatherDescription = weatherDetails.getWeather().get(0).getDescription();
                WeatherVO weatherVO = new WeatherVO(shipDate, weatherDescription, humidity, temp, tempMin, tempMax, capital, country);
                weatherList.add(weatherVO);
            }
        } catch (ParseException e) {
            Log.e(TAG, "Exception occurred :" + Log.getStackTraceString(e));
        }

        return weatherList;
    }

    private static String getWeatherDetailsbyZipCode(String zipCode) {
        String url = APIConstants.WEATHER_API_BASE_URL + zipCode + ",us&APPID=" + APIKEY;
        System.out.println("Weather url " +url);
        return RestRequest.httpGET(url);
    }

    public static WeatherVO getWeatherDetails(String shippingDate, AddressVO address) {
        String jsonStr = getWeatherDetailsbyZipCode(address.getZipCode());

        ObjectMapper mapper = new ObjectMapper();
        WeatherResponse responseObject;
        ArrayList<WeatherVO> list = new ArrayList<>();
        try {
            DateFormat f = new SimpleDateFormat("yyyy-MM-dd");
            Date d = f.parse(shippingDate);
            String shippingDateString = calculateShippingDate(d, f);

            responseObject = mapper.readValue(jsonStr, WeatherResponse.class);
            java.util.List<List> weatherList = responseObject.getList();

            // Filter the weather details and returns the Weather for extreme conditions.
            for (List weatherDetails : weatherList) {
                prepareWeatherListOfShippingDate(weatherDetails, list, shippingDateString, address.getCity(), address.getState()+','+address.getCountry());
            }

        } catch (IOException | ParseException e) {
            Log.e(TAG, "Exception occurred :" + Log.getStackTraceString(e));
        }
        if (list.isEmpty()) {
            return null;
        } else {
            return list.get(0);
        }
    }

    public static WeatherVO getWeatherDetails(AddressVO address) {
        return getWeatherDetails(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()), address);
    }

    private static String calculateShippingDate(Date d, DateFormat f) {
        Calendar c = Calendar.getInstance();
        c.setTime(d); // Now use today date.
        c.add(Calendar.DATE, 3);
        Date newDate = c.getTime();
        return f.format(newDate);
    }
}
