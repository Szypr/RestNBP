package atj.rest.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Rate {
	private String No;
	private String Ask;
	private String Bid;
	private String EffectiveDate;
	
	@XmlElement(name="No")
	public String getNo() {
		return No;
	}

	public void setNo(String No) {
		this.No = No;
	}
	
	@XmlElement(name="Ask")
	public String getAsk() {
		return Ask;
	}

	public void setAsk(String Ask) {
		this.Ask = Ask;
	}
	
	@XmlElement(name="Bid")
	public String getBid() {
		return Bid;
	}

	public void setBid(String Bid) {
		this.Bid = Bid;
	}
	@XmlElement(name="EffectiveDate")
	public String getEffectiveDate() {
		return EffectiveDate;
	}

	public void setEffectiveDate(String EffectiveDate) {
		this.EffectiveDate = EffectiveDate;
	}

	@Override
	public String toString() {
		return "ClassPojo [No = " + getNo() + ", Ask = " + getAsk() + ", Bid = " + getBid() + ", EffectiveDate = " + getEffectiveDate()
				+ "]";
	}
}
