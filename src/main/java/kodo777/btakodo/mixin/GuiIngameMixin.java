package kodo777.btakodo.mixin;

import kodo777.btakodo.BTAKodo;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.render.FontRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = GuiIngame.class, remap = false)
public abstract class GuiIngameMixin extends Gui {

	@Shadow
	protected abstract void drawDebugScreenLine(String string);

	@Redirect(method = "renderGameOverlay", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiIngame;drawString(Lnet/minecraft/client/render/FontRenderer;Ljava/lang/String;III)V", ordinal = 0))
	public void setVersionDebug(GuiIngame instance, FontRenderer fontRenderer, String s, int x, int y, int colour){

		this.drawString(fontRenderer, "Minecraft Kodofy " + BTAKodo.versionNumber, x, y, colour);

	}

	@Redirect(method = "renderGameOverlay", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiIngame;drawDebugScreenLine(Ljava/lang/String;)V", ordinal = 0))
	public void setVersionDebug(GuiIngame instance, String string){

		this.drawDebugScreenLine("Minecraft Kodofy " + BTAKodo.versionNumber);

	}

	@Redirect(method = "renderGameOverlay", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiIngame;drawString(Lnet/minecraft/client/render/FontRenderer;Ljava/lang/String;III)V", ordinal = 1))
	public void setVersion(GuiIngame instance, FontRenderer fontRenderer, String s, int x, int y, int colour){

		this.drawString(fontRenderer, "", x, y, colour);

	}
}
