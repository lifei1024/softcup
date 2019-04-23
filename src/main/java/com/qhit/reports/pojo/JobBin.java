package com.qhit.reports.pojo;

public class JobBin {
    String fname;

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    @Override
    public String toString() {
        return "JobBin{" +
                "fname='" + fname + '\'' +
                '}';
    }
}
