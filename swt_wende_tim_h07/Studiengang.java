import java.util.ArrayList;

/**
 * Studiengang Klasse
 * 
 * @author Tim Wende
 *
 */
public class Studiengang {
	// .. Hier die entsprechenden Attribute einpflegen
	private String bezeichnung; // unique
	private ArrayList<Studierender> teilnehmende = new ArrayList<>(); // ordered

	/**
	 * default ctor
	 * 
	 * @param bezeichnung Bezeichnung des Studiengangs
	 */
	public Studiengang(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	/**
	 * Fügt einen Teilnehmenden zum Studiengang hinzu
	 * 
	 * @param teilnehmender Teilnehmender
	 */
	public void addTeilnehmender(Studierender teilnehmender) {
		teilnehmende.add(teilnehmender);
	}

	/**
	 * default toString()
	 */
	public String toString() {
		String ret = "Bezeichnung: " + " ".repeat(8) + this.bezeichnung;
		ret += "\nTeilnehmende: " + " ".repeat(7);
		String div = "";
		for (int i = 0; i <= 3; i++) {
			if (i >= teilnehmende.size())
				break;
			ret += div + teilnehmende.get(i).getName();
			div = ", ";
		}
		if (teilnehmende.size() > 4)
			ret += ", ...";
		ret += "\nAnzahl Teilnehmende: " + teilnehmende.size();
		return ret;
	}
}
