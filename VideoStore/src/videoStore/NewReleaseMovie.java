package videoStore;

public class NewReleaseMovie extends Movie {

	public NewReleaseMovie(String title) {
		super(title);
	
	}

	@Override
	protected double determineAmount(int daysRented) {
		
		// determines the amount for each line

			
		return daysRented * 3;
	}

	@Override
	protected int determineFrequentRenterPoints(int daysRented) {
		
		return (daysRented > 1) ? 2: 1;
			
	}

}
