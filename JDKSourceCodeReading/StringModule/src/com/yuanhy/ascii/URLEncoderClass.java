package com.yuanhy.ascii;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * URL编码是浏览器发送数据给服务器时使用的编码，它通常附加在URL的参数部分，例如：
 *
 * https://www.baidu.com/s?wd=%E4%B8%AD%E6%96%87
 *
 * 之所以需要URL编码，是因为出于兼容性考虑，很多服务器只识别ASCII字符。但如果URL中包含中文、日文这些非ASCII字符怎么办？不要紧，URL编码有一套规则：
 *
 * 如果字符是A~Z，a~z，0~9以及-、_、.、*，则保持不变；
 * 如果是其他字符，先转换为UTF-8编码，然后对每个字节以%XX表示。
 * 例如：字符中的UTF-8编码是0xe4b8ad，因此，它的URL编码是%E4%B8%AD。URL编码总是大写。
 * URL编码是编码算法，不是加密算法。URL编码的目的是把任意文本数据编码为%前缀表示的文本，编码后的文本仅包含A~Z，a~z，0~9，-，_，.，*和%，便于浏览器和服务器处理。
 */
public class URLEncoderClass{

    /**
     * 功能：将一个URL字符串进行utf-8格式的编码
     * @param info url字符串
     * @return {@link String}
     */
    public static String urlEncode(String info) {
        String cipher = null;
        try {
            cipher = URLEncoder.encode(info, StandardCharsets.UTF_8.name());

        } catch (UnsupportedEncodingException e) {

        }
        return cipher;
    }

    /**
     * 功能： 对一个编码后的URL编码串进行utf-8格式的解码
     * @param translation 编码
     * @return {@link String}
     */
    public static String urlDecode(String translation) {
        String plaintext = null;
        try {
            plaintext = URLDecoder.decode(translation, StandardCharsets.UTF_8.name());
        } catch (UnsupportedEncodingException e) {

        }
        return plaintext;

    }

    public static void main(String[] args) {
        String encode = urlEncode("中国");
        System.out.println("URL转码后："+encode);
        String decode= urlDecode(encode);
        System.out.println("URL恢复转码："+decode);

    }
}
