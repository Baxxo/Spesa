package spesa;

class Alimentare extends Prodotto {

	Data scadenza;

	public Alimentare(String cod, String descr, double prezzo, Data scadenza) {
		super(cod, descr, prezzo);
		this.scadenza = scadenza;
	}

	public void applicaSconto(Data oggi) {
		if (scadenza.getDifference(oggi) > 10) {
			prezzo -= prezzo / 100 * 20;
		}
	}
}
