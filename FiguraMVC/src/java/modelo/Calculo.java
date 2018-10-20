/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Gerson Risso
 */
public class Calculo {
    
    public static float calcArea(float lado){
      if(lado<0)
          throw new IllegalArgumentException("Medida inválida");
      else          
        return lado*lado;
    }
    
    public static float calcArea(float larg,float comp){
      return larg*comp;
    }
    
}
