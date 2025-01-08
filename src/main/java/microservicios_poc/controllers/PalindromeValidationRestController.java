package microservicios_poc.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador para validar input palídromo
 */
@RestController
public class PalindromeValidationRestController {

    /**
     *
     * @param input palabra a verificar
     * @return Un mensaje indicando si la palabra es un palíndromo o no
     */
    @GetMapping("/palindrome-validation/{input}")
    public String palindromeValidation(@PathVariable String input) {
        if(isPalindrome(input)) {
            return "La palabra " + input + " es un palíndromo.";
        } else {
            return "La palabra " + input + " no es un palíndromo.";
        }
    }

    /**
     *
     * @param input palabra a iterar que compara sus caracteres
     * @return true si es palíndromo, false si no lo es
     */
    private boolean isPalindrome(String input) {
        int length = input.length();
        for (int i = 0; i < length / 2; i++) {
            if(input.charAt(i) != input.charAt((length - i - 1))) {
                return false;
            }
        }
        return true;
    }
}
