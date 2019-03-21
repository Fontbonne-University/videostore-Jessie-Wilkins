package videoStore;
import java.util.Vector;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class Statement 
{
	
	private String name;
	private List<Rental> rentals = new ArrayList<Rental>();
	private double totalAmount;
	private int frequentRenterPoints;
	
	public Statement (String name) {
		this.name = name;
	}
	
	public void addRental (Rental rental) {
		rentals.add (rental);
	}
	
	public String generate () {
		clearTotals();
		String 	statementText = header();
		
		statementText += rentalLines();
		
		statementText += footer();
		
		
		return statementText;
	}

	private String footer() {
		
		return String.format("You owed %.1f\nYou earned %d frequent renter points\n", totalAmount, frequentRenterPoints);
	}

	private String rentalLines() {
		String rentalLines = "";
		for (Rental rental : rentals ) {
			rentalLines += rentalLine(rental);
				
		}
		return rentalLines;
	}

	private String rentalLine( Rental rental) {
		String rentalLine = "";
		double rentalAmount = rental.determineAmount();
		frequentRenterPoints += rental.determineFrequentRenterPoints();
		totalAmount += rentalAmount;
		
		return formatRentalLine(rental, rentalAmount);
	}
	
	private String formatRentalLine(Rental rental, double rentalAmount) {
		
		return String.format("\t%s\t%.1f\n", rental.getTitle(), rentalAmount);
	}

	

	private String header() {
		
		return String.format("Rental Record for %s\n", name);
	}

	private void clearTotals() {
		totalAmount = 0;
		frequentRenterPoints = 0;
	}
	
	public double getTotal() {
		return totalAmount;
	}
	
	public int getFrequentRenterPoints() {
		return frequentRenterPoints;
	}
	
	
}