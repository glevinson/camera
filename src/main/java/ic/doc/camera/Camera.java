package ic.doc.camera;

public class Camera implements WriteListener {

    private final Sensor sensor;
    private final MemoryCard memoryCard;
    boolean cameraOn = false;
    boolean memoryWritingOn = false;

    public void pressShutter() {
        if (!cameraOn) {
            return;
        }

        memoryWritingOn = true;
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
        if (memoryWritingOn) {
            return;
        }
        sensor.powerDown();
        // not implemented
    }

    public Camera(Sensor sensor, MemoryCard memoryCard) {
        this.sensor = sensor;
        this.memoryCard = memoryCard;
    }

    @Override
    public void writeComplete() {
        memoryWritingOn = false;
        if (!cameraOn) {
            sensor.powerDown();
        }
    }
}