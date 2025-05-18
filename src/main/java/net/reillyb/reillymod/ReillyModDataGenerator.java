package net.reillyb.reillymod;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;

public class ReillyModDataGenerator implements DataGeneratorEntrypoint {
//	private static class MyRecipeGenerator extends FabricRecipeProvider {
//		private MyRecipeGenerator(FabricDataOutput generator) {
//			super(generator);
//		}
//
//		@Override
//		protected void generateRecipes(Consumer<RecipeJsonProvider> exporter)
//
//	}



	@Override
	public void onInitializeDataGenerator(FabricDataGenerator generator) {
		FabricDataGenerator.Pack pack = generator.createPack();
		pack.addProvider(ReillyModRecipeGenerator::new);
	}

}

