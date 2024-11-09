/**
 * Esta clase representa un mensaje de voz con una duración en segundos.
 * Hereda de la clase Mensaje.
 * 
 * AUTHORS: Ana Chen Zhang
 */
public class MensajeVoz extends Mensaje {
    private int duracion; // Duración del mensaje de voz en segundos

    /**
     * Constructor que inicializa el remitente, destinatario y duración del mensaje de voz.
     * @param remitente Nombre o identificación del remitente
     * @param destinatario Nombre o identificación del destinatario
     * @param duracion Duración del mensaje de voz en segundos
     */
    public MensajeVoz(String remitente, String destinatario, int duracion) {
        super(remitente, destinatario);
        this.duracion = duracion;
    }

    /**
     * Obtiene la duración del mensaje de voz en segundos.
     * @return Duración del mensaje de voz en segundos
     */
    public int getDuracion() {
        return duracion;
    }

    /**
     * Establece la duración del mensaje de voz.
     * @param duracion Nueva duración del mensaje de voz en segundos
     */
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    /**
     * Este método es para reproducir el mensaje de voz, indicando su duración.
     */
    @Override
    public void reproducir() {
        System.out.println("Reproduciendo mensaje de voz de " + duracion + " segundos.");
    }

    /**
     * Retorna una representación en cadena del mensaje de voz, incluyendo la duración.
     * @return Cadena que describe el remitente, destinatario y duración del mensaje de voz
     */
    @Override
    public String toString() {
        return super.toString() + "\nDuración del mensaje de voz: " + duracion + " segundos";
    }
}
