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

public abstract class BaseIconProvider extends IconProvider {

    @Nullable
    public abstract Icon getIconSimple( @NotNull String fileName );

    public Icon getIcon(@NotNull PsiElement psiElement, int flags) {
        PsiFile containingFile = psiElement.getContainingFile();
        if (containingFile != null) {
            return getIconSimple( containingFile.getName() );
        }
        return null;
    }

    @Nullable
    public Icon getIcon(@NotNull FilePath filePath, @Nullable Project project) {
        try {
            VirtualFile file = filePath.getVirtualFile();
            if (file == null) {
                return null;
            }
            PsiFileSystemItem psiFileSystemItem;
            if (file.isDirectory()) {
                psiFileSystemItem = PsiManager.getInstance(project).findDirectory(file);
            } else {
                psiFileSystemItem = PsiManager.getInstance(project).findFile(file);
            }
            if (psiFileSystemItem != null) {
                return getIcon(psiFileSystemItem, 0);
            }
        } catch (Throwable e) {
            logError(e);
        }
        return null;
    }

    @Nullable
    public Icon getIcon(@NotNull VirtualFile file, int flags, @Nullable Project project) {
        try {
            PsiFileSystemItem psiFileSystemItem;
            if (file instanceof LightVirtualFile) {
                return null;
            } else if (file.isDirectory()) {
                psiFileSystemItem = PsiManager.getInstance(project).findDirectory(file);
            } else {
                psiFileSystemItem = PsiManager.getInstance(project).findFile(file);
            }
            if (psiFileSystemItem != null) {
                return getIcon(psiFileSystemItem, flags);
            }
        } catch (Throwable e) {
            logError(e);
        }
        return null;
    }

    private static final Logger LOGGER = Logger.getInstance(vfxIconProvider.class);
    private void logError(@NotNull Throwable e) {
        if (e instanceof ControlFlowException) {
            // Control-flow exceptions should never be logged.
            return;
        }

        if (e.getMessage() != null) {
            String errMsg = e.getMessage()
                .replaceAll("[\\s_]", "")
                .toUpperCase();
            if (errMsg.contains("DISPOSEINPROGRESS") || errMsg.contains("PROJECTISALREADYDISPOSED")) {
                if (LOGGER.isDebugEnabled()) {
                    LOGGER.debug(e);
                }
            } else {
                LOGGER.warn(e);
            }
        }
    }
}
