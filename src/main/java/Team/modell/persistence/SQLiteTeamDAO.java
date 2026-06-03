package Team.modell.persistence;

import Team.modell.TeamDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class SQLiteTeamDAO implements repoDAO <TeamDTO> {




    public static void createTable() {

        String sql = "CREATE TABLE IF NOT EXISTS teams (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT NOT NULL , " +
                "baseLocation TEXT, " +
                "coachName TEXT " +
                ");";


        try (var statement = FactoryConnection.getPreparedStatement(sql)) {
            statement.execute();
        } catch (SQLException e) {
            System.err.println("Erro ao criar o banco de dados: " + e.getMessage());
        }
    }


    @Override
    public void save(TeamDTO dto) {
        String sql = "INSERT INTO teams ( name,baseLocation,coachName) VALUES ( ?, ?, ?)";
        try (var statement = FactoryConnection.getPreparedStatement(sql)) {

            statement.setString(1, dto.name());
            statement.setString(2, dto.baseLocation());
            statement.setString(3, dto.coachName());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<TeamDTO> findOne(String name) {
        String sql = "SELECT * FROM teams  WHERE name = ?";
        try (var statement = FactoryConnection.getPreparedStatement(sql)) {
            statement.setString(1, name);
            final ResultSet rs = statement.executeQuery(); // executes a statement that returns data
            if (rs.next())
                return Optional.of(new TeamDTO(rs.getInt("id"),rs.getString("name"), rs.getString("baseLocation"),rs.getString("coachName")));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public void update(TeamDTO dto) {
        String sql = "UPDATE  teams SET name = ?,baseLocation= ?,coachName=? WHERE id = ?";
        try (var statement = FactoryConnection.getPreparedStatement(sql)) {
            statement.setInt(1, dto.id());
            statement.setString(2, dto.name());
            statement.setString(3, dto.baseLocation());
            statement.setString(4, dto.coachName());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String sku) {
        String sql = "DELETE FROM teams WHERE code = ?";
        try (var statement = FactoryConnection.getPreparedStatement(sql)) {
            statement.setString(1, sku);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
