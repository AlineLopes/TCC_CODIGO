/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leituradearquivos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Timer;
import java.util.TimerTask;
import jdk.nashorn.internal.ir.BreakNode;

/**
 *
 * @author aline
 */
public class ES {

    String[][] representacao;
    int tamPopulacao = Main.conf.getTamPopulacao(), week, geracoes = Main.conf.getGeracoes(), lambda = Main.conf.getLambda();
    Problem problem;
    Individuo individuo, melhorSolucao, individuoFilho;
    ArrayList<Individuo> vetorPopulacao = new ArrayList<Individuo>();
    ArrayList<Individuo> vetorDescendentes = new ArrayList<Individuo>();
    String encerrado = "Não";
    boolean terminou = false;

//    ArrayList<Individuo> melhorDasGeracoes = new ArrayList<Individuo>();
    String info = "";
    long total;

    public ES(Problem problem) {
        this.problem = problem;
    }

    public void estruturaES() throws CloneNotSupportedException, ParseException, IOException {

        Result result;
        int contInicial = 0, contPai = 0, contGeracoes = 0, numDescendente = 0;
        Individuo individuoDescedenteLAHC;
        ManipularDados manipularDadosImpri = new ManipularDados();

        //AVALIAR POPULACAO INICIAL
        Funcao_Objetivo funcao_Objetivo = new Funcao_Objetivo(this.problem.employee.length, this.problem);
        long t0 = System.currentTimeMillis();

        //POPULACAO INICIAL
        while (contInicial < Main.conf.getTamPopulacao()) {
            //GERANDO INDIVIDUO ALEATORIAMENTE
            ManipularDados manipularDados = new ManipularDados();

            //CARREGAR REPRESENTACAO
            representacao = manipularDados.construirMatriz(problem);

            //AVALIAR INDIVIDUO DA POPULACAO INICIAL
            individuo = new Individuo(representacao, problem);
            individuo.setFuncao_Objetivo(funcao_Objetivo.calcularFuncaoObjetivo(representacao));

            //ADICIONAR NO VETOR POPULACAO
            vetorPopulacao.add(individuo);

            contInicial++;

        }
//        representacao = carregarRepresentacao();
//        //AVALIAR POPULACAO INICIAL
//        Funcao_Objetivo funcao_Objetivo = new Funcao_Objetivo(this.week, problem.employee.length, problem);
//
//        individuo = new Individuo(representacao);
//        individuo.setFuncao_Objetivo(funcao_Objetivo.calcularFuncaoObjetivo(representacao));

        //MELHOR SOLUÇÃO INICIADA COM A POPULAÇÃO INICIAL
        Collections.sort(vetorPopulacao);
//        System.out.println(problem.vetorScheduling_Period.size()+"|"+problem.getEmployee().length);
        this.melhorSolucao = (Individuo) vetorPopulacao.get(0).clone();
//        manipularDadosImpri.imprimirRepresentacao(problem, this.melhorSolucao.getSolucao());
//        salvarPenalizacoes(melhorSolucao);
        long t3 = System.currentTimeMillis();
        while (contGeracoes < this.geracoes && !terminou) {//GERAÇÕES
            long t1 = System.currentTimeMillis();
            System.out.println("\nEntrou em Gerações: ");

//            System.out.println("\nNumGeracao: " + contGeracoes);
//            System.out.print(Main.conf.getArquivoVigente() + "," + Main.conf.getDados() + "GerCorrentes: " + contGeracoes + ",");
            info += Main.conf.getArquivoVigente() + "," + contGeracoes + "," + Main.conf.getDados();
            while (contPai < tamPopulacao && !terminou) {
                System.out.println("\nEntrou eno Pai: ");
//                System.out.println("\nPai número: " + numDescendente);
                while (numDescendente < lambda && !terminou) {
                    System.out.println("\nEntrou em Descendente: ");
                    terminou = System.currentTimeMillis() - t3 >= 60000;
                    ManipularDados md = new ManipularDados();

//                    System.out.println("\nDescendentes Numero: " + numDescendente);
                    //CRIAR LAMBDA DESCENDENTES
                    individuoFilho = (Individuo) vetorPopulacao.get(contPai).clone();
//                    vetorDescendentes.add((Individuo)vetorPopulacao.get(contPai));
//                    System.out.println("Filho 1");
//                    md.imprimirRepresentacao(problem, individuoFilho.getSolucao());
                    //APLICAR MUTACAO
                    System.out.println("\nMutação: ");
                    Mutacao mutacao = new Mutacao(problem);
                    individuoFilho.setSolucao(mutacao.operadorMutacao(individuoFilho.getSolucao()));
//                    vetorDescendentes.get(numDescendente).setSolucao(mutacao.operadorMutacao(vetorPopulacao.get(contPai).getSolucao()));

                    //AVALIAR DESCENDENTE
                    individuoFilho.setFuncao_Objetivo(funcao_Objetivo.calcularFuncaoObjetivo(individuoFilho.getSolucao()));
//                    vetorDescendentes.get(numDescendente).setFuncao_Objetivo(funcao_Objetivo.calcularFuncaoObjetivo(vetorDescendentes.get(numDescendente).getSolucao()));
                    System.out.println("\nAvaliou Mutação \n Iniciou a BL ");

                    //INICIA LHC - REFINAMENTO - BUSCA LOCAL
                    Late_Acceptance_Hill_Clibing lAHC = new Late_Acceptance_Hill_Clibing(individuoFilho.getFuncao_Objetivo(), Main.conf.getTamanhoLAHC(), problem);
                    individuoDescedenteLAHC = lAHC.lAHC(individuoFilho.getSolucao());
                    //ADICIONA O DESCENDENTE REFINADO EM UM VETOR
                    individuoDescedenteLAHC.setFuncao_Objetivo(funcao_Objetivo.calcularFuncaoObjetivo(individuoDescedenteLAHC.getSolucao()));
                    System.out.println("\nFim BL: ");

                    vetorDescendentes.add(individuoDescedenteLAHC);
//                    vetorDescendentes.add(individuoFilho);
//                    System.out.println("Descendente Filho 1");
//                    md.imprimirRepresentacao(problem, individuoDescedenteLAHC.getSolucao());
                    numDescendente++;
                    System.out.println("\nSaiDescendente: " + (System.currentTimeMillis() - t3));

                }

                contPai++;
                numDescendente = 0;
                System.out.println("\nSaiPai: " + (System.currentTimeMillis() - t3));

            }
            contPai = 0;

            //MERGE ENTRE PAIS E DESCENDENTES
            vetorPopulacao.addAll(vetorDescendentes);
//            Individuo ind = vetorPopulacao.get(0);
//            for (int i = 1; i < vetorPopulacao.size(); i++) {
//                if (vetorPopulacao.get(i).getFuncao_Objetivo() < ind.getFuncao_Objetivo()) {
//                    ind = (Individuo) vetorPopulacao.get(i).clone();
//                }
//            }

            //ORDENAR SOLUÇÕES
            Collections.sort(vetorPopulacao);

            //CORTAR POPULACAO
            vetorPopulacao.subList(tamPopulacao, vetorPopulacao.size()).clear();

            //ATUALIZAR A MELHOR SOLUÇÃO
            if (melhorSolucao.getFuncao_Objetivo() > vetorPopulacao.get(0).getFuncao_Objetivo()) {
//                int fo = funcao_Objetivo.calcularFuncaoObjetivo(melhorSolucao.getSolucao());
//                int fo3 = funcao_Objetivo.calcularFuncaoObjetivo(melhorSolucao.getSolucao());
//                manipularDadosImpri.imprimirRepresentacao(problem, melhorSolucao.getSolucao());
//                salvarPenalizacoes(melhorSolucao);

                this.melhorSolucao = (Individuo) vetorPopulacao.get(0).clone();
//                melhorDasGeracoes.add((Individuo) melhorSolucao.clone());

//                System.out.println("\n\n\n\n Populacao \n");
//                salvarPenalizacoes(vetorPopulacao.get(0).getSolucao());
//                System.out.println("\n Populacao FO calculado novamente: " + funcao_Objetivo.calcularFuncaoObjetivo(vetorPopulacao.get(0).getSolucao()) + "\n");
//                for (int i = 0; i < 28; i++) {
//                    for (int j = 0; j < problem.employee.length; j++) {
//                        if (!melhorSolucao.getSolucao()[i][j].equals(vetorPopulacao.get(0).getSolucao()[i][j])) {
//                            int fo = funcao_Objetivo.calcularFuncaoObjetivo(melhorSolucao.getSolucao());
//                            int fo2 = funcao_Objetivo.calcularFuncaoObjetivo(vetorPopulacao.get(0).getSolucao());
//                            System.out.println("fo': "+fo+" f02: "+fo+"Deus tende misericordia!");
//                            System.exit(0);
//                        }
//                    }
//                }
//                melhorSolucao.setFuncao_Objetivo(funcao_Objetivo.calcularFuncaoObjetivo(melhorSolucao.getSolucao()));
//                System.out.println("\n\n\n\nMelhor Solucao: \n");
//                salvarPenalizacoes(melhorSolucao.getSolucao());
//                System.out.println("\n Melhor Solucao FO calculado novamente: " + funcao_Objetivo.calcularFuncaoObjetivo(melhorSolucao.getSolucao()) + "\n");
            }
//            System.out.println("FO: " + this.melhorSolucao.getFuncao_Objetivo());
//            System.out.print("FO: " + this.melhorSolucao.getFuncao_Objetivo() + ",Temp" + (System.currentTimeMillis() - t1) + "\n");
            info += "," + this.melhorSolucao.getFuncao_Objetivo() + "," + (System.currentTimeMillis() - t1) + "\n";
            contGeracoes++;
//            if (System.currentTimeMillis() - t0 > Mainconf.getTimoutES()) {
//                total = System.currentTimeMillis() - t0;
//                break;
//            }
            if (System.currentTimeMillis() - t3 >= 600000) {
                encerrado = "Sim";
                break;
            }
            System.out.println("\nFim do laço Geração: " + (System.currentTimeMillis() - t3));
        }
        System.out.println("\nFinaliza Gerações: " + (System.currentTimeMillis() - t3));

        total = System.currentTimeMillis() - t0;
//        Collections.sort(melhorDasGeracoes);
//        manipularDadosImpri.imprimirRepresentacao(problem, melhorSolucao.getSolucao());
        System.out.println(Main.conf.getParametros() + "," + this.melhorSolucao.getFuncao_Objetivo() + "," + total + "," + encerrado + "NumGeracoes: " + contGeracoes + "\n");
        salvarResultado(Main.conf, total, contGeracoes);
//        salvarResultadoAvaliador();
//        salvarPenalizacoes(melhorSolucao);

    }

