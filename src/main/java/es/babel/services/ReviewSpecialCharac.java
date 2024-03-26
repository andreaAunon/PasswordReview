package es.babel.services;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReviewSpecialCharac implements IReviewMethodInterface{

    /**
     * Comprueba si al contraseña tiene caracteres especiales
     *
     * @return
     * Tiene devuelve 2
     * No tiene devuelve 0
     */
    @Override
    public int review(String password) {
        Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
        Matcher matcher = pattern.matcher(password);
        if(matcher.find()){
            return 2;
        }

        return 0;
    }
}
