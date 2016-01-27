package spesa;

public class NonAlimentare extends Prodotto {

	String materiale;

	public NonAlimentare(String cod, String descr, double prezzo, String materiale) {
		super(cod, descr, prezzo);
		this.materiale = materiale;
	}

	public NonAlimentare() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void applicaSconto() {
		if (materiale.equals("carta") || materiale.equals("vetro") || materiale.equals("plastica"))
			prezzo -= prezzo / 100 * 10;
	}
}
