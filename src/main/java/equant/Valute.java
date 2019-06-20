package equant;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class Valute {

    @JacksonXmlProperty(localName = "ID")
    private String ID;
    @JacksonXmlProperty(localName = "NumCode")
    private Integer NumCode;
    @JacksonXmlProperty(localName = "CharCode")
    private String CharCode;
    @JacksonXmlProperty(localName = "Nominal")
    private Integer Nominal;
    @JacksonXmlProperty(localName = "Name")
    private String Name;
    @JacksonXmlProperty(localName = "Value")
    private String value;
}

