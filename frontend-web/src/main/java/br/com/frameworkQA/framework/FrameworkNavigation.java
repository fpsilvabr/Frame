package br.com.frameworkQA.framework;

import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.WebDriver.Navigation;

/**
 * @author XXXX
 *
 */
public class FrameworkNavigation implements Navigation {

	private Navigation navigation;
	private FrameworkUtils utils;

	public FrameworkNavigation(HashMap<String, String> propertyMap, FrameworkUtils utils, Navigation navigation) {
		this.navigation = navigation;
		this.utils = utils;
	}

	public void back() {
		this.navigation.back();
	}

	public void forward() {
		this.navigation.forward();
	}

	public void refresh() {
		this.navigation.refresh();
	}

	public void to(String arg0) {
		this.navigation.to(arg0);
		this.utils.addLogStep("Passed", "A página foi exibida com sucesso", "A página não foi exibida com sucesso");
	}

	public void to(URL arg0) {
		this.navigation.to(arg0);
	}

}
