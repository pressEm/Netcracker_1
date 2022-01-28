package validation;

import contracts.Contract;

/**
 * The class checks the fields of the contract class passed as a parameter
 *  @author Valentina Filonova
 */
public class ValidateContract {
    CheckContract checkContract = new CheckContract();

    /**
     * Validates an Internet contract
     * @param contract
     * @return message that contains validation status and errors
     */
    public ValidatorMessage check(Contract contract) {
        ValidatorMessage message = new ValidatorMessage();
        message.setStatus(Status.OK);

        if (!(checkContract.checkId(contract))) {
            message.setStatus(Status.ERROR);
            message.addError("id", "Id can't be negative");
        }

        if (!(checkContract.checkStartDate(contract))) {
            message.setStatus(Status.ERROR);
            message.addError("start", "Start date can`t be after end/current date");

        }

        if (!(checkContract.checkEndDate(contract))) {
            message.setStatus(Status.ERROR);
            message.addError("end", "End date can`t be before start/current date");

        }

        if (!(checkContract.checkNum(contract))) {
            message.setStatus(Status.ERROR);
            message.addError("num", "num can't be negative");

        }

        if (!(checkContract.checkOwner(contract))) {
            message.setStatus(Status.ERROR);
            message.addError("owner", "error in field \"owner\"");

        }
        return message;
    }
}
