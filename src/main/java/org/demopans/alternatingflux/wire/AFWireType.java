package org.demopans.alternatingflux.wire;

// remember to run gradle reload in IDE to make red text go away
import blusunrize.immersiveengineering.api.tool.IElectricEquipment;
import blusunrize.immersiveengineering.api.wires.Connection;
import blusunrize.immersiveengineering.api.wires.WireType;
import blusunrize.immersiveengineering.api.wires.localhandlers.WireDamageHandler;
import net.minecraft.world.item.ItemStack;
import org.demopans.alternatingflux.AlternatingFlux;
import org.jetbrains.annotations.NotNull;
import org.demopans.alternatingflux.config.AFConfig;

public class AFWireType extends WireType implements WireDamageHandler.IShockingWire {
  /**
   * Constants
   */
  public static final String WIRE_NAME = "AF"; public static final double DAMAGE_RADIUS = 0.05;

  @Override
  public String getUniqueName() {
    return WIRE_NAME; // check source at the other AFWireType:20
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
  public ItemStack getWireCoil(Connection connection) {return new ItemStack(AlternatingFlux.item_coil, 1, ordinal);} //todo: add the item

  @Override
  public double getRenderDiameter() {
    return 0.078125;
  }

  @NotNull
  @Override
  public String getCategory() { return WIRE_NAME; }

  @Override
  public double getDamageRadius() { return DAMAGE_RADIUS; }

  @Override
  public IElectricEquipment.ElectricSource getElectricSource() {
    return null;
  }

  @Override
  public int getTransferRate() {
    return 0;
  }

  @Override
  public double getBasicLossRate(Connection c) {
    return getLossRatio()*c.getLength()/getMaxLength();
  }

  @Override
  public double getLossRate(Connection c, int transferred) {
    return 0;
  }
}
