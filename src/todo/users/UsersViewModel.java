package todo.users;

import java.util.List;
import java.util.UUID;
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
	@NotifyChange("persons")
	public void add(){
		this.newPerson.setIdPersona(UUID.randomUUID().toString());
		personaDao.registrarPersona(this.newPerson);
		this.newPerson = new PersonaVO();
	}
	

}
