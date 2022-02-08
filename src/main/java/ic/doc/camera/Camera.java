package ic.doc.camera;
import java.util.Random;

public class Camera{

  private final Sensor sensor;
  private final MemoryCard memoryCard;
  boolean cameraOn = false;

  public void pressShutter() {
    if(!cameraOn){
      return;
    }

    memoryCard.write(sensor.readData());

    // not implemented
  }

  public void powerOn() {
    cameraOn = true;
    sensor.powerUp();
    // not implemented
  }

  public void powerOff() {
    cameraOn = false;
    sensor.powerDown();
    // not implemented
  }

  public Camera(Sensor sensor, MemoryCard memoryCard){
    this.sensor = sensor;
    this.memoryCard = memoryCard;
  }
}
