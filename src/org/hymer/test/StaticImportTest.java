package org.hymer.test;

import static org.hymer.util.FileRenameUtil.rename;

public class StaticImportTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String path = "";
		String type = "";
		rename(path, type); //个人觉得要尽量避免使用import static
	}

}
