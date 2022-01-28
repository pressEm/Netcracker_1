package validation;

import java.util.HashMap;
import java.util.Map;

/**
 * Class describes the result of validating a single contract: status(OK, ERROR), Errors
 * @author Valentina Filonova
 */
public class ValidatorMessage {
    private Status status;
    private Map<String, String> errors = new HashMap<>();

    public void setStatus(Status status) {
        this.status = status;
    }

    public void addError(String variableName, String  error){
        this.errors.put(variableName, error);
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "ValidatorReport{" +
                "status='" + status + '\'' +
                ", errorDescription: " + errors+
                '}';
    }
}