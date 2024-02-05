package org.demopans.alternatingflux.wire;


import blusunrize.immersiveengineering.api.wires.Connection;
import blusunrize.immersiveengineering.api.wires.WireType;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class AFWireType extends WireType {
  /**
   * Constants
   */
  public static final String WIRE_NAME = "AF";

  @Override
  public String getUniqueName() {
    return WIRE_NAME; // check source at AFWireType:20
  }

  @Override
  public int getColour(Connection connection) {
    return 0;
  }

  @Override
  public double getSlack() {
    return 0;
  }

  @Override
  public int getMaxLength() {
    return 0;
  }

  @Override
  public ItemStack getWireCoil(Connection connection) {
    return null;
  }

  @Override
  public double getRenderDiameter() {
    return 0.078125;
  }

  @NotNull
  @Override
  public String getCategory() {
    return null;
  }
}
