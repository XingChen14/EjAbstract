/**
 * Esta clase abstracta representa un mensaje con un remitente y un destinatario.
 * Proporciona métodos para obtener y modificar el remitente y el destinatario.
 * 
 * AUTHORS: Ana Chen Zhang
 */
public abstract class Mensaje {
    protected String remitente;
    protected String destinatario;

    /**
     * Constructor que inicializa el remitente y destinatario del mensaje.
     * @param remitente Nombre o identificación del remitente
     * @param destinatario Nombre o identificación del destinatario
     */
    public Mensaje(String remitente, String destinatario){
        this.remitente = remitente;
        this.destinatario = destinatario;
    }

    /**
     * Retorna una representación en cadena del mensaje, mostrando el remitente y el destinatario.
     * @return Cadena que describe el remitente y destinatario del mensaje
     */
    @Override
    public String toString(){
        return "Remitente: " + remitente + "\nDestinatario: " + destinatario;
    }

    /**
     * Método abstracto para reproducir el mensaje; su implementación dependerá de la subclase.
     */
    abstract void reproducir();

    /**
     * Obtiene el destinatario del mensaje.
     * @return Destinatario del mensaje
     */
    public String getDestinatario() {
        return destinatario;
    }

    /**
     * Obtiene el remitente del mensaje.
     * @return Remitente del mensaje
     */
    public String getRemitente() {
        return remitente;
    }

    /**
     * Establece el destinatario del mensaje.
     * @param destinatario Nombre o identificación del nuevo destinatario
     */
    public void setDestinatario(String destinatario){
        this.destinatario = destinatario;
    }

    /**
     * Establece el remitente del mensaje.
     * @param remitente Nombre o identificación del nuevo remitente
     */
    public void setRemitente(String remitente){
        this.remitente = remitente;
    }
}
