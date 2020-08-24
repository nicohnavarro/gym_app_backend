package edu.nicolasnavarro.responses;
import edu.nicolasnavarro.dao.PagoDTO;

public class PagoResponse implements EntitiesApplication<PagoDTO> {

	private PagoDTO pago;
	private String message;
	private int statusCode;
	
	public PagoResponse(PagoDTO pago) {
		this.pago=pago;
	}
	
	public PagoDTO getEntity() {
		return this.pago;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	
}