    public void salvarResultado(Configuracao conf, long total, int contGeracoes) {
        try {
            // Serialize to a file  
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("/home/aline/Resultados.txt", true)));
            out.print(conf.getParametros() + "," + this.melhorSolucao.getFuncao_Objetivo() + "," + total + "," + encerrado + "," + contGeracoes + "\n");
            out.close();

//            ObjectOutput out = new ObjectOutputStream(new FileOutputStream("ResultadosES.txt"));
//            out.writeObject(conf.getArquivoVigente() + "," + this.melhorSolucao + "\n");
//            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void salvarResultadoAvaliador() {
        try {
            // Serialize to a file   
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ResultadosAvaliador.txt", true)));

            String conteudo = "";
            int cont = 0;
            String[][] representacao2 = this.melhorSolucao.getSolucao();

//            Funcao_Objetivo fo2 = new Funcao_Objetivo(problem.employee.length, problem);
//            this.melhorSolucao.setFuncao_Objetivo(fo2.calcularFuncaoObjetivo(this.melhorDasGeracoes.get(0).getSolucao()));
            for (int i = 0; i < problem.vetorScheduling_Period.size(); i++) {
                Arrays.sort(problem.employee);
                for (int j = 0; j < problem.employee.length; j++) {
                    Semana semana = (Semana) problem.vetorScheduling_Period.get(i);
                    String teste = representacao2[i][j];
                    if (!teste.equals("-")) {
                        conteudo += "\n" + semana.date + ", " + problem.employee[j].id + ", " + representacao2[i][j] + ";";
                        cont++;

                    }
                }

            }

            out.println("////////////////////////////////////////////////////////////////////");
            out.println("SOLUTION = " + problem.getScheduling_Period().getId() + ";");
            out.println("////////////////////////////////////////////////////////////////////");
            out.println("Aline, " + this.melhorSolucao.getFuncao_Objetivo() + ";\n");
            out.println("////////////////////////////////////////////////////////////////////");
            out.println("ASSIGNMENTS = " + cont + ";");
            out.println("////////////////////////////////////////////////////////////////////");
            out.print("ASSIGNMENTS = " + cont + ";");
            out.print(conteudo);

//            out.print("Melhor FO: " + this.melhorSolucao.getFuncao_Objetivo() + ",Tempo total: " + total + "\n" + info);
            out.close();

//            ObjectOutput out = new ObjectOutputStream(new FileOutputStream("ResultadosES.txt"));
//            out.writeObject(conf.getArquivoVigente() + "," + this.melhorSolucao + "\n");
//            out.close();
        } catch (IOException e) {
        }
    }

    public void salvarPenalizacoes(Individuo solucao) {
//        int foCalcula = 0;
        try {
            // Serialize to a file   
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("Penalizacoes.txt", true)));
            Arrays.sort(problem.employee);
            Funcao_Objetivo fo = new Funcao_Objetivo(problem.employee.length, problem);
