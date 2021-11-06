package model;

import java.sql.Connection;
import java.util.ArrayList;

public interface Connectable {
	public void inserirNovoContato(JavaBeans contato);
	public ArrayList<JavaBeans> listarContatos();
	public JavaBeans selecionarContato(String parameter);
	public void editarContato(JavaBeans contato);
	public void deletarContato(String parameter);
}
