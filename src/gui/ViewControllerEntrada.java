package gui;

import application.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;

public class ViewControllerEntrada {
	@FXML
	private Button botaoLogin;
	@FXML
	public void acaoBotaoLogin() {
		Main.mudarTelaLogin();
	}
	
	@FXML
	private Button botaoCadastro;
	@FXML
	public void acaoBotaoCadstro() {
		Main.mudarTelaCadastro();
	}
	
	@FXML
	private Button botaoAreaALuno;
	@FXML
	public void acaoBotaoAreaAluno() {
		Main.mudarTelaAreaAluno();
		Main.atualizarListaDeHorariosAreaAluno();
	}
}
