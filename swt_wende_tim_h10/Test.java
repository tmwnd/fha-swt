import java.util.Scanner;

public class Test {
	public static void eingabe() {
		int eingabe;
		Scanner sc = new Scanner(System.in);
		Context_PolitikerIn politikerIn = new Context_PolitikerIn();
		
		while (politikerIn.isAktiv()) {
			System.out.println("Welches n�chste Ereignis?\n" + " (0) Lob von der eigenen Partei\n"
					+ " (1) Tadel von der eigenen Partei\n"
					+ " (2) Lob von der Wirtschaft\n" + " (3) Erwischt\n" + " (*) exit");
			eingabe = sc.nextInt();
			switch (eingabe) {
			case 0:
				politikerIn.parteilob();
				break;
			case 1:
				politikerIn.parteitadel();
				break;
			case 2:
				politikerIn.wirtschaftslob();
				break;
			case 3:
				politikerIn.erwischt();
				break;
			default:
				return;
			}
			System.out.println("Fiktiver Politiker befindet sich in" + " (Teil)-Zust�nden: " + politikerIn);
		}

		sc.close();
	}
	
	public static void a_i() {
		Context_PolitikerIn politikerIn = new Context_PolitikerIn();
		politikerIn.parteilob();
		politikerIn.parteitadel();
		System.out.println(politikerIn);
	}
	
	public static void a_ii() {
		Context_PolitikerIn politikerIn = new Context_PolitikerIn();
		politikerIn.parteilob();
		politikerIn.wirtschaftslob();
		politikerIn.wirtschaftslob();	
		System.out.println(politikerIn);	
	}
	
	public static void a_iii() {
		Context_PolitikerIn politikerIn = new Context_PolitikerIn();
		politikerIn.parteilob();
		politikerIn.wirtschaftslob();
		politikerIn.parteilob();
		politikerIn.wirtschaftslob();
		System.out.println(politikerIn);
	}
	
	
	public static void a_iv() {
		Context_PolitikerIn politikerIn = new Context_PolitikerIn();
		politikerIn.parteilob();
		politikerIn.wirtschaftslob();
		politikerIn.erwischt();
		System.out.println(politikerIn);
	}

	public static void main(String[] args) {
//		a_i();
//		a_ii();
//		a_iii();
//		a_iv();
		
		eingabe();
	}
}
