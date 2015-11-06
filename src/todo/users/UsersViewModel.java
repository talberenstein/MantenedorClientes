package todo.users;

import java.util.List;
import java.util.UUID;

import javax.swing.JOptionPane;

import prueba.dao.PersonaDAO;
import prueba.vo.PersonaVO;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;


public class UsersViewModel {
	
	private PersonaDAO personaDao = new PersonaDAO();
	private PersonaVO selectedPerson, newPerson = new PersonaVO();
	
	public PersonaVO getSelectedPerson(){
		return selectedPerson;
	}
	
	public void setSelectedPerson(PersonaVO selectedPerson){
		this.selectedPerson = selectedPerson;
	}
	
	public PersonaVO getNewPerson(){
		return newPerson;
	}
	
	public void setNewPerson(PersonaVO newPerson){
		this.newPerson = newPerson;
	}
	
	public List<PersonaVO> getPersons(){
		return PersonaDAO.listaDePersonas();
	}
	
	@Command("add")
	@NotifyChange("person")
	public void add(){
		String a="hola";
		System.out.println("Hola");
		  JOptionPane.showMessageDialog(null, "ingresando "+UUID.randomUUID().toString());
		this.newPerson.setIdPersona(a);
		personaDao.registrarPersona(this.newPerson);
		this.newPerson = new PersonaVO();
	}
	

}
