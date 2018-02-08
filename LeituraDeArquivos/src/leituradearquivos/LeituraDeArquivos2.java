/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leituradearquivos;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import static jdk.nashorn.internal.objects.NativeString.trim;

/**
 *
 * @author aline
 */
public class LeituraDeArquivos2 {

    static ArrayList dados = new ArrayList<>();
    static Boolean verificador = false;
    public static Problem problem;
//    static ArrayList vetorInstancias = new ArrayList<>();
//    static ArrayList vetorExperimentos = new ArrayList<>();

//    public static Configuracao conf = new Configuracao();

    /**
     * @param args the command line arguments
     */
    public static void executar() throws ParseException, IOException, CloneNotSupportedException {
//        String[] arquivo = new String[1];
//        arquivo[0] = ("/home/aline/NetBeansProjects/LeituraDeArquivos/Instancias de Teste/sprint01.txt");

//        arquivo[0] = ("/home/aline/NetBeansProjects/LeituraDeArquivos/Instancias de Teste/long01.txt");
//        arquivo[1] = ("/home/aline/NetBeansProjects/LeituraDeArquivos/Instancias de Teste/long_hint02.txt");
//        arquivo[2] = ("/home/aline/NetBeansProjects/LeituraDeArquivos/Instancias de Teste/medium_hint01.txt");
//        arquivo[3] = ("/home/aline/NetBeansProjects/LeituraDeArquivos/Instancias de Teste/medium_hint02.txt");
//        arquivo[4] = ("/home/aline/NetBeansProjects/LeituraDeArquivos/Instancias de Teste/medium_late02.txt");
//        arquivo[5] = ("/home/aline/NetBeansProjects/LeituraDeArquivos/Instancias de Teste/sprint01.txt");
//        arquivo[6] = ("/home/aline/NetBeansProjects/LeituraDeArquivos/Instancias de Teste/sprint_hint01.txt");
//        arquivo[7] = ("/home/aline/NetBeansProjects/LeituraDeArquivos/Instancias de Teste/sprint_late01.txt");
//        arquivo[8] = ("/home/aline/NetBeansProjects/LeituraDeArquivos/Instancias de Teste/toy1.txt");
//        for (int i = 0; i < 9; i++) {
//            vetorInstancias.add(i);
//            vetorExperimentos.add(i);
//        }
        int cont = 0, indiceArquivo = 0, contadorInstancia = 0, contadorReplicacao = 0;
//        Collections.shuffle(vetorInstancias);

//        System.out.printf("\nConteúdo do arquivo texto:\n");
        //CONTADOR DE EXPERIMENTO
//        while (contadorInstancia < vetorInstancias.size()) {
//        conf.setArquivoVigente("arquivo");
        int tipo = 0;

        try {
            FileReader arq = new FileReader(Main.conf.instancia);
            BufferedReader lerArq = new BufferedReader(arq);

            String linha = lerArq.readLine(); // lê a primeira linha
// a variável "linha" recebe o valor "null" quando o processo
// de repetição atingir o final do arquivo texto

            Scheduling_Period sp = new Scheduling_Period();
            Skill[] dadosSkills = null;
            Shift_Type[] dadosShift_Types = null;
            Contract[] dadosContracts = null;
            Pattern[] dadosPatterns = null;
            Employee[] dadosEmployees = null;
            Day_Off_Week_Cover[] dadosDay_of_Week_Covers = null;
            Date_Specific_Cover[] dadosDate_Specific_Cover = null;
            Day_Off_Request[] dadosDay_Off_Request = null;
            Day_On_Request[] dadosDay_On_Request = null;
            Shift_Off_Request[] dadosShift_Off_Request = null;
            Shift_On_Request[] dadosShift_On_Request = null;

            while (linha != null) {

                if (linha.equals("////////////////////////////////////////////////////////////////////")) {
                    cont++;
                } else if (!linha.equals("")) {
                    String iterador = null;//saber quantos dados existem na tag
                    int iteradorInt = 0;
                    if (cont >= 1) {
                        String nome = (linha.split("=")[0]).split(";")[0];

                        if (linha.split("=").length == 2) {
                            iterador = (linha.split("=")[1]).split(";")[0];
                            iteradorInt = transformaStringEmInteiro(iterador);
                        }

                        linha = lerArq.readLine();
                        linha = lerArq.readLine();
                        cont++;
                        verificador = true;

                        switch (trim(nome)) {
                            case "SCHEDULING_PERIOD":
//                                Scheduling_Period sp = new Scheduling_Period();
                                sp.setId(linha.split(",")[0]);
                                sp.setStarDate(linha.split(",")[1]);
                                sp.setEndDate((linha.split(",")[2]).split(";")[0]);
                                dados.add(sp);
                                break;
                            case "SKILLS":
                                Skill sk;
                                dadosSkills = new Skill[iteradorInt];

                                for (int i = 0; i < iteradorInt; i++) {
                                    sk = new Skill(trim((linha.split(",")[0]).split(";")[0]));
//                                    sk.setDescription((linha.split(",")[0]).split(";")[0]);
                                    dadosSkills[i] = sk;
                                    linha = lerArq.readLine();

                                }
                                dados.add(dadosSkills);
                                break;
                            case "SHIFT_TYPES":
                                Shift_Type st;
                                dadosShift_Types = new Shift_Type[iteradorInt];

                                for (int i = 0; i < iteradorInt; i++) {
                                    st = new Shift_Type();
                                    st.setId(linha.split(",")[0]);
                                    st.setDescription(linha.split(",")[1]);
                                    st.setStartTime(linha.split(",")[2]);
                                    st.setEndTime(linha.split(",")[3]);
                                    st.setNumberOfRequiredSkills(transformaStringEmInteiro(linha.split(",")[4]));
                                    Skill valor = new Skill(trim(linha.split(",")[5]).split(";")[0]);
                                    st.setRequiredSkill(valor);
                                    dadosShift_Types[i] = st;
                                    linha = lerArq.readLine();
                                }
                                dados.add(dadosShift_Types);
                                break;
                            case "CONTRACTS":
                                Contract ct;
                                dadosContracts = new Contract[iteradorInt];

                                for (int i = 0; i < iteradorInt; i++) {
                                    ct = new Contract();
                                    ct.setId(transformaStringEmInteiro(linha.split(",")[0]));
                                    ct.setDescription(linha.split(",")[1]);

                                    ct.setSingleAssignmentPerDayOn(verificaBooleano(((trim(linha.split(",")[2])).replace("(", "")).replace(")", "").split("[|]")[0]));//foda
                                    ct.setSingleAssignmentPerDayWeight(transformaStringEmInteiro(((trim(linha.split(",")[2])).replace("(", "")).replace(")", "").split("[|]")[1]));

                                    ct.setMaxNumAssignmentsOn(verificaBooleano(((trim(linha.split(",")[3])).replace("(", "")).replace(")", "").split("[|]")[0]));
                                    ct.setMaxNumAssignmentsOnWeight(transformaStringEmInteiro(((trim(linha.split(",")[3])).replace("(", "")).replace(")", "").split("[|]")[1]));
                                    ct.setMaxNumAssignmentsOnValue(transformaStringEmInteiro(((trim(linha.split(",")[3])).replace("(", "")).replace(")", "").split("[|]")[2]));//parou aqui

                                    ct.setMinNumAssignmentsOn(verificaBooleano(((trim(linha.split(",")[4])).replace("(", "")).replace(")", "").split("[|]")[0]));
                                    ct.setMinNumAssignmentsWeight(transformaStringEmInteiro(((trim(linha.split(",")[4])).replace("(", "")).replace(")", "").split("[|]")[1]));
                                    ct.setMinNumAssignmentsValue(transformaStringEmInteiro(((trim(linha.split(",")[4])).replace("(", "")).replace(")", "").split("[|]")[2]));

                                    ct.setMaxConsecutiveWorkingDaysOn(verificaBooleano(((trim(linha.split(",")[5])).replace("(", "")).replace(")", "").split("[|]")[0]));
                                    ct.setMaxConsecutiveWorkingDaysWeight(transformaStringEmInteiro(((trim(linha.split(",")[5])).replace("(", "")).replace(")", "").split("[|]")[1]));
                                    ct.setMaxConsecutiveWorkingDaysValue(transformaStringEmInteiro(((trim(linha.split(",")[5])).replace("(", "")).replace(")", "").split("[|]")[2]));

                                    ct.setMinConsecutiveWorkingDaysOn(verificaBooleano(((trim(linha.split(",")[6])).replace("(", "")).replace(")", "").split("[|]")[0]));
                                    ct.setMinConsecutiveWorkingDaysWeight(transformaStringEmInteiro(((trim(linha.split(",")[6])).replace("(", "")).replace(")", "").split("[|]")[1]));
                                    ct.setMinConsecutiveWorkingDaysValue(transformaStringEmInteiro(((trim(linha.split(",")[6])).replace("(", "")).replace(")", "").split("[|]")[2]));

                                    ct.setMaxConsecutiveFreeDaysOn(verificaBooleano(((trim(linha.split(",")[7])).replace("(", "")).replace(")", "").split("[|]")[0]));
                                    ct.setMaxConsecutiveFreeDaysWeight(transformaStringEmInteiro(((trim(linha.split(",")[7])).replace("(", "")).replace(")", "").split("[|]")[1]));
                                    ct.setMaxConsecutiveFreeDaysValue(transformaStringEmInteiro(((trim(linha.split(",")[7])).replace("(", "")).replace(")", "").split("[|]")[2]));

                                    ct.setMinConsecutiveFreeDaysOn(verificaBooleano(((trim(linha.split(",")[8])).replace("(", "")).replace(")", "").split("[|]")[0]));
                                    ct.setMinConsecutiveFreeDaysWeight(transformaStringEmInteiro(((trim(linha.split(",")[8])).replace("(", "")).replace(")", "").split("[|]")[1]));
                                    ct.setMinConsecutiveFreeDaysValue(transformaStringEmInteiro(((trim(linha.split(",")[8])).replace("(", "")).replace(")", "").split("[|]")[2]));

                                    ct.setMaxConsecutiveWorkingWeekendsOn(verificaBooleano(((trim(linha.split(",")[9])).replace("(", "")).replace(")", "").split("[|]")[0]));
                                    ct.setMaxConsecutiveWorkingWeekendsWeight(transformaStringEmInteiro(((trim(linha.split(",")[9])).replace("(", "")).replace(")", "").split("[|]")[1]));
                                    ct.setMaxConsecutiveWorkingWeekendsValue(transformaStringEmInteiro(((trim(linha.split(",")[9])).replace("(", "")).replace(")", "").split("[|]")[2]));

                                    ct.setMinConsecutiveWorkingWeekendsOn(verificaBooleano(((trim(linha.split(",")[10])).replace("(", "")).replace(")", "").split("[|]")[0]));
                                    ct.setMinConsecutiveWorkingWeekendsWeight(transformaStringEmInteiro(((trim(linha.split(",")[10])).replace("(", "")).replace(")", "").split("[|]")[1]));
                                    ct.setMinConsecutiveWorkingWeekendsValue(transformaStringEmInteiro(((trim(linha.split(",")[10])).replace("(", "")).replace(")", "").split("[|]")[2]));

                                    ct.setMaxWorkingWeekendsInFourWeeksOn(verificaBooleano(((trim(linha.split(",")[11])).replace("(", "")).replace(")", "").split("[|]")[0]));
                                    ct.setMaxWorkingWeekendsInFourWeeksWeight(transformaStringEmInteiro(((trim(linha.split(",")[11])).replace("(", "")).replace(")", "").split("[|]")[1]));
                                    ct.setMaxWorkingWeekendsInFourWeeksValue(transformaStringEmInteiro(((trim(linha.split(",")[11])).replace("(", "")).replace(")", "").split("[|]")[2]));

                                    ct.setWeekendDefinition(linha.split(",")[12]);

                                    ct.setCompleteWeekendsOn(verificaBooleano(((trim(linha.split(",")[13])).replace("(", "")).replace(")", "").split("[|]")[0]));
                                    ct.setCompleteWeekendsWeight(transformaStringEmInteiro(((trim(linha.split(",")[13])).replace("(", "")).replace(")", "").split("[|]")[1]));

                                    ct.setIdent_ShiftTypesDuringWeekendOn(verificaBooleano(((trim(linha.split(",")[14])).replace("(", "")).replace(")", "").split("[|]")[0]));
                                    ct.setIdent_ShiftTypesDuringWeekendWeight(transformaStringEmInteiro(((trim(linha.split(",")[14])).replace("(", "")).replace(")", "").split("[|]")[1]));

                                    ct.setNoNightShiftBeforeFreeWeekendOn(verificaBooleano(((trim(linha.split(",")[15])).replace("(", "")).replace(")", "").split("[|]")[0]));
                                    ct.setNoNightShiftBeforeFreeWeekendWeight(transformaStringEmInteiro(((trim(linha.split(",")[15])).replace("(", "")).replace(")", "").split("[|]")[1]));

                                    ct.setTwoFreeDaysAfterNightShiftsOn(verificaBooleano(((trim(linha.split(",")[16])).replace("(", "")).replace(")", "").split("[|]")[0]));
                                    ct.setTwoFreeDaysAfterNightShiftsWeight(transformaStringEmInteiro(((trim(linha.split(",")[16])).replace("(", "")).replace(")", "").split("[|]")[1]));

                                    ct.setAlternativeSkillCategoryOn(verificaBooleano(((trim(linha.split(",")[17])).replace("(", "")).replace(")", "").split("[|]")[0]));
                                    ct.setAlternativeSkillCategoryWeight(transformaStringEmInteiro(((trim(linha.split(",")[17])).replace("(", "")).replace(")", "").split("[|]")[1]));

                                    ct.setNumberOfUnwantedPatterns(transformaStringEmInteiro(linha.split(",")[18]));

//                                    ct.setUnwantedPatterns(transformaStringEmInteiro(trim((linha.split(",")[19])).split(" ")));
                                    if (ct.getNumberOfUnwantedPatterns() != 0) {
                                        for (int k = 0; k < trim(linha.split(",")[19]).split(";")[0].split(" ").length; ++k) {
                                            ct.unwantedPatternsId.add(transformaStringEmInteiro(trim(linha.split(",")[19]).split(";")[0].split(" ")[k]));

                                        }
                                    }
//                                    ct.setUnwantedPatternsId(transformaStringEmInteiro(trim(((linha.split(",")[19])).split(";")[0]).split(" ")[1]));

                                    dadosContracts[i] = ct;
                                    linha = lerArq.readLine();
                                }
                                dados.add(dadosContracts);
                                break;
                            case "PATTERNS":
                                Pattern pt;
                                dadosPatterns = new Pattern[iteradorInt];

                                for (int i = 0; i < iteradorInt; i++) {
                                    pt = new Pattern();
                                    pt.setId(transformaStringEmInteiro(linha.split(",")[0]));
                                    pt.setWeight(transformaStringEmInteiro(linha.split(",")[1]));
                                    pt.setNumberOfShiftTypes(transformaStringEmInteiro(trim((linha.split(",")[2])).split(" ")[0]));
//                                    pt.setShift_typeID(transformaStringEmInteiro(linha.split(",")[3]));

                                    for (int j = 1; j < trim(linha.split(",")[2]).split(";")[0].split(" ").length; ++j) {
                                        String line = trim(linha.split(",")[2]).split(";")[0].split(" ")[j];
                                        line = line.substring(1, line.length() - 1);
                                        pt.getEtapas().add(new Etapa(line.split(java.util.regex.Pattern.quote("|"))[0], (line.split(java.util.regex.Pattern.quote("|"))[1]).toLowerCase()));

                                    }

//                                    String[] shift_type = new String[pt.getNumberOfShiftTypes()];
//                                    for (int j = 0; j < pt.getNumberOfShiftTypes(); j++) {
//                                        int k = j + 1;
//                                        shift_type[j] = (trim(linha.split(",")[2]).split(";")[0]).split(" ")[k];
//                                    }
//                                    pt.setShift_typeOr(shift_type);
                                    dadosPatterns[i] = pt;
                                    linha = lerArq.readLine();
                                }
                                dados.add(dadosPatterns);
                                break;
                            case "EMPLOYEES":
                                Employee ep;
                                dadosEmployees = new Employee[iteradorInt];

                                for (int i = 0; i < iteradorInt; i++) {
                                    ep = new Employee();
                                    ep.setId(linha.split(",")[0]);
                                    ep.setName(linha.split(",")[1]);
                                    ep.setContractID(transformaStringEmInteiro(linha.split(",")[2]));
                                    ep.setNumberOfSkills(transformaStringEmInteiro(linha.split(",")[3]));

                                    String[] employee_skills = new String[ep.getNumberOfSkills()];
                                    for (int j = 0; j < ep.getNumberOfSkills(); j++) {
                                        employee_skills[j] = (trim(linha.split(",")[4]).split(";")[0]);
                                    }

                                    dadosEmployees[i] = ep;
                                    linha = lerArq.readLine();
                                }
                                Arrays.sort(dadosEmployees);
                                dados.add(dadosEmployees);
                                break;
                            case "DAY_OF_WEEK_COVER":
                                Day_Off_Week_Cover owc;
                                dadosDay_of_Week_Covers = new Day_Off_Week_Cover[iteradorInt];

                                for (int i = 0; i < iteradorInt; i++) {
                                    owc = new Day_Off_Week_Cover();
                                    owc.setDay(linha.split(",")[0]);
                                    owc.setShift_TypesID(trim(linha.split(",")[1]));
                                    owc.setPreferred(transformaStringEmInteiro((linha.split(",")[2]).split(";")[0]));

                                    dadosDay_of_Week_Covers[i] = owc;
                                    linha = lerArq.readLine();
                                }
                                dados.add(dadosDay_of_Week_Covers);
                                break;

                            case "DATE_SPECIFIC_COVER":
                                Date_Specific_Cover dsc;
                                dadosDate_Specific_Cover = new Date_Specific_Cover[iteradorInt];

                                for (int i = 0; i < iteradorInt; i++) {
                                    dsc = new Date_Specific_Cover();
                                    dsc.setDate(linha.split(",")[0]);
                                    dsc.setShift_TypesID(trim(linha.split(",")[1]));
                                    dsc.setPreferred(transformaStringEmInteiro((linha.split(",")[2]).split(";")[0]));

                                    dadosDate_Specific_Cover[i] = dsc;
                                    linha = lerArq.readLine();
                                }
                                dados.add(dadosDate_Specific_Cover);
                                break;
                            case "DAY_OFF_REQUESTS":
                                Day_Off_Request doff;
                                dadosDay_Off_Request = new Day_Off_Request[iteradorInt];

                                for (int i = 0; i < iteradorInt; i++) {
                                    doff = new Day_Off_Request();
                                    doff.setEmployeeID(trim(linha.split(",")[0]));
                                    doff.setDate(trim(linha.split(",")[1]));
                                    doff.setWeight(transformaStringEmInteiro((linha.split(",")[2]).split(";")[0]));

                                    dadosDay_Off_Request[i] = doff;
                                    linha = lerArq.readLine();
                                }
                                dados.add(dadosDay_On_Request);
                                break;
                            case "DAY_ON_REQUESTS":
                                Day_On_Request don;
                                dadosDay_On_Request = new Day_On_Request[iteradorInt];

                                for (int i = 0; i < iteradorInt; i++) {
                                    don = new Day_On_Request();
                                    don.setEmployeeID(trim(linha.split(",")[0]));
                                    don.setDate(trim(linha.split(",")[1]));
                                    don.setWeight(transformaStringEmInteiro((linha.split(",")[2]).split(";")[0]));

                                    dadosDay_On_Request[i] = don;
                                    linha = lerArq.readLine();
                                }
                                dados.add(dadosDay_On_Request);
                                break;
                            case "SHIFT_OFF_REQUESTS":
                                Shift_Off_Request sor;
                                dadosShift_Off_Request = new Shift_Off_Request[iteradorInt];

                                for (int i = 0; i < iteradorInt; i++) {
                                    sor = new Shift_Off_Request();
                                    sor.setEmployeeID(trim(linha.split(",")[0]));
                                    sor.setDate(trim(linha.split(",")[1]));
                                    sor.setShift_TypeID(trim(linha.split(",")[2]));
                                    sor.setWeight(transformaStringEmInteiro((linha.split(",")[3]).split(";")[0]));

                                    dadosShift_Off_Request[i] = sor;
                                    linha = lerArq.readLine();
                                }
                                dados.add(dadosShift_Off_Request);
                                break;

                            case "SHIFT_ON_REQUESTS":
                                Shift_On_Request son;
                                dadosShift_On_Request = new Shift_On_Request[iteradorInt];

                                for (int i = 0; i < iteradorInt; i++) {
                                    son = new Shift_On_Request();
                                    son.setEmployeeID(trim(linha.split(",")[0]));
                                    son.setDate(trim(linha.split(",")[1]));
                                    son.setShift_TypeID(trim(linha.split(",")[2]));
                                    son.setWeight(transformaStringEmInteiro((linha.split(",")[3]).split(";")[0]));

                                    dadosShift_On_Request[i] = son;
                                    linha = lerArq.readLine();
                                }
                                dados.add(dadosShift_On_Request);
                                break;
                        }

                    }
//                    else if (linha.equals("")) {
//                        if (verificador == true) {
//                            verificador = false;
////                            dados.add(dadosLinha);
//                            cont = 0;
//                        }
//
//                    }
                } else {
                    if (verificador == true) {
                        verificador = false;
//                            dados.add(dadosLinha);
                        cont = 0;
                    }

                }

                linha = lerArq.readLine(); // lê da segunda até a última linha
            }

            problem = new Problem(sp, dadosSkills, dadosShift_Types, dadosContracts, dadosPatterns, dadosEmployees, dadosDay_of_Week_Covers, dadosDate_Specific_Cover, dadosDay_Off_Request, dadosDay_On_Request, dadosShift_Off_Request, dadosShift_On_Request);

            arq.close();
        } catch (IOException e) {
//                System.err.printf("Erro na abertura do arquivo: %s.\n",                        e.getMessage());
        }

        salvarProblem();

        //REPLICACAO PARA CADA EXPERIMENTO 
        contadorReplicacao = 0;
//        while (contadorReplicacao < conf.getNumReplicacao()) {
        //EM CADA REPLICACAO EXISTE UMA NOVA ORDEM DE CONFIGURACAO
//            Collections.shuffle(vetorExperimentos);
//            conf.setReplicacao((int) contadorReplicacao);

//        int contadorExperimentos = 1;
//            while (contadorExperimentos < vetorExperimentos.size()) {
//        conf.setExperimento(1);
//        ManipularDados manipularDados = new ManipularDados();
//        manipularDados.construirMatriz(problem);
//System.out.println("indice"+indiceArquivo);
//        configuracaoDeParametros(10);
        ES es = new ES(problem);
        es.estruturaES();
//            System.out.println();
//                    System.out.println("indice" + contadorInstancia);
//        contadorExperimentos++;

//            }
//        contadorReplicacao++;
//        }
//        contadorInstancia++;
//        }
    }