//            foCalcula = fo.calcularFuncaoObjetivo(this.melhorSolucao.getSolucao());
            String[][] representacao2 = fo.salvarFuncaoObjetivo(solucao.getSolucao());
            out.print("FO: " + solucao.getFuncao_Objetivo());
            for (int i = 0; i < problem.employee.length; i++) {
                out.print("\n--------\nFuncionario= " + problem.employee[i].getId() + "\n");
                for (int j = 0; j < 19; j++) {
                    if (representacao2[i][j] != null) {
                        out.print("\n" + representacao2[i][j]);
                    }
                }

            }

//            out.print("Melhor FO: " + this.melhorSolucao.getFuncao_Objetivo() + ",Tempo total: " + total + "\n" + info);
            out.close();

//            ObjectOutput out = new ObjectOutputStream(new FileOutputStream("ResultadosES.txt"));
//            out.writeObject(conf.getArquivoVigente() + "," + this.melhorSolucao + "\n");
//            out.close();
        } catch (IOException e) {
        }
    }

    public void imprimirVetorDescendentes(ArrayList<Individuo> vetor) {

    }

    public String[][] carregarRepresentacao() {
        String[][] representacao = null;
        try {
            // Deserialize from a file   
            File file = new File("representacao.txt");
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
            // Deserialize the object   
            representacao = (String[][]) in.readObject();
            in.close();
        } catch (ClassNotFoundException e) {
        } catch (IOException e) {
        }
        return representacao;
    }

}
