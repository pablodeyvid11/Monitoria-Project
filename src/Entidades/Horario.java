package Entidades;

import SubClasses.Monitor;
import application.Memoria;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Horario implements Serializable{
	SimpleDateFormat sdfSimplesHorario = new SimpleDateFormat("HH:mm");
	SimpleDateFormat sdfDiaSemana = new SimpleDateFormat("EEEE");
	
	private Date hora;

	public Horario(Date hora) {
		this.hora = hora;
	}
        
	/*
	 *@Override
	 *public String toString() {
	 *	StringBuilder sb = new StringBuilder();
	 *	sb.append("Hor�rio: ");
	 *	sb.append(sdfSimplesHorario.format(hora));
	 *	sb.append(" - Dia da semana: ");
	 *	sb.append(sdfDiaSemana.format(hora).toUpperCase().charAt(0) + sdfDiaSemana.format(hora).toLowerCase().substring(1));
	 *	return sb.toString();
	 *}
         */

    public Date getHora() {
        return hora;
    }
    
    public static ArrayList<horarioAcessivel> getHorariosMonitoria(){
        ArrayList<horarioAcessivel> h = new ArrayList<>();
        for(Monitor m : Memoria.monitoresCadastrados){
           h.add(new horarioAcessivel(m.getMonitoria().getArea(),m.getNome(), m.getMonitoria().getHorariosComeco(), m.getMonitoria().getHorariosTermino()));
        }
        return h;
    }
    
    @Override
    public String toString() {
    	SimpleDateFormat sdfSemana = new SimpleDateFormat("EEEE");
    	SimpleDateFormat sdfHora = new SimpleDateFormat("HH:mm");
    	
    	return sdfSemana.format(hora) + " - " + sdfHora.format(hora);
    }
}
