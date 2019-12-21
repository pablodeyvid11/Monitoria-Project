package Entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import SubClasses.Monitor;
import SuperClasses.Aluno;
import application.Memoria;

public class Turma implements Serializable {

    private long IDTurma;
    private String nome;

    private ArrayList<Aluno> alunos;
    private ArrayList<Horario> horariosComeco;
    private ArrayList<Horario> horariosTermino;
    private ArrayList<Encontro> encontros;

    public Turma(String nome) {
        this.nome = nome;    	
        this.IDTurma = gerarID();
        alunos = new ArrayList<>();
        horariosComeco = new ArrayList<>();
        horariosTermino = new ArrayList<>();
        encontros = new ArrayList<>();
    }
    
    private Integer gerarID() {
    	Integer numGerado = 0;
    	for(Monitor m : Memoria.monitoresCadastrados) {
    		for(Turma t : m.getMonitoria().getTurmas()) {
    			numGerado++;
    		}
    	}
    	return numGerado;
    }
    
    public ArrayList<Horario> getHorariosComeco() {
        return horariosComeco;
    }

    public void setHorariosComeco(ArrayList<Horario> horariosComeco) {
        this.horariosComeco = horariosComeco;
    }

    public ArrayList<Horario> getHorariosTermino() {
        return horariosTermino;
    }

    public void setHorariosTermino(ArrayList<Horario> horariosTermino) {
        this.horariosTermino = horariosTermino;
    }

    public long getIDTurma() {
        return IDTurma;
    }

    public void setIDTurma(long iDTurma) {
        IDTurma = iDTurma;
    }

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(ArrayList<Aluno> alunos) {
        this.alunos = alunos;
    }

    public ArrayList<Encontro> getEncontros() {
        return encontros;
    }

    public void setEncontros(ArrayList<Encontro> encontros) {
        this.encontros = encontros;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void registrarEncontro(Date diaDoEncontro) {
        encontros.add(new Encontro(diaDoEncontro));
    }

    public Map<Aluno, Integer> listarPresencas() {
        Map<Aluno, Integer> resultado = new TreeMap<>();

        ArrayList<Aluno> alun = new ArrayList<>();
        ArrayList<Boolean> presencas = new ArrayList<>();

        for (Encontro e : encontros) {
            Set<Aluno> setChaves = e.getLista().getMapDia().keySet();
            for (Aluno a : setChaves) {
                alun.add(a);
                presencas.add(e.getLista().getMapDia().get(a));
            }
        }

        for (int i = 0; i < alun.size(); i++) {
            if (resultado.containsKey(alun.get(i))) {
                resultado.put(alun.get(i), (resultado.get(alun.get(i)) + (presencas.get(i) ? 1 : 0)));
            } else {
                resultado.put(alun.get(i), presencas.get(i) ? 1 : 0);
            }
        }
        return resultado;
    }

    public Map<Aluno, Integer> listarFaltas() {
        Map<Aluno, Integer> resultadoFaltas = new TreeMap<>();

        ArrayList<Aluno> alunos = new ArrayList<>();
        ArrayList<Boolean> presencas = new ArrayList<>();

        for (Encontro e : encontros) {
            Set<Aluno> setChaves = e.getLista().getMapDia().keySet();
            for (Aluno a : setChaves) {
                alunos.add(a);
                presencas.add(e.getLista().getMapDia().get(a));
            }
        }

        for (int i = 0; i < alunos.size(); i++) {
            if (resultadoFaltas.containsKey(alunos.get(i))) {
                resultadoFaltas.put(alunos.get(i), (resultadoFaltas.get(alunos.get(i)) + (presencas.get(i) ? 0 : 1)));

            } else {
                resultadoFaltas.put(alunos.get(i), presencas.get(i) ? 0 : 1);
            }
        }
        return resultadoFaltas;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (IDTurma ^ (IDTurma >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Turma other = (Turma) obj;
        if (IDTurma != other.IDTurma) {
            return false;
        }
        return true;
    }

	@Override
	public String toString() {
		return IDTurma + " - " + nome;
	}
    
}
