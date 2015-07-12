package data;

import org.json.JSONObject;

/**
 * Created by Kon El on 12-07-2015.
 */
public class Units implements JSONPopulator {
    private String temperature;

    @Override
    public void populate(JSONObject data) {
        temperature = data.optString("temperature");
    }

    public String getTemperature() {
        return temperature;
    }
}
