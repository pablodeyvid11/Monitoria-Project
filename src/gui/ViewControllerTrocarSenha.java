package gui;

import java.net.URL;
import java.util.ResourceBundle;

import Excecao.ErroMonitoriaException;
import Servicos.Serializacao;
import application.Main;
import application.Memoria;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;

public class ViewControllerTrocarSenha implements Initializable {
	@FXML
	private PasswordField senhaAntiga;
	@FXML
	private PasswordField novaSenha;
	@FXML
	private PasswordField confirmarNovaSenha;

	@FXML
	private Button botaoConfirmar;

	@FXML
	public void acaoBotaoConfirmar() {
		
		try {
			alertar();
			if (Memoria.monitorLogadoNoMomento.getSenha().equals(senhaAntiga.getText())) {
				if (novaSenha.getText().equals(confirmarNovaSenha.getText())) {
					Memoria.monitorLogadoNoMomento.setSenha(novaSenha.getText());
					Serializacao.AtualizarMonitores();
					Alerts.showAlert("Senha alterada", null, "Senha alterada com sucesso!", AlertType.CONFIRMATION);
					Main.mudarTelaMeusDados();
					
				} else {
					Alerts.showAlert("Erro", null, "A senha e sua confirmação não coincidem", AlertType.ERROR);
				}
			} else {
				Alerts.showAlert("Erro", null, "Senha antiga inválida", AlertType.ERROR);
			}
		} catch (ErroMonitoriaException e) {
			e.printStackTrace();
		}
	}

	private void alertar() throws ErroMonitoriaException {
		if (senhaAntiga.getText().length() == 0) {
			Alerts.showAlert("Erro", null, "Senha antiga inválida", AlertType.ERROR);
			throw new ErroMonitoriaException("Problema de senha");
		}
		if (novaSenha.getText().length() == 0) {
			Alerts.showAlert("Erro", null, "Nova senha inválida", AlertType.ERROR);
			throw new ErroMonitoriaException("Problema de senha");
		}
		if (confirmarNovaSenha.getText().length() == 0) {
			Alerts.showAlert("Erro", null, "Confirmação de senha inválida", AlertType.ERROR);
			throw new ErroMonitoriaException("Problema de senha");
		}
	}

	private void limparCampos() {
		senhaAntiga.setText("");
		novaSenha.setText("");
		confirmarNovaSenha.setText("");
	}

	@FXML
	private Button botaoCancelar;
	@FXML
	public void acaoBotaoCancelar() {
		limparCampos();
		Main.mudarTelaMeusDados();
	}
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		limparCampos();
	}
}
