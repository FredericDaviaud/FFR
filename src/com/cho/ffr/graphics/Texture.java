package com.cho.ffr.graphics;

import static org.lwjgl.opengl.GL11.GL_NEAREST;
import static org.lwjgl.opengl.GL11.GL_RGBA;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_MAG_FILTER;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_MIN_FILTER;
import static org.lwjgl.opengl.GL11.GL_UNSIGNED_BYTE;
import static org.lwjgl.opengl.GL11.glBindTexture;
import static org.lwjgl.opengl.GL11.glGenTextures;
import static org.lwjgl.opengl.GL11.glTexImage2D;
import static org.lwjgl.opengl.GL11.glTexParameteri;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

import com.cho.ffr.utils.BufferUtils;

public class Texture {

    private int width, height;
    private int id;

    private final static Logger LOGGER = Logger.getLogger(Texture.class.getName());

    public Texture (String path) {
        id = load(path);
    }

    /**
     * Load texture from image
     * @param texturePath path of image
     * @return texture
     */
    private int load(String texturePath) {
        int[] pixels = null;

        try {
            BufferedImage image = ImageIO.read(new FileInputStream(texturePath));
            width = image.getWidth();
            height = image.getHeight();
            pixels = new int[width * height];
            image.getRGB(0, 0, width, height, pixels, 0, width);
        } catch (FileNotFoundException e) {
            LOGGER.log(Level.SEVERE, "Texture not found: " + texturePath + " !", e);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error while trying to load texture at path " + texturePath + " !", e);
        }

        int[] glPixels = new int[width * height];
        for (int pixel : pixels) {
            glPixels[pixel] = ((pixels[pixel] & 0xff000000) >> 24) << 24
                    | ((pixels[pixel] & 0xff0000) >> 16) << 16
                    | ((pixels[pixel] & 0xff00) >> 8) << 8
                    | ((pixels[pixel] & 0xff));
        }
        
        int texture = glGenTextures();
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
        glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, width, height, 0, GL_RGBA, GL_UNSIGNED_BYTE, BufferUtils.createIntBuffer(glPixels));
        glBindTexture(GL_TEXTURE_2D, 0);
        
        return texture;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getId() {
        return id;
    }
}
