package com.tacz.guns.compat.playeranimator.animation;

import dev.kosmx.playerAnim.api.layered.modifier.AdjustmentModifier;
import dev.kosmx.playerAnim.core.util.Vec3f;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;

import java.util.Optional;
import java.util.function.Function;

public class AdjustmentYRotModifier implements Function<String, Optional<AdjustmentModifier.PartModifier>> {
    private final Player player;

    private AdjustmentYRotModifier(Player player) {
        this.player = player;
    }

    @Override
    public Optional<AdjustmentModifier.PartModifier> apply(String partName) {
        if (player.getVehicle() != null && "body".equals(partName)) {
            return Optional.empty();
        }

        float yaw = player.yHeadRot - player.yBodyRot;
        yaw = Mth.wrapDegrees(yaw);
        yaw = Mth.clamp(yaw, -85f, 85f);

        float pitch = player.getXRot();
        pitch = Mth.wrapDegrees(pitch);

        return switch (partName) {
            case "body" -> Optional.of(new AdjustmentModifier.PartModifier(new Vec3f(0, -yaw * Mth.DEG_TO_RAD, 0), Vec3f.ZERO));
            case "head", "leftArm", "rightArm" -> Optional.of(new AdjustmentModifier.PartModifier(new Vec3f(pitch * Mth.DEG_TO_RAD, 0, 0), Vec3f.ZERO));
            default -> Optional.empty();
        };
    }

    public static AdjustmentModifier getModifier(Player player) {
        return new AdjustmentModifier(new AdjustmentYRotModifier(player));
    }
}