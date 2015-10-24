package com.cho.ffr.maths;

public class Matrix4f {

    public float[] matrix = new float[16];
    
    /**
     * Return a identity matrix
     * @return identity matrix
     */
    public static Matrix4f identity() {
        Matrix4f matrix = new Matrix4f();
        for (float value : matrix.matrix) {
            value = ((value % 5.0f) == 0.0f) ? 1.0f : 0.0f;
        }
        return matrix;
    }
    
    /**
     * Return a rotation matrix around z axis
     * @param angle rotation in degres
     * @return rotation matrix
     */
    public static Matrix4f rotate(float angle) {
        Matrix4f matrix = identity();
        
        float r = (float) Math.toRadians(angle);
        float cos = (float) Math.cos(r);
        float sin = (float) Math.sin(r);
        
        matrix.matrix[0] = cos;
        matrix.matrix[1] = sin;
        matrix.matrix[4] = -sin;
        matrix.matrix[5] = cos;
         
        return matrix;
    }
    
    /**
     * Return a translate matrix
     * @param vector vector
     * @return translation matrix
     */
    public static Matrix4f translate(Vector3f vector) {
        Matrix4f matrix = new Matrix4f();
        
        matrix.matrix[12] = vector.x;
        matrix.matrix[13] = vector.y;
        matrix.matrix[14] = vector.z;
        
        return matrix;
    }
    
    public static Matrix4f orthographic(float left, float right, float top , float bottom, float near, float far) {
        Matrix4f matrix = identity();
        
        matrix.matrix[0] = 2.0f / (right - left);
        matrix.matrix[5] = 2.0f / (top - bottom);
        matrix.matrix[10] = 2.0f / (near - far);
        matrix.matrix[12] = (left + right) / (left - right);
        matrix.matrix[13] = (bottom + top) / (bottom - top);
        matrix.matrix[14] = (far+ near) / (far - near);
        
        return matrix;
    }
    
    /**
     * Multiply the matrix
     * @param matrix the matrix to multiply by
     * @return the result of multiplication
     */
    public Matrix4f multiply(Matrix4f matrix) {
        Matrix4f result = new Matrix4f();
        
        for (int column = 0; column < 4; column++) {
            for (int lign = 0; lign < 4; lign++) {
                float sum = 0.0f;
                for (int i = 0; i < 4; i++) {
                    sum += this.matrix[i + column * 4]
                            * matrix.matrix[lign + i * 4];
                }
                result.matrix[lign + column * 4] = sum;
            }
        }
        
        return result;
    }
}
