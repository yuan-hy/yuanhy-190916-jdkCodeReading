package com.yuanhy.string;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *  SLF4J : Simple Logging Facade for Java (SLF4J) java简单的日志记录门面
 *
 *  相关版本下载（http://www.slf4j.org/download.html）
 *
 *  将文件slf4j-api-1.7.28.jar添加到您的类路径中。此时会报
 *  SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
 * SLF4J: Defaulting to no-operation (NOP) logger implementation
 * SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
 * 您的类路径上找不到slf4j绑定，所以将打印此警告。
 * 将绑定添加到类路径后，警告将消失。 假设您添加slf4j-simple-1.7.28.jar，以便您的类路径包含：
 *
 * slf4j-api-1.7.28.jar
 * slf4j-simple-1.7.28.jar
 *
 *
 *  典型用法
 *  下面的示例代码说明了SLF4J的典型使用模式。 请注意在第15行上使用{}-占位符。
 *  import org.slf4j.Logger;
 *  2: import org.slf4j.LoggerFactory;
 *  3:
 *  4: public class Wombat {
 *  5:
 *  6:   final Logger logger = LoggerFactory.getLogger(Wombat.class);
 *  7:   Integer t;
 *  8:   Integer oldT;
 *  9:
 * 10:   public void setTemperature(Integer temperature) {
 * 11:
 * 12:     oldT = t;
 * 13:     t = temperature;
 * 14:
 * 15:     logger.debug("Temperature set to {}. Old temperature was {}.", t, oldT);
 * 16:
 * 17:     if(temperature.intValue() > 50) {
 * 18:       logger.info("Temperature has risen above 50 degrees.");
 * 19:     }
 * 20:   }
 * 21: }
 *
 *  流利的日志记录API（）
 *  SLF4J API版本2.0.0需要Java 8，并引入了向后兼容的流畅日志记录API。
 *  向后兼容意味着我们不必更改现有的日志记录框架即可使用户受益于流畅的日志记录API。
 *  logger.atInfo().log("Hello world"); = logger.info("Hello world.");
 *  int newT = 15;
 *         int oldT = 16;
 *
 *         // using traditional API
 *         logger.debug("Temperature set to {}. Old temperature was {}.", newT, oldT);
 *
 *         // using fluent API, add arguments one by one and then log message
 *         logger.atDebug().addArgument(newT).addArgument(oldT).log("Temperature set to {}. Old temperature was {}.");
 *
 *         // using fluent API, log message with arguments
 *         logger.atDebug().log("Temperature set to {}. Old temperature was {}.", newT, oldT);
 *
 *         // using fluent API, add one argument and then log message providing one more argument
 *         logger.atDebug().addArgument(newT).log("Temperature set to {}. Old temperature was {}.", oldT);
 *
 *         // using fluent API, add one argument with a Supplier and then log message with one more argument.
 *         // Assume the method t16() returns 16.
 *         logger.atDebug().addArgument(() -> t16()).log(msg, "Temperature set to {}. Old temperature was {}.", oldT);
 *
 *          int newT = 15;
 *         int oldT = 16;
 *
 *         // using classical API
 *         logger.debug("oldT={} newT={} Temperature changed.", newT, oldT);
 *
 *         // using fluent API
 *         logger.atDebug().addKeyValue("oldT", oldT).addKeyValue("newT", newT).log("Temperature changed.");
 *
 *
 *
 *  这里面设计一个门面模式：
 *      餐厅里点一份西红柿炒蛋：进去餐厅前台点餐，点一份西红柿炒蛋，前台跟厨房分开的。不管厨房里
 *      哪个厨师做的，但是到前台的是西红柿炒蛋还是番茄炒蛋，都一样的食材。就好比 SLFJ 就是前台
 *      实现日志记录（西红柿炒蛋）需要使用日志框架（好比厨师），不管用什么框架记录，SLF4J就是门面，
 *      需要用哪种日志框架记录日志就绑定哪种框架
 *
 *  SLF4J可与哪些日志框架绑定：（使用SLF4J必须有slf4j-api-版本号.jar与下面其中一个搭配，不可重复,
 *      以下均可以在 maven 管理项目的pom.xml文件中添加对应的库）
 *      1、log4j12
 *      slf4j-log4j12-1.7.28.jar
 *      绑定log4j 1.2版，这是一种广泛使用的日志记录框架。 您还需要将log4j.jar放在类路径上。
 *
 *
 *      2、jdk14
 *      slf4j-jdk14-1.7.28.jar（jdk自带）
 *      java.util.logging的绑定，也称为JDK 1.4日志记录
 *      <dependency>
 *          <groupId>org.slf4j</groupId>
 *          <artifactId>slf4j-jdk14</artifactId>
 *          <version>1.7.28</version>
 *      </dependency>
 *
 *      3、nop
 *      slf4j-nop-1.7.28.jar
 *      绑定NOP，静默丢弃所有日志记录。
 *
 *      4、simple
 *      slf4j-simple-1.7.28.jar
 *      进行简单实现的绑定，它将所有事件输出到System.err。 仅打印INFO或更高级别的消息。
 *      在小型应用程序的上下文中，此绑定可能很有用。（debug级别比info低，测试过不会打印）
 *
 *      5、jcl
 *      slf4j-jcl-1.7.28.jar
 *      绑定雅加达公共日志。 此绑定会将所有SLF4J日志记录委派给JCL。
 *
 *      6、logback-classic
 *      logback-classic-1.2.3.jar (requires logback-core-1.2.3.jar)
 *      生实现SLF4J项目外部还有SLF4J绑定，例如 本机实现SLF4J的logback。
 *      Logback的ch.qos.logback.classic.Logger类是SLF4J的org.slf4j.Logger接口的直接实现。
 *      因此，将SLF4J与logback结合使用时，将严格占用零内存和计算开销。
 *
 *  混合使用不同版本的slf4j-api.jar和SLF4J绑定可能会导致问题。
 *       例如，如果您使用的是slf4j-api-1.7.28.jar，则还应该使用slf4j-simple-1.7.28.jar，
 *       而使用slf4j-simple-1.5.5.jar将不起作用。
 *
 *  通过SLF4J合并日志记录：（还没看：http://www.slf4j.org/legacy.html）
 *        桥接旧版API。
 *
 *   支持 MDC (还没看：http://logback.qos.ch/manual/mdc.html)
 *        SLF4J支持MDC或映射的诊断上下文。 如果基础日志框架提供MDC功能，则SLF4J将委派给基础框架的MDC。
 *        请注意，此时，只有log4j和logback提供MDC功能。 如果底层框架不提供MDC，例如java.util.logging，
 *        则SLF4J仍将存储MDC数据，但是其中的信息将需要由自定义用户代码检索。
 *
 *   迁移您的源代码（还没看：http://www.slf4j.org/migrator.html）
 *          slf4j-migrator实用程序可以帮助您迁移源以使用SLF4J。
 *
 *   支持参数化日志消息（还没看：http://www.slf4j.org/faq.html#logging_performance）
 *          所有SLF4J绑定都支持参数化日志消息，从而显着改善了性能结果。
 *
 *
 *
 *
 *
 *
 */
public class SLF4JClass {
    final static Logger logger = LoggerFactory.getLogger(SLF4JClass.class);

    static Integer t, oldT;

    public static void setTemperature(Integer temperature){
        oldT = t;
        t = temperature;
        String wo = "world";
        logger.atInfo().log("123hello{}",wo);
        logger.debug("temperature set to {}.old temperature was {}.", t, oldT);
        if (temperature.intValue() > 50) {
            logger.info("temperature has risen above 50 degree {}", t);
        }
    }

    public static void main(String[] args) {
        System.out.println(logger.isDebugEnabled());
        System.out.println(logger.isInfoEnabled());
        setTemperature(30);
    }
}
