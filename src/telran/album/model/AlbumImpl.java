package telran.album.model;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.function.Predicate;


public class AlbumImpl implements Album{
    private Photo[] photos;
    private int size = 0;

    public AlbumImpl(int capacity) {
        photos = new Photo[capacity];
    }

    @Override
    public boolean addPhoto(Photo photo) {

        return false;
    }

    @Override
    public boolean removePhoto(int photoId, int albumId) {
        return false;
    }

    @Override
    public boolean updatePhoto(int photoId, int albumId, String url) {
        return false;
    }

    @Override
    public Photo getPhotoFromAlbum(int photoId, int albumId) {
        return null;
    }

    @Override
    public Photo[] getAllPhotoFromAlbum(int albumId) {
        return new Photo[0];
    }

    @Override
    public Photo[] getPhotoBetweenDates(LocalDate dateFrom, LocalDate DateTo) {
        return new Photo[0];
    }

    @Override
    public int Size() {
        return 0;
    }

    private  <Photo> int findIndUsingPredicate( Predicate<Photo> predicate){
        for (int i = 0; i < size; i++) {
            if(predicate.test( photos[i])){
                return i;
            }
        }
        return 0; .
    }
}
