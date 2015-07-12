package data;

import org.json.JSONObject;

/**
 * Created by Kon El on 12-07-2015.
 */
public class Item implements JSONPopulator {
    private Condition condition;

    @Override
    public void populate(JSONObject data) {
        condition = new Condition();
        condition.populate(data.optJSONObject("condition"));
    }

    public Condition getCondition() {
        return condition;
    }
}
