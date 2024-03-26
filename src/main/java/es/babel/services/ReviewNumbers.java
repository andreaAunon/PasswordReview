package es.babel.services;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReviewNumbers implements IReviewMethodInterface{

    /**
     * Comprueba si al contraseña tiene numeros
     *
     * @return
     * Tiene devuelve 1
     * No tiene devuelve 0
     */
    @Override
    public int review(String password) {
        Pattern pattern = Pattern.compile("[0-9]");
        Matcher matcher = pattern.matcher(password);
        if(matcher.find()){
            return 1;
        }

        return 0;
    }
}
