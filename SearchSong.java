package musicstreaming.search;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SearchSong {

    public void search(Scanner sc, Connection con) {

        System.out.print("Enter a song title or artist: ");
        String keyword = "%" + sc.nextLine() + "%";

        String sql = "SELECT * FROM songs "
                + "WHERE title LIKE ? OR artist LIKE ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, keyword);
            ps.setString(2, keyword);

            ResultSet rs = ps.executeQuery();
            boolean found = false;

            while (rs.next()) {
                found = true;

                System.out.println("--------------------");
                System.out.println("Song: " + rs.getString("title"));
                System.out.println("Artist: " + rs.getString("artist"));
                System.out.println("Album: " + rs.getString("album"));
                System.out.println("Genre: " + rs.getString("genre"));
                System.out.println("Duration: "
                        + rs.getInt("duration_seconds") + " seconds");
            }

            if (!found) {
                System.out.println("No matching songs found.");
            }

            rs.close();
            ps.close();

        } catch (SQLException e) {
            System.out.println("Search error: " + e.getMessage());
        }
    }
}