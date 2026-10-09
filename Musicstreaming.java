package musicstreaming.main;

import java.sql.Connection;
import java.util.Scanner;

import musicstreaming.database.DBConnection;
import musicstreaming.songs.Songs;
import musicstreaming.add.AddSong;
import musicstreaming.search.SearchSong;

public class Musicstreaming {

    public static void main(String[] args) {

        try (Connection con = DBConnection.getConnection();
             Scanner sc = new Scanner(System.in)) {

            System.out.println("MySQL Connected Successfully!");

            Songs songs = new Songs();
            AddSong add = new AddSong();
            SearchSong search = new SearchSong();

            while (true) {
                System.out.println("\n=== Music Streaming Service ===");
                System.out.println("1. Add a song");
                System.out.println("2. View all songs");
                System.out.println("3. Search songs");
                System.out.println("4. Exit");
                System.out.print("Choose an option: ");

                String choice = sc.nextLine();

                switch (choice) {
                    case "1":
                        add.add(sc, con);
                        break;
                    case "2":
                        songs.displaySongs(con);
                        break;
                    case "3":
                        search.search(sc, con);
                        break;
                    case "4":
                        System.out.println("Goodbye!");
                        return;
                    default:
                        System.out.println("Invalid option!");
                }
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}