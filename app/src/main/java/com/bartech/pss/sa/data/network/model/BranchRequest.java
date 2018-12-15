package com.bartech.pss.sa.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Ahmed on 5/9/2018.
 */

public class BranchRequest {
    private BranchRequest(){

    }

    public static class ServerBranchRequest{

        @Expose
        @SerializedName("CompanyId")
        private String CompanyId;

        public ServerBranchRequest(String companyId) {
            CompanyId = companyId;
        }
    }



}
