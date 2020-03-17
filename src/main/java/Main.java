import api.Api;
import api.DungeonApi;
import database.DungeonDatabase;


import static spark.Spark.*;


public class Main {

    public static void main(String[] args) {
        Api api = new Api();
        post("/atbash/encrypt/", api.encryptAtbash());
        get("/atbash/encrypted/", api.encryptedAtbash());
        get("/", (req, res) -> "Hello Wolrd");
        post("/test", api.test());

        DungeonDatabase dungeonDatabase = new DungeonDatabase();
        DungeonApi dungeonApi = new DungeonApi(dungeonDatabase);
        path("/dungeon", () -> {
            path("/character", () ->{
                get("/login", dungeonApi.getCharacter());
                get("/inventory", dungeonApi.getCharacter());
                post("/add", dungeonApi.addCharacter());
                post("/level-up", dungeonApi.levelUpCharacter());
            });
        });
    }

}
