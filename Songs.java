package musicstreaming.songs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Songs {

    public void displaySongs(Connection con) {

        String sql = "SELECT * FROM songs ORDER BY id";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            boolean found = false;

            System.out.println("\n=== All Songs ===");

            while (rs.next()) {
                found = true;

                System.out.println("--------------------");
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Song: " + rs.getString("title"));
                System.out.println("Artist: " + rs.getString("artist"));
                System.out.println("Album: " + rs.getString("album"));
                System.out.println("Genre: " + rs.getString("genre"));
                System.out.println("Duration: "
                        + rs.getInt("duration_seconds") + " seconds");
            }

            if (!found) {
                System.out.println("No songs available.");
            }

            rs.close();
            ps.close();

        } catch (SQLException e) {
            System.out.println("Error displaying songs: " + e.getMessage());
        }
    }
}