package daddyfrosty.intellij;

import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.util.IconLoader;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.util.IconUtil;
import com.intellij.util.ImageLoader;
import com.intellij.util.RetinaImage;
import com.intellij.util.SVGLoader;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class IconUtils {

    private static final Logger LOGGER = Logger.getInstance(IconUtils.class);
    private static final ThreadLocal<Boolean> contextUpdated = ThreadLocal.withInitial(() -> false);

    public static Icon getIcon(String path) {
        return IconLoader.getIcon(path, IconUtils.class);
    }

    /** Load graphics libraries (TwelveMonkeys) in order to make the JVM able to manipulate SVG files. */
    private synchronized static void enhanceImageIOCapabilities() {
        if ( !contextUpdated.get() ) {
            Thread.currentThread().setContextClassLoader(IconUtils.class.getClassLoader());
            ImageIO.scanForPlugins();
            contextUpdated.set(true);
            LOGGER.info("ImageIO plugins updated with TwelveMonkeys capabilities");
        }
    }
}
