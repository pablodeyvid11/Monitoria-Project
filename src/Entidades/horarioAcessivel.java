package Entidades;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class horarioAcessivel {
    private String tipoMonitoria;
    private ArrayList<Horario> horariosInicio;
    private ArrayList<Horario> horariosTermino;
    private String monitor;

    public horarioAcessivel(String tipoMonitoria, String monitor, ArrayList<Horario> horariosInicio, ArrayList<Horario> horariosTermino) {
        this.tipoMonitoria = tipoMonitoria;
        this.horariosInicio = horariosInicio;
        this.horariosTermino = horariosTermino;
        this.setMonitor(monitor);
    }

    public String getTipoMonitoria() {
        return tipoMonitoria;
    }

    public void setTipoMonitoria(String tipoMonitoria) {
        this.tipoMonitoria = tipoMonitoria;
    }

    public ArrayList<Horario> getHorariosInicio() {
        return horariosInicio;
    }

    public void setHorariosInicio(ArrayList<Horario> horariosInicio) {
        this.horariosInicio = horariosInicio;
    }

    public ArrayList<Horario> getHorariosTermino() {
        return horariosTermino;
    }

    public void setHorariosTermino(ArrayList<Horario> horariosTermino) {
        this.horariosTermino = horariosTermino;
    }

    public String getMonitor() {
		return monitor;
	}

	public void setMonitor(String monitor) {
		this.monitor = monitor;
	}

	@Override
    public String toString() {
        SimpleDateFormat sdfSemana = new SimpleDateFormat("EEEE");
        SimpleDateFormat sdfHora = new SimpleDateFormat("HH:mm");
        StringBuilder saida = new StringBuilder();
        saida.append("Monitoria: " + getTipoMonitoria());
        saida.append("\nMonitor: " + getMonitor());
        if (!horariosInicio.isEmpty() && !horariosTermino.isEmpty()) {
            for (int i = 0; i < horariosInicio.size(); i++) {
                saida.append("\n" + (i+1) + "º Horário: ");
                saida.append("\nEntrada: " + sdfSemana.format(horariosInicio.get(i).getHora()) + " -> " + sdfHora.format(horariosInicio.get(i).getHora()));
                saida.append("\nSaída: " + sdfSemana.format(horariosInicio.get(i).getHora()) + " -> " + sdfHora.format(horariosTermino.get(i).getHora()));
                saida.append("\n");
            }
        }

        return saida.toString();
    }
}
