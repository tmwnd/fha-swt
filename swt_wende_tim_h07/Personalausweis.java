/**
 * Personalausweis Klasse
 * 
 * @author Tim Wende
 *
 */
public class Personalausweis {
	// .. Hier die entsprechenden Attribute einpflegen
	private static int NEWID = 1;
	private int id; // unique
	private Person person;

	/**
	 * default ctor
	 */
	public Personalausweis() {
		// I solemnly swear that I'll add a Person
		this.id = getNewID();
	}

	/**
	 * Erzeugt einzigartige ID
	 * 
	 * @return Unique ID
	 */
	private static int getNewID() {
		return NEWID++;
	}

	/**
	 * Setzt die Person
	 * 
	 * @param person Person
	 */
	public void setPerson(Person person) {
		this.person = person;
	}

	/**
	 * Gibt die ID des Personalausweises zurück
	 * 
	 * @return ID
	 */
	public int getID() {
		return id;
	}
}
