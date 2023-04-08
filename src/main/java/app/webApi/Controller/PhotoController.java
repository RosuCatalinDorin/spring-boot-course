package app.webApi.Controller;

import app.webApi.Model.Photo;
import app.webApi.Services.PhotozService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/photo")
public class PhotoController {

    private final PhotozService photozService;
    public PhotoController(PhotozService photozService) {
        this.photozService = photozService;
    }
    @PostMapping("/addNewPhoto")
    public Photo create (@RequestPart("data") MultipartFile file) throws IOException {
        return  photozService.save(file.getOriginalFilename(),file.getContentType(),file.getBytes());
    }
}

