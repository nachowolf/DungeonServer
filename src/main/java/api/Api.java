package api;

import com.google.gson.Gson;

import dungeon.Character;
import spark.Route;

public class Api {


    public Route getCharacters(){
        return (req, res) -> {
            res.type("application/json");
            return new Gson().toJson(new JsonResponse(Status.SUCCESSS));
        };
    }

    public Route addCharacter(){
        return (req, res) -> {
             return new Gson().toJson(new JsonResponse(Status.SUCCESSS));
//            return "Added";
        };
    }
}
