package kodo777.btakodo.mixin;

import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.chunk.ChunkCoordinates;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = EntityPlayer.class, remap = false)
public class EntityPlayerMixin {

	@Shadow
	public ChunkCoordinates bedChunkCoordinates;

	@Shadow
	public String username;

	@Shadow
	public void dropPlayerItemWithRandomChoice(ItemStack itemstack, boolean flag) {

	}

	@Redirect(method = "sleepInBedAt", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/entity/player/EntityPlayer;setPlayerSleeping(III)V"))
	public void redirectSleep(EntityPlayer instance, int x, int y, int z){
		this.bedChunkCoordinates = new ChunkCoordinates(x,y,z);
	}

	@Inject(method = "onDeath", at = @At("HEAD"))
	public void customItemDrop(CallbackInfo info) {
		if (this.username.equals("MaggAndGeez")) {
			this.dropPlayerItemWithRandomChoice(new ItemStack(Item.ammoFireball, 1), true);
		} else if (this.username.equals("jonkadelic")) {
			this.dropPlayerItemWithRandomChoice(new ItemStack(Item.foodCookie, 1), true);
		} else if (this.username.equals("AnActualSign")) {
			this.dropPlayerItemWithRandomChoice(new ItemStack(Item.sign, 1), true);
		} else if (this.username.equals("Asuru")) {
			this.dropPlayerItemWithRandomChoice(new ItemStack(Item.foodApple, 1), true);
		}
	}
}
