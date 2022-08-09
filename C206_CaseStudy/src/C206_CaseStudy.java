import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		
		ArrayList<CurrencyCentre> currencyList = new ArrayList<CurrencyCentre>();
		
		currencyList.add(new CurrencyCentre("Singapore Dollar","SIN","SGP",0.00 ,0.00,"05-Aug-2022",0));
		
		int option = -1;

		while (option != 5) {

			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an option > ");

		}  if (option == 1) {
			//View all currency
			//CurrencyCentre.viewAllCurrency(CurrencyList);
			
		} else if (option == 2) {
			// Add item
			//CurrencyCentre.setHeader("ADD CURRENCY");

			String addCurrency = Helper.readString("Add currency > ");

			//addCurrency.add(CurrencyList);
			
		} else if (option == 3) {
			// Delete currency
			//CurrencyCentre.setHeader("DELETE CURRENCY");
			String delCurrency = Helper.readString("Delete currency by country> ");
			//delCurrency.remove(CurrencyList);
			
		} else if (option == 4) {
			// Search Currency
			System.out.println("Ping!");
			C206_CaseStudy.searchCurrency(currencyList);
			
		} else 
			System.out.println("Bye!");
	}

	public static void menu() {
		//CurrencyCentre.setHeader("CURRENCY EXCHANGE APP");
		System.out.println("1. Add currency");
		System.out.println("2. View currency");
		System.out.println("3. Delete currency");
		System.out.println("4. Search for Buy/Sell rate of currency");
		System.out.println("5. Quit");
		Helper.line(80, "-");

	}

	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}
	
	public static String searchCurrency(ArrayList<CurrencyCentre> currencyList) {
		
		String output = String.format("%-20s %-10s %-20s %-10s\n", "CURRENT COUNTRY","AMOUNT","OTHER COUNTRY","CONVERTED BUY RATE");
		
		String userSearchRateType = Helper.readString("Enter viewing of Buy or Sell Rate > ");
		
		Helper.line(80, "-");
		System.out.println("MENU");
		System.out.println("1.Search by country name.");
		System.out.println("2.Search by iso code.");
		Helper.line(80, "-");
		
		int userSearchPref = Helper.readInt("Enter option > ");
		
		if (userSearchPref == 1) {
			String userCountry = Helper.readString("Enter country name > ");
			double userAmount = Helper.readDouble("Enter amount to Buy/Sell");
			
			for (CurrencyCentre i : currencyList) {
				if (userSearchRateType.equalsIgnoreCase("Buy")) {
					output += String.format("%-20s %-10d %-20s %-10d.2f\n", userCountry, userAmount, i.getCurrencyCountry(), i.getConvertedBuyRate(userAmount));
				}
				else if (userSearchRateType.equalsIgnoreCase("Sell")) {
					output += String.format("%-20s %-10d %-20s %-10d.2f\n", userCountry, userAmount, i.getCurrencyCountry(), i.getConvertedSellRate(userAmount));
				}
				else {
					output = "Invalid input! Please enter buy or sell.";
				}
			}
		}
		
		else if (userSearchPref == 2) {
			output = String.format("%-10s %-10s %-10s %-10s\n", "CURRENT ISO CODE", "AMOUNT","OTHER ISO CODE", "CONVERTED BUY RATE");
			String isoCode = Helper.readString("Enter ISO Code > ");
			double userAmount = Helper.readDouble("Enter amount to Buy/Sell");
			
			for (CurrencyCentre i : currencyList) {
				if (userSearchRateType.equalsIgnoreCase("Buy")) {
						output += String.format("%-10s %-10d %-10s %-10d.2f\n", isoCode, i.getAmount(), i.getIsoCode(), i.getConvertedBuyRate(userAmount));
				}
				else if (userSearchRateType.equalsIgnoreCase("Sell")) {
					output += String.format("%-10s %-10d %-10s %-10d.2f\n", isoCode, i.getAmount(), i.getIsoCode(), i.getConvertedSellRate(userAmount));
				}
				else {
					output = "Invalid input! Please enter buy or sell.";
				}
			}
		}
		return output;
	}
}



