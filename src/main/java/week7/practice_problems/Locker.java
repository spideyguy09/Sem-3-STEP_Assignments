package week7.practice_problems;

public class Locker {
    private final int lockerNumber;
    private String combinationCode;

    public Locker(int lockerNumber, String initialCode) {
        this.lockerNumber = lockerNumber;
        this.combinationCode = initialCode;
    }

    public void changeCode(String currentCode, String newCode) {
        if (this.combinationCode.equals(currentCode)) {
            this.combinationCode = newCode;
        }
    }

    public int getLockerNumber() {
        return this.lockerNumber;
    }
}
