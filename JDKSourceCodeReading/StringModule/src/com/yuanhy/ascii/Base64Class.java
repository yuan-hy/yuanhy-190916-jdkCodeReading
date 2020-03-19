package com.yuanhy.ascii;

import java.util.Arrays;
import java.util.Base64;

/**
 * URL编码是对字符进行编码，表示成%xx的形式，而Base64编码是对二进制数据进行编码，表示成文本格式。
 * 原理：
 * 具体转换步骤
 * 第一步，将待转换的字符串每三个字节分为一组，每个字节占8bit，那么共有24个二进制位。
 * 第二步，将上面的24个二进制位每6个一组，共分为4组。
 * 第三步，在每组前面添加两个0，每组由6个变为8个二进制位，总共32个二进制位，即四个字节。
 * 第四步，根据Base64编码对照表（见下图）获得对应的值
 * 详细 ：   https://www.liaoxuefeng.com/wiki/1252599548343744/1304227703947297
 * https://blog.csdn.net/wo541075754/article/details/81734770
 *
 * Base64编码的目的是把二进制数据变成文本格式，这样在很多文本中就可以处理二进制数据。例如，电子邮件协议就是文本协议，如果要在电子邮件中添加一个二进制文件，就可以用Base64编码，然后以文本的形式传送。
 * Base64编码的缺点是传输效率会降低，因为它把原始数据的长度增加了1/3。
 */
public class Base64Class {
    public static String base64Encode(byte[] bytes) {
        String base64Encode = Base64.getEncoder().encodeToString(bytes);
        return base64Encode;
    }

    public static String base64Decode(String info) {
        byte[] bytes = Base64.getDecoder().decode(info);
        for (byte bytes1 : bytes) {
            System.out.println(bytes1);
        }
        return Arrays.toString(bytes);
    }

    /**
     * withoutPadding 去填充，，因为编码后的长度加上=总是4的倍数，所以即使不加=也可以计算出原始输入的byte[]。
     * Base64编码的时候可以用withoutPadding()去掉=，解码出来的结果是一样的：
     */
    public static void withoutPadding() {
        byte[] input = new byte[]{(byte) 0xe4, (byte) 0xb8, (byte) 0xad, 0x21};
        String b64encoded = Base64.getEncoder().encodeToString(input);
        String b64encoded2 = Base64.getEncoder().withoutPadding().encodeToString(input);
        System.out.println(b64encoded);
        System.out.println(b64encoded2);
        byte[] output = Base64.getDecoder().decode(b64encoded2);
        System.out.println(Arrays.toString(output));
    }

    /**
     * 因为标准的Base64编码会出现+、/和=，所以不适合把Base64编码后的字符串放到URL中。
     * 一种针对URL的Base64编码可以在URL中使用的Base64编码，它仅仅是把+变成-，/变成_：
     */
    public static void urlEncodeBase64() {
        byte[] input = new byte[]{0x01, 0x02, 0x7f, 0x00};
        String b64encoded = Base64.getUrlEncoder().encodeToString(input);
        System.out.println(b64encoded);
        byte[] output = Base64.getUrlDecoder().decode(b64encoded);
        System.out.println(Arrays.toString(output));
    }

    public static void main(String[] args) {
        byte[] bytes = new byte[]{(byte) 0xe4, (byte) 0xb8, (byte) 0xad};
        String encode = base64Encode(bytes);
        System.out.println("Base64编码结果：" + encode);
        String decode = base64Decode(encode);
        System.out.println("Base64解码结果：" + decode);

        withoutPadding();
        urlEncodeBase64();
    }
}
