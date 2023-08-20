package question3.solution.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import question3.solution.requests.FolderRequest;
import question3.solution.services.IFolderService;

@RestController
@RequestMapping("/folders")
public class FolderController {

    @Autowired
    private IFolderService folderService;

    @PostMapping("/{spaceId}")
    public ResponseEntity<Void> createFolder(@PathVariable Long spaceId, @RequestBody FolderRequest request) {
        folderService.createFolder(spaceId, request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}


