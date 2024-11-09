/**
 * Esta clase representa un mensaje de texto, que contiene un texto como contenido del mensaje.
 * Hereda de la clase Mensaje.
 * 
 * AUTHORS: Ana Chen Zhang
 */
public class MensajeTexto extends Mensaje {
    private String texto;

    /**
     * Constructor que inicializa el remitente, destinatario y contenido del mensaje de texto.
     * @param remitente Nombre o identificación del remitente
     * @param destinatario Nombre o identificación del destinatario
     * @param texto Contenido del mensaje de texto
     */
    public MensajeTexto(String remitente, String destinatario, String texto) {
        super(remitente, destinatario);
        this.texto = texto;
    }
    
    /**
     * Obtiene el contenido del mensaje de texto.
     * @return Contenido del mensaje de texto
     */
    public String getTexto() {
        return texto;
    }

    /**
     * Establece el contenido del mensaje de texto.
     * @param texto Nuevo contenido del mensaje de texto
     */
    public void setTexto(String texto) {
        this.texto = texto;
    }

    /**
     * Este método es para reproducir el mensaje de texto, mostrando su contenido.
     */
    @Override
    void reproducir() {
        System.out.println("Reproduciendo mensaje de texto: " + texto);
    }

    /**
     * Retorna una representación en cadena del mensaje de texto, incluyendo el contenido.
     * @return Cadena que describe el remitente, destinatario y contenido del mensaje de texto
     */
    @Override
    public String toString() {
        return super.toString() + "\nEl texto es: " + texto;
    }
}
