import java.util.ArrayList;

/**
 * PokemonBuilder Klasse
 * 
 * @author Tim Wende
 *
 */
public class Pokemon {
	private String name;
	private int hp;
	private int atk;
	private Type type;
	private IEvolver evolver;
	private ArrayList<Move> moves = new ArrayList<>();
	
	/**
	 * default ctor
	 */
	public Pokemon(String name, int hp, int atk) {
		this.name = name;
		this.hp = hp;
		this.atk = atk;
	}

	// getter / setter Gedöns: read PokemonBuilder
	public void set(Type type) { this.type = type; }
	public void set(IEvolver evolver) { this.evolver = evolver; }
	public void add(Move move) {
		if (moves.size() > 4)
			throw new IndexOutOfBoundsException("Pokemon kann nur 4 Attacken erlernen");
		moves.add(move);
	}
	public void addHP(int hp) { this.hp += hp; }
	public void addATK(int atk) { this.atk += atk; }
	public int getHP() { return hp; }
	public int getATK() { return atk; }
	public Type getType() { return type; }
	public ArrayList<Move> getMoves() { return moves; }
	
	/**
	 * Benutze den i-ten Move 
	 * 
	 * @param i i-ter Move
	 */
	public void use(int i) {
		if (i < 0 || i >= moves.size())
			return;
		System.out.print(name + " (" + type + ")");
		int dmg = moves.get(i).use();
		System.out.println(" (-" + (atk * dmg / 100) + "HP)");
	}
	
	/**
	 * Entwickle dich!
	 * Drucke "B" um die Entwicklung abzubrechen
	 * 
	 * @return Entwickeltes Pokemon
	 */
	public Pokemon evolve() {
		return evolver.evolve(this);
	}
	
	/**
	 * toString
	 */
	public String toString() {
		return name;
	}
}
