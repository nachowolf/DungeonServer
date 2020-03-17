import api.Api;


import static spark.Spark.*;


public class Main {

    public static void main(String[] args) {
        Api api = new Api();
        post("/atbash/encrypt/", api.encryptAtbash());
        get("/atbash/encrypted/", api.encryptedAtbash());

        get("/", (req, res) -> "Hello Wolrd");

        post("/test", api.test());
    }

}
