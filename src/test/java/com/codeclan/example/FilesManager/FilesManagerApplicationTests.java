package com.codeclan.example.FilesManager;

import com.codeclan.example.FilesManager.models.File;
import com.codeclan.example.FilesManager.models.Folder;
import com.codeclan.example.FilesManager.models.User;
import com.codeclan.example.FilesManager.repositories.FileRepository;
import com.codeclan.example.FilesManager.repositories.FolderRepository;
import com.codeclan.example.FilesManager.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
class FilesManagerApplicationTests {

	@Autowired
	private FileRepository fileRepository;


	@Autowired
	private FolderRepository folderRepository;

	@Autowired
	private UserRepository userRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void canCreateAndSaveUserObjects() {

		User user = new User("Mike");
		userRepository.save(user);

		Folder apps = new Folder("Apps", user);
		folderRepository.save(apps);

		assertEquals("Mike", user.getName());
	}
}
//	@Test
//	public void canSetupFilesAndFolders(){
//		File file = new File("flags","java",100););
//		fileRepository.save(file);
//
//		User user = new User("Mike");
//		UserRepository.save(user);
//
//
//	}




