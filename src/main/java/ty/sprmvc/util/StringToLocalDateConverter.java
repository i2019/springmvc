package ty.sprmvc.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class StringToLocalDateConverter implements Converter<String, Date>{
	
    private String datePattern;

    public StringToLocalDateConverter(String datePattern) {
        this.datePattern = datePattern;
    }
    
	@Override
	public Date convert(String s) {
		SimpleDateFormat sdf = new SimpleDateFormat(datePattern);
		try {
			return sdf.parse(s);
		} catch (ParseException e) {
			 // the error message will be displayed when using <form:errors>
            throw new IllegalArgumentException
            ("invalid date format. Please use this pattern\""+ datePattern + "\"");
		}
	}

}
