import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		
		ArrayList<CurrencyCentre> currencyList = new ArrayList<CurrencyCentre>();
		
		currencyList.add(new CurrencyCentre("Singapore","Singapore Dollar","SGD",0.00 ,0.00,"05-Aug-2022",0));
		currencyList.add(new CurrencyCentre("Malaysia","Ringit","MYR",0.00 ,0.00,"05-Aug-2022",0));
		currencyList.add(new CurrencyCentre("European Union","EURO's","EUR",0.00 ,0.00,"05-Aug-2022",0));
		currencyList.add(new CurrencyCentre("United States","US Dollar","USD",0.00 ,0.00,"05-Aug-2022",0));
		int option = -1;

		while (option != 11) {
			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an option > ");

		if (option == 1) {
			// View all items
			
		} else if (option == 2) {
			 // Add a new item
			String addCurrency = Helper.readString("Add currency > ");
			
		} else if (option == 3) {
			// Delete currency
	   
			
		} else if (option == 4) {
			// Search Currency
			C206_CaseStudy.searchCurrency(currencyList);
			
		} 
		
		else if (option == 5) {
			C206_CaseStudy.viewAllHoldings(currencyList);
			
		}
		
		else if (option == 6) {
			C206_CaseStudy.increaseHoldings(currencyList);
			
		}
		
		else if (option == 7) {
			C206_CaseStudy.decreaseHoldings(currencyList);
			
		}
		else if (option == 8) {
			C206_CaseStudy.AddCurrRate(currencyList);
		}
		
		else if (option == 9) {
			C206_CaseStudy.DeleteCurrRate(currencyList);
		}
		
		else if (option == 10) {
			C206_CaseStudy.UpdateCurrRate(currencyList);
		}
		
		else if (option == 11) {
			System.out.println("Bye!");
		}
		
		else {
			System.out.println("Please input a valid option!");
		}
		
	}
		
}

	public static void menu() {
		System.out.println("Money Exchange Management System");
		Helper.line(80, "-");
		System.out.println("1. Add currency");
		System.out.println("2. View currency");
		System.out.println("3. Delete currency");
		System.out.println("4. Search for Buy/Sell rate of currency");
		System.out.println("5. View All Holdings");
		System.out.println("6. Increase Holdings");
		System.out.println("7. Decrease Holdings");
		System.out.println("8. Add Currency Rate");
		System.out.println("9. Delete Currency Rate");
		System.out.println("10. Update Currency Rate");
		System.out.println("11. Quit");
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
	
	 public static String retrieveAllHoldings(ArrayList<CurrencyCentre> currencyList) {
	      String output = "";

	      for (int i = 0; i < currencyList.size(); i++) {
	        output += String.format("%-10s %-20s %.2f\n", currencyList.get(i).getIsoCode(),
	            currencyList.get(i).getCurrencyName(), currencyList.get(i).getAmount());
	      
	      }
	        return output;
	    }
	      
	    
	    public static void viewAllHoldings(ArrayList<CurrencyCentre> currencyList) {
	      String output = String.format("%-10s %-20s %-15s\n", "ISO", "NAME", "HOLDINGS");
	        output += retrieveAllHoldings(currencyList);
	        System.out.println(output);
	}
	  
	    
	    public static void increaseHoldings(ArrayList<CurrencyCentre> currencyList) {
	      String ISO = Helper.readString("Enter ISO Code (USD, EUR, SGD) > ");
	      
	      boolean isIncrease = false;
	      for (int i = 0; i < currencyList.size(); i++) {
	        if(currencyList.get(i).getIsoCode().equalsIgnoreCase(ISO)) {
	          double amount = Helper.readDouble("Enter amount to increase > ");
	          currencyList.get(i).setAmount(currencyList.get(i).getAmount() + amount);
	          System.out.println("Holdings for currency " + currencyList.get(i).getIsoCode() + " is successfully increased!");
	          isIncrease = true;
	          
	        }
	        
	        if(isIncrease = false) {
	          System.out.println("Invalid ISO Code!");
	          
	        }
	      }  
	    }
	    
	    public static void decreaseHoldings(ArrayList<CurrencyCentre> currencyList) {
	      String ISO = Helper.readString("Enter ISO Code (USD, EUR, SGD) > ");
	      
	      boolean isDecrease = false;
	      for (int i = 0; i < currencyList.size(); i++) {
	        if(currencyList.get(i).getIsoCode().equalsIgnoreCase(ISO)) {
	          double amount = Helper.readDouble("Enter amount to decrease > ");
	          currencyList.get(i).setAmount(currencyList.get(i).getAmount() - amount);
	          System.out.println("Holdings for currency " + currencyList.get(i).getIsoCode() + " is successfully decreased!");
	          isDecrease = true;
	          
	        }
	        
	        if(isDecrease = false) {
	          System.out.println("Invalid ISO Code!");
	          
	        }
	      }  
	    }
	    
		private static void AddCurrRate(ArrayList<CurrencyCentre> currencyList) {
			String ISO = Helper.readString("Enter ISO Code or Currency Name > ");
			
			for (int i = 0; i < currencyList.size(); i++) {
				if (ISO.equalsIgnoreCase(currencyList.get(i).getIsoCode()) || ISO.equalsIgnoreCase(currencyList.get(i).getCurrencyName())) {
					double BuyAmount = Helper.readDouble("Enter Buy Rate for " + ISO + " > " );
					double SellAmount = Helper.readDouble("Enter Sell Rate for " + ISO + " > ");
					String date = Helper.readString("Enter date stamp for Currency Rate (dd/mm/yyyy) > ");
					if (BuyAmount < 0 || SellAmount < 0 ) {
						System.out.println("Currency value cannot be negative. Please Input a positive value.");
					}else if (BuyAmount == 0 || SellAmount == 0) {
						System.out.println("Currency value of 0 is not Accepted. Please Input a value larger than 0.");
					}else {
						currencyList.get(i).setBuyRate(BuyAmount);
						currencyList.get(i).setSellRate(SellAmount);
						System.out.println("The Buy rate for "+  ISO +" for " + date +" of " + BuyAmount + " per SGD 1.00 is added");
					}
					
				}else {
					System.out.println("No");
				}
			}
		}
		
		private static void DeleteCurrRate(ArrayList<CurrencyCentre> currencyList) {
			
		}
		
		private static void UpdateCurrRate(ArrayList<CurrencyCentre> currencyList) {
			
		}
}



