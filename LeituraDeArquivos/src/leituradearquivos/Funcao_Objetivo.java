/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leituradearquivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import static jdk.nashorn.internal.objects.NativeString.trim;

/**
 *
 * @author aline
 */
public class Funcao_Objetivo {

    String[][] representacao;
    String[][] penalizacao;
    int week, employees;
    Problem problem;
    int FOMaxNumAssignments, FOMinNumAssignments, FOMaxConsecutiveWorkingDays, FOMinConsecutiveWorkingDays, FOMaxConsecutiveFreeDays, FOMinConsecutiveFreeDays, FOIdent_ShiftTypesDuringWeekend, FONoNightShiftBeforeFreeWeekend, FOMaxConsecutiveWorkingWeekends, FOMinConsecutiveWorkingWeekends, FOMaxWorkingWeekendsInFourWeeks, FOCompleteWeekends, FOTwoFreeDaysAfterNightShifts, FOAlternativeSkillCategory, FOUnwantedPatterns;
    Contract[] contract;
    ArrayList weekend = new ArrayList<>();

    Funcao_Objetivo(int employees, Problem problem) {
//        this.week = week;
        this.employees = employees;
        this.problem = problem;
    }

//    public void main(){
//        carregarProblem();
//    }
    public int calcularFuncaoObjetivo(String[][] representacao2) {
        penalizacao = new String[problem.employee.length][19];
        int fo = 0;
        this.representacao = representacao2.clone();
//        representacao=null;
        contract = problem.getContract();

        for (int i = 0; i < problem.employee.length; i++) {
            for (int j = 0; j < problem.contract.length; j++) {
                if (contract[j].getId() == problem.employee[i].getContractID()) {
                    if (contract[j].getMaxNumAssignmentsOn()) {
                        FOMaxNumAssignments = maxNumAssignments(Integer.parseInt(problem.employee[i].getId()), contract[j].getMaxNumAssignmentsOnWeight(), contract[j].getMaxNumAssignmentsOnValue());

                    }
                    if (contract[j].getMinNumAssignmentsOn()) {
                        FOMinNumAssignments = minNumAssignments(Integer.parseInt(problem.employee[i].getId()), contract[j].getMinNumAssignmentsWeight(), contract[j].getMinNumAssignmentsValue());

                    }
                    if (contract[j].getMaxConsecutiveWorkingDaysOn()) {
                        FOMaxConsecutiveWorkingDays = maxConsecutiveWorkingDays(Integer.parseInt(problem.employee[i].getId()), contract[j].getMaxConsecutiveWorkingDaysWeight(), contract[j].getMaxConsecutiveWorkingDaysValue());

                    }
                    if (contract[j].getMinConsecutiveWorkingDaysOn()) {
                        FOMinConsecutiveWorkingDays = minConsecutiveWorkingDays(Integer.parseInt(problem.employee[i].getId()), contract[j].getMinConsecutiveWorkingDaysWeight(), contract[j].getMinConsecutiveWorkingDaysValue());

                    }
                    if (contract[j].getMaxConsecutiveFreeDaysOn()) {
                        FOMaxConsecutiveFreeDays = maxConsecutiveFreeDays(Integer.parseInt(problem.employee[i].getId()), contract[j].getMaxConsecutiveFreeDaysWeight(), contract[j].getMaxConsecutiveFreeDaysValue());

                    }
                    if (contract[j].getMinConsecutiveFreeDaysOn()) {
                        FOMinConsecutiveFreeDays = minConsecutiveFreeDays(Integer.parseInt(problem.employee[i].getId()), contract[j].getMinConsecutiveFreeDaysWeight(), contract[j].getMinConsecutiveFreeDaysValue());

                    }
                    if (contract[j].getMaxConsecutiveWorkingWeekendsOn()) {
                        FOMaxConsecutiveWorkingWeekends = maxConsecutiveWorkingWeekends(Integer.parseInt(problem.employee[i].getId()), contract[0].getMaxConsecutiveWorkingWeekendsWeight(), contract[0].getMaxConsecutiveWorkingWeekendsValue());

                    }
                    if (contract[j].getMinConsecutiveWorkingWeekendsOn()) {
                        FOMinConsecutiveWorkingWeekends = minConsecutiveWorkingWeekends(Integer.parseInt(problem.employee[i].getId()), contract[j].getMinConsecutiveWorkingWeekendsWeight(), contract[j].getMinConsecutiveWorkingWeekendsValue());

                    }
                    if (contract[j].getMaxWorkingWeekendsInFourWeeksOn()) {
                        FOMaxWorkingWeekendsInFourWeeks = maxWorkingWeekendsInFourWeeks(Integer.parseInt(problem.employee[i].getId()), contract[j].getMaxWorkingWeekendsInFourWeeksWeight(), contract[j].getMaxWorkingWeekendsInFourWeeksValue());

                    }
                    if (contract[j].getCompleteWeekendsOn()) {
                        FOCompleteWeekends = completeWeekends(Integer.parseInt(problem.employee[i].getId()), contract[j].getCompleteWeekendsWeight());

                    }
                    if (contract[j].getIdent_ShiftTypesDuringWeekendOn()) {
                        FOIdent_ShiftTypesDuringWeekend = ident_ShiftTypesDuringWeekend(Integer.parseInt(problem.employee[i].getId()), contract[j].getIdent_ShiftTypesDuringWeekendWeight());

                    }
                    if (contract[j].getNoNightShiftBeforeFreeWeekendOn()) {
                        FONoNightShiftBeforeFreeWeekend = noNightShiftBeforeFreeWeekend(Integer.parseInt(problem.employee[i].getId()), contract[j].getNoNightShiftBeforeFreeWeekendWeight());

                    }
                    if (contract[j].getTwoFreeDaysAfterNightShiftsOn()) {
                        FOTwoFreeDaysAfterNightShifts = twoFreeDaysAfterNightShifts(Integer.parseInt(problem.employee[i].getId()), contract[j].getTwoFreeDaysAfterNightShiftsWeight());

                    }
                    if (contract[j].getAlternativeSkillCategoryOn()) {
                        FOAlternativeSkillCategory = alternativeSkillCategory(contract[j].getAlternativeSkillCategoryWeight());

                    }
                    if (contract[j].getNumberOfUnwantedPatterns() != 0) {
                        FOUnwantedPatterns = unwantedPatterns(Integer.parseInt(problem.employee[i].getId()));

                    }
                }

            }

            fo += FOMaxNumAssignments + FOMinNumAssignments + FOMaxConsecutiveWorkingDays
                    + FOMinConsecutiveWorkingDays + FOMaxConsecutiveFreeDays + FOMinConsecutiveFreeDays
                    + FOIdent_ShiftTypesDuringWeekend + FONoNightShiftBeforeFreeWeekend
                    + FOMaxConsecutiveWorkingWeekends + FOMinConsecutiveWorkingWeekends
                    + FOMaxWorkingWeekendsInFourWeeks + FOCompleteWeekends + FOTwoFreeDaysAfterNightShifts
                    + FOAlternativeSkillCategory + FOUnwantedPatterns + dayOffRequest(problem.employee[i]) + dayOnRequest(problem.employee[i]) + shiftOffRequest(problem.employee[i]) + shiftOnRequest(problem.employee[i]);

//        System.out.println("Resultado da função Objetivo: "+ fo);
        }
        return fo;

    }

