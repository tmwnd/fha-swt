/**
 * Test class
 * 
 * @author Tim Wende
 *
 */
public class Test {
	public static int MAX_LENGTH = 75;

	public static void main(String[] args) {
		Studiengang matse = new Studiengang("Angewandte Mathematik und Informatik");
		Studiengang bwl = new Studiengang("Softwaretechnik");

		Studierender tim = new Studierender("Tim Wende", 3281514, new Personalausweis(), matse);
		tim.addStudiengang(bwl);

		Studierender paddel = new Studierender("Paddel", 1234567, new Personalausweis(), matse);

		System.out.println(tim);
		System.out.println();
		System.out.println(paddel);

		System.out.println();

		Bibliothek rwthbib = new Bibliothek("RWTH Bib");

		Buch h05 = new Buch("swt_wende_tim_h05.pdf");
		rwthbib.addWartender(h05, tim);
		rwthbib.addWartender(h05, paddel);

		Buch h06 = new Buch("swt_wende_tim_h06.pdf");
		rwthbib.addWartender(h06, paddel);

		rwthbib.add(new Buch("swt_wende_tim_h01.pdf"));
		rwthbib.add(new Buch("swt_wende_tim_h02.pdf"));
		rwthbib.add(new Buch("swt_wende_tim_h03.pdf")); // mein Lieblingsbuch
		rwthbib.add(new Buch("swt_wende_tim_h04.pdf"));
		rwthbib.add(h05);
		rwthbib.add(h06);

		System.out.println();
		System.out.println(rwthbib);

		// rwthbib.ausleihen(h05, paddel); // throws error

		System.out.println();
		rwthbib.ausleihen(h05, tim); // gesperrt
		rwthbib.zurueckgeben(h05); // entsperrt
		rwthbib.ausleihen(h05, paddel);

		System.out.println();
		System.out.println(rwthbib);
	}
}
