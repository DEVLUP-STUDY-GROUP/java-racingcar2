package step4;

public interface InputView {
    String getCarNumberPrompt();
    String getAttemptCountPrompt();
    int getNextInt();
    String[] getNextCarNames();
}
