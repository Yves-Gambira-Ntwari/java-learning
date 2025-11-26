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

	}

}
