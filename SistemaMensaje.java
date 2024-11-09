import java.util.*;
import java.util.stream.Collectors;

/**
 * Clase que representa el sistema de gestión de mensajes.
 * Permite agregar, borrar, buscar, ordenar y reproducir mensajes de diferentes tipos.
 */
public class SistemaMensaje {
    private static ArrayList<Mensaje> misMensajes;

    /**
     * Constructor que inicializa la lista de mensajes.
     */
    public SistemaMensaje() {
        misMensajes = new ArrayList<>();
    }

    /**
     * Este método es para agregar un mensaje al sistema.
     * @param m El mensaje a agregar
     */
    public static void inMensaje(Mensaje m) {
        misMensajes.add(m);
    }

    /**
     * Este método es para borrar todos los mensajes de un remitente específico.
     * @param remitente El remitente cuyos mensajes serán eliminados
     */
    public static void borrarMensajesPorRemitente(String remitente) {
        misMensajes.removeIf(m -> m.getRemitente().equals(remitente));
    }

    /**
     * Este método es para reproducir todos los mensajes almacenados en el sistema.
     */
    public static void reproducirTodosMisMensajes() {
        for (Mensaje misMensaje : misMensajes) {
            System.out.println("---------------------------------------");
            System.out.println(misMensaje.toString());
            misMensaje.reproducir();
            System.out.println("---------------------------------------");
        }
    }

    /**
     * Este método es para buscar y reproducir mensajes de un remitente específico.
     * @param remitente El remitente cuyos mensajes serán buscados
     */
    public static void buscarMensajesPorRemitente(String remitente) {
        Map<String, List<Mensaje>> mensajesPorRemitente = misMensajes.stream()
                .filter(m -> m.getRemitente().equalsIgnoreCase(remitente))
                .collect(Collectors.groupingBy(Mensaje::getRemitente));

        if (mensajesPorRemitente.isEmpty()) {
            System.out.println("No se encontraron mensajes de " + remitente);
        } else {
            mensajesPorRemitente.forEach((rem, mensajes) -> {
                for (Mensaje mensaje : mensajes) {
                    System.out.println("---------------------------------------");
                    System.out.println(mensaje.toString());
                    mensaje.reproducir();
                    System.out.println("---------------------------------------");
                }
            });
        }
    }

    /**
     * Este método es para buscar y reproducir mensajes de un tipo específico.
     * @param tipo Clase del tipo de mensaje que se desea buscar
     * @param <T> Tipo de mensaje que extiende de Mensaje
     */
    public static <T extends Mensaje> void buscarMensajesPorTipo(Class<T> tipo) {
        List<T> mensajesDelTipo = misMensajes.stream()
                .filter(tipo::isInstance)
                .map(tipo::cast)
                .collect(Collectors.toList());

        if (mensajesDelTipo.isEmpty()) {
            System.out.println("No se encontraron mensajes del tipo especificado.");
        } else {
            for (Mensaje mensaje : mensajesDelTipo) {
                System.out.println("---------------------------------------");
                System.out.println(mensaje.toString());
                mensaje.reproducir();
                System.out.println("---------------------------------------");
            }
        }
    }

    /**
     * Este método es para ordenar los mensajes por el nombre del remitente.
     */
    public static void ordenarMensajesPorRemitente() {
        misMensajes.sort((m1, m2) -> m1.getRemitente().compareTo(m2.getRemitente()));
    }

    /**
     * Este método es para reproducir un mensaje en una posición específica de la lista.
     * @param indice Posición del mensaje en la lista
     */
    public static void reproducirMensajePorIndice(int indice) {
        if (indice >= 0 && indice < misMensajes.size()) {
            Mensaje mensaje = misMensajes.get(indice);
            System.out.println("---------------------------------------");
            System.out.println(mensaje.toString());
            mensaje.reproducir();
            System.out.println("---------------------------------------");
        } else {
            System.out.println("Índice fuera de rango.");
        }
    }

