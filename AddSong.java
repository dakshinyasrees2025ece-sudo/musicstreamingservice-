package musicstreaming.add;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AddSong {

    public void add(Scanner sc, Connection con) {

        try {
            System.out.print("Song title: ");
            String title = sc.nextLine();

            System.out.print("Artist: ");
            String artist = sc.nextLine();

            System.out.print("Album: ");
            String album = sc.nextLine();

            System.out.print("Genre: ");
            String genre = sc.nextLine();

            System.out.print("Duration in seconds: ");
            int duration = Integer.parseInt(sc.nextLine());

            String sql = "INSERT INTO songs "
                    + "(title, artist, album, genre, duration_seconds) "
                    + "VALUES (?, ?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, title);
            ps.setString(2, artist);
            ps.setString(3, album);
            ps.setString(4, genre);
            ps.setInt(5, duration);

            ps.executeUpdate();
            ps.close();

            System.out.println("Song added successfully!");

        } catch (NumberFormatException e) {
            System.out.println("Enter duration as a whole number.");
        } catch (SQLException e) {
            System.out.println("Error adding song: " + e.getMessage());
        }
    }
}