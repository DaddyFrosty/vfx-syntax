//// SPDX-License-Identifier: MIT
//
package daddyfrosty.intellij.vfx.support;

import daddyfrosty.intellij.IconUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * Provides a custom icon for *.exml files.
 */
public class vfxIconProvider extends BaseIconProvider
{
    private static final String VFX_ICON = "icons/vfx.png";
    private static final String HLSL_ICON = "icons/f_x_active.png";

    //@Override
    @Nullable
    @Override
    public Icon getIconSimple( @NotNull String fileName )
    {
        if ( fileName.endsWith( ".vfx" ) || fileName.endsWith( ".shader" ) )
        {
            return IconUtils.getIcon( VFX_ICON );
        }
        else if ( fileName.endsWith( ".hlsl" ) )
        {
            return IconUtils.getIcon( HLSL_ICON );
        }
        return null;

        // var textMateService = TextMateSettings.getInstance();
        // // TextMateSettings.getInstance().getState().setBundles()
        //
        // textMateService.unregisterAllBundles(false);
        // textMateService.reloadThemesFromDisk();
        // textMateService.registerEnabledBundles(true);
    }
}