    public static Boolean verificaBooleano(String texto) {
        if (!removeCaracteresEspeciais(texto).equals("1")) {
            return false;
        }
        return true;
    }

    public static String removeCaracteresEspeciais(String texto) {
        return texto.replace("/\\d/g", "");
    }

    public static int transformaStringEmInteiro(String texto) {
        int retorno = 0;
        retorno = Integer.parseInt(trim(texto));
        return retorno;
    }

    public static void salvarProblem() {
        try {
            // Serialize to a file   
            ObjectOutput out = new ObjectOutputStream(new FileOutputStream("problem.txt"));
            out.writeObject(problem);
            out.close();
        } catch (IOException e) {
        }
    }

//    public static void configuracaoDeParametros(int tipo) {
//
//        switch (tipo) {
//            case 1:
//                conf.setGeracoes(1000);
//                conf.setTamPopulacao(20);//mu
//                conf.setTamanhoLAHC(15);
//                conf.setLambda(5);
//                conf.settMutacao(0.8);
//                conf.settRefinamento(0.3);
//                conf.setTimoutLAHC(100);
//                break;
//            case 2:
//                conf.setGeracoes(1000);
//                conf.setTamPopulacao(35);//mu
//                conf.setTamanhoLAHC(25);
//                conf.setLambda(5);
//                conf.settMutacao(1.0);
//                conf.settRefinamento(0.3);
//                conf.setTimoutLAHC(1000);
//                break;
//            case 3:
//                conf.setGeracoes(1000);
//                conf.setTamPopulacao(50);//mu
//                conf.setTamanhoLAHC(25);
//                conf.setLambda(5);
//                conf.settMutacao(1.0);
//                conf.settRefinamento(0.4);
//                conf.setTimoutLAHC(1000);
//                break;
//            case 4:
//                conf.setGeracoes(100);
//                conf.setTamPopulacao(20);//mu
//                conf.setTamanhoLAHC(25);
//                conf.setLambda(5);
//                conf.settMutacao(1.0);
//                conf.settRefinamento(0.3);
//                conf.setTimoutLAHC(1000);
//                break;
//            case 5:
//                conf.setGeracoes(100);
//                conf.setTamPopulacao(35);//mu
//                conf.setTamanhoLAHC(20);
//                conf.setLambda(5);
//                conf.settMutacao(0.8);
//                conf.settRefinamento(0.3);
//                conf.setTimoutLAHC(1000);
//                break;
//            case 6:
//                conf.setGeracoes(100);
//                conf.setTamPopulacao(50);//mu
//                conf.setTamanhoLAHC(15);
//                conf.setLambda(5);
//                conf.settMutacao(0.8);
//                conf.settRefinamento(0.3);
//                conf.setTimoutLAHC(1000);
//                break;
//
//            case 7:
//                conf.setGeracoes(100);
//                conf.setTamPopulacao(20);//mu
//                conf.setTamanhoLAHC(15);
//                conf.setLambda(5);
//                conf.settMutacao(1.0);
//                conf.settRefinamento(0.3);
//                conf.setTimoutLAHC(5000);
//                break;
//            case 8:
//                conf.setGeracoes(100);
//                conf.setTamPopulacao(30);//mu
//                conf.setTamanhoLAHC(25);
//                conf.setLambda(5);
//                conf.settMutacao(1.0);
//                conf.settRefinamento(0.5);
//                conf.setTimoutLAHC(5000);
//                break;
//            case 9:
//                conf.setGeracoes(100);
//                conf.setTamPopulacao(50);//mu
//                conf.setTamanhoLAHC(20);
//                conf.setLambda(7);
//                conf.settMutacao(1.0);
//                conf.settRefinamento(0.3);
//                conf.setTimoutLAHC(3000);
//                break;
//            case 10:
//                conf.setGeracoes(1);
//                conf.setTamPopulacao(20);//mu
//                conf.setTamanhoLAHC(15);
//                conf.setLambda(5);
//                conf.settMutacao(0.8);
//                conf.settRefinamento(0.5);
//                conf.setTimoutLAHC(1000);
//                break;
//        }
//
//    }

}

//}
