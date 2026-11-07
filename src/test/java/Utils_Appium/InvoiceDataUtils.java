package Utils_Appium;

public final class InvoiceDataUtils {
    private InvoiceDataUtils() {
    }

    public static String getAmcInvoiceNumber() {
        return TestDataUtils.get("amcInvoiceNumber");
    }

    public static String getWarrantyInvoiceNumber() {
        return TestDataUtils.get("warrantyInvoiceNumber");
    }
}
