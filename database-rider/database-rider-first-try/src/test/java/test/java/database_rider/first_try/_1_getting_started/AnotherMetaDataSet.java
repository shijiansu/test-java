package test.java.database_rider.first_try._1_getting_started;

import com.github.database.rider.core.api.dataset.DataSet;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@DataSet(value = "_1_getting_started/user-expected.yml", disableConstraints = true)
public @interface AnotherMetaDataSet {}
