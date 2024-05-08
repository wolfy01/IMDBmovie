package original;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class user_menu {
	private static List<Movie> movies = new ArrayList<>();
	private static List<String> favmovies = new ArrayList<>();
	Scanner s=new Scanner(System.in);
	public user_menu(String email) {
		readMoviesFromFile("movies.txt");
		readfavmoviesfromfile(email + "_movielist.txt");
	}

    private void readfavmoviesfromfile(String filename) {
    	try {
            Scanner scanner = new Scanner(new File(filename));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                favmovies.add(line); 
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Your favorite movie list is empty add some movies.");
            //e.printStackTrace();
        }
		
	}

	public void readMoviesFromFile(String filename) {
        try {
            Scanner scanner = new Scanner(new File(filename));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("/");
                if (parts.length == 5) {
                    Movie movie = new Movie(parts[0], parts[1], parts[2], parts[3], parts[4]);
                    movies.add(movie);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
            e.printStackTrace();
        }
    }
    
    public void allmovies() {
		for(Movie m:movies) {
			System.out.println(m.toString());
		}
		//movies.clear();
	}
    
    public void allfavmovies() {
		if(favmovies.size()!=0) {
			for(String m:favmovies) {
				System.out.println(m.toString());
			}
		}
		else {
			System.out.println("No favourite movie in list.");
		}
	}
    public void addfavmovies(String email) {
    	int idx=0;
		for(Movie m:movies) {
			System.out.println(++idx +" "+ m.toString());
		}
		System.out.println("Enter the serial number of the movie to add in favourite list (like 1 or 2 or 3) : ");
		int mid=s.nextInt();
		if (mid >= 1 && mid <=movies.size()&&!favmovies.contains(movies.get(mid-1).toString())) {
			favmovies.add(movies.get(mid-1).toString());
			try {
	            FileWriter writer = new FileWriter(email + "_movielist.txt",true);
	            writer.write(movies.get(mid-1).toString() + "\n");
	            writer.close();
	        } catch (IOException e) {
	            System.out.println("Error saving user's favorite movies to file.");
	            e.printStackTrace();
	        }
			System.out.println("Movie added successfully");
		}else {
			System.out.println("The movie is already in the list.");
		}
		//movies.clear();
		
	}
    
    public void removefavmovie(String email) {
        int idx = 0;
        for (String m : favmovies) {
            System.out.println(++idx + " " + m.toString());
        }
        System.out.println("Enter the serial number of the movie to remove from favorite list (like 1 or 2 or 3) : ");
        int mid = s.nextInt();
        if (mid >= 1 && mid <= favmovies.size()) {
            favmovies.remove(mid - 1); 
            try {
                FileWriter writer = new FileWriter(email + "_movielist.txt",false);
                for (String movie : favmovies) {
                    writer.write(movie + "\n");
                }
                writer.close();
                System.out.println("Movie removed from favorites successfully.");
            } catch (IOException e) {
                System.out.println("Error saving user's favorite movies to file.");
                e.printStackTrace();
            }
        } else {
            System.out.println("Invalid serial number.");
        }
    }


    public void searchMovies(String query) {
        List<Movie> matchingMovies = new ArrayList<>();
        for (Movie movie : movies) {
            if (movie.getTitle().toLowerCase().contains(query.toLowerCase())||movie.getCast().toLowerCase().contains(query.toLowerCase())||movie.getCategory().toLowerCase().contains(query.toLowerCase())) {
                matchingMovies.add(movie);
            } 
        }

        Collections.sort(matchingMovies, Comparator.comparing(Movie::getTitle));
        if(matchingMovies.size()!=0) {
        	System.out.println("Matching movies for "+ " '" + query + "':");
            for (Movie m: matchingMovies) {
                System.out.println(m.toString());
            }
        }
        else {
        	System.out.println("No matching movie in list.");
        }
		//movies.clear();
    }
    public void searchfavMovies(String query) {
        List<String> matchingMovies = new ArrayList<>();
        for (String movie : favmovies) {
            if (movie.toLowerCase().contains(query.toLowerCase())) {
                matchingMovies.add(movie);
            } 
        }

        Collections.sort(matchingMovies);
        if(matchingMovies.size()!=0) {
        	System.out.println("Matching movies for "+ " '" + query + "':");
            for (String m: matchingMovies) {
                System.out.println(m);
            }
        }
        else {
        	System.out.println("No matching movie in list.");
        }
    }
    public void clearlists() {
		movies.clear();
		favmovies.clear();
	}
    
}
