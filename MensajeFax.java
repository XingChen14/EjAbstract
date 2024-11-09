/**
 * Esta clase representa un mensaje de fax, que incluye un archivo de texto para ser reproducido.
 * Hereda de la clase Mensaje.
 * 
 * AUTHORS: Ana Chen Zhang
 */
public class MensajeFax extends Mensaje {
    private String nombreArchivo;

    /**
     * Constructor que inicializa el remitente, destinatario y nombre del archivo del fax.
     * @param remitente Nombre o identificación del remitente
     * @param destinatario Nombre o identificación del destinatario
     * @param nombreArchivo Nombre del archivo que contiene el fax
     */
    public MensajeFax(String remitente, String destinatario, String nombreArchivo) {
        super(remitente, destinatario);
        this.nombreArchivo = nombreArchivo;
    }

    /**
     * Este método es para reproducir el fax, en este caso se manda a la impresora.
     * Imprime el contenido del archivo de fax en la consola.
     */
    @Override
    void reproducir() {
        // Leer e imprimir el archivo de texto especificado en el atributo nombreArchivo
        System.out.println("Reproduciendo fax desde el archivo: " + nombreArchivo);
    }

    /**
     * Retorna una representación en cadena del mensaje de fax, incluyendo el archivo.
     * @return Cadena que describe el remitente, destinatario y nombre del archivo del fax
     */
    @Override
    public String toString() {
        return super.toString() + "\nArchivo de fax: " + nombreArchivo;
    }

    /**
     * Obtiene el nombre del archivo del fax.
     * @return Nombre del archivo del fax
     */
    public String getNombreArchivo() {
        return nombreArchivo;
    }

    /**
     * Establece el nombre del archivo del fax.
     * @param nombreArchivo Nombre del nuevo archivo de fax
     */
    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }
}
