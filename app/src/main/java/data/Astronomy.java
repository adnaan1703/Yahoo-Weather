package data;

import org.json.JSONObject;

/**
 * Created by Kon El on 12-07-2015.
 */
public class Astronomy implements JSONPopulator {
    private String sunrise, sunset;

    public String getSunrise() {
        return sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    @Override
    public void populate(JSONObject data) {
        sunrise=data.optString("sunrise");
        sunset=data.optString("sunset");

    }
}
