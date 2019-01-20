package VadymTahiiev.model;

public class Transmitter {
    public String transmitter;
    public Long bytes;

    public Transmitter(String transmitter, Long bytes) {
        this.transmitter = transmitter;
        this.bytes = bytes;
    }

    public String getTransmitter() {
        return transmitter;
    }

    public void setTransmitter(String transmitter) {
        this.transmitter = transmitter;
    }

    public Long getBytes() {
        return bytes;
    }

    public void setBytes(Long bytes) {
        this.bytes = bytes;
    }

    @Override
    public String toString() {
        return "Transmitter{" +
                "transmitter='" + transmitter + '\'' +
                ", bytes=" + bytes +
                '}';
    }
}
