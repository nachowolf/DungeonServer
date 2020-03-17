package database;

public class NoSuchPersonException extends RuntimeException {
    public NoSuchPersonException(){
        super("No such Character Exists");
    }
}
