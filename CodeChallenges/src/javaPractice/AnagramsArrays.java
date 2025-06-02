package javaPractice;

public class AnagramsArrays {
	
	 static boolean isAnagram(String a, String b) {
	      boolean result = true;	   
	      int [] arrayA = new int [91]; //Bucket for a
	      int [] arrayB = new int [91]; // bucket for b
	      int indexA = 0;
	      int indexB = 0;
	      for (int i =0; i < arrayA.length; i++ ) {
	    	  arrayA[i] = 0;
	    	  arrayB[i] = 0;
	      }
	      
	      if (a.length() == b.length()) {
	    	  for (int i = 0; i < a.length(); i++) {
	    		  //read char, determine the ASCII value and increment value on respective bucket
	    		  indexA = (int)Character.toUpperCase(a.charAt(i));
	    		  indexB = (int)Character.toUpperCase(b.charAt(i));
	    		  arrayA[indexA] = arrayA[indexA] +1;
	    		  arrayB[indexB] = arrayB[indexB] +1;
	    	  }
	    	  
	      } else {
	    	  result = false;
	      }
	      if (result) {
	    	  for (int i = 0; i<arrayA.length; i++) {
	    		  if (arrayA[i]!=arrayB[i]) {
	    			  result = false;
	    			  break;
	    		  }
	    	  }
	      } 
	      return result;
	    }

	  public static void main(String[] args) {	    
	        
	        String a = "CASA";
	        String b = "AcAa";	       
	        boolean ret = isAnagram(a, b);
	        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
	    }

}
