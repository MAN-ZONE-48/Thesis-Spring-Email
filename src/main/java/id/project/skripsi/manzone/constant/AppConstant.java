package id.project.skripsi.manzone.constant;

public enum AppConstant {
    STATUS_200("OK"),
    ERROR_500_MESSAGE("There is something wrong in our server: {}"),
    ERROR_400_MESSAGE("It seems you are missing on the parameter/attribute: {}"),
    ERROR_401_MESSAGE("You cannot access this page because you are unauthorized: {}"),
    ERROR_403_MESSAGE("You don't have an access to see this page because it's forbidden: {}"),
    ERROR_404_MESSAGE("The page that you search not found: {}");

    private String message;

    AppConstant(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
