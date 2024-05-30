package kodo777.btakodo.mixin;

import net.minecraft.client.option.BooleanOption;
import net.minecraft.client.option.FloatOption;
import net.minecraft.client.option.GameSettings;
import net.minecraft.client.option.KeyBinding;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = GameSettings.class, remap = false)
public class GameSettingsMixin {
	@Shadow
	public BooleanOption biomeWater;
	@Shadow
	public BooleanOption vignette;
	@Shadow
	public BooleanOption versionInOverlay;
	@Shadow
	public FloatOption cloudHeight;
	@Shadow
	public BooleanOption discordRichPresence;
	@Shadow
	public FloatOption autosaveTimer;
	@Shadow
	public BooleanOption alwaysShowDescriptions;


	@Inject(method = "<init>", at = @At("RETURN"))
	public void editDefaultSettings(CallbackInfo info) {
		GameSettings settings = (GameSettings) (Object) this;
		this.biomeWater = new BooleanOption(settings,"biomeWater", false);
		this.vignette = new BooleanOption(settings, "vignette", false);
		this.versionInOverlay = new BooleanOption(settings,"versionInOverlay",true);
		this.cloudHeight = new FloatOption(settings,"cloudHeight", -0.3f);
		this.discordRichPresence = new BooleanOption(settings,"discordRichPresence", true);
		this.autosaveTimer = new FloatOption(settings,"autosaveTimer", 0.51087f);
		this.alwaysShowDescriptions = new BooleanOption(settings, "alwaysShowDescriptions", true);
	}
}
