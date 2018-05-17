package com.guanyou.hibtc.until;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.Date;

/**
 * MD5
 * @author seif
 * 
 */
public class MD5coding {
	public static MD5coding md5coding;

	public String code(String str) {
		String hs = "";
		try {
			MessageDigest alga;
			String myinfo = str;
			alga = MessageDigest.getInstance("MD5");
			alga.update(myinfo.getBytes());
			byte[] digesta = alga.digest();
			String stmp = "";
			for (int n = 0; n < digesta.length; n++) {
				stmp = (Integer.toHexString(digesta[n] & 0XFF));
				if (stmp.length() == 1)
					hs = hs + "0" + stmp;
				else
					hs = hs + stmp;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hs.toUpperCase();
	}

	/**
	 * Important information is partially encrypted.
	 * 
	 * @param msg
	 *           The string to be processed.
	 * @param encryptLength Encrypt the string length.
	 * @param type
	 *            begin-Encrypt from the beginning<br>
	 *            end-Encrypt at the end<br>
	 *            other-Intermediate encryption
	 * @return
	 */
	public String encryptImportMsg(String msg, int encryptLength, String type) {
		String newChar = "*";
		String result = "";
		if (!StringUtil.isEmpty(msg) && encryptLength > 0) {
			int length = msg.length();
			if ("begin".equals(type)) {
				if (encryptLength > length) {
					for (int i = 0; i < length; i++) {
						result += newChar;
					}
				} else {
					for (int i = 0; i < encryptLength; i++) {
						result += newChar;
					}
					for (int i = encryptLength; i < length; i++) {
						result += msg.substring(i, i + 1);
					}
				}
			} else if ("end".equals(type)) {
				if (encryptLength > length) {
					for (int i = 0; i < length; i++) {
						result += newChar;
					}
				} else {
					for (int i = 0; i < encryptLength; i++) {
						result += newChar;
					}
					for (int i = (length - encryptLength) - 1; i >= 0; i--) {
						result = msg.substring(i, i + 1) + result;
					}
				}
			} else {
				if (encryptLength >= length) {
					for (int i = 0; i < length; i++) {
						result += newChar;
					}
				} else {
					int i = 0;
					int inter = length - encryptLength;
					int multiple = inter / 2;
					int residue = inter % 2;
					int beginIndex = 0;
					int endIndex = 0;
					if (length < encryptLength + 2) {
						while (i < length) {
							if (i == 0) {
								result = msg.substring(0, 1);
							} else {
								result += newChar;
							}
							i++;
						}
					} else {
						if (residue == 0) {
							beginIndex = multiple;
							endIndex = encryptLength + multiple - 1;
						} else {
							beginIndex = multiple + residue;
							endIndex = encryptLength + beginIndex - 1;
						}
						while (i < length) {
							if (i < beginIndex || i > endIndex) {
								result += msg.substring(i, i + 1);
							} else {
								result += newChar;
							}
							i++;
						}
					}
				}
			}
		} else {
			result = msg;
		}
		return result;
	}

	public static MD5coding getInstance() {
		if (md5coding == null) {
			md5coding = new MD5coding();
		}
		return md5coding;
	}

	/**
	 * md5,32-bit lowercase
	 */
	public static String MD5(String inStr) {
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
			byte[] byteArray = inStr.getBytes("utf-8");

			byte[] md5Bytes = md5.digest(byteArray);

			StringBuffer hexValue = new StringBuffer();

			for (int i = 0; i < md5Bytes.length; i++) {
				int val = ((int) md5Bytes[i]) & 0xff;
				if (val < 16)
					hexValue.append("0");
				hexValue.append(Integer.toHexString(val));
			}

			return hexValue.toString();
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
			return "";
		}
	}

}
