/*
 * Copyright (c) 2008, form105 Heiko Kundlacz
 * Licensed under the GNU GPL Version 3. For full terms see the file license.txt
 */
package com.form105.server.web.base;

import com.form105.server.web.base.model.AdressInputModel;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.validation.validator.NumberValidator;

/**
 *
 * @author heiko
 */
public class AddressPage extends TemplatePage {

    public AddressPage() {
        setPageTitle("Adress Page");
        AddressForm form = new AddressForm("addressForm");
        add(form);

        form.add(new Button("saveButton"));
        

    }

    protected class AddressForm extends Form {

        public AddressForm(String name) {
            super(name, new CompoundPropertyModel(new AdressInputModel()));
            RequiredTextField personName = new RequiredTextField("personName");
            personName.setLabel(new Model("personName"));
            add(personName);

            TextField firstName = new TextField("firstName");
            add(firstName);

            TextField street = new TextField("street");
            add(street);

            TextField streetNumber = new TextField("streetNumber");
            add(streetNumber.add(NumberValidator.POSITIVE));


        }

        protected void onSubmit() {
            info("Form.onSubmit executed");
        }
        
    }

}