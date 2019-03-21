package tester.SubTester;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class implementer {

	public static void main(String[] args) {
		List<Integer> lint = new ArrayList<>();
		lint.add(4);
		lint.add(6);
		lint.add(5);
		lint.add(3);
		lint.add(3);
		lint.add(1);
		System.out.println(pickingNumbers(lint));
	}

	public static int pickingNumbers(List<Integer> a) {
		Integer[] aR = a.toArray(new Integer[a.size()]);
		Arrays.sort(aR);
		boolean loop = true;
		int count = 0;

		for (int i = 0; i < aR.length; i++) {
			for (int j = i; j < aR.length; j++) {
				 Integer[] tempAr = Arrays.copyOfRange(aR, i, j);
				 boolean bool = true;
				 
				 for (Integer ta : tempAr) {
					System.out.print(ta+" ");
				 }
				
				 for(int k =0; k<tempAr.length; k++) {
					 for(int l=0; l<tempAr.length;l++) {
						   
						   if(k>l) {
							 System.out.println(tempAr[k] + " " + tempAr[l]);
						   if(!(tempAr[k]-tempAr[l]>1||tempAr[k]-tempAr[l]<-1)) {
							   bool = false;
						   }
						   }
					 }
				 }
				 
				 System.out.println();
				 
				 if(bool) {
					 int tempC = tempAr.length;
					 if(tempC>=count) {
						 count = tempC;
					 }
				 }
				 
			}
		}

		return count;
	}
}
