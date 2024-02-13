package org.demopans.alternatingflux.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;
import org.demopans.alternatingflux.AlternatingFlux;
import com.

@Mod.EventBusSubscriber(modid = AlternatingFlux.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AFConfig { //todo: just extend the preexisting IE config system :/
  ModConfigBuilder builder = new ModConfigBuilder();

  public final AFWire AFWireConfig;

  public AFConfig(AFWire afWireConfig) {
    super();
    AFWireConfig = afWireConfig;  } //todo: add actual config loader

  public static class AFWire{
    public final int length;
    public final double lossRatio;

    public final int capacity;
    public final double damageRadius;
    public final int transferRate;

    public AFWire(ForgeConfigSpec.Builder builder) {
      this.length = builder.define("length",64).get();
      this.lossRatio = builder.define("loss",0.00025).get();
      this.capacity = builder.define("capacity",2<<18).get();
      this.damageRadius = builder.define("damageRadius",0.1).get();
      this.transferRate = builder.define("transferRate",2<<16).get();

      //this.powerLossForm = builder.define("powerLossForm","(1 - flux^2 * loss / capacity^2)*lengthWire").get(); // figure out how to parse equation into java syntax
    }

    private double powerLossForm(int lengthWire, int flux) {return (1 - flux * flux * lossRatio / capacity*capacity)*lengthWire;}
  }

  public static AFConfig WIRE;
}
