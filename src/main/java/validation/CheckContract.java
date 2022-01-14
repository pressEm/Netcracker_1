package validation;

import contracts.*;

import java.time.LocalDate;

public class CheckContract {


    public boolean checkId(Contract contract) {
        if (contract.getID() >= 0) {
            return true;
        } else return false;
    }

    public boolean checkStartDate(Contract contract) {
        if (contract.getStart() instanceof LocalDate &&
                (contract.getStart().isBefore(LocalDate.now())) &&
                (contract.getStart().isBefore(contract.getEnd()))) {
            return true;
        } else return false;
    }

    public boolean checkEndDate(Contract contract) {
        if (contract.getEnd() instanceof LocalDate &&
                !(contract.getEnd().isBefore(LocalDate.now())) &&
                !(contract.getEnd().isBefore(contract.getStart()))) {
            return true;
        } else return false;
    }

    public boolean checkNum(Contract contract) {
        if (contract.getNum() >= 0) {
            return true;
        } else return false;
    }

//

    public boolean checkOwner(Contract contract) {
        if (contract.getOwner() instanceof Person) {
            return true;
        } else return false;
    }

    public boolean checkSpeed(InternetContract contract) {
        if (contract.getConnectionSpeed() >= 0) {
            return true;
        } else return false;
    }

    public boolean checkMinutes(MobileContract contract) {
        if (contract.getMinutes() >= 0) {
            return true;
        } else return false;
    }

    public boolean checkSms(MobileContract contract) {
        if (contract.getSms() >= 0) {
            return true;
        } else return false;
    }
    public boolean checkGb(MobileContract contract) {
        if (contract.getGb() >= 0) {
            return true;
        } else return false;
    }

    public boolean checkTVChannels(TVContract contract) {
        for (Object o : contract.getChannels()
        ) {
            if (!(o instanceof Channels)) {
                return false;
            }
        }
        return true;
    }
}