package infoarantes.primeiraapi.services.validation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//@Constraint(validatedBy = NomeValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface ClienteInsert {
//    String message() default "Erro de validação";
//    Class<?>[] groups() default {};
//    Class<? extends Payloa>[] payload() default {};
}
