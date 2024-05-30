package kodo777.btakodo.mixin;

import kodo777.btakodo.BTAKodo;
import net.minecraft.client.render.window.GameWindowLWJGL2;
import org.lwjgl.opengl.Display;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = GameWindowLWJGL2.class, remap = false)
public class GameWindowLWJGL2Mixin {

	@Redirect(method = "init", at = @At(value = "INVOKE", target = "Lorg/lwjgl/opengl/Display;setTitle(Ljava/lang/String;)V"))
	public void setTitle(String newTitle){

		Display.setTitle("Minecraft Kodofy " + BTAKodo.versionNumber);

	}


}
