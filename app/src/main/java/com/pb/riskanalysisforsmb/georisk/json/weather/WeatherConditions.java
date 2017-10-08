package com.pb.riskanalysisforsmb.georisk.json.weather;

/**
 * Created by PR001SO on 9/26/2017.
 */
public enum WeatherConditions {
    HEAVYINTENSITYRAIN("heavy intensity rain"),
    HEAVYRAIN("very heavy rain"),
    EXTREMEGRAIN("extreme rain"),
    FREEZINGRAIN("freezing rain"),
    HEAVYSNOW("heavy snow"),
    HEAVYSHOWERSNOW("heavy shower snow"),
    VOLCANICASH("volcanic ash"),
    TORNADO("tornado"),
    HURRICANE("hurricane");

    private String name;

    WeatherConditions(String name) {
        this.name = name;
    }

    public static boolean contains(String test) {

        for (WeatherConditions c : values()) {
            if (c.name.equals(test)) {
                return true;
            }
        }
        return false;
    }
}
