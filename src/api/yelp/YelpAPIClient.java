package api.yelp;

import api.Exception.YelpRequestException;
import api.Review.ReviewCriteria;
import api.Search.SearchCriteria;
import api.response.ExceptionResponse;
import okhttp3.*;

import java.io.IOException;

public class YelpAPIClient implements YelpAPIClientInterface {
    private final String API_TOKEN = "m50nmIojrs9_k4NDBc7TeGaSoPFtLXERQpG1o17SNWvp29XQbhSveJAzFwvodpyx2PCZX8yLA-37ULJKxE-Dxno0Hlpb1RfsnSk_3fWjEadWEjs9MPmpOQbhwHxMZXYx";
    private final YelpURIs yelpURIs;
    public Response response;

    public YelpAPIClient(YelpURIs yelpURIs) {
        this.yelpURIs = yelpURIs;
    }

    @Override
    public void allRestaurantsMatching(SearchCriteria criteria) {
        getFrom(yelpURIs.getRestaurantURIWithCriteria(criteria));
    }

    @Override
    public void RestaurantIDMatching(String id) {
        getFrom(yelpURIs.getRestaurantURIByID(id));
    }

    @Override
    public void ReviewIDMatching(ReviewCriteria criteria) {
        getFrom(yelpURIs.getReviewsURI(criteria));
    }

    @Override
    public String getResponseBody() {
        try {
            if (response.body() != null) {
                return response.body().string();
            }
            return null;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void getFrom(String API_URI) throws YelpRequestException {
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(API_URI)
                    .addHeader("Authorization", String.format("Bearer %s", API_TOKEN))
                    .build();
            response = client.newCall(request).execute();
            checkStatus(API_URI);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void checkStatus(String API_URI) {
        try {
            if (response.code() != 200) {
                ExceptionResponse exceptionResponse = new ExceptionResponse(response.body().string(), response.code(), API_URI);
                throw exceptionResponse.getYelpException();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
