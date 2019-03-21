package videoStore;

public class RegularMovie extends Movie {

	public RegularMovie(String title) {
		super(title);
		
	}

	@Override
	protected double determineAmount(int daysRented) {

		// determines the amount for each line
		
				double rentalAmount = 2;
				if (daysRented > 2)
					rentalAmount += (daysRented - 2) * 1.5;
				
			
		
		return rentalAmount;
	}

	@Override
	protected int determineFrequentRenterPoints(int daysRented) {
		
		
		return 1;
	}

}
