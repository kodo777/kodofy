package kodo777.btakodo.mixin;

import net.minecraft.core.entity.player.Player;
import net.minecraft.core.item.Items;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.chunk.ChunkCoordinates;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = Player.class, remap = false)
public class PlayerMixin {

	@Shadow
	public ChunkCoordinates bedChunkCoordinates;

	@Shadow
	public String username;

	@Shadow
	public void dropPlayerItemWithRandomChoice(ItemStack itemstack, boolean flag) {

	}

	@Redirect(method = "sleepInBedAt", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/entity/player/Player;setPlayerSleeping(III)V"))
	public void redirectSleep(Player instance, int x, int y, int z){
		this.bedChunkCoordinates = new ChunkCoordinates(x,y,z);
	}

	@Inject(method = "onDeath", at = @At("HEAD"))
	public void customItemDrop(CallbackInfo info) {
		switch (this.username) {
			case "MaggAndGeez":
				this.dropPlayerItemWithRandomChoice(new ItemStack(Items.AMMO_CHARGE_EXPLOSIVE, 1), true);
				break;
			case "jonkadelic":
				this.dropPlayerItemWithRandomChoice(new ItemStack(Items.FOOD_COOKIE, 1), true);
				break;
			case "AnActualSign":
				this.dropPlayerItemWithRandomChoice(new ItemStack(Items.SIGN, 1), true);
				break;
			case "Asuru":
				this.dropPlayerItemWithRandomChoice(new ItemStack(Items.FOOD_APPLE, 1), true);
				break;
		}
	}
}
