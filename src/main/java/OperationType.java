public enum OperationType {
    DEPOSIT("Deposit"), WITHDRAWAL("Withdrawal");

    private String label;

    OperationType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

}
