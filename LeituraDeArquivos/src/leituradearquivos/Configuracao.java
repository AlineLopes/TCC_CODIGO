/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leituradearquivos;

/**
 *
 * @author aline
 */
public class Configuracao {

     
    int geracoes;     
    int tamPopulacao;//mu     
    int tamanhoLAHC;
    int lambda; 
    double tMutacao = 1.0;
    double tRefinamento;
    int timoutLAHC;
    int replicacao;
    int numReplicacao = 10;
    int timoutES = 1800000;//30 minutos
    String dados, instancia, parametros;


    String arquivoVigente;

//    public void experimentos(int tipo) {
//        switch (tipo) {
//            case 1:
//                this.geracoes = 1000;
//                this.tamPopulacao = 20;//mu
//                this.tamanhoLAHC = 25;
//                this.lambda = 5;
//                this.tMutacao = 0.8;
//                this.tRefinamento = 0.3;
//                this.timoutLAHC = 1000; // depois 5 seg
//                break;
//            case 2:
//                this.geracoes = 1000;
//                this.tamPopulacao = 35;//mu
//                this.tamanhoLAHC = 25;
//                this.lambda = 5;
//                this.tMutacao = 1.0;
//                this.tRefinamento = 0.3;
//                this.timoutLAHC = 1000; // depois 5 seg
//                break;
//            case 3:
//                this.geracoes = 1000;
//                this.tamPopulacao = 50;//mu
//                this.tamanhoLAHC = 25;
//                this.lambda = 5;
//                this.tMutacao = 1;
//                this.tRefinamento = 0.4;
//                this.timoutLAHC = 1000; // depois 5 seg
//                break;
//            case 4:
//                this.geracoes = 100;
//                this.tamPopulacao = 20;//mu
//                this.tamanhoLAHC = 25;
//                this.lambda = 5;
//                this.tMutacao = 1.0;
//                this.tRefinamento = 0.3;
//                this.timoutLAHC = 1000; // depois 5 seg
//                break;
//            case 5:
//                this.geracoes = 100;
//                this.tamPopulacao = 35;//mu
//                this.tamanhoLAHC = 20;
//                this.lambda = 5;
//                this.tMutacao = 0.8;
//                this.tRefinamento = 0.3;
//                this.timoutLAHC = 1000; // depois 5 seg
//                break;
//            case 6:
//                this.geracoes = 100;
//                this.tamPopulacao = 50;//mu
//                this.tamanhoLAHC = 15;
//                this.lambda = 5;
//                this.tMutacao = 0.8;
//                this.tRefinamento = 0.3;
//                this.timoutLAHC = 1000; // depois 5 seg
//                break;
//
//            case 7:
//                this.geracoes = 1000;
//                this.tamPopulacao = 20;//mu
//                this.tamanhoLAHC = 15;
//                this.lambda = 5;
//                this.tMutacao = 1.0;
//                this.tRefinamento = 0.3;
//                this.timoutLAHC = 5000; // depois 5 seg
//                break;
//            case 8:
//                this.geracoes = 100;
//                this.tamPopulacao = 30;//mu
//                this.tamanhoLAHC = 25;
//                this.lambda = 5;
//                this.tMutacao = 1.0;
//                this.tRefinamento = 0.5;
//                this.timoutLAHC = 5000; // depois 5 seg
//                break;
//            case 9:
//                this.geracoes = 100;
//                this.tamPopulacao = 50;//mu
//                this.tamanhoLAHC = 20;
//                this.lambda = 7;
//                this.tMutacao = 1.0;
//                this.tRefinamento = 0.3;
//                this.timoutLAHC = 3000; // depois 5 seg
//                break;
//
//        }
//
//    }

    public String getArquivoVigente() {
        return arquivoVigente;
    }

    public void setArquivoVigente(String arquivoVigente) {
        this.arquivoVigente = arquivoVigente;
    }

    public int getTimoutLAHC() {
        return timoutLAHC;
    }

    public void setTimoutLAHC(int timoutLAHC) {
        this.timoutLAHC = timoutLAHC;
    }

    public int getLambda() {
        return lambda;
    }

    public void setLambda(int lambda) {
        this.lambda = lambda;
    }

    public double gettMutacao() {
        return tMutacao;
    }

    public void settMutacao(double tMutacao) {
        this.tMutacao = tMutacao;
    }

    public double gettRefinamento() {
        return tRefinamento;
    }

    public void settRefinamento(double tRefinamento) {
        this.tRefinamento = tRefinamento;
    }

    public int getTamanhoLAHC() {
        return tamanhoLAHC;
    }

    public void setTamanhoLAHC(int tamanhoLAHC) {
        this.tamanhoLAHC = tamanhoLAHC;
    }

    public int getGeracoes() {
        return geracoes;
    }

    public void setGeracoes(int geracoes) {
        this.geracoes = geracoes;
    }

    public int getTamPopulacao() {
        return tamPopulacao;
    }

    public void setTamPopulacao(int tamPopulacao) {
        this.tamPopulacao = tamPopulacao;
    }

    public int getNumReplicacao() {
        return numReplicacao;
    }

    public void setNumReplicacao(int replicacao) {
        this.numReplicacao = replicacao;
    }
    public int getTimoutES() {
        return timoutES;
    }

    public void setTimoutES(int timoutES) {
        this.timoutES = timoutES;
    }


    public int getReplicacao() {
        return replicacao;
    }

    public void setReplicacao(int replicacao) {
        this.replicacao = replicacao;
    }

    public String getDados() {
        return dados;
    }

    public void setDados(String dados) {
        this.dados = dados;
    }

    public String getInstancia() {
        return instancia;
    }

    public void setInstancia(String instancia) {
        this.instancia = instancia;
    }

    public String getParametros() {
        return parametros;
    }

    public void setParametros(String parametros) {
        this.parametros = parametros;
    }
    
    
}