    public String[][] salvarFuncaoObjetivo(String[][] representacao2) {
        penalizacao = new String[problem.employee.length][19];
        this.representacao = representacao2.clone();
        String info = "";
        int fo = 0;
//        representacao=null;
        String retorno[][];
        contract = problem.getContract();

        for (int i = 0; i < problem.employee.length; i++) {
            for (int j = 0; j < problem.contract.length; j++) {
                if (contract[j].getId() == problem.employee[i].getContractID()) {
                    if (contract[j].getMaxNumAssignmentsOn()) {
                        FOMaxNumAssignments = maxNumAssignments(Integer.parseInt(problem.employee[i].getId()), contract[j].getMaxNumAssignmentsOnWeight(), contract[j].getMaxNumAssignmentsOnValue());

                    }
                    if (contract[j].getMinNumAssignmentsOn()) {
                        FOMinNumAssignments = minNumAssignments(Integer.parseInt(problem.employee[i].getId()), contract[j].getMinNumAssignmentsWeight(), contract[j].getMinNumAssignmentsValue());

                    }
                    if (contract[j].getMaxConsecutiveWorkingDaysOn()) {
                        FOMaxConsecutiveWorkingDays = maxConsecutiveWorkingDays(Integer.parseInt(problem.employee[i].getId()), contract[j].getMaxConsecutiveWorkingDaysWeight(), contract[j].getMaxConsecutiveWorkingDaysValue());

                    }
                    if (contract[j].getMinConsecutiveWorkingDaysOn()) {
                        FOMinConsecutiveWorkingDays = minConsecutiveWorkingDays(Integer.parseInt(problem.employee[i].getId()), contract[j].getMinConsecutiveWorkingDaysWeight(), contract[j].getMinConsecutiveWorkingDaysValue());

                    }
                    if (contract[j].getMaxConsecutiveFreeDaysOn()) {
                        FOMaxConsecutiveFreeDays = maxConsecutiveFreeDays(Integer.parseInt(problem.employee[i].getId()), contract[j].getMaxConsecutiveFreeDaysWeight(), contract[j].getMaxConsecutiveFreeDaysValue());

                    }
                    if (contract[j].getMinConsecutiveFreeDaysOn()) {
                        FOMinConsecutiveFreeDays = minConsecutiveFreeDays(Integer.parseInt(problem.employee[i].getId()), contract[j].getMinConsecutiveFreeDaysWeight(), contract[j].getMinConsecutiveFreeDaysValue());

                    }
                    if (contract[j].getMaxConsecutiveWorkingWeekendsOn()) {
                        FOMaxConsecutiveWorkingWeekends = maxConsecutiveWorkingWeekends(Integer.parseInt(problem.employee[i].getId()), contract[j].getMaxConsecutiveWorkingWeekendsWeight(), contract[j].getMaxConsecutiveWorkingWeekendsValue());

                    }
                    if (contract[j].getMinConsecutiveWorkingWeekendsOn()) {
                        FOMinConsecutiveWorkingWeekends = minConsecutiveWorkingWeekends(Integer.parseInt(problem.employee[i].getId()), contract[j].getMinConsecutiveWorkingWeekendsWeight(), contract[j].getMinConsecutiveWorkingWeekendsValue());

                    }
                    if (contract[j].getMaxWorkingWeekendsInFourWeeksOn()) {
                        FOMaxWorkingWeekendsInFourWeeks = maxWorkingWeekendsInFourWeeks(Integer.parseInt(problem.employee[i].getId()), contract[j].getMaxWorkingWeekendsInFourWeeksWeight(), contract[j].getMaxWorkingWeekendsInFourWeeksValue());

                    }
                    if (contract[j].getCompleteWeekendsOn()) {
                        FOCompleteWeekends = completeWeekends(Integer.parseInt(problem.employee[i].getId()), contract[j].getCompleteWeekendsWeight());

                    }
                    if (contract[j].getIdent_ShiftTypesDuringWeekendOn()) {
                        FOIdent_ShiftTypesDuringWeekend = ident_ShiftTypesDuringWeekend(Integer.parseInt(problem.employee[i].getId()), contract[j].getIdent_ShiftTypesDuringWeekendWeight());

                    }
                    if (contract[j].getNoNightShiftBeforeFreeWeekendOn()) {
                        FONoNightShiftBeforeFreeWeekend = noNightShiftBeforeFreeWeekend(Integer.parseInt(problem.employee[i].getId()), contract[j].getNoNightShiftBeforeFreeWeekendWeight());

                    }
                    if (contract[j].getTwoFreeDaysAfterNightShiftsOn()) {
                        FOTwoFreeDaysAfterNightShifts = twoFreeDaysAfterNightShifts(Integer.parseInt(problem.employee[i].getId()), contract[j].getTwoFreeDaysAfterNightShiftsWeight());

                    }
                    if (contract[j].getAlternativeSkillCategoryOn()) {
                        FOAlternativeSkillCategory = alternativeSkillCategory(contract[j].getAlternativeSkillCategoryWeight());

                    }
                    if (contract[j].getNumberOfUnwantedPatterns() != 0) {
                        FOUnwantedPatterns = unwantedPatterns(Integer.parseInt(problem.employee[i].getId()));

                    }
                }

            }

            int dayOffRequests = 0, dayOnRequests = 0, shiftOffRequests = 0, shiftOnRequests = 0;
            dayOffRequests = dayOffRequest(problem.employee[i]);
            dayOnRequests = dayOnRequest(problem.employee[i]);
            shiftOffRequests = shiftOffRequest(problem.employee[i]);
            shiftOnRequests = shiftOnRequest(problem.employee[i]);
            //        for (int i = 0; i < problem.employee.length; i++) {
            //            int dayOffRequestsTemp = dayOffRequest(problem.employee[i]), dayOnRequestsTemp = dayOnRequest(problem.employee[i]), shiftOffRequestsTemp = ShiftOffRequest(problem.employee[i]), shiftOnRequestsTemp = ShiftOnRequest(problem.employee[i]);
            info += "\nDayOffRequest= " + dayOffRequests + "\nDayOnRequest= " + dayOnRequests + "\nShiftOffRequest= " + shiftOffRequests + "\nShiftOnRequest= " + shiftOnRequests;

            penalizacao[i][15] = "\nDayOffRequest= " + dayOffRequests;
            penalizacao[i][16] = "\nDayOnRequest= " + dayOnRequests;
            penalizacao[i][17] = "\nShiftOffRequest= " + shiftOffRequests;
            penalizacao[i][18] = "\nShiftOnRequest= " + shiftOnRequests;

            fo += FOMaxNumAssignments + FOMinNumAssignments + FOMaxConsecutiveWorkingDays
                    + FOMinConsecutiveWorkingDays + FOMaxConsecutiveFreeDays + FOMinConsecutiveFreeDays
                    + FOIdent_ShiftTypesDuringWeekend + FONoNightShiftBeforeFreeWeekend
                    + FOMaxConsecutiveWorkingWeekends + FOMinConsecutiveWorkingWeekends
                    + FOMaxWorkingWeekendsInFourWeeks + FOCompleteWeekends + FOTwoFreeDaysAfterNightShifts
                    + FOAlternativeSkillCategory + FOUnwantedPatterns + dayOffRequests + dayOnRequests + shiftOffRequests + shiftOnRequests;
////        System.out.println("Resultado da função Objetivo: "+ fo);
        }
//        System.out.println("Fo: " + fo + " \nPenaliza:" + info);
        System.out.println("Fo: " + fo );
        retorno = penalizacao.clone();
        return retorno;

    }

