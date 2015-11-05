package todo.users;

import org.zkoss.bind.ValidationContext;
import org.zkoss.bind.validator.AbstractValidator;

public class PersonValidator extends AbstractValidator{
	
	public void validate(ValidationContext ctx){
		String rut = (String)ctx.getProperties("rut")[0].getValue();
	
		if(rut == null || "".equals(rut)){
			this.addInvalidMessage(ctx, "rut", "Entra un nombre");
		}
			
		
	}
	
}
