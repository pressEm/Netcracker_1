package validation;

import contracts.Contract;
import contracts.TVContract;

public class TVContractValidator extends ValidateContract{

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
