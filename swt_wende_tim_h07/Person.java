/**
 * abstract Person Klasse
 * 
 * @author Tim Wende
 *
 */
public abstract class Person {
	// .. Hier die entsprechenden Attribute einpflegen
	protected String name;
	protected Personalausweis personalausweis; // unique

	/**
	 * default ctor
	 * 
	 * @param name            Name der Person
	 * @param personalausweis Personalausweis der Person
	 */
	public Person(String name, Personalausweis personalausweis) {
		this.name = name;
		this.personalausweis = personalausweis;
		personalausweis.setPerson(this);
	}

	/**
	 * Gibt den Namen der Person zurück
	 * 
	 * @return Name
	 */
	public String getName() {
		return name;
	}

	/**
	 * default toString()
	 */
	public String toString() {
		String ret = "Name: " + " ".repeat(11) + name;
		ret += "\nPersonalausweis: " + personalausweis.getID();
		return ret;
	}
}
