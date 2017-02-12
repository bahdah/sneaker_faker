package tan.brickhack;

import com.github.dvdme.ForecastIOLib.FIOCurrently;
import com.github.dvdme.ForecastIOLib.ForecastIO;
import com.google.gson.JsonObject;


/**
 * Created by Ocean on 2/11/17.
 */
public class WeatherSearcher implements Searcher {

    @Override
    public String search(String command) throws Exception {


        ForecastIO fio = new ForecastIO(Constants.CURRENT_LATITUDE, Constants.CURRENT_LONGITUDE, Constants.FORECAST_IO_API_KEY);
        fio.setUnits(ForecastIO.UNITS_US);
        fio.setLang(ForecastIO.LANG_ENGLISH);
        //fio.getForecast(Constants.CURRENT_LONGITUDE, Constants.CURRENT_LATITUDE);

        FIOCurrently currently = new FIOCurrently(fio);

        long temperature = Math.round(currently.get().apparentTemperature());
        long windSpeed = Math.round(currently.get().windSpeed());

        String searchResult = "Temperature today will be " + temperature + " fahrenheits and the wind speed will be "
                + windSpeed + " miles per hour";

        System.out.println("[DEBUG] " + searchResult);

        return searchResult;
    }

    public static void main(String[] args) {

        try {
            String answer = new WeatherSearcher().search(null);
            System.out.println(answer);

        } catch (Exception e){}

    }
}
