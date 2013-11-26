package pe.edu.unsaac.in.sarad.client.rest;

import pe.edu.unsaac.in.sarad.client.comun.mediador.Suscriptor;

public class RestSuscriptor implements Suscriptor{

    public void recibir(String mensaje) {
        // Procesar la entrada de otros componentes y procesarlo
    }

    public void enviar(String mensaje) {
        // Procesar el mensaje y enviarlo en formato rest hacia el servidor, esperar
        // la respuesta y enviarla al mediador
    }
    
}
