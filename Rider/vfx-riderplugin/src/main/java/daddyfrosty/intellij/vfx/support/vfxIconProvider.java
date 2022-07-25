//// SPDX-License-Identifier: MIT
//
package daddyfrosty.intellij.vfx.support;

import com.intellij.ide.FileIconProvider;
import com.intellij.ide.IconProvider;
import com.intellij.openapi.diagnostic.ControlFlowException;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ProjectFileIndex;
import com.intellij.openapi.vcs.FilePath;
import com.intellij.openapi.vcs.changes.FilePathIconProvider;
import com.intellij.openapi.vfs.VfsUtilCore;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiDirectory;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiFileSystemItem;
import com.intellij.psi.PsiManager;
import com.intellij.testFramework.LightVirtualFile;
import daddyfrosty.intellij.IconUtils;
import com.intellij.openapi.util.IconLoader;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.Icon;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Provides a custom icon for *.exml files.
 */
public class vfxIconProvider extends BaseIconProvider {

    private static final String VFX_ICON = "icons/vfx.png";
    private static final String HLSL_ICON = "icons/f_x_active.png";

    //@Override
    @Nullable
    @Override
    public Icon getIconSimple( @NotNull String fileName ) {
        if ( fileName.endsWith(".vfx") ) {
            return IconUtils.getIcon( VFX_ICON );
        } else if ( fileName.endsWith(".hlsl") ) {
            return IconUtils.getIcon( HLSL_ICON );
		}
        return null;
    }
}
