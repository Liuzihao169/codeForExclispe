package domepack;

public class text11 {
	public static void main(String[] args) {
		int i=0;
		for (int a =2;; a++) {
			if (shusu(a) && huiwen(a)) {
				i++;
					if (i % 10 == 0) {
						System.out.print(a + "\n");
					} else
						System.out.print(a + "\t");
					if(i==100){
						
						if (i==1000){break;}}
				
			}

		}

	}

	static boolean shusu(int a) {//ÅÐ¶ÏËØÊý
		boolean ml = true;
		for (int i = 2; i <=a; i++) {
			if (a % i == 0&&a!=i) {
				ml = false;

			}

		}

		return ml;
	}

	static boolean huiwen(int a) {//ÅÐ¶Ï»ØÎÄ
		boolean f = true;
		String str = Integer.toString(a);
		int low = 0;
		int c = str.length() - 1;
		while (low < c) {
			if (str.charAt(low) != str.charAt(c)) {
				f = false;
				break;
			}
			low++;
			c--;
		}
		return f;
	}

}
