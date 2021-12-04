import java.util.ArrayList;

/**
 * PokemonBuilder Klasse
 * 
 * @author Tim Wende
 *
 */
public class PokemonBuilder {
	private final Pokemon pokemon;

	/**
	 * default ctor
	 * 
	 * @param name Name des Pokemon
	 */
	public PokemonBuilder(String name) {
		this(name, 10, 10);
	}

	/**
	 * default ctor
	 * 
	 * @param name Name des Pokemon
	 * @param hp Basis HP des Pokemon
	 * @param atk Basis ATK des Pokemon
	 */
	public PokemonBuilder(String name, int hp, int atk) {
		System.out.println(name + " wurde gefangen");
		pokemon = getPokemon(name, hp, atk);
	}

	/**
	 * copy ctor
	 * 
	 * @param name Neuer Name des Pokemon
	 * @param pokemon Zu kopierendes Pokemon
	 */
	public PokemonBuilder(String name, Pokemon pokemon) {
		this.pokemon = getPokemon(name, pokemon.getHP(), pokemon.getATK());
		this.with(pokemon.getType()).with(pokemon.getMoves());
	}
	
	/**
	 * private Erstellt ein Pokemon
	 * 
	 * @param name Name des Pokemon
	 * @param hp Basis HP des Pokemon
	 * @param atk Basis ATK des Pokemon
	 * @return erstelltes Pokemon
	 */
	private Pokemon getPokemon(String name, int hp, int atk) {
		return new Pokemon(name, hp, atk);		
	}

	/**
	 * Fuegt dem Pokemon einen Typ hinzu
	 * 
	 * @param type Typ
	 * @return der Pokemonbuilder
	 */
	public PokemonBuilder with(Type type) {
		pokemon.set(type);
		return this;
	}

	/**
	 * Fuegt einen move hinzu
	 * 
	 * @param move Move
	 * @return der Pokemonbuilder
	 */
	public PokemonBuilder with(Move move) {
		System.out.println(pokemon + " erlernt " + move);
		pokemon.add(move);
		return this;
	}

	/**
	 * Fuegt verschiedene Moves hinzu
	 * 
	 * @param moves Moves
	 * @return der Pokemonbuilder
	 */
	public PokemonBuilder with(ArrayList<Move> moves) {
		for (Move move : moves)
			pokemon.add(move);
		return this;
	}

	/**
	 * Setzt den evolver
	 * 
	 * @param evolver Objekt von IEvolver
	 * @return der Pokemonbuilder
	 */
	public PokemonBuilder with(IEvolver evolver) {
		pokemon.set(evolver);
		return this;
	}
	
	/**
	 * Erhoet die HP
	 * 
	 * @param hp HP
	 * @return der Pokemonbuilder
	 */
	public PokemonBuilder addHP(int hp) {
		pokemon.addHP(hp);
		return this;
	}
	
	/**
	 * Erhoet die ATK
	 * 
	 * @param atk ATK
	 * @return der Pokemonbuilder
	 */
	public PokemonBuilder addATK(int atk) {
		pokemon.addATK(atk);
		return this;
	}

	/**
	 * Erstellt das Pokemon
	 * 
	 * @return Das Pokemon
	 */
	public Pokemon build() {
		return pokemon;
	}
}
