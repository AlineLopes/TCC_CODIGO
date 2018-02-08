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
public class Mutacao {

    String[][] representacao;
    Problem problem;
    int number1, number2, temp;
    ArrayList<Integer> position = new ArrayList<>();
    Configuracao conf = new Configuracao();

    public Mutacao(Problem problem) {
        this.problem = problem;
    }

    public String[][] operadorMutacao(String[][] representacao) {

            this.representacao = representacao;
            ArrayList<Integer> funcionario = new ArrayList<Integer>();
            Random gerador = new Random();
            int scheduling_period = gerador.nextInt(problem.vetorScheduling_Period.size());

            for (int i = 0; i < problem.employee.length / 2; i++) {
                funcionario = sortear(problem.employee.length);

                String aux = representacao[scheduling_period][funcionario.get(0)];
                representacao[scheduling_period][funcionario.get(0)] = representacao[scheduling_period][funcionario.get(1)];
                representacao[scheduling_period][funcionario.get(1)] = aux;
            }

//        System.out.println("Funcionarios: " + funcionario.get(0) +"/"+funcionario.get(1) + " Dia da semana: " + scheduling_period);
        

        return representacao;
    }

    public ArrayList<Integer> sortear(int limite) {
        Random gerador = new Random();
        number1 = gerador.nextInt(limite);
        position.add(0, number1);
        number2 = gerador.nextInt(limite);
        while (number2 == number1) {
            number2 = gerador.nextInt(limite);
        }
        position.add(1, number2);

        return position;
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
