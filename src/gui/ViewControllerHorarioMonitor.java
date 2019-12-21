package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Entidades.Horario;
import Servicos.Serializacao;
import application.Main;
import application.Memoria;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ToggleButton;

public class ViewControllerHorarioMonitor implements Initializable{
	@FXML
	private Button botaoVoltar;
	@FXML
	public void acaoBotaoVoltar() {
		Main.mudarTelaAcessoPrincipal();
	}
	
	@FXML
	private Button botaoCadastrar;
	@FXML
	public void acaoBotaoCadastrar() {
		Main.mudarTelaNovoHorariosMonitor();
	}
	
	@FXML
	private ListView<Horario> listHorariosInicio;
	@FXML
	private ListView<Horario> listHorariosFinal;
	
	public static ListView<Horario> listHorariosInicioStatic;
	public static ListView<Horario> listHorariosFinalStatic;
	
	@FXML
	private ToggleButton botaoApagar;
	@FXML
	public void mudancaDeEstadoBotaoApagar() {
		if(botaoApagar.selectedProperty().get()) {
			labelApagar.setVisible(true);
		} else {
			labelApagar.setVisible(false);
		}
	}
	
	@FXML
	public void acaoSelecionarObjetoListaComeco() {
		if(botaoApagar.selectedProperty().get()) {
			Memoria.monitorLogadoNoMomento.getMonitoria().getHorariosTermino().remove(Memoria.monitorLogadoNoMomento.getMonitoria().getHorariosComeco().indexOf(listHorariosInicio.getSelectionModel().getSelectedItem()));
			Memoria.monitorLogadoNoMomento.getMonitoria().getHorariosComeco().remove(listHorariosInicio.getSelectionModel().getSelectedItem());
			Main.atualizarListaDeHorariosMonitor();
			Serializacao.AtualizarMonitores();
			botaoApagar.selectedProperty().set(false);
			labelApagar.setVisible(false);
		}
	}
	
	@FXML
	public void acaoSelecionarObjetoListaTermino() {
		if(botaoApagar.selectedProperty().get()) {
			Memoria.monitorLogadoNoMomento.getMonitoria().getHorariosComeco().remove(Memoria.monitorLogadoNoMomento.getMonitoria().getHorariosTermino().indexOf(listHorariosFinal.getSelectionModel().getSelectedItem()));
			Memoria.monitorLogadoNoMomento.getMonitoria().getHorariosTermino().remove(listHorariosFinal.getSelectionModel().getSelectedItem());
			
			Main.atualizarListaDeHorariosMonitor();
			Serializacao.AtualizarMonitores();
			botaoApagar.selectedProperty().set(false);
			labelApagar.setVisible(false);
		}
	}
	
	@FXML
	private Label labelApagar;
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		labelApagar.setVisible(false);
		listHorariosInicioStatic = listHorariosInicio;
		listHorariosFinalStatic = listHorariosFinal;
	}
}
