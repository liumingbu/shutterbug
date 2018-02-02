package cn.photo.shutterbug.utils;

import java.io.File;
import java.io.FileOutputStream;

public class FileUtils {
	
	/**
	 * 系统文件存储路径 ： 从application中获取
	 */
	private final static String APP_FILEPATH = "D://pet/file/";
	
	/**
	 * 将字节流文件存到指定位置中
	 * @param file  字节流数据
	 * @param filePath	存储的文件路径  
	 * @param fileName	文件名称
	 * @throws Exception
	 */
	public static String uploadFile(byte[] file,String filePath,String fileName) throws Exception {
        File targetFile = new File(APP_FILEPATH+filePath);  
        if(!targetFile.exists()){    
            targetFile.mkdirs();    
        }
        FileOutputStream out = new FileOutputStream(APP_FILEPATH + filePath+fileName);
        out.write(file);
        out.flush();
        out.close();
        return filePath+fileName;
    }
	
	/**
	 * 删除文件
	 * @param url 文件路径（包含文件名）
	 * @throws Exception
	 */
	public static void deleteFile(String url) throws Exception {
		File oldFile = new File(APP_FILEPATH+url);
		if(oldFile.exists()){
			oldFile.delete();
		}
	}
}
