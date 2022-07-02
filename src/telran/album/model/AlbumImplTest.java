package telran.album.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class AlbumImplTest {
    AlbumImpl album;
    Photo[] photos;
    @BeforeEach
    void setUp(){
        photos = new Photo[] {
                new Photo(1,24,"asass","/home", LocalDate.of(2022,11,10)),
                new Photo(2,23,"asdfsaas","/home", LocalDate.of(2021,10,11) ),
                new Photo(2,25,"asdfsgas","/home", LocalDate.of(2022,12,11)),
                new Photo(1,21,"dsfg","/home",LocalDate.of(2012,1,23)),
                new Photo(1,22,"asadsfs","/home", LocalDate.of(2014,5,12))
        };
        album = new AlbumImpl(14);
        for (int i = 0; i < photos.length; i++) {
            boolean res = album.addPhoto(photos[i]);
           // System.out.println(res);
        }
    }

    @Test
    void testAddPhoto(){
        int size = album.size();
        boolean res = album.addPhoto(new Photo(1,26,"asadsfs","/home", LocalDate.of(2025,5,12)));
        assertTrue(res);
        assertEquals(size+1,album.size());
    }

    @Test
    void testDeletePhoto(){
        int size = album.size();
        boolean res = album.removePhoto(24,1);
        assertTrue(res);
        assertEquals(size - 1, album.size());

    }
    @Test
    void testUpdatePhoto(){
        album.updatePhoto(24,1,"/trash");
        Photo photo = album.getPhotoFromAlbum(24,1);
        assertEquals("/trash",photo.getUrl());
    }

    @Test
    void testgetAllPhotosFromAlbum(){
        Photo[] expected = {
                new Photo(1,21,"dsfg","/home",LocalDate.of(2012,1,23)),
                new Photo(1,22,"asadsfs","/home", LocalDate.of(2014,5,12)),
                new Photo(1,24,"asass","/home", LocalDate.of(2022,11,10))
        };
        Photo[] res = album.getAllPhotoFromAlbum(1);
        assertArrayEquals(expected,res);
    }
    @Test
    void testgetPhotoBetweenDates(){
        Photo[] expected = new Photo[] {
                new Photo(1,21,"dsfg","/home",LocalDate.of(2012,1,23)),
                new Photo(1,22,"asadsfs","/home", LocalDate.of(2014,5,12))
        };
        Photo[] actual = album.getPhotoBetweenDates(LocalDate.of(2010,01,01),LocalDate.of(2020,01,01));
        assertArrayEquals(expected,actual);
    }
}