import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 Cuando muchos objetos interactúan con otros objetos, se puede formar una 
 * estructura muy compleja, con objetos con muchas conexiones con otros objetos.
 * En un caso extremo cada objeto puede conocer a todos los demás objetos. 
 * Para evitar esto el patrón Mediator encapsula el comportamiento de todo un 
 * conjunto de objetos en un solo objeto.
 */

//Interfaz Amigo
interface Command {
    void execute();
}

//Mediador Abstracto
interface IMediator {
    //Para mantenimiento de usuario
    void AddDocente();
    void DeleteDocente();
    void UpdateDocente();
    
    void registerAddDocente(BtnAddDocente v);
    void registerDeleteDocente(BtnDeleteDocente s);
    void registerUpdateDocente(BtnUpdateDocente b);
    void registerDisplay(LblDisplay d);
}
 
//Mediador Concreto
class Mediator implements IMediator {
 
    BtnAddDocente       btnAddDocente;
    BtnDeleteDocente    btnDeleteDocente;
    BtnUpdateDocente    btnUpdateDocente;
    LblDisplay          show;
 
    //....
    public void registerAddDocente(BtnAddDocente v) {
        btnAddDocente = v;
    }
 
    public void registerDeleteDocente(BtnDeleteDocente s) {
        btnDeleteDocente = s;
    }
 
    public void registerUpdateDocente(BtnUpdateDocente b) {
        btnUpdateDocente = b;
    }
 
    public void registerDisplay(LblDisplay d) {
        show = d;
    }
 
    public void AddDocente() {
        btnUpdateDocente.setEnabled(true);
        btnAddDocente.setEnabled(false);
        btnDeleteDocente.setEnabled(true);
        show.setText("añadiendo...");
    }
 
    public void DeleteDocente() {
        btnAddDocente.setEnabled(true);
        btnDeleteDocente.setEnabled(false);
        btnUpdateDocente.setEnabled(true);
        show.setText("eliminando...");
    }
 
    public void UpdateDocente() {
        btnDeleteDocente.setEnabled(true);
        btnAddDocente.setEnabled(true);
        btnUpdateDocente.setEnabled(false);
        show.setText("actualizando...");
    }
 
}
 
//Un amigo concreto
class BtnAddDocente extends JButton implements Command {
 
    IMediator med;
 
    BtnAddDocente(ActionListener al, IMediator m) {
        super("AddDocente");
        addActionListener(al);
        med = m;
        med.registerAddDocente(this);
    }
 
    public void execute() {
        med.AddDocente();
    }
 
}
 
//Un amigo concreto
class BtnDeleteDocente extends JButton implements Command {
 
    IMediator med;
 
    BtnDeleteDocente(ActionListener al, IMediator m) {
        super("DeleteDocente");
        addActionListener(al);
        med = m;
        med.registerDeleteDocente(this);
    }
 
    public void execute() {
        med.DeleteDocente();
    }
 
}
 
//Un amigo concreto
class BtnUpdateDocente extends JButton implements Command {
 
    IMediator med;
 
    BtnUpdateDocente(ActionListener al, IMediator m) {
        super("UpdateDocente");
        addActionListener(al);
        med = m;
        med.registerUpdateDocente(this);
    }
 
    public void execute() {
        med.UpdateDocente();
    }
 
}
 
class LblDisplay extends JLabel {
 
    IMediator med;
 
    LblDisplay(IMediator m) {
        super("Just start...");
        med = m;
        med.registerDisplay(this);
        setFont(new Font("Arial", Font.BOLD, 24));
    }
 
}
 
class MediatorDemo extends JFrame implements ActionListener {
 
    IMediator med = new Mediator();
 
    MediatorDemo() {
        JPanel p = new JPanel();
        p.add(new BtnAddDocente(this, med));
        p.add(new BtnDeleteDocente(this, med));
        p.add(new BtnUpdateDocente(this, med));
        getContentPane().add(new LblDisplay(med), "North");
        getContentPane().add(p, "South");
        setSize(400, 200);
        setVisible(true);
    }
 
    public void actionPerformed(ActionEvent ae) {
        Command comd = (Command) ae.getSource();
        comd.execute();
    }
 
//    public static void main(String[] args) {
//        new MediatorDemo();
//    }
 
}