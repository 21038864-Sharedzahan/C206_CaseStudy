public class currencySell extends CurrencyCentre{
	
	private double convertedSellRate;

	public currencySell(String currencyCountry, String currencyName, String isoCode, double buyRate, double sellRate,
			String date, double amount, double convertedSellRate) {
		super(currencyCountry, currencyName, isoCode, buyRate, sellRate, date, amount);
		this.convertedSellRate = convertedSellRate;
	}

	public double getConvertedSellRate() {
		convertedSellRate = getAmount() * getSellRate();
		return convertedSellRate;
	}
}
