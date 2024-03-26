package es.babel.services;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReviewMayus implements IReviewMethodInterface{

    /**
     * Comprueba si al contraseña tiene mayus o minus
     *
     * @return
     * Tiene mayus o minus devuelve 1
     * Tiene ambas devuelve 2
     * No tiene ninguna devuelve 0
     */
    @Override
    public int review(String password) {
        Pattern pattern = Pattern.compile("[A-Z]");
        Matcher matcher = pattern.matcher(password);
        if(matcher.find()){
            return 1;
        }

        return 0;
    }
}
