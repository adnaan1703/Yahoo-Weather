package data;

import org.json.JSONObject;

/**
 * Created by Kon El on 12-07-2015.
 */
public class Channel implements JSONPopulator {

    private Units units;
    private Item item;
    private Location location;
    private Astronomy astronomy;

    @Override
    public void populate(JSONObject data) {
        units = new Units();
        units.populate(data.optJSONObject("units"));

        item = new Item();
        item.populate((data.optJSONObject("item")));

        location = new Location();
        location.populate(data.optJSONObject("location"));

        astronomy = new Astronomy();
        astronomy.populate(data.optJSONObject("astronomy"));
    }

    public Item getItem() {
        return item;
    }

    public Units getUnits() {
        return units;
    }

    public Location getLocation() {
        return location;
    }

    public Astronomy getAstronomy() {
        return astronomy;
    }
}
