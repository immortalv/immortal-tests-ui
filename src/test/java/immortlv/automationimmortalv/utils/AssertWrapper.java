package immortlv.automationimmortalv.utils;


import org.assertj.core.api.Assertions;

public class AssertWrapper {


    public static void assertTrue(Boolean condition, String expected, String actual, String verifyInfo) {
        String verifyData = String.format("%s \n EXPECTED:\"%s\" \n ACTUAL:\"%s\"", verifyInfo, expected, actual);
        LoggerWrapper.verifyInfo(verifyData);

        try {
            Assertions.assertThat(condition).isTrue();
        } catch (AssertionError e) {
            throw new VerifyError(verifyData);
        }

    }

}
