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
		labelSaludo.Text = "Hola " + entryNombre.Text;
		if (entryNombre.Text == "Joan") {
			texto.Buffer.InsertAtCursor ("Que crack "+entryNombre.Text+" ! ");
		} else if (entryNombre.Text == "Ruben") {
			texto.Buffer.Text = "Hola "+entryNombre.Text;
		} else {
			texto.Buffer.Text = "";
		}

	}

}
