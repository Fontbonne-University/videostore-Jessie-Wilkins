package videoStore;

public class ChildrensMovie extends Movie {

	public ChildrensMovie(String title) {
		super(title);
	
	}

	@Override
	protected double determineAmount(int daysRented) {

		// determines the amount for each line
		
		double rentalAmount = 1.5;
		if (daysRented > 3)
			rentalAmount += (daysRented - 3) * 1.5;
			
		
		return rentalAmount;
	}

	@Override
	protected int determineFrequentRenterPoints(int daysRented) {
		
		return 1;
	}

}
