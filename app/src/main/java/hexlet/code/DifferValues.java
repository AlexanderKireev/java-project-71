package hexlet.code;

public class DifferValues {
    private final String status;
    private final Object value1;
    private final Object value2;

    DifferValues(String pStatus, Object pValue1, Object pValue2) {
        this.status = pStatus;
        this.value1 = pValue1;
        this.value2 = pValue2;
    }
    DifferValues(String pStatus, Object pValue) {
        this.status = pStatus;
        this.value1 = pValue;
        this.value2 = pValue;
    }

    public final String getStatus() {
        return status;
    }

    public final Object getValue1() {
        return value1;
    }

    public final Object getValue2() {
        return value2;
    }
}
