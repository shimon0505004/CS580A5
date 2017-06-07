/**
 * 
 */
package a1.skshimon;

/**
 * @author skshimon
 *
 */
public class Roman {

	
	public int toDecimal(String romanNumber) throws InvalidNumberException
    {
		if(romanNumber!=null && !romanNumber.isEmpty()){
			return this.toDecimal_ActualConvertion(romanNumber.toUpperCase(),romanNumber);			
		}else{
			throw new InvalidNumberException(romanNumber);
		}
    }
	
	
	private int toDecimal_ActualConvertion(String modifiedRomanNumber, String originalRomanNumber) throws InvalidNumberException{
		
		/*
		 * CMD is invalid, MCD=1400 is valid
		 * CMC is invalid, M=1000 is valid
		 * DCD is invalid, CM = 900 is valid
		 * CDC is invalid, D = 500 is valid
		 * XCL is invalid, CXL = 140 is valid
		 * XCX is invalid, C = 100 is valid
		 * LXL is invalid, XC = 90 is valid
		 * XLX is invalid, L = 50 is valid
		 * IXV is invalid, XIV = 14 is valid
		 * IXI is invalid, X = 10 is valid
		 * VIV is invalid, IX = 9 is valid
		 * IVI is invalid, V = 5 is valid
		 * IIII is invalid, IV = 4 is valid
		 * VV is invalid, X = 10 is valid
		 * LL is invalid, C = 100 is valid
		 * DD is invalid, M = 1000 is valid
		 * XXXX is invalid, XL = 40 is valid
		 * CCCC is invalid, CD = 400 is valid 
		 */
		if(modifiedRomanNumber.startsWith("CMD")){
			throw new InvalidNumberException(originalRomanNumber);
		}else if(modifiedRomanNumber.startsWith("CMC")){
			throw new InvalidNumberException(originalRomanNumber);
		}else if(modifiedRomanNumber.startsWith("DCD")){
			throw new InvalidNumberException(originalRomanNumber);			
		}else if(modifiedRomanNumber.startsWith("CDC")){
			throw new InvalidNumberException(originalRomanNumber);			
		}else if(modifiedRomanNumber.startsWith("XCL")){
			throw new InvalidNumberException(originalRomanNumber);			
		}else if(modifiedRomanNumber.startsWith("XCX")){
			throw new InvalidNumberException(originalRomanNumber);			
		}else if(modifiedRomanNumber.startsWith("LXL")){
			throw new InvalidNumberException(originalRomanNumber);			
		}else if(modifiedRomanNumber.startsWith("XLX")){
			throw new InvalidNumberException(originalRomanNumber);			
		}else if(modifiedRomanNumber.startsWith("IXV")){
			throw new InvalidNumberException(originalRomanNumber);			
		}else if(modifiedRomanNumber.startsWith("IXI")){
			throw new InvalidNumberException(originalRomanNumber);			
		}else if(modifiedRomanNumber.startsWith("VIV")){
			throw new InvalidNumberException(originalRomanNumber);			
		}else if(modifiedRomanNumber.startsWith("IVI")){
			throw new InvalidNumberException(originalRomanNumber);			
		}else if(modifiedRomanNumber.startsWith("IIII")){
			throw new InvalidNumberException(originalRomanNumber);
		}else if(modifiedRomanNumber.startsWith("VV")){
			throw new InvalidNumberException(originalRomanNumber);
		}else if(modifiedRomanNumber.startsWith("LL")){
			throw new InvalidNumberException(originalRomanNumber);
		}else if(modifiedRomanNumber.startsWith("DD")){
			throw new InvalidNumberException(originalRomanNumber);
		}else if(modifiedRomanNumber.startsWith("XXXX")){
			throw new InvalidNumberException(originalRomanNumber);
		}else if(modifiedRomanNumber.startsWith("CCCC")){
			throw new InvalidNumberException(originalRomanNumber);
		}else if(modifiedRomanNumber.startsWith("IV")){
			return 4 + this.toDecimal_ActualConvertion(modifiedRomanNumber.substring(2),originalRomanNumber);
		}else if(modifiedRomanNumber.startsWith("IX")){
			return 9 + this.toDecimal_ActualConvertion(modifiedRomanNumber.substring(2),originalRomanNumber);
		}else if(modifiedRomanNumber.startsWith("XL")){
			return 40 + this.toDecimal_ActualConvertion(modifiedRomanNumber.substring(2),originalRomanNumber);
		}else if(modifiedRomanNumber.startsWith("XC")){
			return 90 + this.toDecimal_ActualConvertion(modifiedRomanNumber.substring(2),originalRomanNumber);
		}else if(modifiedRomanNumber.startsWith("CD")){
			return 400 + this.toDecimal_ActualConvertion(modifiedRomanNumber.substring(2),originalRomanNumber);
		}else if(modifiedRomanNumber.startsWith("CM")){
			return 900 + this.toDecimal_ActualConvertion(modifiedRomanNumber.substring(2),originalRomanNumber);
		}else if(modifiedRomanNumber.startsWith("I")){
			return 1 + this.toDecimal_ActualConvertion(modifiedRomanNumber.substring(1),originalRomanNumber);
		}else if(modifiedRomanNumber.startsWith("V")){
			return 5 + this.toDecimal_ActualConvertion(modifiedRomanNumber.substring(1),originalRomanNumber);
		}else if(modifiedRomanNumber.startsWith("X")){
			return 10 + this.toDecimal_ActualConvertion(modifiedRomanNumber.substring(1),originalRomanNumber);
		}else if(modifiedRomanNumber.startsWith("L")){
			return 50 + this.toDecimal_ActualConvertion(modifiedRomanNumber.substring(1),originalRomanNumber);
		}else if(modifiedRomanNumber.startsWith("C")){
			return 100 + this.toDecimal_ActualConvertion(modifiedRomanNumber.substring(1),originalRomanNumber);
		}else if(modifiedRomanNumber.startsWith("D")){
			return 500 + this.toDecimal_ActualConvertion(modifiedRomanNumber.substring(1),originalRomanNumber);
		}else if(modifiedRomanNumber.startsWith("M")){
			return 1000 + this.toDecimal_ActualConvertion(modifiedRomanNumber.substring(1),originalRomanNumber);
		}else if(modifiedRomanNumber.equals("")){
			return 0;
		}else{
			throw new InvalidNumberException(originalRomanNumber);
		}
		
	}
	
	
    public String toRoman(int decimalNumber) throws InvalidNumberException
    {
    	StringBuffer romanNumberBuffer = new StringBuffer();
    	if(decimalNumber>=1 && decimalNumber<= 4000){
    		int tempNumber = decimalNumber;

    		while(tempNumber>=1000){
    			romanNumberBuffer.append("M");
    			tempNumber-=1000;
    		}
    		if(tempNumber>=900){
    			romanNumberBuffer.append("CM");
    			tempNumber-=900;
    		}
    		if(tempNumber>=500){
    			romanNumberBuffer.append("D");
    			tempNumber-=500;
    		}
    		if(tempNumber>=400){
    			romanNumberBuffer.append("CD");
    			tempNumber-=400;
    		}
    		while(tempNumber>=100){
    			romanNumberBuffer.append("C");
    			tempNumber-=100;
    		}
    		if(tempNumber>=90){
    			romanNumberBuffer.append("XC");
    			tempNumber-=90;
    		}
    		if(tempNumber>=50){
    			romanNumberBuffer.append("L");
    			tempNumber-=50;
    		}
    		if(tempNumber>=40){
    			romanNumberBuffer.append("XL");
    			tempNumber-=40;
    		}
    		while(tempNumber>=10){
    			romanNumberBuffer.append("X");
    			tempNumber-=10;
    		}
    		if(tempNumber>=9){
    			romanNumberBuffer.append("IX");
    			tempNumber-=9;
    		}
    		if(tempNumber>=5){
    			romanNumberBuffer.append("V");
    			tempNumber-=5;
    		}
    		if(tempNumber>=4){
    			romanNumberBuffer.append("IV");
    			tempNumber-=4;
    		}
    		while(tempNumber>=1){
    			romanNumberBuffer.append("I");
    			tempNumber-=1;
    		}    		
    		
    		if(tempNumber!=0){
    			System.out.println("SHOULDNT HAPPEN");
    		}
    		return romanNumberBuffer.toString();
    	}else{
    		throw new InvalidNumberException(decimalNumber);
    	}
    	
    }
    
	
	/**
	 * @param args
	 */
    /*
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Roman classInstance = new Roman();
    	try {
    		System.out.println(classInstance.toRoman(448));
		} catch (InvalidNumberException e) {
			// TODO Auto-generated catch block
			//System.out.println("Sorry, but the entered Decimal number "+e.getDecimalNumber()+" is invalid.");
			e.printStackTrace();
		}
    	try {
			System.out.println(classInstance.toDecimal("MMDCCLI"));
		} catch (InvalidNumberException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
	}
	*/
}
