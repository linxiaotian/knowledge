package week01;

public class HelloClassLoader extends ClassLoader {

    private byte[] oriBytes;

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] oriBytes = getOribytes();
        return defineClass(name, oriBytes, 0, oriBytes.length);
    }

    public void setOriBytes(byte[] bytes) {
        oriBytes = bytes;
    }

    public byte[] getOribytes() {
        return oriBytes;
    }

}
