/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsf;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


/**
 *
 * @author John Lima
 */
@ManagedBean(name = "enquete")
@SessionScoped
public class Enquete {
    private String escolhida = "";
    private static int[] votos = new int[5];

    public static int[] getVotos() {
        return votos;
    }

    public static void setVotos(int[] votos) {
        Enquete.votos = votos;
    }

    public Enquete() {
    }
    
    public String votar() {
        System.out.println("Votou " + escolhida);
//        votos[escolhida]++;
        return "result";
    }
    
    public String result() {
        return "result";
    }
    
    public String getEscolhida() {
        return escolhida;
    }

    public void setEscolhida(String escolhida) {
        this.escolhida = escolhida;
    }
    
    
}
