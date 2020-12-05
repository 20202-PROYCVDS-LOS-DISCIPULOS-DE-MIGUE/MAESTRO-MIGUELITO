package edu.eci.cvds.sampleprj.dao;

import edu.eci.cvds.samples.entities.Elemento;
import java.util.ArrayList;

public interface ElementoDAO {
    public void registrarElemento(String tipo,String marca);
    public Elemento getElemento(int idElemento);
    public ArrayList<Elemento> getElementos();
<<<<<<< HEAD
	public ArrayList<Elemento> getElementosDisponibles();
	public void asociarElemento(int idElemento,int equipo);
	public void darDeBajaElemento(int idElemento);
<<<<<<< HEAD
=======
=======
    public ArrayList<Elemento> getElementosDisponibles();
    public void eliminarElemento (int idElemento, String marca);
>>>>>>> 52237dc0af5f18e942d3d191081de6417965e8fa
>>>>>>> 887c69887ffe3b0f1d5ce89f473246ed57c061ca
}

