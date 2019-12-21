
package application;

import java.io.File;
import java.util.ArrayList;

import Entidades.Turma;
import Excecao.ErroMonitoriaException;
import Servicos.Serializacao;
import SubClasses.Monitor;

public class Memoria {
    public static void adicionarMonitor(Monitor m) throws ErroMonitoriaException{
        if(!monitoresCadastrados.isEmpty()){
            for (Monitor monitor : monitoresCadastrados) {
                if (monitor.equals(m)) {
                    throw new ErroMonitoriaException("Monitor já cadastrado");
                }
            }
        }
        monitoresCadastrados.add(m);
        Serializacao.AtualizarMonitores();
    }
    
     
    public static  ArrayList<Monitor> monitoresCadastrados;
    public static File arquivoMonitores = new File("Arquivos/arquivoMonitores.txt");
    public static Monitor monitorLogadoNoMomento;
    public static Turma turmaSelecionada;
}
