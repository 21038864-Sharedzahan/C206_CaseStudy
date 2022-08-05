public class CurrencyCentre {

	private String currencyCountry; 
	private String currencyName; 
	private String isoCode;
	private double buyRate;
	private double sellRate;
	private String date;
	private double amount;
	
	public CurrencyCentre(String currencyCountry, String currencyName, String isoCode, double buyRate, double sellRate,
			String date, double amount) {
		super();
		this.currencyCountry = currencyCountry;
		this.currencyName = currencyName;
		this.isoCode = isoCode;
		this.buyRate = buyRate;
		this.sellRate = sellRate;
		this.date = date;
		this.amount = amount;
	}
	
	public double getBuyRate() {
		return buyRate;
	}
	public void setBuyRate(double buyRate) {
		this.buyRate = buyRate;
	}
	public double getSellRate() {
		return sellRate;
	}
	public void setSellRate(double sellRate) {
		this.sellRate = sellRate;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getCurrencyCountry() {
		return currencyCountry;
	}
	public String getCurrencyName() {
		return currencyName;
	}
	public String getIsoCode() {
		return isoCode;
	}
	public double getConvertedBuyRate(double userAmount) {
		double convertedBuyRate = userAmount * getBuyRate();
		return convertedBuyRate;
	}
	public double getConvertedSellRate(double userAmount) {
		double convertedSellRate = userAmount * getBuyRate();
		return convertedSellRate;
	}
}