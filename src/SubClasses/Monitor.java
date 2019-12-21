package SubClasses;

import java.util.Date;

import Entidades.Horario;
import Entidades.Monitoria;
import Entidades.Turma;
import Servicos.Login;
import SuperClasses.Aluno;
import java.io.Serializable;

public class Monitor extends Aluno implements Login, Serializable {

    private String senha;

    private Monitoria monitoria;

    public Monitor(String nome, Long matricula, String turmaSala, String turno, String curso,
            String senha, String area) {
        super(nome, matricula, turmaSala, turno, curso);
        this.senha = senha;
        monitoria = new Monitoria(area);
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Monitoria getMonitoria() {
        return monitoria;
    }

    public void setMonitoria(Monitoria monitoria) {
        this.monitoria = monitoria;
    }

    public void cadastrarHorariComeco(Date diaHorarioMonitoria) {
        monitoria.getHorariosComeco().add(new Horario(diaHorarioMonitoria));
    }

    public void cadastrarHorarioTermino(Date diaHorarioMonitoria) {
        monitoria.getHorariosTermino().add(new Horario(diaHorarioMonitoria));
    }

    public void cadastrarTurma(Turma turma) {
        monitoria.getTurmas().add(turma);
    }

    public void cadastrarAluno(Aluno aluno, Turma turma) {
        for (Turma turmaMonitoria : monitoria.getTurmas()) {
            if (turmaMonitoria.equals(turma)) {
                turmaMonitoria.getAlunos().add(aluno);
            }
        }
    }

    @Override
    public Boolean logar(Long m, String s) {
        return getMatricula().equals(m) && getSenha().equals(s);
    }

    @Override
    public String toString() {

        String retorno = getNome()
                + " ";
        
        
        for (Aluno a : getMonitoria().getTurmas().get(0).listarFaltas().keySet()) {
            retorno += "\nAluno: " + a.getNome() + ", Faltas: " + getMonitoria().getTurmas().get(0).listarFaltas().get(a);
        }

        retorno += "\nPresencas: \n";
        for (Aluno a : getMonitoria().getTurmas().get(0).listarPresencas().keySet()) {
            retorno += "\nAluno: " + a.getNome() + ", Presencas: " + getMonitoria().getTurmas().get(0).listarPresencas().get(a);
        }

        return "\n" + retorno;
    }
}
