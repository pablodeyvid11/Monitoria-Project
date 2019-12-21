package SuperClasses;

import java.io.Serializable;

public class Aluno implements Serializable, Comparable<Aluno>{
	private String nome;
	private Long matricula;
	private String turmaSala;
	private String turno;
	private String curso;
	public Aluno(String nome, Long matricula, String turmaSala, String turno, String curso) {
		this.nome = nome;
		this.matricula = matricula;
		this.turmaSala = turmaSala;
		this.turno = turno;
		this.curso = curso;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Long getMatricula() {
		return matricula;
	}
	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}
	public String getTurmaSala() {
		return turmaSala;
	}
	public void setTurmaSala(String turmaSala) {
		this.turmaSala = turmaSala;
	}
	public String getTurno() {
		return turno;
	}
	public void setTurno(String turno) {
		this.turno = turno;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
        
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}

    @Override
    public int compareTo(Aluno a) {
        return getNome().compareTo(a.getNome());
    }
}
