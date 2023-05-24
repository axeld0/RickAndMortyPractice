import org.json.JSONException;
import org.json.JSONObject;

public class Character implements I_ToJSON {
    private String name;

    private int id;

    private  Origin origin;

    public Character(String name, String species, String status, Origin origin, int id) {
        this.name = name;

        this.origin = origin;
        this.id = id;
    }

    public Character() {
        name = "";

        origin = new Origin();
        id = 0;
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", origin=" + origin +
                '}';
    }

    public Origin getOrigin() {
        return origin;
    }

    public void setOrigin(Origin origin) {
        this.origin = origin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public JSONObject toJSON() throws JSONException{
        JSONObject jsonObject_personaje = new JSONObject();
        jsonObject_personaje.put("name",getName());

        jsonObject_personaje.put("origin",getOrigin().toJSON());
        return jsonObject_personaje;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void fromJSON(JSONObject jsonObject) throws JSONException
    {
        setId(jsonObject.getInt("id"));
        setName(jsonObject.getString("name"));
    }
}
