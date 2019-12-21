package Entidades;

import java.io.Serializable;
import java.util.ArrayList;

public class Monitoria implements Serializable{

    private String area;
    private ArrayList<Horario> horariosComeco;
    private ArrayList<Turma> turmas;
    private ArrayList<Horario> horariosTermino;
    public Monitoria(String area) {
        this.area = area;
        horariosComeco = new ArrayList<>();
        horariosTermino = new ArrayList<>();
        turmas = new ArrayList<>();
    }

    public String getArea() {
        return area;
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

    public void setArea(String area) {
        this.area = area;
    }

  
    public ArrayList<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(ArrayList<Turma> turmas) {
        this.turmas = turmas;
    }



    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((area == null) ? 0 : area.hashCode());
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
        Monitoria other = (Monitoria) obj;
        if (area == null) {
            if (other.area != null) {
                return false;
            }
        } else if (!area.equals(other.area)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString(){
       
        return "Nome da turma: " + getTurmas().get(0).getNome() +
                "\nHorário de começo da monitoria: " + getHorariosComeco().get(0).getHora() +
                "\nHorário de término da monitoria: " + getHorariosTermino().get(0).getHora() +
                "\nNome do aluno cadastrado na turma: " + getTurmas().get(0).getAlunos().get(0).getNome()+
                "\nHorario da turma: " + getTurmas().get(0).getHorariosComeco().get(0).getHora() +
                "\nArea da monitoria: " + getArea()
                ;
    }
}
