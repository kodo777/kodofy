package kodo777.btakodo.mixin;

import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.core.lang.I18n;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = GuiMainMenu.class, remap = false)
public class GuiMainMenuMixin extends GuiScreen {

	@Inject(method = "drawBackground()V", at =@At(value = "HEAD"), cancellable = true)
	public void forceBG(CallbackInfo ci){
		super.drawBackground();
		ci.cancel();
	}

	@Redirect(method = "drawScreen", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/lang/I18n;translateKey(Ljava/lang/String;)Ljava/lang/String;", ordinal = 0))
	public String copyrightText(I18n instance, String s){
		return "";
	}

	@Redirect(method = "drawScreen", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/lang/I18n;translateKey(Ljava/lang/String;)Ljava/lang/String;", ordinal = 1))
	public String copyrightText2(I18n instance, String s){
		return instance.translateKey("btakodo.gui.disclaimer.1");
	}

}
