package pe.edu.unsaac.in.sarad.client.comun.mediador;

public interface Mediador {
    public void enviar(Suscriptor emisor,String mensaje);
    public void agregarSuscriptor(Suscriptor suscriptor);
    public void quitarSuscriptor(Suscriptor suscriptor);
}
