package Chapter1;

public class Question5{
	final int numCharCodes;
	
	Question5(){
		//Assumes Simple ASCII for supported character codes
		this.numCharCodes = 128;
	}

	Question5(int numCharCodes){
		this.numCharCodes = numCharCodes;
	}
	
	public boolean isOneAway(String S1, String S2){
		if(S1 == null || S2 == null || Math.abs(S1.length() - S2.length()) > 1){
			return false;
		}
		int count = 0, minLength = Math.min(S1.length(), S2.length());
		for(int i=0; i < minLength; i++){
			char c1 = S1.charAt(i), c3 = 0;
			char c2 = S2.charAt(i), c4 = 0;
			if(c1 != c2){
				if((i + 1) <= S1.length() - 1){
					c3 = S1.charAt(i + 1);
				}
				if((i + 1) <= S2.length() - 1){
					c4 = S2.charAt(i + 1);
				}
				if(c1 == c4 || c2 == c3 || (c3 == c4 && c3 != 0)){
					count++;
					if(count > 1){
						return false;
					}
				}else{
					return false;
				}
			}
		}
		return true;
	}
}