    public int maxNumAssignments(int idEmployee, int weight, int value) {
        int fo = 0, cont = 0, pen = 0;
//        for (int i = 0; i < problem.employee.length; i++) {
        for (int j = 0; j < problem.getVetorScheduling_Period().size(); j++) {
            if (!representacao[j][idEmployee].equals("-")) {
                cont++;
                if (cont > value) {
                    fo++;
                    pen++;
                    cont = 0;
                    break;
                }

            }
        }
//        if (value != 1) {
//            while (value != 0) {
//                fo++;
//                pen++;
//                value--;
//            }
//        }
        penalizacao[idEmployee][0] = "\nFo Max Num Assignments = " + pen + "Cost" + weight * fo;
//            pen = 0;
//            cont = 0;

//        }
        return fo * weight;
    }

    public int minNumAssignments(int idEmployee, int weight, int value) {
        int fo = 0, cont = 0, pen = 0;
//        for (int i = 0; i < problem.employee.length; i++) {
        for (int j = 0; j < problem.getVetorScheduling_Period().size(); j++) {
            if (!representacao[j][idEmployee].equals("-")) {
                cont++;
            }
        }
        if (cont < value) {
            fo++;
            pen++;
            cont = 0;
        }
//        if (value != 1) {
//            while (value != 0) {
//                fo++;
//                pen++;
//                value--;
//            }
//        }
        penalizacao[idEmployee][1] = "\nFo Min Num Assignments= " + pen + "Cost" + weight * fo;
//            pen = 0;
//        }
        return fo * weight;
    }

