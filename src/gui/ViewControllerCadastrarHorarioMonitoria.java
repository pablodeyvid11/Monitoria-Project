package gui;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

import Entidades.Horario;
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
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

public class ViewControllerCadastrarHorarioMonitoria implements Initializable {
	
	@FXML
	private Spinner<Integer> horaInicio;
	@FXML
	private Spinner<Integer> minutoInicio;
	@FXML
	private Spinner<Integer> horaFinal;
	@FXML
	private Spinner<Integer> minutoFinal;

	@FXML
	private ComboBox<String> diaSemana;

	@FXML
	private Button botaoVoltar;
	
	@FXML
	public void acaoBotaoVoltar() {
		limparCampos();
		Main.mudarTelaHorariosMonitor();
	}

	private void limparCampos() {
		diaSemana.setValue(null);
		horaInicio.getValueFactory().setValue(0);
		horaFinal.getValueFactory().setValue(0);
		minutoInicio.getValueFactory().setValue(0);
		minutoFinal.getValueFactory().setValue(0);
	}

	@FXML
	private Button botaoCadastrar;

	@FXML
	public void acaoBotaoCadastrar() {
		SimpleDateFormat sdf = new SimpleDateFormat("EEEE HH:mm");

		Date inicio = new Date();
		Date fim = new Date();
		try {
			inicio = sdf.parse(diaSemana.getValue() + " " + horaInicio.getValue() + ":" + minutoInicio.getValue());
			fim = sdf.parse(diaSemana.getValue() + " " + horaFinal.getValue() + ":" + minutoFinal.getValue());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		int contExist = 0;
		for (int i = 0; i <= Memoria.monitorLogadoNoMomento.getMonitoria().getHorariosComeco().size(); i++) {
			if(!Memoria.monitorLogadoNoMomento.getMonitoria().getHorariosComeco().isEmpty()) {
				if (sdf.format((Memoria.monitorLogadoNoMomento.getMonitoria().getHorariosComeco().get(0).getHora()))
						.equals(sdf.format(inicio))
						&& sdf.format(
								(Memoria.monitorLogadoNoMomento.getMonitoria().getHorariosTermino().get(0).getHora()))
								.equals(sdf.format(fim))) {
					contExist++;
				}
			}
		}
		
		if(contExist == 0) {
			Memoria.monitorLogadoNoMomento.getMonitoria().getHorariosComeco().add(new Horario(inicio));
			Memoria.monitorLogadoNoMomento.getMonitoria().getHorariosTermino().add(new Horario(fim));
			Main.atualizarListaDeHorariosMonitor();
			limparCampos();
			Main.mudarTelaHorariosMonitor();
			Serializacao.AtualizarMonitores();
		} else {
			Alerts.showAlert("Erro", null, "Horario já cadastrado", AlertType.ERROR);
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		SpinnerValueFactory<Integer> HI = new SpinnerValueFactory.IntegerSpinnerValueFactory(7, 22, 0);
		horaInicio.setValueFactory(HI);

		SpinnerValueFactory<Integer> HF = new SpinnerValueFactory.IntegerSpinnerValueFactory(7, 22, 0);
		horaFinal.setValueFactory(HF);

		SpinnerValueFactory<Integer> MI = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 59, 0);
		minutoInicio.setValueFactory(MI);

		SpinnerValueFactory<Integer> MF = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 59, 0);
		minutoFinal.setValueFactory(MF);

		ArrayList<String> semana = new ArrayList<String>();
		semana.add("Segunda-feira");
		semana.add("Terça-feira");
		semana.add("Quarta-feira");
		semana.add("Quinta-feira");
		semana.add("Sexta-feira");

		ObservableList<String> lista = FXCollections.observableArrayList(semana);
		diaSemana.setItems(lista);
	}

}
