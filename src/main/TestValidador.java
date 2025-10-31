package main;

// Importamos nuestro componente de validación
import componentes.ValidadorC;

// Librerías de interfaz gráfica
import javax.swing.*;
import java.awt.*;

public class TestValidador {

    public static void main(String[] args) {

        //Creamos la ventana principal
        JFrame ventana = new JFrame("Validador de Contraseña");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierra la app al cerrar la ventana
        ventana.setSize(450, 260); // Tamaño de la ventana
        ventana.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 15)); // Organiza los componentes
        ventana.getContentPane().setBackground(new Color(245, 245, 245)); // Fondo gris claro

        //Etiqueta superior que indica qué debe hacer el usuario
        JLabel etiqueta = new JLabel("Introduce tu contraseña:");
        etiqueta.setFont(new Font("DialogInput", Font.BOLD, 14));

        // Campo de contraseña personalizado
        ValidadorC campo = new ValidadorC();

        //Etiqueta que muestra los requisitos de la contraseña
        JLabel requisitos = new JLabel("<html><body style='text-align:left;'>"
                + "Requisitos:<br>"
                + "- Mínimo 8 caracteres<br>"
                + "- Al menos una mayúscula<br>"
                + "- Al menos una minúscula<br>"
                + "- Al menos un número<br>"
                + "- Al menos un carácter especial (!@#$%^&*)"
                + "</body></html>");
        requisitos.setFont(new Font("DialogInput", Font.PLAIN, 12));
        requisitos.setForeground(Color.DARK_GRAY);

        //Botón para confirmar la contraseña
        JButton botonConfirmar = new JButton("Confirmar");
        botonConfirmar.setFont(new Font("DialogInput", Font.BOLD, 14));
        botonConfirmar.setBackground(new Color(100, 149, 237)); // Azul
        botonConfirmar.setForeground(Color.WHITE); // Texto blanco
        botonConfirmar.setFocusPainted(false); // Quita el borde de enfoque
        botonConfirmar.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Cambia el cursor a mano

        // Acción que se ejecuta al pulsar el botón
        botonConfirmar.addActionListener(e -> {
            // Obtenemos el texto del campo
            String contrasena = new String(campo.getPassword()).trim();

            // Si el campo está vacío, muestra un mensaje de advertencia
            if (contrasena.isEmpty()) {
                JOptionPane.showMessageDialog(
                        ventana,
                        "Debes introducir una contraseña antes de confirmar.",
                        "Campo vacío",
                        JOptionPane.WARNING_MESSAGE
                );
            }
            // Si la contraseña es válida (según la lógica del componente)
            else if (campo.esValida()) {
                JOptionPane.showMessageDialog(
                        ventana,
                        "Contraseña válida. Acceso permitido.",
                        "Validación correcta",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
            // Si no cumple los requisitos
            else {
                JOptionPane.showMessageDialog(
                        ventana,
                        "Contraseña no válida. Revisa los requisitos indicados.",
                        "Error de validación",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        });

        //Añadimos los componentes a la ventana
        ventana.add(etiqueta);
        ventana.add(campo);
        ventana.add(requisitos);
        ventana.add(botonConfirmar);

        //Centramos la ventana en la pantalla y la mostramos
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }
}
