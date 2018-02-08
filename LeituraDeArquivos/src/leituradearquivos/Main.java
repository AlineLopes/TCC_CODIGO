package leituradearquivos;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import leituradearquivos.Configuracao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author aline
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static Configuracao conf = new Configuracao();

    public static void main(String[] args) throws ParseException, IOException, CloneNotSupportedException {
        String[] arquivo = new String[9];
        ArrayList<Integer> vetorInstancias = new ArrayList<Integer>();

        arquivo[0] = ("/home/aline/Documents/Documents/Ufop/Estudos_TCC/novas_instancias/sprint01.txt");
        arquivo[1] = ("/home/aline/Documents/Documents/Ufop/Estudos_TCC/novas_instancias/sprint02.txt");
        arquivo[2] = ("/home/aline/Documents/Documents/Ufop/Estudos_TCC/novas_instancias/sprint_hidden01.txt");
        arquivo[3] = ("/home/aline/Documents/Documents/Ufop/Estudos_TCC/novas_instancias/sprint_hidden02.txt");
        arquivo[4] = ("/home/aline/Documents/Documents/Ufop/Estudos_TCC/novas_instancias/sprint_hidden03.txt");
        arquivo[5] = ("/home/aline/Documents/Documents/Ufop/Estudos_TCC/novas_instancias/medium01.txt");
        arquivo[6] = ("/home/aline/Documents/Documents/Ufop/Estudos_TCC/novas_instancias/medium02.txt");
        arquivo[7] = ("/home/aline/Documents/Documents/Ufop/Estudos_TCC/novas_instancias/medium03.txt");
        arquivo[8] = ("/home/aline/Documents/Documents/Ufop/Estudos_TCC/novas_instancias/sprint04.txt");

        for (int i = 0; i < arquivo.length; i++) {
            vetorInstancias.add(i);
        }

        Experimento ex = new Experimento();
//        while (!ex.isFezTodas()) {
//            ex.geraCombinacao();
//            System.out.println(ex);
//        }
//
//        System.exit(0);

        ex.geraCombinacao();
        ArrayList<double[]> comb = ex.adicionaInstancia();

        for (int rep = 0; rep < conf.numReplicacao; rep++) {
            Collections.shuffle(comb);
             for (int i = 0; i < comb.size(); i++) {
//                 for (int j = 0; j < 7; j++) {
                    
                    conf.setGeracoes((int)comb.get(i)[0]);
                    conf.setTamPopulacao((int)comb.get(i)[1]);//mu
                    conf.setLambda((int)comb.get(i)[2]);
                    conf.setTamanhoLAHC((int)comb.get(i)[3]);
                    conf.settRefinamento(comb.get(i)[4]);
                    conf.setTimoutLAHC((int)comb.get(i)[5]);
                    conf.setArquivoVigente("Arquivo" + (int)comb.get(i)[6]);
                    conf.setInstancia(arquivo[(int)comb.get(i)[6]]);
                    conf.setDados("Inst: " + (int)comb.get(i)[6] + " Rep: " + rep + " Ger: " + (int)comb.get(i)[0] + " Mu: " + (int)comb.get(i)[1] + " Lamb: " + (int)comb.get(i)[2] + " TamLahc: " + (int)comb.get(i)[3] + " BL: " + comb.get(i)[4] + " Time: " + (int)comb.get(i)[5]);
                    conf.setParametros("" + (int)comb.get(i)[6] + "," + rep + "," + (int)comb.get(i)[0] + "," + (int)comb.get(i)[1] + "," + (int)comb.get(i)[2] + "," + (int)comb.get(i)[3] + "," + comb.get(i)[4] + "," + (int)comb.get(i)[5]);
                    LeituraDeArquivos2 la2 = new LeituraDeArquivos2();
                    la2.executar(); 
//                 }
            }
        }

//        for (int rep = 0; rep < conf.numReplicacao; rep++) {
//            Collections.shuffle(vetorInstancias);
//            for (int instancia = 0; instancia < vetorInstancias.size(); instancia++) {
//                System.out.println("Inst: " + vetorInstancias.get(instancia));
//                while (!ex.isFezTodas()) {
//                    ex.geraCombinacao();
//                    conf.setArquivoVigente("Arquivo" + vetorInstancias.get(instancia));
//                    conf.setInstancia(arquivo[vetorInstancias.get(instancia)]);
//                    conf.setGeracoes(ex.getGeracao());
//                    conf.setTamPopulacao(ex.getMu());//mu
//                    conf.setLambda(ex.getLambda());
//                    conf.setTamanhoLAHC(ex.getLahc());
//                    conf.settRefinamento(ex.getBl());
//                    conf.setTimoutLAHC(ex.getTimout());
//                    conf.setDados("Inst: " + vetorInstancias.get(instancia) + " Rep: " + rep + " Ger: " + ex.getGeracao() + " Mu: " + ex.getMu() + " Lamb: " + ex.getLambda() + " TamLahc: " + ex.getLahc() + " BL: " + ex.getBl() + " Time: " + ex.getTimout());
//                    conf.setParametros("" + vetorInstancias.get(instancia) + "_" + rep + "_" + ex.getGeracao() + "_" + ex.getMu() + "_" + ex.getLambda() + "_" + ex.getLahc() + "_" + ex.getBl() + "_" + ex.getTimout());
//                    LeituraDeArquivos2 la2 = new LeituraDeArquivos2();
//                    la2.executar();
//                }
//                ex.setFezTodas(false);
//            }
//        }
    }
}
