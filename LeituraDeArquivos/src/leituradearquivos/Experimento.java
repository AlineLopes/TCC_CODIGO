/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leituradearquivos;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author aline
 */
public class Experimento {

    public int replicacao = 10;
    public int geracao[] = new int[2];
    public int mu[] = new int[2];
    public int lambda[] = new int[2];
    public int lahc[] = new int[2];
    public double bl[] = new double[2];
    public int timeout[] = new int[2];

    private int indexGeracao;
    private int indexMu;
    private int indexLambda;
    private int indexLahc;
    private int indexBl;
    private int indexTimeout;
    private double[] combinacao = new double[7];

    private ArrayList<double[]> combinacoes = new ArrayList<>();

    private boolean fezTodas = false;

    public Experimento() {
        reset();
    }

    public void reset() {
        geracao[0] = 100;
        geracao[1] = 1000;
        mu[0] = 20;
        mu[1] = 50;
        lambda[0] = 5;
        lambda[1] = 10;
        lahc[0] = 15;
        lahc[1] = 25;
        bl[0] = 0.3;
        bl[1] = 0.7;
        timeout[0] = 100;
        timeout[1] = 1000;

    }

    @Override
    public String toString() {
        return "Experimento{" + ", geracao=" + geracao[indexGeracao] + ", mu=" + mu[indexMu] + ", lambda=" + lambda[indexLambda] + ", lahc=" + lahc[indexLahc] + ", bl=" + bl[indexBl] + ", timout=" + timeout[indexTimeout] + '}';
    }

    public void geraCombinacao() {
        Random rnd = new Random();
        if (rnd.nextInt() % 2 == 0) {
            indexGeracao = 0;
        } else {
            indexGeracao = 1;
        }

        if (rnd.nextInt() % 2 == 0) {
            indexMu = 0;
        } else {
            indexMu = 1;
        }

        if (rnd.nextInt() % 2 == 0) {
            indexLambda = 0;
        } else {
            indexLambda = 1;
        }

        if (rnd.nextInt() % 2 == 0) {
            indexLahc = 0;
        } else {
            indexLahc = 1;
        }

        if (rnd.nextInt() % 2 == 0) {
            indexBl = 0;
        } else {
            indexBl = 1;
        }

        if (rnd.nextInt() % 2 == 0) {
            indexTimeout = 0;
        } else {
            indexTimeout = 1;
        }
        combinacao = new double[7];
        combinacao[0] = geracao[indexGeracao];
        combinacao[1] = mu[indexMu];
        combinacao[2] = lambda[indexLambda];
        combinacao[3] = lahc[indexLahc];
        combinacao[4] = bl[indexBl];
        combinacao[5] = timeout[indexTimeout];

        if (combinacoes.size() >= 64) {
            System.out.println("Acabaram as combinacoes");
            fezTodas = true;
            return;
        }

        if (combinacoes.contains(combinacao)) {
            geraCombinacao();
        }

        combinacoes.add(combinacao);

        geraCombinacao();

    }

    public ArrayList adicionaInstancia() {
        ArrayList comb = new ArrayList<>();
        for (int i = 0; i < combinacoes.size(); i++) {
//            for (int j = 0; j < 9; j++) {
            for (int j = 0; j < 4; j++) {
                combinacoes.get(i)[6] = j;
                comb.add(combinacoes.get(i).clone());
            }
        }
        return comb;
    }

    public boolean isFezTodas() {
        return fezTodas;
    }

    public void setFezTodas(boolean f) {
        fezTodas = f;
    }

    public int getGeracao() {
        return geracao[indexGeracao];
    }

    public int getMu() {
        return mu[indexMu];
    }

    public int getLambda() {
        return lambda[indexLambda];
    }

    public int getLahc() {
        return lahc[indexLahc];
    }

    public double getBl() {
        return bl[indexBl];
    }

    public int getTimout() {
        return timeout[indexTimeout];
    }

}
