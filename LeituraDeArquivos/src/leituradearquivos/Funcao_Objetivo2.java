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

/**
 *
 * @author aline
 */
public class Funcao_Objetivo2 {
    String[][] representacao;
    int week, employees;
    Problem problem;
    int FOMaxNumAssignments, FOMaxConsecutiveWorkingDays;
    Contract[] contract = problem.getContract();

    /**
     * @param args the command line arguments
     */
    public void main(String[] args) {
//        carregarProblem();
//        carregarRepresentacao();
//        calcularFuncaoObjetivo();    
    }
    public void calcularFuncaoObjetivo() {
//        representacao=null;

        if (contract[0].getMaxNumAssignmentsOn()) {
//            FOMaxNumAssignments = maxNumAssignments(contract[0].getMaxNumAssignmentsOnWeight(), contract[0].getMaxNumAssignmentsOnValue());

        }
        if (contract[0].getMaxConsecutiveWorkingDaysOn()) {
            FOMaxConsecutiveWorkingDays = maxConsecutiveWorkingDays(contract[0].getMaxConsecutiveWorkingDaysWeight(), contract[0].getMaxConsecutiveWorkingDaysValue());

        }

    }
public int maxNumAssignments(int weight, int value) {
        int fo = 0;
        for (int i = 0; i <= week; i++) {
            for (int j = 0; j <= problem.employee.length; j++) {

            }
        }
        return fo;
    }

    private int maxConsecutiveWorkingDays(int weight, int value) {
        int fo = 0, cont = 0, fitneess;
        for (int j = 0; j <= problem.employee.length; j++) {
            cont = 0;
            for (int i = 1; i < week; i++) { //semana vai de 1 a 5(dias uteis) -- Maximo que dias trabalhados
                if (!representacao[j][i].equals("-")) {
                    cont++;
                    if (fo == 4) {
                        fo++;
                        cont = 0;
                    }
                }
            }
        }
        return fo*weight;
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

    
}