    /**
     * Método principal que muestra un menú interactivo para el usuario.
     * Permite ejecutar las diferentes opciones del sistema de mensajes.
     */
    public static void main(String[] args) {
        SistemaMensaje sistema = new SistemaMensaje();

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Sistema de Mensajes ---");
            System.out.println("1. Agregar mensaje de texto");
            System.out.println("2. Agregar mensaje de fax");
            System.out.println("3. Agregar mensaje de voz");
            System.out.println("4. Reproducir todos los mensajes");
            System.out.println("5. Borrar mensajes por remitente");
            System.out.println("6. Buscar mensajes por remitente");
            System.out.println("7. Buscar mensajes por tipo");
            System.out.println("8. Ordenar mensajes por remitente");
            System.out.println("9. Reproducir mensaje por índice");
            System.out.println("10. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1 -> {
                    System.out.print("Ingrese remitente: ");
                    String remitenteTexto = scanner.nextLine();
                    System.out.print("Ingrese destinatario: ");
                    String destinatarioTexto = scanner.nextLine();
                    System.out.print("Ingrese el texto del mensaje: ");
                    String texto = scanner.nextLine();
                    inMensaje(new MensajeTexto(remitenteTexto, destinatarioTexto, texto));
                    System.out.println("Mensaje de texto agregado.");
                }

                case 2 -> {
                    System.out.print("Ingrese remitente: ");
                    String remitenteFax = scanner.nextLine();
                    System.out.print("Ingrese destinatario: ");
                    String destinatarioFax = scanner.nextLine();
                    System.out.print("Ingrese el nombre del archivo de fax: ");
                    String nombreArchivo = scanner.nextLine();
                    inMensaje(new MensajeFax(remitenteFax, destinatarioFax, nombreArchivo));
                    System.out.println("Mensaje de fax agregado.");
                }

                case 3 -> {
                    System.out.print("Ingrese remitente: ");
                    String remitenteVoz = scanner.nextLine();
                    System.out.print("Ingrese destinatario: ");
                    String destinatarioVoz = scanner.nextLine();
                    System.out.print("Ingrese duración del mensaje de voz (en segundos): ");
                    int duracion = scanner.nextInt();
                    inMensaje(new MensajeVoz(remitenteVoz, destinatarioVoz, duracion));
                    System.out.println("Mensaje de voz agregado.");
                }

                case 4 -> reproducirTodosMisMensajes();

                case 5 -> {
                    System.out.print("Ingrese el remitente cuyos mensajes desea borrar: ");
                    String remitenteBorrar = scanner.nextLine();
                    borrarMensajesPorRemitente(remitenteBorrar);
                    System.out.println("Mensajes borrados.");
                }

                case 6 -> {
                    System.out.print("Ingrese el remitente para buscar mensajes: ");
                    String remitenteBuscar = scanner.nextLine();
                    buscarMensajesPorRemitente(remitenteBuscar);
                }

                case 7 -> {
                    System.out.println("Seleccione el tipo de mensaje para buscar:");
                    System.out.println("1. MensajeTexto");
                    System.out.println("2. MensajeFax");
                    System.out.println("3. MensajeVoz");
                    int tipo = scanner.nextInt();
                    scanner.nextLine(); // Limpiar buffer
                    switch (tipo) {
                        case 1 -> buscarMensajesPorTipo(MensajeTexto.class);
                        case 2 -> buscarMensajesPorTipo(MensajeFax.class);
                        case 3 -> buscarMensajesPorTipo(MensajeVoz.class);
                        default -> System.out.println("Tipo de mensaje no válido.");
                    }
                }

                case 8 -> {
                    ordenarMensajesPorRemitente();
                    System.out.println("Mensajes ordenados por remitente.");
                }

                case 9 -> {
                    System.out.print("Ingrese el índice del mensaje a reproducir: ");
                    int indice = scanner.nextInt();
                    reproducirMensajePorIndice(indice);
                }

                case 10 -> System.out.println("Saliendo del sistema de mensajes.");

                default -> System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 10);
    }
}
