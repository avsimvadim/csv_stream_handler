package VadymTahiiev.model;

public class Protocol implements Model {
    public String protocol;
    public Long bytes;

    public Protocol(String protocol, Long bytes) {
        this.protocol = protocol;
        this.bytes = bytes;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public Long getBytes() {
        return bytes;
    }

    public void setBytes(Long bytes) {
        this.bytes = bytes;
    }

    @Override
    public String toString() {
        return "Protocol{" +
                "protocol='" + protocol + '\'' +
                ", bytes=" + bytes +
                '}';
    }
}