    private int maxConsecutiveWorkingDays(int idEmplyee, int weight, int value) {
        int fo = 0, cont = 0, pen = 0;
//        for (int j = 0; j < problem.employee.length; j++) {
//            cont = 0;
        for (int i = 0; i < problem.getVetorScheduling_Period().size(); i++) {
            if (!representacao[i][idEmplyee].equals("-")) {
                cont++;

                if (cont > value) {
                    fo++;
                    pen++;
                    cont = 0;
                }
            } else {
                cont = 0;
            }
        }
        penalizacao[idEmplyee][2] = "\nFo Max Consecutive Working Days= " + pen + "Cost" + weight * fo;
//        }
        return fo * weight;
    }

    private int minConsecutiveWorkingDays(int idEmloyee, int weight, int value) {
        int fo = 0, cont = 0, pen = 0;
//        for (int j = 0; j < problem.employee.length; j++) {
//            cont = 0;
        for (int i = 0; i < problem.getVetorScheduling_Period().size(); i++) {
            if (!representacao[i][idEmloyee].equals("-")) {
                cont++;

            } else {
                if (cont < value && cont != 0) {
                    fo++;
                    pen++;
                    cont = 0;
                } else if (cont >= value && cont != 0) {
                    cont = 0;
                }
            }
        }
        penalizacao[idEmloyee][3] = "\nFo Min Consecutives Working Days = " + pen + "Cost" + weight * fo;
//            pen = 0;
//        }
        return fo * weight;
    }

    private int maxConsecutiveFreeDays(int idEmployee, int weight, int value) {
        int fo = 0, cont = 0, pen = 0;
//        for (int j = 0; j < problem.employee.length; j++) {
//            cont = 0;
        for (int i = 0; i < problem.getVetorScheduling_Period().size(); i++) {
            if (representacao[i][idEmployee].equals("-")) {
                cont++;
                if (cont > value) {
                    fo++;
                    pen++;
                    cont = 0;
                }

            } else {
                cont = 0;
            }
        }
        penalizacao[idEmployee][4] = "\nFo Max Consecutive Free Day= " + pen + "Cost" + weight * fo;
//            pen = 0;
//        }
        return fo * weight;
    }

    private int minConsecutiveFreeDays(int idEmployee, int weight, int value) {
        int fo = 0, cont = 0, pen = 0;
//        for (int j = 0; j < problem.employee.length; j++) {
//            cont = 0;
        for (int i = 0; i < problem.getVetorScheduling_Period().size(); i++) {
            if (representacao[i][idEmployee].equals("-")) {
                cont++;//como ver o min?
            } else {
                if (cont < value && cont != 0) {
                    fo++;
                    pen++;
                }
                cont = 0;
            }
        }
        penalizacao[idEmployee][5] = "\nFo Min Consecutive Free Days =" + pen + "Cost" + weight * fo;
//        pen = 0;
//        }
        return fo * weight;
    }

