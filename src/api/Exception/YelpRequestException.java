package api.Exception;


public class YelpRequestException extends RuntimeException{
    public YelpRequestException(int statusCode, String url, String description) {
        super(String.format("HTTP Error occurred%nStatus code: %d%nURL: %s%nDescription: %s",
            statusCode,
            url,
            description));
    }
}
