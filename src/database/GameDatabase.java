package database;
import personnages.Personnage;
import personnages.heroes.Warrior;
import personnages.heroes.Wizard;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import static displayutils.Colors.*;

public class GameDatabase {
    private static final String DATABASE_URL = "jdbc:sqlite:game_database.db";

    public static void main(String[] args) {
        try {
            getConnection();
            System.out.println("Database connected successfully.");
            createHeroesTable();
        } catch (SQLException e) {
            System.err.println("Database connection failed: " + e.getMessage());
        }
    }

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection(DATABASE_URL);
    }

    public static void createHeroesTable() {
        String sql = "CREATE TABLE IF NOT EXISTS heroes (" +
                "hash_id INTEGER PRIMARY KEY," +
                "name TEXT NOT NULL," +
                "type TEXT NOT NULL," +
                "life INTEGER," +
                "max_life INTEGER," +
                "strength INTEGER," +
                "attack_name TEXT," +
                "attack_value INTEGER," +
                "defense_name TEXT," +
                "defense_value INTEGER," +
                "finished_game INTEGER DEFAULT 0)";

        try (Connection con = getConnection();
             Statement stmt = con.createStatement()) {
            stmt.execute(sql);
            System.out.println("Heroes table created successfully.");
        } catch (SQLException e) {
            System.err.println("Error creating heroes table: " + e.getMessage());
        }
    }

    public static void createHero(Personnage personnage) {
        String sql = "INSERT INTO heroes (hash_id, name, type, life, max_life, strength, attack_name, attack_value, defense_name, defense_value) VALUES (?,?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, personnage.getHashId());
            ps.setString(2, personnage.getName());
            ps.setString(3, personnage.getType());
            ps.setInt(4, personnage.getLife());
            ps.setInt(5, personnage.getMaxLife());
            ps.setInt(6, personnage.getAttackStrength());
            ps.setString(7, personnage.getEquipmentOffensive().getWeaponName());
            ps.setInt(8, personnage.getEquipmentOffensive().getAttackLevel());
            ps.setString(9, personnage.getEquipmentDefensif().getDefenseWeaponName());
            ps.setInt(10, personnage.getEquipmentDefensif().getDefenseLevel());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println(ANSI_GREEN + "[ Successfully saved hero " + personnage.getName() + " ]" + ANSI_RESET);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static List<Personnage> getHeroes() {
        List<Personnage> savedHeroes = new ArrayList<>();
        String sql = "SELECT * FROM heroes";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                String name = rs.getString("name");
                String type = rs.getString("type").toLowerCase();
                int life = rs.getInt("life");
                int maxLife = rs.getInt("max_life");
                int strength = rs.getInt("strength");
                String attackName = rs.getString("attack_name");
                int attackValue = rs.getInt("attack_value");
                String defenseName = rs.getString("defense_name");
                int defenseValue = rs.getInt("defense_value");
                int wonGame = rs.getInt("finished_game");

                Personnage personnage = switch (type) {
                    case "warrior" -> new Warrior(name, type, life, maxLife, strength, attackName, attackValue, defenseName, defenseValue);
                    case "wizard" -> new Wizard(name, type, life, maxLife, strength, attackName, attackValue, defenseName, defenseValue);
                    default -> null;
                };

                if (personnage != null) {
                    personnage.setWonGame(wonGame);
                    savedHeroes.add(personnage);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return savedHeroes;
    }

    public static String changePlayerSavedData(Personnage personnage) {
        String sql = "UPDATE `heroes` SET `name` = ?, " +
                "`type` = ?, " +
                "`life` = ?, " +
                "`max_life` = ?, " +
                "`strength` = ?, " +
                "`attack_name` = ?, " +
                "`attack_value` = ?, " +
                "`defense_name` = ?, " +
                "`defense_value` = ?, " +
                "`finished_game` = ? " +
                "WHERE `heroes`.`hash_id` = ?";

        try (Connection con = getConnection();
             PreparedStatement preparedStatement = con.prepareStatement(sql)) {

            preparedStatement.setString(1, personnage.getName());
            preparedStatement.setString(2, personnage.getType());
            preparedStatement.setInt(3, personnage.getLife());
            preparedStatement.setInt(4, personnage.getMaxLife());
            preparedStatement.setInt(5, personnage.getAttackStrength());
            preparedStatement.setString(6, personnage.getEquipmentOffensive().getWeaponName());
            preparedStatement.setInt(7, personnage.getEquipmentOffensive().getAttackLevel());
            preparedStatement.setString(8, personnage.getEquipmentDefensif().getDefenseWeaponName());
            preparedStatement.setInt(9, personnage.getEquipmentDefensif().getDefenseLevel());
            preparedStatement.setInt(10, personnage.getWonGame());
            preparedStatement.setInt(11, personnage.getHashId());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                return  ANSI_GREEN +  "[ Player data updated successfully. ]" + ANSI_RESET;
            } else {
                return ANSI_RED + "[ No player found with the specified ID. ]" + ANSI_RESET;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return ANSI_RED + "An error occurred while updating player data: " + e.getMessage() + ANSI_RESET;
        }
    }
    }



