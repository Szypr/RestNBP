package atj.rest.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBException;
import atj.rest.client.RatesClient;
import atj.rest.model.ExchangeRatesSeries;
import atj.rest.service.RatesService;


@Path("exchangerates/rates")
@Consumes(MediaType.APPLICATION_XML)
public class RatesResource {
	private ExchangeRatesSeries eRs;
	private RatesService ratesService = new RatesService();
	@GET
	@Path("{table}/{code}/{topCount}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getRates(@PathParam("table") String table, @PathParam("code") String code, @PathParam("topCount") String topCount) throws JAXBException {
		
		RatesClient ratesClient = new RatesClient();
		eRs = ratesClient.getRates(table, code, topCount);
		ratesService.calculateRates(eRs);
			
		return ratesService.toString();
	}
	
	@GET
	@Path("{table}/{code}/{topCount}")
	@Produces(MediaType.TEXT_HTML)
	public String getRatesHTML(@PathParam("table") String table, @PathParam("code") String code, @PathParam("topCount") String topCount) throws JAXBException {
		
		RatesClient ratesClient = new RatesClient();
		eRs = ratesClient.getRates(table, code, topCount);
		ratesService.calculateRates(eRs);
		
//		String midAsk = String.valueOf(ratesService.getMidAsk());
//		String midBid = String.valueOf(ratesService.getMidBid());
//		String midLength = String.valueOf(ratesService.getRateLength());
//		String currencyCode = eRs.getCode();
//		String currency = eRs.getCurrency();
		
		return "<html><body><h2>" + ratesService.toString() + "</h2></body></html>";
//				"<html><body><h1>Waluta: " + currency + "</h1><h2>Srednia z " + midLength + " ostatnich dni: Ask=" + midAsk + currencyCode + ", Bid=" + midBid + currencyCode + "</h2></body></html>";
	}
	
	@GET
	@Path("{table}/{code}/{topCount}")
	@Produces(MediaType.APPLICATION_XML)
	public RatesService getRatesXML(@PathParam("table") String table, @PathParam("code") String code, @PathParam("topCount") String topCount) throws JAXBException {
		
		RatesClient ratesClient = new RatesClient();
		eRs = ratesClient.getRates(table, code, topCount);
		ratesService.calculateRates(eRs);
		
		return ratesService;	
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String test() {
		return "test";
	}
	

}
