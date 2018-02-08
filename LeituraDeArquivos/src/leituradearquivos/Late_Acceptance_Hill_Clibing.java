/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leituradearquivos;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author aline
 */
public class Late_Acceptance_Hill_Clibing {

    int iteracao, fOBest, limite, week;
    ArrayList<Result> vetor_Hill_Climbing;
    Problem problem;
    Individuo individuoDescendente;
    Configuracao  conf = new Configuracao();

    public Late_Acceptance_Hill_Clibing(int fOBest, int limite, Problem problem) {
        this.fOBest = fOBest;
        this.limite = limite;
        this.problem = problem;
    }

    public Individuo lAHC(String[][] representacao) {
        Random rnd = new Random();
        //APLICAR SOMENTE EM 30 PORCENTO DA POPULAÇÃO
        if (rnd.nextDouble() <= Main.conf.tRefinamento) { 
            iteracao = 1;
            vetor_Hill_Climbing = new ArrayList<Result>();
            Funcao_Objetivo funcao_Objetivo = new Funcao_Objetivo(problem.employee.length, problem);
            Mutacao mutacao = new Mutacao(problem);

            //INICIAR RESULT    
            Result result = new Result(iteracao, fOBest);
            //INICIAR O LAHC
            preencherLAHC(limite, result);
            //IMPRIMIR O LAHC
            imprimeLAHC();

            long t0 = System.currentTimeMillis();
            int teste = 0;
            //DEFINIR EXECUÇÕES
        while (System.currentTimeMillis() - t0 < Main.conf.getTimoutLAHC()) {
//            while (teste < 5) {
//                System.out.println("\nLAHC : " + teste);
                String[][] representacao2 = representacao.clone();
                representacao2 = mutacao.operadorMutacao(representacao2);
                int foNew = funcao_Objetivo.calcularFuncaoObjetivo(representacao2);
                //PARTE DA IMPLEMENTACAO DO HILL CIMBLING
                result = new Result(iteracao, foNew);

                if (vetor_Hill_Climbing.get(0).getResultado() > result.getResultado()) {
                    vetor_Hill_Climbing.remove(0);
                    vetor_Hill_Climbing.add(result);

                }
                imprimeLAHC();
                iteracao++;
                //RESPONSAVEL POR ACHAR A MELHOR FUNCAO OBJETIVO
                if (foNew < fOBest) {
//                    System.out.print("\nREPRESENTACAO SUBSTITUIDA\n");

                    representacao = representacao2.clone();
                    fOBest = foNew;
//                    System.out.println("FUNÇÃO OBJETIVO new = " + foNew);
                }
                teste++;
            }
        }   
        individuoDescendente = new Individuo(representacao,this.problem);
        individuoDescendente.setFuncao_Objetivo(fOBest);

//        ManipularDados md = new ManipularDados();
//        md.imprimirRepresentacao(problem, representacao);
//        System.out.println("\nFUNCAO OBJETIVO : " + fOBest);


        return individuoDescendente;
    }

    public void preencherLAHC(int limite, Result result) {
        int contador = 0;

        while (contador < limite) {
            vetor_Hill_Climbing.add(result);
            contador++;
        }
    }

    public void imprimeLAHC() {
        for (int i = 0; i < this.vetor_Hill_Climbing.size(); i++) {
//            System.out.print("[" + this.vetor_Hill_Climbing.get(i).getIteracao() + "|" + this.vetor_Hill_Climbing.get(i).getResultado() + "]");
        }
    }

    public Result retornaResult(int iteracao, int foBest) {
        Result result = new Result(iteracao, fOBest);
        return result;
    }

    public Double verificarPorcentagem() {
        Random gerador = new Random();
        DecimalFormatSymbols simb = new DecimalFormatSymbols();
        simb.setDecimalSeparator('.');
        DecimalFormat umaCasa = new DecimalFormat("#############0.0", simb);

        BigDecimal potencia = new BigDecimal(umaCasa.format(gerador.nextDouble()));
        Double result = potencia.doubleValue();
        return result;
    }
}
