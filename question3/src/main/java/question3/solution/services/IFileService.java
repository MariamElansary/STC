package question3.solution.services;

import question3.solution.responses.FileMetadataResponse;
import question3.solution.requests.FileRequest;

public interface IFileService {

	void createFile(Long folderId, FileRequest request);

	FileMetadataResponse getFileMetadata(Long fileId);

	byte[] downloadFile(Long fileId);

	boolean hasFileAccess(Long fileId, String userEmail);

}
