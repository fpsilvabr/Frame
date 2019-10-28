package br.com.frameworkQA.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

/**
 * Classe Runner do Cucumber, responsável por gerenciar as execuções dos testes.
 *
 * @author XXXX 
 * @version 1.0
 */

@RunWith(Cucumber.class)
@CucumberOptions(monochrome= true, snippets = SnippetType.CAMELCASE,
		plugin = {"pretty", "html:Reports/cucumber"},
        features = {
        		".\\src\\test\\resources\\features\\"},
        glue = {"br.com.frameworkQA.steps"},
        tags = {"@execute"})

public class RunnerTest {
	
}