package Servicos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import SubClasses.Monitor;
import application.Memoria;

public class Serializacao{
	public static ArrayList<Monitor> carregarMonitores() {
		isExistente();
		try {
			FileInputStream in = new FileInputStream(Memoria.arquivoMonitores);
			if(in.available() > 0) {
				ObjectInputStream obj = new ObjectInputStream(in);
				return (ArrayList<Monitor>) obj.readObject();
			} else {
				return new ArrayList<>();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void AtualizarMonitores() {
            
		isExistente();
		try {
			FileOutputStream out = new FileOutputStream(Memoria.arquivoMonitores);
			ObjectOutputStream objOout = new ObjectOutputStream(out);
		
			objOout.writeObject(Memoria.monitoresCadastrados);
			objOout.close();
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException io) {
			io.printStackTrace();
		}
	}
	
	private static void isExistente() {
		File f = Memoria.arquivoMonitores;
		if (!f.exists()) {
			if (f.getParentFile() != null) {
				if (!f.getParentFile().exists()) { // pega tudo que tem antes do arquivo
					f.getParentFile().mkdirs();
				}
			}
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} 
	}
}
