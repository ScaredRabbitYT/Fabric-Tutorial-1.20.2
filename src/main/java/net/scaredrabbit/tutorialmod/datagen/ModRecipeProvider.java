package net.scaredrabbit.tutorialmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;
import net.scaredrabbit.tutorialmod.block.ModBlocks;
import net.scaredrabbit.tutorialmod.item.ModItems;

import java.util.List;

public class ModRecipeProvider extends FabricRecipeProvider {
    private static final List<ItemConvertible> AMETHYST_SMELTABLES = List.of(ModItems.AMETHYST_INGOT);
    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        offerSmelting(exporter, AMETHYST_SMELTABLES , RecipeCategory.MISC, Items.AMETHYST_SHARD,
                0.7f, 150, "amethyst");
        offerBlasting(exporter, AMETHYST_SMELTABLES , RecipeCategory.MISC, Items.AMETHYST_SHARD,
                1.4f, 75, "amethyst");

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.COPPER_BRICKS, 9)
                .pattern("CCC")
                .pattern("CCC")
                .pattern("CCC")
                .input('C', Items.COPPER_BLOCK)
                .criterion(hasItem(Items.COPPER_BLOCK),conditionsFromItem(Items.COPPER_BLOCK))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.COPPER_BRICKS)));
    }
}
