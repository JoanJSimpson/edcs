using System;
using System.IO;
using Gtk;


public partial class MainWindow: Gtk.Window
{	
	public MainWindow (): base (Gtk.WindowType.Toplevel)
	{
		Build ();

		//textView.Buffer.Text = File.ReadAllText ("/home/joan/edcs/prueba.txt");
		//En linux el cambio de linea es \n 
	}

	protected void OnDeleteEvent (object sender, DeleteEventArgs a)
	{
		Application.Quit ();
		a.RetVal = true;
	}

	protected void OnOpenActionActivated (object sender, EventArgs e)
	{
		FileChooserDialog fileChooserDialog = new FileChooserDialog(
			"Elige fichero para abrir",
			this,
			FileChooserAction.Open,
			Stock.Cancel,ResponseType.Cancel,
			Stock.Open,ResponseType.Accept);

		FileChooserDialog fileChooserDialogSave = new FileChooserDialog (
			"Guardar fichero",
			this,
			FileChooserAction.Save,
			Stock.Cancel, ResponseType.Cancel,
			Stock.SaveAs, ResponseType.Apply);

		if (fileChooserDialogSave.Run () == (int)ResponseType.Apply) {
			textView.Buffer.GetText == File.WriteAllText (fileChooserDialogSave.Filename);
		}
		fileChooserDialogSave.Destroy ();
			
		if (fileChooserDialog.Run () == (int)ResponseType.Accept) {
			textView.Buffer.Text = File.ReadAllText(fileChooserDialog.Filename);
		}
		fileChooserDialog.Destroy ();
	}

}
