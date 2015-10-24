package cho.com.ffr.utils;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public class BufferUtils {

    private BufferUtils() {
        
    }
    
    /**
     * Create a byte buffer
     * @param array byte array
     * @return byte buffer
     */
    public static ByteBuffer createByteBuffer(byte[] array) {
        ByteBuffer result = ByteBuffer.allocate(array.length).order(ByteOrder.nativeOrder());
        result.put(array).flip();
        return result;
    }
    
    /**
     * Create a float buffer
     * @param array float array
     * @return float buffer
     */
    public static FloatBuffer createFlaotBuffer(float[] array) {
        FloatBuffer result = ByteBuffer.allocate(array.length << 2).order(ByteOrder.nativeOrder()).asFloatBuffer();
        result.put(array).flip();
        return result;
    }
    
    /**
     * Create an int buffer
     * @param array int array
     * @return int buffer
     */
    public static IntBuffer createIntBuffer(int[] array) {
        IntBuffer result = ByteBuffer.allocate(array.length << 2).order(ByteOrder.nativeOrder()).asIntBuffer();
        result.put(array).flip();
        return result;
    }
}
