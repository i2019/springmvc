package ty.sprmvc.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Utils {
	
	public static String getGenerateKey(){
	
		return getRandomString(24)+getTimeString();
	}
	/**
	 * 获取当前的年月日时分秒毫秒数，共18位
	 * 
	 * @return
	 */
	public static String getTimeString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyyMMddHHmmssSSS");
		return sdf.format(new Date());
	}

	/**
	 * 根据输入的参数，获取指定长度的随机字符串（包括大小写字母和数字）
	 * 
	 * @param length
	 * @return
	 */
	public static String getRandomString(int length) {
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; ++i) {
			int number = random.nextInt(3);
			long result = 0;
			switch (number) {
			case 0:
				result = Math.round(Math.random() * 25 + 65);
				sb.append(String.valueOf((char) result));
				break;
			case 1:
				result = Math.round(Math.random() * 25 + 97);
				sb.append(String.valueOf((char) result));
				break;
			case 2:
				sb.append(String.valueOf(new Random().nextInt(10)));
				break;
			}
		}
		return sb.toString();
	}

}
