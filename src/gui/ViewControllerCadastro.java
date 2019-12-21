package gui;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import Excecao.ErroMonitoriaException;
import Servicos.Serializacao;
import SubClasses.Monitor;
import application.Main;
import application.Memoria;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class ViewControllerCadastro implements Initializable {
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	@FXML
	private Button voltar;
	@FXML
	public void acaoVoltar() throws InterruptedException{
		limparCampos();
		Main.mudarTelaEntrada();
	}
	
	@FXML
	private TextField nome;
	@FXML
	private TextField area;
	@FXML
	private TextField matricula;
	@FXML
	private PasswordField senha;
	@FXML
	private PasswordField confirmarSenha;
	@FXML
	private ComboBox<Integer> turmaSala;
	private ObservableList<Integer> obsListTurma;
	private ObservableList<String> obsListTurno;
	@FXML
	private ComboBox<String> turno;
	@FXML
	private TextField curso;
	@FXML
	private Button botaoCadastrar;
	@FXML
	public void acaoBotaoCadastrar() {
		try { 
			alertar();
			verificarMatricula();
			Monitor m = new Monitor(nome.getText(), Long.parseLong(matricula.getText()), turmaSala.getSelectionModel().getSelectedItem() +"º ano", turno.getSelectionModel().getSelectedItem(), curso.getText(), senha.getText(), area.getText());
			Memoria.monitoresCadastrados.add(m);
			Serializacao.AtualizarMonitores();
			Main.mudarTelaEntrada();
			limparCampos();
			Alerts.showAlert("Cadastro concluído", null, "Cadastro feito com sucesso!", AlertType.CONFIRMATION);
		}catch (ErroMonitoriaException e) {
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void alertar() throws ErroMonitoriaException {
		int cont = 0;
		if (nome.getText().length() == 0 || nome.getText() == null) {
			Alerts.showAlert("Nome vazio", null, "Favor, conferir!", AlertType.ERROR);
			cont++;
		}
		
		if (area.getText().length() == 0 || area.getText() == null) {
			Alerts.showAlert("Área vazia", null, "Favor, conferir!", AlertType.ERROR);
			cont++;
		}
		
		if (curso.getText().length() == 0 || curso.getText() == null) {
			Alerts.showAlert("Curso vazio", null, "Favor, conferir!", AlertType.ERROR);
			cont++;
		}
		
		if (turno.getSelectionModel().getSelectedItem() == null) {
			Alerts.showAlert("Turno vazio", null, "Favor, conferir!", AlertType.ERROR);
			cont++;
		}
		
		if (turmaSala.getSelectionModel().getSelectedItem() == null) {
			Alerts.showAlert("Turma vazia", null, "Favor, conferir!", AlertType.ERROR);
			cont++;
		}
		
		if (matricula.getText().length() == 0 || matricula.getText() == null) {
			Alerts.showAlert("Matrícula inválida", null, "Favor, conferir!", AlertType.ERROR);
			cont++;
		}
		
		if(senha.getText().length() == 0 || senha.getText() == null) {
			Alerts.showAlert("Senhas inválida", null, "Favor, conferir!", AlertType.ERROR);
			cont++;
		}
		if (confirmarSenha.getText().length() == 0 || confirmarSenha.getText() == null) {
			Alerts.showAlert("Confirmação inválida", null, "Favor, conferir!", AlertType.ERROR);
			cont++;
		}
		
		if (!senha.getText().equals(confirmarSenha.getText())) {
			Alerts.showAlert("Senhas não coincidem", null, "Favor, conferir!", AlertType.ERROR);
			cont++;
		}
		
		if(cont != 0) {
			throw new ErroMonitoriaException("");
		}
	}
	
	private void limparCampos() {
		nome.setText(null);
		area.setText(null);
		curso.setText(null);
		turno.setValue(null);
		turmaSala.setValue(null);
		matricula.setText(null);
		senha.setText(null);
		confirmarSenha.setText(null);
	}
	
	private void verificarMatricula() throws ErroMonitoriaException {
		for(Monitor m : Memoria.monitoresCadastrados) {
			if(m.getMatricula().equals(Long.parseLong(matricula.getText()))) {
				Alerts.showAlert("Erro", null, "Usuário já cadastrado!", AlertType.ERROR);
				throw new ErroMonitoriaException("Usuário já cadastrado");
			}
		}
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		List<Integer> lista = new ArrayList<>();
		lista.add(1);
		lista.add(2);
		lista.add(3);
		lista.add(4);
		
		List<String> lista2 = new ArrayList<>();
		lista2.add("Matutino");
		lista2.add("Vespertino");
		lista2.add("Noturno");
		
		obsListTurma = FXCollections.observableArrayList(lista);
		obsListTurno = FXCollections.observableArrayList(lista2);
		turmaSala.setItems(obsListTurma);
		turno.setItems(obsListTurno);
		
		Limitacoes.regularTamanhoDoQueFoiDigitado(matricula, 14);
		Limitacoes.LimitarTextoSoComNumeros(matricula);
	}
	

}
