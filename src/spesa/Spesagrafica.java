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
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class Spesagrafica {

	protected Shell shell;

	Negozio n = new Negozio();
	int l = n.inventario.length;
	public int j = 0;
	public boolean isAlimentare;
	public String textBox;
	public String cod;
	public String descr;
	public double prezzo;
	public Data scadenza;
	public String materiale;
	public int g;
	public int m;
	public int y;
	public Alimentare newAlimentare;
	public NonAlimentare newNonAlimentare;
	public List list;

	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;
	private Text text_5;
	private Text text_6;

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
				n.ls.aggiungiProdotto(n.inventario[list.getSelectionIndex()]);
				System.out.println("prodtto sel: " + n.inventario[list.getSelectionIndex()]);
			}
		});
		list.setBounds(30, 102, 281, 301);

		Button btnTessera = new Button(shell, SWT.CHECK);
		btnTessera.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

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
				n.ls.calcolaTotale();
			}
		});
		btnCassa.setBounds(632, 477, 75, 25);
		btnCassa.setText("CASSA");

		Button btnScontrino = new Button(shell, SWT.NONE);
		btnScontrino.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				btnTessera.setVisible(true);
				int sel = list.getSelectionIndex();
				System.out.println(sel);
			}
		});
		btnScontrino.setBounds(123, 419, 75, 25);
		btnScontrino.setText("SCONTRINO");

		Button btnElimina = new Button(shell, SWT.NONE);
		btnElimina.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				int sel = list.getSelectionIndex();
				System.out.println(sel);
				n.ls.eliminaProdotto(sel);
			}
		});
		btnElimina.setBounds(123, 458, 75, 25);
		btnElimina.setText("ELIMINA");

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

		text_3 = new Text(shell, SWT.BORDER);
		text_3.setBounds(492, 296, 53, 21);
		text_3.setVisible(false);

		text_4 = new Text(shell, SWT.BORDER);
		text_4.setBounds(551, 296, 58, 21);
		text_4.setVisible(false);

		text_5 = new Text(shell, SWT.BORDER);
		text_5.setBounds(611, 296, 51, 21);
		text_5.setVisible(false);

		Label lblYyyy = new Label(shell, SWT.NONE);
		lblYyyy.setBounds(611, 275, 34, 15);
		lblYyyy.setText("YYYY");
		lblYyyy.setVisible(false);

		Label lblGg = new Label(shell, SWT.NONE);
		lblGg.setBounds(505, 275, 21, 15);
		lblGg.setText("GG");
		lblGg.setVisible(false);

		Label lblMm = new Label(shell, SWT.NONE);
		lblMm.setText("MM");
		lblMm.setBounds(560, 275, 21, 15);
		lblMm.setVisible(false);

		Label lblMateriale = new Label(shell, SWT.NONE);
		lblMateriale.setBounds(429, 337, 55, 15);
		lblMateriale.setText("Materiale:");
		lblMateriale.setVisible(false);

		text_6 = new Text(shell, SWT.BORDER);
		text_6.setBounds(492, 334, 170, 21);
		text_6.setVisible(false);

		Button btnAlimentare = new Button(shell, SWT.RADIO);
		btnAlimentare.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				if (btnAlimentare.getSelection() == true) {
					lblCod.setVisible(true);
					lblPrezzo.setVisible(true);
					lblDescrizione.setVisible(true);
					lblScadenza.setVisible(true);
					lblGg.setVisible(true);
					lblMm.setVisible(true);
					lblYyyy.setVisible(true);
					text.setVisible(true);
					text_1.setVisible(true);
					text_2.setVisible(true);
					text_3.setVisible(true);
					text_4.setVisible(true);
					text_5.setVisible(true);
					lblMateriale.setVisible(false);
					text_6.setVisible(false);
					isAlimentare = true;
				}
				// System.out.print(isAlimentare);
			}
		});
		btnAlimentare.setBounds(443, 66, 90, 16);
		btnAlimentare.setText("Alimentare");

		Button btnNonAlimentare = new Button(shell, SWT.RADIO);
		btnNonAlimentare.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				if (btnNonAlimentare.getSelection() == true) {
					lblCod.setVisible(true);
					lblPrezzo.setVisible(true);
					lblDescrizione.setVisible(true);
					lblMateriale.setVisible(true);
					text.setVisible(true);
					text_1.setVisible(true);
					text_2.setVisible(true);
					text_6.setVisible(true);
					lblScadenza.setVisible(false);
					lblGg.setVisible(false);
					lblMm.setVisible(false);
					lblYyyy.setVisible(false);
					text_3.setVisible(false);
					text_4.setVisible(false);
					text_5.setVisible(false);
					isAlimentare = false;
				}
				// System.out.print(isAlimentare);
			}
		});
		btnNonAlimentare.setText("Non Alimentare");
		btnNonAlimentare.setBounds(555, 65, 107, 16);

		Button btnInserisciProdotto = new Button(shell, SWT.NONE);
		btnInserisciProdotto.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnInserisciProdotto.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseUp(MouseEvent e) {
				if (j < 100) {
					if (isAlimentare == true) {
						cod = text.getText();
						prezzo = Double.parseDouble(text_1.getText());
						descr = text_2.getText();
						g = Integer.parseInt(text_3.getText());
						m = Integer.parseInt(text_4.getText());
						y = Integer.parseInt(text_5.getText());
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

			}

		});
		btnInserisciProdotto.setBounds(596, 17, 128, 25);
		btnInserisciProdotto.setText("NUOVO PRODOTTO");

		Button btnRistampa = new Button(shell, SWT.NONE);
		btnRistampa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				stampa();
			}
		});
		btnRistampa.setBounds(28, 66, 75, 25);
		btnRistampa.setText("RISTAMPA");
		
		Button btnEliminaProdotto = new Button(shell, SWT.NONE);
		btnEliminaProdotto.setBounds(453, 17, 128, 25);
		btnEliminaProdotto.setText("ELIMINA PRODOTTO");

		stampa();

	}

	public void stampa() {
		list.removeAll();
		for (int i = 0; i < j; i++) {
			list.add(n.inventario[i].getDescr());
		}
	}
}
