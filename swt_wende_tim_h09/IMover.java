/**
 * Mover Interface
 * 
 * @author Tim Wende
 *
 */
public interface IMover {
	/**
	 * Bewegungsschema
	 * 
	 * @param move Move
	 * @return Berechneter Schaden
	 */
	public int use(Move move);
}
