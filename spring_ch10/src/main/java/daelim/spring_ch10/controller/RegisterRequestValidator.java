package daelim.spring_ch10.controller;

import daelim.spring_ch10.RegisterRequest;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterRequestValidator implements Validator {

    public static final String emailRegExp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private Pattern pattern;

    public RegisterRequestValidator(){
        this.pattern = Pattern.compile(emailRegExp);
    }


    //Validator가 검증할 수 있ㄴ는 타입인지 검사
    @Override
    public boolean supports(Class<?> clazz) {
        return RegisterRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        RegisterRequest registerRequest = (RegisterRequest) target;
        if(registerRequest.getEmail() == null || registerRequest.getEmail().trim().isEmpty()){
            errors.rejectValue("email", "required");
        }else{
            Matcher matcher = pattern.matcher(registerRequest.getEmail());
            if(!matcher.matches()){
                errors.rejectValue("email", "bad");
            }
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required");
        ValidationUtils.rejectIfEmpty(errors, "password", "required");
        ValidationUtils.rejectIfEmpty(errors, "confirmPassword", "required");

        if(!registerRequest.getPassword().isEmpty()){
            if(!registerRequest.isPasswordEqualToConfirmPassword()){
                errors.rejectValue("confirmPassword", "nomatch");
            }
        }

    }
}
