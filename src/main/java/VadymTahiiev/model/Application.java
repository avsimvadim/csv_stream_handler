package VadymTahiiev.model;

public class Application implements Model{
    public String application;
    public Long bytes;

    public Application(String application, Long bytes) {
        this.application = application;
        this.bytes = bytes;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public Long getBytes() {
        return bytes;
    }

    public void setBytes(Long bytes) {
        this.bytes = bytes;
    }

    @Override
    public String toString() {
        return "Application{" +
                "application='" + application + '\'' +
                ", bytes=" + bytes +
                '}';
    }
}
