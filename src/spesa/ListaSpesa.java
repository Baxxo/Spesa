package spesa;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListaSpesa {

	public ListaSpesa() {
	}

	public void aggiungiProdotto(Prodotto p) {
		carrello.add(p);
	}

	public double calcolaTotale() {

		double tot = 0;
		for (int i = 0; i < carrello.size(); i++) {
			tot += carrello.get(i).getPrezzo();
		}
		System.out.println("Prezzo: " + tot);
		return tot;
	}

	public void eliminaProdotto(int index) {
		carrello.remove(index);
	}

	public List<Prodotto> carrello = new ArrayList<Prodotto>();

	public String leggiStringa(BufferedReader br) {
		try {
			return br.readLine();
		} catch (IOException e) {
			System.out.println("ERRORE");
			return leggiStringa(br);
		}
	}

	public int leggiInt(BufferedReader br) {
		return Integer.parseInt(leggiStringa(br));
	}
}
