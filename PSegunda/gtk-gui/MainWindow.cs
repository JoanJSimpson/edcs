
// This file has been generated by the GUI designer. Do not modify.

public partial class MainWindow
{
	private global::Gtk.VBox vBox;
	
	private global::Gtk.Label labelSaludo;
	
	private global::Gtk.HBox hbox2;
	
	private global::Gtk.Entry entryPrimero;
	
	private global::Gtk.Button buttonSuma;
	
	private global::Gtk.HBox hbox1;
	
	private global::Gtk.Entry entrySegundo;
	
	private global::Gtk.Button buttonBorrar;
	
	private global::Gtk.ScrolledWindow GtkScrolledWindow;
	
	private global::Gtk.TextView texto;

	protected virtual void Build ()
	{
		global::Stetic.Gui.Initialize (this);
		// Widget MainWindow
		this.Name = "MainWindow";
		this.Title = global::Mono.Unix.Catalog.GetString ("MainWindow");
		this.WindowPosition = ((global::Gtk.WindowPosition)(4));
		// Container child MainWindow.Gtk.Container+ContainerChild
		this.vBox = new global::Gtk.VBox ();
		this.vBox.Name = "vBox";
		this.vBox.Spacing = 6;
		// Container child vBox.Gtk.Box+BoxChild
		this.labelSaludo = new global::Gtk.Label ();
		this.labelSaludo.Name = "labelSaludo";
		this.labelSaludo.LabelProp = global::Mono.Unix.Catalog.GetString ("PSegunda");
		this.vBox.Add (this.labelSaludo);
		global::Gtk.Box.BoxChild w1 = ((global::Gtk.Box.BoxChild)(this.vBox [this.labelSaludo]));
		w1.Position = 0;
		w1.Expand = false;
		w1.Fill = false;
		// Container child vBox.Gtk.Box+BoxChild
		this.hbox2 = new global::Gtk.HBox ();
		this.hbox2.Name = "hbox2";
		this.hbox2.Spacing = 6;
		// Container child hbox2.Gtk.Box+BoxChild
		this.entryPrimero = new global::Gtk.Entry ();
		this.entryPrimero.CanFocus = true;
		this.entryPrimero.Name = "entryPrimero";
		this.entryPrimero.Text = global::Mono.Unix.Catalog.GetString ("Inserte la primera palabra");
		this.entryPrimero.IsEditable = true;
		this.entryPrimero.InvisibleChar = '•';
		this.hbox2.Add (this.entryPrimero);
		global::Gtk.Box.BoxChild w2 = ((global::Gtk.Box.BoxChild)(this.hbox2 [this.entryPrimero]));
		w2.Position = 0;
		// Container child hbox2.Gtk.Box+BoxChild
		this.buttonSuma = new global::Gtk.Button ();
		this.buttonSuma.CanFocus = true;
		this.buttonSuma.Name = "buttonSuma";
		this.buttonSuma.UseStock = true;
		this.buttonSuma.UseUnderline = true;
		this.buttonSuma.Label = "gtk-ok";
		this.hbox2.Add (this.buttonSuma);
		global::Gtk.Box.BoxChild w3 = ((global::Gtk.Box.BoxChild)(this.hbox2 [this.buttonSuma]));
		w3.Position = 1;
		w3.Expand = false;
		this.vBox.Add (this.hbox2);
		global::Gtk.Box.BoxChild w4 = ((global::Gtk.Box.BoxChild)(this.vBox [this.hbox2]));
		w4.Position = 1;
		w4.Expand = false;
		w4.Fill = false;
		// Container child vBox.Gtk.Box+BoxChild
		this.hbox1 = new global::Gtk.HBox ();
		this.hbox1.Name = "hbox1";
		this.hbox1.Spacing = 6;
		// Container child hbox1.Gtk.Box+BoxChild
		this.entrySegundo = new global::Gtk.Entry ();
		this.entrySegundo.CanFocus = true;
		this.entrySegundo.Name = "entrySegundo";
		this.entrySegundo.Text = global::Mono.Unix.Catalog.GetString ("Introduzca la segunda palabra");
		this.entrySegundo.IsEditable = true;
		this.entrySegundo.InvisibleChar = '●';
		this.hbox1.Add (this.entrySegundo);
		global::Gtk.Box.BoxChild w5 = ((global::Gtk.Box.BoxChild)(this.hbox1 [this.entrySegundo]));
		w5.Position = 0;
		// Container child hbox1.Gtk.Box+BoxChild
		this.buttonBorrar = new global::Gtk.Button ();
		this.buttonBorrar.CanFocus = true;
		this.buttonBorrar.Name = "buttonBorrar";
		this.buttonBorrar.UseStock = true;
		this.buttonBorrar.UseUnderline = true;
		this.buttonBorrar.Label = "gtk-clear";
		this.hbox1.Add (this.buttonBorrar);
		global::Gtk.Box.BoxChild w6 = ((global::Gtk.Box.BoxChild)(this.hbox1 [this.buttonBorrar]));
		w6.Position = 1;
		w6.Expand = false;
		w6.Fill = false;
		this.vBox.Add (this.hbox1);
		global::Gtk.Box.BoxChild w7 = ((global::Gtk.Box.BoxChild)(this.vBox [this.hbox1]));
		w7.Position = 2;
		w7.Expand = false;
		w7.Fill = false;
		// Container child vBox.Gtk.Box+BoxChild
		this.GtkScrolledWindow = new global::Gtk.ScrolledWindow ();
		this.GtkScrolledWindow.Name = "GtkScrolledWindow";
		this.GtkScrolledWindow.ShadowType = ((global::Gtk.ShadowType)(1));
		// Container child GtkScrolledWindow.Gtk.Container+ContainerChild
		this.texto = new global::Gtk.TextView ();
		this.texto.CanFocus = true;
		this.texto.Name = "texto";
		this.texto.Editable = false;
		this.texto.CursorVisible = false;
		this.texto.AcceptsTab = false;
		this.GtkScrolledWindow.Add (this.texto);
		this.vBox.Add (this.GtkScrolledWindow);
		global::Gtk.Box.BoxChild w9 = ((global::Gtk.Box.BoxChild)(this.vBox [this.GtkScrolledWindow]));
		w9.Position = 3;
		this.Add (this.vBox);
		if ((this.Child != null)) {
			this.Child.ShowAll ();
		}
		this.DefaultWidth = 400;
		this.DefaultHeight = 300;
		this.Show ();
		this.DeleteEvent += new global::Gtk.DeleteEventHandler (this.OnDeleteEvent);
		this.buttonSuma.Clicked += new global::System.EventHandler (this.OnButtonAceptarClicked);
		this.buttonBorrar.Clicked += new global::System.EventHandler (this.OnButtonBorrarClicked);
	}
}