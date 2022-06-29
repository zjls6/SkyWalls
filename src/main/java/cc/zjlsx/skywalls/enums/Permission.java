package cc.zjlsx.skywalls.enums;

public enum Permission {

    Admin("admin"),
    Join("join"),
    None("");

    private final String permission;

    Permission(String permission) {
        this.permission = "skywalls." + permission;
    }

    public String getPermission() {
        return permission;
    }
}
