package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) throws JSONException {
        JSONObject result  = new JSONObject(json);
        JSONObject nameObject = result.getJSONObject("name");

        String mainName = nameObject.getString("mainName");
        JSONArray alsoKnownAsArray = nameObject.getJSONArray("alsoKnownAs");
        List<String> alsoKnownAsList = new ArrayList<>();
        for(int i=0;i<alsoKnownAsArray.length();i++) {
            alsoKnownAsList.add(alsoKnownAsArray.getString(i));
        }

        String placeOfOrigin = result.getString("placeOfOrigin");
        String description = result.getString("description");
        String image = result.getString("image");

        JSONArray ingredientsArray = result.getJSONArray("ingredients");
        List<String> ingredientsList = new ArrayList<>();

        for(int i=0;i<ingredientsArray.length();i++) {
            ingredientsList.add(ingredientsArray.getString(i));
        }

        return new Sandwich(mainName, alsoKnownAsList, placeOfOrigin, description, image, ingredientsList);

    }
}
