package ia;

public class IAController {

    public static String responder(String mensaje) {
        mensaje = mensaje.toLowerCase();

        if (mensaje.contains("hola")) {
            return "¡Hola! ¿En qué puedo ayudarte?";
        } else if (mensaje.contains("usuario")) {
            return "Puedes gestionar usuarios desde el menú de administración.";
        } else if (mensaje.contains("producto")) {
            return "Para registrar productos, ve al módulo de inventario.";
        } else if (mensaje.contains("adiós") || mensaje.contains("gracias")) {
            return "¡Hasta luego! Que tengas un buen día 😊";
        } else {
            return "Lo siento, aún estoy aprendiendo. ¿Puedes reformular la pregunta?";
        }
    }
}
