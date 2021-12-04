/**
 * MoveFactory Klasse
 * 
 * @author Tim Wende
 *
 */
public class MoveFactory {
	public static final MoveFactory moveFactory = new MoveFactory();

	/**
	 * static getter
	 * 
	 * @return moveFactory
	 */
	public static final IMover DEFAULT = move -> {
		move.addPP(-1);
		System.out.print(" setzt " + move + " (" + move.type + ", " + move.getPP() + "/"
				+ move.getMaxPP() + ")" + " ein");
		return move.pwr;
	};
	
	/**
	 * default ctor
	 * 
	 * Sollte eine zweite Instanz erzeugt werden, wird ein Fehler geworfen
	 */
	public MoveFactory() {
		if (MoveFactory.moveFactory != null)
			throw new ArithmeticException("Singleton!");
	}

	/**
	 * Erstellt einen Move
	 * 
	 * @param bezeichnung Bezeichnung
	 * @param type Typ
	 * @param pwr Staerke
	 * @return Move
	 */
	public Move getMove(String bezeichnung, Type type, int pwr) {
		return getMove(bezeichnung, type, pwr, 0);
	}

	/**
	 * Erstellt einen Move
	 * 
	 * @param bezeichnung Bezeichnung
	 * @param type Typ
	 * @param pwr Staerke
	 * @param max_pp Maximale AP
	 * @return Move
	 */
	public Move getMove(String bezeichnung, Type type, int pwr, int max_pp) {
		return new Move(bezeichnung, type, pwr, max_pp);
	}

	/**
	 * Erstellt einen kopierten Move
	 * 
	 * @param move Move
	 * @return move.clone()
	 */
	public Move clone(Move move) {
		return moveFactory.addMover(new Move(move));
	}

	/**
	 * fügt ein Bewegungsschema zurück
	 * 
	 * @param move Move
	 * @return Move mit Bewegungsschema
	 */
	public Move addMover(Move move) {
		move.addMover(DEFAULT);
		return move;
	}

	/**
	 * fügt ein Bewegungsschema zurück
	 * 
	 * @param move Move
	 * @param mover Bewegungsschema
	 * @return Move mit Bewegungsschema
	 */
	public Move addMover(Move move, IMover mover) {
		move.addMover(mover);
		return move;
	}

	/**
	 * erhorht die maximalen AP
	 * 
	 * @param move Move
	 * @param pp AP
	 * @return Move mit erhoehten AP
	 */
	public Move increasePP(Move move, int pp) {
		move.increasePP(pp);
		return move;
	}
}
