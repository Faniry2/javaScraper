package fa.whois.model;

import java.util.Date;

public class ExceptionModel {

	private Date date;
	private String errorDetails="";
	private String messageError="";
	private String causeOfException="";
	public ExceptionModel(Date date, 
			String errorDetails,
			String messageError,
			String causeOfException) {
		super();
		this.date = date;
		this.errorDetails = errorDetails;
		this.messageError = messageError;
		this.causeOfException=causeOfException;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getErrorDetails() {
		return errorDetails;
	}
	public void setErrorDetails(String errorDetails) {
		this.errorDetails = errorDetails;
	}
	public String getMessageError() {
		return messageError;
	}
	public void setMessageError(String messageError) {
		this.messageError = messageError;
	}

	public String getCauseOfException() {
		return causeOfException;
	}

	public void setCauseOfException(String causeOfException) {
		this.causeOfException = causeOfException;
	}
}
