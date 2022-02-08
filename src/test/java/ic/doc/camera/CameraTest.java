package ic.doc.camera;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

public class CameraTest {

  @Rule
  public JUnitRuleMockery context = new JUnitRuleMockery();

  Sensor sensor = context.mock(Sensor.class);
  MemoryCard memoryCard = context.mock(MemoryCard.class);

  Camera camera = new Camera(sensor, memoryCard);


  @Test
  public void switchingTheCameraOnPowersUpTheSensor() {
    context.checking(new Expectations() {{
      exactly(1).of(sensor).powerUp();
    }});

    // write your test here
    camera.powerOn();
  }

  @Test
  public void switchingTheCameraOffPowersDownTheSensor() {
    context.checking(new Expectations() {{
      exactly(1).of(sensor).powerDown();
    }});

    // write your test here
    camera.powerOff();
  }

  @Test
  public void pressingShutterWhenPowerIsOffDoesNothing() {
    context.checking(new Expectations() {{
      never(sensor);
    }});

    // write your test here
    camera.pressShutter();
  }

  @Test
  public void pressingShutterWhenPowerIsOnCopiesDataFromSensorToMemoryCard() {

    byte[] data = new byte[0];

    context.checking(new Expectations() {{
      exactly(1).of(sensor).powerUp();
      exactly(1).of(sensor).readData();
      will(returnValue(data));
      exactly(1).of(memoryCard).write(data);
    }});

    // write your test here
    camera.powerOn();
    camera.pressShutter();
  }

}