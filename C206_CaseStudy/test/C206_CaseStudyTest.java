import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	
	private CurrencyCentre cc1;
	private CurrencyCentre cc2;
	private CurrencyCentre cc3;
	
	private ArrayList<CurrencyCentre> currencyList;
	
	//To prevent floating point errors.
	private static final double DELTA = 1e-15;
	
	public C206_CaseStudyTest() {
		super();
	}
	
	@Before
	public void setUp() throws Exception {
		// prepare test data
		cc1 = new CurrencyCentre("Singapore Dollar","SIN","SGP",0.00 ,0.00,"05-Aug-2022",0);
		
		currencyList = new ArrayList<CurrencyCentre>();
	}
	
	@Test
	public void testBuyRateSearch() {
		
		// Test if there is a valid currencyList to search buy rate from.
		assertNotNull(currencyList);
		
		C206_CaseStudy.addCurrency(currencyList, cc1);
		
		// Test that buy rate is present for the particular currency searched. 
		assertNotNull(currencyList.get(0).getBuyRate());
		
		// Test that buy rate is for the particular currency.
		assertEquals(0, currencyList.get(0).getBuyRate(), DELTA);
	}
	
	@Test
	public void testSellRateSearch() {
		
		// Test if there is a valid currencyList to search sell rate from.
		assertNotNull(currencyList);
		
		C206_CaseStudy.addCurrency(currencyList, cc1);
		
		// Test that sell rate is present for the particular currency searched. 
		assertNotNull(currencyList.get(0).getSellRate());
		
		// Test that sell rate is for the particular currency.
		assertEquals(0, currencyList.get(0).getSellRate(), DELTA);
	}
	
	@Test
	public void testConversion() {
		
		C206_CaseStudy.addCurrency(currencyList, cc1);
		C206_CaseStudy.addCurrency(currencyList, cc2);
		C206_CaseStudy.addCurrency(currencyList, cc3);
		
		// Test that 10 SGD converts to 32.30 MYR for buy rate.
		assertEquals(32.30, currencyList.get(1).getConvertedBuyRate(10), DELTA);
		
		// Test that 1 SGD converts to 0.3105 MYR for sell rate
		assertEquals(0.3105, currencyList.get(1).getConvertedSellRate(1), DELTA);
		
		// Test that the latest date is used for conversion for buy rate.
		String correctDate = "12-08-2022";
		assertEquals(currencyList.get(0).getDate(), correctDate);
	}
	
	@After
	public void tearDown() throws Exception {
		cc1 = null;
		cc2 = null;
		cc3 = null;
		
		currencyList = null;
	}
}
