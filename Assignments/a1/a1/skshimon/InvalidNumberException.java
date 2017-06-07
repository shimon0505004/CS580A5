package a1.skshimon;

public class InvalidNumberException extends Exception {

	private int decimalNumber;
	private String romanNumber;
	private String errorMessage;
	
	public InvalidNumberException(int decimalNumber) {
		// TODO Auto-generated constructor stub
		this.setDecimalNumber(decimalNumber);
		this.setRomanNumber(null);
		setErrorMessage("The entered decimal number " + decimalNumber + " is invalid.");
	}

	public InvalidNumberException(String romanNumber) {
		// TODO Auto-generated constructor stub
		this.setDecimalNumber(0);
		this.setRomanNumber(romanNumber);
		setErrorMessage("The entered roman number " + romanNumber + " is invalid.");
	}

	public int getDecimalNumber() {
		return decimalNumber;
	}

	public void setDecimalNumber(int decimalNumber) {
		this.decimalNumber = decimalNumber;
	}

	public String getRomanNumber() {
		return romanNumber;
	}

	public void setRomanNumber(String romanNumber) {
		this.romanNumber = romanNumber;
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return this.errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