    private int maxConsecutiveWorkingWeekends(int idEmployee, int weight, int value) {
        int fo = 0, cont = 0, pen = 0, contract = -1;

        for (int i = 0; i < problem.contract.length; i++) {
            for (int k = 0; k < problem.getVetorScheduling_Period().size(); k++) {
                Semana semana = (Semana) problem.getVetorScheduling_Period().get(k);

                if (problem.contract[i].getId() == problem.employee[idEmployee].getContractID()) {
                    contract = i;
                    if ((problem.contract[i].weekendDefinition).toLowerCase().contains((String) semana.getWrite_out())) {
                        problem.contract[i].weekend.add((String) semana.getWrite_out());
                    }
                } else {
                    break;
                }
                if (problem.contract[i].weekend.size() == daysWeekend(contract)) {
                    break;
                }
            }
        }
//        for (int k = 0; k < problem.getVetorScheduling_Period().size(); k++) {
//            Semana semana = (Semana) problem.getVetorScheduling_Period().get(k);
//            if ((problem.getContract()[0].weekendDefinition).toLowerCase().contains((String) semana.getWrite_out())) {
//                weekend.add(semana.getWrite_out());
//            }
//        }
//        for (int j = 0; j < problem.employee.length; j++) {
        int numW = 0, validWeekend = 0;
        for (int i = 0; i < problem.getVetorScheduling_Period().size(); i++) {
            Semana semana = (Semana) problem.getVetorScheduling_Period().get(i);

            if (problem.contract[contract].weekend.contains(semana.getWrite_out())) {
                if (!representacao[i][idEmployee].equals("-")) {//como tratar o sabado e domingo  de um  mesmo fds?
                    cont++;
                } else {
                    cont = 0;
                }
                numW++;
                if (numW == daysWeekend(contract)) {
                    if (daysWeekend(contract) == cont) {
                        validWeekend++;
                    } else {
                        validWeekend = 0;//fim de semana não foi completo, logo não entrará na conta
                    }
                    numW = 0; //termina o fds
                }

                if (validWeekend > value) {
                    fo++;
                    pen++;
                }
            }
        }
        penalizacao[idEmployee][6] = "\nFo Max Consecute Working Weekends= " + pen + "Cost" + weight * fo;
//        pen = 0;
//        }

        return fo * weight;
    }

    private int minConsecutiveWorkingWeekends(int idEmployee, int weight, int value) {
        int fo = 0, cont = 0, pen = 0, contract = -1;

        for (int i = 0; i < problem.contract.length; i++) {
            for (int k = 0; k < problem.getVetorScheduling_Period().size(); k++) {
                Semana semana = (Semana) problem.getVetorScheduling_Period().get(k);

                if (problem.contract[i].getId() == problem.employee[idEmployee].getContractID()) {
                    contract = i;
                    if ((problem.contract[i].weekendDefinition).toLowerCase().contains((String) semana.getWrite_out())) {
                        problem.contract[i].weekend.add((String) semana.getWrite_out());
                    }
                } else {
                    break;
                }
                if (problem.contract[i].weekend.size() == daysWeekend(contract)) {
                    break;
                }
            }
        }

        int numW = 0, validWeekend = 0;
        for (int i = 0; i < problem.getVetorScheduling_Period().size(); i++) {
            Semana semana = (Semana) problem.getVetorScheduling_Period().get(i);

            if (problem.contract[contract].weekend.contains(semana.getWrite_out())) {
                if (!representacao[i][idEmployee].equals("-")) {//como tratar o sabado e domingo  de um  mesmo fds?
                    cont++;
                } else {
                    cont = 0;
                }
                numW++;
                if (numW == daysWeekend(contract)) {
                    if (daysWeekend(contract) == cont) {
                        validWeekend++;
                        cont = 0;
                    } else {
                        if (validWeekend < value) {
                            fo++;
                            pen++;
                        }
                        validWeekend = 0;//fim de semana não foi completo, logo não entrará na conta
                        cont = 0;
                    }
                    numW = 0; //termina o fds
                }

            }
        }
        penalizacao[idEmployee][7] = "\nFo Min COnsecutive Working Weekends =" + pen + "Cost" + weight * fo;
//            pen = 0;

        return fo * weight;
    }

        private int maxWorkingWeekendsInFourWeeks(int idEmployee, int weight, int value) {
        int fo = 0, cont = 0, pen = 0, contract = -1;

        for (int i = 0; i < problem.contract.length; i++) {
            for (int k = 0; k < problem.getVetorScheduling_Period().size(); k++) {
                Semana semana = (Semana) problem.getVetorScheduling_Period().get(k);

                if (problem.contract[i].getId() == problem.employee[idEmployee].getContractID()) {
                    contract = i;
                    if ((problem.contract[i].weekendDefinition).toLowerCase().contains((String) semana.getWrite_out())) {
                        problem.contract[i].weekend.add((String) semana.getWrite_out());
                    }
                } else {
                    break;
                }
                if (problem.contract[i].weekend.size() == daysWeekend(contract)) {
                    break;
                }
            }
        }

        int numW = 0, validWeekend = 0;
        for (int i = 0; i < problem.getVetorScheduling_Period().size(); i++) {
            Semana semana = (Semana) problem.getVetorScheduling_Period().get(i);

            if (problem.contract[contract].weekend.contains(semana.getWrite_out())) {
                if (!representacao[i][idEmployee].equals("-")) {//como tratar o sabado e domingo  de um  mesmo fds?
                    cont++;
                } else {
                    cont = 0;
                }
                numW++;
                if (numW == daysWeekend(contract)) {
                    if (daysWeekend(contract) == cont) {
                        validWeekend++;
                        cont = 0;
                    }
                    numW = 0; //termina o fds
                }

            }
        }

        if (validWeekend > value) {
            fo++;
            pen++;
        }

        penalizacao[idEmployee][8] = "\nFo Max Working Weekeds in Four Weeks= " + pen + "Cost" + weight * fo;
//            pen = 0;
//        }

        return fo * weight;
    }

