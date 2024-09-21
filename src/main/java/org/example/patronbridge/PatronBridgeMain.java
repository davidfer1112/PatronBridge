package org.example.patronbridge;

import org.example.encriptacion.ProcesoEncriptarAES;
import org.example.encriptacion.ProcesoEncriptarDES;
import org.example.encriptacion.ProcesoEncriptarBase64;
import org.example.encriptacion.ProcesoSinEncriptar;
import org.example.implementacion.PuenteMensajeEncriptacion;
import org.example.implementacion.InterfaceMensajeEncriptacion;


public class PatronBridgeMain {

    public static void main(String[] args) {
        InterfaceMensajeEncriptacion FormatoAES = new PuenteMensajeEncriptacion(new ProcesoEncriptarAES());
        InterfaceMensajeEncriptacion FormatoDES = new PuenteMensajeEncriptacion(new ProcesoEncriptarDES());
        InterfaceMensajeEncriptacion FormatoBase64 = new PuenteMensajeEncriptacion(new ProcesoEncriptarBase64()); // Nueva instancia
        InterfaceMensajeEncriptacion SinFormato = new PuenteMensajeEncriptacion(new ProcesoSinEncriptar());

        try {
            final String message = "<Curso><Nombre>Patrones de Diseño de Software</Nombre></Curso>";
            String messageAES = FormatoAES.EncryptarMensaje(message, "HG58YZ3CR9123456");
            System.out.println("Formato AES > " + messageAES + "\n");

            String messageDES = FormatoDES.EncryptarMensaje(message, "XMzDdG4D03CKm2Ix");
            System.out.println("Formato DES > " + messageDES + "\n");

            String messageBase64 = FormatoBase64.EncryptarMensaje(message, null);
            System.out.println("Formato Base64 > " + messageBase64 + "\n");

            String messageNO = SinFormato.EncryptarMensaje(message, null);
            System.out.println("Sin Formato > " + messageNO + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
