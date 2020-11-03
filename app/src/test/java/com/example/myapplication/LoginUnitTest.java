package com.example.myapplication;

import android.content.Context;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class LoginUnitTest {

    private static final String FAKE_STRING = "Login was successful";

    @Mock
    Context mMockContext;

    @Test
    public void readStringFromContext_LocalizedString() {

        LoginActivity myObjectUnderTest = new LoginActivity(mMockContext);

        // ...when the string is returned from the object under test...
        String result = myObjectUnderTest.validate("admin","admin");

        // ...then the result should be the expected one.
        assertThat(result, is(FAKE_STRING));
    }

    @Test
    public void checkUsernameIsValidEmail_validInput() {
        LoginActivity testObj = new LoginActivity(mMockContext);

        boolean result = testObj.validateUsername("kbaza065@uottawa.ca");

        assertThat(result, is(true));
    }

    @Test
    public void checkUsernameIsValidEmail_invalidInput() {
        LoginActivity testObj = new LoginActivity(mMockContext);

        boolean result = testObj.validateUsername("kbaza065@uottawa");

        assertThat(result, is(false));

    }
}
