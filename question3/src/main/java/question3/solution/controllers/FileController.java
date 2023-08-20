package question3.solution.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import question3.solution.models.Permission;
import question3.solution.requests.FileRequest;
import question3.solution.responses.FileMetadataResponse;
import question3.solution.services.IFileService;

@RestController
@RequestMapping("/files")
public class FileController {

    @Autowired
    private IFileService fileService;

    @PostMapping("/{folderId}")
    public ResponseEntity<Void> createFile(@PathVariable Long folderId, @RequestBody FileRequest request) {
        fileService.createFile(folderId, request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    
    @GetMapping("/{fileId}/metadata")
    public ResponseEntity<FileMetadataResponse> viewFileMetadata(@PathVariable Long fileId) {
        FileMetadataResponse metadata = fileService.getFileMetadata(fileId);
        return ResponseEntity.ok(metadata);
    }
    
    @GetMapping("/{fileId}/download")
    public ResponseEntity<byte[]> downloadFile(@PathVariable Long fileId) {
        byte[] fileData = fileService.downloadFile(fileId);
        HttpHeaders headers = new HttpHeaders();
        
        String userEmail = Permission.getUserEmail();

        // Check if the user has access to the file
        if (!fileService.hasFileAccess(fileId, userEmail)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        
        headers.setContentDispositionFormData("attachment", "filename.pdf");
        return new ResponseEntity<>(fileData, headers, HttpStatus.OK);
    }
}


