package app.webApi.Services;

import app.webApi.Model.Photo;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class PhotozService {
    private Map<String, Photo> db = new HashMap<>() {{
        put("1",new Photo("1","hello.png"));
    }};

    public Collection<Photo> get() {
        return db.values();
    }

    public Photo get(String id) {
        return db.get(id);
    }

    public Photo remove(String id) {
       return db.remove(id);
    }

    public Photo saveInfo(Photo photo) {
        photo.setId(UUID.randomUUID().toString());
        db.put(photo.getId(),photo);
        return photo;
    }
    public Photo save(String fileName, String contentType, byte[] data){
        Photo photo = new Photo();
        photo.setId(UUID.randomUUID().toString());
        photo.setContentType(contentType);
        photo.setFileName(fileName);
        photo.setData(data);
        db.put(photo.getId(),photo);
        return photo;
    }
}
