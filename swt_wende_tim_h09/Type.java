/**
 * Type Klasse
 * 
 * @author Tim Wende
 *
 */
public class Type {
	public final String bezeichnung;
	
	/**
	 * default ctor
	 * 
	 * @param bezeichnung Bezeichnung
	 */
	public Type(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}
	
	/**
	 * toString
	 */
	public String toString() {
		return bezeichnung;
	}
}
