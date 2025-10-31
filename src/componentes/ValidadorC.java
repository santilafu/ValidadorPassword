package componentes;

/*
 * Componente reutilizable que extiende JPasswordField.
 * Su función es validar contraseñas según las siguientes reglas:
 * - Mínimo 8 caracteres
 * - Al menos una mayúscula
 * - Al menos una minúscula
 * - Al menos un número
 * - Al menos un carácter especial
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class ValidadorC extends JPasswordField {

    // Colores que indican si la contraseña es válida o no
    private final Color colorValido = new Color(68, 232, 68);   // Verde claro
    private final Color colorInvalido = new Color(246, 10, 48); // Rojo

    // Constructor del componente
    public ValidadorC() {
        super(15); // Establece el tamaño del campo de texto
        setFont(new Font("DialogInput", Font.PLAIN, 16)); // Fuente de texto
        setBackground(Color.WHITE); // Fondo inicial blanco

        // Agregamos un listener que detecta cuando el campo pierde el foco
        // (es decir, cuando el usuario hace clic fuera del campo)
        addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                validarContrasena(); // Al perder el foco, se ejecuta la validación
            }
        });
    }

    // Método privado que realiza la validación y cambia el color del fondo
    private void validarContrasena() {
        String contrasena = new String(getPassword()).trim();

        // Variables que indican si se cumplen los requisitos
        boolean tieneMayuscula = false;
        boolean tieneMinuscula = false;
        boolean tieneNumero = false;
        boolean tieneEspecial = false;

        // Conjunto de caracteres especiales aceptados
        String caracteresEspeciales = "!@#$%^&*()-_=+[]{}|;:'\",.<>?/`~";

        // Recorremos cada carácter de la contraseña
        for (char c : contrasena.toCharArray()) {
            if (Character.isUpperCase(c)) tieneMayuscula = true;      // Detecta mayúsculas
            else if (Character.isLowerCase(c)) tieneMinuscula = true; // Detecta minúsculas
            else if (Character.isDigit(c)) tieneNumero = true;        // Detecta números
            else if (caracteresEspeciales.contains(String.valueOf(c))) tieneEspecial = true; // Detecta caracteres especiales
        }

        // Comprueba que la longitud sea de al menos 8 caracteres
        boolean longitudCorrecta = contrasena.length() >= 8;

        // Verifica si se cumplen todos los requisitos
        boolean esValida = longitudCorrecta && tieneMayuscula && tieneMinuscula && tieneNumero && tieneEspecial;

        // Cambia el color del fondo y muestra un mensaje al pasar el ratón
        if (esValida) {
            setBackground(colorValido);
            setToolTipText("Contraseña segura");
        } else {
            setBackground(colorInvalido);

            // Construye un mensaje indicando qué requisitos faltan
            StringBuilder mensaje = new StringBuilder("<html>Requisitos no cumplidos:<br>");
            if (!longitudCorrecta) mensaje.append("- Mínimo 8 caracteres<br>");
            if (!tieneMayuscula) mensaje.append("- Al menos una mayúscula<br>");
            if (!tieneMinuscula) mensaje.append("- Al menos una minúscula<br>");
            if (!tieneNumero) mensaje.append("- Al menos un número<br>");
            if (!tieneEspecial) mensaje.append("- Al menos un carácter especial (!@#$%^&*...)<br>");
            mensaje.append("</html>");

            setToolTipText(mensaje.toString());
        }
    }

    // Método público que devuelve true si la contraseña es válida, false si no
    public boolean esValida() {
        String contrasena = new String(getPassword()).trim();

        boolean tieneMayuscula = false;
        boolean tieneMinuscula = false;
        boolean tieneNumero = false;
        boolean tieneEspecial = false;
        String caracteresEspeciales = "!@#$%^&*()-_=+[]{}|;:'\",.<>?/`~";

        // Recorre la contraseña para verificar todos los requisitos
        for (char c : contrasena.toCharArray()) {
            if (Character.isUpperCase(c)) tieneMayuscula = true;
            else if (Character.isLowerCase(c)) tieneMinuscula = true;
            else if (Character.isDigit(c)) tieneNumero = true;
            else if (caracteresEspeciales.contains(String.valueOf(c))) tieneEspecial = true;
        }

        boolean longitudCorrecta = contrasena.length() >= 8;

        // Devuelve el resultado final
        return longitudCorrecta && tieneMayuscula && tieneMinuscula && tieneNumero && tieneEspecial;
    }
}
