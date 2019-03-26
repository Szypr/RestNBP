package atj.rest.service;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import atj.rest.model.ExchangeRatesSeries;
import atj.rest.model.Rate;
import atj.rest.model.Rates;

@XmlRootElement
public class RatesService {
	private String table;
	private String currency;
	private String currencyCode;
	private double midAsk;
	private double midBid;
	private long rateLength;
	

	public RatesService() {
	}

	public void calculateRates(ExchangeRatesSeries exchangeRatesSeries) {
		Rates rates = exchangeRatesSeries.getRates();
		Rate[] rate = rates.getRate();
		double sumAsk = 0;
		double sumBid = 0;
		for (Rate e : rate) {
			sumAsk += Double.valueOf(e.getAsk());
			sumBid += Double.valueOf(e.getBid());
		}
		table = exchangeRatesSeries.getTable();
		currency = exchangeRatesSeries.getCurrency();
		currencyCode = exchangeRatesSeries.getCode();
		rateLength = rate.length;
		midAsk = sumAsk / rateLength;
		midBid = sumBid / rateLength;
	}

	@XmlElement(name="Ask")
	public double getMidAsk() {
		return midAsk;
	}

	@XmlElement(name="Bid")
	public double getMidBid() {
		return midBid;
	}

	@XmlElement(name="Last")
	public long getRateLength() {
		return rateLength;
	}

	@XmlElement(name="Table")
	public String getTable() {
		return table;
	}

	@XmlElement(name="Currency")
	public String getCurrency() {
		return currency;
	}

	@XmlElement(name="Code")
	public String getCurrencyCode() {
		return currencyCode;
	}

	@Override
	public String toString() {
		return "Waluta: " + getCurrency() + ".\nSrednia z " + getRateLength() + " ostatnich dni: Ask=" + getMidAsk()+ getCurrencyCode() + ", Bid=" + getMidBid() + getCurrencyCode();
	}
	
	

}
