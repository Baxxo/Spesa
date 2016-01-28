package spesa;

public class Negozio {

	public ListaSpesa ls = new ListaSpesa();

	public static Prodotto[] inventario = new Prodotto[100];

	public static void stampaProdotti() {
		for (int i = 0; i < inventario.length; i++) {
			System.out.println(i + " - " + inventario[i].getDescr() + " prezzo: " + inventario[i].getPrezzo());
		}
	}

}
