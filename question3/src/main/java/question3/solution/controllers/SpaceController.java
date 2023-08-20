package question3.solution.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import question3.solution.requests.SpaceRequest;
import question3.solution.services.ISpaceService;

@RestController
@RequestMapping("/spaces")
public class SpaceController {

    @Autowired
    private ISpaceService spaceService;

    @PostMapping
    public ResponseEntity<Void> createSpace(@RequestBody SpaceRequest request) {
        spaceService.createSpace(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}

