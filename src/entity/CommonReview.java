package entity;

import java.time.LocalDateTime;

public class CommonReview {
    private final String reviewID;
    private final CommonUser author;
    private final Restaurant restaurant;
    private Float rating;
    private String content;
    private final LocalDateTime creationTime;

    public CommonReview(String reviewID, CommonUser author, Restaurant restaurant, Float rating,
                  String content, LocalDateTime creationTime) {
        this.reviewID = reviewID;
        this.author = author;
        this.restaurant = restaurant;
        this.rating = rating;
        this.content = content;
        this.creationTime = creationTime;
    }

    public String getReviewID() {
        return reviewID;
    }

    public CommonUser getAuthor() {
        return author;
    }

    public Float getRating() {
        return rating;
    }

    public Restaurant getRestaurant() { return restaurant;}

    public String getContent() {
        return content;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    private void changeContent(String newContent) {
        this.content = newContent;
    }

    private void changeRating(Float newRating) {
        this.rating = newRating;
    }

    @Override
    public String toString() {
        return reviewID + "\n User: " + author.getUserID() +
                ", " + author.getUsername() +
                "\n Rating: " + rating +
                "\n CreationTime: " + creationTime;
    }
}
