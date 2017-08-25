/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author oscar
 */
public class JuegoAhorcado {
    
     private int oportunidades = 5;   //Número de chances
    private String palabra;      //Palabra a adivinar.
    private String catego;       //Categoria de palabras.
    private char letra;       //Entrada del usuario a verificar
    private String display;      //Palabra a vizualizar
    private String[] imagenes = {"a0.png", "a1.png", "a2.png", "a3.png", "a4.png", "a5.png"};
    // private String[] palabras = {"PERRO", "VACA", "MARIPOSA", "DELFIN", "JAGUAR", "LEÓN",
    //   "LEOPARDO", "GANSO", "COTORRO", "POLLO", "VENADO", "GALLINA"};
    private String[] palabras;
    private boolean[] acertadas;
    private int errores;
    private boolean banInicio; //Indica si el juego ah iniciado
    
    public void inicializarDatos(){
        errores=0;
        oportunidades= 5;
        banInicio=false;
    }

    public void cargarPalabras() {
        //Depende de la categoria seleccionada
        BufferedReader entrada; //canal de comunicacion de lectura
        File archivo = null;      //nombre del archivo fisico
        int num = 0;                //numero de palabras
        String linea = null;      //usada para leer na linea a la vez
        //Se selecciona el archivo
        switch (catego) {
            case "Animales":
                archivo = new File("C:\\Animales.txt");
                break;
            case "TICs":
                archivo = new File("C:\\Users\\oscar\\Desktop\\TICs.txt");
                break;
            case "Películas":
                archivo = new File("C:\\Users\\oscar\\Desktop\\Peliculas.txt");
                break;
            case "José José":
                archivo = new File("C:\\Users\\oscar\\Desktop\\Jose_Jose.txt");
                break;
            case "Frutas":
                archivo = new File("C:\\Users\\oscar\\Desktop\\Frutas.txt");
                break;
            case "Canciónes":
                archivo = new File("C:\\Users\\oscar\\Desktop\\Canciones.txt");
                break;

        }
        try {
            //Realiza la conexion al archivo
            entrada = new BufferedReader(new FileReader(archivo));
            linea = entrada.readLine();
            while (linea != null) { // mientras tenga texto
                num++;
                linea = entrada.readLine();
            }
            entrada.close();
            palabras = new String[num];
            //ciclo de lecturas para agregar las palabras
            entrada = new BufferedReader(new FileReader(archivo));
            for (int i = 0; i < num; i++) {
                palabras[i] = entrada.readLine();
            }
            entrada.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error, al intentar leer el archivo");
        }
    }

    public void seleccionarPalabras() {
        Random r1 = new Random();
        int pos = 0;
        pos = r1.nextInt(palabras.length);
        palabra = palabras[pos];
        acertadas = new boolean[palabra.length()];
    }

    public void generarDisplay() {
        display = "";
        for (int i = 0; i < palabra.length(); i++) {
            if (acertadas[i]) {
                display += palabra.charAt(i) + " ";
            } else {
                display += "_ ";
            }
        }
    }

    public boolean esCorrecta(char letra) {
        this.letra = letra;
        boolean banOk = false;
        for (int i = 0; i < palabra.length(); i++) {
            if (letra == palabra.charAt(i)) {
                acertadas[i] = true;
                banOk = true;
            }
        }
        if (!banOk && banInicio) {
            errores++;
            oportunidades--;
        }
        generarDisplay();
        return banOk;
    }

    public boolean yaGano() {
        for (int i = 0; i < acertadas.length; i++) {
            if (!acertadas[i]) {
                return false;
            }
        }
        return true;
    }
    
    public boolean yaPerdio(){
        return (errores==imagenes.length-1);
    }

    public String getDisplay() {
        return display;
    }

    public String getPalabra() {
        return palabra;
    }

    public String getImagen() {
        return imagenes[errores];
    }

    public void setBanInicio(boolean banInicio) {
        this.banInicio = banInicio;
    }

    public void setCatego(String catego) {
        this.catego = catego;
    }

    public int getOportunidades() {
        return oportunidades;
    }
    
//    public void setLetra(char letra) {
//        this.letra = letra;
//    }

    public boolean isBanInicio() {
        return banInicio;
    }
    
}
