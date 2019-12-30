package gui;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import Servicos.Serializacao;
import application.Main;
import application.Memoria;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;

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
		if(alertaApagarConta("Confirmação", null, "Você deseja realmenta apagar essa conta?", AlertType.CONFIRMATION) == 1) {
			Memoria.monitoresCadastrados.remove(Memoria.monitorLogadoNoMomento);
			Memoria.monitorLogadoNoMomento = null;
			Alerts.showAlert("Confirmação", null, "Monitor removido com sucesso", AlertType.CONFIRMATION);
			Serializacao.AtualizarMonitores();
			Main.mudarTelaEntrada();
		}
	}
	
	private int alertaApagarConta(String titulo, String cabecalho, String conteudo, AlertType tipo) {
		Alert alert = new Alert(tipo);
		alert.setTitle(titulo);
		alert.setHeaderText(cabecalho);
		alert.setContentText(conteudo);


		ButtonType botaoConfirmar = new ButtonType("Sim, desejo apagar a minha conta");
		ButtonType botaoCancelar = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);
		alert.getButtonTypes().setAll(botaoConfirmar, botaoCancelar);
		
		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == botaoConfirmar){
		    return 1;
		} else {
			return 0;
		}
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		nomeStatic = nome;
		matriculaStatic = matricula;
		salaStatic = sala;
		disciplinaStatic = disciplina;
	}
}
