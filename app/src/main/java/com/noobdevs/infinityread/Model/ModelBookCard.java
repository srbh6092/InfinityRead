package com.noobdevs.infinityread.Model;

public class ModelBookCard
{
    private String bookName , points , userFullName , stars , bookMainPic ;
    private int photosCount ;

    public ModelBookCard(String bookName, String points, String userFullName, String stars, String bookMainPic, int photosCount)
    {
        this.bookName = bookName;
        this.points = points;
        this.userFullName = userFullName;
        this.stars = stars;
        this.photosCount = photosCount;
        this.bookMainPic = bookMainPic;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getpoints() {
        return points;
    }

    public void setpoints(String points) {
        points = points;
    }

    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    public String getStars() {
        return stars;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }

    public int getPhotosCount() {
        return photosCount;
    }

    public void setPhotosCount(int photosCount) {
        this.photosCount = photosCount;
    }

    public String getBookMainPic() {
        return bookMainPic;
    }

    public void setBookMainPic(String bookMainPic) {
        this.bookMainPic = bookMainPic;
    }
}
