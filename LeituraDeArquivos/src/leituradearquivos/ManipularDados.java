/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leituradearquivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author aline
 */
public class ManipularDados {

    String[][] representacao;
    ArrayList<String> demandaPorTurno;
    ArrayList alocacao = new ArrayList<>();
    ArrayList<Semana> vetorScheduling_Period = new ArrayList<Semana>();
    Semana semana;

    public String[][] construirMatriz(Problem problem) throws ParseException, FileNotFoundException, IOException, CloneNotSupportedException {
        int employees;
        int week = 0;

        //###################DIAS DA SEMANA##################
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = (Date) formatter.parse(problem.scheduling_Period.starDate);

        Date endDate = (Date) formatter.parse(problem.scheduling_Period.endDate);

        int diferencaDias = (int) ((endDate.getTime() - startDate.getTime()) / (1000 * 60 * 60 * 24));
        week = diferencaDias;

        Calendar c = Calendar.getInstance();
        c.setTime(startDate);
        int day_of_week = c.get(Calendar.DAY_OF_WEEK);

        for (int i = 0; i <= diferencaDias; i++) {
            String date = "" + c.get(Calendar.YEAR) + "-" + colocaZero(c.get(Calendar.MONTH) + 1) + "-" + colocaZero(c.get(Calendar.DAY_OF_MONTH));

            vetorScheduling_Period.add(check_Day(day_of_week, date));//quantidade de dias de periodo

            c.add(Calendar.DATE, 1);
            Date amanha = c.getTime();
//            c.setTime(amanha);

            day_of_week = c.get(Calendar.DAY_OF_WEEK);

        }

        problem.setVetorScheduling_Period(vetorScheduling_Period);//vetor do periodo de trabalho
        //###################FIM DIAS DA SEMANA##################

        employees = problem.employee.length;

        representacao = new String[vetorScheduling_Period.size()][employees];

        int contadorTurnos = 0, contTurno = 0;
        int cont = 0;//conta turnos x 7
        int verificadorPreference = 0;
        verificadorPreference = contadorDePreference(cont, problem);
//        int verificadorFolga = 0;
//        Boolean afirmadorFolga = false;

        for (int i = 0; i <= week; i++) {

            demandaPorTurno = new ArrayList<>();
//            demandaPorTurno.add("-");

            while (cont < problem.day_Off_Week_Cover.length) {
                switch (problem.getDay_Off_Week_Cover()[cont].getDay()) {
                    case "Monday":
                        while (verificadorPreference != 0) {
                            //representacao funcionario por dia de semana

                            demandaPorTurno.add(problem.getDay_Off_Week_Cover()[cont].getShift_TypesID());
                            verificadorPreference--;
                        }
                        cont++;
                        verificadorPreference = contadorDePreference(cont, problem);
                        contadorTurnos++;

                        if (contadorTurnos == problem.shift_Type.length) {
                            contadorTurnos = 0;
                            while (demandaPorTurno.size() < employees) {
                                demandaPorTurno.add("-");
                            }
                            Collections.shuffle(demandaPorTurno);

                            //demanda por turno mensal
//                        int qtd = vetorScheduling_Period.size() / demandaPorTurno.size();
//                        for (int j = 0; j < qtd; j++) {
//                            for (int k = 0; k < demandaPorTurno.size(); k++) {
//                                demandaPorTurnoAux.add(demandaPorTurno.get(k));
//
//                            }
//                        }
//                        demandaPorTurno.clear();
//                        demandaPorTurno.addAll(demandaPorTurnoAux);
//                        demandaPorTurnoAux.clear();
                            for (int k = 0; k < vetorScheduling_Period.size(); k++) {
                                Semana semanaAux = vetorScheduling_Period.get(k);
                                if (semanaAux.getWrite_out().equals("monday")) {
                                    Collections.shuffle(demandaPorTurno);
                                    for (int j = 0; j < employees; j++) {
                                        representacao[k][j] = (String) demandaPorTurno.get(contTurno);
                                        contTurno++;

                                    }//for

                                }//if
                                contTurno = 0;
                            }//for
                            demandaPorTurno.clear();
//                            demandaPorTurno.add("-");
                            contTurno = 0;

                        }//if
                        break;
                    case "Tuesday":
                        while (verificadorPreference != 0) {
                            //representacao funcionario por dia de semana

                            demandaPorTurno.add(problem.getDay_Off_Week_Cover()[cont].getShift_TypesID());
                            verificadorPreference--;
                        }
                        cont++;
                        verificadorPreference = contadorDePreference(cont, problem);
                        contadorTurnos++;
                        if (contadorTurnos == problem.shift_Type.length) {
                            contadorTurnos = 0;
                            while (demandaPorTurno.size() < employees) {
                                demandaPorTurno.add("-");
                            }
                            Collections.shuffle(demandaPorTurno);
                            for (int k = 0; k < vetorScheduling_Period.size(); k++) {
                                Semana semanaAux = vetorScheduling_Period.get(k);
                                if (semanaAux.getWrite_out().equals("tuesday")) {
                                    Collections.shuffle(demandaPorTurno);
                                    for (int j = 0; j < employees; j++) {
                                        representacao[k][j] = (String) demandaPorTurno.get(contTurno);
                                        contTurno++;

                                    }//for

                                }//if
                                contTurno = 0;
                            }//for
                            demandaPorTurno.clear();
//                            demandaPorTurno.add("-");
                            contTurno = 0;
                        }//if
                        break;
                    case "Wednesday":
                        while (verificadorPreference != 0) {
                            //representacao funcionario por dia de semana

                            demandaPorTurno.add(problem.getDay_Off_Week_Cover()[cont].getShift_TypesID());
                            verificadorPreference--;
                        }
                        cont++;
                        verificadorPreference = contadorDePreference(cont, problem);
                        contadorTurnos++;
                        if (contadorTurnos == problem.shift_Type.length) {
                            contadorTurnos = 0;
                            while (demandaPorTurno.size() < employees) {
                                demandaPorTurno.add("-");
                            }
                            Collections.shuffle(demandaPorTurno);
                            for (int k = 0; k < vetorScheduling_Period.size(); k++) {
                                Semana semanaAux = vetorScheduling_Period.get(k);
                                if (semanaAux.getWrite_out().equals("wednesday")) {
                                    Collections.shuffle(demandaPorTurno);
                                    for (int j = 0; j < employees; j++) {
                                        representacao[k][j] = (String) demandaPorTurno.get(contTurno);
                                        contTurno++;

                                    }//for

                                }//if
                                contTurno = 0;
                            }//for
                            demandaPorTurno.clear();
//                            demandaPorTurno.add("-");
                            contTurno = 0;
                        }//if
                        break;
                    case "Thursday":
                        while (verificadorPreference != 0) {
                            //representacao funcionario por dia de semana

                            demandaPorTurno.add(problem.getDay_Off_Week_Cover()[cont].getShift_TypesID());
                            verificadorPreference--;
                        }
                        cont++;
                        verificadorPreference = contadorDePreference(cont, problem);
                        contadorTurnos++;
                        if (contadorTurnos == problem.shift_Type.length) {
                            contadorTurnos = 0;
                            while (demandaPorTurno.size() < employees) {
                                demandaPorTurno.add("-");
                            }
                            Collections.shuffle(demandaPorTurno);
                            for (int k = 0; k < vetorScheduling_Period.size(); k++) {
                                Semana semanaAux = vetorScheduling_Period.get(k);
                                if (semanaAux.getWrite_out().equals("thursday")) {
                                    Collections.shuffle(demandaPorTurno);
                                    for (int j = 0; j < employees; j++) {
                                        representacao[k][j] = (String) demandaPorTurno.get(contTurno);
                                        contTurno++;

                                    }//for

                                }//if
                                contTurno = 0;
                            }//for
                            demandaPorTurno.clear();
//                            demandaPorTurno.add("-");
                            contTurno = 0;
                        }//if
                        break;
                    case "Friday":
                        while (verificadorPreference != 0) {
                            //representacao funcionario por dia de semana

                            demandaPorTurno.add(problem.getDay_Off_Week_Cover()[cont].getShift_TypesID());
                            verificadorPreference--;
                        }
                        cont++;
                        verificadorPreference = contadorDePreference(cont, problem);
                        contadorTurnos++;
                        if (contadorTurnos == problem.shift_Type.length) {
                            contadorTurnos = 0;
                            while (demandaPorTurno.size() < employees) {
                                demandaPorTurno.add("-");
                            }
                            Collections.shuffle(demandaPorTurno);
                            for (int k = 0; k < vetorScheduling_Period.size(); k++) {
                                Semana semanaAux = vetorScheduling_Period.get(k);
                                if (semanaAux.getWrite_out().equals("friday")) {
                                    Collections.shuffle(demandaPorTurno);
                                    for (int j = 0; j < employees; j++) {
                                        representacao[k][j] = (String) demandaPorTurno.get(contTurno);
                                        contTurno++;

                                    }//for

                                }//if
                                contTurno = 0;
                            }//for
                            demandaPorTurno.clear();
//                            demandaPorTurno.add("-");
                            contTurno = 0;
                        }//if
                        break;
                    case "Saturday":
                        while (verificadorPreference != 0) {
                            //representacao funcionario por dia de semana

                            demandaPorTurno.add(problem.getDay_Off_Week_Cover()[cont].getShift_TypesID());
                            verificadorPreference--;
                        }
                        cont++;
                        verificadorPreference = contadorDePreference(cont, problem);
                        contadorTurnos++;
                        if (contadorTurnos == problem.shift_Type.length) {
                            contadorTurnos = 0;
                            while (demandaPorTurno.size() < employees) {
                                demandaPorTurno.add("-");
                            }
                            Collections.shuffle(demandaPorTurno);
                            for (int k = 0; k < vetorScheduling_Period.size(); k++) {
                                Semana semanaAux = vetorScheduling_Period.get(k);
                                if (semanaAux.getWrite_out().equals("saturday")) {
                                    Collections.shuffle(demandaPorTurno);
                                    for (int j = 0; j < employees; j++) {
                                        representacao[k][j] = (String) demandaPorTurno.get(contTurno);
                                        contTurno++;

                                    }//for

                                }//if
                                contTurno = 0;
                            }//for
                            demandaPorTurno.clear();
//                            demandaPorTurno.add("-");
                            contTurno = 0;
                        }//if
                        break;
                    case "Sunday":
                        while (verificadorPreference != 0) {
                            //representacao funcionario por dia de semana

                            demandaPorTurno.add(problem.getDay_Off_Week_Cover()[cont].getShift_TypesID());
                            verificadorPreference--;
                        }
                        cont++;
                        verificadorPreference = contadorDePreference(cont, problem);
                        contadorTurnos++;
                        if (contadorTurnos == problem.shift_Type.length) {
                            contadorTurnos = 0;
                            while (demandaPorTurno.size() < employees) {
                                demandaPorTurno.add("-");
                            }
                            Collections.shuffle(demandaPorTurno);
                            for (int k = 0; k < vetorScheduling_Period.size(); k++) {
                                Semana semanaAux = vetorScheduling_Period.get(k);
                                if (semanaAux.getWrite_out().equals("sunday")) {
                                    Collections.shuffle(demandaPorTurno);
                                    for (int j = 0; j < employees; j++) {
                                        representacao[k][j] = (String) demandaPorTurno.get(contTurno);
                                        contTurno++;

                                    }//for
                                }//if
                                contTurno = 0;
                            }//for
                            demandaPorTurno.clear();
//                            demandaPorTurno.add("-");
                            contTurno = 0;
                        }//if
                        break;
                }
            }

//            for (int j = 1; j < employees; j++) {
//
//                if (verificadorPreference != 0) {
//                    //representacao funcionario por dia de semana
//
//                    demandaPorTurno.add(problem.getDay_Off_Week_Cover()[cont].getShift_TypesID());
//                    verificadorPreference--;
//                } else {
//                    cont++;
//                    j--;
//                    verificadorPreference = contadorDePreference(cont, problem);
//                }
//                if (j == (employees - 1)) {
//                    Collections.shuffle(demandaPorTurno);
//                    for (int k = 0; k < demandaPorTurno.size(); k++) {
//                        alocacao.add(demandaPorTurno.get(k));
//
//                    }
////                    representacao.add(demandaPorTurno);
//                }
//            }
        }
//        int contAlocacao = 0;
//        for (int i = 0; i <= week; i++) {
//            for (int j = 0; j < employees; j++) {
//                representacao[i][j] = (String) alocacao.get(contAlocacao);
//                contAlocacao++;
//
//            }
//        }

//        salvarRepresentacao();
//        
//        ES es = new ES(problem, week);
//        es.estruturaES();
//        
//        //VETOR COM 15 POSIÇÕES
//        int execucoes = 0, limite = 15;
//
//        System.out.println("EXECUÇÃO NÚMERO " + execucoes + "\n");
//        int iteracao = 1;
//
//        ArrayList<Result> vetor_Hill_Climbing = new ArrayList<Result>();
//        
//        Funcao_Objetivo funcao_Objetivo = new Funcao_Objetivo(week, employees, problem);
//        Mutacao mutacao = new Mutacao(problem);
//
//        int foBest = funcao_Objetivo.calcularFuncaoObjetivo(representacao);
//
//        //INICIA LHC - REFINAMENTO - BUSCA LOCAL
//        Late_Acceptance_Hill_Clibing lAHC = new Late_Acceptance_Hill_Clibing(foBest, limite);
//        //INICIAR RESULT    
//        Result result = lAHC.retornaResult(iteracao, foBest);
//        
//         //INICIAR O LAHC
//         lAHC.preencherLAHC(limite, result);
//
//        //IMPRIMIR O LAHC
//        lAHC.imprimeLAHC();
//
//        
////        int seta = 1;
//
//        int teste = 1;
//
//        while (execucoes < 5) {
//
//            System.out.println("FUNÇÃO OBJETIVO = " + foBest);
////            imprimirRepresentacao(problem, representacao);
//
//            long t0 = System.currentTimeMillis();
//            //IMPLEMENTANDO O HILL CLIMBING
//
//            //DEFINIR EXECUÇÕES
//            while (System.currentTimeMillis() - t0 < 1000000) {
////            while (teste < 15) {
//
//                String[][] representacao2 = representacao.clone();
//                representacao2 = mutacao.operadorMutacao(representacao2);
////            System.out.println("_________________________________________________________");
//                int foNew = funcao_Objetivo.calcularFuncaoObjetivo(representacao2);
//
//                //PARTE DA IMPLEMENTACAO DO HILL CIMBLING
//                result = new Result(iteracao, foNew);
////                result.setIteracao(iteracao);
////                result.setResultado(foNew);
////                if (vetor_Hill_Climbing.size() == 15) {
//                if (vetor_Hill_Climbing.get(0).getResultado() > result.getResultado()) {
//                    vetor_Hill_Climbing.remove(0);
//                    vetor_Hill_Climbing.add(result);
//
//                }
////                } else {
////                    vetor_Hill_Climbing.add(result);
////                }
//
////                if (vetor_Hill_Climbing.size() == 15 && seta == 14) {
//                for (int i = 0; i < vetor_Hill_Climbing.size(); i++) {
//                    System.out.print("[" + vetor_Hill_Climbing.get(i).getIteracao() + "|" + vetor_Hill_Climbing.get(i).getResultado() + "]");
//                }
////                    System.out.println("tam: 15 - seta: 14");
////                seta = -1;
////                } 
//                iteracao++;
////                seta++;
//
////            imprimirRepresentacao(problem, representacao2);
//                //RESPONSAVEL POR ACHAR A MELHOR FUNCAO OBJETIVO
//                if (foNew <= foBest) {
//                    representacao = representacao2.clone();
//                    foBest = foNew;
//                    System.out.println("FUNÇÃO OBJETIVO new = " + foNew);
////                    imprimirRepresentacao(problem, representacao);
//                }
////                teste++;
//
//            }
//            execucoes++;
////            teste = 0;
//        }
//
//        imprimirRepresentacao(problem, representacao);
        return representacao;

    }

