package learning;

public class Learning {

	public static void main(String[] args) {
		int q = 1234567890;
		int counter = 0;
		String str = "";
		while(q>0) {
			int mode = q%10;
			q = q/10;
			str = str + mode;
			System.out.println(q);
			counter ++;
		}
		System.out.print(str);
				String text = "hello 12345 world";
		String resutl = text.replaceAll("\\s", "-");
//		System.out.print(resutl);
		String date = "26/11/20";
		System.out.print(date.matches("[0-3][0-9]/[0-1][0-2]/\\d+{4}"));
	}

	for(int i = 0; i <=5; i++) {
			for(int j = 0; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for(int i = 5; i >=0; i--) {
			for(int j = 0; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for(int i = 5; i >=0; i--) {
			for(int j = 0; j<=5; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
			        for(int i = 1; i <=10; i++) {
	        	for(int j = 1; j<=i; j++) {
	        		if( j< 10 - i) {
	        			System.out.print(" ");
	        		} else {
	        			System.out.print("*");
	        			
	        		}
	        	}
	        	System.out.println();
	        }
}
