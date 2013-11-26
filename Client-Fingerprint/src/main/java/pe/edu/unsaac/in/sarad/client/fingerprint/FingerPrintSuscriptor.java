package pe.edu.unsaac.in.sarad.client.fingerprint;

import pe.edu.unsaac.in.sarad.client.comun.mediador.Suscriptor;

public class FingerPrintSuscriptor extends Thread implements Suscriptor{

    public void recibir(String mensaje) {
        // Implementar lo que van a recibir desde algun lugar
    }

    public void enviar(String mensaje) {
        
    }

    @Override
    public void run() {
        // Al recibir un dato del lector de huella, el mensaje se debe de enviar
        // desde este metodo se debe enviar este resultado al mediador que lo
        // reenvia a los otros componentes.
    }
}