    private int completeWeekends(int idEmployee, int weight) {
        int fo = 0, cont = 0, pen = 0, contract = -1;

        for (int i = 0; i < problem.contract.length; i++) {
            for (int k = 0; k < problem.getVetorScheduling_Period().size(); k++) {
                Semana semana = (Semana) problem.getVetorScheduling_Period().get(k);

                if (problem.contract[i].getId() == problem.employee[idEmployee].getContractID()) {
                    contract = i;
                    if ((problem.contract[i].weekendDefinition).toLowerCase().contains((String) semana.getWrite_out())) {
                        problem.contract[i].weekend.add((String) semana.getWrite_out());
                    }
                } else {
                    break;
                }
                if (problem.contract[i].weekend.size() == daysWeekend(contract)) {
                    break;
                }
            }
        }

        int numW = 0, validWeekend = 0;
        for (int i = 0; i < problem.getVetorScheduling_Period().size(); i++) {
            Semana semana = (Semana) problem.getVetorScheduling_Period().get(i);

            if (problem.contract[contract].weekend.contains(semana.getWrite_out())) {
                if (!representacao[i][idEmployee].equals("-")) {//como tratar o sabado e domingo  de um  mesmo fds?
                    cont++;
                } else {
                    cont = 0;
                }
                numW++;
                if (numW == daysWeekend(contract)) {
                    if (daysWeekend(contract) != cont) {
                        fo++;
                        pen++;
                        cont = 0;
                    }
                    numW = 0; //termina o fds
                }

            }
        }

        penalizacao[idEmployee][9] = "\nFo Complete Weekends = " + pen + "Cost" + weight * fo;
//            pen = 0;
//    }
        return fo * weight;
    }

    private int ident_ShiftTypesDuringWeekend(int idEmployee, int weight) {
        int fo = 0, cont = 0, pen = 0, contract = -1;

        for (int i = 0; i < problem.contract.length; i++) {
            for (int k = 0; k < problem.getVetorScheduling_Period().size(); k++) {
                Semana semana = (Semana) problem.getVetorScheduling_Period().get(k);

                if (problem.contract[i].getId() == problem.employee[idEmployee].getContractID()) {
                    contract = i;
                    if ((problem.contract[i].weekendDefinition).toLowerCase().contains((String) semana.getWrite_out())) {
                        problem.contract[i].weekend.add((String) semana.getWrite_out());
                    }
                } else {
                    break;
                }
                if (problem.contract[i].weekend.size() == daysWeekend(contract)) {
                    break;
                }
            }
        }

        int numW = 0, validWeekend = 0;
        Boolean continua = false;
        ArrayList<String> verifShift = new ArrayList<>();
        for (int i = 0; i < problem.getVetorScheduling_Period().size(); i++) {
            Semana semana = (Semana) problem.getVetorScheduling_Period().get(i);

            if (problem.contract[contract].weekend.contains(semana.getWrite_out())) {
                verifShift.add(representacao[i][idEmployee]);
                cont++;

                numW++;
                if (numW == daysWeekend(contract)) {
                    if (daysWeekend(contract) == cont) {
                        String primeiroElemento = verifShift.get(0);
                        Boolean tudoIgual = true;
                        for (int j = 1; j < verifShift.size(); j++) { // já temos o elemento zero, então o for pode começar em 1
                            if (!verifShift.get(j).equals(primeiroElemento)) {
                                tudoIgual = false;
                                break; // sai do loop, já achamos um elemento diferente, não precisa continuar
                            }
                        }
                        verifShift.clear();
                        if (!tudoIgual) {
                            fo++;
                            pen++;

                        }
                        cont = 0;
                    }
                    numW = 0; //termina o fds
                }

            }
        }
        penalizacao[idEmployee][10] = "\nFo Ident Shift Types During Weekend =" + pen + "Cost" + weight * fo;
//            pen = 0;
//        }
        return fo * weight;
    }

