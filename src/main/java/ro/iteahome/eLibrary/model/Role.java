package ro.iteahome.eLibrary.model;

import java.io.IOException;

public abstract class Role {
    private int roleId;


    // 1- Admin ; 2 - Reader

    Role(int roleId) {
        this.roleId = roleId;

    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }





    public abstract void topFiveBooks() throws IOException;
    public abstract void topAuthor() throws IOException;
    public abstract void authorPoplarBooks() throws IOException;



}
