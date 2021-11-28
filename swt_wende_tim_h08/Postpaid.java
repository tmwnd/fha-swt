import java.util.ArrayList;

public class Postpaid implements IAbrechnungsart {
	private static ArrayList<Integer> vordefinierteZahlintervalle = new ArrayList<>();
	
	/**
	 * Gibt die static ArrayList mit allen vordefinierten Zahlintervallen zurueck
	 * 
	 * @return alle vordefinierten Zahlintervalle
	 */
	public static ArrayList<Integer> getVordefinierteZahlintervalle(){
		return vordefinierteZahlintervalle;
	}
	
	/**
	 * fuegt ein Zahlungsintervall der Abrechnungsart hinzu
	 * 
	 * @param intevall Intervall (in Nachrichten)
	 */
	public static void addVordefiniertesZahlintervall(int intevall) {
		vordefinierteZahlintervalle.add(intevall);
	}
	
	private final int MAX_GUTHABEN;
	private int guthaben;
	private int kosten = 1;
	
	/**
	 * default ctor
	 */
	public Postpaid() {
		this(1); // zahle jede Nachricht
	}
	
	/**
	 * default ctor
	 * Kein Mengenrabatt enthalten!
	 * Bei 1 Geld pro Nachricht zahlt man bei max_guthaben =1 exakt gleichviel wie bei =2
	 * Der einzige Unterschied ist die Haeufigkeit. (2x 1 Geld / 1x 2 Geld)
	 * 
	 * Dies wird natuerlich nicht ueber verschiedene Klassen geloest,
	 * alles andere waere ja auch peinlich tbh
	 * 
	 * @param max_guthaben Nach wie vielen Nachrichten soll gezahlt werden
	 */
	public Postpaid(int max_guthaben) {
		MAX_GUTHABEN = max_guthaben;
		guthaben = MAX_GUTHABEN;
	}
	
	@Override
	public void setKosten(int kosten) {
		this.kosten = kosten;
	}
	




	
	@Override
	public int makeRechnung() {
		if (guthaben <= 1) {
			guthaben = MAX_GUTHABEN;
			return -1 * kosten * MAX_GUTHABEN;
		}
		guthaben--;
		return 0;
	}
	
	@Override
	public String getAbrechnungsart() {
		return "Postpaid" + ((MAX_GUTHABEN == 1) ? " (alle " + MAX_GUTHABEN + " Nachrichten)" : "");
	}
}
