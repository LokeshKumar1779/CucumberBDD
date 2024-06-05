package awesomecucumber.customtype;

import awesomecucumber.domainobjects.BillingDetails;
import awesomecucumber.domainobjects.PersonalDetails;
import awesomecucumber.domainobjects.Product;
import io.cucumber.java.DataTableType;

import java.util.Map;

public class CustomDataTableType {

    @DataTableType
    public PersonalDetails personalDetailsEntry(Map<String,String> entry){
        return new PersonalDetails(entry.get("firstname"), entry.get("lastname"), entry.get("email") );
    }

    @DataTableType
    public BillingDetails billingDetailsEntry(Map<String,String> entry){
        return new BillingDetails(entry.get("addressLine1"), entry.get("city"), entry.get("state") ,entry.get("zipcode"));
    }

    @DataTableType
    public Product productEntry(Map<String,String> entry){
        return new Product(entry.get("name"));
    }
}