    private int noNightShiftBeforeFreeWeekend(int idEmployee, int weight) {
        int fo = 0, cont = 0, pen = 0, contract = -1;

        for (int i = 0; i < problem.contract.length; i++) {
            for (int k = 0; k < problem.getVetorScheduling_Period().size(); k++) {
                Semana semana = (Semana) problem.getVetorScheduling_Period().get(k);

                if (problem.contract[i].getId() == problem.employee[idEmployee].getContractID()) {
                    contract = i;
                    if ((problem.contract[i].weekendDefinition).toLowerCase().contains((String) semana.getWrite_out())) {
                        problem.contract[i].weekend.add((String) semana.getWrite_out());
                    }
                } else {
                    break;
                }
                if (problem.contract[i].weekend.size() == daysWeekend(contract)) {
                    break;
                }
            }
        }

        for (int i = 0; i < problem.getVetorScheduling_Period().size(); i++) {
            Semana semana = (Semana) problem.getVetorScheduling_Period().get(i);

            if (problem.contract[contract].weekend.get(0).equals(semana.getWrite_out())) {
                if (i != 0) {
                    if (representacao[i - 1][idEmployee].equals("N") && representacao[i][idEmployee].equals("-")) {
                        fo++;
                        pen++;
                    }
                }
            }
        }
        penalizacao[idEmployee][11] = "\nFo no night Shift Before Free Weekend =" + pen + "Cost" + weight * fo;
//            pen = 0;
//        }

        return fo * weight;
    }

    private int twoFreeDaysAfterNightShifts(int idEmployee, int weight) {
        int fo = 0, cont = 0, pen = 0;
//        for (int j = 0; j < problem.employee.length; j++) {
        cont = 0;
        for (int i = 0; i < problem.getVetorScheduling_Period().size(); i++) {

            if (representacao[i][idEmployee].equals("N") && i != problem.getVetorScheduling_Period().size() - 1) {
                if (!representacao[i + 1][idEmployee].equals("N") && (i + 1) != problem.getVetorScheduling_Period().size() - 1) {
                    if (representacao[i + 2][idEmployee].equals("N")) {
                        fo++;
                        pen++;
                    }
                } else {
                    fo++;
                    pen++;
                }
            }

        }
        penalizacao[idEmployee][12] = "\nFo two free Days After Nights shifts= " + pen + "Cost" + weight * fo;
//            pen = 0;
//        }
        return fo * weight;
    }

    private int alternativeSkillCategory(int weight) {
        int fo = 0;

        return fo * weight;
    }

    public int unwantedPatterns(int idEmployee) {
        int fo = 0, pen = 0;
//        for (int i = 0; i < problem.employee.length; ++i) {
        for (int j = 0; j < problem.contract.length; ++j) {
            if (problem.contract[j].getId() == problem.employee[idEmployee].getContractID()) {
                for (int k = 0; k < problem.contract[j].unwantedPatternsId.size(); ++k) {
                    for (int l = 0; l < problem.pattern.length; ++l) {
                        if (problem.contract[j].unwantedPatternsId.get(k) == problem.pattern[l].getId()) {
                            for (int n = 0; n < problem.getVetorScheduling_Period().size() - problem.pattern[l].etapas.size() + 1; ++n) {
                                boolean atendePadrao = true;
                                int etapaCount = 0;
                                for (int m = 0; m < problem.pattern[l].etapas.size(); ++m) {
                                    Semana semana = (Semana) problem.getVetorScheduling_Period().get(n + etapaCount);
//                                        System.out.println("Nurse: " + i + " Pattern: " + l + " Etapa: " + m
//                                                + " (" + problem.pattern[l].etapas.get(m).getTurno() + "|" + problem.pattern[l].etapas.get(m).getDia() + ")"
//                                                + " Semana: " + semana.write_out.toString() + " Rep: " + representacao[n + etapaCount][i]);
                                    if ((representacao[n + etapaCount][idEmployee].equals(problem.pattern[l].etapas.get(m).getTurno())
                                            && ((semana.write_out).toString().equals(problem.pattern[l].etapas.get(m).getDia())
                                            || (problem.pattern[l].etapas.get(m).getDia().equals("Any") || problem.pattern[l].etapas.get(m).getDia().equals("any"))))
                                            || (((problem.pattern[l].etapas.get(m).getTurno().equals("Any") || problem.pattern[l].etapas.get(m).getTurno().equals("any")) && !representacao[n + etapaCount][idEmployee].equals("-"))
                                            && ((semana.write_out).toString().equals(problem.pattern[l].etapas.get(m).getDia())
                                            || problem.pattern[l].etapas.get(m).getDia().equals("Any")))
                                            || (((problem.pattern[l].etapas.get(m).getTurno().equals("None") || problem.pattern[l].etapas.get(m).getTurno().equals("none")) && representacao[n + etapaCount][idEmployee].equals("-"))
                                            && representacao[n + etapaCount][idEmployee].equals("-")
                                            && ((semana.write_out).toString().equals(problem.pattern[l].etapas.get(m).getDia())
                                            || (problem.pattern[l].etapas.get(m).getDia().equals("Any") || problem.pattern[l].etapas.get(m).getDia().equals("any"))))) {
                                        //atende etapa do padrao nao faz nada
//                                            System.out.println("true");
                                        ++etapaCount;
                                        if (n + etapaCount >= problem.getVetorScheduling_Period().size()) {
                                            break;
                                        }
                                    } else {
                                        atendePadrao = false;
                                        break;
                                    }
                                }
                                if (atendePadrao) {
                                    fo = fo + problem.pattern[l].weight;
                                    pen++;
                                    //penalizar
//                                        System.out.println("penalty");
                                }
                            }
                        }
                    }
                }
            }
        }
        penalizacao[idEmployee][13] = "\nFo Unwanted Patterns= " + pen + "Cost" + fo;
//            pen = 0;
//        }
        return fo;
    }

