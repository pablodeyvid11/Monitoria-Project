package gui;

import java.net.URL;
import java.util.ResourceBundle;

import Servicos.Serializacao;
import application.Main;
import application.Memoria;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;

public class ViewControllerMeusDados implements Initializable{
	@FXML
	private Label nome;
	public static Label nomeStatic;
	
	@FXML
	private Label matricula;
	public static Label matriculaStatic;
	
	@FXML
	private Label sala;
	public static Label salaStatic;
	
	@FXML
	private Label disciplina;
	public static Label disciplinaStatic;
	
	@FXML
	private Button voltar;
	@FXML
	private void acaoVoltar() {
		Main.mudarTelaAcessoPrincipal();
	}
	
	@FXML
	private Button TrocarSenha;
	@FXML
	private void acaoTrocarSenha() {
		Main.mudarTelaTrocarSenha();
	}
	
	@FXML
	private Button mudarDados;
	@FXML
	private void acaoMudarDados() {
		Main.atualizarDadosMudarDados();
		Main.mudarTelaMudarDados();
	}
	
	@FXML
	private Button botaoApagarConta;
	@FXML
	public void acaoBotaoApagarConta() throws InterruptedException {
		Memoria.monitoresCadastrados.remove(Memoria.monitorLogadoNoMomento);
		Memoria.monitorLogadoNoMomento = null;
		Alerts.showAlert("Confirmação", null, "Monitor removido com sucesso", AlertType.CONFIRMATION);
		Serializacao.AtualizarMonitores();
		Main.mudarTelaEntrada();
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		nomeStatic = nome;
		matriculaStatic = matricula;
		salaStatic = sala;
		disciplinaStatic = disciplina;
	}
}
