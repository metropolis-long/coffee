package com.sky.coffee.tool;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.List;

/**
 *
 */
public class NullUtil {

	/**
	 * get list size if it is null return 0.
	 * @param list
	 * @return
	 */
	public static  int getListSize(List list) {
		if (listIsNull(list))
			return 0;
		else
			return list.size();
	}

	/**
	 * 判断list是否为空
	 *
	 * @param list
	 * @return
	 */
	public static boolean listIsNull(List list) {
		if (null != list && list.size() > 0) {
			return false;
		}
		return true;
	}

	/**
	 * 强行获取整数,不行就返回0.
	 * @param obj
	 * @return
	 */
	public static int getInt(Object obj){
		try{
			return Integer.parseInt(obj.toString().trim());
		}catch(Exception e){
			return 0;
		}
	}
	
	/**
	 * 强行获取长整数,识别科学计数法,不行则返回0.
	 * 如果确定没有科学计数法,不建议使用该方法.
	 * @param obj
	 * @return
	 */
	public static long getLong4E(Object obj){
		try{
			return new BigDecimal(obj.toString()).toBigInteger().longValue();
		}catch(Exception e){
			return 0;
		}
	}
	/**
	 * 将字节数组转换为十六进制字符串
	 * 
	 * @param byteArray
	 * @return
	 */
	public static String byteToString(byte[] byteArray) {

		String strDigest = "";

		for (int i = 0; i < byteArray.length; i++) {

			strDigest += byteToHexString(byteArray[i]);
		}

		return strDigest;
	}

	/**
	 * 将字节转换为十六进制字符串
	 * 
	 * @param mByte
	 * @return
	 */
	private static String byteToHexString(byte mByte) {

		char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E',
				'F' };

		char[] tempArr = new char[2];

		tempArr[0] = Digit[(mByte >>> 4) & 0X0F];

		tempArr[1] = Digit[mByte & 0X0F];

		String s = new String(tempArr);

		return s;
	}

	/**
	 * 字符串转码
	 * 
	 * @param str
	 * @return
	 */
	public static String urlEnodeUTF8(String str) {

		try {
			return URLEncoder.encode(str, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static boolean isNull(Object v) {
		if (v==null||v.toString()==null||"".equals(v)||"".equals(v.toString().trim()))
			return true;
		else
			return false;
	}

	//todo no complete
    public static boolean isValidExpression(String newCron) {
		return true;
    }
}
