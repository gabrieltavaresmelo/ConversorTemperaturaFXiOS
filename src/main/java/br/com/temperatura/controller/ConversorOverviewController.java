package br.com.temperatura.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * 
 * Essa classe (Controller) é responsável por acessar os campos da tela (View).
 * 
 * @author Gabriel Tavares - gabrieltavaresmelo@gmail.com
 * 
 */
public class ConversorOverviewController {

	private Label label = new Label("Valor");
	private Label simboloTemperaturaLabel = new Label("C");
	private TextField valorTextField = new TextField();
	private Button converterButton = new Button("Converter");
	private RadioButton celsiusRadioButton = new RadioButton("Celsius");
	private RadioButton fahrenheitRadioButton = new RadioButton("Fahrenheit");
	private Label resultadoTituloConversaoLabel = new Label("Resultado");
	private Label resultadoConversaoLabel = new Label("");
	
	private VBox rootNode = new VBox(10);
	private HBox valorNode = new HBox();
	private VBox botoesNode = new VBox();
	private HBox resultadoNode = new HBox();
	
	
	public ConversorOverviewController() {
        initializePanel();
		initialize();		
        initializeEvents();
	}

	private void initializePanel() {
		valorNode.setPadding(new Insets(5,5,5,5));
		resultadoNode.setPadding(new Insets(5,5,5,5));
		botoesNode.setPadding(new Insets(5,5,5,5));
		
		valorNode.setSpacing(10);
		resultadoNode.setSpacing(10);
		botoesNode.setSpacing(10);
		
		valorNode.setAlignment(Pos.CENTER);
		botoesNode.setAlignment(Pos.BASELINE_LEFT);
				
		valorNode.getChildren().add(label);
        valorNode.getChildren().add(valorTextField);
        valorNode.getChildren().add(simboloTemperaturaLabel);

        botoesNode.getChildren().add(celsiusRadioButton);
        botoesNode.getChildren().add(fahrenheitRadioButton);
        botoesNode.getChildren().add(converterButton);
        
        resultadoNode.getChildren().add(resultadoTituloConversaoLabel);
        resultadoNode.getChildren().add(resultadoConversaoLabel);
        		
        rootNode.setStyle("-fx-padding: 20px");        
        rootNode.getChildren().add(valorNode);   
        rootNode.getChildren().add(botoesNode);
        rootNode.getChildren().add(resultadoNode);
	}

	private void initializeEvents() {
		celsiusRadioButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
            	handleConversaoCelsius();             
            }
        });
        
        fahrenheitRadioButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
            	handleConversaoFahrenheit();
            }
        });
        
        converterButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
            	handleConverterButton();
        	}
        });
	}
	
	/**
	 * Inicializa o controlador automaticamente após o carregamento do arquivo
	 * FXML.
	 */
	private void initialize() {
		final ToggleGroup group = new ToggleGroup();
		celsiusRadioButton.setToggleGroup(group);		
		fahrenheitRadioButton.setToggleGroup(group);

		// Inicia o celsiusRadioButton selecionado
		celsiusRadioButton.setSelected(true);
		simboloTemperaturaLabel.setText("C");
	}
	
	/**
	 * Chamado quando o usuário clicar no componente visual celsiusRadioButton.
	 */
	private void handleConversaoCelsius() {
		simboloTemperaturaLabel.setText("C");
	}
	
	/**
	 * Chamado quando o usuário clicar no componente visual fahrenheitRadioButton.
	 */
	private void handleConversaoFahrenheit() {
		simboloTemperaturaLabel.setText("F");		
	}
	
	/**
	 * Chamado quando o usuário clicar no componente visual converterButton.
	 */
	private void handleConverterButton() {
//		c/5 = (f-32)/9;
		int valor = Integer.parseInt(valorTextField.getText());
		String resultado = "";
		
		if(celsiusRadioButton.isSelected()){ // Celsius -> Fahrenheit
			double f = (1.8 * valor) + 32;
			resultado = String.format("%.1f", f) + " F";
			
		} else{ // Fahrenheit -> Celsius
			double c = (double) ((valor - 32) / 1.8);
			resultado = String.format("%.1f", c) + " C";
		}
		
		resultadoConversaoLabel.setText(resultado);
	}
	
	public Node getConversorNode() {
		return rootNode;
	}
}
