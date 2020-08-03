package com.meifute.restructure.mmauth.config.token;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;

import java.io.Serializable;


/**
 * create by liuliang
 * on 2020-04-05  14:38
 * 客户端应用信息
 */
@Data
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class DefaultClientDetails extends BaseClientDetails implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -4996423520248249518L;
    //限流标识
    private long if_limit;
    //限流次数
    private long limit_count;


    public DefaultClientDetails(String clientId, String resourceIds, String scopes,
                                String grantTypes, String authorities, String redirectUris) {
        super(clientId, resourceIds, scopes, grantTypes, authorities, redirectUris);
    }


}
