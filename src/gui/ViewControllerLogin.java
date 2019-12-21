package gui;

import java.net.URL;
import java.util.ResourceBundle;

import SubClasses.Monitor;
import application.Main;
import application.Memoria;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class ViewControllerLogin implements Initializable {

	@FXML
	private Button voltar;

	@FXML
	public void acaoVoltar() throws InterruptedException {
		limparCampos();
		Main.mudarTelaEntrada();
	}

	@FXML
	private TextField matricula;

	@FXML
	private PasswordField senha;

	@FXML
	private Button botaoLogar;

	@FXML
	public void acaoLogar() {
		alertar();
		Boolean bandeira = false;
		
		for (Monitor M : Memoria.monitoresCadastrados) {
			if(M.logar(Long.parseLong(matricula.getText()), senha.getText())){
				bandeira = true;
				Memoria.monitorLogadoNoMomento = M;
				break;
			}
		}
		
		if(!bandeira) {
			Alerts.showAlert("Erro", null, "Usuário ou senha inválidos", AlertType.ERROR);
		} else {
			limparCampos();
			Main.mudarTelaAcessoPrincipal();
			Main.atualizarListaDeTurmas();
		}
		
	}

	public void alertar() {
		if (matricula.getText().length() < 14 || matricula.getText() == null) {
			Alerts.showAlert("Matrícula inválida", null, "Favor, conferir!", AlertType.ERROR);
		}
		if (senha.getText().length() == 0 || senha.getText() == null) {
			Alerts.showAlert("Senha inválida", null, "Favor, conferir!", AlertType.ERROR);
		}
	}

	private void limparCampos() {
		matricula.setText("");
		senha.setText("");
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Limitacoes.LimitarTextoSoComNumeros(matricula);
		Limitacoes.regularTamanhoDoQueFoiDigitado(matricula, 14);
	}

}
