package api;

import com.google.gson.Gson;
import database.DungeonDatabase;
import database.NoSuchPersonException;
import database.PersonAlreadyExistsException;
import dungeon.Character;
import dungeon.CharacterLogin;
import spark.Route;

import static api.Status.ERROR;
import static api.Status.SUCCESSS;

public class DungeonApi {

    private DungeonDatabase database;

    public DungeonApi(DungeonDatabase database) {
        this.database = database;
    }

    public Route getCharacter() {
        return (req, res) -> {
            res.type("application/json");
            CharacterLogin characterLogin = new Gson().fromJson(req.body(), CharacterLogin.class);
            try {
                Character character = database.getCharacter(characterLogin);
                return new Gson().toJson(new JsonResponse(SUCCESSS, character));

            } catch (NoSuchPersonException e) {
                return new Gson().toJson(new JsonResponse(ERROR, e.getMessage(), null));
            }
        };
    }

    public Route addCharacter() {
        return (req, res) -> {
            res.type("application/json");
            CharacterLogin characterLogin = new Gson().fromJson(req.body(), CharacterLogin.class);
            try {
                database.addCharacter(characterLogin);
                return new Gson().toJson(new JsonResponse(SUCCESSS, "Character has been created", null));
            } catch (PersonAlreadyExistsException e) {
                e.printStackTrace();
                return new Gson().toJson(new JsonResponse(ERROR, e.getMessage(), null));
            }
        };
    }

    public Route levelUpCharacter() {
        return (req, res) -> {
            res.type("application/json");
            Character character = new Gson().fromJson(req.body(), Character.class);
                database.levelUpCharacter(character);
                return new Gson().toJson(new JsonResponse(SUCCESSS, "Character has leveled up", null));

        };
    }

    public Route getCharacterInventory() {
        return (req, res) -> {
            res.type("application/json");
            Character character = new Gson().fromJson(req.body(), Character.class);

            return new Gson().toJson(new JsonResponse(SUCCESSS, character));
        };
    }
}
