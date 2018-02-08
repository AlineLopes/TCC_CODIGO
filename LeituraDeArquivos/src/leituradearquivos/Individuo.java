/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leituradearquivos;

import java.util.ArrayList;

/**
 *
 * @author aline
 */
public class Individuo implements Comparable<Individuo> {

    String[][] solucao;
    int funcao_Objetivo;
    Problem p;

    public Individuo(String[][] populacaoInicial, Problem problem) {
        this.solucao = populacaoInicial;
        this.p = problem;
    }

    public String[][] getSolucao() {
        return solucao;
    }

    public void setSolucao(String[][] populacaoInicial) {
        this.solucao = populacaoInicial;
    }

    public Integer getFuncao_Objetivo() {
        return funcao_Objetivo;
    }

    public void setFuncao_Objetivo(int funcao_Objetivo) {
        this.funcao_Objetivo = funcao_Objetivo;
    }

    @Override
    protected Individuo clone() throws CloneNotSupportedException {
        Individuo individuo = new Individuo(this.getSolucao().clone(), this.p);
        String[][] s = new String[this.p.vetorScheduling_Period.size()][this.p.getEmployee().length]; //= this.solucao.clone();
        
        for(int i = 0; i < this.p.vetorScheduling_Period.size(); i++) {
            for(int j = 0; j < this.p.getEmployee().length; j++) {
                s[i][j] = this.solucao[i][j];
            }
        }
        
        individuo.setSolucao(s);
        individuo.setFuncao_Objetivo(this.getFuncao_Objetivo());

        return individuo;
    }

    @Override
    public int compareTo(Individuo o) {

        return this.getFuncao_Objetivo().compareTo(o.getFuncao_Objetivo());
    }

}
