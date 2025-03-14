package kodo777.btakodo.mixin;

import net.minecraft.client.option.GameSettings;
import net.minecraft.client.option.OptionBoolean;
import net.minecraft.client.option.OptionFloat;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = GameSettings.class, remap = false)
public class GameSettingsMixin {
	@Shadow
	public OptionBoolean biomeWater;
	@Shadow
	public OptionBoolean vignette;
	@Shadow
	public OptionBoolean versionInOverlay;
	@Shadow
	public OptionFloat cloudHeight;
	@Shadow
	public OptionBoolean discordRichPresence;
	@Shadow
	public OptionBoolean alwaysShowDescriptions;
	@Shadow
	public OptionBoolean alphaMenu;

	@Inject(method = "<init>", at = @At("RETURN"))
	public void editDefaultSettings(CallbackInfo info) {
		GameSettings settings = (GameSettings) (Object) this;
		this.biomeWater = new OptionBoolean(settings,"biomeWater", false);
		this.vignette = new OptionBoolean(settings, "vignette", false);
		this.versionInOverlay = new OptionBoolean(settings,"versionInOverlay",true);
		this.cloudHeight = new OptionFloat(settings,"cloudHeight", -0.3f);
		this.discordRichPresence = new OptionBoolean(settings,"discordRichPresence", true);
		this.alwaysShowDescriptions = new OptionBoolean(settings, "alwaysShowDescriptions", true);
		this.alphaMenu = new OptionBoolean(settings, "old", true);
	}
}
