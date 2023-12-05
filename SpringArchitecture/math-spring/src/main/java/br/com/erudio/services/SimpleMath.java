package br.com.erudio.services;

import br.com.erudio.exception.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

public class SimpleMath {

    /*
     * Somando dois números
     * @param Double
     * @param Double
     * @return A soma de dois números
     * */
    public static Double sum(Double numberOne,Double numberTwo) {
        return numberOne + numberTwo;
    }

    /*
     * Subtraindo dois números
     * @param Double
     * @param Double
     * @return A subtração de dois números
     * */
    public static Double subtraction(Double numberOne,Double numberTwo) {
        return numberOne - numberTwo;
    }

    /*
     * Multiplicando de dois números
     * @param Double
     * @param Double
     * @return A multiplicação de dois números
     * */
    public static Double multiplication(Double numberOne,Double numberTwo) {
        return numberOne * numberTwo;
    }

    /*
     * Divisão de dois números
     * @param Double
     * @param Double
     * @return A divisão de dois números
     * */
    public static Double division(Double numberOne,Double numberTwo) {
        return numberOne / numberTwo;
    }

    /*
     * Média de dois números
     * @param Double
     * @param Double
     * @return A média de dois números dividido por sua quantidade
     * */
    public static Double avarage(Double numberOne,Double numberTwo) {
        return (numberOne + numberTwo) / 2;
    }

    /*
     * Raiz quadrada de um número
     * @param Double
     * @return A raíz quadrada de um número
     * */
    public static Double squareRoot(Double numberOne) {
        return Math.sqrt(numberOne);
    }
}
