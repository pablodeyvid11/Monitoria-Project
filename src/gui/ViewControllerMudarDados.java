package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import Excecao.ErroMonitoriaException;
import Servicos.Serializacao;
import application.Main;
import application.Memoria;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class ViewControllerMudarDados implements Initializable{
	@FXML
	private TextField nome;
	public static TextField nomeStatic;
	
	@FXML
	private ComboBox<Integer> comboAno;
	public static ComboBox<Integer> comboAnoStatic;
	
	@FXML
	private Button botaoConfirmar;
	@FXML
	public void acaoBotaoConfirmar() {
		try {
			alertar();
			
			Memoria.monitorLogadoNoMomento.setNome(nome.getText());
			Memoria.monitorLogadoNoMomento.setTurmaSala(comboAno.getSelectionModel().getSelectedItem() + "º ano");
			Serializacao.AtualizarMonitores();
			Alerts.showAlert("Dados alterados", null, "Dados alterados com sucesso", AlertType.CONFIRMATION);
			Main.mudarTelaMeusDados();
			Main.atualizarDados();
		} catch (ErroMonitoriaException e) {
			e.printStackTrace();
		}
		
	}
	
	@FXML
	private Button botaoCancelar;
	@FXML
	public void acaoBotatoCancelar() {
		Main.mudarTelaMeusDados();
	}
	
	private void alertar() throws ErroMonitoriaException {
		if(comboAno.getSelectionModel().getSelectedItem() == null) {
			Alerts.showAlert("Erro", null, "Ano selecionado inválido", AlertType.ERROR);
			throw new ErroMonitoriaException("Erro de ano");
		}
		if(nome.getText().length() == 0) {
			Alerts.showAlert("Erro", null, "Nome inválidp", AlertType.ERROR);
			throw new ErroMonitoriaException("Erro de nome");
		}
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		List<Integer> lista = new ArrayList<>();
		lista.add(1);
		lista.add(2);
		lista.add(3);
		lista.add(4);
		ObservableList<Integer> obsList = FXCollections.observableArrayList(lista);
		comboAno.setItems(obsList);
		
		nomeStatic = nome;
		comboAnoStatic = comboAno;
	}
	
}
