package api;

import ciphers.Atbash;
import com.google.gson.Gson;

import com.google.gson.JsonElement;
import spark.Route;

public class Api {

    private JsonElement gson;


    public Route encryptAtbash() {
        return (req, res) -> {
            res.type("application/json");
            BodyExtractor extract = new Gson().fromJson(req.body(), BodyExtractor.class);
            return new Gson().toJsonTree(new JsonResponse(Status.SUCCESSS, new Atbash().encrypt(extract.getData())

            ));

        };

    }

        public Route encryptedAtbash(){
            return (req, res) -> {
                res.type("application/json");
                return  gson;

            };
    }

    public Route test(){
        return (req, res) -> {
            res.type("application/json");
            BodyExtractor extract = new Gson().fromJson(req.body(), BodyExtractor.class);
            System.out.println(extract.getData());
            return new Gson().toJson(new JsonResponse(Status.SUCCESSS));

        };
    }

//    public Route getCharacters(){
//        return (req, res) -> {
//            res.type("application/json");
//            return new Gson().toJson(new JsonResponse(Status.SUCCESSS));
//        };
//    }
//
//    public Route addCharacter(){
//        return (req, res) -> {
//             return new Gson().toJson(new JsonResponse(Status.SUCCESSS));
////            return "Added";
//        };
//    }

//    public Route updateCharacter(){
//        return (req, res) -> {
//            return new Gson().toJson(new JsonResponse(Status.SUCCESSS));
////            return "Added";
//        };
//    }
}
