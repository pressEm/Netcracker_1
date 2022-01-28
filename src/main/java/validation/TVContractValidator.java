package validation;

import contracts.Contract;
import contracts.TVContract;

/**
 * Class validate TV contract
 * @author Valentina Filonova
 */
public class TVContractValidator extends ValidateContract{
    /**
     * Validates an TV contract
     * @param c
     * @return message that contains validation status and errors
     */
    public ValidatorMessage validate(Contract c) {
        TVContract contract = (TVContract) c;
        CheckContract checkContract = new CheckContract();
        ValidatorMessage message = this.check(contract);
        if (!checkContract.checkTVChannels(contract)){
            message.setStatus(Status.ERROR);
            message.addError("speed", "speed can't be negative");
        }
        return message;
    }
}
