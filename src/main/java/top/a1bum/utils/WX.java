package top.a1bum.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WX {
	public static String decrypt(String jscode) {
		String result = null;
		try {
		String[] args = new String[] { "H:\\Anacoda\\python.exe", "E:\\eclipse-workspace\\WXMiniProgram/"
				+ "src/main/java/top/a1bum/utils/WXDecrypt.py", jscode };
		Process proc = Runtime.getRuntime().exec(args);
		proc.waitFor();
		InputStreamReader ir = new InputStreamReader(proc.getInputStream());
		BufferedReader input= new BufferedReader(ir);
		result =  input.readLine();
		input.close();
		proc.waitFor();
		ir.close();
		}catch (IOException e) {
			System.out.println("调用python脚本并读取脚本时出错， "+ e.getMessage());
		}catch(InterruptedException e) {
			System.out.println("进程等待出错，" + e.getMessage());
		}
		return result;
	}
}
