import api.Api;
import database.CharacterDatabase;

import static spark.Spark.*;


public class Main {
        public static void main(String[] args) {

          Api api = new Api(new CharacterDatabase());
          get("/api/characters/add/:name", api.addCharacter());
            get("/api/characters", api.getCharacters());

        }
}
