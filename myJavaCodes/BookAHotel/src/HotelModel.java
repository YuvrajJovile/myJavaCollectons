
public class HotelModel {

	String hotelName;
	int hotelRatting;
	double costPerDay;
	int offerDays;
	double offerPercent;
	
	
	double totalCost;
	double availableMoney;
	int neededRatting;
	int numberOfDays;
	
	
	public HotelModel(String hotelName, int hotelRatting, double costPerDay, int offerDays, double offerPercent) {
		super();
		this.hotelName = hotelName;
		this.hotelRatting = hotelRatting;
		this.costPerDay = costPerDay;
		this.offerDays = offerDays;
		this.offerPercent = offerPercent;
	}
	

	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	public double getAvailableMoney() {
		return availableMoney;
	}
	public void setAvailableMoney(double availableMoney) {
		this.availableMoney = availableMoney;
	}
	public int getNeededRatting() {
		return neededRatting;
	}
	public void setNeededRatting(int neededRatting) {
		this.neededRatting = neededRatting;
	}
	public int getNumberOfDays() {
		return numberOfDays;
	}
	public void setNumberOfDays(int numberOfDays) {
		this.numberOfDays = numberOfDays;
	}
	
	
	
	public String isPreferedHotel(int ratting,int days,double money) {
		
		if(ratting==hotelRatting) {
			
			double costForDays = days>offerDays?offerPercent* (costPerDay*days):-1f;
			return (costForDays>0f)&& costForDays<=money?("Hotel Booked for "+days+" days in "+ratting+" star hotel The Park for the cost of $"+costForDays):
				"Sorry! you dont have sufficient amount to book any hotel";
		}
		return "Sorry! you dont have sufficient amount to book any hotel";
	}


	private double validateCost(int days) {
		
		return days>offerDays?offerPercent* (costPerDay*days):0f;
	}
	
	
}
