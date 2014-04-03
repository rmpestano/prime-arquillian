/*
 * Copyright 2009-2014 PrimeTek.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.primefaces.metadata;

import java.util.Set;
import javax.el.ELContext;
import javax.el.ValueExpression;
import javax.el.ValueReference;
import javax.faces.context.FacesContext;
import javax.validation.Validator;
import javax.validation.metadata.BeanDescriptor;
import javax.validation.metadata.ConstraintDescriptor;
import javax.validation.metadata.PropertyDescriptor;
import org.primefaces.context.RequestContext;
import org.primefaces.el.ValueExpressionAnalyzer;

public class BeanValidationMetadataExtractor {

    public static Set<ConstraintDescriptor<?>> extract(FacesContext context, RequestContext requestContext, ValueExpression ve) {

        if (ve != null) {
            ELContext elContext = context.getELContext();
            ValueReference vr = ValueExpressionAnalyzer.getReference(elContext, ve);
            
            if (vr != null) {
                Validator validator = requestContext.getApplicationContext().getValidatorFactory().getValidator();
                Object base = vr.getBase();
                Object property = vr.getProperty();
                
                if (base != null && property != null) {
                    BeanDescriptor beanDescriptor = validator.getConstraintsForClass(base.getClass());
                    
                    if (beanDescriptor != null) {
                        PropertyDescriptor propertyDescriptor = beanDescriptor.getConstraintsForProperty(property.toString());

                        if (propertyDescriptor != null) {
                            return propertyDescriptor.getConstraintDescriptors();
                        }
                    }
                }
            }
        }
        
        return null;
    }
}
