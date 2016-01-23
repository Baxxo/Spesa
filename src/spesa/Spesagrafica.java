package spesa;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.DateTime;

public class Spesagrafica {

	protected Shell shell;

	Negozio n = new Negozio();
	public int l = n.inventario.length;
	public int j = 0;
	public int g;
	public int m;
	public int y;
	public boolean isAlimentare;
	public boolean isScontrino = false;
	public boolean isTessera = false;
	public double prezzo;
	public String textBox;
	public String tot;
	public String cod;
	public String descr;
	public String materiale;
	public Data scadenza;
	public Alimentare newAlimentare;
	public NonAlimentare newNonAlimentare;
	public List list;
	public List list_1;
	public Text text;
	public Text text_1;
	public Text text_2;
	public Text text_6;
	public Text text_7;
	public Button btnElimina;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Spesagrafica window = new Spesagrafica();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	public void ristampa() {
		list_1.setVisible(true);
		stampa();
		stampa1();
		btnElimina.setVisible(true);
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {

		newAlimentare = new Alimentare("4134", "Mela", 1, new Data(22, 1, 2016));
		n.inventario[0] = newAlimentare;
		j++;
		newAlimentare = new Alimentare("4634", "Pera", 2, new Data(26, 1, 2016));
		n.inventario[1] = newAlimentare;
		j++;
		newAlimentare = new Alimentare("4164", "Banana", 3, new Data(10, 1, 2016));
		n.inventario[2] = newAlimentare;
		j++;

		shell = new Shell();
		shell.setSize(750, 550);
		shell.setText("SWT Application");

		Button btnRistampa = new Button(shell, SWT.NONE);

		Label lblNegozio = new Label(shell, SWT.NONE);
		lblNegozio.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.BOLD));
		lblNegozio.setBounds(308, 10, 97, 30);
		lblNegozio.setText("NEGOZIO");

		Label lblProdotti = new Label(shell, SWT.NONE);
		lblProdotti.setBounds(136, 66, 62, 15);
		lblProdotti.setText("PRODOTTI");

