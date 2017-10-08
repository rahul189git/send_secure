package com.pb.riskanalysisforsmb;


public class APIConstants {
    public static final String API_KEY = "fzDSaWLq5g6QPKEces51cy6lPPLOOPWV";
    public static final String SECRET = "DnRSo7rS6Kf4391Q";

    public static final String HTTPS_API__PITNEYBOWES_COM = "https://api-qa.pitneybowes.com";
    public static final String TOKEN_URL = "https://api-qa.pitneybowes.com/oauth/token";


    public final static String CRIME_RISK_REST_URL = HTTPS_API__PITNEYBOWES_COM + "/location-intelligence/georisk/v1/crime/byaddress?";
    public final static String FLLOD_RISK_REST_URL = HTTPS_API__PITNEYBOWES_COM + "/location-intelligence/georisk/v1/flood/byaddress?";

    public final static String FRAUDRISK_API = HTTPS_API__PITNEYBOWES_COM + "/identify/identifyrisk/v1/rest/checkglobalwatchlist/results.json";

    public final static String WEATHER_API_BASE_URL = "http://api.openweathermap.org/data/2.5/forecast?zip=";
}
