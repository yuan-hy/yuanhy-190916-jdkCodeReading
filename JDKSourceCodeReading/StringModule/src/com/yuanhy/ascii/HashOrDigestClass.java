package com.yuanhy.ascii;

import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;
import org.junit.Test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;

/**
 * 哈希算法（Hash）又称摘要算法（Digest），它的作用是：对任意一组输入数据进行计算，得到一个固定长度的输出摘要。
 * 注意是 固定长度
 * <p>
 * 哈希算法最重要的特点就是：
 * <p>
 * 相同的输入一定得到相同的输出；
 * 不同的输入大概率得到不同的输出。
 * 哈希算法的目的就是为了验证原始数据是否被篡改。
 */
public class HashOrDigestClass {
    /**
     * Java字符串的hashCode()就是一个哈希算法，它的输入是任意字符串，输出是固定的4字节int整数：
     * 两个相同的字符串永远会计算出相同的hashCode，否则基于hashCode定位的HashMap就无法正常工作。
     * 这也是为什么当我们自定义一个class时，覆写equals()方法时我们必须正确覆写hashCode()方法。
     */
    @Test
    public void hashCodeTest() {
        int JavaHashCode = "Java".hashCode();
        int HelloHashCode = "Hello".hashCode();
        System.out.println("JavaHashCode:" + JavaHashCode);
        System.out.println("HelloHashCode:" + HelloHashCode);
        System.out.println("Java".hashCode() == JavaHashCode);
    }

    /**
     * 哈希碰撞
     *
     * 两个不同的输入，算出来的哈希是一样的
     * 碰撞不能避免，而且有规律的哈希是不安全的
     */
    @Test
    public void hashCollision() {
        int hashCode1 = "AaAaAa".hashCode();
        int hashCode2 = "BBAaBB".hashCode();
        System.out.println(hashCode1 == hashCode2);
    }

    /**
     * 列举一些常见的哈希算法
     * 常用的哈希算法有：
     *
     * 算法	           输出长度（位）  	   输出长度（字节）
     * MD5	            128 bits	        16 bytes
     * SHA-1	        160 bits	        20 bytes
     * RipeMD-160	    160 bits	        20 bytes
     * SHA-256	        256 bits	        32 bytes
     * SHA-512	        512 bits	        64 bytes
     *
     * 后面的160，256，512是指输出长度，单位是bits 位，转换成字节是 bits数/8=字节数  因为 1字节 = 8bit
     * 根据碰撞概率，哈希算法的输出长度越长，就越难产生碰撞，也就越安全。
     */
    @Test
    public void MD5Test(){
        //利用 MD5 算法创建 MessageDigest 的实例
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            String algorithm = messageDigest.getAlgorithm();
            Provider provider = messageDigest.getProvider();
            //update方法表示输入数据
            messageDigest.update("Hello".getBytes());
            messageDigest.update("World".getBytes());

            //digest方法表示执行摘要算哈希处理
            byte[] hash = messageDigest.digest();
            System.out.println("algorithm:"+algorithm);
            System.out.println("provider:"+provider);
            System.out.println(HexBin.encode(hash));
            /**
             * 或者直接调用 messageDigest.digest(byte[] input),看下面源码就知道了
             * public byte[] digest(byte[] input) {
             *         update(input);
             *         return digest();
             *     }
             *
             *     里面调用了update(byte[] input),在这里输入数据
             *
             */
        }catch (NoSuchAlgorithmException e){

        }

    }

    /**
     * 其他的哈希算法跟 MD5 的使用一样，不过这里有个实践就是使用哈希存储口令，
     * 为避免彩虹表攻击，进行加盐处理，所谓的加盐是增加随机数跟口令一起算哈希
     * 官方算法名查询：
     * https://docs.oracle.com/en/java/javase/13/docs/specs/security/standard-names.html#messagedigest-algorithms
     *
     *
     */

}
