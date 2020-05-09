package database;

public class PersonAlreadyExistsException extends RuntimeException {

    public PersonAlreadyExistsException(){
        super("This person already exists");
    }
}
