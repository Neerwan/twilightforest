// Date: 11/8/2012 9:54:59 AM
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX


package twilightforest.client.model.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import twilightforest.client.BugModelAnimationHelper;
import twilightforest.tileentity.critters.TileEntityTFMoonwormTicking;

import javax.annotation.Nullable;

public class ModelTFMoonworm extends ModelBase {
	//fields
	ModelRenderer Shape1;
	ModelRenderer Shape2;
	ModelRenderer Shape3;
	ModelRenderer head;

	public ModelTFMoonworm() {
		textureWidth = 32;
		textureHeight = 32;

		Shape1 = new ModelRenderer(this, 0, 4);
		Shape1.addBox(-1F, -1F, -1F, 4, 2, 2);
		Shape1.setRotationPoint(-1F, 7F, 3F);

		Shape2 = new ModelRenderer(this, 0, 8);
		Shape2.addBox(-1F, -1F, -1F, 2, 2, 4);
		Shape2.setRotationPoint(3F, 7F, 0F);

		Shape3 = new ModelRenderer(this, 0, 14);
		Shape3.addBox(-1F, -1F, -1F, 2, 2, 2);
		Shape3.setRotationPoint(2F, 7F, -2F);

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-1F, -1F, -1F, 2, 2, 2);
		head.setRotationPoint(-3F, 7F, 2F);
	}

	@Override
	public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entity);
		Shape1.render(scale);
		Shape2.render(scale);
		Shape3.render(scale);
		head.render(scale);
	}

	public void render(float scale) {
		Shape1.render(scale);
		Shape2.render(scale);
		Shape3.render(scale);
		head.render(scale);
	}

	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entity) {
		super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entity);
	}

	public void setLivingAnimations(@Nullable TileEntityTFMoonwormTicking moonworm, float partialTime) {

		head.rotationPointY = 7F;
		Shape1.rotationPointY = 7F;
		Shape2.rotationPointY = 7F;
		Shape3.rotationPointY = 7F;

		if (moonworm != null && moonworm.yawDelay == 0) {
			float time = (moonworm.desiredYaw - moonworm.currentYaw) - partialTime;

			// moving
			head.rotationPointY += Math.min(0, MathHelper.sin(time / 2));
			Shape1.rotationPointY += Math.min(0, MathHelper.sin(time / 2 + 1));
			Shape2.rotationPointY += Math.min(0, MathHelper.sin(time / 2 + 2));
			Shape3.rotationPointY += Math.min(0, MathHelper.sin(time / 2 + 3));
		} else if (moonworm == null && BugModelAnimationHelper.yawWriggleDelay == 0) {
			float time = (BugModelAnimationHelper.desiredRotation - BugModelAnimationHelper.currentRotation) - partialTime;

			// moving
			head.rotationPointY += Math.min(0, MathHelper.sin(time / 2));
			Shape1.rotationPointY += Math.min(0, MathHelper.sin(time / 2 + 1));
			Shape2.rotationPointY += Math.min(0, MathHelper.sin(time / 2 + 2));
			Shape3.rotationPointY += Math.min(0, MathHelper.sin(time / 2 + 3));
		}
	}
}
