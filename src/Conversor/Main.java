package Conversor;

import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;


public class Main {
    public static void main(String[] args) throws Exception {

        Object[] options = {"Convertir monedas", "Convertir temperaturas", "salir"};
        int elige = JOptionPane.showOptionDialog(null, "Que quieres hacer", "Conversor",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        if (elige == 2) {
            JOptionPane.showMessageDialog(null, "Programa cerrado");
            System.exit(0);
        }
        if (elige == 0) {
            DecimalFormat formatDivisa = new DecimalFormat("#.##");
            boolean continuarPrograma = true;
            while (continuarPrograma) {
                String[] opciones = {"AR$->U$D", "AR$->EUR", "AR$->GBP(libras esterlinas)", "AR$->YEN",};
                String cambio = (String) JOptionPane.showInputDialog(null, "Elige una opcion",
                        "Conversor de monedas", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
                String input = JOptionPane.showInputDialog(null, "Ingrese cantidad de pesos");
                double pesos = 0.00;
                try {
                    pesos = Double.parseDouble(input);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Valor no valido");
                }

                if (cambio.equals("AR$->U$D")) {
                    double dolares = pesos * 0.350;
                    JOptionPane.showMessageDialog(null,
                            pesos + "Pesos argentinos son: " + formatDivisa.format(dolares) + " Dolares.");
                } else if (cambio.equals("AR$->EUR")) {
                    double euro = pesos * 0.215;
                    JOptionPane.showMessageDialog(null,
                            pesos + "Pesos argentinos son: " + formatDivisa.format(euro) + " Euros");
                } else if (cambio.equals("AR$->GBP(libras esterlinas)")) {
                    double libra = pesos * 0.244;
                    JOptionPane.showMessageDialog(null,
                            pesos + "Pesos argentinos son: " + formatDivisa.format(libra) + " Libras esterlinas");
                } else if (cambio.equals("AR$->YEN")) {
                    double yen = pesos * 0.150;
                    JOptionPane.showMessageDialog(null,
                            pesos + "Pesos argentinos son: " + formatDivisa.format(yen) + " Yenes chinos");
                    int confirma = JOptionPane.showConfirmDialog(null, "¿Desea continuar con el programa?", "Confirmar", JOptionPane.YES_NO_CANCEL_OPTION);
                    if (confirma == JOptionPane.NO_OPTION || confirma == JOptionPane.CANCEL_OPTION) {
                        continuarPrograma = false;
                        JOptionPane.showMessageDialog(null, "Programa finalizado");
                    }
                }
            }
        }
        if(elige ==1){
            boolean seguirPrograma = true;
            while(seguirPrograma){
                String[] opcione = {"Celsius a Fahrenheit", "Fahrenheit a Celsius"};
                String cambioString=  (String) JOptionPane.showInputDialog(null, "Elige una opcion", "Conversor de Temperatura",JOptionPane.QUESTION_MESSAGE, null, opcione, opcione[0]);
                int cambio = 0;
                System.out.println(cambioString);
                String valorNominal = JOptionPane.showInputDialog(null, "Ingrese valor a convertir");
                double valor = 0.0;
                try{
                    valor = Double.parseDouble(valorNominal);
                }catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(null,"valor no valido");
                    System.exit(0);
                }
                double resultado = 0;

                if(cambioString =="Celsius a Fahrenheit"){
                    cambio = 0;
                } else if(cambioString == "Fahrenheit a Celsius"){
                    cambio = 1;
                }

                 if(cambio == 0){
                    resultado = (valor *9/5) +32;
                    JOptionPane.showMessageDialog(null, valor + " Grados Celsius son: " + resultado + " Grados Fahrenheit");
                }else if(cambio == 1){
                    resultado = (valor - 32) *5/9;
                    JOptionPane.showMessageDialog(null, valor + "Grados Fahrenheit son: " + resultado + "Grados Celsuis");
                }

                int continuar = JOptionPane.showConfirmDialog(null,"¿Desea seguir uasndo el programa?", "", JOptionPane.YES_NO_OPTION);
                if(continuar == JOptionPane.NO_OPTION){
                    seguirPrograma = false;
                    JOptionPane.showMessageDialog(null,"Programa finalizado");
                }
            }
        }
    }
}