    public void carregarRepresentacao() {
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
    }

    public void carregarProblem() {
        try {
            // Deserialize from a file   
            File file = new File("problem.txt");
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
            // Deserialize the object   
            problem = (Problem) in.readObject();
            in.close();
        } catch (ClassNotFoundException e) {
        } catch (IOException e) {
        }
    }

    public ArrayList vetorWeekend() {
        for (int k = 0; k < problem.getVetorScheduling_Period().size(); k++) {
            Semana semana = (Semana) problem.getVetorScheduling_Period().get(k);
            if ((problem.getContract()[0].weekendDefinition).toLowerCase().contains((String) semana.getWrite_out())) {
                weekend.add(semana.getWrite_out());
            }
        }
        return weekend;
    }

    public int dayOffRequest(Employee nurse) {
        int penalizacao = 1, parar = 0, total = 0;
        for (int i = 0; i < problem.day_Off_Request.length; i++) {
            if (nurse.getId().equals(problem.day_Off_Request[i].employeeID)) {
                for (int j = 0; j < problem.vetorScheduling_Period.size(); j++) {
                    Semana semana = (Semana) problem.vetorScheduling_Period.get(j);
                    if (semana.getDate().equals(problem.day_Off_Request[i].date)) {
                        if (!representacao[j][Integer.parseInt(nurse.id)].equals("-")) {
                            penalizacao = penalizacao * problem.day_Off_Request[i].getWeight();
                            total += penalizacao;
                        }
                        penalizacao = 1;
                        break;
                    }
                }
            }
        }
        return total;
    }

    public int dayOnRequest(Employee nurse) {
        int penalizacao = 1, parar = 0, total = 0;
        for (int i = 0; i < problem.day_On_Request.length; i++) {
            if (nurse.getId().equals(problem.day_On_Request[i].employeeID)) {
                for (int j = 0; j < problem.vetorScheduling_Period.size(); j++) {
                    Semana semana = (Semana) problem.vetorScheduling_Period.get(j);
                    if (semana.getDate().equals(problem.day_On_Request[i].date)) {
                        if (representacao[j][Integer.parseInt(nurse.id)].equals("-")) {
                            penalizacao = penalizacao * problem.day_On_Request[i].getWeight();
                            total += penalizacao;
                        }
                        penalizacao = 1;
                        break;
                    }
                }
            }
        }
        return total;
    }

    public int shiftOffRequest(Employee nurse) {
        int penalizacao = 1, parar = 0, total = 0;
        for (int i = 0; i < problem.shift_Off_Request.length; i++) {
            if (nurse.getId().equals(problem.shift_Off_Request[i].employeeID)) {
                for (int j = 0; j < problem.vetorScheduling_Period.size(); j++) {
                    Semana semana = (Semana) problem.vetorScheduling_Period.get(j);
                    if (semana.getDate().equals(problem.shift_Off_Request[i].date)) {
                        if (!representacao[j][Integer.parseInt(nurse.id)].equals(problem.shift_Off_Request[i].shift_TypeID)) {
                            penalizacao = penalizacao * problem.shift_Off_Request[i].getWeight();
                            total += penalizacao;
                        }
                        penalizacao = 1;
                        break;
                    }
                }
            }
        }
        return total;
    }

    public int shiftOnRequest(Employee nurse) {
        int penalizacao = 1, parar = 0, total = 0;
        for (int i = 0; i < problem.shift_On_Request.length; i++) {
            if (nurse.getId().equals(problem.shift_On_Request[i].employeeID)) {
                for (int j = 0; j < problem.vetorScheduling_Period.size(); j++) {
                    Semana semana = (Semana) problem.vetorScheduling_Period.get(j);
                    if (semana.getDate().equals(problem.shift_On_Request[i].date)) {
                        if (!representacao[j][Integer.parseInt(nurse.id)].equals(problem.shift_On_Request[i].shift_TypeID)) {
                            penalizacao = penalizacao * problem.shift_On_Request[i].getWeight();
                            total += penalizacao;
                        }
                        penalizacao = 1;
                        break;
                    }
                }
            }
        }
        return total;
    }

    public int daysWeekend(int idContract) {
        int numDayWeekend = 0;

        String op = trim(problem.contract[idContract].weekendDefinition);
        if (op.equals("SaturdaySunday")) {
            numDayWeekend = 2;
        } else if (op.equals("FridaySaturdaySunday")) {
            numDayWeekend = 3;
        } else if (op.equals("FridaySaturdaySundayMonday")) {
            numDayWeekend = 4;
        } else if (op.equals("SaturdaySundayMonday")) {
            numDayWeekend = 3;
        }

        return numDayWeekend;
    }
}
