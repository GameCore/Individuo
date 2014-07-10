/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package poblacion;

import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.util.Scanner;

/**
 *
 * @author Pablo
 */
public class Poblacion extends JPanel {
    
    
    int tam_pob;
    int tgen;
    int aux_gen[];
    int poblador;
    int auxFenotipo;
    int xmin;
    int xmax;
    double auxX;
   

    Individuo [] tpoblacion ;
    
              
    public void inicioPoblacion(int tam_pob,int lgen, int xmin, int xmax){
        
        /*
        Pedir primero que ada el valor de xmax y xmin en el main
        */
        this.xmin = xmin;
        this.xmax = xmax;
       tgen=lgen;
        
        tpoblacion = new Individuo[xmax] ;
        for(int vc=0;vc<tam_pob;vc++){
            System.out.println(vc);
          tpoblacion[vc]= new Individuo (); 
          tpoblacion[vc].posicion = vc;
        aux_gen=crearGen(lgen);
        tpoblacion[vc].gen = aux_gen;
         auxFenotipo = valorFenotipo(aux_gen);
         tpoblacion[vc].fenotipo = auxFenotipo;
        auxX = valorX(xmax,xmin);
        tpoblacion[vc].x = auxX;
        tpoblacion[vc].adaptacion = adaptacion(auxX);
        poblador = vc;
        }
    
    }

    public int []crearGen(int lgen) {
        int gen[] = new int[lgen];
        for(int vc=0;vc<lgen;vc++){
            //gen = new int[vc];
            Random  aleatorio = new Random();
           gen[vc] = aleatorio.nextInt(2);
        
        }
        return gen;
    }

    public int valorFenotipo(int []aux_gen) {
        int genotipo;
        String valor="";
        
        for(int vc = 0;vc<aux_gen.length;vc++){
        valor+=aux_gen[vc];
        }        
         genotipo = Integer.parseInt(valor,2);
         return genotipo;
    }
    
    

    public double valorX(int xmax, int xmin) {
        double x =(xmin + auxFenotipo)*(xmax-xmin)/(Math.pow(this.tgen, 2));     
                return x;        
    }

    private double adaptacion(double x) {
        double adaptacion;
        adaptacion = x/(1+ Math.pow(x, 2));
        return adaptacion;
    }
    
   
    public void imprimirPoblacion(){
       
      String gen;
    for(int vc=0 ; vc < tpoblacion.length; vc++ ){
        gen="";
         for(int vc2=0 ; vc2 < tgen; vc2++ ){
          gen += Integer.toString(tpoblacion[vc].gen[vc2]);  
         }
       
    System.out.printf("%10d  \t %10s  \t %10d \t %10.6f \t %10.6f \n",tpoblacion[vc].posicion , gen , tpoblacion[vc].fenotipo, tpoblacion[vc].x, tpoblacion[vc].adaptacion);

            
    }
    
    }
    
    
    
    
    
     
}
