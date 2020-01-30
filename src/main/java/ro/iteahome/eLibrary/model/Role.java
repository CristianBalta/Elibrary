package ro.iteahome.eLibrary.model;

public abstract class Role {
    private int roleId;
    private String name;

    Role(int roleId, String name) {
        this.roleId = roleId;
        this.name = name;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void searchBook();
    public abstract void top5Books();
    public abstract void mostReadAuthor();
    public abstract void popularBook(Author author);
}
