package atj.rest.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Rates {
	private Rate[] Rate;
	 @XmlElement(name="Rate")
	public Rate[] getRate() {
		return Rate;
	}

	public void setRate(Rate[] Rate) {
		this.Rate = Rate;
	}

	@Override
	public String toString() {
		return "ClassPojo [Rate = " + getRate() + "]";
	}
}