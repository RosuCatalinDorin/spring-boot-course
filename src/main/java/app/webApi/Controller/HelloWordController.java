package app.webApi.Controller;

import app.webApi.Model.Photo;
import app.webApi.Services.PhotozService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.UUID;

@RestController
public class HelloWordController {


  private final PhotozService photozService;

    public HelloWordController(PhotozService photozService) {
        this.photozService = photozService;
    }


    @GetMapping("/")
    public String hello() {
        return "Hello Word";
    }
    @GetMapping("/photoz/{id}")
    public Photo get(@PathVariable String id){
       Photo photo =photozService.get(id);
       if(photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
       return photo;
   }
    @GetMapping("/photoz")
    public Collection<Photo> get() {
       return photozService.get();
    }

    @DeleteMapping("/photoz/{id}")
    public void delete(@PathVariable String id){
        Photo photo =photozService.remove(id);
        if(photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
    @PostMapping("/addNewPhoto")
    public Photo create (@RequestBody @Valid Photo photo) {
        //aici se salveaza json-ul doar ca exemplu.
      return photozService.saveInfo(photo);
    }
}
