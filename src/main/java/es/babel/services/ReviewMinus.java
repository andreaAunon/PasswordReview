package es.babel.services;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReviewMinus implements IReviewMethodInterface{

    @Override
    public int review(String password) {
        Pattern pattern = Pattern.compile("[a-z]");
        Matcher matcher = pattern.matcher(password);
        if(matcher.find()){
            return 1;
        }

        return 0;
    }
}
