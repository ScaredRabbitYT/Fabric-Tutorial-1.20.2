package net.scaredrabbit.tutorialmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.scaredrabbit.tutorialmod.TutorialMod;
import net.scaredrabbit.tutorialmod.block.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup RUBY_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(TutorialMod.MOD_ID, "tutorial_group"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.amethyst"))
                    .icon(() -> new ItemStack(ModItems.AMETHYST_INGOT)).entries((displayContext, entries) -> {
                        entries.add(ModItems.AMETHYST_INGOT);
                        entries.add(ModBlocks.COPPER_BRICKS);

                    }).build());


    public static void registerItemGroups() {
        TutorialMod.LOGGER.info("Registering Item Groups for " + TutorialMod.MOD_ID);
    }
}