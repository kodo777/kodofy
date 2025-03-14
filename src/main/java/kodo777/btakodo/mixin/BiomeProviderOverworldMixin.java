package kodo777.btakodo.mixin;

import net.minecraft.core.world.biome.Biome;
import net.minecraft.core.world.biome.Biomes;
import net.minecraft.core.world.biome.provider.BiomeProviderOverworld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = BiomeProviderOverworld.class, remap = false)
public abstract class BiomeProviderOverworldMixin {

	@Inject(method = "lookupBiome", at = @At("RETURN"), cancellable = true)
	private void onLookupBiome(double temperature, double humidity, double variety, double altitude, CallbackInfoReturnable<Biome> cir) {
		Biome biome = cir.getReturnValue();

		if (biome == Biomes.OVERWORLD_OUTBACK || biome == Biomes.OVERWORLD_OUTBACK_GRASSY) {
			cir.setReturnValue(Biomes.OVERWORLD_DESERT);
		}
		else if (biome == Biomes.OVERWORLD_CAATINGA || biome == Biomes.OVERWORLD_CAATINGA_PLAINS) {
			cir.setReturnValue(Biomes.OVERWORLD_GRASSLANDS);
		}
		else if (biome == Biomes.OVERWORLD_SWAMPLAND) {
			cir.setReturnValue(Biomes.OVERWORLD_FOREST);
		}
	}
}
