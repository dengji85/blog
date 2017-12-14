package com.dengji85.blog.common;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class Utils {
	
	
	public static byte[] getByteArray(InputStream in) {
		byte[] datas = null;
		try {

			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			byte[] b = new byte[1024];

			int count = -1;
			while ((count = in.read(b)) != -1) {
				bos.write(b, 0, count);

			}
			datas = bos.toByteArray();
			bos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return datas;
	}

}
