import java.util.ArrayList;

public class Nachrichtenkanal {
	private static ArrayList<Nachrichtenkanal> kanaele = new ArrayList<Nachrichtenkanal>();
	
	/**
	 * Gibt die static ArrayList mit allen Kanaelen zurueck
	 * 
	 * @return alle Kanaele
	 */
	public static ArrayList<Nachrichtenkanal> getKanaele() {
		return kanaele;
	}
	
	private String bezeichnung;
	private String content;
	private int kostenProNachricht;
	private ArrayList<Observer> observers = new ArrayList<>();
	
	/**
	 * default ctor
	 * 
	 * @param bezeichnung Bezeichnung des Nachrichtenkanals
	 */
	public Nachrichtenkanal(String bezeichnung) {
		// 1 Geld pro Nachricht; das ist ja fast schon schlimmer als mms
		this(bezeichnung, 1);
	}

	/**
	 * default ctor
	 * 
	 * @param bezeichnung Bezeichnung des Nachrichtenkanals
	 * @param kostenProNachricht Kosten pro Nachricht
	 */
	public Nachrichtenkanal(String bezeichnung, int kostenProNachricht) {
		this.bezeichnung = bezeichnung;
		this.kostenProNachricht = kostenProNachricht;
		kanaele.add(this);
	}
	
	/**
	 * gibt die Bezeichnung des Nachrichtenkanals zurueck
	 * 
	 * @return Bezeichnung des Nachrichtenkanals
	 */
	public String getBezeichnung() {
		return bezeichnung;
	}
	
	/**
	 * Gibt den Content des Nachrichtenkanals zurueck
	 * 
	 * @return Content des Nachrichtenkanals
	 */
	public String getContent() {
		return content;
	}
	

	/**
	 * gibt die Kosten pro Nachricht zurueck
	 * 
	 * @return Kosten pro Nachricht
	 */
	public int getKostenProNachricht() {
		return kostenProNachricht;
	}
	
	/**
	 * gibt die Statistik des Nachrichtenkanals zurueck
	 * 
	 * @return Statistik des Nachrichtenkanals
	 */
	public String getStatistik() {
		return bezeichnung + " - " + kostenProNachricht +
			"€/Nachricht - Anzahl der AbonnentInnen: " + observers.size();
	}

	/**
	 * Erstellt einen Observer fuer ein passendes Abonnement
	 * 
	 * @param kundIn KundIn
	 * @param abrechnungsart Objekt des Interfaces Abrechnungsart
	 * @return Observer
	 */
	public Observer makeObserver(KundIn kundIn, IAbrechnungsart abrechnungsart) {
		abrechnungsart.setKosten(kostenProNachricht);
		Observer observer = new Observer(kundIn, abrechnungsart, this);
		observers.add(observer);
		return observer;
	}

	/**
	 * Loescht dem Observer, falls ein/e KundIn nicht gezahlt haben sollte
	 * 
	 * @param observer zu loeschender Observer
	 */
	public void removeObserver(Observer observer) {
		observers.remove(observer);
	}

	/**
	 * Setzt den Content des Kanals ohne ueberpruefung dessen neu
	 * 
	 * @param content zu setzender Content
	 */
	public void update(String content) {
		System.out.println("#" + bezeichnung + " update: " + content);
		this.content = content;
		for (Observer observer : (ArrayList<Observer>) observers.clone())
			observer.benachrichtige(content);
	}
	
	/**
	 * toString
	 */
	public String toString() {
		return bezeichnung;
	}


	/**
	 * toString in schoen
	 */
	public void print() {		
		String ret = "Bezeichnung: " + bezeichnung + "\nContent: " + " ".repeat(4) + content;
		
		if (observers.size() == 0) {
			System.out.println(Test.box(ret));
			return;
		}
		
		String observerbox = "";
		String div = "";
		for (Observer observer : this.observers) {
			observerbox += div + observer.toString();
			div = "\n\n";
		}
		System.out.println(Test.box(ret + "\n\nAbonnentInnen (" + observers.size() +
			"):\n" + Test.box(observerbox, Test.MAX_WIDTH - 6)));
	}
}
