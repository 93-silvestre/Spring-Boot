package br.org.generation.helloword.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Atividade1") 
public class Controller {
	
	@GetMapping
	public String HabilidadeMentalidade() {
		return "Habiladade: Atenção aos Detalhes | Mentalidade: Persistência ";
		
	}
	
	@RequestMapping("/Atividade2")
	public String Objetivos() {
		return "Objetivo será fazer bastante exercicios de fixação para "
				+ "aprimorar mais meu conhecimento dentro do bootcamp, "
				+ "ter mais calma com meu processo de aprendizagem e conseguir "
				+ "replicar tudo que foi ensinado em meu projeto integrador.";
	}

}
