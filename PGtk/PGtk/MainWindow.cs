using System;
using Gtk;

public partial class MainWindow: Gtk.Window
{	
	private Label ruben;
	private Label label2;
	public MainWindow (): base (Gtk.WindowType.Toplevel)
	{
		Build (); 

		label2 = new Label ("Este lo he añadido a mano");
		ruben = new Label ("Pero que haces tarao?");
		label2.Visible = true;
		vBox.Add (label2);
		vBox.Add (ruben);

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
			//texto.Buffer.Text = "Pero que haces tarao? ";
			label2.Visible = false;
			ruben.Visible = true;
		} else {
			texto.Buffer.Text = "";
		}

	}

}
