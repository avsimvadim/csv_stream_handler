package VadymTahiiev.model;

public class Receiver implements Model {
    public String receiver;
    public Long bytes;

    public Receiver(String receiver, Long bytes) {
        this.receiver = receiver;
        this.bytes = bytes;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public Long getBytes() {
        return bytes;
    }

    public void setBytes(Long bytes) {
        this.bytes = bytes;
    }

    @Override
    public String toString() {
        return "Receiver{" +
                "receiver='" + receiver + '\'' +
                ", bytes=" + bytes +
                '}';
    }
}
