using System;
using Gtk;

public partial class MainWindow: Gtk.Window
{	

	public MainWindow (): base (Gtk.WindowType.Toplevel)
	{
		Build (); 


	}

	protected void OnDeleteEvent (object sender, DeleteEventArgs a)
	{
		Application.Quit ();
		a.RetVal = true;
	}

	protected void OnButtonAceptarClicked (object sender, EventArgs e)
	{
		texto.Buffer.InsertAtCursor ("Hola, Este es el ejercicio!\n");

		if (entryPrimero.Text == "" || entrySegundo.Text == "") {
			texto.Buffer.Text = "";
			texto.Buffer.InsertAtCursor ("¡¡¡¡Error!!!!\nNo puede estar vacio ningún campo\n");
		//} else if (entrySegundo.Text == "") {
		//	texto.Buffer.InsertAtCursor ("La segunda palabra no puede estar vacia");
		} else {
			texto.Buffer.Text = "";
			texto.Buffer.InsertAtCursor (entryPrimero.Text+" "+entrySegundo.Text+"\n");
		}

	}
	protected void OnButtonBorrarClicked (object sender, EventArgs e)
	{
		texto.Buffer.Text = "";
	}
}
