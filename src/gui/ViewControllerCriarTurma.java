package gui;

import Entidades.Turma;
import Excecao.ErroMonitoriaException;
import Servicos.Serializacao;
import application.Main;
import application.Memoria;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ViewControllerCriarTurma {
	@FXML
	private Button BotaoConfirmar;
	@FXML
	public void acaoConfirmar() {
		try {
			alertar();
			Memoria.monitorLogadoNoMomento.cadastrarTurma(new Turma(nome.getText()));
			Alerts.showAlert("Confirmação", null, "Turma adicionada com sucesso!", AlertType.CONFIRMATION);
			Serializacao.AtualizarMonitores();
			Main.mudarTelaAcessoPrincipal();
			limparCampos();
			Main.atualizarListaDeTurmas();
		} catch (ErroMonitoriaException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	private Button BotaoCancelar;
	@FXML
	public void acaoCancelar() {
		limparCampos();
		Main.mudarTelaAcessoPrincipal();
	}
	
	@FXML
	private TextField nome;
	
	private void alertar() throws ErroMonitoriaException {
		int cont = 0;
		if(nome.getText() == null || nome.getText().length() == 0) {
			Alerts.showAlert("Erro", null, "Nome inválido!", AlertType.ERROR);
			cont++;
		}
		
		for(Turma t : Memoria.monitorLogadoNoMomento.getMonitoria().getTurmas()) {
			if(nome.getText().equals(t.getNome())) {
				Alerts.showAlert("Erro", null, "Turma já criada!", AlertType.ERROR);
				cont++;
				break;
			}
		}
		
		if(cont !=0) {
			throw new ErroMonitoriaException("Erro");
		}
		
	}
	
	private void limparCampos() {
		nome.setText("");
	}
}
