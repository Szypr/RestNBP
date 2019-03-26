package atj.rest.client;

import java.net.URI;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import atj.rest.model.ExchangeRatesSeries;


public class RatesClient {
	private ExchangeRatesSeries eRs;
	public RatesClient() {
	}
	@GET
	@Consumes(MediaType.APPLICATION_XML)
	public ExchangeRatesSeries getRates(String table, String code, String topCount) {
	Client client = ClientBuilder.newClient();
	URI uri = UriBuilder.fromPath("http://api.nbp.pl/api/exchangerates/rates/").build();
	WebTarget webTarget = client.target(uri);
	webTarget = webTarget.path(table).path(code).path("last").path(topCount);
	eRs = webTarget.request().accept(MediaType.TEXT_XML).get(ExchangeRatesSeries.class);
	
	return eRs;
	}
	
}
