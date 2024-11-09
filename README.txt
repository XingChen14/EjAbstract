"Clases abstractas"
AUTHORS: Ana Chen Zhang

Vamos a crear una aplicación que manipula los mensajes que llegan de correo, 
estos mensajes pueden ser mensajes de texto, mensajes de voz o mensajes de fax.

|----------------------------|
|<abstract> Mensaje          |
|----------------------------|
|String remitente            |
|String emisor               |
|----------------------------|
|<abstract> reproducir();    |
|----------------------------|

|----------------------------|
| MensajeTexto               |
|----------------------------|
| String texto               |
|----------------------------|
| reproducir();              |
|----------------------------|

|----------------------------|
| MensajeFax                 |
|----------------------------|
| String nombreArchivo       |
|----------------------------|
| reproducir();              |
|----------------------------|

Continuar con el ejemplo de Mensaje y agregar lo que se describe a continuación.
    borrar mensajes por remitente
    CON LAMDAS buscar mensajes por remitente que regrese un hasmap(nombreRemitente,mensaje)
    CON LAMDAS buscar mensaje por tipo, regresa un ArrayList con los mensajes del tipo indicado
    ordenar los mensajes por remitente.
    poder reproducir un mensaje en particular de acuerdo al índice seleccionado
    