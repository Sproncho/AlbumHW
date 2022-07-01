package telran.album.model;

import java.time.LocalDate;

public interface Album {
    public boolean addPhoto(Photo photo);
    public boolean removePhoto(int photoId, int albumId);
    public boolean updatePhoto(int photoId, int albumId, String url);
    public Photo getPhotoFromAlbum(int photoId, int albumId);
    public Photo[] getAllPhotoFromAlbum(int albumId);
    public Photo[] getPhotoBetweenDates(LocalDate dateFrom, LocalDate DateTo);
    public int Size();

}
