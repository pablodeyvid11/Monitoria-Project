package gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import Entidades.Turma;
import application.Main;
import application.Memoria;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class ViewControllerPrincipal implements Initializable {
	@FXML
	private Button botaoSair;

	@FXML
	public void acaoBotaoSair() {
		Memoria.monitorLogadoNoMomento = null;
		Main.mudarTelaLogin();
	}
	@FXML
	private Button botaoCriarTurma;
	@FXML
	public void acaoCriarTurma() {
		Main.mudarTelaCadastrarTurma();
	}
	@FXML
	private Button botaoHorarios;
	@FXML
	public void acaoBotaoHorarios() {
		Main.mudarTelaHorariosMonitor();
		Main.atualizarListaDeHorariosMonitor();
	}
	
	@FXML
	private Button botaoMeusDados;
	@FXML
	public void acaoBotaoMeusDados() {
		Main.mudarTelaMeusDados();
		Main.atualizarDados();
	}
	
	@FXML
	private ListView<Turma> turmasListView;
	
	public static ListView<Turma> turmasListViewStatic;

	@FXML
	public void acaoClicarTurma() {
		Main.mudarTelaTurma();
		Memoria.turmaSelecionada = turmasListView.getSelectionModel().getSelectedItem();
		Main.atualizarAlunosTurma();
		ViewControllerTurma.labelNomeTurmaStatic.setText("Turma " + Memoria.turmaSelecionada.getIDTurma() + " - " + Memoria.turmaSelecionada.getNome());
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		turmasListViewStatic = turmasListView;
	}
}
