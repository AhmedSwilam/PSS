package com.bartech.pss.sa.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Ahmed on 5/8/2018.
 */

public class LoginRequestt {
    private LoginRequestt() {
        // This class is not publicly instantiable
    }
    public static class ServerLoginRequestt {
        @Expose
        @SerializedName("Username")
        private String Username;

        @Expose
        @SerializedName("Password")
        private String Password;

        @Expose
        @SerializedName("Company")
        private String Company;

        @Expose
        @SerializedName("Branch")
        private String Branch;



        public ServerLoginRequestt(String username, String password, String company, String branch) {
            Username = username;
            this.Password = password;
            Company = company;
            Branch = branch;

        }
    }

}