    private int contadorDePreference(int cont, Problem problem) {
        if (cont != problem.day_Off_Week_Cover.length) {
            int verificadorPreference = problem.getDay_Off_Week_Cover()[cont].preferred;
            return verificadorPreference;
        }
        return 0;
    }

    public void salvarRepresentacao() {
        try {
            // Serialize to a file   
            ObjectOutput out = new ObjectOutputStream(new FileOutputStream("representacao.txt"));
            out.writeObject(representacao);
            out.close();
        } catch (IOException e) {
        }
    }

//    public String[][] carregarRepresentacao() {
//        String[][] representacaoIni = null;
//        try {
//            // Deserialize from a file   
//            File file = new File("representacao.txt");
//            ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
//            // Deserialize the object   
//            representacaoIni = (String[][]) in.readObject();
//            in.close();
//        } catch (ClassNotFoundException e) {
//        } catch (IOException e) {
//        }
//        return representacaoIni;
//    }
    public Semana check_Day(int dayofweek, String date) {
        Semana semana = null;
        switch (dayofweek) {
            case 1:
                semana = new Semana(1, "sunday", date);
                break;
            case 2:
                semana = new Semana(2, "monday", date);
                break;
            case 3:
                semana = new Semana(3, "tuesday", date);
                break;
            case 4:
                semana = new Semana(4, "wednesday", date);
                break;
            case 5:
                semana = new Semana(5, "thursday", date);
                break;
            case 6:
                semana = new Semana(6, "friday", date);
                break;
            case 7:
                semana = new Semana(7, "saturday", date);
                break;
        }
        return semana;
    }

