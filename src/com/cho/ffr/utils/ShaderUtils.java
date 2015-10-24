package com.cho.ffr.utils;

import static org.lwjgl.opengl.GL20.*;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.lwjgl.opengl.GL11;

public class ShaderUtils {

    private final static Logger LOGGER = Logger.getLogger(ShaderUtils.class.getName());

    private ShaderUtils () {

    }

    /**
     * Load shader from path
     * @param vertexPath vertex path
     * @param fragmentPath fragment path
     * @return shader
     */
    public static int load(String vertexPath, String fragmentPath) {
        return create(FileUtils.loadFileAsString(vertexPath),
                FileUtils.loadFileAsString(fragmentPath));
    }

    /**
     * Create a shader
     * @param vertex vertex shader
     * @param fragment fragment shader
     * @return shader
     */
    public static int create(String vertex, String fragment) {
        int program = glCreateProgram();
        int vertexId = glCreateShader(GL_VERTEX_SHADER);
        int fragmentId = glCreateShader(GL_FRAGMENT_SHADER);

        glShaderSource(vertexId, vertex);
        glShaderSource(fragmentId, fragment);
        glCompileShader(vertexId);
        checkShaderCompileStatus(vertexId);
        glCompileShader(fragmentId);
        checkShaderCompileStatus(fragmentId);
        glAttachShader(program, vertexId);
        glAttachShader(program, fragmentId);
        glLinkProgram(program);
        glValidateProgram(program);

        return program;
    }

    /**
     * Check shader compile status
     * @param shaderId shader id
     */
    private static void checkShaderCompileStatus(int shaderId) {
        if (glGetShaderi(shaderId, GL_COMPILE_STATUS) == GL11.GL_FALSE) {
            LOGGER.log(Level.WARNING, "Failed to compile shader id:" + shaderId + " !");
        }
    }
}
