package application;

import java.text.ParseException;
import java.util.List;

import Entidades.Horario;
import Entidades.Turma;
import Entidades.horarioAcessivel;
import Servicos.Serializacao;
import SubClasses.Monitor;
import SuperClasses.Aluno;
import gui.ViewControllerAreaAluno;
import gui.ViewControllerHorarioMonitor;
import gui.ViewControllerMeusDados;
import gui.ViewControllerMudarDados;
import gui.ViewControllerPrincipal;
import gui.ViewControllerTurma;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) throws ParseException {
		Memoria.monitorLogadoNoMomento = null;
		Memoria.turmaSelecionada = null;
		Memoria.monitoresCadastrados = Serializacao.carregarMonitores();
		launch(args);
	}

	private static Stage mainStage;

	private static Scene logintela;
	private static Scene cadastrotela;
	private static Scene telaPrincipal;
	private static Scene telaEntrada;
	private static Scene telaAreaALuno;
	private static Scene telaCadastrarTurma;
	private static Scene telaHorariosMonitor;
	private static Scene telaNovoHorarioMonitor;
	private static Scene telaMeusDados;
	private static Scene telaTrocarSenha;
	private static Scene telaMudarDados;
	private static Scene telaTurma;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			mainStage = primaryStage;
			mainStage.getIcons().add(new Image(getClass().getResourceAsStream("/icones/SimboloMonitoria.png")));

			Parent LoginTela = FXMLLoader.load(getClass().getResource("/gui/ViewLogin.fxml"));
			logintela = new Scene(LoginTela);

			Parent areaAluno = FXMLLoader.load(getClass().getResource("/gui/ViewAreaAluno.fxml"));
			telaAreaALuno = new Scene(areaAluno);

			Parent CadastroTela = FXMLLoader.load(getClass().getResource("/gui/ViewCadastro.fxml"));
			cadastrotela = new Scene(CadastroTela);

			Parent principal = FXMLLoader.load(getClass().getResource("/gui/ViewPrincipal.fxml"));
			telaPrincipal = new Scene(principal);

			Parent entrada = FXMLLoader.load(getClass().getResource("/gui/ViewEntrada.fxml"));
			telaEntrada = new Scene(entrada);

			Parent cadastrarTurma = FXMLLoader.load(getClass().getResource("/gui/ViewCriarTurma.fxml"));
			telaCadastrarTurma = new Scene(cadastrarTurma);

			Parent horariosMonitor = FXMLLoader.load(getClass().getResource("/gui/ViewHorarioMonitor.fxml"));
			telaHorariosMonitor = new Scene(horariosMonitor);

			Parent novoHorarioMonitor = FXMLLoader
					.load(getClass().getResource("/gui/ViewCadastrarHorarioMonitoria.fxml"));
			telaNovoHorarioMonitor = new Scene(novoHorarioMonitor);

			Parent meusDados = FXMLLoader.load(getClass().getResource("/gui/ViewMeusDados.fxml"));
			telaMeusDados = new Scene(meusDados);

			Parent trocarSenha = FXMLLoader.load(getClass().getResource("/gui/ViewTrocarSenha.fxml"));
			telaTrocarSenha = new Scene(trocarSenha);

			Parent mudarDados = FXMLLoader.load(getClass().getResource("/gui/ViewMudarDados.fxml"));
			telaMudarDados = new Scene(mudarDados);
			
			Parent turma = FXMLLoader.load(getClass().getResource("/gui/ViewTurma.fxml"));
			telaTurma = new Scene(turma);

			adicionarCSS();
			mudarTelaEntrada();
			mainStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void adicionarCSS() {
		telaAreaALuno.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		telaPrincipal.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		logintela.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		cadastrotela.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		telaEntrada.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		telaCadastrarTurma.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		telaHorariosMonitor.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		telaNovoHorarioMonitor.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		telaMeusDados.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		telaTrocarSenha.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		telaMudarDados.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		telaTurma.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	}
	
	public static void mudarTelaTurma() {
		mainStage.setTitle("Turmas");
		mainStage.setScene(telaTurma);
	}
	
	public static void mudarTelaMudarDados() {
		mainStage.setTitle("Mudar Dados");
		mainStage.setScene(telaMudarDados);
	}

	public static void mudarTelaTrocarSenha() {
		mainStage.setTitle("Trocar Senha");
		mainStage.setScene(telaTrocarSenha);
	}

	public static void mudarTelaMeusDados() {
		mainStage.setTitle("Meus Dados");
		mainStage.setScene(telaMeusDados);
	}

	public static void mudarTelaNovoHorariosMonitor() {
		mainStage.setTitle("Cadastrar horário de monitoria");
		mainStage.setScene(telaNovoHorarioMonitor);
	}

	public static void mudarTelaHorariosMonitor() {
		mainStage.setTitle("Horários Monitoria");
		mainStage.setScene(telaHorariosMonitor);
	}

	public static void mudarTelaCadastrarTurma() {
		mainStage.setTitle("Cadastro de turmas ");
		mainStage.setScene(telaCadastrarTurma);
	}

	public static void mudarTelaAcessoPrincipal() {
		mainStage.setTitle("Olá " + Memoria.monitorLogadoNoMomento.getNome());
		mainStage.setScene(telaPrincipal);
	}

	public static void mudarTelaAreaAluno() {
		mainStage.setTitle("Horários de Monitoria");
		mainStage.setScene(telaAreaALuno);
	}

	public static void mudarTelaEntrada() throws InterruptedException {
		mainStage.setTitle("IF- Monitoria");
		mainStage.setScene(telaEntrada);
	}

	public static void mudarTelaLogin() {
		mainStage.setTitle("Login");
		mainStage.setScene(logintela);
	}

	public static void mudarTelaCadastro() {
		mainStage.setTitle("Cadastro");
		mainStage.setScene(cadastrotela);
	}

	public static void LogarSistema(Monitor M) {
		Memoria.monitorLogadoNoMomento = M;
		mudarTelaAcessoPrincipal();
	}
	
	public static void atualizarAlunosTurma() {
		List<Aluno> alunosList = Memoria.turmaSelecionada.getAlunos();
		ObservableList<Aluno> obsListAluno = FXCollections.observableArrayList(alunosList);
		ViewControllerTurma.alunosListViewStatic.setItems(obsListAluno);
	}
	
	public static void atualizarDados() {
		ViewControllerMeusDados.nomeStatic.setText(Memoria.monitorLogadoNoMomento.getNome());
		ViewControllerMeusDados.matriculaStatic.setText(Memoria.monitorLogadoNoMomento.getMatricula() + "");
		ViewControllerMeusDados.disciplinaStatic.setText(Memoria.monitorLogadoNoMomento.getMonitoria().getArea());
		String textoTurma = Memoria.monitorLogadoNoMomento.getTurmaSala() + " de "
				+ Memoria.monitorLogadoNoMomento.getCurso() + " - " + Memoria.monitorLogadoNoMomento.getTurno() + ".";
		ViewControllerMeusDados.salaStatic.setText(textoTurma);
	}

	public static void atualizarListaDeTurmas() {
		ObservableList<Turma> obsListTurmas;
		List<Turma> turmasList;
		turmasList = Memoria.monitorLogadoNoMomento.getMonitoria().getTurmas();
		obsListTurmas = FXCollections.observableArrayList(turmasList);
		ViewControllerPrincipal.turmasListViewStatic.setItems(obsListTurmas);
	}

	public static void atualizarListaDeHorariosMonitor() {
		ObservableList<Horario> horariosInicio = FXCollections
				.observableArrayList(Memoria.monitorLogadoNoMomento.getMonitoria().getHorariosComeco());
		ObservableList<Horario> horariosFinal = FXCollections
				.observableArrayList(Memoria.monitorLogadoNoMomento.getMonitoria().getHorariosTermino());
		ViewControllerHorarioMonitor.listHorariosInicioStatic.setItems(horariosInicio);
		ViewControllerHorarioMonitor.listHorariosFinalStatic.setItems(horariosFinal);
	}

	public static void atualizarListaDeHorariosAreaAluno() {
		ObservableList<horarioAcessivel> horas = FXCollections.observableArrayList(Horario.getHorariosMonitoria());
		ViewControllerAreaAluno.listaHorariosStatic.setItems(horas);
	}

	public static void atualizarDadosMudarDados() {
		ViewControllerMudarDados.nomeStatic.setText(Memoria.monitorLogadoNoMomento.getNome());
		ViewControllerMudarDados.comboAnoStatic
				.setValue(Integer.parseInt(Memoria.monitorLogadoNoMomento.getTurmaSala().charAt(0) + ""));
	}
}