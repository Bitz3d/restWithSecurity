package pl.rafalab.restWithSpring.Utils;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.web.multipart.MultipartFile;

import pl.rafalab.restWithSpring.Model.User;

public class RwsUtils {
    public static boolean checkEmailOrPassword(String pattern, String toMatch) {
        Pattern p = Pattern.compile(pattern);
        Matcher matcher = p.matcher(toMatch);
        return matcher.matches();
    }
    
    public static void saveUserFile(MultipartFile multipartFile, User user) {
    	String uploadDir = System.getProperty("user.dir")+"/uploads";
    	String makeFileName = multipartFile.getOriginalFilename()+" - "+user.getEmail();
		File file;
		try {
			file = new File(uploadDir);
			if(!file.exists()){
				file.mkdir();
			}
			Path fileAndPath = Paths.get(uploadDir, makeFileName);
			Files.write(fileAndPath, multipartFile.getBytes());
			file = new File(fileAndPath.toString());
			} catch (Exception e) {
				e.printStackTrace();
			  }		
	}
}
