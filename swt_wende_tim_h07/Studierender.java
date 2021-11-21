import java.util.ArrayList;

/**
 * Studierender Klasse
 * 
 * @author Tim Wende
 *
 */
public class Studierender extends Person {
	// .. Hier die entsprechenden Attribute einpflegen
	private final int matrikelnummer; // unique
	private ArrayList<Studiengang> studiengaenge = new ArrayList<>(); // ordered
	private ArrayList<Bibliothek> bibliotheken = new ArrayList<>();

	/**
	 * default ctor
	 * 
	 * @param name            Name des Studierenden
	 * @param matrikelnummer  Matrikelnummer des Studierenden
	 * @param personalausweis Personalausweis des Studierenden
	 * @param studiengang     Erster Studiengang des Studierenden
	 */
	public Studierender(String name, int matrikelnummer, Personalausweis personalausweis, Studiengang studiengang) {
		super(name, personalausweis);
		this.matrikelnummer = matrikelnummer;
		addStudiengang(studiengang);
	}

	/**
	 * Fügt einene Studiengang zum Studierenden hinzu
	 * 
	 * @param studiengang Studiengang
	 */
	public void addStudiengang(Studiengang studiengang) {
		studiengaenge.add(studiengang);
		studiengang.addTeilnehmender(this);
	}

	/**
	 * Werde benachrichtigt
	 */
	public void benachrichtige() {
	}

	/**
	 * default toString() in schön
	 */
	@Override
	public String toString() {
		String ret = "|" + " ".repeat((Test.MAX_LENGTH - 2 - name.length()) / 2) + name;
		ret += "\n|\n|  " + super.toString().replace("\n", "\n|  ").replace(":", ":" + " ".repeat(2));
		ret += "\n|  Matrikelnummer: " + " ".repeat(3) + matrikelnummer;
		ret += "\n|\n|  Studiengänge:";
		ret += "\n|  +" + "-".repeat(Test.MAX_LENGTH - 8) + "+";
		String div = "";
		for (Studiengang studiengang : studiengaenge) {
			ret += div + "\n|  | " + studiengang.toString().replace("\n", "\n|  | ");
			div = "\n|  |";
		}
		ret += "\n|  +" + "-".repeat(Test.MAX_LENGTH - 8) + "+";

		String out = "+" + "-".repeat(Test.MAX_LENGTH - 2) + "+";
		for (String line : ret.split("\n")) {
			if (line.startsWith("|  |"))
				out += "\n" + line + " ".repeat(Test.MAX_LENGTH - 4 - line.length()) + "|  |";
			else
				out += "\n" + line + " ".repeat(Test.MAX_LENGTH - 1 - line.length()) + "|";
		}

		return out + "\n+" + "-".repeat(Test.MAX_LENGTH - 2) + "+";
	}
}
