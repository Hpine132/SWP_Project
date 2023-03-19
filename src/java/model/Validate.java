/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Random;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author nguye
 */
public class Validate {

    public String generatePassword(int length) {
        String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String specialCharacters = "!@#$";
        String numbers = "1234567890";
        String combinedChars = capitalCaseLetters + lowerCaseLetters + specialCharacters + numbers;
        Random random = new Random();
        char[] password = new char[length];
        String pass = "";
        password[0] = lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length()));
        password[1] = capitalCaseLetters.charAt(random.nextInt(capitalCaseLetters.length()));
        password[2] = specialCharacters.charAt(random.nextInt(specialCharacters.length()));
        password[3] = numbers.charAt(random.nextInt(numbers.length()));
        pass = String.valueOf(password[0]) + String.valueOf(password[1]) + String.valueOf(password[2]) + String.valueOf(password[3]);
        for (int i = 4; i < length; i++) {
            password[i] = combinedChars.charAt(random.nextInt(combinedChars.length()));
            pass += String.valueOf(password[i]);
        }
        return pass;
    }

    public static String bytesToHex(byte[] bytes) {
        String result = "";
        for (byte b : bytes) {
            int data = b;
            if (data < 0) {
                data += 256;
            }

            String hex = Integer.toHexString(data);
            result += (hex.length() == 1 ? "0" : "") + hex;
        }
        return result;
    }

    public static byte[] hexToBytes(String hex) {
        byte[] result = new byte[hex.length() / 2];
        for (int i = 0; i < hex.length() - 1; i += 2) {
            result[i / 2] = Byte.parseByte(hex.substring(i, i + 1), 16);
        }
        return result;
    }

    public String SHA256(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            return bytesToHex(md.digest(str.getBytes()));
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    public String encode64(String data) {
        return new String(Base64.getEncoder().encode(data.getBytes()));
    }

    public String decode64(String data) {
        return new String(Base64.getDecoder().decode(data.getBytes()));
    }

    public static void main(String[] args) {
        Validate v = new Validate();
        System.out.println(v.SHA256("admin123456"));
    }
}