		list = new List(shell, SWT.BORDER);
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				list_1.setVisible(true);
				n.ls.aggiungiProdotto(n.inventario[list.getSelectionIndex()]);
				stampa1();
				// System.out.println("prodtto sel: " +
				// n.inventario[list.getSelectionIndex()]);
			}
		});
		list.setBounds(30, 102, 283, 301);

		list_1 = new List(shell, SWT.BORDER);
		list_1.setBounds(410, 102, 289, 301);
		// list_1.setVisible(false);

		Label lblTotale = new Label(shell, SWT.NONE);
		lblTotale.setBounds(270, 482, 43, 15);
		lblTotale.setText("TOTALE");
		lblTotale.setVisible(false);

		Button btnTessera = new Button(shell, SWT.CHECK);
		btnTessera.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				isTessera = true;
			}
		});
		btnTessera.setBounds(516, 481, 93, 16);
		btnTessera.setText("TESSERA");

		btnTessera.setVisible(false);

		/*
		 * for (int i = 0; i < l; i++) { list.add(n.inventario[i].getDescr()); }
		 */

		Button btnCassa = new Button(shell, SWT.NONE);
		btnCassa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				text_7.setVisible(true);
				lblTotale.setVisible(true);
				tot = "" + n.ls.calcolaTotale(isTessera);
				text_7.setText(tot);
			}
		});
		btnCassa.setBounds(632, 477, 75, 25);
		btnCassa.setText("CASSA");

		Button btnScontrino = new Button(shell, SWT.NONE);
		btnScontrino.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				list_1.setVisible(true);
				isScontrino = true;
				btnTessera.setVisible(true);
				int sel = list.getSelectionIndex();
				// System.out.println(sel);
			}
		});
		btnScontrino.setBounds(123, 419, 75, 25);
		btnScontrino.setText("SCONTRINO");

		btnElimina = new Button(shell, SWT.NONE);
		btnElimina.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				// System.out.println(list_1.getSelectionIndex());
				n.ls.eliminaProdotto(list_1.getSelectionIndex());
				ristampa();
			}
		});
		btnElimina.setBounds(443, 409, 75, 25);
		btnElimina.setText("ELIMINA");

		DateTime dateTime = new DateTime(shell, SWT.BORDER);
		dateTime.setBounds(492, 275, 80, 24);
		dateTime.setVisible(false);

		Button btnEliminaProdotto = new Button(shell, SWT.NONE);
		btnEliminaProdotto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				int sel = list.getSelectionIndex();
				System.out.println(sel);
				for (int i = sel; i < j; i++) {
					n.inventario[i] = n.inventario[i++];
				}
				j--;
				ristampa();
			}
		});
		btnEliminaProdotto.setBounds(98, 450, 128, 25);
		btnEliminaProdotto.setText("ELIMINA PRODOTTO");
		// btnEliminaProdotto.setVisible(false);

		Button btnInserisciProdotto = new Button(shell, SWT.NONE);
		btnInserisciProdotto.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});

		Label lblCod = new Label(shell, SWT.NONE);
		lblCod.setBounds(443, 144, 43, 15);
		lblCod.setText("Codice:");
		lblCod.setVisible(false);

		text = new Text(shell, SWT.BORDER);
		text.setBounds(492, 141, 170, 21);
		text.setVisible(false);

		Label lblPrezzo = new Label(shell, SWT.NONE);
		lblPrezzo.setBounds(443, 189, 43, 15);
		lblPrezzo.setText("Prezzo:");
		lblPrezzo.setVisible(false);

		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(492, 186, 170, 21);
		text_1.setVisible(false);

		Label lblDescrizione = new Label(shell, SWT.NONE);
		lblDescrizione.setBounds(418, 235, 68, 15);
		lblDescrizione.setText("Descrizione:");
		lblDescrizione.setVisible(false);

		text_2 = new Text(shell, SWT.BORDER);
		text_2.setBounds(492, 232, 170, 21);
		text_2.setVisible(false);

		Label lblScadenza = new Label(shell, SWT.NONE);
		lblScadenza.setBounds(431, 275, 55, 15);
		lblScadenza.setText("Scadenza:");
		lblScadenza.setVisible(false);

		Label lblMateriale = new Label(shell, SWT.NONE);
		lblMateriale.setBounds(429, 337, 55, 15);
		lblMateriale.setText("Materiale:");
		lblMateriale.setVisible(false);

		text_6 = new Text(shell, SWT.BORDER);
		text_6.setBounds(492, 334, 170, 21);
		text_6.setVisible(false);

		text_7 = new Text(shell, SWT.BORDER);
		text_7.setBounds(348, 479, 76, 21);
		text_7.setVisible(false);
		text.setVisible(true);
		text_1.setVisible(true);
		text_2.setVisible(true);

		Button btnAlimentare = new Button(shell, SWT.RADIO);
		btnAlimentare.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				list_1.setVisible(false);
				// btnElimina.setVisible(true);
				btnInserisciProdotto.setVisible(true);
				if (btnAlimentare.getSelection() == true) {
					lblCod.setVisible(true);
					lblPrezzo.setVisible(true);
					lblDescrizione.setVisible(true);
					lblScadenza.setVisible(true);
					lblMateriale.setVisible(false);
					text_6.setVisible(false);
					dateTime.setVisible(true);
					isAlimentare = true;
				}
				// System.out.print(isAlimentare);
			}
		});
		btnAlimentare.setBounds(443, 66, 90, 16);
		btnAlimentare.setText("Alimentare");
		btnAlimentare.setVisible(false);

		Button btnNonAlimentare = new Button(shell, SWT.RADIO);
		btnNonAlimentare.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				list_1.setVisible(false);
				// btnElimina.setVisible(true);
				btnInserisciProdotto.setVisible(true);
				if (btnNonAlimentare.getSelection() == true) {
					lblCod.setVisible(true);
					lblPrezzo.setVisible(true);
					lblDescrizione.setVisible(true);
					lblMateriale.setVisible(true);
					text.setVisible(true);
					text_1.setVisible(true);
					text_2.setVisible(true);
					text_6.setVisible(true);
					dateTime.setVisible(false);
					lblScadenza.setVisible(false);
					isAlimentare = false;
				}
				// System.out.print(isAlimentare);
			}
		});
		btnNonAlimentare.setText("Non Alimentare");
		btnNonAlimentare.setBounds(555, 65, 107, 16);
		btnNonAlimentare.setVisible(false);

		Button btnProdotto = new Button(shell, SWT.NONE);
		btnProdotto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				btnAlimentare.setVisible(true);
				btnNonAlimentare.setVisible(true);
			}
		});
		btnProdotto.setBounds(534, 15, 75, 25);
		btnProdotto.setText("PRODOTTO");

		btnRistampa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				ristampa();
			}
		});
		btnRistampa.setBounds(28, 66, 75, 25);
		btnRistampa.setText("RISTAMPA");

		btnInserisciProdotto.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseUp(MouseEvent e) {
				list_1.setVisible(false);
				if (j < 100) {
					if (isAlimentare == true) {
						cod = text.getText();
						prezzo = Double.parseDouble(text_1.getText());
						descr = text_2.getText();
						g = dateTime.getDay();
						m = dateTime.getMonth();
						y = dateTime.getYear();
						scadenza = new Data(g, m, y);
						n.inventario[j] = new Alimentare(cod, descr, prezzo, scadenza);
					} else {
						cod = text.getText();
						prezzo = Double.parseDouble(text_1.getText());
						descr = text_2.getText();
						materiale = text_6.getText();
						n.inventario[j] = new NonAlimentare(cod, descr, prezzo, materiale);
					}
				} else {
					System.out.println("elimina qualche prodotto");
				}
				j++;
				ristampa();

			}

		});
		btnInserisciProdotto.setBounds(571, 419, 128, 25);
		btnInserisciProdotto.setText("NUOVO PRODOTTO");
		btnInserisciProdotto.setVisible(false);

		stampa();

	}

	public void stampa() {
		list.removeAll();
		for (int i = 0; i < j; i++) {
			list.add(n.inventario[i].getDescr());
		}
	}

	public void stampa1() {
		list_1.removeAll();
		String prod;
		for (int i = 0; i < n.ls.carrello.size(); i++) {
			// prod = n.ls.carrello.get(i).getDescr();
			list_1.add(n.ls.carrello.get(i).getDescr());
		}
	}
}
