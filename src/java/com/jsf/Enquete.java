/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsf;

import java.util.ArrayList;
import java.util.Arrays;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author John Lima
 */
@ManagedBean(name = "enquete")
@SessionScoped
public class Enquete {

    private int escolhida;
    private static int[] votos = new int[5];
    private static ArrayList<String> matsNames = new ArrayList<String>() {
        {
            add("Desenvolvimento de Sistemas Web 3");
            add("Engenharia de Software 2");
            add("Linguagem de Programacao Orientada a Objetos 2");
            add("Sistema Operacional 2");
            add("Analise e Modelagem Multidimensional");
        }
    };
    private Mat mat;
    private static ArrayList<Mat> mats = new ArrayList<Mat>();
    private static int totalDeVotos = 0;

    @PostConstruct
    public void init() {
        for (String m : matsNames) {
            mat = new Mat();
            mat.setDisciplina(m);
            mats.add(mat);
            System.out.println(m);
        }
    }

    public String votar() {
        votos[escolhida]++;
        totalDeVotos++;
        for (int i = 0; i < mats.size(); i++) {
            mats.get(i).setVotos(votos[i]);
            mats.get(i).setPercent((double) votos[i] / totalDeVotos);
        }
        System.out.println("Votos " + Arrays.toString(votos));
        return "result";
    }

    public String result() {
        return "result";
    }

    public static int[] getVotos() {
        return votos;
    }

    public static void setVotos(int[] votos) {
        Enquete.votos = votos;
    }

    public Enquete() {
    }

    public int getEscolhida() {
        return escolhida;
    }

    public void setEscolhida(int escolhida) {
        this.escolhida = escolhida;
    }

    public Mat getMat() {
        return mat;
    }

    public void setMat(Mat mat) {
        this.mat = mat;
    }

    public ArrayList<Mat> getMats() {
        return mats;
    }

    public void setMats(ArrayList<Mat> mats) {
        Enquete.mats = mats;
    }

    public ArrayList<String> getMatsNames() {
        return matsNames;
    }

    public void setMatsNames(ArrayList<String> matsNames) {
        Enquete.matsNames = matsNames;
    }

    public int getTotalDeVotos() {
        return totalDeVotos;
    }

    public void setTotalDeVotos(int totalDeVotos) {
        this.totalDeVotos = totalDeVotos;
    }
}
