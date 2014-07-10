/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package poblacion;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Pablo
 */
public class AppGen {
    
Poblacion po = new Poblacion();
    
    public static void main(String[] args) {
    int xmax=0;
    int xmin=0;
    int lgen=0;
    double precision = 0;
     Scanner t = new Scanner(System.in);
        
      System.out.println("Dame los valores del intervalo minimo  ");
           xmin = t.nextInt();
              System.out.println("Dame los valores del intervalo maximo  ");
              xmax = t.nextInt();
              System.out.println("Dame los valor de la precicion");
              precision = t.nextDouble();
             lgen= logaritmoCadenaBinaria( xmin, xmax , precision );
             System.out.println(lgen);
             Poblacion p = new Poblacion();
             System.out.println(xmax +"  " + lgen +"  " + xmin +"  " +xmax);
             p.inicioPoblacion(xmax , lgen , xmin ,xmax);
             p.imprimirPoblacion();
    }
    
    public static int logaritmoCadenaBinaria(int xmin, int xmax,double precision){
        int logCadBin;
    logCadBin = (int)Math.round( Math.log(1+((xmax-xmin)/precision))/Math.log(2));    
    return logCadBin;
    
    }
    
   
}
 
