package ic.doc.camera;

public class Camera{

  private final Sensor sensor;
  boolean cameraOn = false;

  public Camera(Sensor sensor) {
    this.sensor = sensor;
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

}

