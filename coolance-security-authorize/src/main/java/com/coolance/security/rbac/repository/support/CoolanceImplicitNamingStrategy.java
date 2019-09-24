/**
 *
 */
package com.coolance.security.rbac.repository.support;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.spi.MetadataBuildingContext;

/**
 * @ClassName CoolanceImplicitNamingStrategy
 * @Description jpa表名策略
 * @Author Coolance
 * @Version
 * @Date 2019/9/13 14:27
 */
public class CoolanceImplicitNamingStrategy extends ImplicitNamingStrategyJpaCompliantImpl {

    /**
     *
     */
    private static final long serialVersionUID = 769122522217805485L;

    @Override
    protected Identifier toIdentifier(String stringForm, MetadataBuildingContext buildingContext) {
        return super.toIdentifier("coolance_" + stringForm.toLowerCase(), buildingContext);
    }

}
