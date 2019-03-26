package atj.rest.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ExchangeRatesSeries")
public class ExchangeRatesSeries {
	private Rates Rates;
	private String Table;
	private String Currency;
	private String Code;
	
	 @XmlElement(name="Rates")
	public Rates getRates() {
		return Rates;
	}

	public void setRates(Rates Rates) {
		this.Rates = Rates;
	}
	 @XmlElement(name="Table")
	public String getTable() {
		return Table;
	}

	public void setTable(String Table) {
		this.Table = Table;
	}
	 @XmlElement(name="Currency")
	public String getCurrency() {
		return Currency;
	}

	public void setCurrency(String Currency) {
		this.Currency = Currency;
	}
	 @XmlElement(name="Code")
	public String getCode() {
		return Code;
	}

	public void setCode(String Code) {
		this.Code = Code;
	}

	@Override
	public String toString() {
		return "ClassPojo [Rates = " + getRates() + ", Table = " + getTable() + ", Currency = " + getCurrency() + ", Code = " + getCode()
				+ "]";
	}
}