package br.com.erudio.controllers;

import br.com.erudio.exception.UnsupportedMathOperationException;
import br.com.erudio.services.NumberConverter;
import br.com.erudio.services.SimpleMath;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/*Controlador dos cálculos matemáticos
 * @author Greg
 * @version 1.0
 * @since 2023-12-05
 * */
@RestController
public class MathController {
	private final AtomicLong counter = new AtomicLong();

	/*
	 * Somando valores com o PathVariable
	 * @param PathVariable de um numero
	 * @param PathVariable de um numero
	 * @return A soma de dois números
	 * */
	@RequestMapping("/sum/{numberOne}/{numberTwo}")
	public Double sum(
			@PathVariable(value = "numberOne")String numberOne,
			@PathVariable(value = "numberTwo")String numberTwo) throws Exception {
		if (!NumberConverter.isNumber(numberOne) || !NumberConverter.isNumber(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		return NumberConverter.convertToDouble(numberOne) + NumberConverter.convertToDouble(numberTwo);
	}

	/*
	 * Subtraindo valores com o PathVariable
	 * @param PathVariable de um numero
	 * @param PathVariable de um numero
	 * @return A subtração de dois números
	 * */
	@RequestMapping("/sub/{numberOne}/{numberTwo}")
	public Double subtraction(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
	) {
		if (!NumberConverter.isNumber(numberOne) || !NumberConverter.isNumber(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		return SimpleMath.sum(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}

	/*
	 * Multiplicando valores com o PathVariable
	 * @param PathVariable de um numero
	 * @param PathVariable de um numero
	 * @return A multiplicação de dois números
	 * */
	@RequestMapping("/multi/{numberOne}/{numberTwo}")
	public Double multiplication(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
	) {
		if (!NumberConverter.isNumber(numberOne) || !NumberConverter.isNumber(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		return SimpleMath.multiplication(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}

	/*
	 * Divisão valores com o PathVariable
	 * @param PathVariable de um numero
	 * @param PathVariable de um numero
	 * @return A divisão de dois números
	 * */
	@RequestMapping("/div/{numberOne}/{numberTwo}")
	public Double division(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
	) {
		if (!NumberConverter.isNumber(numberOne) || !NumberConverter.isNumber(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		if (NumberConverter.convertToDouble(numberTwo) == 0) {
			throw new UnsupportedMathOperationException("Cannot divide by zero!");
		}
		return SimpleMath.division(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}

	/*
	 * Média valores com o PathVariable
	 * @param PathVariable de um numero
	 * @param PathVariable de um numero
	 * @return A média de dois números dividido por sua quantidade
	 * */
	@RequestMapping("/avarage/{numberOne}/{numberTwo}")
	public Double avarage(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
	)  {
		if (!NumberConverter.isNumber(numberOne) || !NumberConverter.isNumber(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		return SimpleMath.avarage(NumberConverter.convertToDouble(numberOne),NumberConverter.convertToDouble(numberTwo));
	}

	/*
	 * Raiz quadrada com o PathVariable
	 * @param PathVariable de um número
	 * @return A raíz quadrada de um número
	 * */
	@RequestMapping("/squareRoot/{numberOne}/{numberTwo}")
	public Double squareRoot(
			@PathVariable(value = "numberOne") String numberOne
	) {
		if (!NumberConverter.isNumber(numberOne)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		return SimpleMath.squareRoot(NumberConverter.convertToDouble(numberOne));
	}




}
