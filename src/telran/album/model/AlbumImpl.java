package telran.album.model;

import java.time.LocalDate;
import java.util.Arrays;
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
        if(findIndUsingPredicate((Photo o) -> o.getPhotoID() == photo.getPhotoID()) != -1 || size == photos.length)
            return false;
        photos[size] = photo;
        size++;
        Arrays.sort(photos,0,size);
        return true;
    }

    @Override
    public boolean removePhoto(int photoId, int albumId) {
        int ind = findIndUsingPredicate((Photo o) ->  o.getPhotoID() == photoId && o.getAlbumID() == albumId);
        if(ind == -1)
            return false;
        photos[ind] = photos[size-1];
        size--;
        Arrays.sort(photos,0,size);
        return true;
    }

    @Override
    public boolean updatePhoto(int photoId, int albumId, String url) {
      int ind = findIndUsingPredicate((Photo o) ->  o.getPhotoID() == photoId && o.getAlbumID() == albumId);
      if(ind == -1)
          return false;
      photos[ind].setUrl(url);
      return true;
    }

    @Override
    public Photo getPhotoFromAlbum(int photoId, int albumId) {
      int ind = findIndUsingPredicate((Photo o) ->  o.getPhotoID() == photoId && o.getAlbumID() == albumId);
      if(ind == -1)
          return null;
      return photos[ind];
    }

    @Override
    public Photo[] getAllPhotoFromAlbum(int albumId) {
        Photo[] res = findPhotosUsingPredicate((Photo o) -> o.getAlbumID() == albumId);
        return res;
    }

    @Override
    public Photo[] getPhotoBetweenDates(LocalDate dateFrom, LocalDate dateTo) {
        Photo[] res = findPhotosUsingPredicate((Photo o)-> o.getDate().isAfter(dateFrom) && o.getDate().isBefore(dateTo));
        return res;
    }

    @Override
    public int size() {
        return this.size;
    }

    private int findIndUsingPredicate( Predicate<Photo> predicate){
        for (int i = 0; i < size; i++) {
            if(predicate.test((Photo) photos[i])){
                return i;
            }
        }
        return -1;
    }

    private Photo[]  findPhotosUsingPredicate(Predicate<Photo> predicate){
        int count  = 0;
        for (int i = 0; i < size; i++) {
            if(predicate.test(photos[i]))
                count++;
        }
        Photo[] res = new Photo[count];
        int ind = 0;
        for (int i = 0; i < size; i++) {
            if(predicate.test(photos[i])){
                res[ind] = photos[i];
                ind++;
            }
        }
        return res;
    }
    public void printPhotos(){
        for (int i = 0; i < photos.length; i++) {
            System.out.println(photos[i]);
        }
    }
}
