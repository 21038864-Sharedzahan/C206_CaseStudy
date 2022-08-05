import java.util.ArrayList;
import java.util.Currency;

public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<CurrencyCentre> CurrencyList = new ArrayList<CurrencyCentre>();

		CurrencyList.add(new CurrencyCentre("Singapore Dollar","SIN","SGP",0.00 ,0.00, "05-Aug-2022", 0));
		int option = 0;

		while (option != 5) {

			//CurrencyCentre.menu();
			option = Helper.readInt("Enter an option > ");

		}  if (option == 1) {
			// View all currency
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
		}
		else if (option == 4) {
			// Search Currency
			
		}else 
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
	
	public void searchCurrency() {
		
		String userSearchRateType = Helper.readString("Delete currency by country> ");
	}
	
	
}