    public void imprimirRepresentacao(Problem prob, String[][] rep) {
        Boolean indice = true;
        System.out.print("\n");

        for (int j = 0; j < prob.vetorScheduling_Period.size(); j++) {
            if (j == 0) {
                System.out.print("   ");
            }
            Semana semanaAux = (Semana) prob.vetorScheduling_Period.get(j);
            String letra = (semanaAux.write_out).toString().substring(0, 1);
            System.out.print(" " + letra.toUpperCase());
            if (j == prob.vetorScheduling_Period.size() - 1) {
                System.out.print("\n");
            }

        }
        for (int i = 0; i < prob.employee.length; i++) {
//            if (indice) {
//                System.out.print("  |");
//                indice = false;
//            } else {
            System.out.print("F" + (i) + "|");
//            }
            for (int j = 0; j < prob.vetorScheduling_Period.size(); j++) {

                try {
                    System.out.print(" " + rep[j][i]);
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("aqui");
                }

            }

            System.out.println(" |");

        }
    }

    public String colocaZero(int month) {
        String monthS = "";
        if (month == 1 || month == 2 || month == 3 || month == 4 || month == 5 || month == 6 || month == 7 || month == 8 || month == 9) {
            monthS = "0" + month;
        } else {
            monthS = "" + month;
        }
        return monthS;
    }
}
