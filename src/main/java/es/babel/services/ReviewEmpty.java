package es.babel.services;

public class ReviewEmpty implements IReviewMethodInterface{

    @Override
    public int review(String password) {
        if(password.equals("")){
            return -1;
        }

        return 0;
    }
}
