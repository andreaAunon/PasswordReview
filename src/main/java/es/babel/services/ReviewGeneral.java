package es.babel.services;

import java.util.ArrayList;
import java.util.List;

public class ReviewGeneral implements IReviewMethodInterface{

    private List<IReviewMethodInterface> reviews;

    public ReviewGeneral(){
        this.reviews = new ArrayList<IReviewMethodInterface>();
    }

    public void addReviewMethod(IReviewMethodInterface reviewMethod){
        reviews.add(reviewMethod);
    }

    public void deleteReviewMethod(IReviewMethodInterface reviewMethod){
        reviews.remove(reviewMethod);
    }

    @Override
    public int review(String password) {
        int puntuacion = 0;

        for(IReviewMethodInterface reviewMethod : reviews){
            puntuacion += reviewMethod.review(password);
        }

        return puntuacion;
    }
}
