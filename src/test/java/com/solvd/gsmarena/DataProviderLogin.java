package com.solvd.gsmarena;

import org.testng.annotations.DataProvider;
public class DataProviderLogin {
    @DataProvider (name = "login-class-data-provider")
    public Object[][] getTestDataAndErrorMessages() {
        return new Object[][]{
                {"", "", "Please fill out this field.", "Please fill out this field.", "false"},
                {"wrong@gmail.com", "", "", "Please fill out this field.", "false"},
                {"", "bcshbcddd", "Please fill out this field.", "", "false"},
                {"vc55vghfdv@gmail.com", "efwecwec", "", "", "true"},
                {"vcvghfcvddvgmail.com", "myPassword7", String.format("Please include an '@' in the email address. '%s' is missing an '@'.", "vcvghfcvddvgmail.com"), "", "false"},
                {"semtestsem029@gmail.com", "djc", "", "Please match the requested format.", "false"},
                {"fdssvghfdv@gmail.com", "myPassword7", "", "", "true"}
        };
    }
}

