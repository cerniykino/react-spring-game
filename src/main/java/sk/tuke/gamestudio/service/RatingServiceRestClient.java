package sk.tuke.gamestudio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import sk.tuke.gamestudio.entity.Rating;
@Service
public class RatingServiceRestClient implements RatingService{

    private String url = "http://localhost:8080/api/rating";

    //@Autowired(required = false)
    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public void setRating(Rating rating) throws RatingException {
        restTemplate.postForEntity(url, rating, Rating.class);
    }

    @Override
    public double getAverageRating(String game) throws RatingException {
        return restTemplate.getForEntity(url + "/" + game , Double.class).getBody();
    }

    @Override
    public int getRating(String game, String player) throws RatingException {
        return restTemplate.getForEntity(url + "/" + game + "/" + player, Integer.class).getBody();
    }

    @Override
    public void reset() throws RatingException {
        throw new UnsupportedOperationException("Not supported via web service");
    }
}
