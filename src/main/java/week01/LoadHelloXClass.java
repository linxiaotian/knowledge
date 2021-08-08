package week01;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;

public class LoadHelloXClass {

    public static void main(String[] args) throws Exception {
        File file = new File("D:\\learn\\first week\\Hello.xlass\\Hello.xlass");
        byte[] allBytes = fileConvertToByteArray(file);
        byte[] oriBytes = new byte[allBytes.length];
        for (int i = 0; i < allBytes.length; i++) {
            byte oriByte = (byte) (255 - allBytes[i]);
            oriBytes[i] = oriByte;
        }
        HelloClassLoader helloClassLoader = new HelloClassLoader();
        helloClassLoader.setOriBytes(oriBytes);
        Class cl = helloClassLoader.findClass("Hello");
        Method method = cl.getDeclaredMethod("hello");
        method.invoke(cl.newInstance());
    }

    /**
     * 把一个文件转化为byte字节数组。
     * @return
     */
    private static byte[] fileConvertToByteArray(File file) {
        byte[] data = null;

        try {
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            int len;
            byte[] buffer = new byte[1024];
            while ((len = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }

            data = baos.toByteArray();

            fis.close();
            baos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

}
