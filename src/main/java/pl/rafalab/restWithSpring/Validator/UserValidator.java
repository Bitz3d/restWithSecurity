package pl.rafalab.restWithSpring.Validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import pl.rafalab.restWithSpring.Const.RestWithSecurityConstants;
import pl.rafalab.restWithSpring.Model.User;
import pl.rafalab.restWithSpring.Utils.RwsUtils;

public class UserValidator implements Validator {

	public boolean supports(Class<?> arg0) {
		
		return User.class.equals(arg0);
	}

	public void validate(Object arg0, Errors errors) {
		User u = (User) arg0;
		
		ValidationUtils.rejectIfEmpty(errors, "name", "error.userName.empty");
		ValidationUtils.rejectIfEmpty(errors, "lastName", "error.userLastName.empty");
		ValidationUtils.rejectIfEmpty(errors, "email", "error.userEmail.empty");
		ValidationUtils.rejectIfEmpty(errors, "password", "error.userPassword.empty");
		ValidationUtils.rejectIfEmpty(errors, "country", "error.country");
		ValidationUtils.rejectIfEmpty(errors, "gender", "error.gender");
		
		if ("NONE".equals(u.getCountry())) {
                errors.rejectValue("country", "error.country");
        }

        if (!u.getEmail().equals(null)) {
            boolean isMatch = RwsUtils.checkEmailOrPassword(RestWithSecurityConstants.EMAIL_PATTERN, u.getEmail());
            if(!isMatch) {
                errors.rejectValue("email", "error.userEmailIsNotMatch");
            }
}
        
        if (!u.getPassword().equals(null)) {
            boolean isMatch = RwsUtils.checkEmailOrPassword(RestWithSecurityConstants.PASSWORD_PATTERN, u.getPassword());
            if(!isMatch) {
                errors.rejectValue("password", "error.userPasswordIsNotMatch");
            }
        }
        

    }

    public void validateEmailExist(User user, Errors errors) {
        if (user != null) {
            errors.rejectValue("email", "error.userEmailExist");
        }
    }
}
