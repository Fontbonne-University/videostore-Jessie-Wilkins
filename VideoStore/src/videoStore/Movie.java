package videoStore;
public abstract class Movie
{
	
	private String title;
	protected int priceCode;
	
	public Movie (String title) {
		this.title 		= title;
	}
	
	
	
	public String getTitle () {
		return title;
	}

	protected abstract double determineAmount(int daysRented);

	protected abstract int determineFrequentRenterPoints(int daysRented);
	
}