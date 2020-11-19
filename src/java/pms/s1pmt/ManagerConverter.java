package pms.s1pmt;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.ConverterException;
import pms.s2pmr.PropertyManager;


@FacesConverter(value = "managerConverter")
public class ManagerConverter implements Converter {
    
    @EJB
    private ManagerConverter managerConverter;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }

        try {
            return value;
        } catch (NumberFormatException e) {
            throw new ConverterException(new FacesMessage(String.format("%s is not a valid User ID", value)), e);
        }
    }

    @Override
    public String getAsString(FacesContext ctx, UIComponent component, Object value) {
        if (value == null) {
            return "";
        }

        if (value instanceof PropertyManager) {
            return String.valueOf(((PropertyManager) value).getPmid());
        } else {
            throw new ConverterException(new FacesMessage(String.format("%s is not a valid User", value)));
        }
    }
}