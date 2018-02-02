package cn.photo.shutterbug.utils;

import java.util.UUID;

/**
 * UUID相关工具类
 * @author XGD
 *
 */
public class UUIDUtil {
	
	/**
	 * 获取UUID
	 * 
	 * @return
	 */
	public static String getUUID() {
		return UUID.randomUUID().toString().toUpperCase().replace("-", "");
	}
	
	/**
	 * 根据文件名生成uuid的文件名
	 * @param fileName
	 * @return
	 */
	public static String getFileName(String fileName){
		String suffix = fileName.substring(fileName.lastIndexOf("."));
		return UUID.randomUUID().toString().toUpperCase().replace("-", "")+suffix;
	}
}
