import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;

public class JvmClassLoaderPrintPath {

    public static void main(String[] args) {
        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        System.out.println("启动类加载器");
        for (URL url : urls) {
            System.out.println("==>" + url.toExternalForm());
        }
        printClassLoader("扩展类加载器", JvmClassLoaderPrintPath.class.getClassLoader().getParent());
        printClassLoader("应用类加载器", JvmClassLoaderPrintPath.class.getClassLoader());
    }

    public static void printClassLoader(String name, ClassLoader cl) {
        if (cl != null) {
            System.out.println(name + " ClassLoader-> " + cl.toString());
            printUrlForClassLoader(cl);
        } else {
            System.out.println(name + " ClassLoader-> null");
        }
    }

    public static void printUrlForClassLoader(ClassLoader cl) {
        Object ucp = insignhtField(cl, "ucp");
        Object path = insignhtField(ucp, "path");
        ArrayList ps = (ArrayList) path;
        for (Object p : ps) {
            System.out.println("==>" + p.toString());
        }
    }

    public static Object insignhtField(Object object, String fName) {
        try {
            Field f = null;
            if (object instanceof ClassLoader) {
                f = URLClassLoader.class.getDeclaredField(fName);
            } else {
                f = object.getClass().getDeclaredField(fName);
            }
            f.setAccessible(true);
            return f.get(object);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
