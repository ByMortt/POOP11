/*
 * Este programa muestra diferentes ejemplos de manipulación de archivos en Java,
 * incluyendo la creación de un archivo, la lectura y escritura de datos en él,
 * y el uso de la clase StringTokenizer para tokenizar una cadena de texto.
 */

package poop11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * La clase principal que contiene el método main para ejecutar el programa.
 */
public class POOP11 {

    /**
     * El método principal de la aplicación. Aquí se realiza la ejecución de las tareas.
     *
     * @param args Los argumentos de línea de comandos (no se utilizan en este caso).
     */
    public static void main(String[] args) {
        // Salida en consola
        System.out.println("Hola mundo");

        // Creación del archivo
        File archivo = new File("alumno.csv");
        System.out.println(archivo.exists());
        if (!archivo.exists()) {
            try {
                System.out.println("Creando archivo");
                boolean seCreo = archivo.createNewFile();
                System.out.println("Archivo creado correctamente: " + seCreo);
                System.out.println(archivo.exists());
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }

        System.out.println("*****************************************");

        try {
            // Lectura de texto ingresado por el usuario
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Escribe algo:");
            String texto = br.readLine();
            System.out.println("Texto ingresado: " + texto);

            // Escritura de datos en el archivo
            FileWriter fw = new FileWriter("alumno.csv");
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter salida = new PrintWriter(bw);
            salida.println(texto);
            for (int i = 0; i < 10; i++) {
                salida.println("Alumno" + i + ",Apellido" + i);
            }
            salida.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println("******************************************");

        try {
            // Lectura de datos desde el archivo
            FileReader fr = new FileReader("alumno.csv");
            BufferedReader br = new BufferedReader(fr);
            String linea = br.readLine();
            System.out.println(linea);
            while (linea != null) {
                System.out.println(linea);
                linea = br.readLine();
            }
            br.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println("*****************************************");

        // Tokenización de una línea de texto
        String linea = "Oscar,Abraham,Cruz,Lopez,317167434,21,20";
        StringTokenizer st = new StringTokenizer(linea, ",");
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }
    }
}

