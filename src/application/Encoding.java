package application;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 
 * @author Leo Fanzott
 *
 */
public class Encoding {

	// holds the encoded form
	private byte[] hash;
	// the selected encoding type
	private EncodingType encodingType;
	// MessageDigest
	private MessageDigest md;
	// holds the file if
	private File fileToEncode;
	// holds the string
	private String stringToEncode;

	// valid encoding types
	public static enum EncodingType {
		MD2, MD5, SHA1, SHA256, SHA384, SHA512
	}

	/**
	 * 
	 * @param stringToEncode
	 * @throws NoSuchAlgorithmException
	 * @throws EncodingException
	 */
	public Encoding(String stringToEncode, EncodingType encodingType)
			throws NoSuchAlgorithmException {
		// TODO Auto-generated constructor stub
		this.encodingType = encodingType;
		this.fileToEncode = null;
		this.stringToEncode = stringToEncode;
		setMessageDigest();
		// MD5, SHA-1, SHA-256
		hash = md.digest(stringToEncode.getBytes());
	}

	/**
	 * 
	 * @param stringToEncode
	 * @param encodingType
	 * @throws NoSuchAlgorithmException
	 * @throws EncodingException
	 * @throws IOException
	 */
	public Encoding(File fileToEncode, EncodingType encodingType)
			throws NoSuchAlgorithmException, IOException {
		// TODO Auto-generated constructor stub
		this.encodingType = encodingType;
		this.fileToEncode = fileToEncode;
		this.stringToEncode = null;
		setMessageDigest();
		BufferedInputStream bfis = new BufferedInputStream(new FileInputStream(
				fileToEncode));
		byte[] buffer = new byte[1024];
		int readBuffer = bfis.read(buffer);
		while (readBuffer != -1) {
			md.update(buffer, 0, readBuffer);
			readBuffer = bfis.read(buffer);
		}
		hash = md.digest();
	}

	/**
	 * 
	 * @throws NoSuchAlgorithmException
	 */
	private void setMessageDigest() throws NoSuchAlgorithmException {
		md = null;
		switch (encodingType) {
		case SHA512:
			md = MessageDigest.getInstance("SHA-512");
			break;
		case SHA384:
			md = MessageDigest.getInstance("SHA-384");
			break;
		case SHA256:
			md = MessageDigest.getInstance("SHA-256");
			break;
		case SHA1:
			md = MessageDigest.getInstance("SHA-1");
			break;
		case MD5:
			md = MessageDigest.getInstance("MD5");
			break;
		case MD2:
			md = MessageDigest.getInstance("MD2");
			break;
		default:
			throw new NoSuchAlgorithmException();
		}

	}

	/**
	 * Print hashcode to the treminal
	 */
	public void printHash() {
		int i = 0;
		if (stringToEncode == null) {
			System.out.println("\n\nEncoded file: " + fileToEncode.getName());
		} else {
			System.out.println("\n\nEncoded string: " + stringToEncode);
		}
		System.out.println("-----------------------------------------");
		for (byte b : hash) {
			System.out.printf("%02x", b);
			i++;
		}
		System.out.println("       Length:" + (i * 8) + " Bit"
				+ "Encoding type: " + encodingType);
	}
	
	/**
	 * Hascode as string
	 * 
	 * @return
	 */
	public String getHashcodeAsString(){
		return javax.xml.bind.DatatypeConverter.printHexBinary(hash);
	}
	
	/**
	 * returns hashcode
	 * 
	 * @return
	 */
	public byte[] getHashcode(){
		return hash;		
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Encoding encode = new Encoding("test", EncodingType.SHA512);
			encode.printHash();
			encode = new Encoding("12345678", EncodingType.SHA256);
			encode.printHash();
			encode = new Encoding("test", EncodingType.SHA256);
			encode.printHash();
			encode = new Encoding("test", EncodingType.SHA1);
			encode.printHash();
			encode = new Encoding("moodle", EncodingType.MD5);
			encode.printHash();
			encode = new Encoding("test", EncodingType.MD2);
			encode.printHash();
			// encode=new Encoding("test",null);
			// encode.printHash();
			// encode a file
			File file = new File("./src/encoding/md5check.txt");
			encode = new Encoding(file, EncodingType.MD5);
			encode.printHash();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
