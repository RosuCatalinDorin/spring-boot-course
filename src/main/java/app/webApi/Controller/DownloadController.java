package app.webApi.Controller;

import app.webApi.Model.Photo;
import app.webApi.Services.PhotozService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

// aici o sa folosesc depemdey injection
@RestController
public class DownloadController {
    private final PhotozService photozService;

    public DownloadController(PhotozService photozService) {
        this.photozService = photozService;
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]>  download(@PathVariable String id){
    Photo photo = photozService.get(id);
    if (null == photo) throw new ResponseStatusException(HttpStatus.NOT_FOUND);

    byte[] data = photo.getData();
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.valueOf(photo.getContentType()));
    ContentDisposition build = ContentDisposition
            .builder("attachment")
            .filename(photo.getFileName())
            .build();
    headers.setContentDisposition(build);

    return new ResponseEntity<>(data,headers, HttpStatus.OK);
}

}
