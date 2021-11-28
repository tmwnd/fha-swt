import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Test {
	/*
	 * Diese Klasse ist an diversen TODO-Stellen unvollstaendig und muss ergaenzt
	 * werden.
	 */
	// merkt man; wieso Main als Objekt???
	
	public static final int MAX_WIDTH = 75;
	public static final Scanner scanner = new Scanner(System.in);
	
//private static ArrayList<KundIn> kundInnen = new ArrayList<KundIn>(); // nein :/
//private static ArrayList<Nachrichtenkanal> kanaele = new ArrayList<Nachrichtenkanal>(); // nein :/

	public static void main(String[] args) {
		//simuliere();
		
		dialog();
	}
	
	/**
	 * static simuliere
	 * 
	 * testet ein bisschen vor sich hin
	 */
	public static void simuliere(){
		KundIn tim = new KundIn("Tim Wende");
		KundIn paddel = new KundIn("Paddel", 10);
		//KundIn lambdaUser = new KundIn("LambdaUser", 160);
		
		Nachrichtenkanal heise = new Nachrichtenkanal("heise.de/newsticker", 3);
		
		new Abonnement(heise.makeObserver(tim, new Postpaid()));
		new Abonnement(heise.makeObserver(paddel, new Postpaid(3)));
		
		// Strategy-Pattern mit lambda Expressions > Strategy-Pattern
		//new Abonnement(heise.makeObserver(lambdaUser,
		//	new Abrechnungsart("Zahle jede Nachricht", betrag -> -1 * betrag)));
		//new Abonnement(heise.makeObserver(lambdaUser,
		//	new Abrechnungsart("Zahle jede Nachricht doppelt", betrag -> -2 * betrag)));
		//new Abonnement(heise.makeObserver(lambdaUser,
		//	new Abrechnungsart("Premium User; muss nichts zahlen", betrag -> 0)));
		//new Abonnement(heise.makeObserver(lambdaUser,
		//	new Abrechnungsart("Wie ich will", betrag -> 7)));
		
		for (KundIn kundIn : KundIn.getKundInnen()) {
			kundIn.print();
		}
		for (Nachrichtenkanal kanal : Nachrichtenkanal.getKanaele()) {
			kanal.print();
		}
		
		System.out.println();
		heise.update("Kurz informiert: Rangliste aller Pokemon");
		heise.update("\"Pokemon strahlender Diamant\" angespielt");
		heise.update("Praxisversuch: Panflam auf 6000�C erhitzen");
		
		System.out.println();
		for (KundIn kundIn : KundIn.getKundInnen()) {
			kundIn.print();
		}
		for (Nachrichtenkanal kanal : Nachrichtenkanal.getKanaele()) {
			kanal.print();
		}
	}
	
	/**
	 * Macht ne Box um Output drum herum
	 * 
	 * @param content Output
	 * @return drum herumte Box
	 */
	public static String box(String content) {
		return box(content, MAX_WIDTH);
	}

	/**
	 * Macht ne Box um Output drum herum
	 * 
	 * @param content Output
	 * @return drum herumte Box
	 */
	public static String box(String content, int width) {
		String ret = "+" + "-".repeat(width - 2) + "+";
		for (String line : content.split("\n"))
			ret +=	"\n|  " + line +
				" ".repeat(width - 6 - line.length()) + "  |";
		return ret + "\n+" + "-".repeat(width - 2) + "+";
	}
	
	// ab hier vorgegebene Main.java "leicht" angepasst
	
	/**
	 * static vorgegebener dialog
	 * 
	 * @author Tim Wende, swt Leuts
	 */
	public static void dialog(){
		Postpaid.addVordefiniertesZahlintervall(1);
		Postpaid.addVordefiniertesZahlintervall(3);
		
		int eingabe;
		
		do {
			System.out.println("Was wollen Sie?\n"
					+" (0) Programm beenden\n"
					+" (1) neuen Kunden erstellen\n"
					+" (2) neuen Nachrichtenkanal erstellen\n"
					+" (3) Kunde abonniert Nachrichtenkanal\n"
					+" (4) Nachrichtenkanalstatistik\n"
					+" (5) Nachricht eines Nachrichtenkanals ver�ndern");
			eingabe = nummerWaehlen();
			switch(eingabe){
			case 1: 
				neue_rKundIn();
				break;
			case 2:
				neuerNachrichtenkanal();
				break;
			case 3:
				neuesAbonnement();
				break;
			case 4:
				nachrichtenkanalStatistik();
				break;
			case 5:
				nachrichtVeraendern();
				break;
			}
		} while (eingabe != 0);
	}
	
	/**
	 * static String eingeben
	 * 
	 * @return eingegebener String
	 */
	private static String textEingeben() {
		return scanner.next();
	}
	
	/**
	 * static recursive int eingeben
	 *  
	 * @return eingegebener int
	 */
	private static int nummerWaehlen() {
		try {
			return scanner.nextInt();
		} catch (InputMismatchException e) {
			scanner.next();
			return nummerWaehlen();
		}
	}
	
	/**
	 * static generic waehle Objekt aus einer Liste
	 * Wir wollen ja keine code dopplung z.B. in neuesAbonnement; nicht wahr //@swt
	 * 
	 * @param <O> Generischer Objekttyp in der ArrayList
	 * @param list ArrayList
	 * @return Generisches Objekt an der gewaehlten stelle
	 */
	public static <O> O objectWaehlen(ArrayList<O> list) {
		if (list.size() == 0)
			throw new ArithmeticException("Liste ist leer");
		if (list.size() == 1) {
			System.out.println("Es wurde automatisch " + list.get(0) + " gew�hlt");
			return list.get(0);
		}
		int i = 1;
		for (O object : list)
			System.out.println(i++ + ": " + object);
		do
			i = nummerWaehlen();
		while (i <= 0 || i > list.size());
		return list.get(i - 1);
	}
	

	
	// Die folgenden Methoden koennen natuerlich nicht zur Automatisierung genutzt werden,
	// da per console Text eingegeben werden muss
	// Dies ist natuerlich hoechst sinnvoll; danke @swt
	
	/**
	 * static Waehle KundIn
	 * 
	 * @return gewaehlte/r KundIn
	 */
	public static KundIn kundInWaehlen() {
		System.out.println("Welche/r KundIn?");
		return (KundIn) objectWaehlen(KundIn.getKundInnen());
	}
	
	/**
	 * static Waehle Nachrichtenkanal
	 * 
	 * @return gewaehlter Nachrichtenkanal
	 */
	public static Nachrichtenkanal nachrichtenkanalWaehlen() {
		System.out.println("Welcher Nachrichtenkanal?");
		return (Nachrichtenkanal) objectWaehlen(Nachrichtenkanal.getKanaele());
	}
	
	/**
	 * static Waehle vordefiniertens Zahlungsintervall
	 * 
	 * @return gewaehltes Zahlungsintervall
	 */
	public static int vordefiniertenZahlintervallWaehlen() {
		System.out.println("Nach wie vielen Nachrichten soll gezahlt werden?");
		return (int) objectWaehlen(Postpaid.getVordefinierteZahlintervalle());		
	}
	
	/**
	 * static nachrichtVeraendern
	 */
	public static void nachrichtVeraendern() {
		System.out.print("Neue Nachricht: ");
		nachrichtenkanalWaehlen().update(textEingeben());
	}

	/**
	 * static nachrichtenkanalStatistik
	 */
	public static void nachrichtenkanalStatistik() {
		System.out.println(nachrichtenkanalWaehlen().getStatistik());
	}

	/**
	 * static neuesAbonnement
	 */
	private static void neuesAbonnement() {
		(new Abonnement(nachrichtenkanalWaehlen().makeObserver(kundInWaehlen(),
			new Postpaid(vordefiniertenZahlintervallWaehlen())))).print();
	}
	




	
	/**
	 * static neuerNachrichtenkanal
	 */
	private static void neuerNachrichtenkanal() {
		System.out.print("Bezeichnung des Nachrichtenkanals: ");
		(new Nachrichtenkanal(textEingeben(), 1)).print();;
	}
	
	/**
	 * static neue_rKundIn
	 */
	private static void neue_rKundIn() {
		System.out.print("Name des/der KundIn: ");
		(new KundIn(textEingeben())).print();
	}
}
