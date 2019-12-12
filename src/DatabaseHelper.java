import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper {
    static final String DATABASE_NAME = "game.db";
    static final String CONNECTION_URL = "jdbc:sqlite:databases/" + DATABASE_NAME;
    static final String TABLE_GAME = "tableGame";
    static final String HEALTH = "health";
    static final String X = "x";
    static final String Y = "y";

    Connection connection;

    public DatabaseHelper() {
        getConnection();
        createShapesTable();
    }

    public void createShapesTable() {
        String sqlCreate = "CREATE TABLE " + TABLE_GAME + "(" +
                HEALTH + " INTEGER, " +
                X + " INTEGER, " +
                Y + " INTEGER)";
        System.out.println(sqlCreate);

        if (connection != null) {
            try {
                Statement statement = connection.createStatement();
                statement.execute(sqlCreate);
            } catch (SQLException e) {
//                e.printStackTrace();
            }
        }
    }

    public void insertPlayer(Character player) {
        String sqlInsert = "INSERT INTO " + TABLE_GAME + " VALUES('" +
                player.getHealth() + "', '" +
                player.getX() + "', '" +
                player.getY() + "')";
        System.out.println(sqlInsert);

        if (connection != null && player.getHealth() > 0) {
            try {
                Statement statement = connection.createStatement();
                statement.execute(sqlInsert);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void deletePlayers() {
        String sqlDelete = "DELETE FROM " + TABLE_GAME;
        System.out.println(sqlDelete);

        if (connection != null) {
            try {
                Statement statement = connection.createStatement();
                statement.execute(sqlDelete);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Character> getAllPlayersList() {
        List<Character> playerList = new ArrayList<>();
        String sqlSelect = "SELECT * FROM " + TABLE_GAME;
        System.out.println(sqlSelect);

        if (connection != null) {
            try {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sqlSelect);
                while (resultSet.next()) {
                    int health = resultSet.getInt(HEALTH);
                    int x = resultSet.getInt(X);
                    int y = resultSet.getInt(Y);
                    Character player = new Character(2, 2, x, y, health);
                    playerList.add(player);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return playerList;
    }

    public void getConnection() {
        try {
            // creates a database if it doesn't already exist
            connection = DriverManager.getConnection(CONNECTION_URL);
            System.out.println("Successfully connected to the database");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        // close the connection
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
