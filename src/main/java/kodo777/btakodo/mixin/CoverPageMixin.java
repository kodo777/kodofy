package kodo777.btakodo.mixin;

import kodo777.btakodo.BTAKodo;
import net.minecraft.client.gui.guidebook.GuidebookPage;
import net.minecraft.client.gui.guidebook.GuidebookSection;
import net.minecraft.client.gui.guidebook.cover.CoverPage;
import net.minecraft.client.render.FontRenderer;
import net.minecraft.client.render.RenderEngine;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = CoverPage.class, remap = false)
public abstract class CoverPageMixin extends GuidebookPage {

	public CoverPageMixin(GuidebookSection section) {
		super(section);
	}

	@Redirect(method = "renderForeground", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/guidebook/cover/CoverPage;drawStringCenteredNoShadow(Lnet/minecraft/client/render/FontRenderer;Ljava/lang/String;III)V"))
	public void setVersion(CoverPage instance, FontRenderer fr, String s, int x, int y, int colour){

		this.drawStringCenteredNoShadow(fr, BTAKodo.versionNumber, x, y, colour);

	}
}
