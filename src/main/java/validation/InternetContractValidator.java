package validation;

import contracts.Contract;
import contracts.InternetContract;

/**
 * Class validate Internet contract
 * @author Valentina Filonova
 */
public class InternetContractValidator extends ValidateContract implements IValidator {

    /**
     * Validates an Internet contract
     * @param c
     * @return message that contains validation status and errors
     */
    public ValidatorMessage validate(Contract c) {
        InternetContract contract = (InternetContract) c;
        CheckContract checkContract = new CheckContract();
        ValidatorMessage message = this.check(contract);
        if (!checkContract.checkSpeed(contract)){
            message.setStatus(Status.ERROR);
            message.addError("speed", "speed can't be negative");
        }
        return message;
    }
}
