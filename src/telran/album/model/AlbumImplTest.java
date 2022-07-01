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
            album.addPhoto(photos[i]);
        }
    }

    @Test
    void testAddPhoto(){

    }
}