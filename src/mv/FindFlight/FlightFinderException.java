package mv.FindFlight;

public class FlightFinderException extends Exception{

	private static final long serialVersionUID = -2757711859734695683L;
	
	private String errorCode;
	private String errorDesc;
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorDesc() {
		return errorDesc;
	}
	public void setErrorDesc(String errorDesc) {
		this.errorDesc = errorDesc;
	}
	public FlightFinderException(String errorCode, String errorDesc) {
		super();
		this.errorCode = errorCode;
		this.errorDesc = errorDesc;
	}
	public FlightFinderException() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "FlightFinderException [errorCode=" + errorCode + ", errorDesc=" + errorDesc + "]";
	}
	
	
	
	
}
