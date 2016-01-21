package spesa;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.wb.swt.SWTResourceManager;

public class Spesagrafica {

	protected Shell shell;
	Negozio n = new Negozio();
	int l = n.inventario.length;

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
		
		List list = new List(shell, SWT.BORDER);
		list.setBounds(30, 102, 281, 301);
		
		for(int i=0; i<l; i++){
			list.add(n.inventario[i].getDescr());			
		}

	}
}
