package spring.formation;

public class Guitariste implements IMusicien {

	private IInstrument instrument;
	private String morceau;

	public Guitariste() {
		super();
	}

	public Guitariste(IInstrument instrument) {
		super();
		this.instrument = instrument;
	}

	@Override
	public void jouer() {
		System.out.println("Le guitariste joue : " + this.morceau + "(" + this.instrument.toString() + ")");

	}

}
