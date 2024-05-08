package original;

public class Movie {
	String title;
	String cast;
	String category;
	String releaseDate; 
	String budget;
	public Movie(String title, String cast, String category, String releaseDate, String budget) {
		this.title = title;
		this.cast = cast;
		this.category = category;
		this.releaseDate = releaseDate;
		this.budget = budget;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCast() {
		return cast;
	}
	public void setCast(String cast) {
		this.cast = cast;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getReleasDate() {
		return releaseDate;
	}
	public void setReleaseDate(String release_date) {
		this.releaseDate = release_date;
	}
	public String getBudget() {
		return budget;
	}
	public void setBudget(String budget) {
		this.budget = budget;
	}
	@Override
	public String toString() {
		return "Movie title=" + title + ", cast=" + cast + ", category=" + category + ", release_date=" + releaseDate
				+ ", budget=" + budget;
	}
	
}
