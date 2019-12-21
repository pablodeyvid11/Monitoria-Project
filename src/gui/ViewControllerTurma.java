package gui;

import java.net.URL;
import java.util.ResourceBundle;

import SuperClasses.Aluno;
import application.Main;
import application.Memoria;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class ViewControllerTurma implements Initializable{
	@FXML
	private Label labelNomeTurma;
	public static Label labelNomeTurmaStatic;
	
	@FXML
	private Button voltar;
	@FXML
	public void acaoVoltar() {
		Main.mudarTelaAcessoPrincipal();
		Memoria.turmaSelecionada = null;
	}
	
	@FXML
	private Button adicionarAluno;
	@FXML
	public void acaoAdicionarAluno() {
		
	}
	
	@FXML
	private ListView<Aluno> alunosListView;
	public static ListView<Aluno> alunosListViewStatic;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		labelNomeTurmaStatic = labelNomeTurma;
		alunosListViewStatic = alunosListView;
	}
}