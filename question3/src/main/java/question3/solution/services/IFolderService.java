package question3.solution.services;

import question3.solution.requests.FolderRequest;

public interface IFolderService {

	void createFolder(Long spaceId, FolderRequest request);

}
