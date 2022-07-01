package telran.album.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Photo implements Comparable<Photo>{
    private int albumID;
    private int photoID;
    private String title;
    private String url;
    private LocalDate date;

    public Photo(int albumID, int photoID, String title, String url, LocalDate date) {
        this.albumID = albumID;
        this.photoID = photoID;
        this.title = title;
        this.url = url;
        this.date = date;
    }

    public int getAlbumID() {
        return albumID;
    }

    public int getPhotoID() {
        return photoID;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "albumID=" + albumID +
                ", photoID=" + photoID +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", date=" + date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Photo)) return false;

        Photo photo = (Photo) o;

        if (albumID != photo.albumID) return false;
        return photoID == photo.photoID;
    }

    @Override
    public int hashCode() {
        int result = albumID;
        result = 31 * result + photoID;
        return result;
    }

    @Override
    public int compareTo(Photo o) {
        if (date.isBefore(o.date))
            return -1;
        else if(date.isAfter(o.date))
            return 1;
        else return 0;
    }

    public static class AlbumImpl {
    }
}
