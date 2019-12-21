package Entidades;

import SuperClasses.Aluno;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Encontro implements Serializable{
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	private Date dia;
	
	private ListaDePresenca lista;

	public Encontro(Date dia) {
		this.dia = dia;
                lista = new ListaDePresenca();
	}

	public Date getDia() {
		return dia;
	}

	public void setDia(Date dia) {
		this.dia = dia;
	}

	public ListaDePresenca getLista() {
		return lista;
	}

	public void setLista(ListaDePresenca lista) {
		this.lista = lista;
	}
        
        public void chamada(Aluno aluno, Boolean presenca){
            lista.getMapDia().put(aluno, presenca);
        }
        
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dia == null) ? 0 : dia.hashCode());
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
		Encontro other = (Encontro) obj;
		if (dia == null) {
			if (other.dia != null)
				return false;
		} else if (!dia.equals(other.dia))
			return false;
		return true;
	}
	
}
