import personnages.Personnage;
import personnages.heroes.Warrior;
import personnages.heroes.Wizard;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GameDatabase {
    private static final String URL = "jdbc:mysql://localhost:3306/js_game_database";
    private static final String USER = "game";
    private static final String PASSWORD = "javagame";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public void createHero(Personnage personnage) {
        String sql = "INSERT INTO heroes (name, type, life, max_life, strength, attack_name, attack_value, defense_name, defense_value) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = GameDatabase.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, personnage.getName());
            ps.setString(2, personnage.getType());
            ps.setInt(3, personnage.getLife());
            ps.setInt(4, personnage.getMaxLife());
            ps.setInt(5, personnage.getAttackStrength());
            ps.setString(6, personnage.getEquipmentOffensive().getWeaponName());
            ps.setInt(7, personnage.getEquipmentOffensive().getAttackLevel());
            ps.setString(8, personnage.getEquipmentDefensif().getDefenseWeaponName());
            ps.setInt(9, personnage.getEquipmentDefensif().getDefenseLevel());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Successfully saved hero " + personnage.getName());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Personnage> getHeroes() {
        List<Personnage> savedHeroes = new ArrayList<>();
        String sql = "SELECT * FROM heroes";

        try (Connection conn = GameDatabase.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                String type = rs.getString("type").toLowerCase();
                String name = rs.getString("name");
                int life = rs.getInt("life");
                int maxLife = rs.getInt("max_life");
                int strength = rs.getInt("strength");
                String attackName = rs.getString("attack_name");
                int attackValue = rs.getInt("attack_value");
                String defenseName = rs.getString("defense_name");
                int defenseValue = rs.getInt("defense_value");

                Personnage personnage = switch (type) {
                    case "warrior" -> new Warrior(name, type, life, maxLife, strength, attackName, attackValue, defenseName, defenseValue);
                    case "wizard" -> new Wizard(name, type, life, maxLife, strength, attackName, attackValue, defenseName, defenseValue);
                    default -> null;
                };

                if (personnage != null) {
                    savedHeroes.add(personnage);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return savedHeroes;
    }

}
