package spesa;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Negozio {

	public static ListaSpesa ls = new ListaSpesa();
	// public static Spesagrafica sg = new Spesagrafica();

	public static Prodotto[] inventario = new Prodotto[100];

	public static void main(String args[]) {
		/*
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		int sel = 0;
		int elimina;

		while (sel != 99) {
			if (sel == 98) {

				stampaProdotti();

				System.out.println("98 - per eliminare");
				System.out.println("99 - per uscire");
				System.out.println("ins numero prodotto: ");

				elimina = ls.leggiInt(br);
				ls.eliminaProdotto(elimina);
			}

			
			  stampaProdotti(); System.out.println("98 - per eliminare");
			  System.out.println("99 - per uscire");
			sel = ls.leggiInt(br);
			if (sel != 99 && sel >= 0 && sel < inventario.length) {
				ls.aggiungiProdotto(inventario[sel]);
			} else {
				System.out.print("");
			}

		}
		ls.calcolaTotale();*/

	}

	public static void stampaProdotti() {
		for (int i = 0; i < inventario.length; i++) {
			System.out.println(i + " - " + inventario[i].getDescr() + " prezzo: " + inventario[i].getPrezzo());
		}
	}

}
