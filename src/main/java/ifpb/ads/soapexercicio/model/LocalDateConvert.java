package ifpb.ads.soapexercicio.model;

import java.sql.Date;
import java.time.LocalDate;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Document  LocalDateConvert
 * @Date  10/08/2016 @Time 14:11:11
 * @author Wellington Lins Claudino Duarte   
 * @mail wellingtonlins2013@gmail.com
 */ 

@Converter(autoApply = true)
public class LocalDateConvert implements AttributeConverter<LocalDate, Date>{

    @Override
    public Date convertToDatabaseColumn(LocalDate x) {
        return Date.valueOf(x);
    }

    @Override
    public LocalDate convertToEntityAttribute(Date y) {
        return y.toLocalDate();
    }

}
