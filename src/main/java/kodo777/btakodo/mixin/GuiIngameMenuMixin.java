package kodo777.btakodo.mixin;

import kodo777.btakodo.BTAKodo;
import net.minecraft.client.gui.GuiIngameMenu;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.render.FontRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = GuiMainMenu.class, remap = false)
public class GuiIngameMenuMixin extends GuiScreen {

	@Redirect(method = "drawScreen", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiMainMenu;drawString(Lnet/minecraft/client/render/FontRenderer;Ljava/lang/String;III)V", ordinal = 1))
	public void setVersion(GuiMainMenu instance, FontRenderer fontRenderer, String s, int x, int y, int colour){
		int versionTextColor = 0xFFFFFF;
		this.drawString(this.fontRenderer, "Minecraft Kodofy " + BTAKodo.versionNumber, 2, 2, versionTextColor);
	}

}
