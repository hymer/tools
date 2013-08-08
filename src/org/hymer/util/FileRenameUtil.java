package org.hymer.util;

import java.io.File;

/**
 * <b>function:</b> 文件命名工具类
 * 
 * @author hoojo
 * @createDate 2012-5-14 下午01:58:14
 * @file FileRenameUtils.java
 * @package com.hoo.util
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 * @version 1.0
 */
public abstract class FileRenameUtil {

	private final static String FILE_PATH = "D:/jwchat";

	/**
	 * <b>function:</b> 将指定目录下的文件的type类型的文件，进行重命名，命名后的文件将去掉type
	 * <p>
	 * example: 如果type = html； index.html.html -> index.html
	 * </p>
	 * <p>
	 * example: 如果type = zh_CN； index.html.zh_CN -> index.html
	 * </p>
	 * 
	 * @author hoojo
	 * @createDate 2012-5-16 下午02:16:48
	 * @param path
	 * @param type
	 */
	public static void rename(String path, String type) {
		if (path == null || "".equals(path)) {
			path = FILE_PATH;
		}
		File dir = new File(path);
		File[] list = dir.listFiles();
		for (File file : list) {
			String name = file.getName();
			String[] s = name.split("\\.");
			if (s.length == 3 && type.equals(s[2])) {
				System.out.println(s[0] + "--" + s[1] + "--" + s[2]);
				file.renameTo(new File(path + "/" + s[0] + "." + s[1]));
			}
		}
	}

	public static void main(String[] args) {
		FileRenameUtil.rename(null,
				"zh_CN");
	}
}
