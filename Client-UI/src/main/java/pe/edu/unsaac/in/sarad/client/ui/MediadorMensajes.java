package pe.edu.unsaac.in.sarad.client.ui;

import java.util.ArrayList;
import java.util.List;
import pe.edu.unsaac.in.sarad.client.comun.mediador.Mediador;
import pe.edu.unsaac.in.sarad.client.comun.mediador.Suscriptor;

public class MediadorMensajes implements Mediador{
    private List<Suscriptor> suscriptores;

    public void setSuscriptores(List<Suscriptor> suscriptores){
        this.suscriptores=suscriptores;
    }
    
    public List<Suscriptor> getSuscriptores(){
        return this.suscriptores;
    }
    
    public MediadorMensajes() {
        suscriptores=new ArrayList<Suscriptor>();
    }

    public void enviar(Suscriptor emisor, String mensaje) {
        for (Suscriptor suscriptor : suscriptores) {
            if(emisor!=suscriptor){
                suscriptor.recibir(mensaje);
            }
        }
    }

    public void agregarSuscriptor(Suscriptor suscriptor) {
        suscriptores.add(suscriptor);
    }

    public void quitarSuscriptor(Suscriptor suscriptor) {
        suscriptores.remove(suscriptor);
    }
    
}
