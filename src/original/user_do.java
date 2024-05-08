package original;

import java.util.Scanner;

public class user_do {
	
	
	public void menus(String username) {
		Scanner s=new Scanner(System.in);
		while(true) {
			System.out.println("hello "+username+"\nPlease choose an option(Like 1 or 2)-\n1. See all movies with details.\n2. Search for movies.\n3. Add movie to favourite list.\n4. Remove movie from favourite list.\n5. Favourite movies\n6. Search from favourite movies.\n7.Log out.");
			String in= s.nextLine();
			if(in.equals("1")) {
				user_menu um= new user_menu(username);
				um.allmovies();
				um.clearlists();
			}
			else if(in.equals("2")){
				System.out.println("Enter title or cast or category of the movie you want to see.");
				String opt=s.nextLine();
				user_menu um= new user_menu(username);
	 			um.searchMovies(opt);
	 			um.clearlists();
			}
			else if(in.equals("3")) {
				user_menu um= new user_menu(username);
				um.addfavmovies(username);
				um.clearlists();
			}
			else if(in.equals("4")) {
				user_menu um= new user_menu(username);
				um.removefavmovie(username);
				um.clearlists();
			}
			else if(in.equals("5")) {
				user_menu um= new user_menu(username);
				um.allfavmovies();
				um.clearlists();
			}
			else if(in.equals("6")) {
				System.out.println("Enter title or cast or category of the movie you want to see.");
				String opt=s.nextLine();
				user_menu um= new user_menu(username);
				um.searchfavMovies(opt);
				um.clearlists();
			}
			else if(in.equals("7")) break;
			else {
				System.out.println("Invalid input!");
			}
		}
		
	}

}
