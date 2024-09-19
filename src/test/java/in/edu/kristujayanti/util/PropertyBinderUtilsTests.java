package in.edu.kristujayanti.util;

import in.edu.kristujayanti.propertyBinder.AuthCommonKeysPBinder;
import in.edu.kristujayanti.propertyBinder.KJUSYSPropertyBinder;
import in.edu.kristujayanti.propertyBinder.PropertyBinderUtils;
import org.junit.Assert;
import org.junit.Test;


public class PropertyBinderUtilsTests {
    @Test
    public void getPropertyNameByDisplayNameTest(){
        KJUSYSPropertyBinder testProperty = AuthCommonKeysPBinder.USER_EMAIL;

        String fetchedPropertyName = PropertyBinderUtils.getPropertyNameByDisplayName(testProperty.getDisplayName());

        System.out.println(fetchedPropertyName);

        Assert.assertEquals(testProperty.getPropertyName(), fetchedPropertyName);
    }
}
