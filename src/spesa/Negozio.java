package spesa;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Negozio {

	public static ListaSpesa ls = new ListaSpesa();

	public static Prodotto[] inventario = new Prodotto[100];

	public static void stampaProdotti() {
		for (int i = 0; i < inventario.length; i++) {
			System.out.println(i + " - " + inventario[i].getDescr() + " prezzo: " + inventario[i].getPrezzo());
		}
	}

}
