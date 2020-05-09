package database;

import com.github.javafaker.Faker;
import dungeon.Character;
import dungeon.CharacterLogin;

import java.sql.*;
import java.util.Random;

public class DungeonDatabase {

     private Connection conn;

     private final String GET_CHARACTER_SQL = "SELECT * FROM character_log WHERE name = ? LIMIT 1";
     private final String ADD_CHARACTER_SQL = "INSERT INTO character_log (name, level) VALUES(?,1)";
     private final String UPDATE_CHARACTER_LEVEL_SQL = "UPDATE character_log SET level = level + 1 WHERE id = ?";

     private PreparedStatement psGetCharacter;
     private PreparedStatement psAddCharacter;
     private PreparedStatement psUpdateCharacterLevel;

     public DungeonDatabase(){
         try{
             conn = DriverManager.getConnection("jdbc:postgresql://localhost/DungeonDatabase", "coder", "coder");
             psGetCharacter = conn.prepareStatement(GET_CHARACTER_SQL);
             psAddCharacter = conn.prepareStatement(ADD_CHARACTER_SQL);
             psUpdateCharacterLevel = conn.prepareStatement(UPDATE_CHARACTER_LEVEL_SQL);
         } catch (SQLException e) {
             e.printStackTrace();
         }
     }

    public Character getCharacter(CharacterLogin login) throws NoSuchPersonException{
         Character result;
         try{
             psGetCharacter.setString(1, login.getUsername());
             ResultSet rs = psGetCharacter.executeQuery();
             if(rs.next()){
                 result = new Character(rs.getInt("id"), rs.getString("name"), rs.getInt("level"));
                 return result;
             }
             else{
                 throw new NoSuchPersonException();
             }
         } catch (SQLException e) {
             e.printStackTrace();
         }


        Random random = new Random();
        Faker faker = new Faker();
        return new Character(random.nextInt(50), faker.lordOfTheRings().character(), random.nextInt(10));
    }

    public void addCharacter(CharacterLogin login) throws PersonAlreadyExistsException{
        try{
            psGetCharacter.setString(1, login.getUsername());
            ResultSet rs = psGetCharacter.executeQuery();
            if(!rs.next()){
               psAddCharacter.setString(1, login.getUsername());
               psAddCharacter.execute();
            }
            else{
                throw new PersonAlreadyExistsException();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void levelUpCharacter(Character character) {
         try{
             psUpdateCharacterLevel.setInt(1, character.getID());
             psUpdateCharacterLevel.execute();
         } catch (SQLException e) {
             e.printStackTrace();
         }
    }
}
