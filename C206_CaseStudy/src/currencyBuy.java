
public class currencyBuy extends CurrencyCentre{
	
	private double convertedBuyRate;

	public currencyBuy(String currencyCountry, String currencyName, String isoCode, double buyRate, double sellRate,
			String date, double amount, double convertedBuyRate) {
		super(currencyCountry, currencyName, isoCode, buyRate, sellRate, date, amount);
		this.convertedBuyRate = convertedBuyRate;
	}

	public double getConvertedBuyRate() {
		convertedBuyRate = getAmount() * getBuyRate();
		return convertedBuyRate;
	}
}
