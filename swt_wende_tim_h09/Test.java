/**
 * @author Tim Wende
 */
public class Test {

	public static void main(String[] args) {
		MoveFactory moveFactory = MoveFactory.moveFactory;

		Type normal = new Type("Normal");
		Type fire = new Type("Feuer");

		Move tackle = moveFactory.addMover(moveFactory.increasePP(moveFactory.getMove(
			"Tackle", normal, 40), 35));
		Move kratzer = moveFactory.addMover(moveFactory.increasePP(moveFactory.getMove(
			"Kratzer", normal, 40), 35));
		Move glut = moveFactory.addMover(moveFactory.increasePP(moveFactory.getMove(
			"Glut", fire, 40), 25));

		Move dragon_zurstoerer_of_hellfire = moveFactory.addMover(moveFactory.getMove(
			"Platscher", normal, 0, 40), move -> {
			if (Math.random() > 0.9)
				return Integer.MAX_VALUE;
			return MoveFactory.DEFAULT.use(move);
		});

		Pokemon glumanda = new PokemonBuilder("Glumanda", 39, 52)
			.with(fire)
			.with(kratzer)
			.with(glut)
			.with(pokemon -> {
				String name = "Glutexo";
				System.out.println(pokemon + " entwickelt sich zu " + name);
				return new PokemonBuilder(name, pokemon).addHP(10).addATK(25).build();
			})
			.build();
		Pokemon bisasam = new PokemonBuilder("Bisasam").with(new Type("Pflanze"))
			.with(tackle).build();
		Pokemon schiggy = new PokemonBuilder("Schiggy").with(new Type("Wasser"))
			.with(moveFactory.clone(tackle)).build();

		System.out.println();
		for (int i = 0; i < 4; i++)
			glumanda.use(i);
		for (int i = 0; i < 4; i++)
			bisasam.use(i);
		for (int i = 0; i < 4; i++)
			schiggy.use(i);

		System.out.println();
		glumanda = glumanda.evolve();
		glumanda.add(dragon_zurstoerer_of_hellfire);

		System.out.println();
		for (int i = 0; i < 4; i++)
			glumanda.use(i);
		glumanda.use(2);
		glumanda.use(2);
	}
}
