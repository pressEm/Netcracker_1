package validation;

import contracts.Contract;
import contracts.MobileContract;

/**
 * Class validate Mobile contract
 * @author Valentina Filonova
 */
public class MobileContractValidtor extends ValidateContract{
    /**
     * Validates an Mobile contract
     * @param c
     * @return message that contains validation status and errors
     */
    public ValidatorMessage validate(Contract c) {
        MobileContract contract = (MobileContract) c;
        CheckContract checkContract = new CheckContract();
        ValidatorMessage message = this.check(contract);
        if (!checkContract.checkMinutes(contract)){
            message.setStatus(Status.ERROR);
            message.addError("minutes", "minutes can't be negative");
        }
        if (!checkContract.checkMinutes(contract)){
            message.setStatus(Status.ERROR);
            message.addError("sms", "sms can't be negative");
        }
        if (!checkContract.checkMinutes(contract)){
            message.setStatus(Status.ERROR);
            message.addError("gb", "gb can't be negative");
        }
        return message;
    }

}
