package equant;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class ValCurs {
    @JacksonXmlElementWrapper(localName = "ValCurs", useWrapping = false)
    @JacksonXmlProperty(localName = "Valute")
    List<Valute> ValCurs = new ArrayList<>();

    @JacksonXmlProperty(localName = "Date" ,isAttribute = true)
    String Date;

    @JacksonXmlProperty(localName = "Name", isAttribute = true)
    String Name;


}
