import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {


        ArrayList<Character> characterArrayList = new ArrayList<>();


        try {
            JSONObject jsonObject = new JSONObject(ConsumoAPI.getInfo());
            JSONObject object_info = jsonObject.getJSONObject("info");
            JSONArray jsonArray_results = jsonObject.getJSONArray("results");

            for (int i=0;i<jsonArray_results.length();i++)
            {
                JSONObject object_elemento = jsonArray_results.getJSONObject(i);
                JSONArray jsonArray_episode = object_elemento.getJSONArray("episode");
                for (int j = 0;j<jsonArray_episode.length();j++)
                {
                    String s = jsonArray_episode.getString(j);
                    // System.out.println(s+"\n");
                }

                JSONObject object_origin = object_elemento.getJSONObject("origin");

                Origin origin = new Origin();
                origin.setName(object_origin.getString("name"));
                origin.setUrl(object_origin.getString("url"));

                Character personaje = new Character();
                personaje.setOrigin(origin);
                personaje.fromJSON(object_elemento);
                characterArrayList.add(personaje);
            }
            //System.out.println(count);
            for (Character e : characterArrayList)
            {
                System.out.println(e+"\n");
            }
        }
        catch (JSONException e)
        {
            System.out.println("JSON mal procesado o fuente incorrecta "+e.getMessage());
        }
        }




    }
