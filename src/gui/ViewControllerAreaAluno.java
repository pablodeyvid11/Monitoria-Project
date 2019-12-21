package gui;

import java.net.URL;
import java.util.ResourceBundle;

import Entidades.horarioAcessivel;
import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class ViewControllerAreaAluno implements Initializable{
	@FXML
	private Button voltar;
	@FXML
	public void acaoBotaoVoltar() throws InterruptedException {
		Main.mudarTelaEntrada();
	}
	@FXML
	private ListView<horarioAcessivel> listaHorarios;
	public static ListView<horarioAcessivel> listaHorariosStatic;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		listaHorariosStatic = listaHorarios;
	}
}
